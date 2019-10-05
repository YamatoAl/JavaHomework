import java.util.Scanner;

public class NextLine3{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y,z;
		x=keyin.next();
		y=keyin.next();
		z=keyin.nextLine();
		z=z.trim();
		System.out.println(y);
		System.out.print(z);
	}
}