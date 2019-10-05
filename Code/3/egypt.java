import java.util.Scanner;

public class egypt{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int x,i,j;
		x=keyin.nextInt();
		for(i=0;i<x;i++){
			for(j=0;j<x+i;j++){
				if(j>=x-i-1 && j<=x+i) System.out.print("*");
				else System.out.print(" ");
			}
			if(i==x-1)break;
			System.out.printf("\n");
		}
	}
}