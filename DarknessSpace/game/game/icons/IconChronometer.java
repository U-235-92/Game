package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconChronometer extends PaintIcon
{
	public IconChronometer(int x, int y) 
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
		g.drawString(String.valueOf("STASIS:"),  getX() - 35, getY() - 25);
		if(getStatsPlayerField().isChronometerAvailable() == true)
		{
			g.setColor(Color.GREEN);
			g.drawString(String.valueOf("ON"),  getX() + 12, getY() - 25);
		}
		else if(getStatsPlayerField().isChronometerAvailable() == false)
		{
			g.setColor(Color.RED);
			g.drawString(String.valueOf("OFF"),  getX() + 12, getY() - 25);
		}
		if(getStatsPlayerField().isChronometerOn() == true)
		{
			g.setColor(Color.RED);
			g.drawString(String.valueOf(getStatsPlayerField().getIntervalWorkChronometer()),  getX() - 5, getY() - 12);
		}
	}
}
