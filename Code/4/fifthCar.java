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
	
	public boolean setCar(String c,String b){
		speed=0;
		mileage=0;
		color=c;
		brand=b;
		return true;
	}
	
	public Car(int s,int m,String c,String b){
		speed=s;
		mileage=m;
		color=c;
		brand=b;
	}
	
	public boolean setCar(int s,int m,String c,String b){
		speed=s;
		mileage=m;
		color=c;
		brand=b;
		return true;
	}
	
	public boolean setColor(String c,String b){
		speed=0;
		mileage=0;
		color=c;
		brand=b;
		return true;
	}
	
	public boolean setColor(int s,int m,String c,String b){
		speed=s;
		mileage=m;
		color=c;
		brand=b;
		return true;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getMileage(){
		return mileage;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public boolean setSpeed(int s){
		speed=s;
		return true;
	}
	
	public boolean setMileage(int m){
		mileage=m;
		return true;
	}
	
	public boolean setColor(String c){
		color=c;
		return true;
	}
	
	public boolean setBrand(String b){
		brand=b;
		return true;
	}
	
	
}