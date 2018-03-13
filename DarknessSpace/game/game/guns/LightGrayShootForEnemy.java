package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class LightGrayShootForEnemy extends Shoot
{
	public LightGrayShootForEnemy(int x, int y)
	{
		super(x, y, new Weapon(30, 1000, 0));
	}
	public void paintShoot(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(getX(), getY(), getX(), getY() + 15); 
	}
}
