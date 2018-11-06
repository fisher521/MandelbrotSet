/**
 * MandelbrotChecker
 *
 * A class that checks how many iterations it takes for a complex number to escape the Mandelbrot Set.
 *
 * @author Fisher
 * @version 11/03/18
 */
class MandelbrotChecker {
    static void main(double a, double b, int maxIterations) {

        double outputA = a;
        double outputB = b;
        int iterations = 1;
        printInfo(outputA,outputB,iterations);

        double oldOutputA, oldOutputB;

        while (checkMagnitude(outputA, outputB) < 2 && iterations < maxIterations) {
            oldOutputA = outputA;
            oldOutputB = outputB;

            outputA = iterateA(oldOutputA, oldOutputB, a);
            outputB = iterateB(oldOutputA, oldOutputB, b);

            iterations ++;
            printInfo(outputA,outputB,iterations);
        }

        if (checkMagnitude(outputA,outputB) >= 2 && iterations != 1) {
            System.out.println("\nEscaped at " + iterations + " iterations.");
        }
        if (checkMagnitude(outputA,outputB) >= 2 && iterations == 1) {
            System.out.println("\nEscaped at " + iterations + " iteration.");
        }
    }

    //(a+bi)^2 + c = (a^2 - b^2) + (ab + ab)i + c
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
        System.out.println("\nITERATION " + iterations);
        if (b < 0) {
            System.out.println (a + "-" + b * -1 + "i");
        }
        else {
            System.out.println (a + "+" + b + "i");
        }
        System.out.println("Magnitude: " + checkMagnitude(a, b));
    }
}
