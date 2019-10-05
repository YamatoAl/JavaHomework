import java.util.Scanner;

public class iHateJava{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y;
		int out;
		x=keyin.nextLine();
		x=x.replaceAll("I","i");
		x=x.replaceAll("hate","Love");
		x=x.replaceAll("java","JAVA");
		x=x.replaceAll("Java","JAVA");
		x=x.replaceAll("jAVA","JAVA");
		x=x.replaceAll("\\s+", "");
		System.out.print("***"+x+"***");
	}
}