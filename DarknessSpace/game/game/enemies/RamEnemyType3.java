package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class RamEnemyType3 extends Enemy
{
	public RamEnemyType3(int x, int y, int armor, int speed, int idForMove)
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
		enemy.lineTo(getX() + 10, getY() - 30);
		enemy.lineTo(getX(), getY() - 50);
		enemy.lineTo(getX() - 10, getY() - 30);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.RED);
		g.drawLine(getX(), getY(), getX() + 10, getY() - 30);
		g.drawLine(getX(), getY(), getX() - 10, getY() - 30);
		g.drawLine(getX() + 10, getY() - 30, getX(), getY() - 50);
		g.drawLine(getX() - 10, getY() - 30, getX(), getY() - 50);	
	}
}
