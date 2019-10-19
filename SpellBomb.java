package Realmofthemadgod;

import apcs.Window;

public class SpellBomb {


	public SpellBomb(Realmofthemadgod my) {



	}
	public void draw(){
		if(Window.key.pressed("space")){
			Window.out.color("red");
			Window.out.rectangle(Window.mouse.getX(), Window.mouse.getY(), 10, 1);
		}
	}
}