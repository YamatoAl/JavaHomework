import java.util.Scanner;

public class PigLatinRule{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String firstName,lastName,firstAy,lastAy,newFirstWord,newLastWord,newFirst,newLast;
		firstName=input.next();
		lastName=input.next();
		firstAy=firstName.substring(0,1);
		lastAy=lastName.substring(0,1);
		newFirstWord=firstName.substring(1,2);
		newLastWord=lastName.substring(1,2);
		newFirst=firstName.substring(2);
		newLast=lastName.substring(2);
		
		System.out.print(newFirstWord.toUpperCase()+newFirst+firstAy.toLowerCase()+"ay "+newLastWord.toUpperCase()+newLast+lastAy.toLowerCase()+"ay\n");
	}
}