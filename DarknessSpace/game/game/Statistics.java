package game;

import java.awt.Color;
import java.awt.Graphics;

import game.fields.GameField;

public class Statistics 
{
	private int x;
	private int y;
	private GameField gameField;
	public Statistics(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField)
	{
		this.gameField = gameField;
	}
	public void paintStatistic(Graphics g)
	{
		if(getGameFild().isPlayerDestroyed() == true || getGameFild().isEndGame() == true)
		{
			g.setColor(Color.RED);
			g.drawRect(getX(), getY(), 500, 520);
			g.setColor(Color.BLACK);
			g.fillRect(getX() + 1, getY() + 1, 499, 519);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", getX() + 210, getY() + 20);// PRESS X TO GO INTO MENU
			g.setColor(Color.RED);
			g.drawString("TOTAL SCORE: " + getGameFild().getScore(), getX() + 200, getY() + 50);
			g.drawString("ELIMINATE ENEMIES:", getX() + 190, getY() + 80);
			g.setColor(Color.YELLOW);
			g.drawString("PRESS X TO GO INTO MENU", getX() + 170, getY() + 500);
			g.setColor(Color.RED);
			g.drawString("............................................."
					+ "................................................"
					+ ".............................  " + getGameFild().getCountEliminateEnemyType1(),
					getX() + 62, getY() + 120);
			g.drawString("............................................."
					+ "................................................"
					+ ".............................  " + getGameFild().getCountEliminateEnemyType2(),
					getX() + 62, getY() + 200);
			g.drawString("............................................."
					+ "................................................"
					+ ".............................  "  + getGameFild().getCountEliminateEnemyType3(),
					getX() + 62, getY() + 290);
			g.drawString("............................................."
					+ "................................................"
					+ ".............................  "  + getGameFild().getCountEliminateEnemyType4(),
					getX() + 62, getY() + 390);
			g.setColor(Color.RED);
			g.drawString("" + getGameFild().getCountEliminateRamEnemyType1(), getX() + 87, getY() + 480);
			g.drawString("" + getGameFild().getCountEliminateRamEnemyType2(), getX() + 240, getY() + 480);
			g.drawString("" + getGameFild().getCountEliminateRamEnemyType3(), getX() + 387, getY() + 480);
			/////////////
			////TYPE1////
			/////////////
			g.setColor(Color.RED);
			////нос/////////////////////
			g.drawLine(getX() + 42, getY() + 110, getX() + 37, getY() + 102);
			g.drawLine(getX() + 42, getY() + 110, getX() + 47, getY() + 102);
			////крылья//////////////////
			g.drawLine(getX() + 37, getY() + 102, getX() + 32, getY() + 118); //left
			g.drawLine(getX() + 47, getY() + 102, getX() + 52, getY() + 118); //right etc.
			g.drawLine(getX() + 32, getY() + 118, getX() + 32, getY() + 96);
			g.drawLine(getX() + 52, getY() + 118, getX() + 52, getY() + 96);
			////переход на двигатель////
			g.drawLine(getX() + 32, getY() + 96, getX() + 37, getY() + 85);
			g.drawLine(getX() + 52, getY() + 96, getX() + 47, getY() + 85);
			g.drawLine(getX() + 37, getY() + 85, getX() + 47, getY() + 85);
			////от двигателя к носу/////
			g.drawLine(getX() + 37, getY() + 85, getX() + 42, getY() + 110);
			g.drawLine(getX() + 47, getY() + 85, getX() + 42, getY() + 110);
			g.drawLine(getX() + 37, getY() + 102, getX() + 32, getY() + 96);
			g.drawLine(getX() + 47, getY() + 102, getX() + 52, getY() + 96);
			/////////////
			////TYPE2////
			/////////////
			g.setColor(Color.RED);
			////нос//////////////////////////////
			g.drawLine(getX() + 42, getY() + 200, getX() + 37, getY() + 188);
			g.drawLine(getX() + 42, getY() + 200, getX() + 47, getY() + 188);
			g.drawLine(getX() + 37, getY() + 188, getX() + 47, getY() + 188);
			////крыло////////////////////////////
			g.drawLine(getX() + 42, getY() + 168, getX() + 57, getY() + 155);
			g.drawLine(getX() + 42, getY() + 168, getX() + 27, getY() + 155);
			////крепление под правое орудие//////
			g.drawLine(getX() + 57, getY() + 155, getX() + 60, getY() + 160);
			g.drawLine(getX() + 60, getY() + 160, getX() + 64, getY() + 156);
			////крепление под левое орудие///////
			g.drawLine(getX() + 27, getY() + 155, getX() + 24, getY() + 160);
			g.drawLine(getX() + 24, getY() + 160, getX() + 20, getY() + 156);
			/////////////////////////////////////
			g.drawLine(getX() + 20, getY() + 156, getX() + 24, getY() + 152);
			g.drawLine(getX() + 64, getY() + 156, getX() + 60, getY() + 152);
			g.drawLine(getX() + 24, getY() + 152, getX() + 28, getY() + 150);
			g.drawLine(getX() + 60, getY() + 152, getX() + 56, getY() + 150);
			////двигатели////////////////////////
			g.drawLine(getX() + 28, getY() + 150, getX() + 34, getY() + 150);
			g.drawLine(getX() + 56, getY() + 150, getX() + 50, getY() + 150);
			////хвост////////////////////////////
			g.drawLine(getX() + 34, getY() + 150, getX() + 42, getY() + 146);
			g.drawLine(getX() + 50, getY() + 150, getX() + 42, getY() + 146);
			////от конуса к креплениям///////////
			g.drawLine(getX() + 47, getY() + 188, getX() + 55, getY() + 157);
			g.drawLine(getX() + 37, getY() + 188, getX() + 29, getY() + 157);
			////от крыла до хвоста///////////////
			g.drawLine(getX() + 42, getY() + 168, getX() + 50, getY() + 150);
			g.drawLine(getX() + 42, getY() + 168, getX() + 34, getY() + 150);
			/////////////
			////TYPE3////
			/////////////
			g.setColor(Color.RED);
			////нос////////
			g.drawLine(getX() + 40, getY() + 290, getX() + 45, getY() + 290);
			g.drawLine(getX() + 45, getY() + 290, getX() + 50, getY() + 275);
			g.drawLine(getX() + 40, getY() + 290, getX() + 35, getY() + 275);
			////фюзеляж///
			g.drawLine(getX() + 50, getY() + 275, getX() + 50, getY() + 235);
			g.drawLine(getX() + 35, getY() + 275, getX() + 35, getY() + 235);
			////двигатели///
			g.drawLine(getX() + 50, getY() + 235, getX() + 48, getY() + 230);
			g.drawLine(getX() + 48, getY() + 230, getX() + 45, getY() + 230);
			g.drawLine(getX() + 45, getY() + 230, getX() + 42, getY() + 235);
		
			g.drawLine(getX() + 35, getY() + 235, getX() + 38, getY() + 230);
			g.drawLine(getX() + 38, getY() + 230, getX() + 41, getY() + 230);
			g.drawLine(getX() + 41, getY() + 230, getX() + 44, getY() + 235);
			////ПГО/////////
			g.drawLine(getX() + 50, getY() + 270, getX() + 55, getY() + 265);
			g.drawLine(getX() + 55, getY() + 265, getX() + 50, getY() + 265);
			g.drawLine(getX() + 35, getY() + 270, getX() + 30, getY() + 265);
			g.drawLine(getX() + 30, getY() + 265, getX() + 35, getY() + 265);
			////крылья//////
			g.drawLine(getX() + 50, getY() + 255, getX() + 70, getY() + 245);
			g.drawLine(getX() + 35, getY() + 255, getX() + 15, getY() + 245);
			g.drawLine(getX() + 50, getY() + 235, getX() + 70, getY() + 245);
			g.drawLine(getX() + 35, getY() + 235, getX() + 15, getY() + 245);
			g.drawLine(getX() + 70, getY() + 250, getX() + 70, getY() + 240);
			g.drawLine(getX() + 15, getY() + 250, getX() + 15, getY() + 240);
			////////////////
			g.drawLine(getX() + 50, getY() + 255, getX() + 42, getY() + 235);
			g.drawLine(getX() + 35, getY() + 255, getX() + 44, getY() + 235);
			////////////////
			g.drawLine(getX() + 42, getY() + 286, getX() + 39, getY() + 278);
			g.drawLine(getX() + 43, getY() + 286, getX() + 46, getY() + 278);
			g.drawLine(getX() + 46, getY() + 278, getX() + 39, getY() + 278);	
			/////////////
			////TYPE4////
			/////////////
			g.setColor(Color.RED);
			////нос////////
			g.drawLine(getX() + 42, getY() + 390, getX() + 52, getY() + 365);
			g.drawLine(getX() + 42, getY() + 390, getX() + 32, getY() + 365);
			g.drawLine(getX() + 52, getY() + 365, getX() + 42, getY() + 350);
			g.drawLine(getX() + 32, getY() + 365, getX() + 42, getY() + 350);
			///////////////
			g.drawLine(getX() + 52, getY() + 365, getX() + 54, getY() + 350);
			g.drawLine(getX() + 32, getY() + 365, getX() + 30, getY() + 350);
			///////////////
			g.drawLine(getX() + 54, getY() + 350, getX() + 62, getY() + 360);
			g.drawLine(getX() + 30, getY() + 350, getX() + 22, getY() + 360);
			g.drawLine(getX() + 62, getY() + 360, getX() + 54, getY() + 355);
			g.drawLine(getX() + 22, getY() + 360, getX() + 30, getY() + 355);
			///
			g.drawLine(getX() + 54, getY() + 350, getX() + 72, getY() + 345);
			g.drawLine(getX() + 30, getY() + 350, getX() + 12, getY() + 345);
			g.drawLine(getX() + 72, getY() + 345, getX() + 57, getY() + 340);
			g.drawLine(getX() + 12, getY() + 345, getX() + 27, getY() + 340);
			g.drawLine(getX() + 57, getY() + 340, getX() + 67, getY() + 330);
			g.drawLine(getX() + 27, getY() + 340, getX() + 17, getY() + 330);
			g.drawLine(getX() + 67, getY() + 330, getX() + 57, getY() + 325);
			g.drawLine(getX() + 17, getY() + 330, getX() + 27, getY() + 325);
			g.drawLine(getX() + 57, getY() + 325, getX() + 54, getY() + 328);
			g.drawLine(getX() + 27, getY() + 325, getX() + 30, getY() + 328);
			g.drawLine(getX() + 54, getY() + 328, getX() + 42, getY() + 320);
			g.drawLine(getX() + 30, getY() + 328, getX() + 42, getY() + 320);
			g.drawLine(getX() + 54, getY() + 328, getX() + 42, getY() + 365);
			g.drawLine(getX() + 30, getY() + 328, getX() + 42, getY() + 365);
			///////////////////////
			////RAM ENEMY TYPE1////
			///////////////////////
			g.setColor(Color.RED);
			g.drawLine(getX() + 90, getY() + 460, getX() + 100, getY() + 445);
			g.drawLine(getX() + 90, getY() + 460, getX() + 80, getY() + 445);
			g.drawLine(getX() + 100, getY() + 445, getX() + 93, getY() + 435);
			g.drawLine(getX() + 80, getY() + 445, getX() + 87, getY() + 435);
			g.drawLine(getX() + 87, getY() + 435, getX() + 93, getY() + 435);
			g.drawLine(getX() + 87, getY() + 435, getX() + 84, getY() + 430);
			g.drawLine(getX() + 93, getY() + 435, getX() + 96, getY() + 430);
			g.drawLine(getX() + 84, getY() + 430, getX() + 84, getY() + 425);
			g.drawLine(getX() + 96, getY() + 430, getX() + 96, getY() + 425);
			g.drawLine(getX() + 84, getY() + 440, getX() + 78, getY() + 430);
			g.drawLine(getX() + 96, getY() + 440, getX() + 102, getY() + 430);
			g.drawLine(getX() + 78, getY() + 430, getX() + 78, getY() + 425);
			g.drawLine(getX() + 102, getY() + 430, getX() + 102, getY() + 425);
			///////////////////////
			////RAM ENEMY TYPE2////
			///////////////////////
			g.setColor(Color.RED);
			g.drawLine(getX() + 242, getY() + 460, getX() + 249, getY() + 430);
			g.drawLine(getX() + 243, getY() + 460, getX() + 236, getY() + 430);
			g.drawLine(getX() + 245, getY() + 455, getX() + 252, getY() + 440);
			g.drawLine(getX() + 240, getY() + 455, getX() + 233, getY() + 440);
			g.drawLine(getX() + 252, getY() + 440, getX() + 254, getY() + 430);
			g.drawLine(getX() + 233, getY() + 440, getX() + 231, getY() + 430);
			g.drawLine(getX() + 254, getY() + 430, getX() + 249, getY() + 430);
			g.drawLine(getX() + 231, getY() + 430, getX() + 236, getY() + 430);
			g.drawLine(getX() + 249, getY() + 430, getX() + 235, getY() + 430);	
			///////////////////////
			////RAM ENEMY TYPE3////
			///////////////////////
			g.setColor(Color.RED);
			g.drawLine(getX() + 390, getY() + 460, getX() + 400, getY() + 430);
			g.drawLine(getX() + 390, getY() + 460, getX() + 380, getY() + 430);
			g.drawLine(getX() + 400, getY() + 430, getX() + 390, getY() + 410);
			g.drawLine(getX() + 380, getY() + 430, getX() + 390, getY() + 410);	
		}
	}
}
