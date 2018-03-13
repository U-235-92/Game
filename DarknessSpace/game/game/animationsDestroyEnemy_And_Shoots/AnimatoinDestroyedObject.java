package game.animationsDestroyEnemy_And_Shoots;

import game.Ship;
import game.fields.GameField;

import java.awt.Graphics;

public abstract class AnimatoinDestroyedObject extends Ship
{
	private GameField gameField;
	private static final int width = 30;
	private static final int height = 55;
	public AnimatoinDestroyedObject(int x, int y) 
	{
		super(x, y, width, height);
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
	}
	public abstract void paintAnimationDestroyOject(Graphics g);
}
