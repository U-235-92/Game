package game.guns;

import game.Shoot;
import game.Weapon;

import java.awt.Color;
import java.awt.Graphics;

public class ShootForRamEnemyType1 extends Shoot
{
	public ShootForRamEnemyType1(int x, int y) 
	{
		super(x, y, new Weapon(20, 2000, 0));
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY(), getX(), getY() + 10); 
	}
}
