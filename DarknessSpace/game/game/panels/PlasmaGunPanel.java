package game.panels;

import java.awt.Graphics;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import javax.swing.JPanel;

public class PlasmaGunPanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	public PlasmaGunPanel(StatsPlayerField statsPlayerField)
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
		if(getStatsPlayerField().isFlagForIconPlasma() == true)
		{
			getStatsPlayerField().getIconPlasmaGun().paintAvailableIcon(g);
		}
		else
		{
			getStatsPlayerField().getIconPlasmaGun().paintNotAvailableIcon(g);
		}
		getStatsPlayerField().getIconPlasmaGun().paintLabel(g);
	}
}
