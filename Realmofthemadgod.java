// Code by Kunal Singh/////////////////////////////////////////////
// This is a beta copy of Realm of the Mad God i made//////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
package Realmofthemadgod;

import apcs.Window;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Realmofthemadgod.Bullet;
public class Realmofthemadgod {

	//Server Variables
	static int port = 1342; 
	static String number;
	static String temp;

	static String kunal = "Kunal";
	static int x = 470;
	static int y = 360;
	static int yy = 360;
	static int roll = 1;
	static int xx = 470;
	static boolean askname = true;
	static int speed = 8;
	static boolean gameover = false;
	static boolean Sprite1 = false;
	static boolean Sprite2 = false;
	static boolean Sprite3 = false;
	static boolean Sprite4 = true;
	static boolean inRange = false; 
	static boolean TouchingTopWall = false;
	static boolean TouchingTopWall2 = false;
	static int playerhealth = 250;
	static int Portal1x = 150;
	static int Portal1y = 250;
	static int Portal2x = 400;
	static int Portal2y = 150;
	static int Portal3x = 650;
	static int Portal3y = 250;
	static int sx = 20;
	static int sy = 1/4;
	static int p1x = 400;
	static int p1y = 450;
	static int carpety = 110;
	static int carpetx = 260;
	static int pHealth = 300;
	static int wall1x = -80;
	static int wall1y = 10;
	static int wall2x = 1020;
	static int wall2y = 10;
	static int TopWallx = 200;
	static int TopWally = 20;
	static int TopWall2x = 470;
	static int TopWall2y = 900;
	static boolean wander = true;
	static boolean touchingwall1 = false;
	static boolean bullethitpirate = false;
	static boolean pirateDead = false;
	static boolean EnterRealmScreen = false;
	static boolean bulletalive = true;
	static boolean rolled = false;
	static String lastChat1 = "";
	static String lastChat2 = "";
	static int dex = 5;
	static boolean TouchingLeftWall = false;
	static boolean TouchingRightWall = true;
	static int dmg = 20;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Pick a size

		Window.size(1000, 800);
		// Make variables to store what's in the world
		Realmofthemadgod my= new Realmofthemadgod();
		//	ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
		ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
		ArrayList<SpellBomb> SpellBombList = new ArrayList<SpellBomb>();
		ArrayList<PirateBullet> PirateBulletList = new ArrayList<PirateBullet>();
		ArrayList<cli> ClientList = new ArrayList<cli>();
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("127.0.0.1",port);
		System.out.println(s);

		Scanner sc1 = new Scanner(s.getInputStream());

		//	ArrayList<SStuff> StuffList = new ArrayList<SStuff>();
		//	ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
		int bulletTimer = 0;

		// Infinitely draw frames
		System.out.println("what's your name");
		System.out.println(kunal);

