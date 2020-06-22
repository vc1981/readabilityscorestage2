package readability;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentenceInput = scanner.nextLine();
        // String[] sentenceWords = sentenceInput.split(" ");
        String[] sentenceWords = sentenceInput.split(" |\\s|\\p{Z}|\\p{Space}|\\p{Blank}");
        // System.out.println(sentenceWords.length);
        ArrayList<Integer> sentenceLength = new ArrayList<Integer>();
        int sentenceWordCount = 0;
        int sentenceFunctioningMissing = 0;
        for (String word : sentenceWords) {
            sentenceWordCount++;
            sentenceFunctioningMissing++;
            // System.out.println(word + " count of the word " + sentenceWordCount);
            if (word.matches(".+\\.") || word.matches(".+\\!") || word.matches(".+\\?") || sentenceFunctioningMissing == sentenceWords.length) {
                // System.out.println("End of sentence.");
                sentenceLength.add(sentenceWordCount);
                sentenceWordCount = 0;

            }
        }
        System.out.println(calculateAverage(sentenceLength));
    }

    public static String calculateAverage(ArrayList<Integer> sentenceWordCountList) {
        double average = 0;
        double sum = 0;
        String answer = null;
        if (!sentenceWordCountList.isEmpty()) {
            for (Integer mark : sentenceWordCountList) {
                sum += mark;
            }
            average = sum / sentenceWordCountList.size();
            // System.out.println(average);
        }
        if (average > 10) {
            answer = "HARD";
        } else {
            answer = "EASY";
        }
        return answer;
    }

}
