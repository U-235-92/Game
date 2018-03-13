package game.guns;

import java.awt.Color;
import java.awt.Graphics;

import game.Shoot;
import game.Weapon;
import game.enemies.CarrierEnemyType1;
import game.enemies.Enemy;
import game.enemies.EnemyType1;
import game.enemies.EnemyType2;
import game.enemies.EnemyType3;
import game.enemies.EnemyType4;

public class VoidHunter extends Shoot
{
	private int speed = 20;
	private Enemy enemy;
	public VoidHunter(int x, int y) 
	{
		super(x, y, new Weapon(150, 50, 0));
	}
	public void distanceToEnemy()
	{
		int distanceToTargetX = 0; 
		int distanceToTargetY = 0; 
		int distanceToTarget;
		int minDistanceToTarget = 9000;
		//посчитать мин рассто€ние до противника и передать ниже
		for(EnemyType1 enemyType1 : getGameFild().getEnemiesType1())
		{
			distanceToTargetX = enemyType1.getX() - getX();
			distanceToTargetY = enemyType1.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
			{
				minDistanceToTarget = distanceToTarget;
				enemy = enemyType1;
			}
		}
		for(EnemyType2 enemyType2 : getGameFild().getEnemiesType2())
		{
			distanceToTargetX = enemyType2.getX() - getX();
			distanceToTargetY = enemyType2.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
			{
				minDistanceToTarget = distanceToTarget;
				enemy = enemyType2;
			}
		}
		for(EnemyType3 enemyType3 : getGameFild().getEnemiesType3())
		{
			distanceToTargetX = enemyType3.getX() - getX();
			distanceToTargetY = enemyType3.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
			{
				minDistanceToTarget = distanceToTarget;
				enemy = enemyType3;
			}
		}
		for(EnemyType4 enemyType4 : getGameFild().getEnemiesType4())
		{
			distanceToTargetX = enemyType4.getX() - getX();
			distanceToTargetY = enemyType4.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
			{
				minDistanceToTarget = distanceToTarget;
				enemy = enemyType4;
			}
		}
		for(CarrierEnemyType1 carrier : getGameFild().getEnemyCarrierType1())
		{
			distanceToTargetX = carrier.getX() - getX();
			distanceToTargetY = carrier.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
			{
				minDistanceToTarget = distanceToTarget;
				enemy = carrier;
			}
		}
	}
	public void moveHunter()
	{	
		int distanceToTargetX = 0; 
		int distanceToTargetY = 0; 
		int distanceToTarget;
		int rotation;
		int vX = 0; // скорость по ’
		int vY = 0; // скорость по Y
		if(enemy != null)
		{
			distanceToTargetX = enemy.getX() - getX();
			distanceToTargetY = enemy.getY() - getY();
		}
		vY = -speed;
		if(distanceToTargetY >= 0)
		{
			vX = 0; 
			vY = -speed;
		}
		else
		{
			distanceToTargetX = enemy.getX() - getX();
			distanceToTargetY = enemy.getY() - getY();
			distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
			rotation = (int) (Math.atan2(distanceToTargetY, distanceToTargetX) * 180 / Math.PI);
			//скорость по ’ в зависимости от угла, если угол от -90 до 90 скорость’ = 0
			vX = (int) (speed * (90 - Math.abs(rotation)) / 90);
			if(rotation < 0)
			{
				vY = -speed + Math.abs(vX);
			}
			else
			{
				vY = speed - Math.abs(vX);
			}
		}
		setDy(vY);
		setDx(vX);
		super.move();
	}
	public void paintShoot(Graphics g) 
	{
		g.setColor(Color.BLUE);
		g.drawOval(getX(), getY(), 15, 15);
		g.setColor(Color.BLACK);
		g.fillOval(getX() + 1, getY(), 14, 14);
	}
	public void paintAnimationShoot1(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawLine(getX() + 7, getY() + 7, getX() + 10, getY() + 7); //1
		g.drawLine(getX() + 7, getY() + 7, getX() + 6, getY() + 7); //1
	}
	public void paintAnimationShoot2(Graphics g) 
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 10, getY() + 7, getX() + 10, getY() + 4); //2
		g.drawLine(getX() + 10, getY() + 7, getX() + 10, getY() + 10); //2
		g.drawLine(getX() + 6, getY() + 7, getX() + 6, getY() + 4); //2
		g.drawLine(getX() + 6, getY() + 7, getX() + 6, getY() + 10); //2
		g.drawLine(getX() + 8, getY() + 7, getX() + 8, getY() + 11); //2
		g.drawLine(getX() + 8, getY() + 7, getX() + 8, getY() + 3); //2
	}
	public void paintAnimationShoot3(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.drawLine(getX() + 10, getY() + 4, getX() + 14, getY() + 4); //3
		g.drawLine(getX() + 10, getY() + 10, getX() + 14, getY() + 10); //3
		g.drawLine(getX() + 6, getY() + 4, getX() + 2, getY() + 4); //3
		g.drawLine(getX() + 6, getY() + 10, getX() + 2, getY() + 10); //3
		g.drawLine(getX() + 8, getY() + 11, getX() + 10, getY() + 13); //3
		g.drawLine(getX() + 8, getY() + 11, getX() + 6, getY() + 13); //3
		g.drawLine(getX() + 8, getY() + 3, getX() + 10, getY() + 1); //3
		g.drawLine(getX() + 8, getY() + 3, getX() + 6, getY() + 1); //3
	}
}
