import java.util.Scanner;

public class NextDouble{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x;
		x=keyin.nextDouble();
		System.out.printf("%.2f\n",x*10);
	}
}