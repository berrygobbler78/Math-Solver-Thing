package Commands.ComplexNumbersAndPolarCoordinates;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class RectangularToPolar {
    public static void rectangularToPolarStart() {
        try {
            rectangularToPolarRun();
        } catch (NumberFormatException e) {
            System.out.println("\nYou formatted the reponse wrong. Try again.");
            rectangularToPolarStart();
        } catch (Exception e) {
            System.out.println("\nReport bug for Exception:" + e);
        }
    }

    public static void rectangularToPolarRun() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your rectangular equation (Write it in the form a+bi)"
        );

        String[] rectangularToPolar = (scanner.nextLine()).split("[+i]");
        
        Double a = Double.parseDouble(rectangularToPolar[0]);
        Double b = Double.parseDouble(rectangularToPolar[1]);

        Double modulus = Math.sqrt((a*a)+(b*b));
        Double arcTan = Math.atan(b / a) * 180 / Math.PI;
        
        System.out.println(
            "\n" + "Would you like an exact or rounded answer? (1 or 2)"
        );

        String roundedOrExact = scanner.nextLine();

        if(roundedOrExact.equals("1")) {
            if(b < 0) {
                System.out.println(
                    "\n" + "Your answer is:" + modulus + "cos(" + (arcTan + 180) + ") + isin(" + (arcTan + 180) + ")"
                );
            } else {
                System.out.println(
                    "\n" + "Your answer is:" + modulus + "cos(" + arcTan + ") + isin(" + arcTan + ")"
                );
            }
            
        } else if(roundedOrExact.equals("2")) { 

            MathContext modulusMathContext = new MathContext(1 + (Double.toString(modulus)).indexOf("."));
            MathContext arcTanMathContext = new MathContext(1 + (Double.toString(arcTan)).indexOf("."));

            BigDecimal modulusDecimal = (BigDecimal.valueOf(modulus)).round(modulusMathContext);
            BigDecimal arcTanDecimal = (BigDecimal.valueOf(arcTan)).round(arcTanMathContext);
                
            if(b < 0) {
                System.out.println(
                    "\n" + "Your answer is:" + modulusDecimal + "cos(" + (arcTanDecimal.doubleValue() + 180) + ") + isin(" + (arcTanDecimal.doubleValue() + 180) + ")"
                );
            } else {
                System.out.println(
                    "\n" + "Your answer is:" + modulusDecimal + "cos(" + arcTanDecimal + ") + isin(" + arcTanDecimal + ")"
                );
            }
            
        } else {
            System.out.println(
                "\n" + "Not a valid answer numbnuts"
            );
        } 
        scanner.close();
    
    }
}
