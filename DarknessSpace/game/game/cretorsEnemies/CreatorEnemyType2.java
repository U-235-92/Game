package game.cretorsEnemies;

import game.Ship;
import game.enemies.EnemyType2;
import game.fields.GameField;

import java.util.LinkedList;
import java.util.List;

public class CreatorEnemyType2 extends Ship
{
	private boolean flagForCreate = true; //����, ������������ ��������� �����������, ���� true - ���������� ������������, ���� ���.
	private boolean flagForStartCreate = false; //����, ���������� �� �������� ������ ������ ���������. �����, ����� ����� ��������� �� ���������� ����� "�� ������" ����.
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private int countCreatedEnemies = 0; //����� ��������� ����������� �����������.
	private int countReloadCreator = 0; //������� �������� ����� ���������������� ������������ (�����, ����� ���������� �� �������������� ���� �� ������ ��� ���������)
	private int maxCountCreatedEnemies;// = 5; //����������� ��������� ����� ��������������� �����������
	private int maxDelayForReloadCreator;// = -500; //������������ ����� �������� ����� ����������� �����������
	private int delayStartCreateEnemies = 0; //�������� ����� ������� ��������� ��. flagForStartCreate
	private static final int width = 2;
	private static final int height = 2;
	public CreatorEnemyType2(int x, int y, int speed) 
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
	public List<EnemyType2> createEnemyType2StraightSpeed_8_Level_1()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -600) //-1700
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
					EnemyType2 enemy = new EnemyType2(getX(), getY(), 100, 8, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType2().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType2StraightSpeed_6_Level_1()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -700) //-3000
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
					EnemyType2 enemy = new EnemyType2(getX(), getY(), 150, 6, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType2().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType2ForDiagonalMoveFromRight_Level_1()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
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
				if(delayStartCreateEnemies <= -750)//3600
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1800;
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
						EnemyType2 enemy = new EnemyType2(getX(), getY(), 50, 10, 2);
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
						getGameFild().getEnemiesType2().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType2ForDiagonalMoveFromLeft_Level_1()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
		maxCountCreatedEnemies = 6;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -800) //3700
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -1900;
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
						EnemyType2 enemy = new EnemyType2(getX(), getY(), 50, 10, 3);
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
						getGameFild().getEnemiesType2().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	/////////////////////LEVEL 2////////
	public List<EnemyType2> createEnemyType2StraightSpeed_8_Level_2()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -300) //-1700
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
					timeout = 2000;
					EnemyType2 enemy = new EnemyType2(getX(), getY(), 150, 8, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType2().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType2StraightSpeed_12_Level_2()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -350) //-3000
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
					timeout = 2000;
					EnemyType2 enemy = new EnemyType2(getX(), getY(), 50, 12, 0);
					enemy.setGameFild(gameField);
					enemies.add(enemy);
					getGameFild().getEnemiesType2().addAll(enemies);
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType1Fast10CrossedFromRight_Level_2()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
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
				if(delayStartCreateEnemies <= -400)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -900; //(100 ~6 sec?) //1200 +-50 ~ 1 min?
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
						EnemyType2 enemy = new EnemyType2(getX(), getY(), 50, 10, 1);
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
						getGameFild().getEnemiesType2().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
	public List<EnemyType2> createEnemyType1Fast10CrossedFromLeft_Level_2()
	{
		List<EnemyType2> enemies = new LinkedList<EnemyType2>();
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
				if(delayStartCreateEnemies <= -400)
				{
					flagForStartCreate = true;
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
				}
				maxDelayForReloadCreator = -900;
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
						EnemyType2 enemy = new EnemyType2(getX(), getY(), 50, 10, 1);
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
						getGameFild().getEnemiesType2().addAll(enemies);
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
}
