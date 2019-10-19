
package Realmofthemadgod;

import apcs.Window;
import java.util.ArrayList;

public class PirateBullet {
	int bulletTimer = 0;
	int dx;
	int dy;
	int x;
	int y;
	int xx;
	int dex;
	boolean inRange;

				public PirateBullet(Realmofthemadgod my) {
					x = my.p1x;
					y = my.p1y;
					xx = my.x;
					dex = 10;
					dx = x - xx;
					dy = y;	
					inRange = my.inRange;
					
				
				
				}
				public void draw() {
					if(inRange == true){
					Window.out.color("white");
					Window.out.circle(x + 30, y + 30, 5);
				}
			}
				public void move() {
					x = x + dx;
					y = y + dy;
				}

			}
					
					




