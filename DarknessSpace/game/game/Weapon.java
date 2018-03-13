package game;

public class Weapon 
{
	private final int damage;
	private final int rateFire;
	private int indicator; //нужно для различения типа оружия, необходимо, чтобы снаряд поражл цель
	public Weapon(int damage, int timeout, int indicator)
	{
		this.damage = damage;
		this.rateFire = timeout;
		this.indicator = indicator;
	}
	public int getDamage() 
	{
		return damage;
	}
	public int getRateFire() 
	{
		return rateFire;
	}
	public int getIndicator() 
	{
		return indicator;
	}
}
