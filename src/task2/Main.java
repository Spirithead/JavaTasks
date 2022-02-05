package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter an integer");
        Scanner scanner = new Scanner(System.in);
        //если введено не целое число, выведется сообщение об ошибке
        if(!scanner.hasNextInt()) System.out.println("There must be an integer");
        else multipliers(scanner.nextInt(),true);
    }

    static void multipliers(int number, boolean isInitial){
        number=Math.abs(number);
        //если входное число 0 или 1, выводится это же число
        if((number<2)&&isInitial) System.out.println(number);
        else{
            /*
            рекурсия: подбирается наименьший множитель числа, затем вызывается
            эта же функция с числом на входе, поделённым на найденный множитель
             */
            for(int i=2;i<=number;i++){
                if(number%i==0){
                    isInitial=false;
                    System.out.print(i+" ");
                    multipliers(number/i,isInitial);
                    break;
                }
            }
        }
    }
}
