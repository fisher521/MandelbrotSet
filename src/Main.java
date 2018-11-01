import java.util.Scanner;
/**
 * Main
 *
 * Main class of the Mandelbrot set program.
 *
 * @author Fisher
 * @version 10/31/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double a, b;
        int maxIterations;

        running:
        while (true) {
            System.out.print("Enter real value: ");
            a = UtilityMethods.inputDouble("no u");
            System.out.print("Enter imaginary value: ");
            b = UtilityMethods.inputDouble("no u");
            System.out.print("Enter how many iterations to run: ");
            maxIterations = UtilityMethods.inputInt("plz no");

            MandelbrotChecker.main(a,b, maxIterations);

            System.out.println();
            while(true) {
                System.out.print("Restart? Y/N ");
                String response = reader.nextLine();
                if (response.equals("N") || response.equals("n")) {
                    break running;
                }
                else if (response.equals("Y") || response.equals("y")) {
                    System.out.println();
                    break;
                }
            }
        }
    }
}
