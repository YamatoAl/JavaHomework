import java.util.Scanner;

public class FactorialKai{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int[] num=new int[50];
		int[] nowPlus=new int[50];
		int inNum,i,j,k,useSize;
		inNum=input.nextInt();
		num[0]=inNum;
		useSize=0;
		for(i=inNum-1;i>1;i--){
			for(j=0;j<=useSize;j++){
				num[j]*=i;
				if(num[j]>10000){
					nowPlus[j+1]=num[j]/10000;
					num[j]%=10000;
					if(j+1>useSize)useSize++;
				}
			}
			for(j=0;j<=useSize;j++){
				num[j]+=nowPlus[j];
				nowPlus[j]=0;
			}
		}
		for(i=useSize;i>=0;i--){
			if(num[i]<1000&&num[i]>99&&i!=useSize)System.out.print("0");
			else if(num[i]<100&&num[i]>9&&i!=useSize)System.out.print("00");
			else if(num[i]==0)System.out.print("000");
			System.out.print(num[i]);
		}
		System.out.print("\n");	
	}
}