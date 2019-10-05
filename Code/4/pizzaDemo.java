import java.util.Scanner;

public class PizzaDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int totalPrice=0;
		String line=sc.nextLine();
		String[] token=line.split(" ");
		if(isInt(token[0])){
			switch(token.length){
				case 1:totalPrice=compute(Integer.valueOf(token[0]));
								break;
				case 2:totalPrice=compute(Integer.valueOf(token[0]),
								Integer.valueOf(token[1]));break;
				case 3:totalPrice=compute(Integer.valueOf(token[0]),
								Integer.valueOf(token[1]),
								Integer.valueOf(token[2]));break;
			}	
		}else{
			if(token.length==2){
				totalPrice=compute(token[0],
						Integer.valueOf(token[1]));
			}else{
				totalPrice=compute(token);
			}
		}
		System.out.println(totalPrice);
	}

	private static boolean isInt(String msg) {
		if(java.lang.Character.isDigit(msg.charAt(0))){
			return true;
		}
		return false;
	}

	//Method1
	private static int compute(int pbnum) {
		int totalPrice=0;
totalPrice=pbnum*500;


		return totalPrice;
	}

	//Method2
	private static int compute(int pbnum, int cbnum) {
		int totalPrice=0;
totalPrice=pbnum*500+cbnum*200;

		return totalPrice;
	}

	//Method3
	private static int compute(int pbnum, int cbnum, int dbnum) {
		int totalPrice=0;
totalPrice=pbnum*500+cbnum*200+dbnum*50;

		return totalPrice;
	}

	//Method4
	private static int compute(String item, int num) {
		int totalPrice=0;
if(item.compareTo("pb")==0) totalPrice=num*500;
else if(item.compareTo("pm")==0) totalPrice=num*400;
else if(item.compareTo("ps")==0) totalPrice=num*300;
else if(item.compareTo("cb")==0) totalPrice=num*200;
else if(item.compareTo("cs")==0) totalPrice=num*100;
else if(item.compareTo("db")==0) totalPrice=num*50;
else if(item.compareTo("ds")==0) totalPrice=num*30;

		return totalPrice;
	}
	
	//Method5
	private static int compute(String... token) {
		int totalPrice=0;
for(int i=0;i<token.length;i+=2){
 if(token[i].compareTo("pb")==0) totalPrice+=Integer.valueOf(token[i+1])*500;
 else if(token[i].compareTo("pm")==0) totalPrice+=Integer.valueOf(token[i+1])*400;
 else if(token[i].compareTo("ps")==0) totalPrice+=Integer.valueOf(token[i+1])*300;
 else if(token[i].compareTo("cb")==0) totalPrice+=Integer.valueOf(token[i+1])*200;
 else if(token[i].compareTo("cs")==0) totalPrice+=Integer.valueOf(token[i+1])*100;
 else if(token[i].compareTo("db")==0) totalPrice+=Integer.valueOf(token[i+1])*50;
 else if(token[i].compareTo("ds")==0) totalPrice+=Integer.valueOf(token[i+1])*30;
}
		
		return totalPrice;
	}
}