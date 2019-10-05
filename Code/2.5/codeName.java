import java.util.Scanner;

public class codeName{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String inFirstName,inLastName,fWordFisrt,fWordLast,sWordFirst,lWordLast,lFirst,lLast;
		int lenLast;
		inFirstName=keyin.next();
		inLastName=keyin.next();
		lenLast=inLastName.length();
		fWordFisrt=inFirstName.substring(0,1);
		fWordLast=inLastName.substring(0,1);
		sWordFirst=inFirstName.substring(1,2);
		lWordLast=inLastName.substring(lenLast-1);
		lFirst=inFirstName.substring(2);
		lLast=inLastName.substring(1,lenLast-1);
		fWordFisrt=fWordFisrt.toLowerCase();
		sWordFirst=sWordFirst.toUpperCase();
		fWordLast=fWordLast.toLowerCase();
		lWordLast=lWordLast.toUpperCase();
		System.out.print(sWordFirst+lFirst+fWordFisrt+"ay "+lWordLast+fWordLast+lLast+"er");
	}
}