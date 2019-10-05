import java.util.*;
import java.util.Scanner;

public class StringToken{ 
    public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
        String str;
		str=keyin.nextLine();
        StringTokenizer st1=new StringTokenizer(str,"%|abcdefghijklmnopqrstuvwxyz");
        while(st1.hasMoreTokens()) { 
            System.out.println(st1.nextToken());
        }
    }
} 