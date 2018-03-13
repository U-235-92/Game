package game.bonuses;

import game.Ship;
import game.fields.GameField;

import java.awt.Graphics;

public abstract class Bonus extends Ship
{
	private GameField gameField;
	private int speed;
	private static final int width = 30;
	private static final int height = 55;
	public Bonus(int x, int y, int speed)
	{
		super(x, y, width, height);
		this.speed = speed;
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
	}
	public int getSpeed()
	{
		return speed;
	}
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	public void moveBonus()
	{
		int dy = getDy();
		dy = speed;
		setDy(dy);
		super.move(2);
	}
	public abstract void paintBonus(Graphics g);
}
