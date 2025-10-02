import java.util.Scanner;

public class ex225 {
    public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input 2 double numbers:");
		double d1=scanner.nextDouble();
		double d2=scanner.nextDouble();
		
		double sum=d1+d2;
		double diff=d1-d2;
		double	prd=d1*d2;
		
		System.out.println("Sum:"+sum);
		System.out.println("Difference:"+diff);
		System.out.println("Product:"+prd);
		
		if(d2!=0) {
			double qt=d1/d2;
			System.out.println("Quotient:"+qt);
		}
		else {
			System.out.println("Can't divide by 0!");
		}
		scanner.close();
	}
}
