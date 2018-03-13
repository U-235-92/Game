package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class PlasmaGunForEnemy extends Shoot
{
	public PlasmaGunForEnemy(int x, int y)
	{
		super(x, y, new Weapon(150, 1500, 2));
	}
	public void paintShoot(Graphics g)
	{	
		g.setColor(Color.BLUE);
		g.drawLine(getX(), getY(), getX(), getY() + 42); 
		g.drawLine(getX() - 5, getY() + 42, getX() + 5, getY() + 42);
		g.drawLine(getX() - 5, getY() + 38, getX() + 5, getY() + 46);
		g.drawLine(getX() - 5, getY() + 46, getX() + 5, getY() + 38);
	}
}
