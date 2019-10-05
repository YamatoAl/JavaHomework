import java.util.Scanner;

public class UseDelimiter2{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String x,y;
		x=keyin.nextln();
		y=keyin.next();
		
		String[] spX=x.split(y);
		
		for(String outPut : spX){
			System.out.println(outPut);
		}
	}
}