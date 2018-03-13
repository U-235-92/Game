package game.guns;

import game.Player;
import game.Shoot;
import game.Weapon;
import game.fields.GameField;

import java.awt.Color;
import java.awt.Graphics;

public class PlasmaGun extends Shoot
{
	private GameField fild;
	private Player player;
	public PlasmaGun(int x, int y)
	{
		super(x, y, new Weapon(200, 400, 2));
	}
	public GameField getFild()
	{
		return fild;
	}
	public Player getPlayer() 
	{
		return player;
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 2, getX(), getY() - 42); 
		g.drawLine(getX() - 5, getY() - 42, getX() + 5, getY() - 42);
		g.drawLine(getX() - 5, getY() - 38, getX() + 5, getY() - 46);
		g.drawLine(getX() - 5, getY() - 46, getX() + 5, getY() - 38);
	}
}
