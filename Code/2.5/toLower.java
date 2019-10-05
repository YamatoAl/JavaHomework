import java.util.Scanner;

public class toLower{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y;
		int out;
		x=keyin.nextLine();
		x=x.toLowerCase();
		System.out.print(x);
	}
}