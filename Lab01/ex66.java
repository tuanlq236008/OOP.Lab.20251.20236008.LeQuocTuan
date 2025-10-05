public class ex66 {
	public static void main(String[]args) {
		int [][] a= {{1,2,3},
				     {2,3,5},
				     {4,3,1}
		};
		int [][] b= {{4,5,2},
				     {2,4,1},
				     {3,8,4}
		};
		int [][] c=new int[3][3];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}