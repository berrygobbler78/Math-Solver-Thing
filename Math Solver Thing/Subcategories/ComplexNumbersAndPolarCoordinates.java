package Subcategories;

import java.util.Scanner;

import Commands.ComplexNumbersAndPolarCoordinates.FindModulus;
import Commands.ComplexNumbersAndPolarCoordinates.PolarToRectangular;
import Commands.ComplexNumbersAndPolarCoordinates.RectangularToPolar;

public class ComplexNumbersAndPolarCoordinates {

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
            RectangularToPolar.rectangularToPolarStart();
        } else if(operationType.equals("2")) {
            PolarToRectangular.polarToRectangularStart();
        } else if(operationType.equals("3")) {
            FindModulus.findModulusStart();
        } else {
            System.out.println(
                "\n" + "You formatted the response wrong. Try again."
            );
            complexNumbersAndPolarCoordinatesMain();
        } 

        scanner.close();
    }    
}
