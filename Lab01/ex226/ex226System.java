import java.util.Scanner;
public class ex226System {
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){
            System.out.println("Enter coefficients a1, b1, c1 for equation 1 (a1*x + b1*y = c1): ");
            double a1 = input.nextDouble();
            double b1 = input.nextDouble();
            double c1 = input.nextDouble();
            System.out.println("Enter coefficients a2, b2, c2 for equation 2 (a2*x + b2*y = c2): ");
            double a2 = input.nextDouble();
            double b2 = input.nextDouble();
            double c2 = input.nextDouble();

            double determinant = a1 * b2 - a2 * b1;

            if (determinant == 0) {
                if (a1 * c2 == a2 * c1) {
                    System.out.println("Infinite solutions.");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                double x = (c1 * b2 - c2 * b1) / determinant;
                double y = (a1 * c2 - a2 * c1) / determinant;
                System.out.println("Solution: x = " + x + ", y = " + y);
            }
        }
    }
}





    

    
