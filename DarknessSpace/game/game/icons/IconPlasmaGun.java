package game.icons;

import java.awt.Color;
import java.awt.Graphics;

public class IconPlasmaGun extends PaintIcon
{
	public IconPlasmaGun(int x, int y) 
	{
		super(x, y);
	}

	@Override
	public void paintNotAvailableIcon(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawLine(getX() - 48, getY() - 38, getX() + 55, getY() + 22);
		g.drawLine(getX() + 55, getY() - 38, getX() - 48, getY() + 22);
		
		g.drawLine(getX() - 20, getY() + 8, getX() - 10, getY() + 16);
		g.drawLine(getX() - 20, getY() + 8, getX() - 10, getY());
		g.drawLine(getX() - 10, getY() + 16, getX() - 5, getY() + 16);
		g.drawLine(getX() - 10, getY(), getX() - 5, getY());
		g.drawLine(getX() - 5, getY() + 16, getX() - 5, getY());
		g.drawLine(getX() - 5, getY(), getX() + 30, getY());
		g.drawLine(getX() + 30, getY(), getX() + 28, getY() + 4);
		g.drawLine(getX() + 28, getY() + 4, getX(), getY() + 5);
		
		g.drawLine(getX() - 5, getY() + 16, getX() + 30, getY() + 16);
		g.drawLine(getX() + 30, getY() + 16, getX() + 28, getY() + 12);
		g.drawLine(getX() + 28, getY() + 12, getX(), getY() + 11);
		g.drawLine(getX(), getY() + 11, getX() + 5, getY() + 8);
		g.drawLine(getX(), getY() + 5, getX() + 5, getY() + 8);
		g.drawLine(getX(), getY() + 11, getX() - 20, getY() + 8);
		g.drawLine(getX(), getY() + 5, getX() - 20, getY() + 8);
	}
	public void paintAvailableIcon(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawLine(getX() - 20, getY() + 8, getX() - 10, getY() + 16);
		g.drawLine(getX() - 20, getY() + 8, getX() - 10, getY());
		g.drawLine(getX() - 10, getY() + 16, getX() - 5, getY() + 16);
		g.drawLine(getX() - 10, getY(), getX() - 5, getY());
		g.drawLine(getX() - 5, getY() + 16, getX() - 5, getY());
		g.drawLine(getX() - 5, getY(), getX() + 30, getY());
		g.drawLine(getX() + 30, getY(), getX() + 28, getY() + 4);
		g.drawLine(getX() + 28, getY() + 4, getX(), getY() + 5);
		
		g.drawLine(getX() - 5, getY() + 16, getX() + 30, getY() + 16);
		g.drawLine(getX() + 30, getY() + 16, getX() + 28, getY() + 12);
		g.drawLine(getX() + 28, getY() + 12, getX(), getY() + 11);
		g.drawLine(getX(), getY() + 11, getX() + 5, getY() + 8);
		g.drawLine(getX(), getY() + 5, getX() + 5, getY() + 8);
		g.drawLine(getX(), getY() + 11, getX() - 20, getY() + 8);
		g.drawLine(getX(), getY() + 5, getX() - 20, getY() + 8);
	}
	public void paintLabel(Graphics g) 
	{
		g.drawString(String.valueOf("Scorpion PG"), getX() - 30, getY() - 15);
	}
}
