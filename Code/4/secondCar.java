public class Car{
	public int speed;
	public int mileage;
	public String color;
	public String brand;
	
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
	
	public boolean setCar(String c,String b){
		color=c;
		brand=b;
		return true;
	}
	
	public boolean setCar(int s,int m,String c,String b){
		speed=s;
		mileage=m;
		color=c;
		brand=b;
		return true;
	}
}