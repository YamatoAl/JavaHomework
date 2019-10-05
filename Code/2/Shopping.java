import java.util.Scanner;

public class Shopping{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		String productX,productY,productZ;
		int numX,numY,numZ;
		int costX,costY,costZ;
		int sum;
		productX=keyin.next();
		numX=keyin.nextInt();
		costX=keyin.nextInt();
		productY=keyin.next();
		numY=keyin.nextInt();
		costY=keyin.nextInt();
		productZ=keyin.next();
		numZ=keyin.nextInt();
		costZ=keyin.nextInt();
		sum=numX*costX+numY*costY+numZ*costZ;
		System.out.println(productX+" "+numX+" "+costX+" "+numX*costX);
		System.out.println(productY+" "+numY+" "+costY+" "+numY*costY);
		System.out.println(productZ+" "+numZ+" "+costZ+" "+numZ*costZ);
		System.out.println("sum "+sum);
	}
}