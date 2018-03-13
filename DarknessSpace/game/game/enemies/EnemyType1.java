package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class EnemyType1 extends Enemy
{
	public EnemyType1(int x, int y, int armor, int speed, int idForMove) 
	{
		super(x, y, armor, speed, idForMove);
	}
	public void paintEnemy(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
		g2d.setPaint(Color.BLACK);
		GeneralPath enemy = new GeneralPath();
		enemy.moveTo(getX(), getY());
		enemy.lineTo(getX() - 5, getY() - 8);
		enemy.lineTo(getX() - 10, getY() + 8);
		enemy.lineTo(getX() - 10, getY() - 14);
		enemy.lineTo(getX() - 5, getY() - 25);
		enemy.lineTo(getX() + 5, getY() - 25);
		enemy.lineTo(getX() + 10, getY() - 14);
		enemy.lineTo(getX() + 10, getY() + 8);
		enemy.lineTo(getX() + 5, getY() - 8);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.RED);
		////нос/////////////////////
		g.drawLine(getX(), getY(), getX() - 5, getY() - 8);
		g.drawLine(getX(), getY(), getX() + 5, getY() - 8);
		////крылья//////////////////
		g.drawLine(getX() - 5, getY() - 8, getX() - 10, getY() + 8); //left
		g.drawLine(getX() + 5, getY() - 8, getX() + 10, getY() + 8); //right etc.
		g.drawLine(getX() - 10, getY() + 8, getX() - 10, getY() - 14);
		g.drawLine(getX() + 10, getY() + 8, getX() + 10, getY() - 14);
		////переход на двигатель////
		g.drawLine(getX() - 10, getY() - 14, getX() - 5, getY() - 25);
		g.drawLine(getX() + 10, getY() - 14, getX() + 5, getY() - 25);
		g.drawLine(getX() - 5, getY() - 25, getX() + 5, getY() - 25);
		////от двигателя к носу/////
		g.drawLine(getX() - 5, getY() - 25, getX(), getY());
		g.drawLine(getX() + 5, getY() - 25, getX(), getY());
		g.drawLine(getX() - 5, getY() - 8, getX() - 10, getY() - 14);
		g.drawLine(getX() + 5, getY() - 8, getX() + 10, getY() - 14);
	}
	public void paintAnimationShootEnemyType1(Graphics g)
	{
		if(isShootEnemyType1() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(getX(), getY() + 2, getX() + 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() - 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() + 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() - 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() + 5, getY() + 5);
			g.drawLine(getX(), getY() + 2, getX() - 5, getY() + 5);
		}
	}
	public void paintAnimationEngineEnemyType1_1(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 27, getX(), getY() - 39);
		g.drawLine(getX() - 1, getY() - 27, getX() - 1, getY() - 39);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX() + 1, getY() - 27, getX() + 1, getY() - 33);
		g.drawLine(getX() - 2, getY() - 27, getX() - 2, getY() - 33);
		g.setColor(Color.RED);
		g.drawLine(getX() + 2, getY() - 27, getX() + 2, getY() - 34);
		g.drawLine(getX() - 3, getY() - 27, getX() - 3, getY() - 34);
		g.setColor(Color.WHITE);
		g.drawLine(getX() + 3, getY() - 27, getX() + 3, getY() - 31);
		g.drawLine(getX() - 4, getY() - 27, getX() - 4, getY() - 31);
	}
	public void paintAnimationEngineEnemyType1_2(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 27, getX(), getY() - 37);
		g.drawLine(getX() - 1, getY() - 27, getX() - 1, getY() - 37);
		g.setColor(Color.RED);
		g.drawLine(getX() + 1, getY() - 27, getX() + 1, getY() - 36);
		g.drawLine(getX() - 2, getY() - 27, getX() - 2, getY() - 36);
		g.setColor(Color.WHITE);
		g.drawLine(getX() + 2, getY() - 27, getX() + 2, getY() - 32);
		g.drawLine(getX() - 3, getY() - 27, getX() - 3, getY() - 32);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 3, getY() - 27, getX() + 3, getY() - 29);
		g.drawLine(getX() - 4, getY() - 27, getX() - 4, getY() - 29);
	}
	public void paintAnimationEngineEnemyType1_3(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawLine(getX(), getY() - 27, getX(), getY() - 38);
		g.drawLine(getX() - 1, getY() - 27, getX() - 1, getY() - 38);
		g.setColor(Color.WHITE);
		g.drawLine(getX() + 1, getY() - 27, getX() + 1, getY() - 35);
		g.drawLine(getX() - 2, getY() - 27, getX() - 2, getY() - 35);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 2, getY() - 27, getX() + 2, getY() - 32);
		g.drawLine(getX() - 3, getY() - 27, getX() - 3, getY() - 32);
		g.setColor(Color.MAGENTA);
		g.drawLine(getX() + 3, getY() - 27, getX() + 3, getY() - 31);
		g.drawLine(getX() - 4, getY() - 27, getX() - 4, getY() - 31);
	}
	public void paintFlashBeaconAnimation(final Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 0, getY() - 16, getX() + 0, getY() - 18); 
		g.drawLine(getX() + 0, getY() - 16, getX() + 0, getY() - 14);
		
		g.drawLine(getX() + 0, getY() - 16, getX() - 2, getY() - 16);
		g.drawLine(getX() + 0, getY() - 16, getX() + 2, getY() - 16);
		
		g.drawLine(getX() + 0, getY() - 16, getX() - 2, getY() - 14);
		g.drawLine(getX() + 0, getY() - 16, getX() + 2, getY() - 14);
		
		g.drawLine(getX() + 0, getY() - 16, getX() - 2, getY() - 18);
		g.drawLine(getX() + 0, getY() - 16, getX() + 2, getY() - 18);
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
				g.drawLine(getGameFild().getTargetEnemy().getX() + 4, getGameFild().getTargetEnemy().getY() + 12, getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() + 12);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() + 12, getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() + 4);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() - 6, getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() - 10);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() - 20, getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() - 28);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 12, getGameFild().getTargetEnemy().getY() - 28, getGameFild().getTargetEnemy().getX() + 4, getGameFild().getTargetEnemy().getY() - 28);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 4, getGameFild().getTargetEnemy().getY() - 28, getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() - 28);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() - 28, getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() - 20);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() - 6, getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() - 10);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() + 4, getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() + 12);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 12, getGameFild().getTargetEnemy().getY() + 12, getGameFild().getTargetEnemy().getX() - 4, getGameFild().getTargetEnemy().getY() + 12);
			}
		}
	}
}
