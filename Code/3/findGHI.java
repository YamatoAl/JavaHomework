import java.util.Scanner;

public class findGHI{
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int a,b,c,d,e,g,h,i,sumGHI;
		boolean end=false;
		boolean[] check;
		check=new boolean[11];
		for(int k=0;k<=9;k++){
			check[k]=false;
		}
		a=keyin.nextInt();
		b=keyin.nextInt();
		c=keyin.nextInt();
		d=keyin.nextInt();
		e=keyin.nextInt();
		check[a]=true;
		check[b]=true;
		check[c]=true;
		check[d]=true;
		check[e]=true;
		sumGHI=1100*e+d-100*a-10*b-11*c;
		for(g=0;g<=9;g++){
			if(check[g])continue;
			for(h=0;h<=9;h++){
				if(check[h] || g==h)continue;
				for(i=0;i<=9;i++){
					if(check[i] || g==i || h==i)continue;
					else if(g*100+h-10*i == sumGHI){
						System.out.println(g);
						System.out.println(h);
						System.out.print(i);
						end=true;
					}
				}
			}
		}
		if(!end) System.out.print("-1");
	}
}