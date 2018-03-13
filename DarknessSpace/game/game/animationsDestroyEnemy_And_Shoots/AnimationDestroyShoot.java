package game.animationsDestroyEnemy_And_Shoots;

import java.awt.Color;
import java.awt.Graphics;

public class AnimationDestroyShoot extends AnimatoinDestroyedObject
{
	public AnimationDestroyShoot(int x, int y) 
	{
		super(x, y);
	}
	public void paintAnimationDestroyOject(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12,	getX(), getY() - 18);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 6);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 6, getY() - 12, getX(), getY() - 12);
		g.drawLine(getX() + 6, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() - 4, getY() - 16);
		g.drawLine(getX(), getY() - 12, getX() + 4, getY() - 8);
		g.setColor(Color.ORANGE);
		g.drawLine(getX(), getY() - 12, getX() + 4, getY() - 16);
		g.drawLine(getX(), getY() - 12, getX() - 4, getY() - 8);
	}
}
