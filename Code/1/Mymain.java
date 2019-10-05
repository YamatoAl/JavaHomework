import java.util.Scanner;

public class MyMain{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int x;
		x=input.nextInt();
		if(x>100) System.out.print("OOR");
		else if(x>89) System.out.print("A");
		else if(x>79) System.out.print("B");
		else if(x>69) System.out.print("C");
		else if(x>59) System.out.print("D");
		else if(x>49) System.out.print("E");
		else if(x>=0) System.out.print("Failed");
		else System.out.print("OOR");
	}
}