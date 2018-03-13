package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class RedGunShoot extends Shoot
{
	public RedGunShoot(int x, int y) 
	{
		super(x, y, new Weapon(50, 1000, 0));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
