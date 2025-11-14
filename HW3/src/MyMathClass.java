
import java.util.ArrayList;

class MyMathClass<T extends Number> {
    public double standardDeviation(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (T num : list) {
            sum += num.doubleValue();
        }
        double mean = sum / list.size();
        double squaredDifferenceSum = 0;
        for (T num : list) {
            squaredDifferenceSum += Math.pow(num.doubleValue() - mean, 2);
        }
        double variance = squaredDifferenceSum / list.size();
        double standardDeviation = Math.sqrt(variance);
        return standardDeviation;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        MyMathClass<Integer> math = new MyMathClass<>();
        System.out.println("standard deviation is: " + math.standardDeviation(list));
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(10.5);
        list2.add(20.5);
        list2.add(30.5);
        list2.add(40.5);
        list2.add(50.5);
        MyMathClass<Double> math2 = new MyMathClass<>();
        System.out.println("standard deviation is: " + math2.standardDeviation(list2));
    }
}