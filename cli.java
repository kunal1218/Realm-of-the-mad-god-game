package Realmofthemadgod;

//import java.awt.Window;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import apcs.Window;

	public class cli{ 
		int port = 1342;
		String number;
		String temp;
		
		public cli(Realmofthemadgod cli) throws UnknownHostException, IOException {
		
		
		
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("127.0.0.1",port);
		System.out.println(s);
		
		Scanner sc1 = new Scanner(s.getInputStream());
		

		
		while(true){
		System.out.println("Chat:");
		number = sc.nextLine();
	
		PrintStream p = new PrintStream(s.getOutputStream());
		
		p.println(number);
		
		temp = number;
		
		System.out.println(temp);
		Window.out.color("black");
		Window.out.print(temp,1,100);
		}
	}
}