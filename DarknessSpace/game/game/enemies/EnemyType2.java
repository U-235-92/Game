package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class EnemyType2 extends Enemy
{
	public EnemyType2(int x, int y, int armor, int speed, int idForMove) 
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
		enemy.lineTo(getX() - 5, getY() - 12);
		enemy.lineTo(getX() - 15, getY() - 45);
		enemy.lineTo(getX() - 18, getY() - 40);
		enemy.lineTo(getX() - 22, getY() - 44);
		enemy.lineTo(getX() - 18, getY() - 48);
		enemy.lineTo(getX() - 14, getY() - 50);
		enemy.lineTo(getX() - 8, getY() - 50);
		enemy.lineTo(getX(), getY() - 54);
		enemy.lineTo(getX() + 8, getY() - 50);
		enemy.lineTo(getX() + 14, getY() - 50);
		enemy.lineTo(getX() + 18, getY() - 48);
		enemy.lineTo(getX() + 22, getY() - 44);
		enemy.lineTo(getX() + 18, getY() - 40);
		enemy.lineTo(getX() + 15, getY() - 45);
		enemy.lineTo(getX() + 5, getY() - 12);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.RED);
		////нос//////////////////////////////
		g.drawLine(getX(), getY(), getX() - 5, getY() - 12);
		g.drawLine(getX(), getY(), getX() + 5, getY() - 12);
		g.drawLine(getX() - 5, getY() - 12, getX() + 5, getY() - 12);
		////крыло////////////////////////////
		g.drawLine(getX(), getY() - 32, getX() + 15, getY() - 45);
		g.drawLine(getX(), getY() - 32, getX() - 15, getY() - 45);
		////крепление под правое орудие//////
		g.drawLine(getX() + 15, getY() - 45, getX() + 18, getY() - 40);
		g.drawLine(getX() + 18, getY() - 40, getX() + 22, getY() - 44);
		////крепление под левое орудие///////
		g.drawLine(getX() - 15, getY() - 45, getX() - 18, getY() - 40);
		g.drawLine(getX() - 18, getY() - 40, getX() - 22, getY() - 44);
		/////////////////////////////////////
		g.drawLine(getX() - 22, getY() - 44, getX() - 18, getY() - 48);
		g.drawLine(getX() + 22, getY() - 44, getX() + 18, getY() - 48);
		g.drawLine(getX() - 18, getY() - 48, getX() - 14, getY() - 50);
		g.drawLine(getX() + 18, getY() - 48, getX() + 14, getY() - 50);
		////двигатели////////////////////////
		g.drawLine(getX() - 14, getY() - 50, getX() - 8, getY() - 50);
		g.drawLine(getX() + 14, getY() - 50, getX() + 8, getY() - 50);
		////хвост////////////////////////////
		g.drawLine(getX() - 8, getY() - 50, getX(), getY() - 54);
		g.drawLine(getX() + 8, getY() - 50, getX(), getY() - 54);
		////от конуса к креплениям///////////
		g.drawLine(getX() + 5, getY() - 12, getX() + 13, getY() - 43);
		g.drawLine(getX() - 5, getY() - 12, getX() - 13, getY() - 43);
		////от крыла до хвоста///////////////
		g.drawLine(getX(), getY() - 32, getX() + 8, getY() - 50);
		g.drawLine(getX(), getY() - 32, getX() - 8, getY() - 50);	
	}
	public void paintAnimationShootEnemyType2(Graphics g)
	{
		if(isShootEnemyType2() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.YELLOW);
			g.drawLine(getX() + 20, getY() - 39, getX() + 22, getY() - 30); 
			g.drawLine(getX() - 20, getY() - 39, getX() - 22, getY() - 30);
			g.drawLine(getX() + 20, getY() - 39, getX() + 24, getY() - 33); 
			g.drawLine(getX() - 20, getY() - 39, getX() - 24, getY() - 33);
			g.drawLine(getX() + 20, getY() - 39, getX() + 25, getY() - 35); 
			g.drawLine(getX() - 20, getY() - 39, getX() - 25, getY() - 35);
			
			g.drawLine(getX() + 20, getY() - 39, getX() + 18, getY() - 30);
			g.drawLine(getX() - 20, getY() - 39, getX() - 18, getY() - 30);
			g.drawLine(getX() + 20, getY() - 39, getX() + 16, getY() - 33);
			g.drawLine(getX() - 20, getY() - 39, getX() - 16, getY() - 33);
			g.drawLine(getX() + 20, getY() - 39, getX() + 15, getY() - 35);
			g.drawLine(getX() - 20, getY() - 39, getX() - 15, getY() - 35);
		}
	}
	public void paintAnimationEngineEnemyType2_1(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 57, getX() + 9, getY() - 53); 
		g.drawLine(getX() - 1, getY() - 57, getX() - 11, getY() - 53);
	}
	public void paintAnimationEngineEnemyType2_2(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 60, getX() + 7, getY() - 57); 
		g.drawLine(getX() - 1, getY() - 60, getX() - 5, getY() - 57); 
	}
	public void paintAnimationEngineEnemyType2_3(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 63, getX() + 5, getY() - 61); 
		g.drawLine(getX() - 1, getY() - 63, getX() - 5, getY() - 61); 
	}
	public void paintAnimationEngineEnemyType2_4(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 66, getX() + 3, getY() - 65); 
		g.drawLine(getX() - 1, getY() - 66, getX() - 3, getY() - 65);
	}
	public void paintAnimationEngineEnemyType2_5(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.drawLine(getX(), getY() - 68, getX() + 2, getY() - 69); 
		g.drawLine(getX() - 1, getY() - 68, getX() - 2, getY() - 69);
	}
	public void paintAnimationEngineEnemyType2_6(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX(), getY() - 70, getX() + 1, getY() - 72); 
		g.drawLine(getX() - 1, getY() - 70, getX() - 1, getY() - 72);
	}
	public void paintFlashBeaconAnimation(final Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 0, getY() - 20, getX() + 0, getY() - 22); 
		g.drawLine(getX() + 0, getY() - 20, getX() + 0, getY() - 18);
		
		g.drawLine(getX() + 0, getY() - 20, getX() - 2, getY() - 20);
		g.drawLine(getX() + 0, getY() - 20, getX() + 2, getY() - 20);
		
		g.drawLine(getX() + 0, getY() - 20, getX() - 2, getY() - 18);
		g.drawLine(getX() + 0, getY() - 20, getX() + 2, getY() - 18);
		
		g.drawLine(getX() + 0, getY() - 20, getX() - 2, getY() - 22);
		g.drawLine(getX() + 0, getY() - 20, getX() + 2, getY() - 22);
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
				g.drawLine(getGameFild().getTargetEnemy().getX() + 15, getGameFild().getTargetEnemy().getY() - 57, getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 57);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 57, getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 49);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 15, getGameFild().getTargetEnemy().getY() - 0, getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 0);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 0, getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 8);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 15, getGameFild().getTargetEnemy().getY() - 0, getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 0);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 0, getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 8);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 15, getGameFild().getTargetEnemy().getY() - 57, getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 57);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 57, getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 49);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 32, getGameFild().getTargetEnemy().getX() - 23, getGameFild().getTargetEnemy().getY() - 24);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 32, getGameFild().getTargetEnemy().getX() + 23, getGameFild().getTargetEnemy().getY() - 24);
			}
		}
	}
}
