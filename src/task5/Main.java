package task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Enter items: [name] [weight] [value]...");
        /*в строку вводятся предметы в формате [имя] [вес] [ценность]
        например: silver 1 2 gold 4 10 bronze 1 1 cobalt 2 2
         */
        String input = scannerIn.nextLine();

        System.out.println("Enter safe capability");
        int capability = scannerIn.nextInt();
        Scanner scannerLine=new Scanner(input);
        Safe maxSafe;

        ArrayList<Item> items = new ArrayList<>();
        //введённые предметы собираются в массив предметов
        while(scannerLine.hasNext()){
            items.add(new Item(scannerLine.next(), scannerLine.nextInt(), scannerLine.nextInt()));
        }

        Safe[][] matrix = new Safe[items.size()+1][capability+1];
        /*
        Алгоритм построен по принципу динамического программирования, где большая задача
        решается посредством решения цепочки более мелких задач.
        создаётся таблица, где строки - кол-во предметов от 0 до макс. кол-ва предметов,
        столбцы - вариации сейфов с вместительностю от 0 до макс. веса. Ячейки таблицы -
        варианты наилучшего заполнения определённого сейфа определёнными предметами.
         */
        for(int i=0;i<=items.size();i++){
            for(int j=0;j<=capability;j++){
                /*каждую строку добавляется конкретный предмет в сейф с новым весом в новом столбце
                в этом примере в строке 1 добавляется серебро, во 2 - золото и т.д.
                 */
                if(i==0||j==0) matrix[i][j]=new Safe(new ArrayList<>(),0,0);
                //нулевые строки и столбцы заполняются сейфами с нулевой ценностью
                else{
                    if(items.get(i-1).getWeight()<=j){//если один предмет помещается в пустой сейф текущей вместимости
                        int newWeight = items.get(i-1).getWeight()+matrix[i][j-items.get(i-1).getWeight()].getCurrWeight();
                        int newValue = items.get(i-1).getValue()+matrix[i][j-items.get(i-1).getWeight()].getCurrValue();
                    /*вычисляются вес и ценность сейфа, которые он предположительно будет иметь
                    при копировании содержимого сейфа c вместимостью = (текущий вес - вес предмета) той же строки
                    и добавлении ещё одного предмета
                     */
                        if((newWeight<=j)){//если новое содержимое помещается...
                            if(newValue>matrix[i-1][j].getCurrValue()) {/*и ценность выше, чем у сейфа ячейкой выше в том же столбце,
                            копируется содержимое сейфа c вместимостью = (текущий вес - вес предмета) той же строки
                            и добавляется предмет
                            */
                                matrix[i][j] = new Safe(matrix[i][j-items.get(i-1).getWeight()].getContent(), matrix[i][j-items.get(i-1).getWeight()].getCurrWeight(), matrix[i][j-items.get(i-1).getWeight()].getCurrValue());
                                matrix[i][j].addItem(items.get(i-1));
                            }
                            else matrix[i][j] = new Safe(matrix[i-1][j].getContent(), matrix[i-1][j].getCurrWeight(), matrix[i-1][j].getCurrValue());
                            //иначе копируется содержимое сейфа ячейкой выше того же столбца
                        }
                        else{
                            matrix[i][j]=new Safe(matrix[i][j - 1].getContent(), matrix[i][j - 1].getCurrWeight(), matrix[i][j - 1].getCurrValue());
                            //если новое содержимое не помещается, копируется содержимое сейфа предыдущей ячейки той же строки
                        }
                    }
                    else matrix[i][j] = new Safe(matrix[i-1][j].getContent(), matrix[i-1][j].getCurrWeight(), matrix[i-1][j].getCurrValue());

                }
            }
        }

        maxSafe=matrix[items.size()][capability];//Ответ на задачу находится в последней ячейке последней строки
        System.out.println(maxSafe);
    }
}
