import java.util.Scanner;

class UnknownOperatorException extends Exception {
    public UnknownOperatorException(String message) {
        super(message);
    }
}
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runCalculator = true;

        while (runCalculator) {
            double result = 0;
            System.out.println("calculator is on");
            System.out.println("result = " + result);
            while (true) {
                System.out.print(("> "));

                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("R")) {
                    System.out.println("final result = " + result);
                    break;
                }
                try {
                    if (input.length() < 2) {
                        throw new UnknownOperatorException("input must be at least 2 characters long");
                    }
                    char operator = input.charAt(0);
                    double operand = Double.parseDouble(input.substring(1));
                    switch (operator) {
                        case '+':
                            result += operand;
                            break;
                        case '-':
                            result -= operand;
                            break;
                        case '*':
                            result *= operand;
                            break;
                        case '/':
                            if (operand == 0) {
                                throw new ArithmeticException("division by zero");
                            }
                            result /= operand;
                            break;
                        default:
                            throw new UnknownOperatorException("unknown operator: " + operator);
                    }
                    System.out.println("updated result " + result);
                } catch (UnknownOperatorException e) {
                    System.out.println(e.getMessage());
                    System.out.println("re-enter last line");
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("invalid number format");
                }
            }
            System.out.println("do you want to continue? (yes/no)");
            String answer = scanner.nextLine().trim();
            if (!answer.equalsIgnoreCase("yes")) {
                runCalculator = false;
                System.out.println("end");
            }
        }
    }
}

