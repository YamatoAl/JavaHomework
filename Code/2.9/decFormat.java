import java.util.Scanner;
import java.text.DecimalFormat;

public class decFormat{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x;
		x=keyin.nextDouble();
		DecimalFormat df = new DecimalFormat("0.00"); 
		DecimalFormat df2 = new DecimalFormat("0.000"); 
		System.out.println(df.format(x));
		System.out.println(df2.format(x));
	}
}