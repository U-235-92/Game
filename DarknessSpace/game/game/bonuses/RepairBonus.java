package game.bonuses;

import java.awt.Color;
import java.awt.Graphics;

public class RepairBonus extends Bonus
{
	public RepairBonus(int x, int y, int speed) 
	{
		super(x, y, speed);
	}
	public void paintBonus(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawRect(getX(), getY(), 7, 7);
		g.fillRect(getX(), getY(), 7, 7);
		g.setColor(Color.YELLOW);
		g.drawRect(getX() + 7, getY(), 7, 7);
		g.fillRect(getX() + 7, getY(), 7, 7);
		g.setColor(Color.RED);
		g.drawRect(getX() + 7, getY() + 7, 7, 7);
		g.fillRect(getX() + 7, getY() + 7, 7, 7);
		g.setColor(Color.YELLOW);
		g.drawRect(getX(), getY() + 7, 7, 7);
		g.fillRect(getX(), getY() + 7, 7, 7);
	}
	public void paintAnimation1(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawRect(getX(), getY(), 7, 7);
		g.fillRect(getX(), getY(), 7, 7);
		g.setColor(Color.RED);
		g.drawRect(getX() + 7, getY(), 7, 7);
		g.fillRect(getX() + 7, getY(), 7, 7);
		g.setColor(Color.YELLOW);
		g.drawRect(getX() + 7, getY() + 7, 7, 7);
		g.fillRect(getX() + 7, getY() + 7, 7, 7);
		g.setColor(Color.RED);
		g.drawRect(getX(), getY() + 7, 7, 7);
		g.fillRect(getX(), getY() + 7, 7, 7);
	}
	public void paintAnimation2(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawRect(getX(), getY(), 7, 7);
		g.fillRect(getX(), getY(), 7, 7);
		g.setColor(Color.YELLOW);
		g.drawRect(getX() + 7, getY(), 7, 7);
		g.fillRect(getX() + 7, getY(), 7, 7);
		g.setColor(Color.RED);
		g.drawRect(getX() + 7, getY() + 7, 7, 7);
		g.fillRect(getX() + 7, getY() + 7, 7, 7);
		g.setColor(Color.YELLOW);
		g.drawRect(getX(), getY() + 7, 7, 7);
		g.fillRect(getX(), getY() + 7, 7, 7);
	}
}
