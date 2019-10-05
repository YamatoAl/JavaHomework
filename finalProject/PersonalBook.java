import java.util.*;
import java.lang.*;
import java.io.*;

public class PersonalBook{
	
	private static final String FILEADDRESS="bookList.txt";
	private static final String WISHADDRESS="wishList.txt";
	private static final String ACCOUNT="cis";
	private static final String PASSWORD="1234";
	private static final int LISTSIZE=128;
	private static final int AUTHORSIZE=128;
	private static final int WISHSIZE=32;
	private static final int PAGESET=3;
	
	public static Book[] books = new Book[LISTSIZE];
	public static Book[] wishes = new Book[WISHSIZE];
	public static int countBooks=0;
	public static int countWishes=0;
	public static boolean[] disSet=new boolean[7];
	
	public static boolean login(){
		Scanner keyin=new Scanner(System.in);
		String tempA,tempP;
		System.out.println("Welcome to the Personal Book System");
		for(int t=0;;t++){
			System.out.println("");
			System.out.print("Account:");
			tempA=keyin.next();
			System.out.print("Password:");
			tempP=keyin.next();
			if(tempA.trim().equals(ACCOUNT) && tempP.trim().equals(PASSWORD)){
				System.out.println("Login success.");
				return true;
			}
			else if(t>3){
				System.out.println("Failed more than 5 times, system close.");
				return false;
			}
			else{
				System.out.println("Account or password is incorrect.");
				continue;
			}
		}
		
	}
	
	public static void disSetReset(){
		for(int i=0;i<=6;i++) disSet[i]=true;
	}
	
	public static void listRead() throws IOException{
		
		System.out.print("\nData loading");
		
		FileReader fr=new FileReader(FILEADDRESS);
		BufferedReader br=new BufferedReader(fr);
		String[] temp=new String[10];
		
		for(countBooks=0;br.ready();countBooks++){
			if(countBooks>=LISTSIZE){
				System.out.print("Error: Quantity of books in data are more than max size of system.");
				countBooks--;
				break;
			}
			
//			System.out.println(br.readLine());
			temp=br.readLine().split(" ");
			books[countBooks]=new Book(temp[0],temp[1],temp[2],temp[3],temp[4],Integer.parseInt(temp[5]),Integer.parseInt(temp[6]));
		}
//		System.out.println(countBooks);

		FileReader fr2=new FileReader(WISHADDRESS);
		BufferedReader br2=new BufferedReader(fr2);
		
		for(countWishes=0;br2.ready();countWishes++){
			if(countWishes>=WISHSIZE){
				System.out.print("Error: Quantity of wishes in data are more than max size of system.");
				countWishes--;
				break;
			}
			
//			System.out.println(br2.readLine());
			temp=br2.readLine().split(" ");
			wishes[countWishes]=new Book(temp[0],temp[1],temp[2],temp[3],temp[4],Integer.parseInt(temp[5]),Integer.parseInt(temp[6]));
		}
//		System.out.println(countWishes);
		
		System.out.println(" Complete.");
		return;
	}
	
	public static void save() throws IOException{
		FileWriter fw=new FileWriter(FILEADDRESS);
		FileWriter fw2=new FileWriter(WISHADDRESS);
		Scanner keyin=new Scanner(System.in);
		
		for(int i=0;i<countBooks;i++){
			if(books[i].exist)fw.write(books[i].toString()+"\r\n");
		}
		
		for(int i=0;i<countWishes;i++){
			if(wishes[i].exist)fw2.write(wishes[i].toString()+"\r\n");
		}
		
		fw.flush();
		fw.close();
		fw2.flush();
		fw2.close();
		
		System.out.println("\n--------------------");
		System.out.println("\nSave complete.");
		System.out.print("\n--------------------\n[Press enter to continue]");
		keyin.nextLine();
		
	}
	
