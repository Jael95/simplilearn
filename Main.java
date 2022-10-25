package Lockers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private int lockno;
	private String lockname;
	private int lockamt;
	
	Main(int lockno,String lockname,int lockamt){
		this.lockno = lockno;
		this.lockname = lockname;
		this.lockamt = lockamt;
	}
	
	public String toString() {
		return lockno+" "+lockname+" "+lockamt;
	}
	
	class Lockers{
		public static void main(String[] args) throws Exception {
			ArrayList<Main> al = new ArrayList<Main>();
			Scanner s = new Scanner(System.in);
			Scanner s1 = new Scanner(System.in);
			Scanner S2 = new Scanner(System.in);
			File file = new File("emp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(file));
			if(file.isFile())
			{
				ois = new ObjectInputStream(new FileInputStream(file));
			}
			int ch;
			do {
				System.out.println("1.Search");
				System.out.println("2.Insert");
				System.out.println("3.Delete");
				System.out.println("4.Exit");
				System.out.println("Enter your choice");
				ch = s.nextInt();
				
				switch(ch) {
				case 1:
					System.out.println("Enter Lock Number: ");
					int lockno = s.nextInt();
					System.out.println("Enter Lock Name: ");
					String lockname = s1.nextLine();
					System.out.println("Enter Lock Amount");
					int lockamt = S2.nextInt();				
					al.add(new Main(lockno,lockname,lockamt));
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					break;
				}
			}
			while(ch!=0);
			{
				
			}
		}
		
	}
}


