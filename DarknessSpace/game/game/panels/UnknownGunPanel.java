package game.panels;

import java.awt.Graphics;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import javax.swing.JPanel;

public class UnknownGunPanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	public UnknownGunPanel(StatsPlayerField statsPlayerField)
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
		if(getStatsPlayerField().isFlagForIconUncnown() == true)
		{
			getStatsPlayerField().getIconUnknownGun().paintAvailableIcon(g);
		}
		else
		{
			getStatsPlayerField().getIconUnknownGun().paintNotAvailableIcon(g);
		}
		getStatsPlayerField().getIconUnknownGun().paintLabel(g);
	}
}
