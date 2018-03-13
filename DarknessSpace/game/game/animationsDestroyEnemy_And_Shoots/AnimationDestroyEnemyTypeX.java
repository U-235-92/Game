package game.animationsDestroyEnemy_And_Shoots;

import java.awt.Color;
import java.awt.Graphics;

public class AnimationDestroyEnemyTypeX extends AnimatoinDestroyedObject
{
	public AnimationDestroyEnemyTypeX(int x, int y) 
	{
		super(x, y);
	}
	public void paintAnimationDestroyOject(Graphics g) 
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);
	}
	public void paintAnimationDestroyCarrierEnemyType1_1(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 22);
		g.drawLine(getX(), getY() - 12, getX(), getY() - 2);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 10, getY() - 12, getX(), getY() - 12);
		g.drawLine(getX() + 10, getY() - 12, getX(), getY() - 12);
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 4);
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 12, getX() + 8, getY() - 20);
		g.drawLine(getX(), getY() - 12, getX() - 8, getY() - 4);
	}
	public void paintAnimationDestroyCarrierEnemyType1_2(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX(), getY() - 52, getX(), getY() - 62); //1
		g.drawLine(getX(), getY() - 52, getX(), getY() - 42); //2
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 10, getY() - 52, getX(), getY() - 52); //3
		g.drawLine(getX() + 10, getY() - 52, getX(), getY() - 52); //4
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 52, getX() - 8, getY() - 60); //5
		g.drawLine(getX(), getY() - 52, getX() + 8, getY() - 44); //6
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 52, getX() + 8, getY() - 60); //7
		g.drawLine(getX(), getY() - 52, getX() - 8, getY() - 44); //8
	}
	public void paintAnimationDestroyCarrierEnemyType1_3(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 65, getY() - 52, getX() - 65, getY() - 62);
		g.drawLine(getX() - 65, getY() - 52, getX() - 65, getY() - 42);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 75, getY() - 52, getX() - 65, getY() - 52);
		g.drawLine(getX() - 55, getY() - 52, getX() - 65, getY() - 52);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 65, getY() - 52, getX() - 67, getY() - 60);
		g.drawLine(getX() - 65, getY() - 52, getX() - 63, getY() - 44);
		g.setColor(Color.WHITE);
		g.drawLine(getX() - 65, getY() - 52, getX() - 63, getY() - 60);
		g.drawLine(getX() - 65, getY() - 52, getX() - 67, getY() - 44);
	}
	public void paintAnimationDestroyCarrierEnemyType1_4(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 65, getY() - 52, getX() + 65, getY() - 62);
		g.drawLine(getX() + 65, getY() - 52, getX() + 65, getY() - 42);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 75, getY() - 52, getX() + 65, getY() - 52);
		g.drawLine(getX() + 55, getY() - 52, getX() + 65, getY() - 52);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 65, getY() - 52, getX() + 63, getY() - 60);
		g.drawLine(getX() + 65, getY() - 52, getX() + 67, getY() - 44);
		g.setColor(Color.WHITE);
		g.drawLine(getX() + 65, getY() - 52, getX() + 67, getY() - 60);
		g.drawLine(getX() + 65, getY() - 52, getX() + 63, getY() - 44);
	}
	public void paintAnimationDestroyCarrierEnemyType1_5(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawLine(getX(), getY() - 72, getX(), getY() - 87);
		g.drawLine(getX(), getY() - 72, getX(), getY() - 57);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 15, getY() - 72, getX(), getY() - 72);
		g.drawLine(getX() + 15, getY() - 72, getX(), getY() - 72);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 72, getX() - 13, getY() - 85);///////
		g.drawLine(getX(), getY() - 72, getX() + 13, getY() - 59);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 72, getX() + 13, getY() - 85);
		g.drawLine(getX(), getY() - 72, getX() - 13, getY() - 59);
	}
}
