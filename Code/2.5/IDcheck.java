import java.util.Scanner;

public class IDcheck{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String inID,firstWord,secondWord;
		inID=keyin.next();
		if(inID.length()==10){
			firstWord=inID.substring(0,1);
			System.out.println("1_CLEAR");
			if(firstWord.compareTo("A")>=0 && firstWord.compareTo("Z")<=0){
				secondWord=inID.substring(1,2);
				System.out.println("2_CLEAR");
				if(secondWord.compareTo("1")==0 || secondWord.compareTo("2")==0){
					System.out.println("3_CLEAR");
					System.out.print("1");
				}
				else System.out.print("0");
			}
			else System.out.print("0");
		}
		else System.out.print("0");
	}			
}