package game;

import game.fields.GameField;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background 
{
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int speed = 10;
	private GameField gameField;
	private Image background1;
	private Image background2;
	public Background(int x, int y)
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
	public GameField getGameFild()
	{
		return gameField;
	}
	public void setGameFild(GameField gameField)
	{
		this.gameField = gameField;
	}
	public void moveBackground1()
	{
		if(getGameFild().isChronometerActive() == true)
		{
			dy = speed / 2;
		}
		else
		{
			dy = speed;
		}
		y = y + dy;
		if(y >= getGameFild().getHeight())
		{
			y = 0;
		}
	}
	public void paintBackground1(Graphics g)
	{
		if(getGameFild().getCountLevels() == 1)//getGameFild().isEndLevel_1() ==  false
		{
			ImageIcon img = new ImageIcon("Images\\Backgrounds\\backgroundLevel1.jpg"); 
			background1 = img.getImage();
			g.drawImage(background1, x, y,
					getGameFild().getWidth(), getGameFild().getHeight(), null);
		}
		else if(getGameFild().getCountLevels() == 2)// && getGameFild().isChangeBackground() == true)
		{
			ImageIcon img = new ImageIcon("Images\\Backgrounds\\backgroundLevel2.jpg"); 
			background1 = img.getImage();
			g.drawImage(background1, x, y,
					getGameFild().getWidth(), getGameFild().getHeight(), null);
		}
	}
	public void paintBackground2(Graphics g)
	{
		if(getGameFild().getCountLevels() == 1)
		{
			ImageIcon img = new ImageIcon("Images\\Backgrounds\\backgroundLevel1.jpg"); 
			background2 = img.getImage();
			g.drawImage(background2, x, y - getGameFild().getHeight() + 0,
					getGameFild().getWidth(), getGameFild().getHeight(), null);
		}
		else if(getGameFild().getCountLevels() == 2)//&& getGameFild().isChangeBackground() == true)
		{
			ImageIcon img = new ImageIcon("Images\\Backgrounds\\backgroundLevel2.jpg"); 
			background2 = img.getImage();
			g.drawImage(background2, x, y - getGameFild().getHeight() + 0,
					getGameFild().getWidth(), getGameFild().getHeight(), null);
		}
	}
}
