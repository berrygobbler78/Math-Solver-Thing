package Commands.ComplexNumbersAndPolarCoordinates;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class FindModulus {
    public static void findModulusStart() {
        try {
            findModulusRun();
        } catch (NumberFormatException e) {
            System.out.println("\nYou formatted the reponse wrong. Try again.");
            findModulusRun();
        } catch (Exception e) {
            System.out.println("\nReport bug for Exception:" + e);
        }
    }

    public static void findModulusRun() {
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
}
