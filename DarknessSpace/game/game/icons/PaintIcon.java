package game.icons;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import java.awt.Graphics;

public abstract class PaintIcon
{
	private int x;
	private int y;
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	public PaintIcon(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
	}
	public StatsPlayerField getStatsPlayerField() 
	{
		return statsPlayerField;
	}
	public void setStatsPlayerField(StatsPlayerField statsPlayerField) 
	{
		this.statsPlayerField = statsPlayerField;
	}
	public abstract void paintAvailableIcon(Graphics g);
	public abstract void paintNotAvailableIcon(Graphics g);
	public abstract void paintLabel(Graphics g);
}
