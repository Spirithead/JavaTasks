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
            /*строка разбивается на отдельные символы, идёт попытка преобразовать каждый символ
            в int, при успехе цифра прибавляется к сумме цифр
             */
            char[] inChar = in.toCharArray();
            int newDigit = 0;
            try{
                newDigit = Integer.parseInt(String.valueOf(inChar[i]));
            }
            catch (Exception e){
                newDigit = 0;
            }
            finally {
                result+=newDigit;
            }
        }
        return result;
    }
}
