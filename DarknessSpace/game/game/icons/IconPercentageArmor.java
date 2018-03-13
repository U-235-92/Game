package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconPercentageArmor extends PaintIcon
{
	public IconPercentageArmor(int x, int y) 
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
		g.drawString(String.valueOf("ARMOR:"), getX() - 25, getY() + 15);
		g.drawString(String.valueOf(getStatsPlayerField().getPercentageArmorPlayer() + "%"), getX() - 18, getY() + 30);
	}
}
