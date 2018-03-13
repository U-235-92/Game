package game.panels;

import java.awt.Graphics;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import javax.swing.JPanel;

public class MachineGunPanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	
	public MachineGunPanel(StatsPlayerField statsPlayerField)
	{
		this.statsPlayerField = statsPlayerField;
	}
	public GameField getGameFild()
	{
		return gameField;
	}
	public void setGameFild(GameField gameField)
	{
		this.gameField = gameField;
	}
	public StatsPlayerField getStatsPlayerField() 
	{
		return statsPlayerField;
	}
	public void setStatsPlayerField(StatsPlayerField statsPlayerField) 
	{
		this.statsPlayerField = statsPlayerField;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(getStatsPlayerField().isFlagForIconMachinegun() == true)
		{
			getStatsPlayerField().getIconMachineGun().paintAvailableIcon(g);
		}
		else
		{
			getStatsPlayerField().getIconMachineGun().paintNotAvailableIcon(g);
		}
		getStatsPlayerField().getIconMachineGun().paintLabel(g);
	}
}
