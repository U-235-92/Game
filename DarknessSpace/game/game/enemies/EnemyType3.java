package game.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

public class EnemyType3 extends Enemy
{
	public EnemyType3(int x, int y, int armor, int speed, int idForMove)
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
		enemy.moveTo(getX() + 1, getY());
		enemy.lineTo(getX() + 5, getY());
		enemy.lineTo(getX() + 10, getY() - 15);
		enemy.lineTo(getX() + 10, getY() - 20);
		enemy.lineTo(getX() + 15, getY() - 25);
		enemy.lineTo(getX() + 10, getY() - 25);
		enemy.lineTo(getX() + 10, getY() - 35);
		enemy.lineTo(getX() + 30, getY() - 45);
		enemy.lineTo(getX() + 10, getY() - 50);
		enemy.lineTo(getX() + 10, getY() - 55);
		enemy.lineTo(getX() + 8, getY() - 60);
		enemy.lineTo(getX() + 5, getY() - 60);
		enemy.lineTo(getX() + 3, getY() - 55);
		enemy.lineTo(getX() + 1, getY() - 60);
		enemy.lineTo(getX() - 2, getY() - 60);
		enemy.lineTo(getX() - 4, getY() - 55);
		enemy.lineTo(getX() - 4, getY() - 50);
		enemy.lineTo(getX() - 24, getY() - 45);		
		enemy.lineTo(getX() - 4, getY() - 35);	
		enemy.lineTo(getX() - 4, getY() - 25);
		enemy.lineTo(getX() - 9, getY() - 25);
		enemy.lineTo(getX() - 4, getY() - 20);
		enemy.lineTo(getX() - 4, getY() - 15);
		enemy.lineTo(getX() + 1, getY());
		g2d.fill(enemy);
		g.setColor(Color.WHITE);
		////нос////////
		g.drawLine(getX(), getY(), getX() + 5, getY());
		g.drawLine(getX() + 5, getY(), getX() + 10, getY() - 15);
		g.drawLine(getX(), getY(), getX() - 5, getY() - 15);
		////фюзеляж///
		g.drawLine(getX() + 10, getY() - 15, getX() + 10, getY() - 55);
		g.drawLine(getX() - 5, getY() - 15, getX() - 5, getY() - 55);
		////двигатели///
		g.drawLine(getX() + 10, getY() - 55, getX() + 8, getY() - 60);
		g.drawLine(getX() + 8, getY() - 60, getX() + 5, getY() - 60);
		g.drawLine(getX() + 5, getY() - 60, getX() + 2, getY() - 55);
		
