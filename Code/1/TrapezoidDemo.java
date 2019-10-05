import java.util.Scanner;
public class TrapezoidDemo{
	public static void main(String[] args) {
		double a,b,c;
		double result=0.0;
		Scanner sc=new Scanner(System.in);

		a=sc.nextDouble();
		b=sc.nextDouble();
		c=sc.nextDouble();
		
		//---------------------
		//---Begin to Modify---
		//---------------------	
		result=(a+b)*c/2;
		//---------------------
		//---End to Modify-----
		//---------------------
		
		System.out.println(result);
	}

}