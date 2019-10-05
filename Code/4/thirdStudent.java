public class Student{
	public int age;
	public int grade;
	public String name;
	public String id;
	
	public Student(){
		age=20;
		grade=1;
		name="NoName";
		id="ACS001";
	}
	
	public Student(int a){
		age=a;
		grade=1;
		name="NoName";
		id="ACS001";
	}
	
	public Student(String n){
		age=20;
		grade=1;
		name=n;
		id="ACS001";
	}
	
	public Student(int a,int g,String n,String i){
		age=a;
		grade=g;
		name=n;
		id=i;
	}
}