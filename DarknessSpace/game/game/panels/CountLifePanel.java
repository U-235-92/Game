package game.panels;

import java.awt.Graphics;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import javax.swing.JPanel;

public class CountLifePanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	
	public CountLifePanel(StatsPlayerField statsPlayerField) 
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
		getStatsPlayerField().getIconCountLifes().paintLabel(g);
		getStatsPlayerField().getIconCountLifes().paintLive(g);
	}
}
