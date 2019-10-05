import java.util.Scanner;

public class TurnedDouble{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x;
		double result;
		x=keyin.nextDouble();
		result=1/x;
		System.out.printf("%.0f",result);
	}
}