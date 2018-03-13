package game.cretorsEnemies;

import game.Ship;
import game.enemies.EnemyType1;
import game.fields.GameField;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class CreatorEnemyType1 extends Ship
{
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private static final int width = 2;
	private static final int height = 2;
	private int countCreatedEnemies = 0; //число созданных противников генератором.
	private int countReloadCreator = 0; //счетчик задержки между сгенерированными противниками (нужно, чтобы противники не генерировались друг за другом без остановки)
	private int maxCountCreatedEnemies;// = 5; //максимально возможное число сгенерированных противников
	private int maxDelayForReloadCreator;// = -500; //максимальное число задержки между генерациями противников
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private boolean flagForCreate = true; //флаг, регулирующий генерацию противников, если true - противники генерируются, наче нет.
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Нужно, чтобы метод генерации не запускался сразу "на старте" игры.
	public CreatorEnemyType1(int x, int y, int speed) 
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
	public List<EnemyType1> createEnemyType1StraightSpeed_12_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(lastCreate + timeout > System.currentTimeMillis())
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				timeout = 2000; //2000
				EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 12, 0);
				enemy.setGameFild(gameField);
				enemies.add(enemy);
				getGameFild().getEnemiesType1().addAll(enemies);
			}	
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1StraightSpeed_10_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(lastCreate + timeout > System.currentTimeMillis())
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				timeout = 2000;//2000
				EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 0);
				enemy.setGameFild(gameField);
				enemies.add(enemy);
				getGameFild().getEnemiesType1().addAll(enemies);
			}
		}	
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast15CrossedFromRight_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 5;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -200) //-600
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -800; //-900 //(100 ~6 sec?) //1200 +-50 ~ 1 min?
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 15, 1);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast15CrossedFromLeft_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 7;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -300) //-800
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -800; //-900
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 15, 1);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast20Straight_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 8;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -550) //-1300
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -2000; //-800
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 0);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1DiagonalFromRight_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 7;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -570) //-1000
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -2000; //-1000
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 2);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1DiagonalFromLeft_Level_1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 5;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -600) //-1100
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -2000; //-1000
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 3);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	/////////////////////////////LEVEL2/////////
	public List<EnemyType1> createEnemyType1StraightSpeed_12_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(lastCreate + timeout > System.currentTimeMillis())
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				timeout = 2000;
				EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 12, 0);
				enemy.setGameFild(gameField);
				enemies.add(enemy);
				getGameFild().getEnemiesType1().addAll(enemies);
			}	
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1StraightSpeed_14_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(lastCreate + timeout > System.currentTimeMillis())
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				timeout = 2000;
				EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 14, 0);
				enemy.setGameFild(gameField);
				enemies.add(enemy);
				getGameFild().getEnemiesType1().addAll(enemies);
			}
		}	
		return enemies;
	}
	public List<EnemyType1> createEnemyType1DiagonalFromRight_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 8;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -500)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1000; //-1400
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 2);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1DiagonalFromLeft_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 8;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -500)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1000; //-1400
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 10, 3);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast20Straight_Left_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 5;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -600)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -800;
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 20, 0);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast20Straight_Right_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 5;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -650)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -800;
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 20, 0);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType1> createEnemyType1Fast20Straight_Right_2_Level_2()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		maxCountCreatedEnemies = 5;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -700)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -800;
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
						timeout = 500;
						EnemyType1 enemy = new EnemyType1(getX(), getY(), 50, 20, 0);
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
						getGameFild().getEnemiesType1().addAll(enemies);
					}
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
	public void move350_650onX()
	{
		int dx = getDx();
		if(getX() >= 650)
		{
			dx = -speed;
		}
		if(getX() <= 350)
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
	public void paintCreatorEnemyType1(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawRect(getX(), getY(), width, height);
	}
}
