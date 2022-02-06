package task3;

import java.util.Locale;

public class Word {//объект этого класса содержит слово и кол-во гласных в нём
    private String letters;
    private int vowels;

    public Word(String letters){
        this.letters=letters;
    }

    void firstVowelToUpper(char[] vowels){
        /*
        идёт проверка на гласную: если следующая буква согласная, она добавляется в строку,
        содержащую согласные в начале слова, если же буква гласная, она становится заглавной.
        На этом цикл досрочно заканчивается и формируется новое слово из согласных в начале,
        заглавной гласной буквы и остальной части слова
         */
        boolean isChanged = false;
        StringBuilder consonantLetters = new StringBuilder();
        for(int i=0;i<letters.length();i++){
            if(isChanged) break;
            for (char vowel : vowels) {
                if (letters.charAt(i) == vowel) {
                    String consLettersFinal = consonantLetters.toString();
                    String capitalVowel = String.valueOf(letters.charAt(i)).toUpperCase(new Locale("ru"));
                    letters = consLettersFinal + capitalVowel + letters.substring(consLettersFinal.length()+1);
                    isChanged = true;
                    break;
                }
            }
            if(!isChanged) consonantLetters.append(letters.charAt(i));
        }
    }

    public void setVowels(int vowels) {
        this.vowels = vowels;
    }

    public int getVowels() {
        return vowels;
    }

    public String getLetters() {
        return letters;
    }
}
