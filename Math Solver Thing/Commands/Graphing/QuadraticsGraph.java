package Commands.Graphing;

import java.util.Scanner;

public class QuadraticsGraph {
    protected static Double a;
    protected static Double b;
    protected static  Double c;

    public static void quadraticsGraphStart() {
        try {
            quadraticsGraphRun();
        } catch (NumberFormatException e) {
            System.out.println("\nYou formatted the reponse wrong. Try again.");
            quadraticsGraphRun();
        } catch (Exception e) {
            System.out.println("\nReport bug for Exception:" + e);
        }
    }

    public static void quadraticsGraphRun() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "What is your equation? (Write your equation, use the format ax^2+bx+c)");
        
        String originalString = scanner.next();
        String[] equation = originalString.split("[x+]");
        
        a = Double.parseDouble(equation[0]);
        b = Double.parseDouble(equation[2]);
        c = Double.parseDouble(equation[4]);

        new GraphFrame();
        
        scanner.close();
    }
}
