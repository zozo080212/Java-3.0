import java.io.*;
import java.util.*;


public class BookRating {
    public static void main(String[] args) {
        String filename = "BR.txt";
        Map<String, List<Integer>> BOOKRATINGS = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int NumRatings = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < NumRatings; i++) {
                String line = reader.readLine();
                int rating = Integer.parseInt(reader.readLine());
                BOOKRATINGS.putIfAbsent(line, new ArrayList<>());
                BOOKRATINGS.get(line).add(rating);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("An error occurred." + e.getMessage());
            return;
        }
        for (Map.Entry<String, List<Integer>> entry : BOOKRATINGS.entrySet()) {
            String book = entry.getKey();
            List<Integer> ratings = entry.getValue();
            int reviewCount = ratings.size();
            double avgRating = ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.println(book + " (Reviews: " + reviewCount + ", Average Rating: " + avgRating + ")");
        }
    }
}
