package game.cretorsEnemies;

import game.Ship;
import game.enemies.EnemyType4;
import game.fields.GameField;

import java.util.LinkedList;
import java.util.List;

public class CreatorEnemyType4 extends Ship
{
	private GameField gameField;
	private boolean flagForCreate = true; //флаг, регулирующий генерацию противников, если true - противники генерируются, наче нет.
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Нужно, чтобы метод генерации не запускался сразу "на старте" игры.
	private long lastCreate;
	private int timeout;
	private int speed;
	private int countCreatedEnemies = 0; //число созданных противников генератором.
	private int countReloadCreator = 0; //счетчик задержки между сгенерированными противниками (нужно, чтобы противники не генерировались друг за другом без остановки)
	private int maxCountCreatedEnemies;// = 5; //максимально возможное число сгенерированных противников
	private int maxDelayForReloadCreator;// = -500; //максимальное число задержки между генерациями противников
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private static final int width = 2;
	private static final int height = 2;
	public CreatorEnemyType4(int x, int y, int speed) 
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
	public List<EnemyType4> createEnemyType4StraightFromLeft_Level_1()
	{
		List<EnemyType4> enemies = new LinkedList<EnemyType4>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -1200) //-6600
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
					timeout = 4000;
					EnemyType4 enemy = new EnemyType4(getX(), getY(), 150, 8, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType4().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType4> createEnemyType4RouteFlightLeft_Level_1()
	{
		List<EnemyType4> enemies = new LinkedList<EnemyType4>();
		maxCountCreatedEnemies = 3;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -1350) //7000
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1600;
				if(flagForStartCreate == true)
				{
					countReloadCreator--;
					if(flagForCreate == false)
					{
						if(countReloadCreator <= maxDelayForReloadCreator)
						{
							flagForCreate = true;
							countReloadCreator = 0;
							countCreatedEnemies = 0;
						}
					}
					if(flagForCreate == true)
					{
						if(lastCreate + timeout > System.currentTimeMillis())
						{
							return null;
						}
						lastCreate = System.currentTimeMillis();
						timeout = 2200;
						EnemyType4 enemy = new EnemyType4(getX(), getY(), 150, 6, 5);
						enemy.setGameFild(gameField);
						enemies.add(enemy);
						if(countCreatedEnemies < maxCountCreatedEnemies)
						{
							countCreatedEnemies++;
						}
						if(countCreatedEnemies >= maxCountCreatedEnemies)
						{
							flagForCreate = false;
							countCreatedEnemies = countCreatedEnemies;
						}
						getGameFild().getEnemiesType4().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType4> createEnemyType4RouteFlightRight_Level_1()
	{
		List<EnemyType4> enemies = new LinkedList<EnemyType4>();
		maxCountCreatedEnemies = 3;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -1350) //7000
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1600;
				if(flagForStartCreate == true)
				{
					countReloadCreator--;
					if(flagForCreate == false)
					{
						if(countReloadCreator <= maxDelayForReloadCreator)
						{
							flagForCreate = true;
							countReloadCreator = 0;
							countCreatedEnemies = 0;
						}
					}
					if(flagForCreate == true)
					{
						if(lastCreate + timeout > System.currentTimeMillis())
						{
							return null;
						}
						lastCreate = System.currentTimeMillis();
						timeout = 2200;
						EnemyType4 enemy = new EnemyType4(getX(), getY(), 150, 6, 6);
						enemy.setGameFild(gameField);
						enemies.add(enemy);
						if(countCreatedEnemies < maxCountCreatedEnemies)
						{
							countCreatedEnemies++;
						}
						if(countCreatedEnemies >= maxCountCreatedEnemies)
						{
							flagForCreate = false;
							countCreatedEnemies = countCreatedEnemies;
						}
						getGameFild().getEnemiesType4().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	////////////////////LEVEL 2/////////////
	public List<EnemyType4> createEnemyType4StraightFromLeft_Level_2()
	{
		List<EnemyType4> enemies = new LinkedList<EnemyType4>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -800)
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
					timeout = 4000;
					EnemyType4 enemy = new EnemyType4(getX(), getY(), 150, 8, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType4().addAll(enemies);
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
}
