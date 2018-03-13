package game.creatorsBonuses;

import java.util.LinkedList;
import java.util.List;

import game.Ship;
import game.bonuses.RepairBonus;
import game.fields.GameField;

public class CreatorRepairBonus extends Ship
{
	private long lastCreate;
	private int timeout;
	private int speed;
	private static int width;
	private static int height;
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private GameField gameField;
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Ќужно, чтобы метод генерации не запускалс€ сразу "на старте" игры.
	public CreatorRepairBonus(int x, int y, int speed)
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
	public List<RepairBonus> createRepairBonus()
	{
		List<RepairBonus> bonuses = new LinkedList<RepairBonus>();
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
					timeout = 15000;
					RepairBonus bonus = new RepairBonus(getX(), getY(), 6);
					bonuses.add(bonus);
					getGameFild().getRepairBonuses().addAll(bonuses);
				}
			}
		}
		return bonuses;
	}
	public List<RepairBonus> createRepairBonusLevel2()
	{
		List<RepairBonus> bonuses = new LinkedList<RepairBonus>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -50)
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
					timeout = 15000;
					RepairBonus bonus = new RepairBonus(getX(), getY(), 6);
					bonuses.add(bonus);
					getGameFild().getRepairBonuses().addAll(bonuses);
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
