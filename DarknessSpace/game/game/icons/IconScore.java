package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconScore extends PaintIcon
{

	public IconScore(int x, int y) 
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
		g.drawString(String.valueOf("SCORE:"), getX() - 25, getY() + 15);
		g.drawString(String.valueOf(getStatsPlayerField().getScore()), getX() - 40, getY() + 30);
	}
}
