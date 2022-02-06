package task3;

import java.util.ArrayList;

public interface Comparator {
    static void quickSort(ArrayList<Word> words, int leftBorder, int rightBorder) {
        //алгоритм быстрой сортировки по кол-ву гласных всловах
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = words.get((leftMarker + rightMarker) / 2).getVowels();
        do {

            while (words.get(leftMarker).getVowels() > pivot) {
                leftMarker++;
            }

            while (words.get(rightMarker).getVowels() < pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                if (leftMarker < rightMarker) {
                    Word tmp = words.get(leftMarker);
                    words.set(leftMarker,words.get(rightMarker));
                    words.set(rightMarker,tmp);
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(words, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(words, leftBorder, rightMarker);
        }
    }
}
