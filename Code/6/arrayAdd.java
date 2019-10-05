import java.util.Scanner;

public class arrayAdd{
	public static void main(String[] args){
		Scanner keyin= new Scanner(System.in);
		int[] array1,array2;
		int size1,size2;
		size1=keyin.nextInt();
		array1=new int[size1];
		for(int i=0;i<size1;i++){
			array1[i]=keyin.nextInt();
		}
		size2=keyin.nextInt();
		array2=new int[size2];
		for(int i=0;i<size2;i++){
			array2[i]=keyin.nextInt();
		}
		for(int i=0;i<size2;i++){
			System.out.print((array1[i]+array2[i]));
			if(i<size2-1)System.out.print(" ");
		}
	}
}