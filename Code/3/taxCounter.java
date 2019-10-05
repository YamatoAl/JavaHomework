import java.util.Scanner;

public class taxCounter{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double inMoney;
		inMoney=keyin.nextDouble();
		if(inMoney>=30000){
			System.out.printf("%.2f 1",(inMoney-30000)*0.1+750);
		}
		else if(inMoney>=15000){
			System.out.printf("%.2f 1",(inMoney-15000)*0.05);
		}
		else System.out.print("0.00 1");
	}
}