import java.util.Scanner;

import Commands.complexNumbersAndPolarCoordinates;



public class mathProblemSolverMain {

    public static void main(String[] args) {

        // pi variable for use later
        // final double pi = 3.14159265358979323846;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "What type of problem do you want to solve?" + 
            "\n" + "1. Complex numbers and polar coordinates" + 
            "\n" + "2. Trigonometric equations and graphing trigonometric equations" + 
            "\n" + "3. Linear and angular velocity" + 
            "\n" + "4. Angles and trigonometric functions"
        );

        String problemType = scanner.nextLine();  
        if(problemType.equals("1")) {
            complexNumbersAndPolarCoordinates.complexNumbersAndPolarCoordinatesMain();
        } else {
            System.out.println(
                "\n" + "Not a valid answer numbnuts"
            );
        } 

        scanner.close();
    }
}
