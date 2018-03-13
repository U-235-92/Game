package game.guns;

import java.awt.Color;
import java.awt.Graphics;

import game.Shoot;
import game.Weapon;

public class DualGreenShoot extends Shoot
{
	public DualGreenShoot(int x, int y) 
	{
		super(x, y, new Weapon(100, 500, 0));
	}
	public void paintShoot(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawOval(getX(), getY(), getWidth(), getHeight());	
	}
}
