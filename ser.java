package Realmofthemadgod;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import apcs.Window;

public class ser {

	public static void main(String args[]) throws IOException
	{
		String number,temp;
		
		ServerSocket s1 = new ServerSocket(1342);
		
		Socket ss= s1.accept();
		System.out.println(ss);
		
		Scanner sc = new Scanner(ss.getInputStream());

		number = sc.nextLine();
		
		temp = number;
		
		PrintStream p = new PrintStream(ss.getOutputStream());

		p.println(temp);
		
	
}}