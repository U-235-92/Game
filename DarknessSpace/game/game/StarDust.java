package game;

import game.fields.GameField;

import java.awt.Color;
import java.awt.Graphics;

public class StarDust extends Ship
{
	private GameField gameField; 
	private int speed = 8;
	public StarDust(int x, int y)
	{
		super(x, y, 1, 1);
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
	}
	public void move()
	{
//		for(Player player : getGameFild().getPlayers())
//		{
			int newX = getX();
			int newY = getY();
			int dx = getDx();
			int dy = getDy();
			newX = getX() + dx;
			newY = getY() + dy;
			dx = 0;
			dy = speed;//player.getSpeed()
			if(newY >= getGameFild().getHeight())
			{
				newY = 0;
			}
			setX(newX);
			setY(newY);
			setDx(dx);
			setDy(dy);
//		}
	}
	public void paintWhiteStarDust(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
	public void paintYellowStarDust(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
	public void paintRedStaeDust(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
	public void paintBlueStarDust(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
	public void paintOrangeStarDust(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
