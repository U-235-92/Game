package game;

import game.fields.GameField;
import game.fields.StatsPlayerField;
import game.panels.ChronometerPanel;
import game.panels.CountLifePanel;
import game.panels.DualGunPanel;
import game.panels.GamePanel;
import game.panels.GreenGunPanel;
import game.panels.MachineGunPanel;
import game.panels.MenuPanel;
import game.panels.PercentageArmorPanel;
import game.panels.PlasmaGunPanel;
import game.panels.VoidHunterGunPanel;
import game.panels.ScorePanel;
import game.panels.TripleGunPanel;
import game.panels.UnknownGunPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainGame 
{
	private static int width = 1000;
	private static int height = 600;
	private static boolean gameStart = false;
	private static final JFrame menuFrame = new JFrame("Darkness Space");
	public static void playGame()
	{
		final JFrame gameFrame = new JFrame("Darkness Space");
		final GameField gameField = new GameField(width, height);
		final StatsPlayerField statsPlayerField = new StatsPlayerField(width, 80);
		gameField.addObjects();
		statsPlayerField.addIcons();
		
		final GamePanel gamePanel = new GamePanel(gameField);
		
		JPanel splitterPanel = new JPanel();
		JPanel statusPlayerPanel = new JPanel(); //тут пушки
		final JPanel lifesArmorPlayerPanel = new JPanel(); //тут показания корабля
		
		final ScorePanel scorePanel = new ScorePanel(statsPlayerField);
		final PercentageArmorPanel percentageArmorPanel = new PercentageArmorPanel(statsPlayerField);
		final CountLifePanel countLifePanel = new CountLifePanel(statsPlayerField);
		final ChronometerPanel chronometerPanel = new ChronometerPanel(statsPlayerField);
		
		final GreenGunPanel greenGunPanel = new GreenGunPanel(statsPlayerField);
		final DualGunPanel dualGunPanel = new DualGunPanel(statsPlayerField);
		final TripleGunPanel tripleGunPanel = new TripleGunPanel(statsPlayerField);
		final MachineGunPanel machinegunGunPanel = new MachineGunPanel(statsPlayerField);
		final VoidHunterGunPanel voidHunterGunPanel = new VoidHunterGunPanel(statsPlayerField);
		final PlasmaGunPanel plasmaGunPanel = new PlasmaGunPanel(statsPlayerField);
		final UnknownGunPanel unknownGunPanel = new UnknownGunPanel(statsPlayerField);
		
		splitterPanel.setBackground(Color.BLACK);
		statusPlayerPanel.setBackground(Color.BLACK);
		lifesArmorPlayerPanel.setBackground(Color.BLACK);
		greenGunPanel.setBackground(Color.BLACK);
		dualGunPanel.setBackground(Color.BLACK);
		tripleGunPanel.setBackground(Color.BLACK);
		machinegunGunPanel.setBackground(Color.BLACK);
		voidHunterGunPanel.setBackground(Color.BLACK);
		plasmaGunPanel.setBackground(Color.BLACK);
		unknownGunPanel.setBackground(Color.BLACK);
		scorePanel.setBackground(Color.BLACK);
		percentageArmorPanel.setBackground(Color.BLACK);
		countLifePanel.setBackground(Color.BLACK);
		chronometerPanel.setBackground(Color.BLACK);
		
		lifesArmorPlayerPanel.setPreferredSize(new Dimension(width - 800, 80)); //10
		lifesArmorPlayerPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		splitterPanel.setPreferredSize(new Dimension(1, 80));
		
		statusPlayerPanel.setPreferredSize(new Dimension(width - 200, 80));
		statusPlayerPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(5, 0, 5, 0))); 
		
		scorePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		percentageArmorPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		countLifePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		chronometerPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		statusPlayerPanel.setLayout(new GridLayout(1, 7, 5, 5));
		statusPlayerPanel.add(greenGunPanel);
		statusPlayerPanel.add(dualGunPanel);
		statusPlayerPanel.add(tripleGunPanel);
		statusPlayerPanel.add(machinegunGunPanel);
		statusPlayerPanel.add(voidHunterGunPanel);
		statusPlayerPanel.add(plasmaGunPanel);
		statusPlayerPanel.add(unknownGunPanel);
		
		lifesArmorPlayerPanel.setLayout(new GridLayout(2, 2, 2, 2));
		lifesArmorPlayerPanel.add(scorePanel, BorderLayout.NORTH);
		lifesArmorPlayerPanel.add(percentageArmorPanel, BorderLayout.WEST);
		lifesArmorPlayerPanel.add(countLifePanel, BorderLayout.EAST);
		lifesArmorPlayerPanel.add(chronometerPanel, BorderLayout.SOUTH);
		
		gameFrame.add(lifesArmorPlayerPanel, BorderLayout.WEST);
		gameFrame.add(splitterPanel, BorderLayout.CENTER);
		gameFrame.add(statusPlayerPanel, BorderLayout.EAST);
		gameFrame.add(gamePanel, BorderLayout.SOUTH);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//запрет на использование крестика закрытия
		gameFrame.setResizable(false); //запрет на изменение размера фрейма.
		gamePanel.setPreferredSize(new Dimension(gameField.getWidth(), gameField.getHeight()));
		gamePanel.setBackground(Color.BLACK);
		gamePanel.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent event)
			{
				for(Player player : gameField.getPlayers())
				{
					if(gameField.isCarrierDestroy() == false)
					{
						if(event.getKeyCode() == KeyEvent.VK_UP) 
						{
							gameField.setUpVk(true);
							if(gameField.isSpaceVk() == true)
							{
								gameField.createShootsForPlayer();
							}
							player.up();
						} 
						else if(event.getKeyCode() == KeyEvent.VK_DOWN) 
						{
							gameField.setDownVk(true);
							if(gameField.isSpaceVk() == true)
							{
								gameField.createShootsForPlayer();
							}
							player.down(); 
						}
						else if(event.getKeyCode() == KeyEvent.VK_LEFT) 
						{
							gameField.setLeftVk(true);
							if(gameField.isSpaceVk() == true)
							{
								gameField.createShootsForPlayer();
							}
							player.left(); 
						}
						else if(event.getKeyCode() == KeyEvent.VK_RIGHT) 
						{
							gameField.setRightVk(true);
							if(gameField.isSpaceVk() == true)
							{
								gameField.createShootsForPlayer();
							}
							player.right(); 
						}
					}
				}
				///////////////
				if(gameField.isUpVk() == true && gameField.isRightVk() == true && gameField.isSpaceVk() == true)
				{
					gameField.createShootsForPlayer();
				}
				else if(gameField.isUpVk() == true && gameField.isLeftVk() == true && gameField.isSpaceVk() == true)
				{
					gameField.createShootsForPlayer();
				}
				else if(gameField.isDownVk() == true && gameField.isRightVk() == true && gameField.isSpaceVk() == true)
				{
					gameField.createShootsForPlayer();
				}
				else if(gameField.isDownVk() == true && gameField.isLeftVk() == true && gameField.isSpaceVk() == true)
				{
					gameField.createShootsForPlayer();
				}
				///////////////////
				if(event.getKeyCode() == KeyEvent.VK_SPACE)
				{
					if(gameField.isPause() == false)
					{
						gameField.setSpaceVk(true);
						gameField.createShootsForPlayer();
					}
				}
				if(event.getKeyCode() == KeyEvent.VK_Q)
				{
					gameField.setShootByDefaultFlag(true);
					gameField.setShootDualGreenFlag(false);
					gameField.setShootTripleFlag(false);
					gameField.setShootMachinegunFlag(false);
					gameField.setShootVoidHunterFlag(false);
					gameField.setShootPlasmaGunFlag(false);
					gameField.setShootUnknownFlag(false);
					greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
				}
				else if(event.getKeyCode() == KeyEvent.VK_1)
				{
					if(gameField.isGunDual() == true)
					{
						gameField.setShootDualGreenFlag(true);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootTripleFlag(false);
						gameField.setShootMachinegunFlag(false);
						gameField.setShootVoidHunterFlag(false);
						gameField.setShootPlasmaGunFlag(false);
						gameField.setShootUnknownFlag(false);
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_2)
				{
					if(gameField.isGunTriple() == true)
					{
						gameField.setShootTripleFlag(true);
						gameField.setShootDualGreenFlag(false);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootMachinegunFlag(false);
						gameField.setShootVoidHunterFlag(false);
						gameField.setShootPlasmaGunFlag(false);
						gameField.setShootUnknownFlag(false);
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_3)
				{
					if(gameField.isGunMachinegun() == true)
					{
						gameField.setShootMachinegunFlag(true);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootDualGreenFlag(false);
						gameField.setShootTripleFlag(false);
						gameField.setShootVoidHunterFlag(false);
						gameField.setShootPlasmaGunFlag(false);
						gameField.setShootUnknownFlag(false);
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_4)
				{
					if(gameField.isGunVoidHunter() == true)
					{
						gameField.setShootVoidHunterFlag(true);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootDualGreenFlag(false);
						gameField.setShootTripleFlag(false);
						gameField.setShootMachinegunFlag(false);
						gameField.setShootPlasmaGunFlag(false);
						gameField.setShootUnknownFlag(false);
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_5)
				{
					if(gameField.isGunPlasma() == true)
					{
						gameField.setShootPlasmaGunFlag(true);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootDualGreenFlag(false);
						gameField.setShootTripleFlag(false);
						gameField.setShootMachinegunFlag(false);
						gameField.setShootVoidHunterFlag(false);
						gameField.setShootUnknownFlag(false);
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_6)
				{
					if(gameField.isGunUnknown() == true) 
					{
						gameField.setShootUnknownFlag(true);
						gameField.setShootByDefaultFlag(false);
						gameField.setShootDualGreenFlag(false);
						gameField.setShootTripleFlag(false);
						gameField.setShootMachinegunFlag(false);
						gameField.setShootVoidHunterFlag(false);
						gameField.setShootPlasmaGunFlag(false);
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_C)
				{
					if(gameField.isPause() == false)
					{
						if(gameField.isCarrierDestroy() == false)
						{
							if(gameField.isChronometerAvailable() == true)
							{
								gameField.setChronometerActive(true);
								gameField.setChronometerOn(true);
								if(gameField.isChronometerOn() == true)
								{
									gameField.timerWorkChronometer();
								}
							}
						}
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					gameField.setPause(true);
					gameField.setCountKeyPressed(gameField.getCountKeyPressed() + 1);
					if(gameField.getCountKeyPressed() == 2)
					{
						gamePanel.setBackMenuClicked(false);
						gamePanel.setExitClicked(false);
						gameField.setPause(false);
						gameField.setIndicatorPauseGame(gameField.getIndicatorPauseGame() + 1);
						gameField.setCountKeyPressed(0);
					}
				}
				else if(event.getKeyCode() == KeyEvent.VK_X)
				{
					if(gameField.isPlayerDestroyed() == true)
					{
						gameFrame.setVisible(false);
						menuFrame.setVisible(true);
						gameField.setPlayerDestroyed(false);
						gameStart = false;
					}
					else if(gameField.isEndGame() == true)
					{
						gameFrame.setVisible(false);
						menuFrame.setVisible(true);
						gameField.setEndGame(false);
						gameStart = false;
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					gameField.setUpVk(false);
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					gameField.setDownVk(false);
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					gameField.setLeftVk(false);
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					gameField.setRightVk(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					gameField.setSpaceVk(false);
				}
				for(Player player : gameField.getPlayers())
				{
					player.stop();
				}
			}
		});
		gamePanel.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent e) 
			{
				int mouseX = e.getX();
				int mouseY = e.getY();
				if(mouseX > 440 && mouseX < 570 && mouseY > 210 && mouseY < 240 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false
						&& gamePanel.isExitClicked() == false)
				{
					gamePanel.setContinueInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setContinueInduced(false);
					gamePanel.repaint();
				}
				if(mouseX > 390 && mouseX < 620 && mouseY > 270 && mouseY < 300 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false
						&& gamePanel.isExitClicked() == false)
				{
					gamePanel.setBackToMenuInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setBackToMenuInduced(false);
					gamePanel.repaint();
				}
				if(mouseX > 470 && mouseX < 540 && mouseY > 320 && mouseY < 350
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false
						&& gamePanel.isExitClicked() == false)
				{
					gamePanel.setExitInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setExitInduced(false);
					gamePanel.repaint();
				}
				////backMenu
				if(mouseX > 410 && mouseX < 465 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == true)
				{
					gamePanel.setYesInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setYesInduced(false);
					gamePanel.repaint();
				}
				if(mouseX > 550 && mouseX < 585 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == true)
				{
					gamePanel.setNoInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setNoInduced(false);
					gamePanel.repaint();
				}
				////exitClicked
				if(mouseX > 410 && mouseX < 465 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isExitClicked() == true)
				{
					gamePanel.setYesExitInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setYesExitInduced(false);
					gamePanel.repaint();
				}
				if(mouseX > 550 && mouseX < 585 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isExitClicked() == true)
				{
					gamePanel.setNoExitInduced(true);
					gamePanel.repaint();
				}
				else
				{
					gamePanel.setNoExitInduced(false);
					gamePanel.repaint();
				}
			}
			public void mouseDragged(MouseEvent e)
			{	
			}
		});
		gamePanel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				int mouseX = e.getX();
				int mouseY = e.getY();
				if(mouseX > 440 && mouseX < 570 && mouseY > 210 && mouseY < 240 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false 
						&& gamePanel.isExitClicked() == false)
				{
//					Continue
					gameField.setPause(true);
					gameField.setCountKeyPressed(gameField.getCountKeyPressed() + 1);
					if(gameField.getCountKeyPressed() == 2)
					{
						gamePanel.setBackMenuClicked(false);
						gameField.setPause(false);
						gameField.setIndicatorPauseGame(gameField.getIndicatorPauseGame() + 1);
						gameField.setCountKeyPressed(0);
					}
				}
				else if(mouseX > 390 && mouseX < 620 && mouseY > 270 && mouseY < 300 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false
						&& gamePanel.isExitClicked() == false)
				{
//					Back To Menu
					gamePanel.setBackMenuClicked(true);
				}
				else if(mouseX > 470 && mouseX < 540 && mouseY > 320 && mouseY < 350
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == false
						&& gamePanel.isExitClicked() == false)
				{
//					Exit
					gamePanel.setExitClicked(true);
				}
				else if(mouseX > 410 && mouseX < 465 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == true)
				{
//					Yes
					gameFrame.setVisible(false);
					menuFrame.setVisible(true);
					gameStart = false;
					//переход на главное меню
				}
				else if(mouseX > 550 && mouseX < 585 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isBackMenuClicked() == true)
				{
//					No
					gamePanel.setBackMenuClicked(false);
				}
				else if(mouseX > 410 && mouseX < 465 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isExitClicked() == true)
				{
//					Yes
					System.exit(0);
				}
				else if(mouseX > 550 && mouseX < 585 && mouseY > 280 && mouseY < 310 
						&& gameField.isPause() == true && gamePanel.isExitClicked() == true)
				{
//					No
					gamePanel.setExitClicked(false);
				}
			}
		});
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();	
		gameFrame.pack();
		if(gameStart == false)
		{
			gameFrame.setVisible(false);
		}
		else
		{
			gameFrame.setVisible(true);
		}
		ActionListener updateGame = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(gameField.isPause() == false)
				{
					try 
					{
						gameField.moveObjectsGame();
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					gamePanel.repaint();
					lifesArmorPlayerPanel.repaint();
					/////
					if(gameField.isGunDual() == true)
					{
						statsPlayerField.setFlagForIconDual(true);
					}
					else
					{
						statsPlayerField.setFlagForIconDual(false);
					}
					
					if(gameField.isGunTriple() == true)
					{
						statsPlayerField.setFlagForIconTriple(true);
					}
					else
					{
						statsPlayerField.setFlagForIconTriple(false);
					}
					
					if(gameField.isGunMachinegun() == true)
					{
						statsPlayerField.setFlagForIconMachinegun(true);
					}
					else
					{
						statsPlayerField.setFlagForIconMachinegun(false);
					}
					
					if(gameField.isGunVoidHunter() == true)
					{
						statsPlayerField.setFlagForIconRocket(true);
					}
					else
					{
						statsPlayerField.setFlagForIconRocket(false);
					}
					
					if(gameField.isGunPlasma() == true)
					{
						statsPlayerField.setFlagForIconPlasma(true);
					}
					else
					{
						statsPlayerField.setFlagForIconPlasma(false);
					}
					
					if(gameField.isGunUnknown() == true)
					{
						statsPlayerField.setFlagForIconUncnown(true);
					}
					else
					{
						statsPlayerField.setFlagForIconUncnown(false);
					}
					statsPlayerField.setCountShootMashinegun(gameField.getCountNumberShootsMachinegun());
					statsPlayerField.setCountShootVoidHunter(gameField.getCountNumberShootsVoidHunter());
					statsPlayerField.setCountShootUnknown(gameField.getCountNumberShootsUnknown());
					statsPlayerField.setChronometerOn(gameField.isChronometerOn());
					statsPlayerField.setIntervalWorkChronometer(gameField.getIntervalWorkChronometer());
					/////
					if(gameField.isGunDual() == false && gameField.isGunTriple() == false && gameField.isGunMachinegun() == false &&
							gameField.isGunVoidHunter() == false && gameField.isGunPlasma() == false && gameField.isGunUnknown() == false)
					{
						greenGunPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
						dualGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						tripleGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						machinegunGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						voidHunterGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						plasmaGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
						unknownGunPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
					}
					statsPlayerField.setPercentageArmorPlayer(gameField.getPercentageArmorPlayer());
					statsPlayerField.setScore(gameField.getScore());
					statsPlayerField.setCountLifesPlayer(gameField.getCountLifesPlayer());
					statsPlayerField.setChronometerAvailable(gameField.isChronometerAvailable());
					greenGunPanel.repaint();
					dualGunPanel.repaint();
					tripleGunPanel.repaint();
					machinegunGunPanel.repaint();
					voidHunterGunPanel.repaint();
					plasmaGunPanel.repaint();
					unknownGunPanel.repaint();
				}
				else
				{
					gamePanel.repaint();
				}
			}
		};
		Timer timer = new Timer(50, updateGame);
		timer.start();
	}
	private static void menuGame() 
	{
		final GameField gameField = new GameField(width, height);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//запрет на использование крестика закрытия
		menuFrame.setResizable(false); //запрет на изменение размера фрейма.
		final MenuPanel menuPanel = new MenuPanel(gameField);
		menuPanel.setPreferredSize(new Dimension(width, height + 80));
		menuPanel.addMouseMotionListener(new MouseMotionListener() 
		{
			public void mouseMoved(MouseEvent e) 
			{
				int mouseX = e.getX();
				int mouseY = e.getY();
				if(mouseX > 110 && mouseX < 260 && mouseY > 270 && mouseY < 300 
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
					menuPanel.setNewGameInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setNewGameInduced(false);
					menuPanel.repaint();
				}
				if(mouseX > 125 && mouseX < 250 && mouseY > 320 && mouseY < 350
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
					menuPanel.setOptionsInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setOptionsInduced(false);
					menuPanel.repaint();
				}
				if(mouseX > 100 && mouseX < 275 && mouseY > 370 && mouseY < 400
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
					menuPanel.setBestScoreInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setBestScoreInduced(false);
					menuPanel.repaint();
				}
				if(mouseX > 150 && mouseX < 220 && mouseY > 420 && mouseY < 450
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
					menuPanel.setExitInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setExitInduced(false);
					menuPanel.repaint();
				}
				if(mouseX > 410 && mouseX < 465 && mouseY > 280 && mouseY < 310)
				{
					menuPanel.setYesInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setYesInduced(false);
					menuPanel.repaint();
				}
				if(mouseX > 550 && mouseX < 585 && mouseY > 280 && mouseY < 310)
				{
					menuPanel.setNoInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setNoInduced(false);
					menuPanel.repaint();
				}
				/////best score
				if(mouseX > 470 && mouseX < 550 && mouseY > 290 && mouseY < 320
						&& menuPanel.isBestScoreClicked() == true)
				{
					menuPanel.setBackInduced(true);
					menuPanel.repaint();
				}
				else
				{
					menuPanel.setBackInduced(false);
					menuPanel.repaint();
				}
			}
			public void mouseDragged(MouseEvent arg0)
			{
			}
		});
		menuPanel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(e.getX() > 110 && e.getX() < 260 && e.getY() > 270 && e.getY() < 300
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
//					New game
					menuFrame.setVisible(false);
					gameStart = true;
					playGame();
				}
				else if(e.getX() > 125 && e.getX() < 250 && e.getY() > 320 && e.getY() < 350
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
//					Options
					final JFrame optionsFrame = new JFrame("Darkness Space");
					optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					optionsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//запрет на использование крестика закрытия
					optionsFrame.setResizable(false); //запрет на изменение размера фрейма.
					final MenuPanel optionsPanel = new MenuPanel(gameField);
					optionsPanel.setPreferredSize(new Dimension(width, height + 80));
					optionsFrame.add(optionsPanel);
					optionsPanel.setOptionsOn(true);
					
					optionsPanel.addMouseMotionListener(new MouseMotionListener() 
					{
						public void mouseMoved(MouseEvent e)
						{
							int mouseX = e.getX();
							int mouseY = e.getY();
							if(mouseX > 460 && mouseX < 540 && mouseY > 540 && mouseY < 560)
							{
								optionsPanel.setBackInduced(true);
								optionsPanel.repaint();
							}
							else
							{
								optionsPanel.setBackInduced(false);
								optionsPanel.repaint();
							}
						}
						public void mouseDragged(MouseEvent e)
						{	
						}
					});
					optionsPanel.addMouseListener(new MouseAdapter() 
					{
						public void mouseClicked(MouseEvent e) 
						{
							if(e.getX() > 460 && e.getX() < 540 && e.getY() > 540 && e.getY() < 560)
							{
//								Back Clicked
								optionsFrame.setVisible(false);
								menuFrame.setVisible(true);
								optionsPanel.setOptionsOn(false);
								menuPanel.setOptionsInduced(false);
								menuPanel.repaint();
							}
						}
					});
					optionsFrame.pack();
					optionsFrame.setVisible(true);
					menuFrame.setVisible(false);
					
				}
				else if(e.getX() > 100 && e.getX() < 275 && e.getY() > 370 && e.getY() < 400
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
//					BestScore
					menuPanel.setBestScoreClicked(true);
				}
				else if(e.getX() > 150 && e.getX() < 220 && e.getY() > 420 && e.getY() < 450
						&& menuPanel.isExitClicked() == false && menuPanel.isBestScoreClicked() == false)
				{
//					Exit
					menuPanel.setExitClicked(true);
				}
				else if(e.getX() > 410 && e.getX() < 465 && e.getY() > 280 && e.getY() < 310 
						&& menuPanel.isExitClicked() == true)
				{
//					Yes
					System.exit(0);
				}
				else if(e.getX() > 550 && e.getX() < 585 && e.getY() > 280 && e.getY() < 310 
						&& menuPanel.isExitClicked() == true)
				{
//					No
					menuPanel.setExitClicked(false);
				}
				else if(e.getX() > 470 && e.getX() < 550 && e.getY() > 290 && e.getY() < 320
						&& menuPanel.isBestScoreClicked() == true)
				{
//					BackBestScore
					menuPanel.setBestScoreClicked(false);
				}
			}
		});
		menuFrame.add(menuPanel);
		menuFrame.pack();
		if(gameStart == false)
		{
			menuFrame.setVisible(true);
		}
		else
		{
			menuFrame.setVisible(false);
		}
	}
	public static void main(String[] args) throws IOException 
	{
		menuGame();
	}
}