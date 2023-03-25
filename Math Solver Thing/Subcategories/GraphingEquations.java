package Subcategories;

import java.util.Scanner;

import Commands.Graphing.QuadraticsGraph;

public class GraphingEquations {
    public static void graphingEquationsMain() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "\nWhat kind of equation would you like to graph?\n" +
            "1. Quadratic\n" +
            "2. Cosine, sine, or tangent"
        );

        String graphType = scanner.nextLine();

        if (graphType.equals("1")) {
            QuadraticsGraph.quadraticsGraphStart();
        } else {
            System.out.println(
                "\n" + "You formatted the response wrong. Try again."
            );

            graphingEquationsMain();
        }
        scanner.close();
    }
}
