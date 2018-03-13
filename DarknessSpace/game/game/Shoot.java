package game;

import game.fields.GameField;

import java.awt.Graphics;

public abstract class Shoot extends Ship
{
	private Weapon weapon;
	private Player player;
	private GameField gameField;
	private int count = 80; //время жизни снаряда 80
	private boolean isDestroy; //проверка жив ли снаряд или нет (нужно для счетчика жизни снаряда)
	public Shoot(int x, int y, Weapon weapon) 
	{
		super(x, y, 5, 5);
		this.weapon = weapon;
	}
	public Player getPlayer() 
	{
		return player;
	}
	public Weapon getWeapon() 
	{
		return weapon;
	}
	public void setWeapon(Weapon weapon) 
	{
		this.weapon = weapon;
	}
	public boolean isDestroy() 
	{
		return isDestroy;
	}
	public void setDestroy(boolean isDestroy) 
	{
		this.isDestroy = isDestroy;
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
		super.move(2);
		count--;
		if(count <= 0)
		{
			isDestroy = true;
		}
	}
	public abstract void paintShoot(Graphics g);
}
