package game.panels;

import game.fields.GameField;
import game.fields.StatsPlayerField;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GreenGunPanel extends JPanel
{
	private GameField gameField;
	private StatsPlayerField statsPlayerField;
	public GreenGunPanel(StatsPlayerField statsPlayerField) 
	{
		this.statsPlayerField = statsPlayerField;
	}
	public StatsPlayerField getStatsPlayerField() 
	{
		return statsPlayerField;
	}
	public void setStatsPlayerField(StatsPlayerField statsPlayerField) 
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
	public void paint(Graphics g)
	{
		super.paint(g);
		getStatsPlayerField().getIconGreenGun().paintAvailableIcon(g);
		getStatsPlayerField().getIconGreenGun().paintLabel(g);
	}
}
