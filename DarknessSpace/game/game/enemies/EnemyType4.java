package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class EnemyType4 extends Enemy
{
	public EnemyType4(int x, int y, int armor, int speed, int idForMove) 
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
		enemy.lineTo(getX() + 10, getY() - 25);
		enemy.lineTo(getX() + 12, getY() - 35);
		enemy.lineTo(getX() + 20, getY() - 30);
		enemy.lineTo(getX() + 12, getY() - 40);
		enemy.lineTo(getX() + 30, getY() - 45);
		enemy.lineTo(getX() + 15, getY() - 50);
		enemy.lineTo(getX() + 25, getY() - 60);
		enemy.lineTo(getX() + 15, getY() - 65);
		enemy.lineTo(getX() + 12, getY() - 62);
		enemy.lineTo(getX(), getY() - 70);
		enemy.lineTo(getX() - 12, getY() - 62);
		enemy.lineTo(getX() - 15, getY() - 65);
		enemy.lineTo(getX() - 25, getY() - 60);
		enemy.lineTo(getX() - 15, getY() - 50);
		enemy.lineTo(getX() - 30, getY() - 45);
		enemy.lineTo(getX() - 12, getY() - 40);
		enemy.lineTo(getX() - 20, getY() - 30);
		enemy.lineTo(getX() - 12, getY() - 35);
		enemy.lineTo(getX() - 10, getY() - 25);
		enemy.lineTo(getX(), getY());
		g2d.fill(enemy);
		g.setColor(Color.BLUE);
		////нос////////
		g.drawLine(getX(), getY(), getX() + 10, getY() - 25);
		g.drawLine(getX(), getY(), getX() - 10, getY() - 25);
		g.drawLine(getX() + 10, getY() - 25, getX(), getY() - 40);
		g.drawLine(getX() - 10, getY() - 25, getX(), getY() - 40);
		///////////////
		g.drawLine(getX() + 10, getY() - 25, getX() + 12, getY() - 40);
		g.drawLine(getX() - 10, getY() - 25, getX() - 12, getY() - 40);
		///////////////
		g.drawLine(getX() + 12, getY() - 40, getX() + 20, getY() - 30);
		g.drawLine(getX() - 12, getY() - 40, getX() - 20, getY() - 30);
		g.drawLine(getX() + 20, getY() - 30, getX() + 12, getY() - 35);
		g.drawLine(getX() - 20, getY() - 30, getX() - 12, getY() - 35);
		///
		g.drawLine(getX() + 12, getY() - 40, getX() + 30, getY() - 45);
		g.drawLine(getX() - 12, getY() - 40, getX() - 30, getY() - 45);
		g.drawLine(getX() + 30, getY() - 45, getX() + 15, getY() - 50);
		g.drawLine(getX() - 30, getY() - 45, getX() - 15, getY() - 50);
		g.drawLine(getX() + 15, getY() - 50, getX() + 25, getY() - 60);
		g.drawLine(getX() - 15, getY() - 50, getX() - 25, getY() - 60);
		g.drawLine(getX() + 25, getY() - 60, getX() + 15, getY() - 65);
		g.drawLine(getX() - 25, getY() - 60, getX() - 15, getY() - 65);
		g.drawLine(getX() + 15, getY() - 65, getX() + 12, getY() - 62);
		g.drawLine(getX() - 15, getY() - 65, getX() - 12, getY() - 62);
		g.drawLine(getX() + 12, getY() - 62, getX(), getY() - 70);
		g.drawLine(getX() - 12, getY() - 62, getX(), getY() - 70);
		g.drawLine(getX() + 12, getY() - 62, getX(), getY() - 25);
		g.drawLine(getX() - 12, getY() - 62, getX(), getY() - 25);
	}
	public void paintAnimationShootEnemyType4(Graphics g)
	{
		if(isShootEnemyType4() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.CYAN);
			g.drawLine(getX(), getY() + 2, getX() + 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() - 2, getY() + 10);
			g.drawLine(getX(), getY() + 2, getX() + 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() - 4, getY() + 7);
			g.drawLine(getX(), getY() + 2, getX() + 5, getY() + 5);
			g.drawLine(getX(), getY() + 2, getX() - 5, getY() + 5);
			g.drawLine(getX() + 1, getY() + 2, getX() + 9, getY() + 4);
			g.drawLine(getX() - 1, getY() + 2, getX() - 9, getY() + 4);
		}
	}
	public void paintAnimationEngineEnemyType4_1(Graphics g)
	{
		Color myColor = new Color(200, 162, 200);
		////левый двигатель///////////
		g.setColor(myColor);
		g.drawLine(getX() - 10, getY() - 66, getX() - 14, getY() - 72); 
		g.drawLine(getX() - 10, getY() - 66, getX() - 6, getY() - 72); 
		g.drawLine(getX() - 14, getY() - 72, getX() - 16, getY() - 79); 
		////правый двигатель///////////
		g.drawLine(getX() + 10, getY() - 66, getX() + 14, getY() - 72); 
		g.drawLine(getX() + 10, getY() - 66, getX() + 6, getY() - 72); 
		g.drawLine(getX() + 14, getY() - 72, getX() + 16, getY() - 79); 
	}
	public void paintAnimationEngineEnemyType4_2(Graphics g)
	{
		Color myColor = new Color(147, 112, 216);
		////левый двигатель///////////
		g.setColor(myColor);	
		g.drawLine(getX() - 14, getY() - 72, getX() - 12, getY() - 77); 
		g.drawLine(getX() - 6, getY() - 72, getX() - 2, getY() - 75);
		g.drawLine(getX() - 16, getY() - 79, getX() - 14, getY() - 83);
		////правый двигатель///////////		
		g.drawLine(getX() + 14, getY() - 72, getX() + 12, getY() - 77); 
		g.drawLine(getX() + 6, getY() - 72, getX() + 2, getY() - 75);		
		g.drawLine(getX() + 16, getY() - 79, getX() + 14, getY() - 83);
	}
	public void paintAnimationEngineEnemyType4_3(Graphics g)
	{
		Color myColor = new Color(0, 125, 255);
		////левый двигатель///////////
		g.setColor(myColor);
		g.drawLine(getX() - 14, getY() - 72, getX() - 8, getY() - 75);
		g.drawLine(getX() - 2, getY() - 75, getX() - 5, getY() - 79);
		g.drawLine(getX() - 16, getY() - 80, getX() - 16, getY() - 85);
		////правый двигатель///////////
		g.drawLine(getX() + 14, getY() - 72, getX() + 8, getY() - 75);
		g.drawLine(getX() + 2, getY() - 75, getX() + 5, getY() - 79);		
		g.drawLine(getX() + 16, getY() - 80, getX() + 16, getY() - 85);
	}
	public void paintAnimationEngineEnemyType4_4(Graphics g)
	{
		Color myColor = new Color(175, 218, 252);
		////левый двигатель///////////
		g.setColor(myColor);
		g.drawLine(getX() - 8, getY() - 75, getX() - 10, getY() - 85);
		g.drawLine(getX() - 5, getY() - 79, getX() - 2, getY() - 83);
		g.drawLine(getX() - 16, getY() - 85, getX() - 13, getY() - 89);
		////правый двигатель///////////
		g.drawLine(getX() + 8, getY() - 75, getX() + 10, getY() - 85);
		g.drawLine(getX() + 5, getY() - 79, getX() + 2, getY() - 83);	
		g.drawLine(getX() + 16, getY() - 85, getX() + 13, getY() - 89);
	}
	public void paintAnimationEngineEnemyType4_5(Graphics g)
	{
		Color myColor = new Color(255, 87, 143);
		////левый двигатель///////////
		g.setColor(myColor);
		g.drawLine(getX() - 9, getY() - 82, getX() - 4, getY() - 84);
		g.drawLine(getX() - 5, getY() - 79, getX() - 1, getY() - 80);	
		////правый двигатель///////////
		g.drawLine(getX() + 9, getY() - 82, getX() + 4, getY() - 84);		
		g.drawLine(getX() + 5, getY() - 79, getX() + 1, getY() - 80);
	}
	public void paintAnimationEngineEnemyType4_6(Graphics g)
	{
		Color myColor = new Color(245, 171, 196);
		////левый двигатель///////////
		g.setColor(myColor);
		g.drawLine(getX() - 4, getY() - 84, getX() - 6, getY() - 92);
		////правый двигатель///////////
		g.drawLine(getX() + 4, getY() - 84, getX() + 6, getY() - 92);
	}
	public void paintFlashBeaconAnimation(final Graphics g)
	{
		g.setColor(Color.CYAN);
		g.drawLine(getX() + 0, getY() - 56, getX() + 0, getY() - 58); 
		g.drawLine(getX() + 0, getY() - 56, getX() + 0, getY() - 54);
		
		g.drawLine(getX() + 0, getY() - 56, getX() - 2, getY() - 56);
		g.drawLine(getX() + 0, getY() - 56, getX() + 2, getY() - 56);
		
		g.drawLine(getX() + 0, getY() - 56, getX() - 2, getY() - 54);
		g.drawLine(getX() + 0, getY() - 56, getX() + 2, getY() - 54);
		
		g.drawLine(getX() + 0, getY() - 56, getX() - 2, getY() - 58);
		g.drawLine(getX() + 0, getY() - 56, getX() + 2, getY() - 58);
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
				g.drawLine(getGameFild().getTargetEnemy().getX() + 27, getGameFild().getTargetEnemy().getY() - 72, getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 72);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 72, getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 64);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 27, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() + 2);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 6);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() - 25, getGameFild().getTargetEnemy().getY() + 2);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 6);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 72, getGameFild().getTargetEnemy().getX() - 25, getGameFild().getTargetEnemy().getY() - 72);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 72, getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 64);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 38, getGameFild().getTargetEnemy().getX() - 33, getGameFild().getTargetEnemy().getY() - 30);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 38, getGameFild().getTargetEnemy().getX() + 35, getGameFild().getTargetEnemy().getY() - 30);
			}
		}
	}
}
