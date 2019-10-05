import java.util.Scanner;

public class compareString{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y;
		int out;
		x=keyin.next();
		y=keyin.next();
		out=x.compareTo(y);
		if(out==0)System.out.print("1");
		else System.out.print("0");
	}
}