package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconDualGun extends PaintIcon
{
	public IconDualGun(int x, int y)
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawRect(getX() - 20, getY(), 26, 16);
		g.drawRect(getX() - 15, getY() + 5, 16, 6);
		g.drawLine(getX() - 20, getY(), getX() - 15, getY() + 5);
		g.drawLine(getX() + 6, getY(), getX() + 2, getY() + 4);
		g.drawLine(getX() - 20, getY() + 16, getX() - 15, getY() + 11);
		g.drawLine(getX() + 6, getY() + 16, getX() + 2, getY() + 12);
		g.drawRect(getX() + 6, getY() + 3, 28, 2);		
		g.drawRect(getX() + 6, getY() + 10, 28, 2);
		g.drawRect(getX() + 17, getY() + 5, 2, 5);
		g.drawRect(getX() + 34, getY() + 2, 2, 4);
		g.drawRect(getX() + 34, getY() + 9, 2, 4);
	}
	public void paintAvailableIcon(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.drawRect(getX() - 20, getY(), 26, 16);
		g.drawRect(getX() - 15, getY() + 5, 16, 6);
		g.drawLine(getX() - 20, getY(), getX() - 15, getY() + 5);
		g.drawLine(getX() + 6, getY(), getX() + 2, getY() + 4);
		g.drawLine(getX() - 20, getY() + 16, getX() - 15, getY() + 11);
		g.drawLine(getX() + 6, getY() + 16, getX() + 2, getY() + 12);
		g.drawRect(getX() + 6, getY() + 3, 28, 2);		
		g.drawRect(getX() + 6, getY() + 10, 28, 2);
		g.drawRect(getX() + 17, getY() + 5, 2, 5);
		g.drawRect(getX() + 34, getY() + 2, 2, 4);
		g.drawRect(getX() + 34, getY() + 9, 2, 4);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Ripper Mk. 2"), getX() - 30, getY() - 15);
	}
}
