package task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Comparator {
    static char[] vowels=new char[] {'а','е','ё','и','о','у','ы','э','ю','я',
            'А','Е','Ё','И','О','У','Ы','Э','Ю','Я'};

    public static void main(String[] args) {
        System.out.println("Enter a sentence");
        ArrayList<Word> words = wordsInput();
        System.out.println("vowels quantity: "+vowelCounter(words));
        Comparator.quickSort(words,0,words.size()-1);
        for(Word word:words){
            word.firstVowelToUpper(vowels);
            System.out.println(word.getLetters());
        }
    }

    static ArrayList<Word> wordsInput(){
        //сканнер получает строку из потока, затем получает слова из этой строки
        ArrayList<Word> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner = new Scanner(input);
        while(scanner.hasNext()){
            String newWord = scanner.next();
            words.add(new Word(newWord));
        }
        return words;
    }
    static int vowelCounter(ArrayList<Word> words){
        int sum = 0;
        for(Word word:words){
            for(int i=0;i<word.getLetters().length();i++){
                for (char vowel : vowels) {
                    if (word.getLetters().charAt(i) == vowel) {
                        sum++;
                        word.setVowels(word.getVowels() + 1);
                        break;
                    }
                }
            }
        }
        return sum;
    }


}
