import java.util.Scanner;

public class BMICount{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		double high,weight;
		double result;
		high=input.nextDouble() / 100;
		weight=input.nextDouble();
		result=weight/(high*high);
		System.out.print(result);
	}
}