
import java.io.*;
public class DoubleLetters {
    public static void main(String[] args) {
        String filename = "words.txt";
        String bestWord = "";
        int maxDoublePairs = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int doublePairs = countDoublePairs(line);
                if (doublePairs > maxDoublePairs) {
                    maxDoublePairs = doublePairs;
                    bestWord = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("The word with the most double pairs is: " + bestWord);
    }
    private static int countDoublePairs(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                count++;
                i++;
            }
        }
        return count;
    }
}


