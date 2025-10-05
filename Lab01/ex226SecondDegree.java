import java.util.Scanner;
public class ex226SecondDegree {
    public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a,b,c (double):");
		double a=scanner.nextDouble();
		double b=scanner.nextDouble();
        double c=scanner.nextDouble();
        double delta=b*b-4*a*c;
		if(a==0){
			if(b==0){
                if(c ==0){
                    System.out.println("The equation has infinitely many solutions.");
                }
                else{
                    System.out.println("The equation has no solution.");
                }
            }
			else{ 
                double x=-c/b;
                System.out.println("The equation has one solution: x= " +x);
            }
		}
		else {
			if(delta<0){
                System.out.println("The equation has no real solution.");
            }
            else if(delta==0){
                double x=-b/(2*a);
                System.out.println("The equation has one real solution: x= " +x);
            }
            else{
                double x1=(-b-Math.sqrt(delta))/(2*a);
                double x2=(-b+Math.sqrt(delta))/(2*a);
                System.out.println("The equation has two real solutions: x1= " +x1+" and x2= "+x2);
            }
		}
     }
}





    

    
