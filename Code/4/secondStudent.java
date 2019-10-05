public class Student{
	public int age;
	public int grade;
	public String name;
	public String id;
	
	public boolean setAge(int a){
		age=a;
		return true;
	}
	
	public boolean setId(String s){
		id=s;
		return true;
	}
	
	public boolean setStudent(int g,String n,String i){
		grade=g;
		name=n;
		id=i;
		return true;
	}
}