		while (true) {
			Window.frame();

			if(EnterRealmScreen == true){
				Window.out.background("tan");
				Window.out.image("sand.png", sx, sy-300);
				Window.out.image("sand.png", sx+325, sy-300);
				Window.out.image("sand.png", sx+650, sy-300);
				Window.out.image("sand.png", sx+977, sy-300);
				Window.out.image("sand.png", sx-327, sy-300);
				//
				Window.out.image("sand.png", sx-327, sy);
				Window.out.image("sand.png", sx-327, sy+199);
				Window.out.image("sand.png", sx-327, sy+499);
				///
				Window.out.image("sand.png", sx+977, sy);
				Window.out.image("sand.png", sx+977, sy+199);
				Window.out.image("sand.png", sx+977, sy+499);
				///
				Window.out.image("sand.png", sx+650, sy+499);
				Window.out.image("sand.png", sx+325, sy+499);
				Window.out.image("sand.png", sx, sy+499);
				///
				Window.out.image("sand.png", sx+650, sy+199);
				Window.out.image("sand.png", sx+325, sy+199);
				Window.out.image("sand.png", sx, sy+199);
				///
				Window.out.image("sand.png", sx+650, sy);
				Window.out.image("sand.png", sx+325,sy );
				Window.out.image("sand.png", sx, sy);
			}

			if(EnterRealmScreen == true){
				if(Window.key.pressed("d")){

					sx = sx - speed;
				}
				if(Window.key.pressed("a")){
					sx = sx + speed;	
				}
				if(Window.key.pressed("w")){
					sy = sy + speed;	
				}
				if(Window.key.pressed("s")){
					sy = sy - speed;	
				}
			}

			if(EnterRealmScreen == false){
				Window.out.image("nexuswood.png", -5, -5);
				Window.out.image("nexuswood.png", -5, 610);
				Window.out.image("nexuswood.png",785, -5);
				Window.out.image("nexuswood.png", 785, 610);
				Window.out.image("carpet.png", carpetx, carpety);

				Window.out.image("Copy of realmportal.png", Portal3x, Portal3y);
				Window.out.image("Copy of realmportal.png", Portal2x, Portal2y);
				Window.out.image("Copy of realmportal.png", Portal1x, Portal1y);

			}

			//Pirate 

			if (pHealth > 1) {

				Window.out.image("Pirate.png", p1x, p1y);

				Window.out.color("white");
				Window.out.fontSize(18);
				Window.out.print(pHealth, p1x+20, p1y+85);

			}

			//Pirate Attack

			if( x > p1x - 200 && x < p1x + 200 && y < p1y + 200 && y > p1y - 200){
				inRange = true;
			}
			else{
				inRange = false;

			}			

			Iterator <Bullet> it = bulletList.iterator();
			while (it.hasNext()){
				//	for (Bullet b : bulletList) {
				Bullet b = it.next();
				b.draw();
				b.move();
				//	b.delete();

				if (b.x > p1x-35 && b.x < p1x + 40 && b.y < p1y + 40 && b.y > p1y-30 ){
					pHealth = pHealth - dmg;

					it.remove();


					if(pHealth > 0){
						Window.out.color("red");
						Window.out.print("-" + dmg, p1x+20, p1y-5);
					}
				}
				if(b.x < 20 || b.x > 920 || b.y > 780 || b.y < 20){
					it.remove();
				}

				//	for(cli c : ClientList){
				//	c.cli();
				//}

				//		if (b.b1x > x && b.b1x < x + 63 && b.b1y < y + 70 && b.b1y > y ){
				//	 playerhealth =  playerhealth - 10;
				//		}

				//		if(inRange == true){
				//		b.PirateBullet();
				//	}

				//Window.out.print(b.dex, 825, 572);
			}
			//	for (SpellBomb s : SpellBombList) {

			//	s.draw();

			//Pirate Move

			if(wander == true){
				Window.rollDice(roll);
				if(inRange == false){
					if(roll == 1){
						p1x = p1x + 5;
					}
				}
			}
			if(p1x == p1x + 6){
				Window.rollDice(roll);

			}

			if(roll == 2){
				p1x = p1x - 5;
			}
			if(roll == 3){
				p1y = p1y + 5;
			}
			if(roll == 4){
				p1y = p1y - 5;
			}

			//Gameover

			if(playerhealth < 1){
				gameover = true;
			}
			if(gameover == true){


				Window.out.background("red");
				Window.out.color("white");
				Window.out.fontSize(80);
				Window.out.print("The Mad God got you!", 100, 300);
				Window.out.fontSize(40);
				Window.out.print("Click to reset", 380, 400);
			}

			//Reset

			if(Window.key.pressed("r")){
				if(EnterRealmScreen == true){
					EnterRealmScreen = false;
					playerhealth = 250;
					Portal1x = 150;
					Portal1y = 250;
					Portal2x = 400;
					Portal2y = 150;
					Portal3x = 650;
					Portal3y = 250;
					sx = 20;
					sy = 1/4;
					p1x = 400;
					p1y = 450;
					carpety = 110;
					carpetx = 260;
					pHealth = 300;
					wall1x = 1;
					wall1y = 10;
					wall2x = 990;
					wall2y = 10;
					TopWallx = 200;
					TopWally = 20;
					TopWall2x = 470;
					TopWall2y = 900;
				}
			}
			// draw and move everything

				if (Window.mouse.clicked() && bulletTimer <= 0) {

				Bullet newBullet = new Bullet(my);

				bulletList.add(newBullet);

				bulletTimer = 5;
			}

			bulletTimer = bulletTimer - 1;

			for (PirateBullet a : PirateBulletList) {
				a.draw();
				a.move();

			}


			if(EnterRealmScreen == false){
				Window.out.color("white");
				Window.out.rectangle(wall1x+ 10 ,wall1y+400 , 20, 1000);				
				Window.out.rectangle(wall2x , wall2y+400 , 20,1000);
				Window.out.rectangle(TopWallx+280, TopWally-100, 1080, 20);
				Window.out.rectangle(TopWall2x, TopWall2y, 1100, 20);
			}
			
			// item menu thing
			Window.out.image("capture.png", 750, 30);
			
			Window.out.color("grey");
			Window.out.fontSize(18);
			Window.out.print(speed + 7, 825, 572);

			Window.out.color("white");
			Window.out.print(kunal, 800, 300);

			if(playerhealth > 1){
				Window.out.color("white");
				Window.out.fontSize(18);
				Window.out.print(playerhealth, 860, 364);
			}
			//Loot menu
			if(Window.mouse.getX() > 760 && Window.mouse.getX() < 790 && Window.mouse.getY() > 470 && Window.mouse.getY() < 500){
			if(Window.mouse.clicked()){
			Window.out.image("Rotmg Menu.png", 770, 470);	
				}
			}
			else{
			Window.out.image("capture.png", 750, 30);
			}
				

			//Sprite

			if(playerhealth > 0) {
				if(Sprite2 == true){
					Window.out.image("wizardback.png", x, y);
				}
			}
			if(Sprite4 == true){
				if(playerhealth > 0) {
					Window.out.image("Wizard.png", x, y);
				}
			}

			if(playerhealth > 0) {
				if(Sprite1 == true){
					Window.out.image("wizardright.png", x, y);
				}
			}
			if(playerhealth > 0) {
				if(Sprite3 == true){
					Window.out.image("wizardleft.png", x, y);
				}

				//Chat

				Window.out.color("white");
				Window.out.rectangle(350, 780,700, 80);
				Window.out.color("black");
				Window.out.fontSize(18);
				Window.out.print("Chat:", 330, 755);
				Window.out.print(lastChat2,1,765);
				Window.out.print(lastChat1,1,785);

				//Portals

				if(x > Portal1x  &&  x + 70 < Portal1x + 85 && y + 73 > Portal1y - 17) {
					if(EnterRealmScreen == false){
						Window.out.color("white");
						Window.out.print("Beholder: press f to join", Portal1x-70, Portal1y-5);
					}
				}

				if(x + 70 > Portal1x  &&  x < Portal2x + 85 && y + 73 > Portal1y - 17 && y + 73 < Portal1y + 100) {

					if(Window.key.pressed("f")){
						EnterRealmScreen = true;
					}

				}
				if(x + 70 > Portal2x  &&  x < Portal2x + 85 && y + 73 > Portal2y - 17 &&  y + 73 < Portal2y + 100) {
					if(EnterRealmScreen == false){
						Window.out.color("white");
						Window.out.print("Medusa: press f to join", Portal2x-50, Portal2y-5);
					}
					if(x > Portal2x - 10  &&  x + 70 < Portal2x + 100 && y + 73 > Portal2y - 17) {
						if(Window.key.pressed("f")){
							EnterRealmScreen = true;
						}
					}

				}	
				if(x + 70 > Portal3x  &&  x < Portal3x + 85 && y + 73 > Portal3y - 17 &&  y + 73 < Portal3y + 100) {
					if(EnterRealmScreen == false){
						Window.out.color("white");

						Window.out.print("Djinn: press f to join", Portal3x-50, Portal3y-5);
					}
					if(x > Portal3x  &&  x + 70 < Portal3x + 85 && y + 73 > Portal3y - 17) {
						if(Window.key.pressed("f")){
							EnterRealmScreen = true;

						}
					}

				}

			}

			//Changes The Way the Wizard looks

			if(Window.key.pressed("s")){
				Sprite3 = false;					
				Sprite1 = false;
				Sprite2 = false;
				Sprite4 = true;

			}
			if(Window.key.pressed("w")){
				Sprite2 = true;
				Sprite1 = false;
				Sprite3 = false;
				Sprite4 = false;
			}

			if(Window.key.pressed("d")){
				Sprite2 = false;
				Sprite1 = true;
				Sprite3 = false;
				Sprite4 = false;
			}

			if(Window.key.pressed("a")){
				Sprite3 = true;
				Sprite1 = false;
				Sprite2 = false;
				Sprite4 = false;

			}


			if(Window.mouse.getY() > y){
				if(Window.mouse.clicked()){

					Sprite3 = false;					
					Sprite1 = false;
					Sprite2 = false;
					Sprite4 = true;
				}
			}
			if(Window.mouse.getY() < y){
				if(Window.mouse.clicked()){


					Sprite2 = true;
					Sprite1 = false;
					Sprite3 = false;
					Sprite4 = false;
				}
			}
			if(Window.mouse.getX() > x + 70 ){
				if(Window.mouse.clicked()){

					Sprite2 = false;
					Sprite1 = true;
					Sprite3 = false;
					Sprite4 = false;
				}
			}
			if(Window.mouse.getX() < x ){
				if(Window.mouse.clicked()){

					Sprite3 = true;
					Sprite1 = false;
					Sprite2 = false;
					Sprite4 = false;
				}
			}

			// LR Wall Collision
			if(x > wall1x + 25){
				TouchingLeftWall = false;
			}
			else{
				TouchingLeftWall = true;
			}
			if(x + 63 < wall2x - 20){
				TouchingRightWall = false;
			}
			else{
				TouchingRightWall = true;
			}

			//UD Wall Collision

			if(y < TopWally-80){
				TouchingTopWall = true;
			}
			else{
				TouchingTopWall = false;
			}

			if(y + 65 > TopWall2y-19){
				TouchingTopWall2 = true;
			}
			else{
				TouchingTopWall2 = false;
			}

			//Up
			if (Window.key.pressed("w")){
				if(EnterRealmScreen == false){
					if(TouchingTopWall == false){
						Portal3y = Portal3y + speed;
						Portal2y = Portal2y + speed;
						Portal1y = Portal1y + speed;
						carpety = carpety + speed;
						p1y = p1y + speed;
						TopWally = TopWally + speed;
						TopWall2y = TopWall2y + speed;
					}
				}
			}

			//Down
			if(Window.key.pressed("s")){
				if(TouchingTopWall2 == false){
					if(EnterRealmScreen == false){	
						Portal3y = Portal3y - speed;
						Portal2y = Portal2y - speed;
						Portal1y = Portal1y - speed;
						carpety = carpety - speed;
						p1y = p1y - speed;
						TopWally = TopWally - speed;
						TopWall2y = TopWall2y - speed;
					}
				}
			}

			//Left
			if(Window.key.pressed("a")){
				if(EnterRealmScreen == false){	
					if(TouchingLeftWall == false){

						Portal3x = Portal3x + speed;
						Portal2x = Portal2x + speed;
						Portal1x = Portal1x + speed;
						carpetx = carpetx + speed;
						TopWallx = TopWallx + speed;
						TopWall2x = TopWall2x + speed;
						wall2x = wall2x + speed;
						wall1x = wall1x + speed;
					}
				}
			}

			//Right
			if (Window.key.pressed("d")) {
				if(EnterRealmScreen == false){	
					if(TouchingRightWall == false){
						Portal3x = Portal3x - speed;
						Portal2x = Portal2x - speed;
						Portal1x = Portal1x - speed;
						carpetx = carpetx - speed;
						TopWallx = TopWallx - speed;
						TopWall2x = TopWall2x - speed;
						wall1x  = wall1x - speed;
						wall2x = wall2x - speed;
					}
				}
			}

			if(Window.key.pressed("a")){
				if(xx < 490){
					xx = xx + 5;
				}
			}
			else{
				xx = 470;
			}

			if(Window.key.pressed("s")){
				if(yy > 360){
					yy = yy - 5;

				}
			}
			if(Window.key.pressed("w")){
				if(yy < 390){
					yy = yy + 5;
				}
			}
			else{
				yy = 360;
			}

			if(Window.key.pressed("d")){
				if(xx > 0){
					xx = xx - 5;
				}
			}
			//Chat
			if(Window.key.pressed("t")){
				System.out.println("Chat:");
				number = sc.nextLine();

				PrintStream p = new PrintStream(s.getOutputStream());

				p.println(number);

				temp = number;

				lastChat2 = lastChat1;
				lastChat1 = temp;

				System.out.println(temp);


				//	Window.frame(5000);

			}

			if(Window.key.pressed("d")){

				p1x = p1x - speed;
			}
			if(Window.key.pressed("a")){

				p1x = p1x + speed;
			}
			if(Window.key.pressed("w")){
				p1y = p1y + speed;

			}
			if(Window.key.pressed("s")){
				p1y = p1y - speed;


			}
			// coordinate check
			
			Window.out.color("blue");
			Window.out.rectangle(795 , 470,5,5);
		}

	}

}