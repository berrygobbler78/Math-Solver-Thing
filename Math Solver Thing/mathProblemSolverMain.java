import java.util.Scanner;

import Subcategories.complexNumbersAndPolarCoordinates;
import Subcategories.graphingEquations;
import Subcategories.quadraticEquations;

public class mathProblemSolverMain {

    public static void main(String[] args) {

        // pi variable for use later
        // final double pi = 3.14159265358979323846;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "What type of problem do you want to solve?\n" + 
            "1. Complex numbers and polar coordinates\n" + 
            "2. Quadratic equations\n" +
            "3. Graphing equations"
        );

        String problemType = scanner.nextLine();  
        if(problemType.equals("1")) {
            complexNumbersAndPolarCoordinates.complexNumbersAndPolarCoordinatesMain();
        } else if(problemType.equals("2")) {
            quadraticEquations.quadraticEquationsMain();
        } else if(problemType.equals("3")) {
            graphingEquations.graphingEquationsMain();
        } else {
            System.out.println(
                "\n" + "Not a valid answer numbnuts"
            );
        }

        scanner.close();
    }
}
