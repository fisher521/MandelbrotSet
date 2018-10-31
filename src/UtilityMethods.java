import java.util.Scanner;
/**
 * Utility Methods
 *
 * Methods to assist in making programs fool-proof.
 *
 * @author Fisher
 * @version 5/30/18
 */
class UtilityMethods {
    private static Scanner reader = new Scanner(System.in);
    static int inputInt(String errorMessage) {
        int integer;
        while (true) {
            try {
                String response = reader.nextLine();
                integer = Integer.parseInt(response);
                break;
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
            }
        }
        return integer;
    }
    static double inputDouble(String errorMessage) {
        double dub;
        while (true) {
            try {
                String response = reader.nextLine();
                dub = Double.parseDouble(response);
                break;
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
            }
        }
        return dub;
    }
}

