package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconVoidHunterGun extends PaintIcon
{
	public IconVoidHunterGun(int x, int y)
	{
		super(x, y);
	}
	public void paintNotAvailableIcon(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawOval(getX() - 5, getY(), 15, 15);
		g.drawLine(getX() + 2, getY() + 7, getX() + 5, getY() + 7); //1
		g.drawLine(getX() + 2, getY() + 7, getX() + 1, getY() + 7); //1
		g.drawLine(getX() + 5, getY() + 7, getX() + 5, getY() + 4); //2
		g.drawLine(getX() + 5, getY() + 7, getX() + 5, getY() + 10); //2
		g.drawLine(getX() + 1, getY() + 7, getX() + 1, getY() + 4); //2
		g.drawLine(getX() + 1, getY() + 7, getX() + 1, getY() + 10); //2
		g.drawLine(getX() + 3, getY() + 7, getX() + 3, getY() + 11); //2
		g.drawLine(getX() + 3, getY() + 7, getX() + 3, getY() + 3); //2
		g.drawLine(getX() + 5, getY() + 4, getX() + 9, getY() + 4); //3
		g.drawLine(getX() + 5, getY() + 10, getX() + 9, getY() + 10); //3
		g.drawLine(getX() + 1, getY() + 4, getX() - 3, getY() + 4); //3
		g.drawLine(getX() + 1, getY() + 10, getX() - 3, getY() + 10); //3
		g.drawLine(getX() + 3, getY() + 11, getX() + 5, getY() + 13); //3
		g.drawLine(getX() + 3, getY() + 11, getX() + 1, getY() + 13); //3
		g.drawLine(getX() + 3, getY() + 3, getX() + 5, getY() + 1); //3
		g.drawLine(getX() + 3, getY() + 3, getX() + 1, getY() + 1); //3
	}
	public void paintAvailableIcon(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawOval(getX() - 5, getY(), 15, 15);
		g.drawLine(getX() + 2, getY() + 7, getX() + 5, getY() + 7); //1
		g.drawLine(getX() + 2, getY() + 7, getX() + 1, getY() + 7); //1
		g.drawLine(getX() + 5, getY() + 7, getX() + 5, getY() + 4); //2
		g.drawLine(getX() + 5, getY() + 7, getX() + 5, getY() + 10); //2
		g.drawLine(getX() + 1, getY() + 7, getX() + 1, getY() + 4); //2
		g.drawLine(getX() + 1, getY() + 7, getX() + 1, getY() + 10); //2
		g.drawLine(getX() + 3, getY() + 7, getX() + 3, getY() + 11); //2
		g.drawLine(getX() + 3, getY() + 7, getX() + 3, getY() + 3); //2
		g.drawLine(getX() + 5, getY() + 4, getX() + 9, getY() + 4); //3
		g.drawLine(getX() + 5, getY() + 10, getX() + 9, getY() + 10); //3
		g.drawLine(getX() + 1, getY() + 4, getX() - 3, getY() + 4); //3
		g.drawLine(getX() + 1, getY() + 10, getX() - 3, getY() + 10); //3
		g.drawLine(getX() + 3, getY() + 11, getX() + 5, getY() + 13); //3
		g.drawLine(getX() + 3, getY() + 11, getX() + 1, getY() + 13); //3
		g.drawLine(getX() + 3, getY() + 3, getX() + 5, getY() + 1); //3
		g.drawLine(getX() + 3, getY() + 3, getX() + 1, getY() + 1); //3
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("  Void Hunter"), getX() - 33, getY() - 15);
		g.drawString(String.valueOf(getStatsPlayerField().getCountShootVoidHunter()), getX() - 40, getY() + 15);
	}
}
