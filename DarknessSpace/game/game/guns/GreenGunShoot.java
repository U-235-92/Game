package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class GreenGunShoot extends Shoot
{
	public GreenGunShoot(int x, int y) 
	{
		super(x, y, new Weapon(50, 500, 0));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
