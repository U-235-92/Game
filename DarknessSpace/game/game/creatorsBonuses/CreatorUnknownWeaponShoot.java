package game.creatorsBonuses;

import java.util.LinkedList;
import java.util.List;

import game.Ship;
import game.bonuses.UnknownWeaponBonus;
import game.fields.GameField;

public class CreatorUnknownWeaponShoot extends Ship
{
	private static final int width = 2;
	private static final int height = 2;
	private long lastCreate;
	private int timeout;
	private int speed;
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private GameField gameField;
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Ќужно, чтобы метод генерации не запускалс€ сразу "на старте" игры.
	public CreatorUnknownWeaponShoot(int x, int y, int speed) 
	{
		super(x, y, width, height);
		this.speed = speed;
	}
	public int getSpeed() 
	{
		return speed;
	}
	public void setSpeed(int speed)
	{
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
	public List<UnknownWeaponBonus> createUnknownWeaponBonus()
	{
		List<UnknownWeaponBonus> bonuses = new LinkedList<UnknownWeaponBonus>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -300)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				if(flagForStartCreate == true)
				{
					if(lastCreate + timeout > System.currentTimeMillis())
					{
						return null;
					}
					lastCreate = System.currentTimeMillis();
					timeout = 30000;
					UnknownWeaponBonus bonus = new UnknownWeaponBonus(getX(), getY(), 10);
					bonuses.add(bonus);
					getGameFild().getUnknownBonus().addAll(bonuses);
				}
			}
		}
		return bonuses;
	}
	public List<UnknownWeaponBonus> createUnknownWeaponBonusLevel2()
	{
		List<UnknownWeaponBonus> bonuses = new LinkedList<UnknownWeaponBonus>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -200)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				if(flagForStartCreate == true)
				{
					if(lastCreate + timeout > System.currentTimeMillis())
					{
						return null;
					}
					lastCreate = System.currentTimeMillis();
					timeout = 50000;
					UnknownWeaponBonus bonus = new UnknownWeaponBonus(getX(), getY(), 10);
					bonuses.add(bonus);
					getGameFild().getUnknownBonus().addAll(bonuses);
				}
			}
		}
		return bonuses;
	}
	public void move50_950onX()
	{
		int dx = getDx();
		if(getX() >= getGameFild().getWidth() - 50)
		{
			dx = -speed;
		}
		if(getX() <= 50)
		{
			dx = speed;
		}
		setDx(dx);
		super.move(1);
	}
}
