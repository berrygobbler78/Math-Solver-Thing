package Commands.Quadratics;

import java.util.Scanner;

public class quadraticEquationSolver {
    
    public static void quadraticEquationSolverStart() {
        try {
            quadraticEquationSolverRun();
        } catch (NumberFormatException e) {
            System.out.println("\nYou formatted the reponse wrong. Try again.");
            quadraticEquationSolverStart();
        } catch (Exception e) {
            System.out.println("\nReport bug for Exception:" + e);
        }
    }

    public static void quadraticEquationSolverRun() {
        Boolean doesParabolaOpenUpwards;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "What is your equation? (Write your equation, use the format ax^2+bx+c)");
        
        String originalString = scanner.next();
        String[] equation = originalString.split("[x+]");
        
        Double a = Double.parseDouble(equation[0]);
        Double b = Double.parseDouble(equation[2]);
        Double c = Double.parseDouble(equation[4]);
        
        Double xCoordinate = -b/(2 * a);
        Double yCoordinate = (a * Math.pow(xCoordinate, 2)) + (b * xCoordinate) + c; 
        
        Double x1 = xCoordinate + 1;
        Double x2 = xCoordinate + 2;
        
        Double y1 = (a * Math.pow(x1, 2) + (b * x1) + c);
        Double y2 = (a * Math.pow(x2 , 2) + (b * x2) + c);
        
        if (y1 < y2) {
            doesParabolaOpenUpwards = true;
        } else {
            doesParabolaOpenUpwards = false;
        }

        Double step1 = Math.pow(b, 2) - 4 * a * c;
        
        if (step1 < 0) {
            step1 = -step1;
    
            Double xInterceptPt1 = -b / 2 * a;
            Double xInterceptPt2 = Math.sqrt(step1) / 2 * a;
            
            System.out.println("\n" + "X-Intercept: " + xInterceptPt1 + " ± " + xInterceptPt2 + "i" + "\n" + "Y-Intercept: " + c + "\n" + "Vertex: (" + xCoordinate + ", " + yCoordinate + ").");
            
                if (doesParabolaOpenUpwards == true) {
                System.out.println("\nThe parabola opens upwards.");
            } else {
                System.out.println("\nThe parabola opens downwards.");
            }
            System.out.println("(The imaginary number 'i' represents the sqrt of -1. In this case, the vertex of the parabola is above the x axis, and the parabola opens upwards.)");
        } else {
            Double xIntercept1 = (-b + Math.sqrt(step1)) / (2 * a);
            Double xIntercept2 = (-b - Math.sqrt(step1)) / (2 * a);
            
            if (xIntercept1.equals(xIntercept2)) {
                System.out.println("X-intercept: " + xIntercept1);
            } else {
                System.out.println("X-intercepts: " + xIntercept1 + " and " + xIntercept2);
            }
            System.out.println("Y-Intercept: " + c + "\nVertex: (" + xCoordinate + ", " + yCoordinate + ")");

            if (doesParabolaOpenUpwards == true) {
                System.out.println("The parabola opens upwards.");
            } else {
                System.out.println("The parabola opens downwards.");
            }   
        }
        scanner.close();
    }
}