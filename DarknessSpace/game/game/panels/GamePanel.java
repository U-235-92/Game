package game.panels;

import game.Player;
import game.Shoot;
import game.animationsDestroyEnemy_And_Shoots.AnimationDestroyEnemyTypeX;
import game.animationsDestroyEnemy_And_Shoots.AnimationDestroyShoot;
import game.bonuses.HealthBonus;
import game.bonuses.RepairBonus;
import game.bonuses.ShootBonus;
import game.bonuses.UnknownWeaponBonus;
import game.enemies.CarrierEnemyType1;
import game.enemies.EnemyType1;
import game.enemies.EnemyType2;
import game.enemies.EnemyType3;
import game.enemies.EnemyType4;
import game.enemies.RamEnemyType1;
import game.enemies.RamEnemyType2;
import game.enemies.RamEnemyType3;
import game.fields.GameField;
import game.guns.VoidHunter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel 
{
	private GameField gameField;
	private Image image;
	private boolean backToMenuInduced = false;
	private boolean continueInduced = false;
	private boolean exitInduced = false;
	private boolean noInduced = false;
	private boolean yesInduced = false;
	private boolean noExitInduced = false;
	private boolean yesExitInduced = false;
	private boolean backMenuClicked = false;
	private boolean exitClicked = false;
	public GamePanel(GameField fild) 
	{
		this.gameField = fild;
	}
	public boolean isNoExitInduced()
	{
		return noExitInduced;
	}
	public void setNoExitInduced(boolean noExitInduced)
	{
		this.noExitInduced = noExitInduced;
	}
	public boolean isYesExitInduced()
	{
		return yesExitInduced;
	}
	public void setYesExitInduced(boolean yesExitInduced) 
	{
		this.yesExitInduced = yesExitInduced;
	}
	public boolean isExitClicked()
	{
		return exitClicked;
	}
	public void setExitClicked(boolean exitClicked)
	{
		this.exitClicked = exitClicked;
	}
	public boolean isExitInduced() 
	{
		return exitInduced;
	}
	public void setExitInduced(boolean exitInduced)
	{
		this.exitInduced = exitInduced;
	}
	public boolean isNoInduced()
	{
		return noInduced;
	}
	public void setNoInduced(boolean noInduced) 
	{
		this.noInduced = noInduced;
	}
	public boolean isYesInduced()
	{
		return yesInduced;
	}
	public void setYesInduced(boolean yesInduced) 
	{
		this.yesInduced = yesInduced;
	}
	public boolean isBackMenuClicked() 
	{
		return backMenuClicked;
	}
	public void setBackMenuClicked(boolean backMenuClicked)
	{
		this.backMenuClicked = backMenuClicked;
	}
	public boolean isBackToMenuInduced()
	{
		return backToMenuInduced;
	}
	public void setBackToMenuInduced(boolean backToMenuInduced) 
	{
		this.backToMenuInduced = backToMenuInduced;
	}
	public boolean isContinueInduced()
	{
		return continueInduced;
	}
	public void setContinueInduced(boolean continueInduced) 
	{
		this.continueInduced = continueInduced;
	}
	private void paintBackToMenuButton(Graphics g)
	{
		if(backToMenuInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backToMenuClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 390, 260,
					240, 37, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backToMenuReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 390, 260,
					240, 37, null);
		}
	}
	private void paintContinueButton(Graphics g)
	{
		if(continueInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Continue\\continueClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 440, 200,
					133, 38, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Continue\\continueReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 440, 200,
					133, 38, null);
		}
		repaint();
	}
	private void paintExitButton(Graphics g)
	{
		if(exitInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Exit\\exitClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 470, 320,
					70, 35, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Exit\\exitReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 470, 320,
					70, 35, null);
		}
	}
	private void paintYesButton(Graphics g)
	{
		if(yesInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Yes\\yesClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 410, 275,
					58, 41, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Yes\\yesReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 410, 275,
					58, 41, null);
		}
		repaint();
	}
	private void paintNoButton(Graphics g)
	{
		if(noInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\No\\noClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 545, 280,
					44, 29, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\No\\noReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 545, 280,
					44, 29, null);
		}
		repaint();
	}
	private void paintYesExitButton(Graphics g)
	{
		if(yesExitInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Yes\\yesClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 410, 275,
					58, 41, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Yes\\yesReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 410, 275,
					58, 41, null);
		}
		repaint();
	}
	private void paintNoExitButton(Graphics g)
	{
		if(noExitInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\No\\noClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 545, 280,
					44, 29, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\No\\noReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 545, 280,
					44, 29, null);
		}
		repaint();
	}
	private void paintPauseMenu(Graphics g)
	{
		int width = 300;
		int height = 200;
		int X = 355;
		int Y = 180;
		g.setColor(Color.WHITE);
		g.drawRect(X, Y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(X + 1, Y + 1, width - 1, height - 1);
	}
	private void paintChoiceMenu(Graphics g)
	{
		int width = 280;
		int height = 100;
		int X = 365;
		int Y = 230;
		g.setColor(Color.WHITE);
		g.drawRect(X, Y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(X + 1, Y + 1, width - 1, height - 1);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 17));
		g.setColor(Color.WHITE);
		g.drawString("All results will be lost. Continue? ", X + 15, Y + 30);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		////////////////////
		/////BACKGROUND/////
		////////////////////
		gameField.getBackground().paintBackground1(g);
		gameField.getBackground().paintBackground2(g);
		////////////////
		/////PLAYER/////
		////////////////
		double newY;
		for(Player player : gameField.getPlayers())
		{
			player.paintPlayer(g);
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 100)
				{
					player.paintFlashBeaconAnimation(g);
				}
				if(newY > 200 && newY < 300)
				{
					player.paintFlashBeaconAnimation(g);
				}
				if(newY > 400 && newY < 500)
				{
					player.paintFlashBeaconAnimation(g);
				}
			}
			if(player.isShotGreenShoot() == true && gameField.isFlag() == true 
					&& gameField.isShootDualGreenFlag() == false && gameField.isShootTripleFlag() == false
					&& gameField.isShootMachinegunFlag() == false && gameField.isShootVoidHunterFlag() == false
					&& gameField.isShootPlasmaGunFlag() == false && gameField.isShootUnknownFlag() == false)
			{
				player.paintAnimationGreenShoot(g);
				gameField.setFlag(false);
			}
			if(player.isShotMashinegun() == true && gameField.isFlag() == true
					&& gameField.isShootMachinegunFlag() == true)
			{
				player.paintAnimationMashinegunShoot(g);
				gameField.setFlag(false);
			}
			if(player.isShotTripleShoot() == true && gameField.isFlag() == true
					&& gameField.isShootTripleFlag() == true)
			{
				player.paintAnimationTripleShoot(g);
				gameField.setFlag(false);
			}
			if(player.isShotUnknown() == true && gameField.isFlag() == true
					&& gameField.isShootUnknownFlag() == true)
			{
				player.paintAnimationUnknownShoot(g);
				gameField.setFlag(false);
			}
			if(player.isPlasmaGun() == true && gameField.isFlag() == true
					&& gameField.isShootPlasmaGunFlag() == true)
			{
				player.paintAnimationPlasmaGunShoot(g);
				gameField.setFlag(false);
			}
			if(player.isShotDualGreenShoot() == true && gameField.isFlag() == true
					&& gameField.isShootDualGreenFlag() == true)
			{
				player.paintAnimationDualGreenShoot(g);
				gameField.setFlag(false);
			}
			player.paintFlameFromEngine1(g);
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 50)
				{
					player.paintFlameFromEngine1(g);
				}
				if(newY > 50 && newY < 100)
				{
					player.paintFlameFromEngine2(g);
					player.paintFlameFromEngine3(g);
				}
				if(newY > 100 && newY < 150)
				{
					player.paintFlameFromEngine1(g);
				}
				if(newY > 150 && newY < 200)
				{
					player.paintFlameFromEngine1(g);
					player.paintFlameFromEngine3(g);
				}
				if(newY > 250 && newY < 300)
				{
					player.paintFlameFromEngine2(g);
				}
				if(newY > 350 && newY < 400)
				{
					player.paintFlameFromEngine1(g);
					player.paintFlameFromEngine3(g);
				}
				if(newY > 450 && newY < 500)
				{
					player.paintFlameFromEngine2(g);
				}
				if(newY > 550 && newY < 600)
				{
					player.paintFlameFromEngine1(g);
					player.paintFlameFromEngine3(g);
				}
				if(newY > 650 && newY < 700)
				{
					player.paintFlameFromEngine2(g);
				}
			}
			if(gameField.isShieldActivated() == true)
			{
				player.paintShield(g);
				repaint();
			}
		}
		for(Shoot shootPlayer : gameField.getShootsPlayer())
		{
			shootPlayer.paintShoot(g);
		}
		////////////////////
		////VOID HUNTER/////
		////////////////////
		for(final VoidHunter voidHunter : gameField.getVoidHunters())
		{
			voidHunter.paintShoot(g);
			for(int i = 0; i <= 60; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 20)
				{
					voidHunter.paintAnimationShoot1(g);
				}
				if(newY > 20 && newY < 40)
				{
					voidHunter.paintAnimationShoot2(g);
				}
				if(newY > 40 && newY < 60)
				{
					voidHunter.paintAnimationShoot3(g);
				}
			}
		}
		/////////////////////
		/////ENEMY TYPE1/////
		/////////////////////
		for(Shoot shootEnemyType1 : gameField.getShootsEnemyType1())
		{
			shootEnemyType1.paintShoot(g);
		}
		for(EnemyType1 enemyType1 : gameField.getEnemiesType1())
		{
			enemyType1.paintEnemy(g);
			if(gameField.isLockEnemyType1() == true)
			{
				enemyType1.paintLockTarget(g); ////LOCK TARGET/////
			}
			enemyType1.paintAnimationEngineEnemyType1_2(g);
			if(enemyType1.isShootEnemyType1() == true &&
					enemyType1.isEnemyCreateShoot() == true)
			{
				enemyType1.paintAnimationShootEnemyType1(g);
				enemyType1.setEnemyCreateShoot(false);
			}
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 50)
				{
					enemyType1.paintAnimationEngineEnemyType1_1(g);
				}
				if(newY > 50 && newY < 100)
				{
					enemyType1.paintAnimationEngineEnemyType1_2(g);
				}
				if(newY > 100 && newY < 150)
				{
					enemyType1.paintAnimationEngineEnemyType1_3(g);
				}
				if(newY > 150 && newY < 200)
				{
					enemyType1.paintAnimationEngineEnemyType1_1(g);
				}
				if(newY > 250 && newY < 300)
				{
					enemyType1.paintAnimationEngineEnemyType1_2(g);
				}
				if(newY > 350 && newY < 400)
				{
					enemyType1.paintAnimationEngineEnemyType1_3(g);
				}
				if(newY > 450 && newY < 500)
				{
					enemyType1.paintAnimationEngineEnemyType1_1(g);
				}
				if(newY > 550 && newY < 600)
				{
					enemyType1.paintAnimationEngineEnemyType1_2(g);
				}
				if(newY > 600 && newY < 650)
				{
					enemyType1.paintAnimationEngineEnemyType1_3(g);
				}
			}
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 100)
				{
					enemyType1.paintFlashBeaconAnimation(g);
				}
				if(newY > 200 && newY < 300)
				{
					enemyType1.paintFlashBeaconAnimation(g);
				}
				if(newY > 400 && newY < 500)
				{
					enemyType1.paintFlashBeaconAnimation(g);
				}
			}
		}
		/////////////////////
		/////ENEMY TYPE2/////
		/////////////////////
		for(Shoot shootEnemyType2 : gameField.getShootsEnemyType2())
		{
			shootEnemyType2.paintShoot(g);
		}
		for(EnemyType2 enemyType2 : gameField.getEnemiesType2())
		{
			enemyType2.paintEnemy(g);
			if(gameField.isLockEnemyType2() == true)
			{
				enemyType2.paintLockTarget(g); ////LOCK TARGET/////
			}
			if(enemyType2.isShootEnemyType2() == true &&
					enemyType2.isEnemyCreateShoot() == true)
			{
				enemyType2.paintAnimationShootEnemyType2(g);
				enemyType2.setEnemyCreateShoot(false);
			}
			for(int i = 0; i <= 60; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 10)
				{
					enemyType2.paintAnimationEngineEnemyType2_1(g);
				}
				if(newY > 10 && newY < 20)
				{
				enemyType2.paintAnimationEngineEnemyType2_2(g);
				}
				if(newY > 20 && newY < 30)
				{
					enemyType2.paintAnimationEngineEnemyType2_3(g);
				}
				if(newY > 30 && newY < 40)
				{
					enemyType2.paintAnimationEngineEnemyType2_4(g);
				}
				if(newY > 40 && newY < 50)
				{
					enemyType2.paintAnimationEngineEnemyType2_5(g);
				}
				if(newY > 50 && newY < 60)
				{
					enemyType2.paintAnimationEngineEnemyType2_6(g);
				}
			}
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 100)
				{
					enemyType2.paintFlashBeaconAnimation(g);
				}
				if(newY > 200 && newY < 300)
				{
					enemyType2.paintFlashBeaconAnimation(g);
				}
				if(newY > 400 && newY < 500)
				{
					enemyType2.paintFlashBeaconAnimation(g);
				}
			}
		}
		/////////////////////
		/////ENEMY TYPE3/////
		/////////////////////
		for(Shoot shootEnemyType3 : gameField.getShootsEnemyType3())
		{
			shootEnemyType3.paintShoot(g);
		}
		for(EnemyType3 enemyType3 : gameField.getEnemiesType3())
		{
			enemyType3.paintEnemy(g);
			if(gameField.isLockEnemyType3() == true)
			{
				enemyType3.paintLockTarget(g); ////LOCK TARGET/////
			}
			if(enemyType3.isShootEnemyType3() == true &&
					enemyType3.isEnemyCreateShoot() == true)
			{
				enemyType3.paintAnimationShootEnemyType3(g);
				enemyType3.setEnemyCreateShoot(false);
			}
			for(int i = 0; i <= 150; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 50)
				{
					enemyType3.paintAnimationEngineEnemyType3_1(g);
				}
				if(newY > 50 && newY < 100)
				{
					enemyType3.paintAnimationEngineEnemyType3_2(g);
				}
				if(newY > 100 && newY < 150)
				{
					enemyType3.paintAnimationEngineEnemyType3_3(g);
				}
			}
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 100)
				{
					enemyType3.paintFlashBeaconAnimation(g);
				}
				if(newY > 200 && newY < 300)
				{
					enemyType3.paintFlashBeaconAnimation(g);
				}
				if(newY > 400 && newY < 500)
				{
					enemyType3.paintFlashBeaconAnimation(g);
				}
			}
		}
		/////////////////////
		/////ENEMY TYPE4/////
		/////////////////////
		for(Shoot shootEnemyType4 : gameField.getShootsEnemyType4())
		{
			shootEnemyType4.paintShoot(g);
		}
		for(EnemyType4 enemyType4 : gameField.getEnemiesType4())
		{
			enemyType4.paintEnemy(g);
			if(gameField.isLockEnemyType4() == true)
			{
				enemyType4.paintLockTarget(g); ////LOCK TARGET/////
			}
			if(enemyType4.isShootEnemyType4() == true &&
					enemyType4.isEnemyCreateShoot() == true)
			{
				enemyType4.paintAnimationShootEnemyType4(g);
				enemyType4.setEnemyCreateShoot(false);
			}
//			enemyType4.paintAnimationEngineEnemyType4_1(g);
			for(int i = 0; i <= 60; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 10)
				{
					enemyType4.paintAnimationEngineEnemyType4_1(g);
				}
				if(newY > 10 && newY < 20)
				{
					enemyType4.paintAnimationEngineEnemyType4_2(g);
				}
				if(newY > 20 && newY < 30)
				{
					enemyType4.paintAnimationEngineEnemyType4_3(g);
				}
				if(newY > 30 && newY < 40)
				{
					enemyType4.paintAnimationEngineEnemyType4_4(g);
				}
				if(newY > 40 && newY < 50)
				{
					enemyType4.paintAnimationEngineEnemyType4_5(g);
				}
				if(newY > 50 && newY < 60)
				{
					enemyType4.paintAnimationEngineEnemyType4_6(g);
				}
			}
			for(int i = 0; i < (gameField.getStarDusts().size() + 1) - gameField.getStarDusts().size(); i++)
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 100)
				{
					enemyType4.paintFlashBeaconAnimation(g);
				}
				if(newY > 200 && newY < 300)
				{
					enemyType4.paintFlashBeaconAnimation(g);
				}
				if(newY > 400 && newY < 500)
				{
					enemyType4.paintFlashBeaconAnimation(g);
				}
			}
		}
		/////////////////////////
		/////RAM ENEMY TYPE1/////
		/////////////////////////
		for(Shoot shootRamEnemyType1 : gameField.getShootsRamEnemyType1())
		{
			shootRamEnemyType1.paintShoot(g);
		}
		for(RamEnemyType1 ramEnemyType1 : gameField.getRamEnemiesType1())
		{
			ramEnemyType1.paintEnemy(g);
			if(ramEnemyType1.isShootRamEnemyType1() == true &&
					ramEnemyType1.isEnemyCreateShoot() == true)
			{
				ramEnemyType1.paintAnimationShootRamEnemyType1(g);
				ramEnemyType1.setEnemyCreateShoot(false);
			}
		}
		/////////////////////////
		/////RAM ENEMY TYPE2/////
		/////////////////////////
		for(RamEnemyType2 ramEnemyType2 : gameField.getRamEnemiesType2())
		{
			ramEnemyType2.paintEnemy(g);
		}
		/////////////////////////
		/////RAM ENEMY TYPE3/////
		/////////////////////////
		for(RamEnemyType3 ramEnemyType3 : gameField.getRamEnemiesType3())
		{
			ramEnemyType3.paintEnemy(g);
		}
		/////////////////////////////
		/////ENEMY CARRIER TYPE1/////
		/////////////////////////////
		for(Shoot shootCarrierEnemyType1 : gameField.getShootsCarrierEnemyType1())
		{
			shootCarrierEnemyType1.paintShoot(g);
		}
		for(CarrierEnemyType1 enemyCarrierType1 : gameField.getEnemyCarrierType1())
		{
			enemyCarrierType1.paintEnemy(g);
			if(gameField.isLockEnemyCarrierType1() == true)
			{
				enemyCarrierType1.paintLockTarget(g); ////LOCK TARGET/////
			}
			if(enemyCarrierType1.isShootCarrierEnemyType1() == true &&
					enemyCarrierType1.isEnemyCreateShoot() == true)
			{
				enemyCarrierType1.paintAnimationShootCarrierEnemyType1(g);
				if(enemyCarrierType1.getCheckHalfArmorCarrierType1() == 4)
				{
					enemyCarrierType1.paintAnimationShootCarrierEnemyType1_2(g);
				}
				enemyCarrierType1.setEnemyCreateShoot(false);
			}
			//enemyCarrierType1.paintAnimationDestroyCarrierEnemyType1_2(g);
			for(int i = 0; i <= 40; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 10)
				{
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_1(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_4(g);
				}
				if(newY > 10 && newY < 20)
				{
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_1(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_2(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_5(g);
				}
				if(newY > 20 && newY < 30)
				{
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_1(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_3(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_6(g);
				}
				if(newY > 30 && newY < 40)
				{
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_1(g);
					enemyCarrierType1.paintAnimationEngineCarrierEnemyType1_7(g);
				}
			}
		}
		///////////////////
		////SHOOT BONUS////
		///////////////////
		//fild.getShootBonus().paintBonus(g);
		for(ShootBonus shootBonus : gameField.getShootBonuses())
		{
			for(int i = 0; i <= 120; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 40)
				{
					shootBonus.paintAnimationShootBonus1_1(g);
				}
				if(newY > 40 && newY < 80)
				{
					shootBonus.paintAnimationShootBonus1_2(g);
				}
				if(newY > 80 && newY < 120)
				{
					shootBonus.paintAnimationShootBonus1_3(g);
				}
			}
		}
		for(UnknownWeaponBonus bonus : gameField.getUnknownBonus())
		{
			for(int i = 0; i <= 180; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 40)
				{
					bonus.paintAnimation1(g);
				}
				if(newY > 40 && newY < 80)
				{
					bonus.paintAnimation2(g);
				}
				if(newY > 80 && newY < 120)
				{
					bonus.paintAnimation3(g);
				}
				if(newY > 120 && newY < 140)
				{
					bonus.paintAnimation4(g);
				}
				if(newY > 140 && newY < 160)
				{
					bonus.paintAnimation5(g);
				}
				if(newY > 160 && newY < 180)
				{
					bonus.paintAnimation6(g);
				}
			}
		}
		////////////////////
		////HEALTH BONUS////
		////////////////////
		for(HealthBonus healthBonus : gameField.getHealthBonuses())
		{
			for(int i = 0; i <= 140; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 40)
				{
					healthBonus.paintAnimation1(g);
				}
				if(newY > 40 && newY < 80)
				{
					healthBonus.paintAnimation2(g);
				}
				if(newY > 80 && newY < 120)
				{
					healthBonus.paintAnimation3(g);
				}
				if(newY > 120 && newY < 140)
				{
					healthBonus.paintAnimation4(g);
				}
			}
		}
		////////////////////
		////REPAIR BONUS////
		////////////////////
		for(RepairBonus repairBonus : gameField.getRepairBonuses())
		{
			for(int i = 0; i <= 200; i = i + 1) 
			{
				newY = gameField.getStarDusts().get(i).getY();
				if(newY > 0 && newY < 50)
				{
					repairBonus.paintAnimation1(g);
				}
				if(newY > 50 && newY < 100)
				{
					repairBonus.paintAnimation2(g);
				}
				if(newY > 100 && newY < 150)
				{
					repairBonus.paintAnimation1(g);
				}
				if(newY > 150 && newY < 200)
				{
					repairBonus.paintAnimation2(g);
				}
			}
		}
		///////////////////////////////
		////ANIMATION DESTROY ENEMY////
		///////////////////////////////
		for(AnimationDestroyEnemyTypeX animation : gameField.getAnimationDestroyEnemyTypeX())
		{
			if(gameField.isEnemyDestroy() == true)
			{
				animation.paintAnimationDestroyOject(g);
			}
			else if(gameField.isCarrierType1Destroy() == true && gameField.isCarrierDestroy() == true)
			{
				animation.paintAnimationDestroyCarrierEnemyType1_1(g);
				animation.paintAnimationDestroyCarrierEnemyType1_2(g);
				animation.paintAnimationDestroyCarrierEnemyType1_3(g);
				animation.paintAnimationDestroyCarrierEnemyType1_4(g);
				animation.paintAnimationDestroyCarrierEnemyType1_5(g);
			}
		}
		///////////////////////////////
		////ANIMATION DESTROY SHOOT////
		///////////////////////////////
		for(AnimationDestroyShoot animation : gameField.getAnimationDestroyShoot())
		{
			if(gameField.isShootDestroy() == true)
			{
				animation.paintAnimationDestroyOject(g);
			}
		}
		//////////////////
		////PAUSE MENU////
		//////////////////
		if(gameField.isPause() == true)
		{
			paintPauseMenu(g);
			paintContinueButton(g);
			paintBackToMenuButton(g);
			paintExitButton(g);
			if(backMenuClicked == true)
			{
				paintChoiceMenu(g);
				paintYesButton(g);
				paintNoButton(g);
			}
			if(exitClicked == true)
			{
				paintChoiceMenu(g);
				paintYesExitButton(g);
				paintNoExitButton(g);
			}
		}
		//////////////////
		////STATISTICS////
		//////////////////
		gameField.getStatistics().paintStatistic(g);
	}
}
