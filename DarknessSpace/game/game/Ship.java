package game;

import game.fields.GameField;

public class Ship extends Square
{	
	private int dx;
	private int dy;
	private int width;
	private int height;
	private GameField gameField;
	public Ship(int x, int y, int width, int height) 
	{
		super(x, y);
		this.width = width;
		this.height = height;
	}
	public int getDx() 
	{
		return dx;
	}
	public void setDx(int dx)
	{
		this.dx = dx;
	}
	public int getDy() 
	{
		return dy;
	}
	public void setDy(int dy) 
	{
		this.dy = dy;
	}
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void move(int indicator) //0 - Player; 1 - Enemy; 
	{
		int newX = getX() + dx;
		int newY = getY() + dy;
		if(indicator == 0)  
		{
			if(getX() > getGameFild().getWidth() - width)
			{
				newX = getGameFild().getWidth() - width;
				dx = 0;
			}
			if (newX < width)
			{
				newX = width;
				dx = 0;
			}
			if (newY > getGameFild().getHeight() - height)
			{
				newY = getGameFild().getHeight() - height;
				dy = 0;
			}
			if (newY < 0)
			{
				newY = 0;
				dy = 0;
			}
		}
		setX(newX);
		setY(newY);
	}
}
