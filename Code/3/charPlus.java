import java.util.Scanner;

public class charPlus{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String fIn,sIn;
		char[] ch;
		ch=new char[6];
		int[] out;
		out=new int[3];
		out[0]=0;
		out[1]=0;
		out[2]=0;
		fIn=keyin.next();
		sIn=keyin.next();
		for(int i=0;i<=5;i++){
			if(i<3)ch[i]=fIn.charAt(i);
			else ch[i]=sIn.charAt(i-3);
			switch(ch[i]){
				case 'A':
					out[i%3]+=0;
					break;
				case 'B':
					out[i%3]+=1;
					break;
				case 'C':
					out[i%3]+=2;
					break;
				case 'D':
					out[i%3]+=3;
					break;
				case 'E':
					out[i%3]+=4;
					break;
				case 'F':
					out[i%3]+=5;
					break;
				case 'G':
					out[i%3]+=6;
					break;
				case 'H':
					out[i%3]+=7;
					break;
				case 'I':
					out[i%3]+=8;
					break;
				case 'J':
					out[i%3]+=9;
					break;
				default:
					break;
			}
		}
		System.out.print((out[0]*100+out[1]*10+out[2]));
	}
}