package game.fields;

import game.icons.IconChronometer;
import game.icons.IconLabelLife;
import game.icons.IconDualGun;
import game.icons.IconGreenGun;
import game.icons.IconMachineGun;
import game.icons.IconPercentageArmor;
import game.icons.IconPlasmaGun;
import game.icons.IconVoidHunterGun;
import game.icons.IconScore;
import game.icons.IconTripleGun;
import game.icons.IconUnknownGun;

public class StatsPlayerField
{
	private int width;
	private int height;
	private int countShootMashinegun;
	private int countShootVoidHunter;
	private int countShootUnknown;
	private int percentageArmorPlayer;
	private int score;
	private int countLifesPlayer;
	private int intervalWorkChronometer;
	
	private GameField gameField;
	
	private IconGreenGun iconGreenGun;
	private IconDualGun iconDualGun;
	private IconTripleGun iconTripleGun;
	private IconMachineGun iconMachineGun;
	private IconVoidHunterGun iconVoidHunterGun;
	private IconPlasmaGun iconPlasmaGun;
	private IconUnknownGun iconUnknownGun;
	private IconScore iconScore;
	private IconPercentageArmor iconPercentageArmor;
	private IconLabelLife iconLabelLife;
	private IconChronometer iconChronometer;
	
	private boolean flagForIconGreen = true;
	private boolean flagForIconDual;
	private boolean flagForIconTriple;
	private boolean flagForIconMachinegun;
	private boolean flagForIconRocket;
	private boolean flagForIconPlasma;
	private boolean flagForIconUncnown;
	private boolean chronometerAvailable;
	private boolean chronometerOn;
	public StatsPlayerField(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public GameField getGameFild()
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
		gameField.setStatsPlayerField(this);
	}
	public IconGreenGun getIconGreenGun() 
	{
		return iconGreenGun;
	}
	public void setIconGreenGun(IconGreenGun iconGreenGun) 
	{
		this.iconGreenGun = iconGreenGun;
		iconGreenGun.setStatsPlayerField(this);
	}
	public IconDualGun getIconDualGun()
	{
		return iconDualGun;
	}
	public void setIconDualGun(IconDualGun iconDualGun)
	{
		this.iconDualGun = iconDualGun;
		iconDualGun.setStatsPlayerField(this);
	}
	public IconTripleGun getIconTripleGun()
	{
		return iconTripleGun;
	}
	public void setIconTripleGun(IconTripleGun iconTripleGun) 
	{
		this.iconTripleGun = iconTripleGun;
		iconTripleGun.setStatsPlayerField(this);
	}
	public IconMachineGun getIconMachineGun()
	{
		return iconMachineGun;
	}
	public void setIconMachineGun(IconMachineGun iconMachineGun)
	{
		this.iconMachineGun = iconMachineGun;
		iconMachineGun.setStatsPlayerField(this);
	}
	public IconVoidHunterGun getIconVoidHunter()
	{
		return iconVoidHunterGun;
	}
	public void setIconVoidHunter(IconVoidHunterGun iconVoidHunterGun) 
	{
		this.iconVoidHunterGun = iconVoidHunterGun;
		iconVoidHunterGun.setStatsPlayerField(this);
	}
	public IconPlasmaGun getIconPlasmaGun() 
	{
		return iconPlasmaGun;
	}
	public void setIconPlasmaGun(IconPlasmaGun iconPlasmaGun)
	{
		this.iconPlasmaGun = iconPlasmaGun;
		iconPlasmaGun.setStatsPlayerField(this);
	}
	public IconUnknownGun getIconUnknownGun()
	{
		return iconUnknownGun;
	}
	public void setIconUnknownGun(IconUnknownGun iconUnknownGun)
	{
		this.iconUnknownGun = iconUnknownGun;
		iconUnknownGun.setStatsPlayerField(this);
	}
	public IconScore getIconScore() 
	{
		return iconScore;
	}
	public void setIconScore(IconScore iconScore) 
	{
		this.iconScore = iconScore;
		iconScore.setStatsPlayerField(this);
	}
	public IconPercentageArmor getIconPercentageArmor()
	{
		return iconPercentageArmor;
	}
	public void setIconPercentageArmor(IconPercentageArmor iconPercentageArmor)
	{
		this.iconPercentageArmor = iconPercentageArmor;
		iconPercentageArmor.setStatsPlayerField(this);
	}
	public IconLabelLife getIconCountLifes() 
	{
		return iconLabelLife;
	}
	public void setIconCountLifes(IconLabelLife iconLabelLife) 
	{
		this.iconLabelLife = iconLabelLife;
		iconLabelLife.setStatsPlayerField(this);
	}
	public IconChronometer getIconChronometer()
	{
		return iconChronometer;
	}
	public void setIconChronometer(IconChronometer iconChronometer)
	{
		this.iconChronometer = iconChronometer;
		iconChronometer.setStatsPlayerField(this);
	}
	public boolean isFlagForIconGreen() 
	{
		return flagForIconGreen;
	}
	public void setFlagForIconGreen(boolean flagForIconGreen) 
	{
		this.flagForIconGreen = flagForIconGreen;
	}
	public boolean isFlagForIconDual() 
	{
		return flagForIconDual;
	}
	public void setFlagForIconDual(boolean flagForIconDual)
	{
		this.flagForIconDual = flagForIconDual;
	}
	public boolean isFlagForIconTriple() 
	{
		return flagForIconTriple;
	}
	public void setFlagForIconTriple(boolean flagForIconTriple)
	{
		this.flagForIconTriple = flagForIconTriple;
	}
	public boolean isFlagForIconMachinegun()
	{
		return flagForIconMachinegun;
	}
	public void setFlagForIconMachinegun(boolean flagForIconMachinegun) 
	{
		this.flagForIconMachinegun = flagForIconMachinegun;
	}
	public boolean isFlagForIconRocket() 
	{
		return flagForIconRocket;
	}
	public void setFlagForIconRocket(boolean flagForIconRocket) 
	{
		this.flagForIconRocket = flagForIconRocket;
	}
	public boolean isFlagForIconPlasma() 
	{
		return flagForIconPlasma;
	}
	public void setFlagForIconPlasma(boolean flagForIconPlasma) 
	{
		this.flagForIconPlasma = flagForIconPlasma;
	}
	public boolean isFlagForIconUncnown() 
	{
		return flagForIconUncnown;
	}
	public void setFlagForIconUncnown(boolean flagForIconUncnown) 
	{
		this.flagForIconUncnown = flagForIconUncnown;
	}
	public int getCountShootMashinegun()
	{
		return countShootMashinegun;
	}
	public void setCountShootMashinegun(int countShootMashinegun) 
	{
		this.countShootMashinegun = countShootMashinegun;
	}
	public int getCountShootVoidHunter()
	{
		return countShootVoidHunter;
	}
	public void setCountShootVoidHunter(int countShootVoidHunter) 
	{
		this.countShootVoidHunter = countShootVoidHunter;
	}
	public int getCountShootUnknown() 
	{
		return countShootUnknown;
	}
	public void setCountShootUnknown(int countShootUnknown) 
	{
		this.countShootUnknown = countShootUnknown;
	}
	public int getPercentageArmorPlayer() 
	{
		return percentageArmorPlayer;
	}
	public void setPercentageArmorPlayer(int percentageArmorPlayer)
	{
		this.percentageArmorPlayer = percentageArmorPlayer;
	}
	public int getScore() 
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	public int getCountLifesPlayer() 
	{
		return countLifesPlayer;
	}
	public void setCountLifesPlayer(int countLifesPlayer) 
	{
		this.countLifesPlayer = countLifesPlayer;
	}
	public boolean isChronometerAvailable() 
	{
		return chronometerAvailable;
	}
	public void setChronometerAvailable(boolean chronometerAvailable) 
	{
		this.chronometerAvailable = chronometerAvailable;
	}
	public int getIntervalWorkChronometer() 
	{
		return intervalWorkChronometer;
	}
	public void setIntervalWorkChronometer(int intervalWorkChronometer)
	{
		this.intervalWorkChronometer = intervalWorkChronometer;
	}
	public boolean isChronometerOn() 
	{
		return chronometerOn;
	}
	public void setChronometerOn(boolean chronometerOn)
	{
		this.chronometerOn = chronometerOn;
	}
	public void addIcons()
	{
		setIconGreenGun(new IconGreenGun(50, 40));
		setIconDualGun(new IconDualGun(50, 40));
		setIconTripleGun(new IconTripleGun(50, 40));
		setIconMachineGun(new IconMachineGun(50, 40));
		setIconVoidHunter(new IconVoidHunterGun(50, 40));
		setIconPlasmaGun(new IconPlasmaGun(50, 40));
		setIconUnknownGun(new IconUnknownGun(50, 40));
		setIconScore(new IconScore(50, 0));
		setIconPercentageArmor(new IconPercentageArmor(50, 0));
		setIconCountLifes(new IconLabelLife(50, 40));
		setIconChronometer(new IconChronometer(50, 40));
	}
}
