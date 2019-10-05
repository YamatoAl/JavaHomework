public class Student{
	public int age;
	public int grade;
	public String name;
	
	public Student(){
		age=20;
		grade=1;
		name="NoName";
	}
	
	public boolean setStudent(){
		age=20;
		grade=1;
		name="NoName";
		return true;
	}
	
	public boolean setStudent(int g){
		age=20;
		grade=g;
		name="NoName";
		return true;
	}
	
	public boolean setStudent(int a,int g,String n){
		age=a;
		grade=g;
		name=n;
		return true;
	}
	
	public Student(int a,int g,String n){
		age=a;
		grade=g;
		name=n;
	}
	
	public boolean setGrade(int g){
		grade=g;
		return true;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public boolean setName(String n){
		name=n;
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
}