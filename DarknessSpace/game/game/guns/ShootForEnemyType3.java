package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class ShootForEnemyType3 extends Shoot
{
	public ShootForEnemyType3(int x, int y)
	{
		super(x, y, new Weapon(25, 500, 0));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.CYAN);
		g.drawLine(getX(), getY(), getX(), getY() + 15); 	
	}
}
