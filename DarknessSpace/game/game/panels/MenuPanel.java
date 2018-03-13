package game.panels;

import game.fields.GameField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPanel extends JPanel
{
	private Image image;
	private GameField gameField;
	
	private boolean newGameInduced = false;
	private boolean optionsInduced = false;
	private boolean exitInduced = false;
	private boolean backInduced = false;
	private boolean continueInduced = false;
	private boolean noInduced = false;
	private boolean yesInduced = false;
	private boolean bestScoreInduced = false;
	private boolean optionsOn = false;
	private boolean exitClicked = false;
	private boolean bestScoreClicked = false;
	public MenuPanel(GameField gameField)
	{
		this.gameField = gameField;
	}
	public boolean isBestScoreClicked()
	{
		return bestScoreClicked;
	}
	public void setBestScoreClicked(boolean bestScoreClicked) 
	{
		this.bestScoreClicked = bestScoreClicked;
	}
	public boolean isBestScoreInduced() 
	{
		return bestScoreInduced;
	}
	public void setBestScoreInduced(boolean bestScoreInduced)
	{
		this.bestScoreInduced = bestScoreInduced;
	}
	public boolean isExitClicked()
	{
		return exitClicked;
	}
	public void setExitClicked(boolean exitClicked)
	{
		this.exitClicked = exitClicked;
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
	public boolean isNewGameInduced()
	{
		return newGameInduced;
	}
	public void setNewGameInduced(boolean newGameInduced)
	{
		this.newGameInduced = newGameInduced;
	}
	public boolean isOptionsInduced()
	{
		return optionsInduced;
	}
	public void setOptionsInduced(boolean optionsInduced) 
	{
		this.optionsInduced = optionsInduced;
	}
	public boolean isExitInduced() 
	{
		return exitInduced;
	}
	public void setExitInduced(boolean exitInduced) 
	{
		this.exitInduced = exitInduced;
	}
	public boolean isBackInduced() 
	{
		return backInduced;
	}
	public void setBackInduced(boolean backInduced) 
	{
		this.backInduced = backInduced;
	}
	public boolean isContinueInduced() 
	{
		return continueInduced;
	}
	public void setContinueInduced(boolean continueInduced) 
	{
		this.continueInduced = continueInduced;
	}
	public boolean isOptionsOn() 
	{
		return optionsOn;
	}
	public void setOptionsOn(boolean optionsOn)
	{
		this.optionsOn = optionsOn;
	}
	private void paintNewGameButton(Graphics g)
	{
		if(newGameInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\NewGame\\newGameClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 110, 260,
					152, 32, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\NewGame\\newGameReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 110, 260,
					152, 32, null);
		}
		repaint();
	}
	private void paintOptionsButton(Graphics g)
	{
		if(optionsInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Options\\optionsClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 125, 310,
					126, 42, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Options\\optionsReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 125, 310,
					126, 42, null);
		}
	}
	private void paintBestScoreButton(Graphics g)
	{
		if(bestScoreInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\BestScore\\bestScoreClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 100, 360,
					182, 39, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\BestScore\\bestScoreReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 100, 360,
					182, 39, null);
		}
		repaint();
	}
	private void paintExitButton(Graphics g)
	{
		if(exitInduced == true)
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Exit\\exitClicked.png"); 
			image = img.getImage();
			g.drawImage(image, 150, 410,
					70, 35, null);
		}
		else
		{
			ImageIcon img = new ImageIcon("Images\\Buttons\\Exit\\exitReleased.png"); 
			image = img.getImage();
			g.drawImage(image, 150, 410,
					70, 35, null);
		}
	}
	private void paintBackButton(Graphics g)
	{
		if(optionsOn == true)
		{
			if(backInduced == true)
			{
				ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backClicked.png"); 
				image = img.getImage();
				g.drawImage(image, 460, 530,
						86, 35, null);
			}
			else
			{
				ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backReleased.png"); 
				image = img.getImage();
				g.drawImage(image, 460, 530,
						86, 35, null);
			}
		}
		else if(bestScoreClicked == true)
		{
			if(backInduced == true)
			{
				ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backClicked.png"); 
				image = img.getImage();
				g.drawImage(image, 470, 280,
						86, 35, null);
			}
			else
			{
				ImageIcon img = new ImageIcon("Images\\Buttons\\Back\\backReleased.png"); 
				image = img.getImage();
				g.drawImage(image, 470, 280,
						86, 35, null);
			}
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
	private void paintBackgroundMenu(Graphics g)
	{
		ImageIcon img = new ImageIcon("Images\\Backgrounds\\menuBackground.jpg"); 
		image = img.getImage();
		g.drawImage(image, 0, 0,
				gameField.getWidth(), gameField.getHeight() + 80, null);
	}
	private void paintBackgroundOptions(Graphics g)
	{
		ImageIcon img = new ImageIcon("Images\\Backgrounds\\optionsBackground.jpg"); 
		image = img.getImage();
		g.drawImage(image, 0, 0,
				gameField.getWidth() + 2, gameField.getHeight() + 80, null);
	}
	private void paintAreaOptions(Graphics g)
	{
		int width = 600;
		int height = 500;
		int X = 200;
		int Y = 100;
		Color myColor = new Color(104, 106, 104);
		g.setColor(Color.WHITE);
		g.drawRect(X, Y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(X + 1, Y + 1, width - 1, height - 1);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.WHITE);
		g.setColor(myColor);
		g.drawString("MOVEMENT", X + 30, Y + 50);
		g.setColor(Color.WHITE);
		g.drawString("Move Forward ............................................... ", X + 50, Y + 80);
		g.drawString("Move Backward ............................................ ", X + 50, Y + 110);
		g.drawString("Move Right .................................................... ", X + 50, Y + 140);
		g.drawString("Move Left ....................................................... ", X + 50, Y + 170);
		
		g.drawString("UP ARROW", X + 420, Y + 80);
		g.drawString("DOWN ARROW", X + 420, Y + 110);
		g.drawString("RIGHT ARROW", X + 420, Y + 140);
		g.drawString("LEFT ARROW", X + 420, Y + 170);
		
		g.setColor(myColor);
		g.drawString("SHOOTING", X + 30, Y + 200);
		g.setColor(Color.WHITE);
		g.drawString("Fire ................................................................. ", X + 50, Y + 230);
		g.drawString("Choice Weapon ............................................. ", X + 50, Y + 260);
		g.drawString("Default Weapon ............................................. ", X + 50, Y + 290);
		
		g.drawString("SPACE", X + 420, Y + 230);
		g.drawString("KEYS 1 - 6", X + 420, Y + 260);
		g.drawString("KEY Q", X + 420, Y + 290);
		
		g.setColor(myColor);
		g.drawString("CHRONOMETER", X + 30, Y + 320);
		g.setColor(Color.WHITE);
		g.drawString("Use Chronometer ......................................... ", X + 50, Y + 350);
		
		g.drawString("KEY C", X + 420, Y + 350);
		
		g.setColor(myColor);
		g.drawString("MENU / PAUSE", X + 30, Y + 380);
		g.setColor(Color.WHITE);
		g.drawString("Keyboard ....................................................... ", X + 50, Y + 410);
		
		g.drawString("KEY ESC", X + 420, Y + 410);
	}
	private void paintChoiceMenu(Graphics g) throws FileNotFoundException
	{
		int width = 280;
		int height = 0;
		if(bestScoreClicked == true)
		{
			height = 100;
		}
		else if(exitClicked == true)
		{
			height = 100;
		}
		int X = 365;
		int Y = 230;
		g.setColor(Color.WHITE);
		g.drawRect(X, Y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(X + 1, Y + 1, width - 1, height - 1);
		g.setColor(Color.WHITE);
		g.setColor(Color.WHITE);
		if(exitClicked == true)
		{
			g.setFont(new Font("Arial", Font.BOLD, 17));
			g.drawString("Continue?", X + 100, Y + 30);
		}
		else if(bestScoreClicked == true)
		{
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Best Score:", X + 10, Y + 30);
			String addresFile = "C:\\DarknessSpace\\BestScore\\score.txt";
			File file = new File(addresFile);
			if(file.exists() == false)
			{
				g.drawString("0", X + 125, Y + 30);
			}
			else
			{
				String readScore = "";
				Scanner in = new Scanner(new File(addresFile));
				while(in.hasNext())
				{
					readScore += in.nextLine();
				}
				in.close();
				g.drawString(readScore, X + 125, Y + 30);
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(optionsOn == false)
		{
			paintBackgroundMenu(g);
			paintNewGameButton(g);
			paintOptionsButton(g);
			paintBestScoreButton(g);
			paintExitButton(g);
			if(exitClicked == true)
			{
				try
				{
					paintChoiceMenu(g);
				} 
				catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				paintYesButton(g);
				paintNoButton(g);
			}
			if(bestScoreClicked == true)
			{
				try 
				{
					paintChoiceMenu(g);
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				paintBackButton(g);
			}
		}
		else
		{
			paintBackgroundOptions(g);
			paintAreaOptions(g);
			paintBackButton(g);
		}
	}
}