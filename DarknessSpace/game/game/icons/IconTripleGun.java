package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconTripleGun extends PaintIcon
{

	public IconTripleGun(int x, int y)
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawLine(getX() - 10, getY() + 8, getX(), getY() + 16);
		g.drawLine(getX() - 10, getY() + 8, getX(), getY());
		
		g.drawLine(getX(), getY() + 16, getX() + 5, getY() + 16);
		g.drawLine(getX(), getY(), getX() + 5, getY());
		g.drawLine(getX() + 5, getY() + 16, getX() + 5, getY());
		
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY());
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY() + 16);
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY() + 8);
		
	}
	public void paintAvailableIcon(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.drawLine(getX() - 10, getY() + 8, getX(), getY() + 16);
		g.drawLine(getX() - 10, getY() + 8, getX(), getY());
		
		g.drawLine(getX(), getY() + 16, getX() + 5, getY() + 16);
		g.drawLine(getX(), getY(), getX() + 5, getY());
		g.drawLine(getX() + 5, getY() + 16, getX() + 5, getY());
		
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY());
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY() + 16);
		g.drawLine(getX() + 5, getY() + 8, getX() + 25, getY() + 8);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Trident G-3"), getX() - 25, getY() - 15);
	}
}
