package game.cretorsEnemies;

import game.Ship;
import game.enemies.RamEnemyType2;
import game.fields.GameField;

import java.util.LinkedList;
import java.util.List;

public class CreatorRamEnemyType2 extends Ship
{
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private static final int width = 2;
	private static final int height = 2;
	private int countCreatedEnemies = 0; //число созданных противников генератором.
	private int maxCountCreatedEnemies;// = 5; //максимально возможное число сгенерированных противников
	private int delayStartCreateEnemies = 0; //задержка перед стартом генерации см. flagForStartCreate
	private boolean flagForCreate = true; //флаг, регулирующий генерацию противников, если true - противники генерируются, наче нет.
	private boolean flagForStartCreate = false; //флаг, отвечающий за задержку старта метода генерации. Нужно, чтобы метод генерации не запускался сразу "на старте" игры.
	public CreatorRamEnemyType2(int x, int y, int speed) 
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
	public List<RamEnemyType2> createRamEnemyType2ForWall_Level_1()
	{
		List<RamEnemyType2> enemies = new LinkedList<RamEnemyType2>();
		maxCountCreatedEnemies = 4;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(getGameFild().isPauseCreateEnemies() == false)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -5760)//начало задержки генерации противников (c - 40)
				{
					getGameFild().setPauseCreateEnemies(true);
				}
				if(delayStartCreateEnemies <= -5800)//-5800 //-320 //c
				{
					flagForStartCreate = true;
				}
				if(delayStartCreateEnemies <= -5980)//конец задержки генерации противников (c + 180)
				{
					getGameFild().setPauseCreateEnemies(false);
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
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
						timeout = 600;
						RamEnemyType2 enemy = new RamEnemyType2(getX(), getY(), 50, 5, 0);
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
						getGameFild().getRamEnemiesType2().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
}
