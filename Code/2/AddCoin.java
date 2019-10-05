import java.util.Scanner;

public class AddCoin{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int x,y;
		int result;
		x=keyin.nextInt();
		y=keyin.nextInt();
		result=x+y*5;
		System.out.println(result);
	}
}