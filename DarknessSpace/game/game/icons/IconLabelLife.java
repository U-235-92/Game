package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconLabelLife extends PaintIcon
{
	public IconLabelLife(int x, int y)
	{
		super(x, y);
	}
	public void paintAvailableIcon(Graphics g) 
	{
	}
	public void paintNotAvailableIcon(Graphics g)
	{
	}
	public void paintLabel(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawString(String.valueOf("LIFE:"), getX() - 17, getY() - 25);
	}
	public void paintLive(Graphics g)
	{
		g.setColor(Color.RED);
		if(getStatsPlayerField().getCountLifesPlayer() == 5)
		{
			g.drawLine(getX() - 33, getY() - 20, getX() - 28, getY() - 10);
			g.drawLine(getX() - 28, getY() - 10, getX() - 38, getY() - 10);
			g.drawLine(getX() - 38, getY() - 10, getX() - 33, getY() - 20);
			
			g.drawLine(getX() - 18, getY() - 20, getX() - 13, getY() - 10);
			g.drawLine(getX() - 13, getY() - 10, getX() - 23, getY() - 10);
			g.drawLine(getX() - 23, getY() - 10, getX() - 18, getY() - 20);
			
			g.drawLine(getX() - 3, getY() - 20, getX() + 2, getY() - 10);
			g.drawLine(getX() + 2, getY() - 10, getX() - 8, getY() - 10);
			g.drawLine(getX() - 8, getY() - 10, getX() - 3, getY() - 20);
			
			g.drawLine(getX() + 12, getY() - 20, getX() + 17, getY() - 10);
			g.drawLine(getX() + 17, getY() - 10, getX() + 7, getY() - 10);
			g.drawLine(getX() + 7, getY() - 10, getX() + 12, getY() - 20);
			
			g.drawLine(getX() + 27, getY() - 20, getX() + 32, getY() - 10);
			g.drawLine(getX() + 32, getY() - 10, getX() + 22, getY() - 10);
			g.drawLine(getX() + 22, getY() - 10, getX() + 27, getY() - 20);
		}
		if(getStatsPlayerField().getCountLifesPlayer() == 4)
		{
			g.drawLine(getX() - 33, getY() - 20, getX() - 28, getY() - 10);
			g.drawLine(getX() - 28, getY() - 10, getX() - 38, getY() - 10);
			g.drawLine(getX() - 38, getY() - 10, getX() - 33, getY() - 20);
			
			g.drawLine(getX() - 18, getY() - 20, getX() - 13, getY() - 10);
			g.drawLine(getX() - 13, getY() - 10, getX() - 23, getY() - 10);
			g.drawLine(getX() - 23, getY() - 10, getX() - 18, getY() - 20);
			
			g.drawLine(getX() - 3, getY() - 20, getX() + 2, getY() - 10);
			g.drawLine(getX() + 2, getY() - 10, getX() - 8, getY() - 10);
			g.drawLine(getX() - 8, getY() - 10, getX() - 3, getY() - 20);
			
			g.drawLine(getX() + 12, getY() - 20, getX() + 17, getY() - 10);
			g.drawLine(getX() + 17, getY() - 10, getX() + 7, getY() - 10);
			g.drawLine(getX() + 7, getY() - 10, getX() + 12, getY() - 20);
		}
		if(getStatsPlayerField().getCountLifesPlayer() == 3)
		{
			g.drawLine(getX() - 33, getY() - 20, getX() - 28, getY() - 10);
			g.drawLine(getX() - 28, getY() - 10, getX() - 38, getY() - 10);
			g.drawLine(getX() - 38, getY() - 10, getX() - 33, getY() - 20);
			
			g.drawLine(getX() - 18, getY() - 20, getX() - 13, getY() - 10);
			g.drawLine(getX() - 13, getY() - 10, getX() - 23, getY() - 10);
			g.drawLine(getX() - 23, getY() - 10, getX() - 18, getY() - 20);
			
			g.drawLine(getX() - 3, getY() - 20, getX() + 2, getY() - 10);
			g.drawLine(getX() + 2, getY() - 10, getX() - 8, getY() - 10);
			g.drawLine(getX() - 8, getY() - 10, getX() - 3, getY() - 20);
		}
		if(getStatsPlayerField().getCountLifesPlayer() == 2)
		{
			g.drawLine(getX() - 33, getY() - 20, getX() - 28, getY() - 10);
			g.drawLine(getX() - 28, getY() - 10, getX() - 38, getY() - 10);
			g.drawLine(getX() - 38, getY() - 10, getX() - 33, getY() - 20);
			
			g.drawLine(getX() - 18, getY() - 20, getX() - 13, getY() - 10);
			g.drawLine(getX() - 13, getY() - 10, getX() - 23, getY() - 10);
			g.drawLine(getX() - 23, getY() - 10, getX() - 18, getY() - 20);
		}
		if(getStatsPlayerField().getCountLifesPlayer() == 1)
		{
			g.drawLine(getX() - 33, getY() - 20, getX() - 28, getY() - 10);
			g.drawLine(getX() - 28, getY() - 10, getX() - 38, getY() - 10);
			g.drawLine(getX() - 38, getY() - 10, getX() - 33, getY() - 20);
		}
	}
}
