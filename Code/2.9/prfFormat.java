import java.util.Scanner;

public class prfFormat{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double x;
		x=keyin.nextDouble();
		System.out.println(String.format("Start%8.2fEnd.",x));
		System.out.println(String.format("Start%-8.2fEnd.",x));
	}
}