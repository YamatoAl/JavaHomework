import java.util.Scanner;

public class Oil{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x,y;
		double result;
		x=keyin.nextDouble();
		y=keyin.nextDouble();
		result=x/y;
		System.out.printf("%.2f",result);
	}
}