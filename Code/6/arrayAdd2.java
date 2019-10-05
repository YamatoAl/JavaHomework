import java.util.Scanner;

public class arrayAdd2{
	public static void main(String[] args){
		Scanner keyin= new Scanner(System.in);
		int[][] array1,array2;
		int sizeR1,sizeC1,sizeR2,sizeC2;
		sizeR1=keyin.nextInt();
		sizeC1=keyin.nextInt();
		array1=new int[sizeR1][sizeC1];
		for(int i=0;i<sizeR1;i++){
			for(int j=0;j<sizeC1;j++){
				array1[i][j]=keyin.nextInt();
			}
		}
		sizeR2=keyin.nextInt();
		sizeC2=keyin.nextInt();
		array2=new int[sizeR2][sizeC2];
		for(int i=0;i<sizeR2;i++){
			for(int j=0;j<sizeC2;j++){
				array2[i][j]=keyin.nextInt();
			}
		}
		for(int i=0;i<sizeR2;i++){
			for(int j=0;j<sizeC2;j++){
				System.out.print((array1[i][j]+array2[i][j]));
				if(j<sizeC2-1)System.out.print(" ");
				else System.out.printf("\n");
			}
		}
	}
}