package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconMachineGun extends PaintIcon
{
	public IconMachineGun(int x, int y)
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawLine(getX() - 14, getY() + 4, getX() + 6, getY() + 4);
		g.drawLine(getX() - 14, getY() + 14, getX() + 6, getY() + 14);
		g.drawLine(getX() - 14, getY() + 4, getX() - 14, getY() + 14);
		g.drawLine(getX() + 6, getY() + 4, getX() + 4, getY() + 9);
		g.drawLine(getX() + 4, getY() + 9, getX() + 6, getY() + 14);
		g.drawLine(getX() + 6, getY() + 14, getX() + 8, getY() + 12);
		g.drawLine(getX() + 6, getY() + 4, getX() + 8, getY() + 6);
		g.drawLine(getX() + 8, getY() + 6, getX() + 8, getY() + 12);
		g.drawLine(getX() + 8, getY() + 12, getX() + 12, getY() + 12);
		g.drawLine(getX() + 8, getY() + 6, getX() + 12, getY() + 6);
		g.drawLine(getX() + 12, getY() + 12, getX() + 12, getY() + 6);
		g.drawLine(getX() + 12, getY() + 10, getX() + 34, getY() + 10);
		g.drawLine(getX() + 12, getY() + 8, getX() + 34, getY() + 8);
		g.drawLine(getX() + 34, getY() + 8, getX() + 34, getY() + 10);
		g.drawRect(getX() - 14, getY() + 8, 10, 6);
	}
	public void paintAvailableIcon(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.drawLine(getX() - 14, getY() + 4, getX() + 6, getY() + 4);
		g.drawLine(getX() - 14, getY() + 14, getX() + 6, getY() + 14);
		g.drawLine(getX() - 14, getY() + 4, getX() - 14, getY() + 14);
		g.drawLine(getX() + 6, getY() + 4, getX() + 4, getY() + 9);
		g.drawLine(getX() + 4, getY() + 9, getX() + 6, getY() + 14);
		g.drawLine(getX() + 6, getY() + 14, getX() + 8, getY() + 12);
		g.drawLine(getX() + 6, getY() + 4, getX() + 8, getY() + 6);
		g.drawLine(getX() + 8, getY() + 6, getX() + 8, getY() + 12);
		g.drawLine(getX() + 8, getY() + 12, getX() + 12, getY() + 12);
		g.drawLine(getX() + 8, getY() + 6, getX() + 12, getY() + 6);
		g.drawLine(getX() + 12, getY() + 12, getX() + 12, getY() + 6);
		g.drawLine(getX() + 12, getY() + 10, getX() + 34, getY() + 10);
		g.drawLine(getX() + 12, getY() + 8, getX() + 34, getY() + 8);
		g.drawLine(getX() + 34, getY() + 8, getX() + 34, getY() + 10);
		g.drawRect(getX() - 14, getY() + 8, 10, 6);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Storm M-30-1"), getX() - 30, getY() - 15);
		g.drawString(String.valueOf(getStatsPlayerField().getCountShootMashinegun()), getX() - 40, getY() + 5);
		g.drawString(String.valueOf(getStatsPlayerField().getCountShootMashinegun()), getX() - 40, getY() + 20);
	}
}
