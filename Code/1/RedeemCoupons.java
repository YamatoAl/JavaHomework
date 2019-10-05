import java.util.Scanner;

public class RedeemCoupons{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int coupon;
		int outCandy,outGum,outCoupons;
		coupon=input.nextInt();
		outCandy=coupon/10;
		outGum=(coupon-outCandy*10)/3;
		outCoupons=coupon-outCandy*10-outGum*3;
		System.out.print(outCandy+" "+outGum+" "+outCoupons+"\n");
	}
}