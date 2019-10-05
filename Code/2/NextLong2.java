import java.util.Scanner;

public class NextLong{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		long x,sec,min,hour,day;
		x=keyin.nextLong();
		x=x/1000;
		sec=x%60;
		min=x/60;
		min=min%60;
		hour=x/3600;
		hour=hour%24;
		day=x/86400;
		System.out.print(day+" "+hour+" "+min+" "+sec);
	}
}