		g.drawLine(getX() - 5, getY() - 55, getX() - 2, getY() - 60);
		g.drawLine(getX() - 2, getY() - 60, getX() + 1, getY() - 60);
		g.drawLine(getX() + 1, getY() - 60, getX() + 4, getY() - 55);
		////ПГО/////////
		g.drawLine(getX() + 10, getY() - 20, getX() + 15, getY() - 25);
		g.drawLine(getX() + 15, getY() - 25, getX() + 10, getY() - 25);
		g.drawLine(getX() - 5, getY() - 20, getX() - 10, getY() - 25);
		g.drawLine(getX() - 10, getY() - 25, getX() - 5, getY() - 25);
		////крылья//////
		g.drawLine(getX() + 10, getY() - 35, getX() + 30, getY() - 45);
		g.drawLine(getX() - 5, getY() - 35, getX() - 25, getY() - 45);
		g.drawLine(getX() + 10, getY() - 55, getX() + 30, getY() - 45);
		g.drawLine(getX() - 5, getY() - 55, getX() - 25, getY() - 45);
		g.drawLine(getX() + 30, getY() - 40, getX() + 30, getY() - 50);
		g.drawLine(getX() - 25, getY() - 40, getX() - 25, getY() - 50);
		////////////////
		g.drawLine(getX() + 10, getY() - 35, getX() + 2, getY() - 55);
		g.drawLine(getX() - 5, getY() - 35, getX() + 4, getY() - 55);
		////////////////
		g.drawLine(getX() + 2, getY() - 4, getX() - 1, getY() - 12);
		g.drawLine(getX() + 3, getY() - 4, getX() + 6, getY() - 12);
		g.drawLine(getX() + 6, getY() - 12, getX() - 1, getY() - 12);	
	}
	public void paintAnimationShootEnemyType3(Graphics g)
	{
		if(isShootEnemyType3() == true && isEnemyCreateShoot() == true)
		{
			g.setColor(Color.CYAN);
			g.drawLine(getX() + 2, getY() + 2, getX() + 4, getY() + 10);
			g.drawLine(getX() + 2, getY() + 2, getX() - 0, getY() + 10);
			g.drawLine(getX() + 2, getY() + 2, getX() + 6, getY() + 7);
			g.drawLine(getX() + 2, getY() + 2, getX() - 2, getY() + 7);
			g.drawLine(getX() + 2, getY() + 2, getX() + 7, getY() + 5);
			g.drawLine(getX() + 2, getY() + 2, getX() - 3, getY() + 5);
		}
	}
	public void paintAnimationEngineEnemyType3_1(Graphics g)
	{
		////левый двигатель///////////
		g.setColor(Color.RED);
		g.drawLine(getX() - 1, getY() - 62, getX() + 2, getY() - 68); 
		g.drawLine(getX(), getY() - 62, getX() - 3, getY() - 68);
		g.setColor(Color.RED);
		g.drawLine(getX() - 1, getY() - 62, getX() + 1, getY() - 72); 
		g.drawLine(getX(), getY() - 62, getX() - 1, getY() - 72);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 1, getY() - 62, getX() + 3, getY() - 65); 
		g.drawLine(getX(), getY() - 62, getX() - 4, getY() - 65);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 1, getY() - 62, getX() + 1, getY() - 70); 
		g.drawLine(getX(), getY() - 62, getX() - 2, getY() - 70);
		////правый двигатель///////////
		g.setColor(Color.RED);
		g.drawLine(getX() + 6, getY() - 62, getX() + 9, getY() - 68); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 4, getY() - 68);
		g.setColor(Color.RED);
		g.drawLine(getX() + 6, getY() - 62, getX() + 8, getY() - 72); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 6, getY() - 72);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 6, getY() - 62, getX() + 10, getY() - 65); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 3, getY() - 65);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 6, getY() - 62, getX() + 8, getY() - 70); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 5, getY() - 70);
	}
	public void paintAnimationEngineEnemyType3_2(Graphics g)
	{
		////левый двигатель///////////
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 1, getY() - 62, getX() + 2, getY() - 66); 
		g.drawLine(getX(), getY() - 62, getX() - 3, getY() - 66);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 1, getY() - 62, getX() + 1, getY() - 74); 
		g.drawLine(getX(), getY() - 62, getX() - 1, getY() - 74);
		g.setColor(Color.RED);
		g.drawLine(getX() - 1, getY() - 62, getX() + 3, getY() - 67); 
		g.drawLine(getX(), getY() - 62, getX() - 4, getY() - 67);
		////правый двигатель///////////
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 6, getY() - 62, getX() + 9, getY() - 66); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 4, getY() - 66);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 6, getY() - 62, getX() + 8, getY() - 74); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 6, getY() - 74);
		g.setColor(Color.RED);
		g.drawLine(getX() + 6, getY() - 62, getX() + 10, getY() - 67); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 3, getY() - 67);
	}
	public void paintAnimationEngineEnemyType3_3(Graphics g)
	{
		////левый двигатель///////////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 1, getY() - 62, getX() + 2, getY() - 68); 
		g.drawLine(getX(), getY() - 62, getX() - 3, getY() - 68);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 1, getY() - 62, getX() + 1, getY() - 72); 
		g.drawLine(getX(), getY() - 62, getX() - 1, getY() - 72);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() - 1, getY() - 62, getX() + 3, getY() - 65); 
		g.drawLine(getX(), getY() - 62, getX() - 4, getY() - 65);
		g.setColor(Color.RED);
		g.drawLine(getX() - 1, getY() - 62, getX() + 1, getY() - 70); 
		g.drawLine(getX(), getY() - 62, getX() - 2, getY() - 70);
		////правый двигатель///////////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 6, getY() - 62, getX() + 9, getY() - 68); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 4, getY() - 68);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 6, getY() - 62, getX() + 8, getY() - 72); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 6, getY() - 72);
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 6, getY() - 62, getX() + 10, getY() - 65); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 3, getY() - 65);
		g.setColor(Color.RED);
		g.drawLine(getX() + 6, getY() - 62, getX() + 8, getY() - 70); 
		g.drawLine(getX() + 7, getY() - 62, getX() + 5, getY() - 70);
	}
	public void paintFlashBeaconAnimation(final Graphics g)
	{
		g.setColor(Color.RED);
		////right////
		g.drawLine(getX() + 33, getY() - 45, getX() + 33, getY() - 47); // - 85
		g.drawLine(getX() + 33, getY() - 45, getX() + 33, getY() - 43);
		
		g.drawLine(getX() + 33, getY() - 45, getX() + 31, getY() - 45);
		g.drawLine(getX() + 33, getY() - 45, getX() + 35, getY() - 45);
		
		g.drawLine(getX() + 33, getY() - 45, getX() + 31, getY() - 43);
		g.drawLine(getX() + 33, getY() - 45, getX() + 35, getY() - 43);
		
		g.drawLine(getX() + 33, getY() - 45, getX() + 31, getY() - 47);
		g.drawLine(getX() + 33, getY() - 45, getX() + 35, getY() - 47);
		////left////
		g.drawLine(getX() - 27, getY() - 45, getX() - 27, getY() - 47);
		g.drawLine(getX() - 27, getY() - 45, getX() - 27, getY() - 43);
	
		g.drawLine(getX() - 27, getY() - 45, getX() - 25, getY() - 45);
		g.drawLine(getX() - 27, getY() - 45, getX() - 29, getY() - 45);
		
		g.drawLine(getX() - 27, getY() - 45, getX() - 25, getY() - 43);
		g.drawLine(getX() - 27, getY() - 45, getX() - 29, getY() - 43);
		
		g.drawLine(getX() - 27, getY() - 45, getX() - 25, getY() - 47);
		g.drawLine(getX() - 27, getY() - 45, getX() - 29, getY() - 47);
		////center////
		g.drawLine(getX() + 3, getY() - 20, getX() + 3, getY() - 18);
		g.drawLine(getX() + 3, getY() - 20, getX() + 3, getY() - 22);
		
		g.drawLine(getX() + 3, getY() - 20, getX() + 1, getY() - 20);
		g.drawLine(getX() + 3, getY() - 20, getX() + 5, getY() - 20);
			
		g.drawLine(getX() + 3, getY() - 20, getX() + 1, getY() - 22);
		g.drawLine(getX() + 3, getY() - 20, getX() + 5, getY() - 22);
		
		g.drawLine(getX() + 3, getY() - 20, getX() + 1, getY() - 18);
		g.drawLine(getX() + 3, getY() - 20, getX() + 5, getY() - 18);
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
				g.drawLine(getGameFild().getTargetEnemy().getX() + 24, getGameFild().getTargetEnemy().getY() - 62, getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 62);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 62, getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 54);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 24, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() + 2);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 6);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() - 19, getGameFild().getTargetEnemy().getY() + 2);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() + 2, getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 6);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 62, getGameFild().getTargetEnemy().getX() - 19, getGameFild().getTargetEnemy().getY() - 62);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 62, getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 54);
				g.drawLine(getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 35, getGameFild().getTargetEnemy().getX() - 27, getGameFild().getTargetEnemy().getY() - 27);
				g.drawLine(getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 35, getGameFild().getTargetEnemy().getX() + 32, getGameFild().getTargetEnemy().getY() - 27);
			}
		}
	}
}
