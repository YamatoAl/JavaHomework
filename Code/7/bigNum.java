import java.util.Scanner;

public class bigNum{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		double[] inNum,outNum;
		int i,len,nowLen,big;
		inNum=new double[10];
		for(i=0;keyin.hasNext();i++){
			inNum[i]=keyin.nextDouble();
		}
		len=i-1;
		outNum=new double[len+1];
		nowLen=1;
		for(i=0;i<=len;i++){
			big=0;
			for(int j=0;j<=len;j++){
				if(inNum[j]>inNum[big])big=j;
			}
			outNum[i]=inNum[big];
			inNum[big]=0;
		}
		System.out.print("Large to small: ");
		for(i=0;i<=len;i++){
			System.out.print(outNum[i]);
			if(i<len)System.out.print(" ");
		}
	}
}