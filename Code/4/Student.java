public class Student{
	public int grade;
	public String name;
	
	public Student(){
		grade=1;
		name="NoName";
	}
	
	public Student(int g,String n){
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
}