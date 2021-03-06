package task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        int[][][] matrix = new int[][][]{
                {{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{1,0,0,0,0,0,1},{1,0,0,0,0,0,1},{1,0,0,0,0,0,1},{0,1,0,0,0,1,0},{0,0,1,1,1,0,0}},
                {{0,0,0,1,0,0,0},{0,0,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,1,1,1,0,0}},
                {{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{0,1,0,0,1,0,0},{0,0,0,1,0,0,0},{0,0,1,0,0,0,0},{0,1,0,0,0,0,0},{0,1,1,1,1,1,0}},
                {{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{0,0,0,0,1,0,0},{0,0,0,1,0,0,0},{0,0,0,0,1,0,0},{0,1,0,0,0,1,0},{0,0,1,1,1,0,0}},
                {{0,0,0,1,0,0,0},{0,0,1,1,0,0,0},{0,1,0,1,0,0,0},{1,0,0,1,0,0,0},{1,1,1,1,1,1,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0}},
                {{0,1,1,1,1,1,0},{0,1,0,0,0,0,0},{0,1,1,1,0,0,0},{0,0,0,0,1,0,0},{0,0,0,0,0,1,0},{0,0,0,0,1,0,0},{0,1,1,1,0,0,0}},
                {{0,0,0,0,1,0,0},{0,0,0,1,0,0,0},{0,0,1,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,0,1,0},{0,1,0,0,0,1,0},{0,0,1,1,1,0,0}},
                {{0,1,1,1,1,1,0},{0,0,0,0,0,1,0},{0,0,0,0,1,0,0},{0,0,0,1,0,0,0},{0,0,1,0,0,0,0},{0,1,0,0,0,0,0},{0,1,0,0,0,0,0}},
                {{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{0,1,0,0,0,1,0},{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{0,1,0,0,0,1,0},{0,0,1,1,1,0,0}},
                {{0,0,1,1,1,0,0},{0,1,0,0,0,1,0},{0,1,0,0,0,1,0},{0,0,1,1,1,1,0},{0,0,0,0,0,1,0},{0,0,0,0,1,0,0},{0,0,1,1,0,0,0}}};

        System.out.println("Enter a number");
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for(int i=0;i<input.length();i++){
            /*строка разбивается на отдельные символы, идёт попытка преобразовать каждый символ
            в int, при успехе цифра добавляется в массив цифр
             */
            char[] inChar = input.toCharArray();
            int newDigit;
            try{
                newDigit = Integer.parseInt(String.valueOf(inChar[i]));
                numbers.add(newDigit);
            }
            catch (Exception e){
                newDigit = 0;
            }
            if(newDigit>max) max=newDigit;
        }

        print(numbers,max,matrix);
    }

    static void print(ArrayList<Integer> numbers, int max, int[][][] matrix){
        /*
        каждая цифра представлена как матрица 7х7 из 0 и 1. Результат печатается по строке,
        состоящей из "кусков" длины 7, соответствующей отдельной цифре. Если ячейка матрицы
        равна 1, печатается *, если 0 - пробел
         */
        for(int i=0;i<7;i++){
            for (Integer number : numbers) {
                for (int k = 0; k < 7; k++) {
                    if(number==max){//самая большая цифра будет состоять из соответствующих цифр
                        if (matrix[number][i][k] == 1) System.out.print(number);
                        else System.out.print(' ');
                    }
                    else {
                        if (matrix[number][i][k] == 1) System.out.print('*');
                        else System.out.print(' ');
                    }

                }
            }
            System.out.print('\n');
        }
    }
}
