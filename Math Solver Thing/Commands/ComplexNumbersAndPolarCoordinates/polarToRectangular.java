package Commands.ComplexNumbersAndPolarCoordinates;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class polarToRectangular {
    public static void polarToRectangularStart() {
        try {
            polarToRectangularRun();
        } catch (NumberFormatException e) {
            System.out.println("\nYou formatted the reponse wrong. Try again.");
            polarToRectangularRun();
        } catch (Exception e) {
            System.out.println("\nReport bug for Exception:" + e);
        }
    }

    public static void polarToRectangularRun() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your polar equation (Write it in the form r(cos(x)+isin(x) where x is degrees)"
        );

        String[] polarToRectangular = (scanner.nextLine()).split("[)()]");

        Double r = Double.parseDouble(polarToRectangular[0]);
        Double x = Double.parseDouble(polarToRectangular[2]);

        System.out.println(
            "\n" + "Would you like an exact or rounded answer? (1 or 2)"
        );
    
        String roundedOrExact = scanner.nextLine();
        
        if (roundedOrExact.equals("1")) {
            if (Math.sin(x) < 0) {
                System.out.println(
                    "\n" +"Your answer is:" +  (r * Math.cos(Math.toRadians(x))) + "- i" + -( r * Math.sin(Math.toRadians(x)))
                );
            } else {
                System.out.println(
                    "\n" +"Your answer is:" +  (r * Math.cos(Math.toRadians(x))) + "+ i" + ( r * Math.sin(Math.toRadians(x)))
                );
            }
        } else if (roundedOrExact.equals("2")) {
            Double cos = Math.cos(Math.toRadians(x)) * r;
            Double sin = Math.sin(Math.toRadians(x)) * r;

            MathContext cosMathContext = new MathContext(1 + (Double.toString(cos)).indexOf("."));
            MathContext sinMathContext = new MathContext(1 + (Double.toString(sin)).indexOf("."));

            BigDecimal cosDecimal = (BigDecimal.valueOf(cos)).round(cosMathContext);
            Double sinDecimal = ((BigDecimal.valueOf(sin)).round(sinMathContext)).doubleValue();

            if (sinDecimal < 1 ) {
                System.out.println(
                    "\n" +"Your answer is:" +  cosDecimal + " - i" + -sinDecimal
                );
            } else {
                System.out.println(
                    "\n" +"Your answer is:" +  cosDecimal + " + i" + sinDecimal
                );
            }
        }
        scanner.close();
    }
}
