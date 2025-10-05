import java.util.Scanner;
public class ex63 {
    public static void main(String[] args) {

        try(Scanner input = new Scanner(System.in)){
            System.out.print("Enter the height of the triangle: ");
            int n = input.nextInt();

            for(int i = 1; i <= n; i++){
                int space = n - i;
                int star = 2 * (i - 1) + 1;

                for(int j = 1; j <= space; j++)
                    System.out.print(" ");

                for(int j = 1; j <= star; j++)
                    System.out.print("*");

                System.out.println();
            }
        }
    }
}