	public static void listDisplay(){
		Scanner keyin=new Scanner(System.in);
		String tempOP;
		
		System.out.println("\n--------------------");
		System.out.println("\nDisplay option");
		System.out.println("\n(1)Display simple list");
		System.out.println("(2)Display detailed list");
		System.out.println("(3)Display by rate(higher to lower)");
		System.out.println("(4)Display by rate(lower to higher)");
		System.out.println("(5)Return to main menu");
		System.out.print("\nPlease enter option code:");
		
		switch(tempOP=keyin.nextLine().trim()){
				case "1":
					System.out.println("\n--------------------\n\nMy List\n");
					if(disSet[0])System.out.print("name      ");
					if(disSet[1])System.out.print(" author    ");
					if(disSet[2])System.out.print(" press     ");
					if(disSet[3])System.out.print(" number    ");
					if(disSet[4])System.out.print(" classification  ");
					if(disSet[5])System.out.print(" year ");
					if(disSet[6])System.out.println(" rate");
					else System.out.println("");
					for(int i=0;i<countBooks;i++){
						if(books[i].exist)books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
					}
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "2":
					for(int i=0;i<countBooks;i++){
						if(i%PAGESET==0)System.out.println("\n--------------------\n\nMy List (Page "+(i/PAGESET+1)+"/"+(countBooks/PAGESET+1)+")\n");
						System.out.println("\n("+(i+1)+")");
						if(books[i].exist)books[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						else System.out.println("Book is been deleted.");
						if(i==countBooks-1){
							System.out.print("\n--------------------\n[Press enter to continue]");
							keyin.nextLine();
						}
						else if(i%PAGESET==PAGESET-1){
							System.out.print("\n--------------------\n[Press enter to next page]");
							keyin.nextLine();
						}
					}
					break;
				case "3":
					System.out.println("\n--------------------\n\nMy List\n");
					if(disSet[0])System.out.print("name      ");
					if(disSet[1])System.out.print(" author    ");
					if(disSet[2])System.out.print(" press     ");
					if(disSet[3])System.out.print(" number    ");
					if(disSet[4])System.out.print(" classification  ");
					if(disSet[5])System.out.print(" year ");
					if(disSet[6])System.out.println(" rate");
					else System.out.println("");
					for(int i=5;i>=0;i--){
						for(int j=0;j<countBooks;j++){
							if(books[j].exist && books[j].getRate()==i){
								books[j].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
							}
						}
					}
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "4":
					System.out.println("\n--------------------\n\nMy List\n");
					if(disSet[0])System.out.print("name      ");
					if(disSet[1])System.out.print(" author    ");
					if(disSet[2])System.out.print(" press     ");
					if(disSet[3])System.out.print(" number    ");
					if(disSet[4])System.out.print(" classification  ");
					if(disSet[5])System.out.print(" year ");
					if(disSet[6])System.out.println(" rate");
					else System.out.println("");
					for(int i=0;i<=5;i++){
						for(int j=0;j<countBooks;j++){
							if(books[j].exist && books[j].getRate()==i){
								books[j].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
							}
						}
					}
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "5":
					return;
				default:
					System.out.println("Option \""+tempOP+"\" not found.");
			}
	}
	
	public static void bookSearch(){
		Scanner keyin=new Scanner(System.in);
		String tempOP;
		String tempIN;
		boolean printCheck=false;
		
		System.out.println("\n--------------------");
		System.out.println("\nSearch option");
		System.out.println("\n(1)Search by name");
		System.out.println("(2)Search by author");
		System.out.println("(3)Search by press");
		System.out.println("(4)Search by number");
		System.out.println("(5)Search by classification");
		System.out.println("(6)Search by year");
		System.out.println("(7)Return to main menu");
		System.out.print("\nPlease enter option code:");
		
		switch(tempOP=keyin.nextLine().trim()){
				case "1":
					System.out.print("\nInupt book name: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getName().toLowerCase().contains(tempIN.toLowerCase())){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nBook \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "2":
					System.out.print("\nInupt author name: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getAuthor().toLowerCase().contains(tempIN.toLowerCase())){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nAuthor \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "3":
					System.out.print("\nInupt press name: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getPress().toLowerCase().contains(tempIN.toLowerCase())){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nPress \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "4":
					System.out.print("\nInupt number: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getNumber().toLowerCase().contains(tempIN.toLowerCase())){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nNumber \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "5":
					System.out.print("\nInupt classification: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getClassification().toLowerCase().contains(tempIN.toLowerCase())){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nClassification \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "6":
					System.out.print("\nInupt published year: ");
					tempIN=keyin.nextLine();
					for(int i=0;i<countBooks;i++){
						if(books[i].exist && books[i].getYear()==Integer.parseInt(tempIN)){
							if(!printCheck){
								System.out.println("\n--------------------\n\nSearch Result\n");
								if(disSet[0])System.out.print("name      ");
								if(disSet[1])System.out.print(" author    ");
								if(disSet[2])System.out.print(" press     ");
								if(disSet[3])System.out.print(" number    ");
								if(disSet[4])System.out.print(" classification  ");
								if(disSet[5])System.out.print(" year ");
								if(disSet[6])System.out.println(" rate");
								else System.out.println("");
								printCheck=true;
							}
							books[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
						}
					}
					if(!printCheck)System.out.println("\n--------------------\n\nBook published in \""+tempIN+"\" not found.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					break;
				case "7":
					return;
				default:
					System.out.println("Option \""+tempOP+"\" not found.");
		}
	}
	
	public static void addBook(){
		Scanner keyin=new Scanner(System.in);
		String addName,addAuthor,addPress,addNumber,addClassification,addYear,addRate,tempIN;
		System.out.println("\n--------------------");
		if(countBooks>=LISTSIZE){
			System.out.println("\nList is full.");
			return;
		}
		System.out.print("\nInput new book name: ");
		addName=keyin.nextLine();
		System.out.print("\nInput new book author: ");
		addAuthor=keyin.nextLine();
		System.out.print("\nInput new book press: ");
		addPress=keyin.nextLine();
		System.out.print("\nInput new book number: ");
		addNumber=keyin.nextLine();
		System.out.print("\nInput new book classification: ");
		addClassification=keyin.nextLine();
		System.out.print("\nInput new book published year: ");
		addYear=keyin.nextLine();
		System.out.println("Book name: "+addName);
		System.out.println("Book author: "+addAuthor);
		System.out.println("Book press: "+addPress);
		System.out.println("Book number: "+addNumber);
		System.out.println("Classification: "+addClassification);
		System.out.println("Published year: "+addYear);
		for(;;){
			System.out.print("\nBe sure to add this book? [Y/N]: ");
			tempIN=keyin.nextLine().trim();
			if(tempIN.equalsIgnoreCase("Y")||tempIN.equalsIgnoreCase("YES")){
				books[countBooks]=new Book(addName,addAuthor,addPress,addNumber,addClassification,Integer.parseInt(addYear));
				books[countBooks].exist=true;
				countBooks++;
				System.out.print("\nAdd a rate for the new book? (Input 0 for not, 1~5 for the new rate): ");
				books[countBooks-1].setRate(Integer.parseInt(keyin.nextLine()));
				System.out.println("\nAdd success.");
//				save();
				System.out.print("\n--------------------\n[Press enter to continue]");
				keyin.nextLine();
				break;
			}
			else if(tempIN.equalsIgnoreCase("N")||tempIN.equalsIgnoreCase("NO")) return;
			else continue;
		}
	}
	
	public static void modifyBook(){
		Scanner keyin=new Scanner(System.in);
		String tempBN,tempIN,tempIN2,tempOP;
		System.out.println("\n--------------------");
		System.out.print("\nInput book name: ");
		tempBN=keyin.nextLine();
		for(int i=0;;i++){
			if(i>=countBooks){
				System.out.println("\nBook \""+tempBN+"\" not found.");
				return;
			}
			if(books[i].exist && books[i].getName().toLowerCase().contains(tempBN.toLowerCase())){
				System.out.println("");
				books[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nIs this the book you want to modify? [Y/N]: ");
				tempIN2=keyin.nextLine().trim();
				if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
					for(;;){
						System.out.println("\nWhich you want to modify?");
						System.out.println("\n(1)Name");
						System.out.println("(2)Author");
						System.out.println("(3)Press");
						System.out.println("(4)Number");
						System.out.println("(5)Classification");
						System.out.println("(6)Year");
						System.out.println("(7)Rate");
						System.out.println("(8)Return to menu");
						System.out.print("\nPlease enter option code:");
						switch(tempOP=keyin.nextLine().trim()){
							case "1":
								System.out.print("\nInput new name:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld name: "+books[i].getName());
								System.out.println("New name: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setName(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "2":
								System.out.print("\nInput new author:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld author: "+books[i].getAuthor());
								System.out.println("New author: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setAuthor(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "3":
								System.out.print("\nInput new press:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld press: "+books[i].getPress());
								System.out.println("New press: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setPress(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "4":
								System.out.print("\nInput new number:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld number: "+books[i].getNumber());
								System.out.println("New number: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setNumber(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "5":
								System.out.print("\nInput new classification:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld classification: "+books[i].getClassification());
								System.out.println("New classification: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setClassification(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "6":
								System.out.print("\nInput new published year:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld published year: "+books[i].getYear());
								System.out.println("New published year: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setYear(Integer.parseInt(tempIN));
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "7":
								System.out.print("\nInput new rate:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld rate: "+books[i].getRate());
								System.out.println("New rate: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									books[i].setRate(Integer.parseInt(tempIN));
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "8":
								return;
							default:
								System.out.println("Option \""+tempOP+"\" not found.");
						}
					}
				}
				else if(tempIN2.equalsIgnoreCase("N")||tempIN2.equalsIgnoreCase("NO")) continue;
				else continue;
			}
		}
	}
	
	public static void deleteBook(){
		Scanner keyin=new Scanner(System.in);
		String tempIN,tempIN2,tempOP;
		System.out.println("\n--------------------");
		System.out.print("\nInput book name: ");
		tempIN=keyin.nextLine();
		for(int i=0;;i++){
			if(i>=countBooks){
				System.out.println("\nBook \""+tempIN+"\" not found.");
				return;
			}
			if(books[i].exist && books[i].getName().toLowerCase().contains(tempIN.toLowerCase())){
				System.out.println("");
				books[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nIs this the book you want to delete? [Y/N]: ");
				tempIN2=keyin.nextLine().trim();
				if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
					books[i].delete();
//					save();
					System.out.println("\nDelete success.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					return;
				}
				else if(tempIN2.equalsIgnoreCase("N")||tempIN2.equalsIgnoreCase("NO")) continue;
				else continue;
			}
		}
	}
	
	public static void randomBook(){
		Scanner keyin=new Scanner(System.in);
		Random ran=new Random();
		String tempIN;
		int ranNum=0;
		boolean countCheck=false,exit=false;
		System.out.println("\n--------------------");
		for(int i=0;i<countBooks;i++){
			if(books[i].exist){
				countCheck=true;
				break;
			}
		}
		if(!countCheck){
			System.out.println("\nThere is no book in the list, add one first.");
			System.out.print("\n--------------------\n[Press enter to continue]");
			keyin.nextLine();
			return;
		}
		for(;!exit;){
			ranNum=ran.nextInt(countBooks);
			if(!books[ranNum].exist)continue;
			else{
				System.out.println("\nYour lucky book:\n");
				books[ranNum].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nGet another random book? [Y/N]: ");
				tempIN=keyin.nextLine().trim();
				if(tempIN.equalsIgnoreCase("Y")||tempIN.equalsIgnoreCase("YES"))continue;
				else return;
				
			}
		}
	}

	public static void wishDisplay(){
		Scanner keyin=new Scanner(System.in);
		System.out.println("\n--------------------\n\nWish List\n");
		if(disSet[0])System.out.print("name      ");
		if(disSet[1])System.out.print(" author    ");
		if(disSet[2])System.out.print(" press     ");
		if(disSet[3])System.out.print(" number    ");
		if(disSet[4])System.out.print(" classification  ");
		if(disSet[5])System.out.print(" year ");
		if(disSet[6])System.out.println(" rate");
		else System.out.println("");
		for(int i=0;i<countWishes;i++){
			if(wishes[i].exist)wishes[i].simpleDisplay(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
		}
		System.out.print("\n--------------------\n[Press enter to continue]");
		keyin.nextLine();
	}
	
	public static void wishReach(){
		Scanner keyin=new Scanner(System.in);
		String tempIN,tempIN2,tempOP;
		System.out.println("\n--------------------");
		System.out.print("\nInput wish book name: ");
		tempIN=keyin.nextLine();
		for(int i=0;;i++){
			if(i>=countWishes){
				System.out.println("\nWish \""+tempIN+"\" not found.");
				return;
			}
			if(wishes[i].exist && wishes[i].getName().toLowerCase().contains(tempIN.toLowerCase())){
				System.out.println("");
				wishes[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nSend this book to the main list? [Y/N]: ");
				tempIN2=keyin.nextLine().trim();
				if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
					if(countBooks>=LISTSIZE){
						System.out.println("\nList is full.");
						return;
					}
					books[countBooks]=new Book(wishes[i].getName(),wishes[i].getAuthor(),wishes[i].getPress(),wishes[i].getNumber(),wishes[i].getClassification(),wishes[i].getYear());
					books[countBooks].exist=true;
					countBooks++;
					wishes[i].delete();
//					save();
					System.out.println("\nComplete.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					return;
				}
				else if(tempIN2.equalsIgnoreCase("N")||tempIN2.equalsIgnoreCase("NO")) continue;
				else continue;
			}
		}
	}
	
	public static void addWish(){
		Scanner keyin=new Scanner(System.in);
		String addName,addAuthor,addPress,addNumber,addClassification,addYear,addRate,tempIN;
		System.out.println("\n--------------------");
		if(countWishes>=WISHSIZE){
			System.out.println("\nList is full.");
			return;
		}
		System.out.print("\n\nInput new wish name: ");
		addName=keyin.nextLine();
		System.out.print("\nInput new wish author: ");
		addAuthor=keyin.nextLine();
		System.out.print("\nInput new wish press: ");
		addPress=keyin.nextLine();
		System.out.print("\nInput new wish number: ");
		addNumber=keyin.nextLine();
		System.out.print("\nInput new wish classification: ");
		addClassification=keyin.nextLine();
		System.out.print("\nInput new wish published year: ");
		addYear=keyin.nextLine();
		System.out.println("Book name: "+addName);
		System.out.println("Book author: "+addAuthor);
		System.out.println("Book press: "+addPress);
		System.out.println("Book number: "+addNumber);
		System.out.println("Classification: "+addClassification);
		System.out.println("Published year: "+addYear);
		for(;;){
			System.out.print("\nBe sure to add this wish? [Y/N]: ");
			tempIN=keyin.nextLine().trim();
			if(tempIN.equalsIgnoreCase("Y")||tempIN.equalsIgnoreCase("YES")){
				wishes[countWishes]=new Book(addName,addAuthor,addPress,addNumber,addClassification,Integer.parseInt(addYear));
				wishes[countWishes].exist=true;
				countWishes++;
				System.out.print("\nAdd a rate for the new book? (Input 0 for not, 1~5 for the new rate): ");
				wishes[countWishes-1].setRate(Integer.parseInt(keyin.nextLine()));
				System.out.println("\nAdd success.");
//				save();
				System.out.print("\n--------------------\n[Press enter to continue]");
				keyin.nextLine();
				break;
			}
			else if(tempIN.equalsIgnoreCase("N")||tempIN.equalsIgnoreCase("NO")) return;
			else continue;
		}
	}
	
	public static void modifyWish(){
		Scanner keyin=new Scanner(System.in);
		String tempBN,tempIN,tempIN2,tempOP;
		System.out.println("\n--------------------");
		System.out.print("\nInput book name: ");
		tempBN=keyin.nextLine();
		for(int i=0;;i++){
			if(i>=countWishes){
				System.out.println("\nWish \""+tempBN+"\" not found.");
				return;
			}
			if(wishes[i].exist && wishes[i].getName().toLowerCase().contains(tempBN.toLowerCase())){
				System.out.println("");
				wishes[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nIs this the book you want to modify? [Y/N]: ");
				tempIN2=keyin.nextLine().trim();
				if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
					for(;;){
						System.out.println("\nWhich you want to modify?");
						System.out.println("\n(1)Name");
						System.out.println("(2)Author");
						System.out.println("(3)Press");
						System.out.println("(4)Number");
						System.out.println("(5)Classification");
						System.out.println("(6)Year");
						System.out.println("(7)Rate");
						System.out.println("(8)Return to menu");
						System.out.print("\nPlease enter option code:");
						switch(tempOP=keyin.nextLine().trim()){
							case "1":
								System.out.print("\nInput new name:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld name: "+wishes[i].getName());
								System.out.println("New name: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setName(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "2":
								System.out.print("\nInput new author:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld author: "+wishes[i].getAuthor());
								System.out.println("New author: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setAuthor(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "3":
								System.out.print("\nInput new press:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld press: "+wishes[i].getPress());
								System.out.println("New press: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setPress(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "4":
								System.out.print("\nInput new number:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld number: "+wishes[i].getNumber());
								System.out.println("New number: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setNumber(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "5":
								System.out.print("\nInput new classification:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld classification: "+wishes[i].getClassification());
								System.out.println("New classification: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setClassification(tempIN);
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "6":
								System.out.print("\nInput new published year:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld published year: "+wishes[i].getYear());
								System.out.println("New published year: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setYear(Integer.parseInt(tempIN));
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "7":
								System.out.print("\nInput new rate:");
								tempIN=keyin.nextLine();
								System.out.println("\nOld rate: "+wishes[i].getRate());
								System.out.println("New rate: "+tempIN);
								System.out.print("\nBe sure to modify? [Y/N]: ");
								tempIN2=keyin.nextLine().trim();
								if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
									wishes[i].setRate(Integer.parseInt(tempIN));
									System.out.println("\nModify success.");
//									save();									
								}
								else System.out.println("Modify cancel.");
								break;
							case "8":
								return;
							default:
								System.out.println("Option \""+tempOP+"\" not found.");
						}
					}
				}
				else if(tempIN2.equalsIgnoreCase("N")||tempIN2.equalsIgnoreCase("NO")) continue;
				else continue;
			}
		}
	}
	
	public static void deleteWish(){
		Scanner keyin=new Scanner(System.in);
		String tempIN,tempIN2,tempOP;
		System.out.println("\n--------------------");
		System.out.print("\nInput wish book name: ");
		tempIN=keyin.nextLine();
		for(int i=0;;i++){
			if(i>=countWishes){
				System.out.println("\nWish \""+tempIN+"\" not found.");
				return;
			}
			if(wishes[i].exist && wishes[i].getName().toLowerCase().contains(tempIN.toLowerCase())){
				System.out.println("");
				wishes[i].display(disSet[0],disSet[1],disSet[2],disSet[3],disSet[4],disSet[5],disSet[6]);
				System.out.print("\nIs this the wish you want to delete? [Y/N]: ");
				tempIN2=keyin.nextLine().trim();
				if(tempIN2.equalsIgnoreCase("Y")||tempIN2.equalsIgnoreCase("YES")){
					wishes[i].delete();
//					save();
					System.out.println("\nDelete success.");
					System.out.print("\n--------------------\n[Press enter to continue]");
					keyin.nextLine();
					return;
				}
				else if(tempIN2.equalsIgnoreCase("N")||tempIN2.equalsIgnoreCase("NO")) continue;
				else continue;
			}
		}
	}
	
	public static void wishListMenu(){
		Scanner keyin=new Scanner(System.in);
		boolean exit=false;
		String tempOP;
		for(;!exit;){
			System.out.println("\n--------------------");
			System.out.println("\nWish List Menu");
			System.out.println("\n(1)Display wish list");
			System.out.println("(2)Wish reached");
			System.out.println("(3)Add new wish");
			System.out.println("(4)Modify wish");
			System.out.println("(5)Delete wish");
			System.out.println("(6)Return to main menu");
			System.out.print("\nPlease enter option code:");
			
			switch(tempOP=keyin.nextLine().trim()){
				case "1":
					wishDisplay();
					break;
				case "2":
					wishReach();
					break;
				case "3":
					addWish();
					break;
				case "4":
					modifyWish();
					break;
				case "5":
					deleteWish();
					break;
				case "6":
					exit=true;
					break;
				default:
					System.out.println("Option \""+tempOP+"\" not found.");
			}
		}
		
		return;
	}
	
	public static void authorList(){
		Scanner keyin=new Scanner(System.in);
		boolean exit=false;
		String tempOP,tempIN,tempA;
		int tempW;
		String[] authors=new String[AUTHORSIZE];
		int[] works=new int[AUTHORSIZE];
		int countAuthors=0;
		boolean reCheck;
		System.out.println("\n--------------------");
		System.out.println("\nPrint from:");
		System.out.println("(1)More works to less works");
		System.out.println("(2)Less works to more works");
		System.out.println("(3)Cancel");
		System.out.print("\nPlease enter option code:");
		switch(tempOP=keyin.nextLine().trim()){
			case "1":
				for(int i=0;i<countBooks;i++){
					reCheck=false;
					for(int j=0;j<countAuthors;j++){
						if(authors[j].equals(books[i].getAuthor())){
							works[j]++;
							reCheck=true;
						}
					}
					if(!reCheck){
						authors[countAuthors]=books[i].getAuthor();
						works[countAuthors]=1;
						countAuthors++;
					}
				}
				for(int i=0,j;i<countAuthors;i++){
					tempA=authors[i];
					tempW=works[i];
					for(j=i-1;j>=0;j--){
						if(works[j]>tempW)break;
						else{
							authors[j+1]=authors[j];
							works[j+1]=works[j];
						}
					}
					authors[j+1]=tempA;
					works[j+1]=tempW;
				}
				System.out.println("\n--------------------\nAuthor List\n");
				System.out.println("Author     Works");
				for(int i=0;i<countAuthors;i++){
					System.out.printf("%-10s %d\n",authors[i],works[i]);
				}
				System.out.print("\n--------------------\n[Press enter to continue]");
				keyin.nextLine();
				break;
			case "2":
				for(int i=0;i<countBooks;i++){
					reCheck=false;
					for(int j=0;j<countAuthors;j++){
						if(authors[j].equals(books[i].getAuthor())){
							works[j]++;
							reCheck=true;
						}
					}
					if(!reCheck){
						authors[countAuthors]=books[i].getAuthor();
						works[countAuthors]=1;
						countAuthors++;
					}
				}
				for(int i=0,j;i<countAuthors;i++){
					tempA=authors[i];
					tempW=works[i];
					for(j=i-1;j>=0;j--){
						if(works[j]<tempW)break;
						else{
							authors[j+1]=authors[j];
							works[j+1]=works[j];
						}
					}
					authors[j+1]=tempA;
					works[j+1]=tempW;
				}
				System.out.println("\n--------------------\nAuthor List\n");
				System.out.println("Author     Works");
				for(int i=0;i<countAuthors;i++){
					System.out.printf("%-10s %d\n",authors[i],works[i]);
				}
				System.out.print("\n--------------------\n[Press enter to continue]");
				keyin.nextLine();
				break;
			case "3":
				return;
			default:
				System.out.println("Option \""+tempOP+"\" not found.");
		}
	}
	
	public static void settingMenu(){
		Scanner keyin=new Scanner(System.in);
		boolean exit=false;
		String tempOP,tempIN;
		for(;!exit;){
			System.out.println("\n--------------------");
			System.out.println("\nSetting");
			System.out.println("\n(1)Display setting");
			System.out.println("(2)Reload data");
			System.out.println("(3)Reset system");
			System.out.println("(4)Return to main menu");
			System.out.print("\nPlease enter option code:");
			
			switch(tempOP=keyin.nextLine().trim()){
				case "1":
					boolean exit2=false;
					for(;!exit2;){
						System.out.println("\n--------------------");
						System.out.println("\nDisplay Setting");
						System.out.print("\n(1)Name: ");
						if(disSet[0])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(2)Author: ");
						if(disSet[1])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(3)Press: ");
						if(disSet[2])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(4)Number: ");
						if(disSet[3])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(5)Classification: ");
						if(disSet[4])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(6)Published year: ");
						if(disSet[5])System.out.println("ON");
						else System.out.println("OFF");
						System.out.print("(7)Rate: ");
						if(disSet[6])System.out.println("ON");
						else System.out.println("OFF");
						System.out.println("\n(8)Reset display setting");
						System.out.print("\nEnter option code to change, enter 0 to return setting menu: ");
						switch(tempOP=keyin.nextLine().trim()){
							case "0":
								exit2=true;
								break;
							case "1":
							case "2":
							case "3":
							case "4":
							case "5":
							case "6":
							case "7":
								disSet[Integer.parseInt(tempOP)-1]=!disSet[Integer.parseInt(tempOP)-1];
								break;
							case "8":
								disSetReset();
								break;
							default:
								System.out.println("Option \""+tempOP+"\" not found.");
						}
					}
					break;
				case "2":
					try{
						listRead();
					}
					catch(IOException ex) {
						ex.printStackTrace();
					}
					break;
				case "3":
					System.out.println("\n--------------------");
					System.out.print("\nWaring! Can not restitution after system reset. Be sure to continue? [Y/N]: ");
					tempIN=keyin.nextLine().trim();
					if(tempIN.equalsIgnoreCase("Y")||tempIN.equalsIgnoreCase("YES")){
						System.out.print("Please enter \"RESET\" with uppercase for check: ");
						tempIN=keyin.nextLine().trim();
						if(tempIN.equals("RESET")){
							for(int i=0;i<countBooks;i++){
								books[i].delete();
							}
							countBooks=0;
							for(int i=0;i<countWishes;i++){
								wishes[i].delete();
							}
							countWishes=0;
							disSetReset();
							try{
								save();
							}
							catch(IOException ex) {
								ex.printStackTrace();
							}
							System.out.println("\nReset success.");
							System.out.print("\n--------------------\n[Press enter to continue]");
							keyin.nextLine();
							break;
						}
					}
					System.out.println("Reset cancel.");
					break;
				case "4":
					exit=true;
					break;
				default:
					System.out.println("Option \""+tempOP+"\" not found.");
			}
		}
	}
	
	public static void menu(){
		
		Scanner keyin=new Scanner(System.in);
		boolean exit=false;
		String tempOP;
		for(;!exit;){
			System.out.println("\n--------------------");
			System.out.println("\nMain Menu");
			System.out.println("\n(1)Display book list");
			System.out.println("(2)Search book");
			System.out.println("(3)Add new book");
			System.out.println("(4)Modify book");
			System.out.println("(5)Delete book");
			System.out.println("(6)Random book");
			System.out.println("(7)Wish list");
			System.out.println("(8)Author list");
			System.out.println("(9)Save data");
			System.out.println("(10)Setting");
			System.out.println("(11)Exit system");
			System.out.print("\nPlease enter option code:");
			
			switch(tempOP=keyin.nextLine().trim()){
				case "1":
					listDisplay();
					break;
				case "2":
					bookSearch();
					break;
				case "3":
					addBook();
					break;
				case "4":
					modifyBook();
					break;
				case "5":
					deleteBook();
					break;
				case "6":
					randomBook();
					break;
				case "7":
					wishListMenu();
					break;
				case "8":
					authorList();
					break;
				case "9":
					try{
						save();
					}
					catch(IOException ex) {
						ex.printStackTrace();
					}
					break;
				case "10":
					settingMenu();
					break;
				case "11":
					exit=true;
					break;
				default:
					System.out.println("Option \""+tempOP+"\" not found.");
			}
		}
		
		return;
	}
	
	public static void exitDisplay(){
		
		Scanner keyin=new Scanner(System.in);
		String tempIN;
		System.out.println("");
		
		for(;;){
			System.out.print("Do you want to save data before exit? [Y/N] :");
			tempIN=keyin.nextLine().trim();
			if(tempIN.equalsIgnoreCase("Y")||tempIN.equalsIgnoreCase("YES")){
				try{
					save();
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
				break;
			}
			else if(tempIN.equalsIgnoreCase("N")||tempIN.equalsIgnoreCase("NO")) break;
			else continue;
		}
		System.out.println("\nThanks for using Personal Book System.");
		System.out.println("See you next time.");
	}
	
	public static void main(String[] args) throws IOException{
		
		if(login()){
			try{
				listRead();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
			disSetReset();
			menu();
			exitDisplay();
		}
		
	}
}