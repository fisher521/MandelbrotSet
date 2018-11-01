/**
 * MandelbrotChecker
 *
 * Checks how many iterations it takes for a complex number to escape the Mandelbrot Set.
 *
 * @author Fisher
 * @version 10/31/18
 */
class MandelbrotChecker {
    static void main(double a, double b, int maxIterations) {

        double outputA = a;
        double outputB = b;
        int iterations = 0;
        printInfo(outputA,outputB,iterations);

        double oldOutputA, oldOutputB;

        while (checkMagnitude(outputA, outputB) <= 2 && iterations < maxIterations) {
            oldOutputA = outputA;
            oldOutputB = outputB;

            outputA = iterateA(oldOutputA, oldOutputB, a);
            outputB = iterateB(oldOutputA, oldOutputB, b);

            iterations ++;
            printInfo(outputA,outputB,iterations);
        }

        if (checkMagnitude(outputA,outputB) > 2) {
            System.out.println("Escaped at " + iterations + " iterations");
        }
    }
    private static double iterateA(double a, double b, double c) {
        return (a * a - b * b) + c;
    }
    private static double iterateB(double a, double b, double c) {
        return (a*b + a*b) + c;
    }
    private static double checkMagnitude(double a, double b) {
        return Math.sqrt(a*a + b*b);
    }
    private static void printInfo(double a, double b, int iterations) {
        System.out.println();
        System.out.println("ITERATION " + iterations);
        //test 0,1
        if (b < 0) {
            System.out.println (a + "-" + b * -1 + "i");
        }
        else {
            System.out.println (a + "+" + b + "i");
        }
        System.out.println("Magnitude: " + checkMagnitude(a, b));
    }
}
