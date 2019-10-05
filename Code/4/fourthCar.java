public class Car{
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
	public Car(){
		speed=0;
		mileage=0;
		color="NoColor";
		brand="NoBrand";
	}
	
	public Car(int s){
		speed=s;
		mileage=0;
		color="NoColor";
		brand="NoBrand";
	}
	
	public Car(String c){
		speed=0;
		mileage=0;
		color=c;
		brand="NoBrand";
	}
	
	public Car(String c,String b){
		speed=0;
		mileage=0;
		color=c;
		brand=b;
	}
	
	public Car(int s,int m,String c,String b){
		speed=s;
		mileage=m;
		color=c;
		brand=b;
	}
}