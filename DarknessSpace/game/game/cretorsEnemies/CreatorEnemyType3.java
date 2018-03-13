package game.cretorsEnemies;

import game.Ship;
import game.enemies.EnemyType3;
import game.fields.GameField;

import java.util.LinkedList;
import java.util.List;

public class CreatorEnemyType3 extends Ship
{
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private static final int width = 2;
	private static final int height = 2;
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Ќужно, чтобы метод генерации не запускалс€ сразу "на старте" игры.
	public CreatorEnemyType3(int x, int y, int speed) 
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
	public List<EnemyType3> createEnemyType3Straight_Level_1()
	{
		List<EnemyType3> enemies = new LinkedList<EnemyType3>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -850) //-4800
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
					timeout = 20000;
					EnemyType3 enemy = new EnemyType3(getX(), getY(), 250, 4, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType3().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType3> createEnemyType3CrossedFromRight_Level_1()
	{
		List<EnemyType3> enemies = new LinkedList<EnemyType3>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -900) //-5200
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
					timeout = 25000; //45000
					EnemyType3 enemy = new EnemyType3(getX(), getY(), 150, 5, 1);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType3().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType3> createEnemyType3CrossedFromLeft_Level_1()
	{
		List<EnemyType3> enemies = new LinkedList<EnemyType3>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -950) //-5300
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
					timeout = 15000; //30000
					EnemyType3 enemy = new EnemyType3(getX(), getY(), 150, 5, 1);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType3().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	/////////LEVEL2/////////////////
	public List<EnemyType3> createEnemyType3Straight_Level_2()
	{
		List<EnemyType3> enemies = new LinkedList<EnemyType3>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -550) //-4800
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
					timeout = 10000;
					EnemyType3 enemy = new EnemyType3(getX(), getY(), 200, 6, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType3().addAll(enemies);
				}
			}
		}
		return enemies;
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
	public void move900_700onX()
	{
		int dx = getDx();
		if(getX() >= 900)
		{
			dx = -speed;
		}
		if(getX() <= 700)
		{
			dx = speed;
		}
		setDx(dx);
		super.move(1);
	}
	public void move300_100onX()
	{
		int dx = getDx();
		if(getX() >= 300)
		{
			dx = -speed;
		}
		if(getX() <= 100)
		{
			dx = speed;
		}
		setDx(dx);
		super.move(1);
	}
}
