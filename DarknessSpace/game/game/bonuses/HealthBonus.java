package game.bonuses;

import java.awt.Color;
import java.awt.Graphics;

public class HealthBonus extends Bonus
{
	public HealthBonus(int x, int y, int speed) 
	{
		super(x, y, speed);
	}
	public void paintBonus(Graphics g) 
	{
	}	
	public void paintAnimation1(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.GREEN);
		g.drawOval(getX() - 6, getY() - 18, 12, 12);
	}
	public void paintAnimation2(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);	
		g.setColor(Color.MAGENTA);
		g.drawOval(getX() - 6, getY() - 18, 12, 12);
	}
	public void paintAnimation3(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.GREEN);
		g.drawOval(getX() - 6, getY() - 18, 12, 12);
	}
	public void paintAnimation4(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.MAGENTA);
		g.drawOval(getX() - 6, getY() - 18, 12, 12);
	}
}
