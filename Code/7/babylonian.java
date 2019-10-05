import java.util.Scanner;

public class babylonian{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double n,r,guess;
		n=keyin.nextDouble();
		guess=n/2;
		for(int i=0;i<6;i++){
			r=n/guess;
			guess=(guess+r)/2;
		}
		System.out.printf("%.0f 0.1",guess);
	}
}