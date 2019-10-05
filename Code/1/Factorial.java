import java.util.Scanner;

public class Factorial{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		long num,inNum,i,j,useSize;
		inNum=input.nextLong();
		num=inNum;
		for(i=inNum-1;i>0;i--){
			num*=i;
		}
		System.out.print(num);
	}
}