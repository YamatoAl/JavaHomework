import java.util.Scanner;

public class prfAdd{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int x,y;
		x=keyin.nextInt();
		y=keyin.nextInt();
		System.out.printf("%d add %d are %d.",x,y,x+y);
	}
}