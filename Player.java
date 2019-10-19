package Realmofthemadgod;
import java.util.ArrayList;
import apcs.Window;
public class Player {
	 static int x;
	 static int y;
	 static int Portal3y;
	 static int Portal2y;
	 static int Portal4y;
	 static int Portal3x;
	 static int Portal2x;
	 static int Portal4x;
	 static boolean Sprite1;
	 static boolean Sprite2;
	 static boolean Sprite3;
	 static boolean Sprite4;
	 static int Portal1x;
	 static int Portal1y;
	 static int playerhealth;
	
		
		public void draw(){
	if(playerhealth > 0) {
		if(Sprite1 == true){
			Window.out.image("Wizard.png", x, y);
		}
	}
					if(Sprite2 == true){
				if(playerhealth > 0) {

					Window.out.image("wizardback.png", x, y);

				}
			}
						if(playerhealth > 0) {

			Window.out.image("wizardright.png", x, y);
				}
			
		
				if(Sprite4 == true){
				if(playerhealth > 0) {

			Window.out.image("wizardleft.png", x, y);
				}}
				}
			/**
			 * Moves the player with the arrow keys.
			 * Uses the up, down, left, right arrow keys.
			 */
				public void move() {
				
						if(Window.key.pressed("a")){
								Portal3x = Portal3x + 5;
								Portal2x = Portal2x + 5;
						    	Portal1x = Portal1x + 5;
								Sprite3 = false;
								Sprite1 = false;
								Sprite2 = false;
								Sprite4 = true;
								}
					if (Window.key.pressed("w")) {
						Portal3y = Portal3y + 5;
						Portal2y = Portal2y + 5;
						Portal1y = Portal1y + 5;
						Sprite2 = true;
						Sprite1 = false;
						Sprite3 = false;
						Sprite4 = false;
					
					}
		
						if(Window.key.pressed("s")){
							Portal3y = Portal3y - 5;
							Portal2y = Portal2y - 5;
							Portal1y = Portal1y - 5;
							Sprite2 = false;
							Sprite1 = true;
							Sprite3 = false;
							Sprite4 = false;
						}
					if (Window.key.pressed("d")) {
							Portal3x = Portal3x - 5;
							Portal2x = Portal2x - 5;
							Portal1x = Portal1x - 5;
							Sprite3 = true;
							Sprite1 = false;
							Sprite2 = false;
							Sprite4 = false;
						}
					
				}
		}