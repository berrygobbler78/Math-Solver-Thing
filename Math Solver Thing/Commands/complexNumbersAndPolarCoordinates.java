package Commands;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class complexNumbersAndPolarCoordinates {

    public static void complexNumbersAndPolarCoordinatesMain() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println(
            "\n" + "What kind of operation would you like to do?" + "\n" + 
            "1. Rectangular function to polar function" + "\n" + 
            "2. Polar function to rectangular function" + "\n" +
            "3. Find the modulus"
        );

        String operationType = scanner.nextLine();

        if(operationType.equals("1")) {
            rectangularToPolar();
        } else if(operationType.equals("2")) {
            polarToRectangular();
        } else if(operationType.equals("3")) {
            findModulus();
        } else {
            System.out.println(
                "\n" + "Not a valid answer numbnuts"
            );
        } 

        scanner.close();
    }

    public static void findModulus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your rectangular equation (Write it in the form a+bi)"
        );

        String[] rectangularEquation = (scanner.nextLine()).split("[+i]");
        
        Double a = Double.parseDouble(rectangularEquation[0]);
        Double b = Double.parseDouble(rectangularEquation[1]);

        System.out.println(
            "\n" + "Would you like an exact or rounded answer? (1 or 2)"
        );

        String roundedOrExact = scanner.nextLine();

        if (roundedOrExact.equals("1")) {
            System.out.println(Math.sqrt((a*a)+(b*b)));
        } else if (roundedOrExact.equals("2")) {
            MathContext answerMathContext = new MathContext(1 + (Double.toString(Math.sqrt((a*a)+(b*b)))).indexOf("."));

            Double answer = ((BigDecimal.valueOf(Math.sqrt((a*a)+(b*b)))).round(answerMathContext)).doubleValue();

            System.out.println(answer); 
        }
        

        scanner.close();
    }

    public static void polarToRectangular() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your polar equation (write it in the form r(cos(x)+isin(y))"
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
                    "\n" + (r * Math.cos(x)) + "- i" + -( r * Math.sin(x))
                );
            } else {
                System.out.println(
                    "\n" + (r * Math.cos(x)) + "+ i" + ( r * Math.sin(x))
                );
            }
        } else if (roundedOrExact.equals("2")) {
            
            Double cos = Math.cos(x) * r;
            Double sin = Math.sin(x) * r;

            MathContext cosMathContext = new MathContext(1 + (Double.toString(cos)).indexOf("."));
            MathContext sinMathContext = new MathContext(1 + (Double.toString(sin)).indexOf("."));

            BigDecimal cosDecimal = (BigDecimal.valueOf(cos)).round(cosMathContext);

            Double sinDecimal = ((BigDecimal.valueOf(sin)).round(sinMathContext)).doubleValue();

            if (sinDecimal < 1.0 ) {
                System.out.println(
                    "\n" + cosDecimal + "- i" + -sinDecimal
                );
            } else {
                System.out.println(
                    "\n" + cosDecimal + "+ i" + sinDecimal
                );
            }
            
        }

        scanner.close();
    }

    public static void rectangularToPolar() {
        final double pi = 3.14159265358979323846;
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your rectangular equation (Write it in the form a+bi)"
        );

        String[] rectangularToPolar = (scanner.nextLine()).split("[+i]");
        
        Double a = Double.parseDouble(rectangularToPolar[0]);
        Double b = Double.parseDouble(rectangularToPolar[1]);

        Double modulus = Math.sqrt((a*a)+(b*b));
        Double arcTan = Math.atan(b / a) * 180 / pi;
        
        System.out.println(
            "\n" + "Would you like an exact or rounded answer? (1 or 2)"
        );

        String roundedOrExact = scanner.nextLine();

        if(roundedOrExact.equals("1")) {
            if(b < 0) {
                System.out.println(
                    "\n" + modulus + "cos(" + (arcTan + 180) + ") + isin(" + (arcTan + 180) + ")"
                );
            } else {
                System.out.println(
                    "\n" + modulus + "cos(" + arcTan + ") + isin(" + arcTan + ")"
                );
            }
            
        } else if(roundedOrExact.equals("2")) { 

            MathContext modulusMathContext = new MathContext(1 + (Double.toString(modulus)).indexOf("."));
            MathContext arcTanMathContext = new MathContext(1 + (Double.toString(arcTan)).indexOf("."));

            BigDecimal modulusDecimal = (BigDecimal.valueOf(modulus)).round(modulusMathContext);
            BigDecimal arcTanDecimal = (BigDecimal.valueOf(arcTan)).round(arcTanMathContext);
            
            if(b < 0) {
                System.out.println(
                    "\n" + modulusDecimal + "cos(" + (arcTanDecimal.doubleValue() + 180) + ") + isin(" + (arcTanDecimal.doubleValue() + 180) + ")"
                );
            } else {
                System.out.println(
                    "\n" + modulusDecimal + "cos(" + arcTanDecimal + ") + isin(" + arcTanDecimal + ")"
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
