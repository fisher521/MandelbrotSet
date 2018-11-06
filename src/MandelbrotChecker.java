import java.util.Scanner;
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
        Scanner reader = new Scanner(System.in);
        double outputA = a;
        double outputB = b;
        int iterations = 1;

        System.out.println();
        printInfo(outputA,outputB,iterations);

        reader.nextLine();

        double oldOutputA, oldOutputB;

        while (checkMagnitude(outputA, outputB) < 2 && iterations < maxIterations) {
            oldOutputA = outputA;
            oldOutputB = outputB;

            outputA = iterateA(oldOutputA, oldOutputB, a);
            outputB = iterateB(oldOutputA, oldOutputB, b);

            iterations ++;
            printInfo(outputA,outputB, iterations);

            reader.nextLine();
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
        System.out.println("ITERATION " + iterations);
        if (b < 0) {
            System.out.println (a + "-" + b*-1 + "i");
            System.out.println("|"+ a + "-" + b*-1 + "i| = sqrt(" + a + "^2 + " + b + "^2)");
        }
        else {
            System.out.println (a + "+" + b + "i");
            System.out.println("|"+ a + "+" + b + "i| = sqrt(" + a + "^2 + " + b + "^2)");
        }
        System.out.println("= sqrt(" + a*a + " + " + b*b + ")");
        System.out.println("= sqrt(" + (a*a+b*b) + ")");
        if (a*a+b*b > 4) {
            System.out.println("sqrt(" + (a*a+b*b) + ") > 2");
        }
        else if (a*a+b*b == 4) {
            System.out.println("sqrt(" + (a*a+b*b) + ") = 2");
        }
        else {
            System.out.println("sqrt(" + (a*a+b*b) + ") < 2");
        }
    }
}
