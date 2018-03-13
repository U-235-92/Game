package game.cretorsEnemies;

import game.Ship;
import game.enemies.RamEnemyType3;
import game.fields.GameField;

import java.util.LinkedList;
import java.util.List;

public class CreatorRamEnemyType3 extends Ship
{
	private GameField gameField;
	private long lastCreate;
	private int timeout;
	private int speed;
	private int countCreatedEnemies = 0; //����� ��������� ����������� �����������.
	private int maxCountCreatedEnemies;// = 5; //����������� ��������� ����� ��������������� �����������
	private int delayStartCreateEnemies = 0; //�������� ����� ������� ��������� ��. flagForStartCreate
	private static final int width = 2;
	private static final int height = 2;
	private boolean flagForCreate = true; //����, ������������ ��������� �����������, ���� true - ���������� ������������, ���� ���.
	private boolean flagForStartCreate = false; //����, ���������� �� �������� ������ ������ ���������. �����, ����� ����� ��������� �� ���������� ����� "�� ������" ����.
	private boolean permissionCreate = true; //������������ ����� ������ ���� � ���
	public CreatorRamEnemyType3(int x, int y, int speed) 
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
	public List<RamEnemyType3> createRamEnemyType3MoveSnake_Level_1()
	{
		List<RamEnemyType3> enemies = new LinkedList<RamEnemyType3>();
		maxCountCreatedEnemies = 15;
		boolean flagOnIncrementDelayStartCreate = true;
		if(getGameFild().isCarrierDestroy() == false)
		{
			if(permissionCreate == true)
			{
				if(flagOnIncrementDelayStartCreate == true)
				{
					delayStartCreateEnemies--;
				}
				if(delayStartCreateEnemies <= -1010)//������ �������� ��������� ����������� (c - 40)
				{
					getGameFild().setPauseCreateEnemies(true);
				}
				if(delayStartCreateEnemies <= -1050)//-4000 //-120 //c
				{
					flagForStartCreate = true;
				}
				if(delayStartCreateEnemies <= -1150)//����� �������� ��������� ����������� (c + 100)
				{
					getGameFild().setPauseCreateEnemies(false);
					flagOnIncrementDelayStartCreate = false;
					delayStartCreateEnemies = 0;
					permissionCreate = false;
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
						RamEnemyType3 enemy = new RamEnemyType3(getX(), getY(), 50, 10, 4);
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
						getGameFild().getRamEnemiesType3().addAll(enemies);
					}
				}
			}
		}
		return enemies;
	}
}
