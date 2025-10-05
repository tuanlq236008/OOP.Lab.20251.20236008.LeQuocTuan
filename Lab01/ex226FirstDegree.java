import java.util.Scanner;

public class ex226FirstDegree {
    public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a and b (double):");
		double a=scanner.nextDouble();
		double b=scanner.nextDouble();
	
		if(a==0) {
			if(b==0){
				System.out.println("The equation has infinitely many solutions.");
			}
			else {
				System.out.println("The equation has no solution.");
			}
		}
		else {
			double x=-b/a;
			System.out.println("The equation has one solution: x= " +x);
		}
	}
}
