package game.bonuses;

import java.awt.Color;
import java.awt.Graphics;

public class ShootBonus extends Bonus
{

	public ShootBonus(int x, int y, int speed) 
	{
		super(x, y, speed);
	}
	public void paintBonus(Graphics g)
	{
	}
	public void paintAnimationShootBonus1_1(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);
	}
	public void paintAnimationShootBonus1_2(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.WHITE);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);
	}
	public void paintAnimationShootBonus1_3(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.WHITE);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);
	}
}
