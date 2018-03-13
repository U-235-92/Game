package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class RamEnemyType2 extends Enemy
{
	public RamEnemyType2(int x, int y, int armor, int speed, int idForMove) 
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
		enemy.moveTo(getX() + 5, getY() - 5);
		enemy.lineTo(getX() + 12, getY() - 20);
		enemy.lineTo(getX() + 14, getY() - 30);
		enemy.lineTo(getX() - 9, getY() - 30);
		enemy.lineTo(getX() - 7, getY() - 20);
		enemy.lineTo(getX(), getY() - 5);
		enemy.lineTo(getX() + 5, getY() - 5);
		g2d.fill(enemy);
		g.setColor(Color.RED);
		g.drawLine(getX() + 2, getY(), getX() + 9, getY() - 30);
		g.drawLine(getX() + 3, getY(), getX() - 4, getY() - 30);
		g.drawLine(getX() + 5, getY() - 5, getX() + 12, getY() - 20);
		g.drawLine(getX(), getY() - 5, getX() - 7, getY() - 20);
		g.drawLine(getX() + 12, getY() - 20, getX() + 14, getY() - 30);
		g.drawLine(getX() - 7, getY() - 20, getX() - 9, getY() - 30);
		g.drawLine(getX() + 14, getY() - 30, getX() + 9, getY() - 30);
		g.drawLine(getX() - 9, getY() - 30, getX() - 4, getY() - 30);
		g.drawLine(getX() + 9, getY() - 30, getX() - 5, getY() - 30);	
	}
}
