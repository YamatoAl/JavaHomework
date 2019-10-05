import java.util.Scanner;

public class UseDelimiter{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y,z;
		keyin.useDelimiter("#");
		x=keyin.next();
		y=keyin.next();
		z=keyin.next();
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}