package Subcategories;

import java.util.Scanner;

import Commands.Quadratics.quadraticEquationSolver;

public class quadraticEquations {

    public static void quadraticEquationsMain() {

        Scanner scanner = new Scanner(System.in);
    
        System.out.println(
            "\n" + "What kind of operation would you like to do?" + "\n" +
            "1. Solve Quadratic equation"
        );

        String operationType = scanner.nextLine();

        if(operationType.equals("1")) {
            quadraticEquationSolver.quadraticEquationSolverStart();
        } else if(operationType.equals("2")) {
        } else if(operationType.equals("3")) {
        } else {
            System.out.println(
                "\n" + "You formatted the response wrong. Try again."
            );
            quadraticEquationsMain();
        } 

        scanner.close();
    }    
}
