import java.util.Scanner;
import java.lang.Math;

public class PH{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x,logX;
		double result;
		x=keyin.nextDouble();
		logX=Math.log10(x);
		result=14+logX;
		System.out.printf("%.2f",result);
	}
}