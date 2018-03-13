package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class UnknownWeapon extends Shoot
{
	public UnknownWeapon(int x, int y) 
	{
		super(x, y, new Weapon(300, 1000, 3));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.GRAY);
		g.drawLine(getX() - 2550, getY(), getX() + 2550, getY());
	}
}
