import java.util.ArrayList;

public class Eratosthenes {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            numbers.add(i);
        }
        int index = 0;
        while (index < numbers.size() && numbers.get(index) * numbers.get(index) <= 100) {
            int prime = numbers.get(index);
            for (int j = numbers.size() - 1; j > index; j--) {
                if (numbers.get(j) % prime == 0) {
                    numbers.remove(j);
                }
            }
            index++;
        }
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
