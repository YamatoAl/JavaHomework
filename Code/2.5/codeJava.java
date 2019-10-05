import java.util.Scanner;

public class codeJava{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,outX;
		int i;
		x=keyin.nextLine();
		for(i=0;i<x.length();i+=3){
			System.out.print(x.substring(i,i+1));
		}
	}
}
		