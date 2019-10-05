import java.util.Scanner;

public class police{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int sizeW,sizeH,x,y,count,endCheck=0;
		sizeW = sc.nextInt();
		sizeH = sc.nextInt();
		x= sc.nextInt();
		y= sc.nextInt();
		count=0;
		for(int i=0;i<sizeW;i++){
			for(int j=0;j<sizeH;j++){
				if(i==x&&j==y){
					System.out.print(count);
					endCheck=1;
					break;
				}
				else ++count;
			}
			if(endCheck==1)break;
		}
	}
}