package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class Machinegun extends Shoot
{
	public Machinegun(int x, int y)
	{
		super(x, y, new Weapon(25, 100, 1));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY(), getX(), getY() + 3);
	}
}
