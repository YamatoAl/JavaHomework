import java.util.*;
import java.lang.*;

public class Book{
	
	private String name;
	private String author;
	private String press;
	private String number;
	private String classification;
	private int year;
	private int rate;
	public boolean exist=false;
	
	public Book(){
		this("","","","","",0);
		this.exist=false;
	}
	
	public Book(String n,String a,String p,String num,String c,int y){
		setName(n);
		setAuthor(a);
		setPress(p);
		setNumber(num);
		setClassification(c);
		setYear(y);
		this.exist=true;
	}
	
	public Book(String n,String a,String p,String num,String c,int y,int r){
		setName(n);
		setAuthor(a);
		setPress(p);
		setNumber(num);
		setClassification(c);
		setYear(y);
		setRate(r);
		this.exist=true;
	}
	
	public void setName(String n){
		if(n.trim().length()==0){
			this.name="Unknown Book";
		}
		else this.name=n;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAuthor(String a){
		if(a.trim().length()==0){
			this.author="Unknown Author";
		}
		else this.author=a;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setPress(String p){
		if(p.trim().length()==0){
			this.press="Unknown Press";
		}
		else this.press=p;
	}
	
	public String getPress(){
		return press;
	}
	
	public void setNumber(String num){
		if(num.trim().length()==0){
			this.number="Unknown Number";
		}
		else this.number=num;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setClassification(String c){
		if(c.trim().length()==0){
			this.classification="Unknown Classification";
		}
		else this.classification=c;
	}
	
	public String getClassification(){
		return classification;
	}
	
	public void setYear(int y){
		if(y<0 || y>9999){
			this.year=0;
		}
		else this.year=y;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setRate(int r){
		if(r==0){
			this.rate=0;
		}
		else if(r<1 || r>5){
			System.out.println("Books \""+name+"\" has wrong rate, reset to 0.");
			this.rate=0;
		}
		else this.rate=r;
	}
	
	public int getRate(){
		return rate;
	}
	
	public void simpleDisplay(boolean n,boolean a,boolean p,boolean num,boolean c,boolean y,boolean r){
		if(n)System.out.printf("%-10s",this.name);
		if(a)System.out.printf(" %-10s",this.author);
		if(p)System.out.printf(" %-10s",this.press);
		if(num)System.out.printf(" %-10s",this.number);
		if(c)System.out.printf(" %-15s ",this.classification);
		if(y)System.out.printf(" %4d ",this.year);
		if(r && this.rate>0)System.out.println(" "+this.rate);
		else if(r) System.out.println(" Not rated");
		else System.out.println("");
	}
	
	public void display(boolean n,boolean a,boolean p,boolean num,boolean c,boolean y,boolean r){
		if(n)System.out.println("Name: "+this.name);
		if(a)System.out.println("Author: "+this.author);
		if(p)System.out.println("Press: "+this.press);
		if(num)System.out.println("Number: "+this.number);
		if(c)System.out.println("Classification: "+this.classification);
		if(y)System.out.println("Publishing Year: "+this.year);
		if(r && this.rate>0)System.out.println("Rate: "+this.rate);
		else if(r) System.out.println("Rate: Not rated");
	}
	
	public void delete(){
		setName("");
		setAuthor("");
		setPress("");
		setNumber("");
		setClassification("");
		setYear(0);
		setRate(0);
		this.exist=false;
	}
	
	public String toString(){
		return(name+" "+author+" "+press+" "+number+" "+classification+" "+year+" "+rate);
	}
	
}