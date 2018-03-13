package game.bonuses;

import java.awt.Color;
import java.awt.Graphics;

public class UnknownWeaponBonus extends Bonus
{
	public UnknownWeaponBonus(int x, int y, int speed) 
	{
		super(x, y, speed);
	}
	public void paintBonus(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
	}
	public void paintAnimation1(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 8, getY(), getX() + 8, getY() - 5);
		g.drawLine(getX() + 8, getY() + 16, getX() + 8, getY() + 21);
		g.drawLine(getX() + 16, getY() + 8, getX() + 21, getY() + 8);
		g.drawLine(getX(), getY() + 8, getX() - 5, getY() + 8);
	}
	public void paintAnimation2(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 8, getY() - 5, getX() + 12, getY() - 7);
		g.drawLine(getX() + 8, getY() + 21, getX() + 4, getY() + 23);
		g.drawLine(getX() + 21, getY() + 8, getX() + 23, getY() + 12);
		g.drawLine(getX() - 5, getY() + 8, getX() - 7, getY() + 4);
	}
	public void paintAnimation3(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 12, getY() - 7, getX() + 14, getY() - 11);
		g.drawLine(getX() + 4, getY() + 23, getX() + 2, getY() + 27);
		g.drawLine(getX() + 23, getY() + 12, getX() + 27, getY() + 14);
		g.drawLine(getX() - 7, getY() + 4, getX() - 11, getY() + 2);
	}
	public void paintAnimation4(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 12, getY() - 7, getX() + 8, getY() - 9);
		g.drawLine(getX() + 4, getY() + 23, getX() + 8, getY() + 25);
		g.drawLine(getX() + 23, getY() + 12, getX() + 25, getY() + 10);
		g.drawLine(getX() - 7, getY() + 4, getX() - 9, getY() + 8);
	}
	public void paintAnimation5(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 8, getY() - 2, getX() + 4, getY() - 7);
		g.drawLine(getX() + 8, getY() + 18, getX() + 12, getY() + 21);
		g.drawLine(getX() + 18, getY() + 8, getX() + 22, getY() + 4);
		g.drawLine(getX() - 2, getY() + 8, getX() - 5, getY() + 12);
	}
	public void paintAnimation6(Graphics g)
	{
		Color myColor = new Color(97, 115, 176);
		g.setColor(myColor);
		g.drawOval(getX(), getY(), 16, 16);
		Color myColor2 = new Color(181, 184, 177);
		g.setColor(myColor2);
		g.drawLine(getX() + 4, getY() - 7, getX() + 6, getY() - 11);
		g.drawLine(getX() + 12, getY() + 21, getX() + 11, getY() + 25);
		g.drawLine(getX() + 22, getY() + 4, getX() + 26, getY() + 6);
		g.drawLine(getX() - 5, getY() + 12, getX() - 9, getY() + 11);
	}
	public void paintAnimation7(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), 16, 16);
	}
	public void paintAnimation8(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), 16, 16);
	}
	public void paintAnimation9(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), 16, 16);
	}
}
