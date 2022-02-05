package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a sequence of digits");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(sum(input));
    }

    static int sum(String in){
        int result = 0;
        for(int i=0;i<in.length();i++){
            /*строка разбивается на отдельные символы, создаются отдельные объекты Scanner,
            в качестве потока принимающие эти символы. Если входной символ был цифрой, она прибавляется
            к результату - сумме цифр в строке
             */
            Scanner scanner = new Scanner(String.valueOf(in.charAt(i)));
            if(scanner.hasNextInt()) result+=scanner.nextInt();
        }
        return result;
    }
}
