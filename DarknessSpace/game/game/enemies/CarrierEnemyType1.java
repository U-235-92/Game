package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CarrierEnemyType1 extends Enemy
{
	private int speed;
	private long lastCreate;
	private long timeStartPause;
	private long timeDelayPause;
	private int delayCreate;
	private boolean flagPauseGame = false;
	
	public CarrierEnemyType1(int x, int y, int armor, int speed, int idForMove)
	{
		super(x, y, armor, speed, idForMove);
	}
	public List<EnemyType1> createEnemyType1FromCarrierType1()
	{
		List<EnemyType1> enemies = new LinkedList<EnemyType1>();
		if(getGameFild().getCountLevels() == 1)
		{
			final Timer timer = new Timer();
			delayCreate = 5000;
			if(getGameFild().isPause() == true)
			{
				timeStartPause = System.currentTimeMillis();
			}
			timeDelayPause = 1500;//(1500 + delayCreate) - timeStartPause;
			if(timeDelayPause < 0)
			{
				timeDelayPause = 0;
			}
			if(getGameFild().getIndicatorPauseGame() == 0)
			{
				flagPauseGame = false;
			}
			else if(getGameFild().getIndicatorPauseGame() != 0)
			{
				flagPauseGame = true;
			}
			if(flagPauseGame == true)
			{
				timer.schedule(new TimerTask()
				{
					public void run()
					{
						if(flagPauseGame == false)
						{
							timer.cancel();
						}
						flagPauseGame = false;
						getGameFild().setIndicatorPauseGame(0);
					}
				}, timeDelayPause);
			}
			else if(flagPauseGame == false)
			{
				if(lastCreate + delayCreate > System.currentTimeMillis()) 
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				////первый противник////
				EnemyType1 enemy1 = new EnemyType1(getX() + 60, getY() + 0, 100, 5, 0);
				enemy1.setGameFild(getGameFild());
				enemies.add(enemy1);
				for(Enemy enemyCarrier : getGameFild().getEnemyCarrierType1())
				{
					if(enemyCarrier.getDx() == speed)
					{
						enemy1.setDx(-enemy1.getSpeed());
					}
					else
					{
						enemy1.setDx(enemy1.getSpeed());
					}
				}
				////второй противник////
				EnemyType1 enemy2 = new EnemyType1(getX() - 60, getY() + 0, 100, 5, 0);
				enemy2.setGameFild(getGameFild());
				enemies.add(enemy2);
				for(Enemy enemyCarrier : getGameFild().getEnemyCarrierType1())
				{
					if(enemyCarrier.getDx() == speed)
					{
						enemy2.setDx(enemy2.getSpeed());
					}
					else
					{
						enemy2.setDx(-enemy2.getSpeed());
					}
				}
				getGameFild().getEnemiesType1().addAll(enemies);
			}
		}
		else if(getGameFild().getCountLevels() == 2)
		{
			final Timer timer = new Timer();
			delayCreate = 5000;
			if(getGameFild().isPause() == true)
			{
				timeStartPause = System.currentTimeMillis();
			}
			timeDelayPause = 1500;//(1000 + delayCreate) - timeStartPause;
			if(timeDelayPause < 0)
			{
				timeDelayPause = 0;
			}
			if(getGameFild().getIndicatorPauseGame() == 0)
			{
				flagPauseGame = false;
			}
			else if(getGameFild().getIndicatorPauseGame() != 0)
			{
				flagPauseGame = true;
			}
			if(flagPauseGame == true)
			{
				timer.schedule(new TimerTask()
				{
					public void run()
					{
						if(flagPauseGame == false)
						{
							timer.cancel();
						}
						flagPauseGame = false;
						getGameFild().setIndicatorPauseGame(0);
					}
				}, timeDelayPause);
			}
			else if(flagPauseGame == false)
			{
				if(lastCreate + delayCreate > System.currentTimeMillis()) 
				{
					return null;
				}
				lastCreate = System.currentTimeMillis();
				////первый противник////
				EnemyType1 enemy1 = new EnemyType1(getX() + 60, getY() + 0, 100, 5, 0);
				enemy1.setGameFild(getGameFild());
				enemies.add(enemy1);
				////второй противник////
				EnemyType1 enemy2 = new EnemyType1(getX() - 60, getY() + 0, 100, 5, 0);
				enemy2.setGameFild(getGameFild());
				enemies.add(enemy2);
				getGameFild().getEnemiesType1().addAll(enemies);
			}
		}
		return enemies;
	}
	public void paintEnemy(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
		g2d.setPaint(Color.BLACK);
		GeneralPath enemy = new GeneralPath();
		enemy.moveTo(getX(), getY());
		enemy.lineTo(getX() + 15, getY() - 35);
		enemy.lineTo(getX() + 135, getY() - 65);
		enemy.lineTo(getX() + 155, getY() - 75);
		enemy.lineTo(getX() + 165, getY() - 85);
		enemy.lineTo(getX() + 175, getY() - 100);
		enemy.lineTo(getX() + 160, getY() - 88);
		enemy.lineTo(getX() + 130, getY() - 85);
		enemy.lineTo(getX() + 90, getY() - 90);
		enemy.lineTo(getX() + 55, getY() - 98);
		enemy.lineTo(getX() + 35, getY() - 125);
		enemy.lineTo(getX() + 30, getY() - 145);
		enemy.lineTo(getX() + 25, getY() - 125);
		enemy.lineTo(getX() + 10, getY() - 98);
		enemy.lineTo(getX(), getY() - 90);
		enemy.lineTo(getX() - 10, getY() - 98);
		enemy.lineTo(getX() - 25, getY() - 125);
		enemy.lineTo(getX() - 30, getY() - 145);
		enemy.lineTo(getX() - 35, getY() - 125);
		enemy.lineTo(getX() - 55, getY() - 98);
		enemy.lineTo(getX() - 90, getY() - 90);
		enemy.lineTo(getX() - 130, getY() - 85);
		enemy.lineTo(getX() - 160, getY() - 88);
		enemy.lineTo(getX() - 175, getY() - 100);
		enemy.lineTo(getX() - 165, getY() - 85);
		enemy.lineTo(getX() - 155, getY() - 75);
		enemy.lineTo(getX() - 135, getY() - 65);
		enemy.lineTo(getX() - 15, getY() - 35);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.RED);
		////нос/////
		g.drawLine(getX(), getY(), getX() + 15, getY() - 35);
		g.drawLine(getX(), getY(), getX() - 15, getY() - 35);
		g.drawLine(getX() + 15, getY() - 35, getX(), getY() - 65);
		g.drawLine(getX() - 15, getY() - 35, getX(), getY() - 65);
		////правое крыло
		g.drawLine(getX() + 15, getY() - 35, getX() + 135, getY() - 65);
		g.drawLine(getX() + 135, getY() - 65, getX() + 155, getY() - 75);
		g.drawLine(getX() + 155, getY() - 75, getX() + 165, getY() - 85);
		g.drawLine(getX() + 165, getY() - 85, getX() + 175, getY() - 100);
		g.drawLine(getX() + 175, getY() - 100, getX() + 160, getY() - 88);
		g.drawLine(getX() + 160, getY() - 88, getX() + 130, getY() - 85);
		g.drawLine(getX() + 130, getY() - 85, getX() + 90, getY() - 90);
		g.drawLine(getX() + 90, getY() - 90, getX() + 55, getY() - 98);
		g.drawLine(getX() + 55, getY() - 98, getX() + 35, getY() - 125);
		g.drawLine(getX() + 35, getY() - 125, getX() + 30, getY() - 145);
		g.drawLine(getX() + 30, getY() - 145, getX() + 25, getY() - 125);
		g.drawLine(getX() + 25, getY() - 125, getX() + 10, getY() - 98);
		////левое крыло
		g.drawLine(getX() - 15, getY() - 35, getX() - 135, getY() - 65);
		g.drawLine(getX() - 135, getY() - 65, getX() - 155, getY() - 75);
		g.drawLine(getX() - 155, getY() - 75, getX() - 165, getY() - 85);
		g.drawLine(getX() - 165, getY() - 85, getX() - 175, getY() - 100);
		g.drawLine(getX() - 175, getY() - 100, getX() - 160, getY() - 88);
		g.drawLine(getX() - 160, getY() - 88, getX() - 130, getY() - 85);
		g.drawLine(getX() - 130, getY() - 85, getX() - 90, getY() - 90);
		g.drawLine(getX() - 90, getY() - 90, getX() - 55, getY() - 98);
		g.drawLine(getX() - 55, getY() - 98, getX() - 35, getY() - 125);
		g.drawLine(getX() - 35, getY() - 125, getX() - 30, getY() - 145);
		g.drawLine(getX() - 30, getY() - 145, getX() - 25, getY() - 125);
		g.drawLine(getX() - 25, getY() - 125, getX() - 10, getY() - 98);
		////соединение левого и правого крыльев
		g.drawLine(getX() - 10, getY() - 98, getX(), getY() - 90);
		g.drawLine(getX() + 10, getY() - 98, getX(), getY() - 90);
		////от носа к правому двигателю
		g.drawLine(getX() + 15, getY() - 35, getX() + 55, getY() - 98);
		g.drawLine(getX() + 15, getY() - 35, getX() + 10, getY() - 98);
		////от носа к левому двигателю
		g.drawLine(getX() - 15, getY() - 35, getX() - 55, getY() - 98);
		g.drawLine(getX() - 15, getY() - 35, getX() - 10, getY() - 98);
		////выделение правого двигателя
		g.drawLine(getX() + 55, getY() - 98, getX() + 30, getY() - 120);
		g.drawLine(getX() + 10, getY() - 98, getX() + 30, getY() - 120);
		////выделение левого двигателя
		g.drawLine(getX() - 55, getY() - 98, getX() - 30, getY() - 120);
		g.drawLine(getX() - 10, getY() - 98, getX() - 30, getY() - 120);
		////от носа к правому крылу
		g.drawLine(getX() + 15, getY() - 35, getX() + 130, getY() - 85);
		////от носа к правому крылу
		g.drawLine(getX() - 15, getY() - 35, getX() - 130, getY() - 85);
	}
	public void paintAnimationShootCarrierEnemyType1(Graphics g)
	{
		if(isShootCarrierEnemyType1() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.RED);
			g.drawLine(getX() + 100, getY() - 54, getX() + 102, getY() - 45); 
			g.drawLine(getX() - 100, getY() - 54, getX() - 102, getY() - 45);
			g.setColor(Color.BLUE);
			g.drawLine(getX() + 100, getY() - 54, getX() + 104, getY() - 45); 
			g.drawLine(getX() - 100, getY() - 54, getX() - 104, getY() - 45);
			g.setColor(Color.MAGENTA);
			g.drawLine(getX() + 100, getY() - 54, getX() + 105, getY() - 45); 
			g.drawLine(getX() - 100, getY() - 54, getX() - 105, getY() - 45);
			g.setColor(Color.RED);
			g.drawLine(getX() + 100, getY() - 54, getX() + 98, getY() - 45);
			g.drawLine(getX() - 100, getY() - 54, getX() - 98, getY() - 45);
			g.setColor(Color.BLUE);
			g.drawLine(getX() + 100, getY() - 54, getX() + 96, getY() - 45);
			g.drawLine(getX() - 100, getY() - 54, getX() - 96, getY() - 45);
			g.setColor(Color.MAGENTA);
			g.drawLine(getX() + 100, getY() - 54, getX() + 95, getY() - 45);
			g.drawLine(getX() - 100, getY() - 54, getX() - 95, getY() - 45);
		}
	}
	public void paintAnimationShootCarrierEnemyType1_2(Graphics g)
	{
		if(isShootCarrierEnemyType1() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.RED);
			g.drawLine(getX(), getY(), getX() + 2, getY() + 9); 
			g.drawLine(getX(), getY(), getX() - 2, getY() + 9);
			g.setColor(Color.BLUE);
			g.drawLine(getX(), getY(), getX() + 4, getY() + 9); 
			g.drawLine(getX(), getY(), getX() - 4, getY() + 9);
			g.setColor(Color.MAGENTA);
			g.drawLine(getX(), getY(), getX() + 5, getY() + 9); 
			g.drawLine(getX(), getY(), getX() - 5, getY() + 9);
		}
	}
	public void paintAnimationEngineCarrierEnemyType1_1(Graphics g)
	{
		Color myColor = new Color(31, 206, 203);
		g.setColor(myColor);
		g.drawLine(getX() - 55, getY() - 100, getX() - 55, getY() - 114);
		g.drawLine(getX() - 50, getY() - 107, getX() - 50, getY() - 121);
		g.drawLine(getX() - 45, getY() - 114, getX() - 45, getY() - 128);
		g.drawLine(getX() - 40, getY() - 121, getX() - 40, getY() - 136);
		g.drawLine(getX() - 35, getY() - 128, getX() - 35, getY() - 144);
		g.drawLine(getX() - 30, getY() - 144, getX() - 30, getY() - 158);
		g.drawLine(getX() - 25, getY() - 128, getX() - 25, getY() - 144);
		g.drawLine(getX() - 20, getY() - 119, getX() - 20, getY() - 135);
		g.drawLine(getX() - 15, getY() - 110, getX() - 15, getY() - 128);
		g.drawLine(getX() - 10, getY() - 100, getX() - 10, getY() - 114);
		
		g.drawLine(getX() + 55, getY() - 100, getX() + 55, getY() - 114);
		g.drawLine(getX() + 50, getY() - 107, getX() + 50, getY() - 121);
		g.drawLine(getX() + 45, getY() - 114, getX() + 45, getY() - 128);
		g.drawLine(getX() + 40, getY() - 121, getX() + 40, getY() - 135);
		g.drawLine(getX() + 35, getY() - 128, getX() + 35, getY() - 144);
		g.drawLine(getX() + 30, getY() - 144, getX() + 30, getY() - 158);
		g.drawLine(getX() + 25, getY() - 128, getX() + 25, getY() - 144);
		g.drawLine(getX() + 20, getY() - 119, getX() + 20, getY() - 135);
		g.drawLine(getX() + 15, getY() - 110, getX() + 15, getY() - 128);
		g.drawLine(getX() + 10, getY() - 100, getX() + 10, getY() - 114);
	}
	public void paintAnimationEngineCarrierEnemyType1_2(Graphics g)
	{
		Color myColor = new Color(135, 206, 250);
		g.setColor(myColor);
		g.drawLine(getX() - 53, getY() - 112, getX() - 53, getY() - 122);
		g.drawLine(getX() - 48, getY() - 119, getX() - 48, getY() - 129);
		g.drawLine(getX() - 43, getY() - 126, getX() - 43, getY() - 136);
		g.drawLine(getX() - 38, getY() - 133, getX() - 38, getY() - 143);
		g.drawLine(getX() - 33, getY() - 142, getX() - 33, getY() - 152);
		g.drawLine(getX() - 27, getY() - 142, getX() - 27, getY() - 152);
		g.drawLine(getX() - 22, getY() - 133, getX() - 22, getY() - 143);
		g.drawLine(getX() - 17, getY() - 126, getX() - 17, getY() - 136);
		g.drawLine(getX() - 12, getY() - 112, getX() - 12, getY() - 122);
		
		g.drawLine(getX() + 53, getY() - 112, getX() + 53, getY() - 122);
		g.drawLine(getX() + 48, getY() - 119, getX() + 48, getY() - 129);
		g.drawLine(getX() + 43, getY() - 126, getX() + 43, getY() - 136);
		g.drawLine(getX() + 38, getY() - 133, getX() + 38, getY() - 143);
		g.drawLine(getX() + 33, getY() - 142, getX() + 33, getY() - 152);
		g.drawLine(getX() + 27, getY() - 142, getX() + 27, getY() - 152);
		g.drawLine(getX() + 22, getY() - 133, getX() + 22, getY() - 143);
		g.drawLine(getX() + 17, getY() - 126, getX() + 17, getY() - 136);
		g.drawLine(getX() + 12, getY() - 112, getX() + 12, getY() - 122);
	}
	public void paintAnimationEngineCarrierEnemyType1_3(Graphics g)
	{
		Color myColor = new Color(204, 204, 255);
		g.setColor(myColor);
		g.drawLine(getX() - 55, getY() - 119, getX() - 55, getY() - 127);
		g.drawLine(getX() - 50, getY() - 128, getX() - 50, getY() - 136);
		g.drawLine(getX() - 45, getY() - 135, getX() - 45, getY() - 143);
		g.drawLine(getX() - 40, getY() - 142, getX() - 40, getY() - 150);
		g.drawLine(getX() - 35, getY() - 149, getX() - 35, getY() - 157);
		g.drawLine(getX() - 30, getY() - 158, getX() - 30, getY() - 168);
		g.drawLine(getX() - 25, getY() - 149, getX() - 25, getY() - 157);
		g.drawLine(getX() - 20, getY() - 140, getX() - 20, getY() - 148);
		g.drawLine(getX() - 15, getY() - 133, getX() - 15, getY() - 141);
		g.drawLine(getX() - 10, getY() - 119, getX() - 10, getY() - 127);
		
		g.drawLine(getX() + 55, getY() - 119, getX() + 55, getY() - 127);
		g.drawLine(getX() + 50, getY() - 128, getX() + 50, getY() - 136);
		g.drawLine(getX() + 45, getY() - 135, getX() + 45, getY() - 143);
		g.drawLine(getX() + 40, getY() - 142, getX() + 40, getY() - 150);
		g.drawLine(getX() + 35, getY() - 149, getX() + 35, getY() - 157);
		g.drawLine(getX() + 30, getY() - 158, getX() + 30, getY() - 168);
		g.drawLine(getX() + 25, getY() - 149, getX() + 25, getY() - 157);
		g.drawLine(getX() + 20, getY() - 140, getX() + 20, getY() - 148);
		g.drawLine(getX() + 15, getY() - 133, getX() + 15, getY() - 141);
		g.drawLine(getX() + 10, getY() - 119, getX() + 10, getY() - 127);
	}
	public void paintAnimationEngineCarrierEnemyType1_4(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawLine(getX() - 55, getY() - 105, getX() - 36, getY() - 132);
		g.drawLine(getX() - 36, getY() - 132, getX() - 31, getY() - 152);
		g.drawLine(getX() - 29, getY() - 152, getX() - 25, getY() - 132);
		g.drawLine(getX() - 25, getY() - 132, getX() - 10, getY() - 105);
		
		g.drawLine(getX() + 53, getY() - 105, getX() + 36, getY() - 132);
		g.drawLine(getX() + 36, getY() - 132, getX() + 31, getY() - 152);
		g.drawLine(getX() + 29, getY() - 152, getX() + 23, getY() - 132);
		g.drawLine(getX() + 23, getY() - 132, getX() + 10, getY() - 105);
	}
	public void paintAnimationEngineCarrierEnemyType1_5(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 45, getY() - 129, getX() - 32, getY() - 156);
		g.drawLine(getX() - 32, getY() - 156, getX() - 29, getY() - 166);
		g.drawLine(getX() - 29, getY() - 166, getX() - 26, getY() - 156);
		g.drawLine(getX() - 26, getY() - 156, getX() - 17, getY() - 129);
		
		g.drawLine(getX() + 45, getY() - 129, getX() + 33, getY() - 156);
		g.drawLine(getX() + 33, getY() - 156, getX() + 30, getY() - 166);
		g.drawLine(getX() + 30, getY() - 166, getX() + 27, getY() - 156);
		g.drawLine(getX() + 27, getY() - 156, getX() + 17, getY() - 129);
	}
	public void paintAnimationEngineCarrierEnemyType1_6(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 35, getY() - 158, getX() - 28, getY() - 178);
		g.drawLine(getX() - 28, getY() - 178, getX() - 23, getY() - 158);
		
		g.drawLine(getX() + 37, getY() - 158, getX() + 30, getY() - 178);
		g.drawLine(getX() + 30, getY() - 178, getX() + 23, getY() - 158);
	}
	public void paintAnimationEngineCarrierEnemyType1_7(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX() - 30, getY() - 180, getX() - 28, getY() - 184);
		g.drawLine(getX() - 28, getY() - 184, getX() - 26, getY() - 180);
		
		g.drawLine(getX() + 33, getY() - 180, getX() + 31, getY() - 184);
		g.drawLine(getX() + 31, getY() - 184, getX() + 28, getY() - 180);
	}
	public void paintLockTarget(Graphics g)
	{
		if(getGameFild().getTargetEnemy() != null)
		{
			if(getGameFild().isShootVoidHunterFlag() == false)
			{
				
			}
			else
			{
				g.setColor(Color.GREEN);
				g.drawLine(getX() + 172, getY() - 160, getX() + 180, getY() - 160);
				g.drawLine(getX() + 180, getY() - 160, getX() + 180, getY() - 152);
				g.drawLine(getX() + 172, getY() + 2, getX() + 180, getY() + 2);
				g.drawLine(getX() + 180, getY() + 2, getX() + 180, getY() - 6);
				g.drawLine(getX() - 180, getY() + 2, getX() - 172, getY() + 2);
				g.drawLine(getX() - 180, getY() + 2, getX() - 180, getY() - 6);
				g.drawLine(getX() - 180, getY() - 160, getX() - 172, getY() - 160);
				g.drawLine(getX() - 180, getY() - 160, getX() - 180, getY() - 152);
				g.drawLine(getX() - 180, getY() - 98, getX() - 180, getY() - 68);
				g.drawLine(getX() + 180, getY() - 98, getX() + 180, getY() - 68);
			}
		}
	}
}
