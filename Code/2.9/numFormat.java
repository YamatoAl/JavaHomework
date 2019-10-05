import java.util.Scanner;
import java.text.DecimalFormat;

public class numFormat{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x;
		x=keyin.nextDouble();
		DecimalFormat df = new DecimalFormat("NT$#,##0.00"); 
		System.out.println(df.format(x));
	}
}