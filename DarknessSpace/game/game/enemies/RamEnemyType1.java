package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class RamEnemyType1 extends Enemy
{
	public RamEnemyType1(int x, int y, int armor, int speed, int idForMove) 
	{
		super(x, y, armor, speed, idForMove);
	}
	public void paintEnemy(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
		g2d.setPaint(Color.BLACK);
		GeneralPath enemy = new GeneralPath();
		enemy.moveTo(getX(), getY());
		enemy.lineTo(getX() + 10, getY() - 15);
		enemy.lineTo(getX() + 3, getY() - 25);
		enemy.lineTo(getX() - 3, getY() - 25);
		enemy.lineTo(getX() - 10, getY() - 15);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.RED);
		g.drawLine(getX(), getY(), getX() + 10, getY() - 15);
		g.drawLine(getX(), getY(), getX() - 10, getY() - 15);
		g.drawLine(getX() + 10, getY() - 15, getX() + 3, getY() - 25);
		g.drawLine(getX() - 10, getY() - 15, getX() - 3, getY() - 25);
		g.drawLine(getX() - 3, getY() - 25, getX() + 3, getY() - 25);
		g.drawLine(getX() - 3, getY() - 25, getX() - 6, getY() - 30);
		g.drawLine(getX() + 3, getY() - 25, getX() + 6, getY() - 30);
		g.drawLine(getX() - 6, getY() - 30, getX() - 6, getY() - 35);
		g.drawLine(getX() + 6, getY() - 30, getX() + 6, getY() - 35);
		g.drawLine(getX() - 6, getY() - 20, getX() - 12, getY() - 30);
		g.drawLine(getX() + 6, getY() - 20, getX() + 12, getY() - 30);
		g.drawLine(getX() - 12, getY() - 30, getX() - 12, getY() - 35);
		g.drawLine(getX() + 12, getY() - 30, getX() + 12, getY() - 35);
	}
	public void paintAnimationShootRamEnemyType1(Graphics g)
	{
		if(isShootRamEnemyType1() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.YELLOW);
			g.drawLine(getX(), getY() + 2, getX() + 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() - 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() + 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() - 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() + 5, getY() + 5);
			g.drawLine(getX(), getY() + 2, getX() - 5, getY() + 5);
		}
	}
}
