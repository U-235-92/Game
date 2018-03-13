package game.guns;

import java.awt.Color;
import java.awt.Graphics;

import game.Shoot;
import game.Weapon;

public class ShootForCarrierType1 extends Shoot
{
	public ShootForCarrierType1(int x, int y) 
	{
		super(x, y, new Weapon(75, 1200, 0));
	}
	public void paintShoot(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY(), getX(), getY() + 15); 
	}
}
