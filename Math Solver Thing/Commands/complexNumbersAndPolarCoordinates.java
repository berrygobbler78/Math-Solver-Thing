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

        }

        scanner.close();
    }

    public static void polarToRectangular() {
        final double pi = 3.14159265358979323846;
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your polar equation (write it in the form r(cos(x)+isin(y))"
            );

        String[] polarToRectangular = (scanner.nextLine()).split("[)()]");

        Double r = Double.parseDouble(polarToRectangular[0]);
        Double x = Double.parseDouble(polarToRectangular[2]);

        Double p1 = r * Math.cos(x);
        Double p2 = r * Math.sin(x);

        System.out.println((r * Math.cos(x)) + "+i" +  );
        

        scanner.close();
    }

    public static void rectangularToPolar() {
        final double pi = 3.14159265358979323846;
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\n" + "Please input your rectangular equation (write it in the form a+bi)"
            );

        String[] rectangularToPolar = (scanner.nextLine()).split("[+i]");
        
        Double a = Double.parseDouble(rectangularToPolar[0]);
        Double b = Double.parseDouble(rectangularToPolar[1]);

        Double modulus = Math.sqrt((a*a)+(b*b));
        Double arcTan = Math.atan(b / a) * 180 / pi;
        
        System.out.println(
            "\n" + "Would you like an exact or rounded answer? (1 or 2)" +
            );

        String roundedOrExact = scanner.nextLine();

        if(roundedOrExact.equals("1")) {
            System.out.println(
                "\n" + modulus + "cos(" + arcTan + ") + isin(" + arcTan + ")"
                );
        }

        else if(roundedOrExact.equals("2")) { 

            MathContext modulusMathContext = new MathContext(2 + (Double.toString(modulus)).indexOf("."));
            MathContext arcTanMathContext = new MathContext(2 + (Double.toString(arcTan)).indexOf("."));

            BigDecimal modulusDecimal = (BigDecimal.valueOf(modulus)).round(modulusMathContext);
            BigDecimal arcTanDecimal = (BigDecimal.valueOf(arcTan)).round(arcTanMathContext);

            System.out.println(
                "\n" + modulusDecimal + "cos(" + arcTanDecimal + ") + isin(" + arcTanDecimal + ")"
                );
        } else {
            System.out.println(
                "\n" + "You are an idiot. Try again."
                );
        } 

        scanner.close();
    }

    
}
