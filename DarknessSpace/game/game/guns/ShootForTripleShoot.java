package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class ShootForTripleShoot extends Shoot
{
	public ShootForTripleShoot(int x, int y)
	{
		super(x, y, new Weapon(50, 500, 1));
	}
	public void paintShoot(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
