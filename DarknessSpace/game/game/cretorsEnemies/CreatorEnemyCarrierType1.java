package game.cretorsEnemies;

import java.util.LinkedList;
import java.util.List;

import game.Ship;
import game.enemies.CarrierEnemyType1;
import game.fields.GameField;

public class CreatorEnemyCarrierType1 extends Ship
{
	private boolean flagForCreate = true; //флаг, регулирующий генерацию противников, если true - противники генерируются, наче нет.
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Нужно, чтобы метод генерации не запускался сразу "на старте" игры.
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private int countCreatedEnemies = 0; //число созданных противников генератором.
	private int maxCountCreatedEnemies;// = 5; //максимально возможное число сгенерированных противников
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private static final int width = 2;
	private static final int height = 2;
	public CreatorEnemyCarrierType1(int x, int y, int speed) 
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
	public List<CarrierEnemyType1> createEnemyCarrierType1_Level_1()
	{
		List<CarrierEnemyType1> enemies = new LinkedList<CarrierEnemyType1>();
		maxCountCreatedEnemies = 1;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == true) //конец задержки генерации противников 
		{
			getGameFild().setPauseCreateEnemies(false);
		}
		else if(getGameFild().isCarrierDestroy() == false && getGameFild().getCountLevels() == 1) //getGameFild().isEndLevel_1() == false
		{
			if(flagOnIncrementDelayStartCreate == true)
			{
				delayStartCreateEnemies--;
			}
			if(delayStartCreateEnemies <= -1940)//начало задержки генерации противников (c - 60)
			{
				getGameFild().setPauseCreateEnemies(true);
			}
			if(delayStartCreateEnemies <= -2000)//-9800 //c
			{
				getGameFild().setPauseCreateEnemies(true);
				flagForStartCreate = true;
				flagOnIncrementDelayStartCreate = false;
				delayStartCreateEnemies = 0;
				getGameFild().setStartMoveCarrierType1(true); 
			}
			if(flagForStartCreate == true)
			{
				if(flagForCreate == true)
				{
					if(lastCreate + timeout > System.currentTimeMillis())
					{
						return null;
					}
					lastCreate = System.currentTimeMillis();
					timeout = 100;
					CarrierEnemyType1 enemy = new CarrierEnemyType1(getX(), getY(), 1500, 2, 0);
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
					getGameFild().getEnemyCarrierType1().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<CarrierEnemyType1> createEnemyCarrierType1_Level_2()
	{
		List<CarrierEnemyType1> enemies = new LinkedList<CarrierEnemyType1>();
		countCreatedEnemies = 0;
		maxCountCreatedEnemies = 1;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == true) //конец задержки генерации противников 
		{
			getGameFild().setPauseCreateEnemies(false);
		}
		else if(getGameFild().isCarrierDestroy() == false && getGameFild().getCountLevels() == 2) //getGameFild().isEndLevel_1() == false
		{
			if(flagOnIncrementDelayStartCreate == true)
			{
				delayStartCreateEnemies--;
			}
			if(delayStartCreateEnemies <= -940)//начало задержки генерации противников (c - 60)
			{
				getGameFild().setPauseCreateEnemies(true);
			}
			if(delayStartCreateEnemies <= -1000)//-1000 //c
			{
				flagForStartCreate = true;
				flagOnIncrementDelayStartCreate = false;
				delayStartCreateEnemies = 0;
				getGameFild().setStartMoveCarrierType1(true); //после смерти игрока выставить false (на рестарте)?????
			}
			if(flagForStartCreate == true)
			{
				if(flagForCreate == true)
				{
					if(lastCreate + timeout > System.currentTimeMillis())
					{
						return null;
					}
					lastCreate = System.currentTimeMillis();
					timeout = 100;
					CarrierEnemyType1 enemy = new CarrierEnemyType1(getX(), getY(), 1500, 2, 0);
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
					getGameFild().getEnemyCarrierType1().addAll(enemies);
				}
			}
		}
		return enemies;
	}
}
