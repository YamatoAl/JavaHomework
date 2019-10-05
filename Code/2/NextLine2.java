import java.util.Scanner;

public class NextLine2{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y,z;
		x=keyin.nextLine();
		y=keyin.nextLine();
		z=keyin.nextLine();
		System.out.println(x+y+z);
	}
}