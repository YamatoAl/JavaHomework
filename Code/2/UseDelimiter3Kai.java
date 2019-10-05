import java.util.Scanner;

public class UseDelimiter3Kai{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y,z;
		int lastCh,firstCh;
		x=keyin.nextLine();
		firstCh=x.indexOf("#");
		lastCh=x.lastIndexOf("#");
		y=x.substring(0,firstCh);
		z=x.substring(lastCh+1);
		System.out.print(y+z);
	}
}