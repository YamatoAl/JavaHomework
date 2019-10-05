import java.util.Scanner;

public class backNum{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int inNum;
		inNum=keyin.nextInt();
		if((inNum%10)==(inNum/10000) && ((inNum/1000)%10)==((inNum/10)%10)) System.out.print(inNum+"是迴文數");
		else System.out.print(inNum+"不是迴文數");
	}
}