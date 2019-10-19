
package Realmofthemadgod;

import apcs.Window;
import java.util.ArrayList;
public class Bullet {
	int bulletTimer = 0;
	int dx;
	int dy;
	int x;
	int y;
	int dex;

				public Bullet(Realmofthemadgod my) {
					x = my.xx;
					y = my.yy;
					dex = my.dex;
					dx = (Window.mouse.getX() - x) / 30; //- dex;
					dy = (Window.mouse.getY() - y) / 30; // - dex;
					
					// TODO: make the bullet speed more "normal"/realistic
					
					//if(dx < 5){
					//	dx = dx * 5;
					}
					//if (dx > 10) {
				//		dx = 15;
					//}
			//		if (dx < -10) {
				//		dx = -15;				
				//	}
			//		
				//	if (dy > 10) {
				//		dy = 15;
				//	}
				//	if (dy < -10) {
					//	dy = -15;
					//}
			//	}
				
				public void draw() {
					if(y < y + 50 && y > y - 50){
					Window.out.color("red");
					Window.out.circle(x + 30, y + 30, 5);
				}
			}	
				public void move() {
					x = x + dx;
					y = y + dy;
				}
			}		
					




