package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconUnknownGun extends PaintIcon
{
	public IconUnknownGun(int x, int y) 
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawLine(getX(), getY() + 8, getX() + 5, getY() + 13);
		g.drawLine(getX() + 5, getY() + 13, getX() + 10, getY() + 8);
		g.drawLine(getX() + 10, getY() + 8, getX() + 5, getY() + 3);
		g.drawLine(getX() + 5, getY() + 3, getX(), getY() + 8);
		
		g.drawLine(getX(), getY() + 8, getX() - 5, getY() + 8);
		g.drawLine(getX() + 5, getY() + 13, getX() + 5, getY() + 18);
		g.drawLine(getX() + 5, getY() + 3, getX() + 5, getY() - 2);
		g.drawLine(getX() + 10, getY() + 8, getX() + 15, getY() + 8);

	}
	public void paintAvailableIcon(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawLine(getX(), getY() + 8, getX() + 5, getY() + 13);
		g.drawLine(getX() + 5, getY() + 13, getX() + 10, getY() + 8);
		g.drawLine(getX() + 10, getY() + 8, getX() + 5, getY() + 3);
		g.drawLine(getX() + 5, getY() + 3, getX(), getY() + 8);
		
		g.drawLine(getX(), getY() + 8, getX() - 5, getY() + 8);
		g.drawLine(getX() + 5, getY() + 13, getX() + 5, getY() + 18);
		g.drawLine(getX() + 5, getY() + 3, getX() + 5, getY() - 2);
		g.drawLine(getX() + 10, getY() + 8, getX() + 15, getY() + 8);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Unknown"), getX() - 22, getY() - 15);
		g.drawString(String.valueOf(getStatsPlayerField().getCountShootUnknown()), getX() - 40, getY() + 15);
	}
}
