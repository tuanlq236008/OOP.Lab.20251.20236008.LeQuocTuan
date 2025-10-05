import java.util.Arrays;
public class ex65 {
	public static void main(String[]args) {
		int [] a= {5,4,2,8,9,1,10};
		int sum=0;
		for (int i=0; i<a.length-1; i++){
            for(int j = 0; j<a.length-i-1; j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
		for(int i: a) {
			sum+=i;
		}
		double avg=(double)sum/a.length;
		System.out.println("Sorted array:"+Arrays.toString(a));
		System.out.println("Sum:"+sum);
		System.out.println("Average:"+avg);
		
	}
}