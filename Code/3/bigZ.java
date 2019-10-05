import java.util.Scanner;

public class bigZ{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		char[] x;
		x=new char[5];
		for(int i=0;i<=4;i++){
			x[i]=keyin.next().charAt(0);
		}
		for(int i=0;i<=4;i++){
			switch(x[i]){
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
					System.out.print(Character.toUpperCase(x[i]));
					break;
				default:
					System.out.print("Z");
			}
			if(i==4)break;
			else System.out.print(" ");
		}
	}
}