package game.panels;

import java.awt.Graphics;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import javax.swing.JPanel;

public class TripleGunPanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	public TripleGunPanel(StatsPlayerField statsPlayerField) 
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
		if(getStatsPlayerField().isFlagForIconTriple() == true)
		{
			getStatsPlayerField().getIconTripleGun().paintAvailableIcon(g);
		}
		else
		{
			getStatsPlayerField().getIconTripleGun().paintNotAvailableIcon(g);
		}
		getStatsPlayerField().getIconTripleGun().paintLabel(g);
	}
}
