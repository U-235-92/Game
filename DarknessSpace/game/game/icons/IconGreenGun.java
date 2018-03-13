package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconGreenGun extends PaintIcon
{
	public IconGreenGun(int x, int y)
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g)
	{
		
	}
	public void paintAvailableIcon(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawRect(getX() - 16, getY(), 26, 16);
		g.drawRect(getX() - 11, getY() + 5, 16, 6);
		g.drawLine(getX() - 16, getY(), getX() - 11, getY() + 5);
		g.drawLine(getX() + 10, getY(), getX() + 5, getY() + 5);
		g.drawLine(getX() - 16, getY() + 16, getX() - 11, getY() + 11);
		g.drawLine(getX() + 10, getY() + 16, getX() + 5, getY() + 11);
		g.drawRect(getX() + 10, getY() + 7, 25, 3);		
		g.drawRect(getX() + 30, getY() + 5, 5, 7);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Ripper Mk. 1"), getX() - 30, getY() - 15);
	}
}
