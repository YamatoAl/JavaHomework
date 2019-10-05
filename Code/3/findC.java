import java.util.Scanner;

public class findC{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int b,d,e,c;
		b=keyin.nextInt();
		d=keyin.nextInt();
		e=keyin.nextInt();
		c=101*b-10*d-101*e;
		if(c%101==0 && c>=0 && c<=909 && c!=101*b && c!=101*d && c!=101*e){
			c/=101;
			System.out.print(c);
		}
		else System.out.print("-1");
	}
}