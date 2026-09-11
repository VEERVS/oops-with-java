import java.util.Scanner;

public class PredefinedException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int[] arr = {1, 2, 3, 4};

            int i, b;

            System.out.print("Enter array index: ");
            i = sc.nextInt();

            System.out.print("Enter divisor: ");
            b = sc.nextInt();

            System.out.println("Array element: " + arr[i]);
            System.out.println("Result: " + (arr[i] / b));
        }

        catch (ArithmeticException e) {
            System.err.println("Exception caught is " + e.getMessage());
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Exception caught is " + e.getMessage());
        }

        finally {
            sc.close();
            System.err.println("finally");
        }
    }
}