import java.util.Scanner;

public class uplower{
	public static void main(String[] args){
		Scanner keyin= new Scanner(System.in);
		String str;
		str=keyin.nextLine();
		System.out.println(str.toUpperCase());
		System.out.print(str.toLowerCase());
	}
}