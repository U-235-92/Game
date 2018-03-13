package game.fields;

import game.Background;
import game.Player;
import game.Shoot;
import game.StarDust;
import game.Statistics;
import game.animationsDestroyEnemy_And_Shoots.AnimationDestroyEnemyTypeX;
import game.animationsDestroyEnemy_And_Shoots.AnimationDestroyShoot;
import game.bonuses.HealthBonus;
import game.bonuses.RepairBonus;
import game.bonuses.ShootBonus;
import game.bonuses.UnknownWeaponBonus;
import game.creatorsBonuses.CreatorHealthBonus;
import game.creatorsBonuses.CreatorRepairBonus;
import game.creatorsBonuses.CreatorUnknownWeaponShoot;
import game.cretorsEnemies.CreatorEnemyCarrierType1;
import game.cretorsEnemies.CreatorEnemyType1;
import game.cretorsEnemies.CreatorEnemyType2;
import game.cretorsEnemies.CreatorEnemyType3;
import game.cretorsEnemies.CreatorEnemyType4;
import game.cretorsEnemies.CreatorRamEnemyType1;
import game.cretorsEnemies.CreatorRamEnemyType2;
import game.cretorsEnemies.CreatorRamEnemyType3;
import game.enemies.CarrierEnemyType1;
import game.enemies.Enemy;
import game.enemies.EnemyType1;
import game.enemies.EnemyType2;
import game.enemies.EnemyType3;
import game.enemies.EnemyType4;
import game.enemies.RamEnemyType1;
import game.enemies.RamEnemyType2;
import game.enemies.RamEnemyType3;
import game.guns.VoidHunter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;


public class GameField 
{	
	private static Timer timer;
	private final Timer timerForShield = new Timer();
	private long timeDelayWorkShield = 0;
	private int countEliminateEnemyType1; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateEnemyType2; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateEnemyType3; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateEnemyType4; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateRamEnemyType1; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateRamEnemyType2; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int countEliminateRamEnemyType3; //счетчик числа сбитых противников (надо для статистики сбитых противников)
	private int score;
	private int previos;
	private int startPointForPlayerX = 500; //стартовая позиция игрока по X
	private int startPointForPlayerY = 500; //стартовая позиция игрока по Y
	private int armorPlayer = 500; //показатель брони игрока
	private int currentArmorPlayer; // текущее значение брони
	private int percentageArmorPlayer; //процент жизни игрока
	private int countLifesPlayer = 2; //счетчик "жизней" игрока (сколько дается на старте).
	private int maxCountLifesPlayer = 5; //максимально возможное число жизней у игрока
	private int maxCountVoidHunterShootsPlayer = 6; //максимальное количество снарядов для этой пушки
	private int maxCountUnknownShootsPlayer = 3; //максимальное количество снарядов для этой пушки
	private int maxCountMachinegunShootsPlayer = 400; //максимальное количество снарядов для этой пушки
	private int countNumberShootsUnknown = 0; //счетчик числа выстрелов для данной пушки
	private int countNumberShootsMachinegun = 0; //счетчик числа выстрелов для данной пушки
	private int countNumberShootsVoidHunter = 0; //счетчик числа выстрелов для данной пушки
	private int indicatorPauseGame = 0; 
	private int width = 1000;
	private int height = 700;
	private int shootX;
	private int shootY;
	private int flagForGun = 1;
	private int countDestroyedEnemyType1; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedEnemyType2; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedEnemyType3; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedEnemyType4; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedRamEnemyType1; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedRamEnemyType2; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int countDestroyedRamEnemyType3; //счетчик уничтоженных противников (нужно для работы бонусов)
	private int speedShootBonus = 5; //скорость перемещения бонуса
	private int speedHealthBonus = 5; //скорость перемещения бонуса
	private int speedRepairBonus = 5; //скорость перемещения бонуса
	private int timeWorkShield = 5000; //время работы щита
	private int timeWorkChronometer = 5000; //время работы хронометра
	private int timeReloadChronometer = 15000; //время перезарядки хронометра
	private int intervalWorkChronometer = (timeWorkChronometer / 1000) + 1;
	private int countLevels = 1; 
	private int countKeyPressed = 0; //счетчик нажатий кнопки "p" - пауза/проигрывание.
	
	private List<VoidHunter> voidHunters = new LinkedList<VoidHunter>();
	
	private Enemy targetEnemy;
	
	private List<Player> players = new LinkedList<Player>();
	
	private List<HealthBonus> healthBonuses = new LinkedList<HealthBonus>();
	private List<RepairBonus> repairBonuses = new LinkedList<RepairBonus>();
	private CopyOnWriteArrayList<ShootBonus> shootBonuses = new CopyOnWriteArrayList<ShootBonus>();
	private List<UnknownWeaponBonus> unknownBonus = new LinkedList<UnknownWeaponBonus>();
	
	private List<StarDust> starDusts = new LinkedList<StarDust>();
	
	private List<AnimationDestroyEnemyTypeX> animationDestroyEnemyTypeX = new LinkedList<AnimationDestroyEnemyTypeX>();
	private List<AnimationDestroyShoot> animationDestroyShoot = new LinkedList<AnimationDestroyShoot>();
	
	private CopyOnWriteArrayList<Shoot> shootsPlayer = new CopyOnWriteArrayList<Shoot>(); 
	private CopyOnWriteArrayList<Shoot> shootsEnemyType1 = new CopyOnWriteArrayList<Shoot>();///concurrent //List
	private CopyOnWriteArrayList<Shoot> shootsEnemyType2 = new CopyOnWriteArrayList<Shoot>();
	private CopyOnWriteArrayList<Shoot> shootsEnemyType3 = new CopyOnWriteArrayList<Shoot>();
	private CopyOnWriteArrayList<Shoot> shootsEnemyType4 = new CopyOnWriteArrayList<Shoot>();
	private CopyOnWriteArrayList<Shoot> shootsRamEnemyType1 = new CopyOnWriteArrayList<Shoot>();
	private CopyOnWriteArrayList<Shoot> shootsCarrierEnemyType1 = new CopyOnWriteArrayList<Shoot>();
	
	private Set<Shoot> destroyedShootsEnemyType1 = new HashSet<Shoot>();
	private Set<Shoot> destroyedShootsEnemyType2 = new HashSet<Shoot>();
	private Set<Shoot> destroyedShootsEnemyType3 = new HashSet<Shoot>();
	private Set<Shoot> destroyedShootsEnemyType4 = new HashSet<Shoot>();
	private Set<Shoot> destroyedShootsRamEnemyType1 = new HashSet<Shoot>();
	private Set<Shoot> destroyedShootsCarrierEnemyType1 = new HashSet<Shoot>();
	
	private Set<Shoot> destroyedShootsPlayer = new HashSet<Shoot>();
	Set<Player> destroyedPlayer = new HashSet<Player>();
	
	private List<CarrierEnemyType1> enemyCarrierType1 = new LinkedList<CarrierEnemyType1>();
	private CopyOnWriteArrayList<EnemyType1> enemiesType1 = new CopyOnWriteArrayList<EnemyType1>();
	private CopyOnWriteArrayList<EnemyType2> enemiesType2 = new CopyOnWriteArrayList<EnemyType2>();
	private CopyOnWriteArrayList<EnemyType3> enemiesType3 = new CopyOnWriteArrayList<EnemyType3>();
	private CopyOnWriteArrayList<EnemyType4> enemiesType4 = new CopyOnWriteArrayList<EnemyType4>();
	private List<RamEnemyType1> ramEnemiesType1 = new LinkedList<RamEnemyType1>();
	private List<RamEnemyType2> ramEnemiesType2 = new LinkedList<RamEnemyType2>();
	private List<RamEnemyType3> ramEnemiesType3 = new LinkedList<RamEnemyType3>();
	
	private Set<Enemy> destroyedEnemiesType1 = new HashSet<Enemy>();
	private Set<Enemy> destroyedEnemiesType2 = new HashSet<Enemy>();
	private Set<Enemy> destroyedEnemiesType3 = new HashSet<Enemy>();
	private Set<Enemy> destroyedEnemiesType4 = new HashSet<Enemy>();
	private Set<Enemy> destroyedRamEnemiesType1 = new HashSet<Enemy>();
	private Set<Enemy> destroyedRamEnemiesType2 = new HashSet<Enemy>();
	private Set<Enemy> destroyedRamEnemiesType3 = new HashSet<Enemy>();
	private Set<Enemy> destroyedCarrierType1 = new HashSet<Enemy>();
	
	private Set<ShootBonus> destroyedShootBonus = new HashSet<ShootBonus>();
	private Set<HealthBonus> destroyedHealthBonus = new HashSet<HealthBonus>();
	private Set<RepairBonus> destroyedRepairBonus = new HashSet<RepairBonus>();
	private Set<UnknownWeaponBonus> destroyedUnknownWeaponBonus = new HashSet<UnknownWeaponBonus>();
	private Set<AnimationDestroyEnemyTypeX> destroyedAnimationEnemy = new HashSet<AnimationDestroyEnemyTypeX>();
	private Set<AnimationDestroyShoot> destroyedAnimationShoot = new HashSet<AnimationDestroyShoot>();
	private Set<VoidHunter> destroyedVoidHunters = new HashSet<VoidHunter>();
	
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Right; 
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Left;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Center;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_10_Right;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Left;
	private CreatorEnemyType1 creatorEnemyType_1_Crossed_From_Left;
	private CreatorEnemyType1 creatorEnemyType_1_Crossed_From_Right;
	private CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Left;
	private CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Right;
	
	private CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Right;
	private CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Left;
	private CreatorEnemyType2 creatorEnemyType_2_Crossed_Diagonal_Right;
	private CreatorEnemyType2 creatorEnemyType_2_Crossed_Diagonal_Left;
	
	private CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Left;
	private CreatorEnemyType3 creatorEnemyType_3_Crossed_From_Right;
	private CreatorEnemyType3 creatorEnemyType_3_Crossed_From_Left;
	
	private CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Left;
	private CreatorEnemyType4 creatorEnemyType_4_Route_Flight_Left;
	private CreatorEnemyType4 creatorEnemyType_4_Route_Flight_Right;
	
	private CreatorRamEnemyType3 creatorRamEnemyType_3_Snake;
	
	private CreatorRamEnemyType2 creatorRamEnemyType2_50_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_100_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_150_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_200_Wall;
	private CreatorRamEnemyType1 creatorRamEnemyType1_250_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_300_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_350_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_400_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_450_Wall;
	private CreatorRamEnemyType1 creatorRamEnemyType1_500_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_550_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_600_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_650_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_700_Wall;
	private CreatorRamEnemyType1 creatorRamEnemyType1_750_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_800_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_850_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_900_Wall;
	private CreatorRamEnemyType2 creatorRamEnemyType2_950_Wall;
	
	private CreatorUnknownWeaponShoot creatorUnknownWeaponShoot;
	private CreatorHealthBonus creatorHealthBonus;
	private CreatorRepairBonus creatorRepairBonus;
	
	private CreatorEnemyCarrierType1 creatorEnemyCarrierType1;
	
	private Background background;
	private StatsPlayerField statsPlayerField;
	private Statistics statistics;
	
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Right_Level_2; 
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Left_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Right_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Left_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Left_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Right_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2;
	private CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2;
	
	private CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Right_Level_2;
	private CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Left_Level_2;
	private CreatorEnemyType2 creatorEnemyType_2_Crossed_From_Left_Level_2;
	private CreatorEnemyType2 creatorEnemyType_2_Crossed_From_Right_Level_2;
	
	private CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Left_Level_2;
	private CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Right_Level_2;
	
	private CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Left_Level_2;
	private CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Right_Level_2;
	
	private CreatorEnemyCarrierType1 creatorEnemyCarrierType1_Level_2;
	
	private boolean leftVk;
	private boolean rightVk;
	private boolean upVk;
	private boolean downVk;
	private boolean spaceVk;
	private boolean flag = false; //нужно для грамотного отображения анимации выстрелов (ВАЖНО! Не изменять!)
	private boolean enemyDestroy; //индикатор уничтожения противника (нужно для анимации взрыва)
	private boolean shootDestroy; //аналог enemyDestroy, но для выстрелов
	private boolean carrierType1Destroy;//индикатор уничтожения противника (нужно для анимации взрыва)
	private boolean shootMachinegunFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean shootByDefaultFlag; //true; //чтобы при подлете к бонусу менялось орудие
	private boolean shootDualGreenFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean shootPlasmaGunFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean shootTripleFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean shootUnknownFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean shootVoidHunterFlag = false; //чтобы при подлете к бонусу менялось орудие
	private boolean destroyEnemyType1; //необходимо для определения какие пушки могут быть получены после смерти противника данного типа
	private boolean destroyEnemyType2; //необходимо для определения какие пушки могут быть получены после смерти противника данного типа
	private boolean destroyEnemyType3; //необходимо для определения какие пушки могут быть получены после смерти противника данного типа
	private boolean destroyEnemyType4; //необходимо для определения какие пушки могут быть получены после смерти противника данного типа
	private boolean gunDual; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean gunTriple; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean gunMachinegun; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean gunVoidHunter; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean gunPlasma; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean gunUnknown; //индикатор для конкретной пушки (необходим для выбора оружия)
	private boolean readyToShootUnknown = true; //индикатор разрешения стрельбы если количество выстрелов для Unknown > 0
	private boolean readyToShootVoidHunter = true; //индикатор разрешения стрельбы если количество выстрелов для Rocket > 0
	private boolean readyToShootMachinegun = true; //индикатор разрешения стрельбы если количество выстрелов для Machinegun > 0
	private boolean shieldActivated;
	private boolean playerDestroyed; //индикатор гибели игрока - нужно для отображения статистики убийств
	private boolean chronometerActive; // ндикатор активации хронометра
	private boolean chronometerAvailable = true; //флаг, доступен хронометр или не доступен (запрет использования во время перезарядки)
	private boolean chronometerOn; //нужно для работы таймера, вкл. по нажатию кнопки, выкл. по истечению времени работы хронометра
	private boolean lockEnemyType1;
	private boolean lockEnemyType2;
	private boolean lockEnemyType3;
	private boolean lockEnemyType4;
	private boolean lockEnemyCarrierType1;
	private boolean pauseCreateEnemies = false; //необходимо для временной блокировки создания противников генераторами
	private boolean startMoveCarrierType1 = false;
	private boolean carrierDestroy = false;
	private boolean clearFrame = false;
	private boolean endGame = false;
	private boolean pause = false;
	private boolean escapeOn = false;
	private boolean visibleGameFrame = false;
	public GameField(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}
	public Timer getTimerForShield()
	{
		return timerForShield;
	}
	public boolean isVisibleGameFrame() 
	{
		return visibleGameFrame;
	}
	public void setVisibleGameFrame(boolean visibleGameFrame) 
	{
		this.visibleGameFrame = visibleGameFrame;
	}
	public boolean isEscapeOn() 
	{
		return escapeOn;
	}
	public void setEscapeOn(boolean escapeOn)
	{
		this.escapeOn = escapeOn;
	}
	public boolean isPause() 
	{
		return pause;
	}
	public void setPause(boolean pause)
	{
		this.pause = pause;
	}
	public int getCountLevels() 
	{
		return countLevels;
	}
	public void setCountLevels(int countLevels) 
	{
		this.countLevels = countLevels;
	}
	public boolean isLockEnemyType1()
	{
		return lockEnemyType1;
	}
	public void setLockEnemyType1(boolean lockEnemyType1) 
	{
		this.lockEnemyType1 = lockEnemyType1;
	}
	public boolean isLockEnemyType2() 
	{
		return lockEnemyType2;
	}
	public void setLockEnemyType2(boolean lockEnemyType2)
	{
		this.lockEnemyType2 = lockEnemyType2;
	}
	public boolean isLockEnemyType3()
	{
		return lockEnemyType3;
	}
	public void setLockEnemyType3(boolean lockEnemyType3)
	{
		this.lockEnemyType3 = lockEnemyType3;
	}
	public boolean isLockEnemyType4() 
	{
		return lockEnemyType4;
	}
	public void setLockEnemyType4(boolean lockEnemyType4)
	{
		this.lockEnemyType4 = lockEnemyType4;
	}
	public boolean isLockEnemyCarrierType1()
	{
		return lockEnemyCarrierType1;
	}
	public void setLockEnemyCarrierType1(boolean lockEnemyCarrierType1) 
	{
		this.lockEnemyCarrierType1 = lockEnemyCarrierType1;
	}
	public Enemy getTargetEnemy()
	{
		return targetEnemy;
	}
	public void setTargetEnemy(Enemy targetEnemy)
	{
		this.targetEnemy = targetEnemy;
	}
	public Statistics getStatistics()
	{
		return statistics;
	}
	public void setStatistics(Statistics statistics) 
	{
		this.statistics = statistics;
		statistics.setGameFild(this);
	}
	public int getScore() 
	{
		return score;
	}
	public void setScore(int score) 
	{
		this.score = score;
	}
	public int getMaxCountLifesPlayer() 
	{
		return maxCountLifesPlayer;
	}
	public void setMaxCountLifesPlayer(int maxCountLifesPlayer) 
	{
		this.maxCountLifesPlayer = maxCountLifesPlayer;
	}
	public int getArmorPlayer()
	{
		return armorPlayer;
	}
	public void setArmorPlayer(int armorPlayer)
	{
		this.armorPlayer = armorPlayer;
	}
	public int getCurrentArmorPlayer()
	{
		return currentArmorPlayer;
	}
	public void setCurrentArmorPlayer(int currentArmorPlayer) 
	{
		this.currentArmorPlayer = currentArmorPlayer;
	}
	public int getPercentageArmorPlayer() 
	{
		return percentageArmorPlayer;
	}
	public void setPercentageArmorPlayer(int percentageArmorPlayer)
	{
		this.percentageArmorPlayer = percentageArmorPlayer;
	}
	public int getCountLifesPlayer()
	{
		return countLifesPlayer;
	}
	public void setCountLifesPlayer(int countLifesPlayer) 
	{
		this.countLifesPlayer = countLifesPlayer;
	}
	public int getMaxCountVoidHunterShootsPlayer()
	{
		return maxCountVoidHunterShootsPlayer;
	}
	public void setMaxCountVoidHunterShootsPlayer(int maxCountVoidHunterShootsPlayer) 
	{
		this.maxCountVoidHunterShootsPlayer = maxCountVoidHunterShootsPlayer;
	}
	public int getMaxCountUnknownShootsPlayer()
	{
		return maxCountUnknownShootsPlayer;
	}
	public void setMaxCountUnknownShootsPlayer(int maxCountUnknownShootsPlayer) 
	{
		this.maxCountUnknownShootsPlayer = maxCountUnknownShootsPlayer;
	}
	public int getMaxCountMachinegunShootsPlayer()
	{
		return maxCountMachinegunShootsPlayer;
	}
	public void setMaxCountMachinegunShootsPlayer(int maxCountMachinegunShootsPlayer) 
	{
		this.maxCountMachinegunShootsPlayer = maxCountMachinegunShootsPlayer;
	}
	public int getCountNumberShootsUnknown() 
	{
		return countNumberShootsUnknown;
	}
	public void setCountNumberShootsUnknown(int countNumberShootsUnknown) 
	{
		this.countNumberShootsUnknown = countNumberShootsUnknown;
	}
	public int getCountNumberShootsMachinegun() 
	{
		return countNumberShootsMachinegun;
	}
	public void setCountNumberShootsMachinegun(int countNumberShootsMachinegun) 
	{
		this.countNumberShootsMachinegun = countNumberShootsMachinegun;
	}
	public int getCountNumberShootsVoidHunter()
	{
		return countNumberShootsVoidHunter;
	}
	public void setCountNumberShootsVoidHunter(int countNumberShootsVoidHunter) 
	{
		this.countNumberShootsVoidHunter = countNumberShootsVoidHunter;
	}
	public int getIndicatorPauseGame()
	{
		return indicatorPauseGame;
	}
	public void setIndicatorPauseGame(int indicatorPauseGame)
	{
		this.indicatorPauseGame = indicatorPauseGame;
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
	public List<Player> getPlayers() 
	{
		return players;
	}
	public void setPlayers(Player player) 
	{
		players.add(player);
		player.setGameFild(this);
	}
	public CopyOnWriteArrayList<Shoot> getShootsPlayer() 
	{
		return shootsPlayer;
	}
	public void setShootsPlayer(CopyOnWriteArrayList<Shoot> shootsPlayer)
	{
		this.shootsPlayer = shootsPlayer;
	}
	public List<StarDust> getStarDusts() 
	{
		return starDusts;
	}
	public void setStarDust(StarDust starDust) 
	{
		starDusts.add(starDust);
		starDust.setGameFild(this);
	}
	public List<CarrierEnemyType1> getEnemyCarrierType1() 
	{
		return enemyCarrierType1;
	}
	public void setEnemyCarrierType1(CarrierEnemyType1 enemy)
	{
		enemyCarrierType1.add(enemy);
		enemy.setGameFild(this);
	}
	public boolean isFlag() 
	{
		return flag;
	}
	public void setFlag(boolean flag) 
	{
		this.flag = flag;
	}
	
	public boolean isEnemyDestroy() 
	{
		return enemyDestroy;
	}
	public void setEnemyDestroy(boolean enemyDestroy) 
	{
		this.enemyDestroy = enemyDestroy;
	}
	public CopyOnWriteArrayList<EnemyType1> getEnemiesType1() 
	{
		return enemiesType1;
	}
	public void setEnemiesType1(EnemyType1 enemy) 
	{
		enemiesType1.add(enemy); ////////////////
		enemy.setGameFild(this);
	}
	public CopyOnWriteArrayList<EnemyType2> getEnemiesType2()
	{
		return enemiesType2;
	}
	public void setEnemiesType2(EnemyType2 enemy) 
	{
		enemiesType2.add(enemy);
		enemy.setGameFild(this);
	}
	public CopyOnWriteArrayList<EnemyType3> getEnemiesType3()
	{
		return enemiesType3;
	}
	public void setEnemiesType3(EnemyType3 enemy)
	{
		enemiesType3.add(enemy);
		enemy.setGameFild(this);
	}
	public CopyOnWriteArrayList<EnemyType4> getEnemiesType4()
	{
		return enemiesType4;
	}
	public void setEnemiesType4(EnemyType4 enemy)
	{
		enemiesType4.add(enemy);
		enemy.setGameFild(this);
	}
	public List<RamEnemyType1> getRamEnemiesType1() 
	{
		return ramEnemiesType1;
	}
	public void setRamEnemiesType1(RamEnemyType1 enemy) 
	{
		ramEnemiesType1.add(enemy);
		enemy.setGameFild(this);
	}
	public List<RamEnemyType2> getRamEnemiesType2()
	{
		return ramEnemiesType2;
	}
	public void setRamEnemiesType2(RamEnemyType2 enemy) 
	{
		ramEnemiesType2.add(enemy);
		enemy.setGameFild(this);
	}
	public List<RamEnemyType3> getRamEnemiesType3()
	{
		return ramEnemiesType3;
	}
	public void setRamEnemiesType3(RamEnemyType3 enemy) 
	{
		ramEnemiesType3.add(enemy);
		enemy.setGameFild(this);
	}
	public boolean isShootDestroy() 
	{
		return shootDestroy;
	}
	public void setShootDestroy(boolean shootDestroy)
	{
		this.shootDestroy = shootDestroy;
	}
	public int getShootX()
	{
		return shootX;
	}
	public void setShootX(int shootX) 
	{
		this.shootX = shootX;
	}
	public int getShootY() 
	{
		return shootY;
	}
	public void setShootY(int shootY) 
	{
		this.shootY = shootY;
	}
	public CopyOnWriteArrayList<Shoot> getShootsEnemyType1() 
	{
		return shootsEnemyType1;
	}
	public void setShootsEnemyType1(CopyOnWriteArrayList<Shoot> shootsEnemyType1)
	{
		this.shootsEnemyType1 = shootsEnemyType1;
	}
	public CopyOnWriteArrayList<Shoot> getShootsEnemyType2() 
	{
		return shootsEnemyType2;
	}
	public void setShootsEnemyType2(CopyOnWriteArrayList<Shoot> shootsEnemyType2) 
	{
		this.shootsEnemyType2 = shootsEnemyType2;
	}
	public CopyOnWriteArrayList<Shoot> getShootsEnemyType3() 
	{
		return shootsEnemyType3;
	}
	public void setShootsEnemyType3(CopyOnWriteArrayList<Shoot> shootsEnemyType3) 
	{
		this.shootsEnemyType3 = shootsEnemyType3;
	}
	public CopyOnWriteArrayList<Shoot> getShootsEnemyType4() 
	{
		return shootsEnemyType4;
	}
	public void setShootsEnemyType4(CopyOnWriteArrayList<Shoot> shootsEnemyType4)
	{
		this.shootsEnemyType4 = shootsEnemyType4;
	}
	public CopyOnWriteArrayList<Shoot> getShootsRamEnemyType1()
	{
		return shootsRamEnemyType1;
	}
	public void setShootsRamEnemyType1(CopyOnWriteArrayList<Shoot> shootsRamEnemyType1) 
	{
		this.shootsRamEnemyType1 = shootsRamEnemyType1;
	}
	public CopyOnWriteArrayList<Shoot> getShootsCarrierEnemyType1() 
	{
		return shootsCarrierEnemyType1;
	}
	public void setShootsCarrierEnemyType1(CopyOnWriteArrayList<Shoot> shootsCarrierEnemyType1)
	{
		this.shootsCarrierEnemyType1 = shootsCarrierEnemyType1;
	}
	public boolean isCarrierType1Destroy()
	{
		return carrierType1Destroy;
	}
	public void setCarrierType1Destroy(boolean carrierType1Destroy) 
	{
		this.carrierType1Destroy = carrierType1Destroy;
	}
	public CopyOnWriteArrayList<ShootBonus> getShootBonuses() 
	{
		return shootBonuses;
	}
	public void setShootBonuses(ShootBonus shootBonus) 
	{
		shootBonuses.add(shootBonus);
		shootBonus.setGameFild(this);
	}
	public boolean isShootByDefaultFlag()
	{
		return shootByDefaultFlag;
	}
	public void setShootByDefaultFlag(boolean shootByDefaultFlag) 
	{
		this.shootByDefaultFlag = shootByDefaultFlag;
	}
	public boolean isShootMachinegunFlag()
	{
		return shootMachinegunFlag;
	}
	public void setShootMachinegunFlag(boolean shootMachinegunFlag) 
	{
		this.shootMachinegunFlag = shootMachinegunFlag;
	}
	public boolean isShootDualGreenFlag() 
	{
		return shootDualGreenFlag;
	}
	public void setShootDualGreenFlag(boolean shootDualGreenFlag) 
	{
		this.shootDualGreenFlag = shootDualGreenFlag;
	}
	public boolean isShootPlasmaGunFlag()
	{
		return shootPlasmaGunFlag;
	}
	public void setShootPlasmaGunFlag(boolean shootPlasmaGunFlag)
	{
		this.shootPlasmaGunFlag = shootPlasmaGunFlag;
	}
	public boolean isShootTripleFlag()
	{
		return shootTripleFlag;
	}
	public void setShootTripleFlag(boolean shootTripleFlag)
	{
		this.shootTripleFlag = shootTripleFlag;
	}
	public boolean isShootUnknownFlag() 
	{
		return shootUnknownFlag;
	}
	public void setShootUnknownFlag(boolean shootUnknownFlag)
	{
		this.shootUnknownFlag = shootUnknownFlag;
	}
	public boolean isShootVoidHunterFlag() 
	{
		return shootVoidHunterFlag;
	}
	public void setShootVoidHunterFlag(boolean shootVoidHunterFlag) 
	{
		this.shootVoidHunterFlag = shootVoidHunterFlag;
	}
	public int getFlagForGun()
	{
		return flagForGun;
	}
	public void setFlagForGun(int flagForGun) 
	{
		this.flagForGun = flagForGun;
	}
	public boolean isDestroyEnemyType1() 
	{
		return destroyEnemyType1;
	}
	public void setDestroyEnemyType1(boolean destroyEnemyType1)
	{
		this.destroyEnemyType1 = destroyEnemyType1;
	}
	public boolean isDestroyEnemyType2()
	{
		return destroyEnemyType2;
	}
	public void setDestroyEnemyType2(boolean destroyEnemyType2) 
	{
		this.destroyEnemyType2 = destroyEnemyType2;
	}
	public boolean isDestroyEnemyType3() 
	{
		return destroyEnemyType3;
	}
	public void setDestroyEnemyType3(boolean destroyEnemyType3) 
	{
		this.destroyEnemyType3 = destroyEnemyType3;
	}
	public boolean isDestroyEnemyType4() 
	{
		return destroyEnemyType4;
	}
	public void setDestroyEnemyType4(boolean destroyEnemyType4) 
	{
		this.destroyEnemyType4 = destroyEnemyType4;
	}
	public boolean isGunDual()
	{
		return gunDual;
	}
	public void setGunDual(boolean gunDual)
	{
		this.gunDual = gunDual;
	}
	public boolean isGunTriple() 
	{
		return gunTriple;
	}
	public void setGunTriple(boolean gunTriple)
	{
		this.gunTriple = gunTriple;
	}
	public boolean isGunMachinegun()
	{
		return gunMachinegun;
	}
	public void setGunMachinegun(boolean gunMachinegun)
	{
		this.gunMachinegun = gunMachinegun;
	}
	public boolean isGunVoidHunter() 
	{
		return gunVoidHunter;
	}
	public void setGunVoidHunter(boolean gunVoidHunter) 
	{
		this.gunVoidHunter = gunVoidHunter;
	}
	public boolean isGunPlasma() 
	{
		return gunPlasma;
	}
	public void setGunPlasma(boolean gunPlasma) 
	{
		this.gunPlasma = gunPlasma;
	}
	public boolean isGunUnknown() 
	{
		return gunUnknown;
	}
	public void setGunUnknown(boolean gunUnknown)
	{
		this.gunUnknown = gunUnknown;
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Right() 
	{
		return creatorEnemyType_1_Straight_50_950_Right;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Right(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Right) 
	{
		this.creatorEnemyType_1_Straight_50_950_Right = creatorEnemyType_1_Straight_50_950_Right;
		creatorEnemyType_1_Straight_50_950_Right.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Left() 
	{
		return creatorEnemyType_1_Straight_50_950_Left;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Left(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Left)
	{
		this.creatorEnemyType_1_Straight_50_950_Left = creatorEnemyType_1_Straight_50_950_Left;
		creatorEnemyType_1_Straight_50_950_Left.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_350_650_Center() 
	{
		return creatorEnemyType_1_Straight_350_650_Center;
	}
	public void setCreatorEnemyType_1_Straight_350_650_Center(
			CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Center) 
	{
		this.creatorEnemyType_1_Straight_350_650_Center = creatorEnemyType_1_Straight_350_650_Center;
		creatorEnemyType_1_Straight_350_650_Center.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Fast_10_Right()
	{
		return creatorEnemyType_1_Straight_50_950_Fast_10_Right;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Fast_10_Right(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_10_Right) 
	{
		this.creatorEnemyType_1_Straight_50_950_Fast_10_Right = creatorEnemyType_1_Straight_50_950_Fast_10_Right;
		creatorEnemyType_1_Straight_50_950_Fast_10_Right.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Fast_20_Left() 
	{
		return creatorEnemyType_1_Straight_50_950_Fast_20_Left;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Fast_20_Left(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Left) 
	{
		this.creatorEnemyType_1_Straight_50_950_Fast_20_Left = creatorEnemyType_1_Straight_50_950_Fast_20_Left;
		creatorEnemyType_1_Straight_50_950_Fast_20_Left.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Crossed_From_Left() 
	{
		return creatorEnemyType_1_Crossed_From_Left;
	}
	public void setCreatorEnemyType_1_Crossed_From_Left(
			CreatorEnemyType1 creatorEnemyType_1_Crossed_From_Left) 
	{
		this.creatorEnemyType_1_Crossed_From_Left = creatorEnemyType_1_Crossed_From_Left;
		creatorEnemyType_1_Crossed_From_Left.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Crossed_From_Right() 
	{
		return creatorEnemyType_1_Crossed_From_Right;
	}
	public void setCreatorEnemyType_1_Crossed_From_Right(
			CreatorEnemyType1 creatorEnemyType_1_Crossed_From_Right) 
	{
		this.creatorEnemyType_1_Crossed_From_Right = creatorEnemyType_1_Crossed_From_Right;
		creatorEnemyType_1_Crossed_From_Right.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Diagonal_From_Left() 
	{
		return creatorEnemyType_1_Diagonal_From_Left;
	}
	public void setCreatorEnemyType_1_Diagonal_From_Left(
			CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Left) 
	{
		this.creatorEnemyType_1_Diagonal_From_Left = creatorEnemyType_1_Diagonal_From_Left;
		creatorEnemyType_1_Diagonal_From_Left.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Diagonal_From_Right() 
	{
		return creatorEnemyType_1_Diagonal_From_Right;
	}
	public void setCreatorEnemyType_1_Diagonal_From_Right(
			CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Right) 
	{
		this.creatorEnemyType_1_Diagonal_From_Right = creatorEnemyType_1_Diagonal_From_Right;
		creatorEnemyType_1_Diagonal_From_Right.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Straight_50_950_Right() 
	{
		return creatorEnemyType_2_Straight_50_950_Right;
	}
	public void setCreatorEnemyType_2_Straight_50_950_Right(
			CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Right)
	{
		this.creatorEnemyType_2_Straight_50_950_Right = creatorEnemyType_2_Straight_50_950_Right;
		creatorEnemyType_2_Straight_50_950_Right.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Straight_50_950_Left()
	{
		return creatorEnemyType_2_Straight_50_950_Left;
	}
	public void setCreatorEnemyType_2_Straight_50_950_Left(
			CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Left) 
	{
		this.creatorEnemyType_2_Straight_50_950_Left = creatorEnemyType_2_Straight_50_950_Left;
		creatorEnemyType_2_Straight_50_950_Left.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Crossed_Diagonal_Right() 
	{
		return creatorEnemyType_2_Crossed_Diagonal_Right;
	}
	public void setCreatorEnemyType_2_Crossed_Diagonal_Right(
			CreatorEnemyType2 creatorEnemyType_2_Crossed_Diagonal_Right) 
	{
		this.creatorEnemyType_2_Crossed_Diagonal_Right = creatorEnemyType_2_Crossed_Diagonal_Right;
		creatorEnemyType_2_Crossed_Diagonal_Right.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Crossed_Diagonal_Left()
	{
		return creatorEnemyType_2_Crossed_Diagonal_Left;
	}
	public void setCreatorEnemyType_2_Crossed_Diagonal_Left(
			CreatorEnemyType2 creatorEnemyType_2_Crossed_Diagonal_Left) 
	{
		this.creatorEnemyType_2_Crossed_Diagonal_Left = creatorEnemyType_2_Crossed_Diagonal_Left;
		creatorEnemyType_2_Crossed_Diagonal_Left.setGameFild(this);
	}
	public CreatorEnemyType3 getCreatorEnemyType_3_Straight_50_950_Left()
	{
		return creatorEnemyType_3_Straight_50_950_Left;
	}
	public void setCreatorEnemyType_3_Straight_50_950_Left(
			CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Left) 
	{
		this.creatorEnemyType_3_Straight_50_950_Left = creatorEnemyType_3_Straight_50_950_Left;
		creatorEnemyType_3_Straight_50_950_Left.setGameFild(this);
	}
	public CreatorEnemyType3 getCreatorEnemyType_3_Crossed_From_Right()
	{
		return creatorEnemyType_3_Crossed_From_Right;
	}
	public void setCreatorEnemyType_3_Crossed_From_Right(
			CreatorEnemyType3 creatorEnemyType_3_Crossed_From_Right) 
	{
		this.creatorEnemyType_3_Crossed_From_Right = creatorEnemyType_3_Crossed_From_Right;
		creatorEnemyType_3_Crossed_From_Right.setGameFild(this);
	}
	public CreatorEnemyType3 getCreatorEnemyType_3_Crossed_From_Left() 
	{
		return creatorEnemyType_3_Crossed_From_Left;
	}
	public void setCreatorEnemyType_3_Crossed_From_Left(
			CreatorEnemyType3 creatorEnemyType_3_Crossed_From_Left) 
	{
		this.creatorEnemyType_3_Crossed_From_Left = creatorEnemyType_3_Crossed_From_Left;
		creatorEnemyType_3_Crossed_From_Left.setGameFild(this);
	}
	public CreatorEnemyType4 getCreatorEnemyType_4_Straight_50_950_Left()
	{
		return creatorEnemyType_4_Straight_50_950_Left;
	}
	public void setCreatorEnemyType_4_Straight_50_950_Left(
			CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Left) 
	{
		this.creatorEnemyType_4_Straight_50_950_Left = creatorEnemyType_4_Straight_50_950_Left;
		creatorEnemyType_4_Straight_50_950_Left.setGameFild(this);
	}
	public CreatorEnemyType4 getCreatorEnemyType_4_Route_Flight_Left() 
	{
		return creatorEnemyType_4_Route_Flight_Left;
	}
	public void setCreatorEnemyType_4_Route_Flight_Left(
			CreatorEnemyType4 creatorEnemyType_4_Route_Flight_Left)
	{
		this.creatorEnemyType_4_Route_Flight_Left = creatorEnemyType_4_Route_Flight_Left;
		creatorEnemyType_4_Route_Flight_Left.setGameFild(this);
	}
	public CreatorEnemyType4 getCreatorEnemyType_4_Route_Flight_Right() 
	{
		return creatorEnemyType_4_Route_Flight_Right;
	}
	public void setCreatorEnemyType_4_Route_Flight_Right(
			CreatorEnemyType4 creatorEnemyType_4_Route_Flight_Right)
	{
		this.creatorEnemyType_4_Route_Flight_Right = creatorEnemyType_4_Route_Flight_Right;
		creatorEnemyType_4_Route_Flight_Right.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_50_Wall() 
	{
		return creatorRamEnemyType2_50_Wall;
	}
	public void setCreatorRamEnemyType2_50_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_50_Wall) 
	{
		this.creatorRamEnemyType2_50_Wall = creatorRamEnemyType2_50_Wall;
		creatorRamEnemyType2_50_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_100_Wall() 
	{
		return creatorRamEnemyType2_100_Wall;
	}
	public void setCreatorRamEnemyType2_100_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_100_Wall) 
	{
		this.creatorRamEnemyType2_100_Wall = creatorRamEnemyType2_100_Wall;
		creatorRamEnemyType2_100_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_150_Wall()
	{
		return creatorRamEnemyType2_150_Wall;
	}
	public void setCreatorRamEnemyType2_150_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_150_Wall)
	{
		this.creatorRamEnemyType2_150_Wall = creatorRamEnemyType2_150_Wall;
		creatorRamEnemyType2_150_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_200_Wall() 
	{
		return creatorRamEnemyType2_200_Wall;
	}
	public void setCreatorRamEnemyType2_200_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_200_Wall)
	{
		this.creatorRamEnemyType2_200_Wall = creatorRamEnemyType2_200_Wall;
		creatorRamEnemyType2_200_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType1 getCreatorRamEnemyType1_250_Wall() 
	{
		return creatorRamEnemyType1_250_Wall;
	}
	public void setCreatorRamEnemyType1_250_Wall(
			CreatorRamEnemyType1 creatorRamEnemyType1_250_Wall) 
	{
		this.creatorRamEnemyType1_250_Wall = creatorRamEnemyType1_250_Wall;
		creatorRamEnemyType1_250_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_300_Wall()
	{
		return creatorRamEnemyType2_300_Wall;
	}
	public void setCreatorRamEnemyType2_300_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_300_Wall)
	{
		this.creatorRamEnemyType2_300_Wall = creatorRamEnemyType2_300_Wall;
		creatorRamEnemyType2_300_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_350_Wall() 
	{
		return creatorRamEnemyType2_350_Wall;
	}
	public void setCreatorRamEnemyType2_350_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_350_Wall)
	{
		this.creatorRamEnemyType2_350_Wall = creatorRamEnemyType2_350_Wall;
		creatorRamEnemyType2_350_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_400_Wall() 
	{
		return creatorRamEnemyType2_400_Wall;
	}
	public void setCreatorRamEnemyType2_400_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_400_Wall) 
	{
		this.creatorRamEnemyType2_400_Wall = creatorRamEnemyType2_400_Wall;
		creatorRamEnemyType2_400_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_450_Wall() 
	{
		return creatorRamEnemyType2_450_Wall;
	}
	public void setCreatorRamEnemyType2_450_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_450_Wall)
	{
		this.creatorRamEnemyType2_450_Wall = creatorRamEnemyType2_450_Wall;
		creatorRamEnemyType2_450_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType1 getCreatorRamEnemyType1_500_Wall()
	{
		return creatorRamEnemyType1_500_Wall;
	}
	public void setCreatorRamEnemyType1_500_Wall(
			CreatorRamEnemyType1 creatorRamEnemyType1_500_Wall)
	{
		this.creatorRamEnemyType1_500_Wall = creatorRamEnemyType1_500_Wall;
		creatorRamEnemyType1_500_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_550_Wall() 
	{
		return creatorRamEnemyType2_550_Wall;
	}
	public void setCreatorRamEnemyType2_550_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_550_Wall) 
	{
		this.creatorRamEnemyType2_550_Wall = creatorRamEnemyType2_550_Wall;
		creatorRamEnemyType2_550_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_600_Wall() 
	{
		return creatorRamEnemyType2_600_Wall;
	}
	public void setCreatorRamEnemyType2_600_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_600_Wall)
	{
		this.creatorRamEnemyType2_600_Wall = creatorRamEnemyType2_600_Wall;
		creatorRamEnemyType2_600_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_650_Wall() 
	{
		return creatorRamEnemyType2_650_Wall;
	}
	public void setCreatorRamEnemyType2_650_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_650_Wall)
	{
		this.creatorRamEnemyType2_650_Wall = creatorRamEnemyType2_650_Wall;
		creatorRamEnemyType2_650_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_700_Wall() 
	{
		return creatorRamEnemyType2_700_Wall;
	}
	public void setCreatorRamEnemyType2_700_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_700_Wall) 
	{
		this.creatorRamEnemyType2_700_Wall = creatorRamEnemyType2_700_Wall;
		creatorRamEnemyType2_700_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType1 getCreatorRamEnemyType1_750_Wall()
	{
		return creatorRamEnemyType1_750_Wall;
	}
	public void setCreatorRamEnemyType1_750_Wall(
			CreatorRamEnemyType1 creatorRamEnemyType1_750_Wall) 
	{
		this.creatorRamEnemyType1_750_Wall = creatorRamEnemyType1_750_Wall;
		creatorRamEnemyType1_750_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_800_Wall()
	{
		return creatorRamEnemyType2_800_Wall;
	}
	public void setCreatorRamEnemyType2_800_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_800_Wall) 
	{
		this.creatorRamEnemyType2_800_Wall = creatorRamEnemyType2_800_Wall;
		creatorRamEnemyType2_800_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_850_Wall()
	{
		return creatorRamEnemyType2_850_Wall;
	}
	public void setCreatorRamEnemyType2_850_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_850_Wall) 
	{
		this.creatorRamEnemyType2_850_Wall = creatorRamEnemyType2_850_Wall;
		creatorRamEnemyType2_850_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_900_Wall() 
	{
		return creatorRamEnemyType2_900_Wall;
	}
	public void setCreatorRamEnemyType2_900_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_900_Wall)
	{
		this.creatorRamEnemyType2_900_Wall = creatorRamEnemyType2_900_Wall;
		creatorRamEnemyType2_900_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType2 getCreatorRamEnemyType2_950_Wall()
	{
		return creatorRamEnemyType2_950_Wall;
	}
	public void setCreatorRamEnemyType2_950_Wall(
			CreatorRamEnemyType2 creatorRamEnemyType2_950_Wall)
	{
		this.creatorRamEnemyType2_950_Wall = creatorRamEnemyType2_950_Wall;
		creatorRamEnemyType2_950_Wall.setGameFild(this);
	}
	public CreatorRamEnemyType3 getCreatorRamEnemyType_3_Snake() 
	{
		return creatorRamEnemyType_3_Snake;
	}
	public void setCreatorRamEnemyType_3_Snake(
			CreatorRamEnemyType3 creatorRamEnemyType_3_Snake) 
	{
		this.creatorRamEnemyType_3_Snake = creatorRamEnemyType_3_Snake;
		creatorRamEnemyType_3_Snake.setGameFild(this);
	}
	public List<AnimationDestroyEnemyTypeX> getAnimationDestroyEnemyTypeX()
	{
		return animationDestroyEnemyTypeX;
	}
	public void setAnimationDestroyEnemyTypeX(AnimationDestroyEnemyTypeX animation)
	{
		animationDestroyEnemyTypeX.add(animation);
		animation.setGameFild(this);
	}
	public List<AnimationDestroyShoot> getAnimationDestroyShoot() 
	{
		return animationDestroyShoot;
	}
	public void setAnimationDestroyShoot(AnimationDestroyShoot animation) 
	{
		animationDestroyShoot.add(animation);
		animation.setGameFild(this);
	}
	public boolean isReadyToShootUnknown() 
	{
		return readyToShootUnknown;
	}
	public void setReadyToShootUnknown(boolean readyToShootUnknown) 
	{
		this.readyToShootUnknown = readyToShootUnknown;
	}
	public boolean isReadyToShootVoidHunter()
	{
		return readyToShootVoidHunter;
	}
	public void setReadyToShootVoidHunter(boolean readyToShootVoidHunter)
	{
		this.readyToShootVoidHunter = readyToShootVoidHunter;
	}
	public boolean isReadyToShootMachinegun() 
	{
		return readyToShootMachinegun;
	}
	public void setReadyToShootMachinegun(boolean readyToShootMachinegun)
	{
		this.readyToShootMachinegun = readyToShootMachinegun;
	}
	public List<UnknownWeaponBonus> getUnknownBonus() 
	{
		return unknownBonus;
	}
	public void setUnknownBonus(UnknownWeaponBonus bonus) 
	{
		unknownBonus.add(bonus);
		bonus.setGameFild(this);
	}
	public CreatorUnknownWeaponShoot getCreatorUnknownWeaponShoot()
	{
		return creatorUnknownWeaponShoot;
	}
	public void setCreatorUnknownWeaponShoot(CreatorUnknownWeaponShoot creator)
	{
		this.creatorUnknownWeaponShoot = creator;
		creatorUnknownWeaponShoot.setGameFild(this);
	}
	public CreatorHealthBonus getCreatorHealthBonus() 
	{
		return creatorHealthBonus;
	}
	public void setCreatorHealthBonus(CreatorHealthBonus creatorHealthBonus)
	{
		this.creatorHealthBonus = creatorHealthBonus;
		creatorHealthBonus.setGameFild(this);
	}
	public CreatorRepairBonus getCreatorRepairBonus() 
	{
		return creatorRepairBonus;
	}
	public void setCreatorRepairBonus(CreatorRepairBonus creatorRepairBonus) 
	{
		this.creatorRepairBonus = creatorRepairBonus;
		creatorRepairBonus.setGameFild(this);
	}
	public CreatorEnemyCarrierType1 getCreatorEnemyCarrierType1() 
	{
		return creatorEnemyCarrierType1;
	}
	public void setCreatorEnemyCarrierType1(
			CreatorEnemyCarrierType1 creatorEnemyCarrierType1) 
	{
		this.creatorEnemyCarrierType1 = creatorEnemyCarrierType1;
		creatorEnemyCarrierType1.setGameFild(this);
	}
	public Background getBackground()
	{
		return background;
	}
	public void setBackground(Background background) 
	{
		this.background = background;
		background.setGameFild(this);
	}
	public StatsPlayerField getStatsPlayerField() 
	{
		return statsPlayerField;
	}
	public void setStatsPlayerField(StatsPlayerField statsPlayerField)
	{
		this.statsPlayerField = statsPlayerField;
		statsPlayerField.setGameFild(this);
	}
	public List<HealthBonus> getHealthBonuses() 
	{
		return healthBonuses;
	}
	public void setHealthBonuses(HealthBonus healthBonus) 
	{
		healthBonuses.add(healthBonus);
		healthBonus.setGameFild(this);
	}
	public List<RepairBonus> getRepairBonuses() 
	{
		return repairBonuses;
	}
	public void setRepairBonuses(RepairBonus repairBonus) 
	{
		repairBonuses.add(repairBonus);
		repairBonus.setGameFild(this);
	}
	public int getCountEliminateEnemyType1() 
	{
		return countEliminateEnemyType1;
	}
	public void setCountEliminateEnemyType1(int countEliminateEnemyType1)
	{
		this.countEliminateEnemyType1 = countEliminateEnemyType1;
	}
	public int getCountEliminateEnemyType2() 
	{
		return countEliminateEnemyType2;
	}
	public void setCountEliminateEnemyType2(int countEliminateEnemyType2)
	{
		this.countEliminateEnemyType2 = countEliminateEnemyType2;
	}
	public int getCountEliminateEnemyType3() 
	{
		return countEliminateEnemyType3;
	}
	public void setCountEliminateEnemyType3(int countEliminateEnemyType3)
	{
		this.countEliminateEnemyType3 = countEliminateEnemyType3;
	}
	public int getCountEliminateEnemyType4()
	{
		return countEliminateEnemyType4;
	}
	public void setCountEliminateEnemyType4(int countEliminateEnemyType4)
	{
		this.countEliminateEnemyType4 = countEliminateEnemyType4;
	}
	public int getCountEliminateRamEnemyType1() 
	{
		return countEliminateRamEnemyType1;
	}
	public void setCountEliminateRamEnemyType1(int countEliminateRamEnemyType1) 
	{
		this.countEliminateRamEnemyType1 = countEliminateRamEnemyType1;
	}
	public int getCountEliminateRamEnemyType2() 
	{
		return countEliminateRamEnemyType2;
	}
	public void setCountEliminateRamEnemyType2(int countEliminateRamEnemyType2) 
	{
		this.countEliminateRamEnemyType2 = countEliminateRamEnemyType2;
	}
	public int getCountEliminateRamEnemyType3()
	{
		return countEliminateRamEnemyType3;
	}
	public void setCountEliminateRamEnemyType3(int countEliminateRamEnemyType3)
	{
		this.countEliminateRamEnemyType3 = countEliminateRamEnemyType3;
	}
	public boolean isShieldActivated() 
	{
		return shieldActivated;
	}
	public void setShieldActivated(boolean shieldActivated) 
	{
		this.shieldActivated = shieldActivated;
	}
	public boolean isPlayerDestroyed() 
	{
		return playerDestroyed;
	}
	public void setPlayerDestroyed(boolean playerDestroyed)
	{
		this.playerDestroyed = playerDestroyed;
	}
	public List<VoidHunter> getVoidHunters()
	{
		return voidHunters;
	}
	public void setVoidHunters(VoidHunter voidHunter)
	{
		voidHunters.add(voidHunter);
		voidHunter.setGameFild(this);
		voidHunter.distanceToEnemy();
	}
	public boolean isChronometerActive() 
	{
		return chronometerActive;
	}
	public void setChronometerActive(boolean chronometerActive) 
	{
		this.chronometerActive = chronometerActive;
	}
	public boolean isChronometerAvailable()
	{
		return chronometerAvailable;
	}
	public void setChronometerAvailable(boolean chronometerAvailable) 
	{
		this.chronometerAvailable = chronometerAvailable;
	}
	public boolean isChronometerOn()
	{
		return chronometerOn;
	}
	public void setChronometerOn(boolean chronometerOn) 
	{
		this.chronometerOn = chronometerOn;
	}
	public int getIntervalWorkChronometer() 
	{
		return intervalWorkChronometer;
	}
	public void setIntervalWorkChronometer(int intervalWorkChronometer)
	{
		this.intervalWorkChronometer = intervalWorkChronometer;
	}
	public boolean isPauseCreateEnemies()
	{
		return pauseCreateEnemies;
	}
	public void setPauseCreateEnemies(boolean pauseCreateEnemies) 
	{
		this.pauseCreateEnemies = pauseCreateEnemies;
	}
	public boolean isStartMoveCarrierType1() 
	{
		return startMoveCarrierType1;
	}
	public void setStartMoveCarrierType1(boolean startMoveCarrierType1) 
	{
		this.startMoveCarrierType1 = startMoveCarrierType1;
	}
	public boolean isCarrierDestroy() 
	{
		return carrierDestroy;
	}
	public void setCarrierDestroy(boolean carrierDestroy)
	{
		this.carrierDestroy = carrierDestroy;
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Right_Level_2()
	{
		return creatorEnemyType_1_Straight_50_950_Right_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Right_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Right_Level_2)
	{
		this.creatorEnemyType_1_Straight_50_950_Right_Level_2 = creatorEnemyType_1_Straight_50_950_Right_Level_2;
		creatorEnemyType_1_Straight_50_950_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Left_Level_2() 
	{
		return creatorEnemyType_1_Straight_50_950_Left_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Left_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Left_Level_2) 
	{
		this.creatorEnemyType_1_Straight_50_950_Left_Level_2 = creatorEnemyType_1_Straight_50_950_Left_Level_2;
		creatorEnemyType_1_Straight_50_950_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_350_650_Right_Level_2() 
	{
		return creatorEnemyType_1_Straight_350_650_Right_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_350_650_Right_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Right_Level_2) 
	{
		this.creatorEnemyType_1_Straight_350_650_Right_Level_2 = creatorEnemyType_1_Straight_350_650_Right_Level_2;
		creatorEnemyType_1_Straight_350_650_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_350_650_Left_Level_2() 
	{
		return creatorEnemyType_1_Straight_350_650_Left_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_350_650_Left_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_350_650_Left_Level_2)
	{
		this.creatorEnemyType_1_Straight_350_650_Left_Level_2 = creatorEnemyType_1_Straight_350_650_Left_Level_2;
		creatorEnemyType_1_Straight_350_650_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Diagonal_From_Left_Level_2() 
	{
		return creatorEnemyType_1_Diagonal_From_Left_Level_2;
	}
	public void setCreatorEnemyType_1_Diagonal_From_Left_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Left_Level_2)
	{
		this.creatorEnemyType_1_Diagonal_From_Left_Level_2 = creatorEnemyType_1_Diagonal_From_Left_Level_2;
		creatorEnemyType_1_Diagonal_From_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Diagonal_From_Right_Level_2()
	{
		return creatorEnemyType_1_Diagonal_From_Right_Level_2;
	}
	public void setCreatorEnemyType_1_Diagonal_From_Right_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Diagonal_From_Right_Level_2)
	{
		this.creatorEnemyType_1_Diagonal_From_Right_Level_2 = creatorEnemyType_1_Diagonal_From_Right_Level_2;
		creatorEnemyType_1_Diagonal_From_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2() 
	{
		return creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2) 
	{
		this.creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2 = creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2;
		creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2() 
	{
		return creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2) 
	{
		this.creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2 = creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2;
		creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType1 getCreatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2() 
	{
		return creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2;
	}
	public void setCreatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2(
			CreatorEnemyType1 creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2)
	{
		this.creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2 = creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2;
		creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Straight_50_950_Right_Level_2() 
	{
		return creatorEnemyType_2_Straight_50_950_Right_Level_2;
	}
	public void setCreatorEnemyType_2_Straight_50_950_Right_Level_2(
			CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Right_Level_2) 
	{
		this.creatorEnemyType_2_Straight_50_950_Right_Level_2 = creatorEnemyType_2_Straight_50_950_Right_Level_2;
		creatorEnemyType_2_Straight_50_950_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Straight_50_950_Left_Level_2() 
	{
		return creatorEnemyType_2_Straight_50_950_Left_Level_2;
	}
	public void setCreatorEnemyType_2_Straight_50_950_Left_Level_2(
			CreatorEnemyType2 creatorEnemyType_2_Straight_50_950_Left_Level_2)
	{
		this.creatorEnemyType_2_Straight_50_950_Left_Level_2 = creatorEnemyType_2_Straight_50_950_Left_Level_2;
		creatorEnemyType_2_Straight_50_950_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Crossed_From_Left_Level_2() 
	{
		return creatorEnemyType_2_Crossed_From_Left_Level_2;
	}
	public void setCreatorEnemyType_2_Crossed_From_Left_Level_2(
			CreatorEnemyType2 creatorEnemyType_2_Crossed_From_Left_Level_2) 
	{
		this.creatorEnemyType_2_Crossed_From_Left_Level_2 = creatorEnemyType_2_Crossed_From_Left_Level_2;
		creatorEnemyType_2_Crossed_From_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType2 getCreatorEnemyType_2_Crossed_From_Right_Level_2() 
	{
		return creatorEnemyType_2_Crossed_From_Right_Level_2;
	}
	public void setCreatorEnemyType_2_Crossed_From_Right_Level_2(
			CreatorEnemyType2 creatorEnemyType_2_Crossed_From_Right_Level_2) 
	{
		this.creatorEnemyType_2_Crossed_From_Right_Level_2 = creatorEnemyType_2_Crossed_From_Right_Level_2;
		creatorEnemyType_2_Crossed_From_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType3 getCreatorEnemyType_3_Straight_50_950_Left_Level_2() 
	{
		return creatorEnemyType_3_Straight_50_950_Left_Level_2;
	}
	public void setCreatorEnemyType_3_Straight_50_950_Left_Level_2(
			CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Left_Level_2) 
	{
		this.creatorEnemyType_3_Straight_50_950_Left_Level_2 = creatorEnemyType_3_Straight_50_950_Left_Level_2;
		creatorEnemyType_3_Straight_50_950_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType3 getCreatorEnemyType_3_Straight_50_950_Right_Level_2() 
	{
		return creatorEnemyType_3_Straight_50_950_Right_Level_2;
	}
	public void setCreatorEnemyType_3_Straight_50_950_Right_Level_2(
			CreatorEnemyType3 creatorEnemyType_3_Straight_50_950_Right_Level_2)
	{
		this.creatorEnemyType_3_Straight_50_950_Right_Level_2 = creatorEnemyType_3_Straight_50_950_Right_Level_2;
		creatorEnemyType_3_Straight_50_950_Right_Level_2.setGameFild(this);
	}
	public CreatorEnemyType4 getCreatorEnemyType_4_Straight_50_950_Left_Level_2()
	{
		return creatorEnemyType_4_Straight_50_950_Left_Level_2;
	}
	public void setCreatorEnemyType_4_Straight_50_950_Left_Level_2(
			CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Left_Level_2)
	{
		this.creatorEnemyType_4_Straight_50_950_Left_Level_2 = creatorEnemyType_4_Straight_50_950_Left_Level_2;
		creatorEnemyType_4_Straight_50_950_Left_Level_2.setGameFild(this);
	}
	public CreatorEnemyType4 getCreatorEnemyType_4_Straight_50_950_Right_Level_2() 
	{
		return creatorEnemyType_4_Straight_50_950_Right_Level_2;
	}
	public void setCreatorEnemyType_4_Straight_50_950_Right_Level_2(
			CreatorEnemyType4 creatorEnemyType_4_Straight_50_950_Right_Level_2)
	{
		this.creatorEnemyType_4_Straight_50_950_Right_Level_2 = creatorEnemyType_4_Straight_50_950_Right_Level_2;
		creatorEnemyType_4_Straight_50_950_Right_Level_2.setGameFild(this);
	}
	public boolean isEndGame() 
	{
		return endGame;
	}
	public void setEndGame(boolean endGame) 
	{
		this.endGame = endGame;
	}
	public CreatorEnemyCarrierType1 getCreatorEnemyCarrierType1_Level_2()
	{
		return creatorEnemyCarrierType1_Level_2;
	}
	public void setCreatorEnemyCarrierType1_Level_2(
			CreatorEnemyCarrierType1 creatorEnemyCarrierType1_Level_2) 
	{
		this.creatorEnemyCarrierType1_Level_2 = creatorEnemyCarrierType1_Level_2;
		creatorEnemyCarrierType1_Level_2.setGameFild(this);
	}
	public int getCountKeyPressed() 
	{
		return countKeyPressed;
	}
	public void setCountKeyPressed(int countKeyPressed) 
	{
		this.countKeyPressed = countKeyPressed;
	}
	public boolean isLeftVk() 
	{
		return leftVk;
	}
	public void setLeftVk(boolean leftVk) 
	{
		this.leftVk = leftVk;
	}
	public boolean isRightVk()
	{
		return rightVk;
	}
	public void setRightVk(boolean rightVk) 
	{
		this.rightVk = rightVk;
	}
	public boolean isUpVk()
	{
		return upVk;
	}
	public void setUpVk(boolean upVk)
	{
		this.upVk = upVk;
	}
	public boolean isDownVk()
	{
		return downVk;
	}
	public void setDownVk(boolean downVk)
	{
		this.downVk = downVk;
	}
	public boolean isSpaceVk()
	{
		return spaceVk;
	}
	public void setSpaceVk(boolean spaceVk) 
	{
		this.spaceVk = spaceVk;
	}
	public void createShootsForPlayer() //отвечает за создание выстрелов игрока
	{
		for(Player player : players)
		{
			if(shootMachinegunFlag == false && shootDualGreenFlag == false &&
					shootPlasmaGunFlag == false && shootTripleFlag == false &&
					shootUnknownFlag == false && shootVoidHunterFlag == false)
			{
				List<Shoot> shoot = player.createGreenShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
				}
			}
			else if(shootDualGreenFlag == true)
			{
				List<Shoot> shoot = player.createDualGreenShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
				}
			}
			else if(shootTripleFlag == true)
			{
				List<Shoot> shoot = player.createTripleShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
				}
			}
			else if(shootMachinegunFlag == true && readyToShootMachinegun == true)
			{
				List<Shoot> shoot = player.createMashinegunShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
					countNumberShootsMachinegun--;
					if(countNumberShootsMachinegun <= 0)
					{
						readyToShootMachinegun = false;
					}
				}
			}
			else if(shootVoidHunterFlag == true && readyToShootVoidHunter == true)
			{
				if(countNumberShootsVoidHunter % 2 == 0)
				{
					setVoidHunters(new VoidHunter(player.getX() + 16, player.getY() + 30));
				}
				else
				{
					setVoidHunters(new VoidHunter(player.getX() - 20, player.getY() + 30));
				}
				countNumberShootsVoidHunter--;
				if(countNumberShootsVoidHunter <= 0)
				{
					readyToShootVoidHunter = false;
				}
			}
			else if(shootPlasmaGunFlag == true) 
			{
				List<Shoot> shoot = player.createPlasmaGunShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
				}
			}
			else if(shootUnknownFlag == true && readyToShootUnknown == true)
			{
				List<Shoot> shoot = player.createUnknownWeaponShoot(); //создать выстрел
				if(shoot != null)
				{
					shootsPlayer.addAll(shoot); //добавить его в список выстрелов
					countNumberShootsUnknown--;
					if(countNumberShootsUnknown <= 0)
					{
						readyToShootUnknown = false;
					}
				}
			}
		}
	}
	public void moveObjectsGame() throws IOException //отвечает за движение объектов поля
	{	
		final Timer timerForChronometer = new Timer();
		List<Shoot> shootsPlayerIt = new LinkedList<Shoot>();
		shootsPlayerIt.addAll(shootsPlayer);
		if(destroyEnemyType1 == false && destroyEnemyType2 == false 
				&& destroyEnemyType3 == false &&	destroyEnemyType4 == false)
		{
			destroyEnemyType1 = true;
			destroyEnemyType2 = false;
			destroyEnemyType3 = false;
			destroyEnemyType4 = false;
		}
		for(Player player : players)
		{
			if(carrierDestroy == false)
			{
				player.move(0);
			}
			else
			{
				player.movePlayerAfterCarrierDestroy();
			}
			if(player.getY() < -60)
			{
				clearFrame = true;
			}
			if(player.getY() < -70)
			{
				countLevels++;
				carrierDestroy = false;
				pauseCreateEnemies = false;
				clearFrame = false;
				///сброс всего оружия и жизней при переходе на следующий уровень на default
				gunDual = false;
				gunTriple = false;
				gunMachinegun = false;
				gunVoidHunter = false;
				gunPlasma = false;
				gunUnknown = false;
				shootDualGreenFlag = false;
				shootTripleFlag = false;
				shootMachinegunFlag = false;
				shootVoidHunterFlag = false;
				shootPlasmaGunFlag = false;
				shootUnknownFlag = false;
				countNumberShootsMachinegun = 0;
				countNumberShootsVoidHunter = 0;
				countNumberShootsUnknown = 0;
				countLifesPlayer = 2;
				player.setArmor(armorPlayer);
				///
				player.setX(startPointForPlayerX);
				player.setY(startPointForPlayerY);
				player.stop();
			}
			if(countLevels == 2 && carrierDestroy == true)
			{
				writeScore(score);
				player.setSpeed(0);
				endGame = true;
			}
			currentArmorPlayer = player.getArmor();
			percentageArmorPlayer = (int) (currentArmorPlayer * 100 / armorPlayer);
		}
		background.moveBackground1();
		////CREATORS FOR LEVEL 1////
		if(countLevels == 1)
		{
			addCreatorsForLevel_1();
		}
		////CREATORS FOR LEVEL 2////
		if(countLevels == 2)
		{
			addCreatorsForLevel_2();
		}
		////STAR DUST/////
		for(StarDust starDust : starDusts)
		{
			starDust.move();
		}
		///////////////////
		////CHRONOMETER////
		/////////////////// 
		if(chronometerActive == true)
		{
			timerForChronometer.schedule(new TimerTask()
			{
				public void run()
				{
					if(chronometerActive == false)
					{
						timerForChronometer.cancel();
					}
					chronometerOn = false;
					chronometerActive = false;
					chronometerAvailable = false;
					if(chronometerAvailable == false)
					{
						reloadChronometer();
					}
				}
			}, timeWorkChronometer);
		}
		///////////////////
		////SHOOT BONUS////
		///////////////////
		processingOperations_Shoot_Bonus();
		////////////////////
		////HEALTH BONUS////
		////////////////////
		processingOperations_Health_Bonus();
		////////////////////
		////REPAIR BONUS////
		////////////////////
		processingOperations_Repair_Bonus();
		///////////////////////////////
		////ANIMATION DESTROY ENEMY////
		///////////////////////////////
		animationDestroyEnemy();
		///////////////////////////////
		////ANIMATION DESTROY SHOOT////
		///////////////////////////////
		animationDestroyShoot();
		///////////////////
		////VOID HUNTER////
		///////////////////
		processingOperations_Void_Hunter();
		////////////////////////////////////////////////////////////////
		///////////////////CARRIER TYPE1////////////////////////////////
		////////////////////////////////////////////////////////////////
		if(enemyCarrierType1.size() > 0)
		{
			processingOperations_Enemy_Carrier_Type_1();
		}
		////////////////////////////////////////////////////////////////
		////////////////////////противник TYPE1/////////////////////////
		////////////////////////////////////////////////////////////////
		if(enemiesType1.size() > 0)
		{
			processingOperations_Enemy_Type_1();
		}
		////////////////////////////////////////////////////////////////
		///////////////////////противник TYPE2//////////////////////////
		////////////////////////////////////////////////////////////////
		if(enemiesType2.size() > 0)
		{
			processingOperations_Enemy_Type_2();
		}
		////////////////////////////////////////////////////////////////
		///////////////////////противник TYPE3//////////////////////////
		////////////////////////////////////////////////////////////////
		if(enemiesType3.size() > 0)
		{
			processingOperations_Enemy_Type_3();
		}
		////////////////////////////////////////////////////////////////
		//////////////////////противник TYPE4///////////////////////////
		////////////////////////////////////////////////////////////////
		if(enemiesType4.size() > 0)
		{
			processingOperations_Enemy_Type_4();
		}
		////////////////////////////////////////////////////////////////
		//////////////////////противник RAM TYPE1///////////////////////
		////////////////////////////////////////////////////////////////
		if(ramEnemiesType1.size() > 0)
		{
			processingOperations_Ram_Enemy_Type_1();
		}
		////////////////////////////////////////////////////////////////
		///////////////////////противник RAM TYPE2//////////////////////
		////////////////////////////////////////////////////////////////
		if(ramEnemiesType2.size() > 0)
		{
			processingOperations_Ram_Enemy_Type_2();
		}
		////////////////////////////////////////////////////////////////
		/////////////////////противник RAM TYPE3////////////////////////
		////////////////////////////////////////////////////////////////
		if(ramEnemiesType3.size() > 0)
		{
			processingOperations_Ram_Enemy_Type_3();
		}
		//////////////////////////////
		////FREE FLY PLAYER SHOOTS////
		//////////////////////////////
		processingOperations_Free_Fly_Shoots_Player();
		/////////////////////////////
		////FREE FLY ENEMY SHOOTS////
		/////////////////////////////
		processingOperations_Free_Fly_Shoots_Enemy();
		///////////////////////
		////DESTROY OBJECTS////
		///////////////////////
		destroyObjects();
		////////////////////////////////////
		////CLEAR FRAME AFTER END LEVEL1////
		////////////////////////////////////
		if(clearFrame == true)
		{
			clearFrameAfterEndLevel_1();
		}
	}
	public void timerWorkChronometer()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
	    {
	        public void run()
	        {
	        	if(chronometerActive == false)
	        	{
	        		timer.cancel();
	        	}
	        	countdownTimer();
	        }
	    }, 0, 1000);
	}
	private void countdownTimer() 
	{
		if(chronometerOn == true)
		{
			if(intervalWorkChronometer <= 1)
			{
				chronometerOn = false;
			}
			if(chronometerOn == true)
			{
				intervalWorkChronometer--;
			}
		}
		else
		{
			intervalWorkChronometer = (timeWorkChronometer / 1000) + 1;
		}
	}
	private void reloadChronometer() //перезарядка хронометра
	{
		final Timer timer = new Timer();
		if(chronometerAvailable == false)
		{
			timer.schedule(new TimerTask()
			{
				public void run()
				{
					if(chronometerAvailable == true)
					{
						timer.cancel();
					}
					chronometerAvailable = true;
				}
			}, timeReloadChronometer);
		}
	}
	private void distanceToEnemyForLock()
	{
		if(gunVoidHunter == true && shootVoidHunterFlag == true)
		{
			int distanceToTargetX = 0; 
			int distanceToTargetY = 0; 
			int distanceToTarget;
			int minDistanceToTarget = 9000;
			for(Player player : players)
			{
				for(EnemyType1 enemyType1 : enemiesType1)
				{
					if(countNumberShootsVoidHunter % 2 == 0)
					{
						distanceToTargetX = enemyType1.getX() - player.getX() - 20;
						distanceToTargetY = enemyType1.getY() - player.getY() - 30;
					}
					else
					{
						distanceToTargetX = enemyType1.getX() - player.getX() + 16;
						distanceToTargetY = enemyType1.getY() - player.getY() - 30;
					}
					distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
					if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
					{
						minDistanceToTarget = distanceToTarget;
						targetEnemy = enemyType1;
						lockEnemyType1 = true;
						lockEnemyType2 = false;
						lockEnemyType3 = false;
						lockEnemyType4 = false;
						lockEnemyCarrierType1 = false;
					}
				}
				for(EnemyType2 enemyType2 : enemiesType2)
				{
					if(countNumberShootsVoidHunter % 2 == 0)
					{
						distanceToTargetX = enemyType2.getX() - player.getX() - 20;
						distanceToTargetY = enemyType2.getY() - player.getY() - 30;
					}
					else
					{
						distanceToTargetX = enemyType2.getX() - player.getX() + 16;
						distanceToTargetY = enemyType2.getY() - player.getY() - 30;
					}
					distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
					if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
					{
						minDistanceToTarget = distanceToTarget;
						targetEnemy = enemyType2;
						lockEnemyType1 = false;
						lockEnemyType2 = true;
						lockEnemyType3 = false;
						lockEnemyType4 = false;
						lockEnemyCarrierType1 = false;
					}
				}
				for(EnemyType3 enemyType3 : enemiesType3)
				{
					if(countNumberShootsVoidHunter % 2 == 0)
					{
						distanceToTargetX = enemyType3.getX() - player.getX() - 20;
						distanceToTargetY = enemyType3.getY() - player.getY() - 30;
					}
					else
					{
						distanceToTargetX = enemyType3.getX() - player.getX() + 16;
						distanceToTargetY = enemyType3.getY() - player.getY() - 30;
					}
					distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
					if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
					{
						minDistanceToTarget = distanceToTarget;
						targetEnemy = enemyType3;
						lockEnemyType1 = false;
						lockEnemyType2 = false;
						lockEnemyType3 = true;
						lockEnemyType4 = false;
						lockEnemyCarrierType1 = false;
					}
				}
				for(EnemyType4 enemyType4 : enemiesType4)
				{
					if(countNumberShootsVoidHunter % 2 == 0)
					{
						distanceToTargetX = enemyType4.getX() - player.getX() - 20;
						distanceToTargetY = enemyType4.getY() - player.getY() - 30;
					}
					else
					{
						distanceToTargetX = enemyType4.getX() - player.getX() + 16;
						distanceToTargetY = enemyType4.getY() - player.getY() - 30;
					}
					distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
					if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
					{
						minDistanceToTarget = distanceToTarget;
						targetEnemy = enemyType4;
						lockEnemyType1 = false;
						lockEnemyType2 = false;
						lockEnemyType3 = false;
						lockEnemyType4 = true;
						lockEnemyCarrierType1 = false;
					}
				}
				for(CarrierEnemyType1 carrierType1 : enemyCarrierType1)
				{
					if(countNumberShootsVoidHunter % 2 == 0)
					{
						distanceToTargetX = carrierType1.getX() - player.getX() - 20;
						distanceToTargetY = carrierType1.getY() - player.getY() - 30;
					}
					else
					{
						distanceToTargetX = carrierType1.getX() - player.getX() + 16;
						distanceToTargetY = carrierType1.getY() - player.getY() - 30;
					}
					distanceToTarget = (int) Math.hypot(distanceToTargetX, distanceToTargetY);
					if(minDistanceToTarget > distanceToTarget && distanceToTargetY <= 0)
					{
						minDistanceToTarget = distanceToTarget;
						targetEnemy = carrierType1;
						lockEnemyType1 = false;
						lockEnemyType2 = false;
						lockEnemyType3 = false;
						lockEnemyType4 = false;
						lockEnemyCarrierType1 = true;
					}
				}
				if(shootVoidHunterFlag == false)
				{
					lockEnemyType1 = false;
					lockEnemyType2 = false;
					lockEnemyType3 = false;
					lockEnemyType4 = false;
					lockEnemyCarrierType1 = false;
				}
			}
		}
	}
	private void processingOperations_Enemy_Type_1() throws IOException
	{
		////////////////////////////////////////////////////////////////
		////////////////////////противник TYPE1/////////////////////////
		////////////////////////////////////////////////////////////////
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		for(Enemy enemyType1 : enemiesType1)
		{
			////ENEMY////
			if(enemyType1.getIdForMove() == 3)
			{
				if(enemyType1.getY() < 0)
				{
					enemyType1.moveStraight();
				}
				else
				{
					enemyType1.moveDiagonalFromLeft();
				}
			}
			else if(enemyType1.getIdForMove() == 2)
			{
				if(enemyType1.getY() < 0)
				{
					enemyType1.moveStraight();
				}
				else
				{
					enemyType1.moveDiagonalFromRight();
				}
			}
			else if(enemyType1.getIdForMove() == 1)
			{
				if(enemyType1.getY() < 0)
				{
					enemyType1.moveStraight();
				}
				else
				{
					enemyType1.moveCrossed();
				}
			}
			else if(enemyType1.getIdForMove() == 0)
			{
				enemyType1.moveStraight();
			}
			distanceToEnemyForLock();
			Shoot shoot = enemyType1.createShootEnemyType1(); // создать выстрелы противника
			if(shoot != null) 
			{
				shootsEnemyType1.add(shoot);
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(enemyType1.getY() > height + 100)
			{
				destroyedEnemiesType1.add(enemyType1);
				continue;
			}
			if(chronometerActive == true)
			{
				enemyType1.setCheckChronometron(4);
			}
			else
			{
				enemyType1.setCheckChronometron(5);
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = enemyType1.getX() - player.getX();
				distancePlayerToEnemyY = enemyType1.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					countDestroyedEnemyType1++;
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(enemiesType1.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType1.getX(),
											enemyType1.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType1 == 5) 
								{
									destroyEnemyType1 = true;
									destroyEnemyType2 = false;
									destroyEnemyType3 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType1.getX(),
											enemyType1.getY(), speedShootBonus));
									countDestroyedEnemyType1 = 0;
								}
								destroyedEnemiesType1.add(enemyType1);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield + timeDelayWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - enemyType1.getX();
				distanceY = shootPlayer.getY() - enemyType1.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						enemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType1.getArmor() <= 0)
						{
							score += 100;
							countDestroyedEnemyType1++;
							countEliminateEnemyType1++;
							if(enemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType1.getX(),
												enemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType1 == 5) 
									{
										destroyEnemyType1 = true;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType1.getX(),
												enemyType1.getY(), speedShootBonus));
										countDestroyedEnemyType1 = 0;
									}
									destroyedEnemiesType1.add(enemyType1);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						enemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType1.getArmor() <= 0)
						{
							score += 100;
							countDestroyedEnemyType1++;
							countEliminateEnemyType1++;
							if(enemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType1.getX(),
												enemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType1 == 5) 
									{
										destroyEnemyType1 = true;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										countDestroyedEnemyType1 = 0;
									}
									destroyedEnemiesType1.add(enemyType1);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType1.getArmor() <= 0) //<= было
						{
							score += 100;
							countDestroyedEnemyType1++;
							countEliminateEnemyType1++;
							if(enemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType1.getX(),
												enemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType1 == 5)  
									{
										destroyEnemyType1 = true;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType1.getX(),
												enemyType1.getY(), speedShootBonus));
										countDestroyedEnemyType1 = 0;
									}
									destroyedEnemiesType1.add(enemyType1);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			}
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsEnemyType1)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToShootEnemy < 20 && 
							Math.abs(distanceShootX) < 5)
					{
						if(shootPlayer.getWeapon().getIndicator() == 0)
						{
							shootDestroy = true;
							shootDestroy = false;
						}
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsEnemyType1.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsEnemyType1.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceShootY) < 20) 
					{
						destroyedShootsEnemyType1.add(shootEnemy);
						continue;
					}
				}
			}
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{		
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 30)
				{
					if(shieldActivated == true)
					{
						destroyedShootsEnemyType1.add(shootEnemy);
					}
					else
					{
						player.damageArmorEnemyType1(shootEnemy.getWeapon());
						destroyedShootsEnemyType1.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			}
		}
	}
	private void processingOperations_Enemy_Type_2() throws IOException
	{
		////////////////////////////////////////////////////////////////
		///////////////////////противник TYPE2//////////////////////////
		////////////////////////////////////////////////////////////////
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		for(Enemy enemyType2 : enemiesType2)
		{
			////ENEMY////
			if(enemyType2.getIdForMove() == 3)
			{
				if(enemyType2.getY() < 0)
				{
					enemyType2.moveStraight();
				}
				else
				{
					enemyType2.moveCrossedDiagonalFromLeft();
				}
			}
			else if(enemyType2.getIdForMove() == 2)
			{
				if(enemyType2.getY() < 0)
				{
					enemyType2.moveStraight();
				}
				else
				{
					enemyType2.moveCrossedDiagonalFromRight();
				}
			}
			else if(enemyType2.getIdForMove() == 1)
			{
				if(enemyType2.getY() < 0)
				{
					enemyType2.moveStraight();
				}
				else
				{
					enemyType2.moveCrossed();
				}
			}
			else if(enemyType2.getIdForMove() == 0)
			{
				enemyType2.moveStraight();
			}
			distanceToEnemyForLock();
			List<Shoot> shoot = enemyType2.createShootEnemyType2(); // создать выстрелы противника
			if(shoot != null) 
			{
				shootsEnemyType2.addAll(shoot);
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(enemyType2.getY() > height + 100)
			{
				destroyedEnemiesType2.add(enemyType2);
				continue;
			}
			if(chronometerActive == true)
			{
				enemyType2.setCheckChronometron(4);
			}
			else
			{
				enemyType2.setCheckChronometron(5);
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = enemyType2.getX() - player.getX();
				distancePlayerToEnemyY = enemyType2.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					countDestroyedEnemyType2++;
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(enemiesType2.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType2.getX(),
											enemyType2.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType2 == 4) 
								{
									destroyEnemyType2 = true;
									destroyEnemyType1 = false;
									destroyEnemyType3 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType2.getX(),
											enemyType2.getY(), speedShootBonus));
									countDestroyedEnemyType2 = 0;
								}
								destroyedEnemiesType2.add(enemyType2);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height)
				{
					destroyedShootsPlayer.add(shootPlayer);
				}
				if(shootPlayer.getY() < 0)
				{
					destroyedShootsPlayer.add(shootPlayer);
				}
				distanceX = shootPlayer.getX() - enemyType2.getX();
				distanceY = shootPlayer.getY() - enemyType2.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						enemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType2.getArmor() <= 0)
						{
							score += 200;
							countDestroyedEnemyType2++;
							countEliminateEnemyType2++;
							if(enemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType2.getX(),
												enemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType2 == 4) 
									{
										destroyEnemyType2 = true;
										destroyEnemyType1 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType2.getX(),
												enemyType2.getY(), speedShootBonus));
										countDestroyedEnemyType2 = 0;
									}
									destroyedEnemiesType2.add(enemyType2);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						enemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType2.getArmor() <= 0)
						{
							score += 200;
							countDestroyedEnemyType2++;
							countEliminateEnemyType2++;
							if(enemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType2.getX(),
												enemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType2 == 4) 
									{
										destroyEnemyType2 = true;
										destroyEnemyType1 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										countDestroyedEnemyType2 = 0;
									}
									destroyedEnemiesType2.add(enemyType2);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 20)
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType2.getArmor() <= 0)
						{
							score += 200;
							countDestroyedEnemyType2++;
							countEliminateEnemyType2++;
							if(enemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType2.getX(),
												enemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType2 == 4) 
									{
										destroyEnemyType2 = true;
										destroyEnemyType1 = false;
										destroyEnemyType3 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType2.getX(),
												enemyType2.getY(), speedShootBonus));
										countDestroyedEnemyType2 = 0;
									}
									destroyedEnemiesType2.add(enemyType2);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			}
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsEnemyType2)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsEnemyType2.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsEnemyType2.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						if(shootPlayer.getWeapon().getIndicator() == 0)
						{
							shootDestroy = true;
							shootDestroy = false;
						}
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsEnemyType2.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsEnemyType2.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceShootY) < 20) 
					{
						destroyedShootsEnemyType2.add(shootEnemy);
						continue;
					}
				}
			}
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 32;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 32)
				{
					if(shieldActivated == true)
					{
						destroyedShootsEnemyType2.add(shootEnemy);
					}
					else
					{
						player.damageArmorEnemyType2(shootEnemy.getWeapon());
						destroyedShootsEnemyType2.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			}
		}
	}
	private void processingOperations_Enemy_Type_3() throws IOException
	{
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		////////////////////////////////////////////////////////////////
		///////////////////////противник TYPE3//////////////////////////
		////////////////////////////////////////////////////////////////
		for(Enemy enemyType3 : enemiesType3)
		{
			if(enemyType3.getIdForMove() == 3)
			{
				if(enemyType3.getY() < 0)
				{
					enemyType3.moveStraight();
				}
				else
				{
					enemyType3.moveDiagonalFromLeft();
				}
			}
			else if(enemyType3.getIdForMove() == 2)
			{
				if(enemyType3.getY() < 0)
				{
					enemyType3.moveStraight();
				}
				else
				{
					enemyType3.moveDiagonalFromRight();
				}
			}
			else if(enemyType3.getIdForMove() == 1)
			{
				if(enemyType3.getY() < 0)
				{
					enemyType3.moveStraight();
				}
				else
				{
					enemyType3.moveCrossed();
				}
			}
			else if(enemyType3.getIdForMove() == 0)
			{
				enemyType3.moveStraight();
			}
			distanceToEnemyForLock();
			Shoot shoot = enemyType3.createShootEnemyType3(); // создать выстрелы противника
			if(shoot != null) 
			{
				shootsEnemyType3.add(shoot);
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(enemyType3.getY() > height + 100)
			{
				destroyedEnemiesType3.add(enemyType3);
				continue;
			}
			if(chronometerActive == true)
			{
				enemyType3.setCheckChronometron(4);
			}
			else
			{
				enemyType3.setCheckChronometron(5);
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = enemyType3.getX() - player.getX();
				distancePlayerToEnemyY = enemyType3.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					countDestroyedEnemyType3++;
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(enemiesType3.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType3.getX(),
											enemyType3.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType3 == 3) 
								{ 
									destroyEnemyType3 = true;
									destroyEnemyType1 = false;
									destroyEnemyType2 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType3.getX(),
											enemyType3.getY(), speedShootBonus));
									countDestroyedEnemyType3 = 0;
								}
								destroyedEnemiesType3.add(enemyType3);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - enemyType3.getX();
				distanceY = shootPlayer.getY() - enemyType3.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 30) 
					{
						enemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType3.getArmor() <= 0)
						{
							score += 300;
							countDestroyedEnemyType3++;
							countEliminateEnemyType3++;
							if(enemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType3.getX(),
												enemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType3 == 3)
									{
										destroyEnemyType3 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType3.getX(),
												enemyType3.getY(), speedShootBonus));
										countDestroyedEnemyType3 = 0;
									}
									destroyedEnemiesType3.add(enemyType3);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						enemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType3.getArmor() <= 0)
						{
							score += 300;
							countDestroyedEnemyType3++;
							countEliminateEnemyType3++;
							if(enemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType3.getX(),
												enemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType3 == 3)
									{
										destroyEnemyType3 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType4 = false;
										countDestroyedEnemyType3 = 0;
									}
									destroyedEnemiesType3.add(enemyType3);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 30 && distanceY < 5) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType3.getArmor() <= 0)
						{
							score += 300;
							countDestroyedEnemyType3++;
							countEliminateEnemyType3++;
							if(enemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType3.getX(),
												enemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType3 == 3)
									{
										destroyEnemyType3 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType4 = false;
										setShootBonuses(new ShootBonus(enemyType3.getX(),
												enemyType3.getY(), speedShootBonus));
										countDestroyedEnemyType3 = 0;
									}
									destroyedEnemiesType3.add(enemyType3);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			} 
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsEnemyType3)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsEnemyType3.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsEnemyType3.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						if(shootPlayer.getWeapon().getIndicator() == 0)
						{
							shootDestroy = true;
							shootDestroy = false;
						}
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsEnemyType3.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsEnemyType3.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceShootY) < 20) 
					{
						destroyedShootsEnemyType3.add(shootEnemy);
						continue;
					}
				}
			}
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 30)
				{
					if(shieldActivated == true)
					{
						destroyedShootsEnemyType3.add(shootEnemy);
					}
					else
					{
						player.damageArmorEnemyType3(shootEnemy.getWeapon());
						destroyedShootsEnemyType3.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			}
		}
	}
	private void processingOperations_Enemy_Type_4() throws IOException
	{
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		////////////////////////////////////////////////////////////////
		//////////////////////противник TYPE4///////////////////////////
		////////////////////////////////////////////////////////////////
		for(Enemy enemyType4 : enemiesType4)
		{
			if(enemyType4.getIdForMove() == 6)
			{
				if(enemyType4.getY() < 0)
				{
					enemyType4.moveStraight();
				}
				else
				{
					enemyType4.moveRouteFlightRight();
				}
			}
			else if(enemyType4.getIdForMove() == 5)
			{
				if(enemyType4.getY() < 0)
				{
					enemyType4.moveStraight();
				}
				else
				{
					enemyType4.moveRouteFlightLeft();
				}
			}
			else if(enemyType4.getIdForMove() == 3)
			{
				if(enemyType4.getY() < 0)
				{
					enemyType4.moveStraight();
				}
				else
				{
					enemyType4.moveDiagonalFromLeft();
				}
			}
			else if(enemyType4.getIdForMove() == 2)
			{
				if(enemyType4.getY() < 0)
				{
					enemyType4.moveStraight();
				}
				else
				{
					enemyType4.moveDiagonalFromRight();
				}
			}
			else if(enemyType4.getIdForMove() == 1)
			{
				if(enemyType4.getY() < 0)
				{
					enemyType4.moveStraight();
				}
				else
				{
					enemyType4.moveCrossed();
				}
			}
			else if(enemyType4.getIdForMove() == 0)
			{
				enemyType4.moveStraight();
			}
			distanceToEnemyForLock();
			Shoot shoot = enemyType4.createShootEnemyType4(); // создать выстрелы противника
			if(shoot != null) 
			{
				shootsEnemyType4.add(shoot);
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(enemyType4.getY() > height + 100)
			{
				destroyedEnemiesType4.add(enemyType4);
				continue;
			}
			if(chronometerActive == true)
			{
				enemyType4.setCheckChronometron(4);
			}
			else
			{
				enemyType4.setCheckChronometron(5);
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = enemyType4.getX() - player.getX();
				distancePlayerToEnemyY = enemyType4.getY() - player.getY() - 40;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 40)
				{
					countDestroyedEnemyType4++;
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(enemiesType4.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType4.getX(),
											enemyType4.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType4 == 3) 
								{
									destroyEnemyType4 = true;
									destroyEnemyType1 = false;
									destroyEnemyType2 = false;
									destroyEnemyType3 = false;
									setShootBonuses(new ShootBonus(enemyType4.getX(),
											enemyType4.getY(), speedShootBonus));
									countDestroyedEnemyType4 = 0;
								}
								destroyedEnemiesType4.add(enemyType4);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - enemyType4.getX();
				distanceY = shootPlayer.getY() - enemyType4.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 30) 
					{
						enemyType4.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType4.getArmor() <= 0)
						{
							score += 400;
							countDestroyedEnemyType4++;
							countEliminateEnemyType4++;
							if(enemiesType4.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType4.getX(),
												enemyType4.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType4 == 3) 
									{
										destroyEnemyType4 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										setShootBonuses(new ShootBonus(enemyType4.getX(),
												enemyType4.getY(), speedShootBonus));
										countDestroyedEnemyType4 = 0;
									}
									destroyedEnemiesType4.add(enemyType4);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						enemyType4.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType4.getArmor() <= 0)
						{
							score += 400;
							countDestroyedEnemyType4++;
							countEliminateEnemyType4++;
							if(enemiesType4.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType4.getX(),
												enemyType4.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType4 == 3) 
									{
										destroyEnemyType4 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										countDestroyedEnemyType4 = 0;
									}
									destroyedEnemiesType4.add(enemyType4);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 30 && distanceY < 5) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemyType4.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemyType4.getArmor() <= 0)
						{
							score += 400;
							countDestroyedEnemyType4++;
							countEliminateEnemyType4++;
							if(enemiesType4.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemyType4.getX(),
												enemyType4.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedEnemyType4 == 3)
									{
										destroyEnemyType4 = true;
										destroyEnemyType1 = false;
										destroyEnemyType2 = false;
										destroyEnemyType3 = false;
										setShootBonuses(new ShootBonus(enemyType4.getX(),
												enemyType4.getY(), speedShootBonus));
										countDestroyedEnemyType4 = 0;
									}
									destroyedEnemiesType4.add(enemyType4);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			}
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsEnemyType4)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsEnemyType4.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsEnemyType4.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1 &&
						shootEnemy.getWeapon().getIndicator() != 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						if(shootPlayer.getWeapon().getIndicator() == 0)
						{
							shootDestroy = true;
							shootDestroy = false;
						}
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsEnemyType4.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsEnemyType4.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceShootY) < 50) 
					{
						destroyedShootsEnemyType4.add(shootEnemy);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2 && 
						shootEnemy.getWeapon().getIndicator() == 2)
				{
					if(Math.abs(distanceShootY) < 50 && Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						setAnimationDestroyShoot(
								new AnimationDestroyShoot(shootEnemy.getX(),
										shootEnemy.getY() + 35)); ///анимация коллизии снарядов
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsEnemyType4.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootEnemy.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						setAnimationDestroyShoot(
								new AnimationDestroyShoot(shootPlayer.getX(),
										shootPlayer.getY() + 60)); ///анимация коллизии снарядов
						destroyedShootsPlayer.add(shootPlayer);
						continue;
					}
				}
			}
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY();
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 30)
				{
					if(shieldActivated == true)
					{
						destroyedShootsEnemyType4.add(shootEnemy);
					}
					else
					{
						player.damageArmorEnemyType4(shootEnemy.getWeapon());
						destroyedShootsEnemyType4.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			} 
		}
	}
	private void processingOperations_Ram_Enemy_Type_1() throws IOException
	{
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		////////////////////////////////////////////////////////////////
		//////////////////////противник RAM TYPE1///////////////////////
		////////////////////////////////////////////////////////////////
		for(Enemy ramEnemyType1 : ramEnemiesType1)
		{
			if(ramEnemyType1.getIdForMove() == 3)
			{
				if(ramEnemyType1.getY() < 0)
				{
					ramEnemyType1.moveStraight();
				}
				else
				{
					ramEnemyType1.moveDiagonalFromLeft();
				}
			}
			else if(ramEnemyType1.getIdForMove() == 2)
			{
				if(ramEnemyType1.getY() < 0)
				{
					ramEnemyType1.moveStraight();
				}
				else
				{
					ramEnemyType1.moveDiagonalFromRight();
				}
			}
			else if(ramEnemyType1.getIdForMove() == 1)
			{
				if(ramEnemyType1.getY() < 0)
				{
					ramEnemyType1.moveStraight();
				}
				else
				{
					ramEnemyType1.moveCrossed();
				}
			}
			else if(ramEnemyType1.getIdForMove() == 0)
			{
				ramEnemyType1.moveStraight();
			}
			Shoot shoot = ramEnemyType1.createShootRamEnemyType1(); // создать выстрелы противника
			if(shoot != null) 
			{
				shootsRamEnemyType1.add(shoot);
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(ramEnemyType1.getY() > height + 100)
			{
				destroyedRamEnemiesType1.add(ramEnemyType1);
				continue;
			}
			if(chronometerActive == true)
			{
				ramEnemyType1.setCheckChronometron(4);
			}
			else
			{
				ramEnemyType1.setCheckChronometron(5);
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = ramEnemyType1.getX() - player.getX();
				distancePlayerToEnemyY = ramEnemyType1.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(ramEnemiesType1.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType1.getX(),
											ramEnemyType1.getY()));
							if(enemyDestroy == true) 
							{
								destroyedRamEnemiesType1.add(ramEnemyType1);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - ramEnemyType1.getX();
				distanceY = shootPlayer.getY() - ramEnemyType1.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						ramEnemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType1.getArmor() <= 0)
						{
							score += 150;
							countDestroyedRamEnemyType1++;
							countEliminateRamEnemyType1++;
							if(ramEnemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType1.getX(),
												ramEnemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType1 == 4) 
									{
										setHealthBonuses(new HealthBonus(ramEnemyType1.getX(),
												ramEnemyType1.getY(), speedHealthBonus));
										countDestroyedRamEnemyType1 = 0;
									}
									destroyedRamEnemiesType1.add(ramEnemyType1);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						ramEnemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType1.getArmor() <= 0)
						{
							score += 150;
							countDestroyedRamEnemyType1++;
							countEliminateRamEnemyType1++;
							if(ramEnemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType1.getX(),
												ramEnemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType1 == 4) 
									{
										setHealthBonuses(new HealthBonus(ramEnemyType1.getX(),
												ramEnemyType1.getY(), speedHealthBonus));
										countDestroyedRamEnemyType1 = 0;
									}
									destroyedRamEnemiesType1.add(ramEnemyType1);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						ramEnemyType1.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType1.getArmor() <= 0)
						{
							score += 150;
							countDestroyedRamEnemyType1++;
							countEliminateRamEnemyType1++;
							if(ramEnemiesType1.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType1.getX(),
												ramEnemyType1.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType1 == 4) 
									{
										setHealthBonuses(new HealthBonus(ramEnemyType1.getX(),
												ramEnemyType1.getY(), speedHealthBonus));
										countDestroyedRamEnemyType1 = 0;
									}
									destroyedRamEnemiesType1.add(ramEnemyType1);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}
			}
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsRamEnemyType1)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsRamEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsRamEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						if(shootPlayer.getWeapon().getIndicator() == 0)
						{
							shootDestroy = true;
							shootDestroy = false;
						}
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsRamEnemyType1.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsRamEnemyType1.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						destroyedShootsRamEnemyType1.add(shootEnemy);
						continue;
					}
				}
			}
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 30)
				{
					if(shieldActivated == true)
					{
						destroyedShootsRamEnemyType1.add(shootEnemy);
					}
					else
					{
						player.damageArmorRamEnemyType1(shootEnemy.getWeapon());
						destroyedShootsRamEnemyType1.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			}
		}
	}
	private void processingOperations_Ram_Enemy_Type_2() throws IOException
	{
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		////////////////////////////////////////////////////////////////
		///////////////////////противник RAM TYPE2//////////////////////
		////////////////////////////////////////////////////////////////
		for(Enemy ramEnemyType2 : ramEnemiesType2)
		{
			if(ramEnemyType2.getIdForMove() == 3)
			{
				if(ramEnemyType2.getY() < 0)
				{
					ramEnemyType2.moveStraight();
				}
				else
				{
					ramEnemyType2.moveDiagonalFromLeft();
				}
			}
			else if(ramEnemyType2.getIdForMove() == 2)
			{
				if(ramEnemyType2.getY() < 0)
				{
					ramEnemyType2.moveStraight();
				}
				else
				{
					ramEnemyType2.moveDiagonalFromRight();
				}
			}
			else if(ramEnemyType2.getIdForMove() == 1)
			{
				if(ramEnemyType2.getY() < 0)
				{
					ramEnemyType2.moveStraight();
				}
				else
				{
					ramEnemyType2.moveCrossed();
				}
			}
			else if(ramEnemyType2.getIdForMove() == 0)
			{
				ramEnemyType2.moveStraight();
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(ramEnemyType2.getY() > height + 100)
			{
				destroyedRamEnemiesType2.add(ramEnemyType2);
				continue;
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = ramEnemyType2.getX() - player.getX();
				distancePlayerToEnemyY = ramEnemyType2.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(ramEnemiesType2.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType2.getX(),
											ramEnemyType2.getY()));
							if(enemyDestroy == true) 
							{
								destroyedRamEnemiesType2.add(ramEnemyType2);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - ramEnemyType2.getX();
				distanceY = shootPlayer.getY() - ramEnemyType2.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						ramEnemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType2.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType2++;
							countEliminateRamEnemyType2++;
							if(ramEnemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType2.getX(),
												ramEnemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType2 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType2.getX(),
												ramEnemyType2.getY(), speedRepairBonus));
										countDestroyedRamEnemyType2 = 0;
									}
									destroyedRamEnemiesType2.add(ramEnemyType2);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						ramEnemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType2.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType2++;
							countEliminateRamEnemyType2++;
							if(ramEnemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType2.getX(),
												ramEnemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType2 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType2.getX(),
												ramEnemyType2.getY(), speedRepairBonus));
										countDestroyedRamEnemyType2 = 0;
									}
									destroyedRamEnemiesType2.add(ramEnemyType2);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						ramEnemyType2.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType2.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType2++;
							countEliminateRamEnemyType2++;
							if(ramEnemiesType2.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType2.getX(),
												ramEnemyType2.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType2 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType2.getX(),
												ramEnemyType2.getY(), speedRepairBonus));
										countDestroyedRamEnemyType2 = 0;
									}
									destroyedRamEnemiesType2.add(ramEnemyType2);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			} 
		}
	}
	private void processingOperations_Ram_Enemy_Type_3() throws IOException
	{
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		////////////////////////////////////////////////////////////////
		/////////////////////противник RAM TYPE3////////////////////////
		////////////////////////////////////////////////////////////////
		for(Enemy ramEnemyType3 : ramEnemiesType3)
		{
			if(ramEnemyType3.getIdForMove() == 4)
			{
				if(ramEnemyType3.getY() < 0)
				{
					ramEnemyType3.moveStraight();
				}
				else
				{
					ramEnemyType3.moveSnake();
				}
			}
			///если противник не был убит игроком и достиг нижнего края карты - kill him/////
			if(ramEnemyType3.getY() > height + 100)
			{
				destroyedRamEnemiesType3.add(ramEnemyType3);
				continue;
			}
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{
				distancePlayerToEnemyX = ramEnemyType3.getX() - player.getX();
				distancePlayerToEnemyY = ramEnemyType3.getY() - player.getY() - 30;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				if(distancePlayerToEnemy < 30)
				{
					if(shieldActivated == true)
					{
						
					}
					else
					{
						if(ramEnemiesType3.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType3.getX(),
											ramEnemyType3.getY()));
							if(enemyDestroy == true) 
							{
								destroyedRamEnemiesType3.add(ramEnemyType3);
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - ramEnemyType3.getX();
				distanceY = shootPlayer.getY() - ramEnemyType3.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						ramEnemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType3.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType3++;
							countEliminateRamEnemyType3++;
							if(ramEnemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType3.getX(),
												ramEnemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType3 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType3.getX(),
												ramEnemyType3.getY(), speedRepairBonus));
										countDestroyedRamEnemyType3 = 0;
									}
									destroyedRamEnemiesType3.add(ramEnemyType3);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceY) <= 20) 
					{
						ramEnemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType3.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType3++;
							countEliminateRamEnemyType3++;
							if(ramEnemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType3.getX(),
												ramEnemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType3 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType3.getX(),
												ramEnemyType3.getY(), speedRepairBonus));
										countDestroyedRamEnemyType3 = 0;
									}
									destroyedRamEnemiesType3.add(ramEnemyType3);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 20) 
					{
						destroyedShootsPlayer.add(shootPlayer);
						ramEnemyType3.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(ramEnemyType3.getArmor() <= 0)
						{
							score += 50;
							countDestroyedRamEnemyType3++;
							countEliminateRamEnemyType3++;
							if(ramEnemiesType3.size() >= 1)
							{
								enemyDestroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(ramEnemyType3.getX(),
												ramEnemyType3.getY()));
								if(enemyDestroy == true) 
								{
									if(countDestroyedRamEnemyType3 == 6) 
									{
										setRepairBonuses(new RepairBonus(ramEnemyType3.getX(),
												ramEnemyType3.getY(), speedRepairBonus));
										countDestroyedRamEnemyType3 = 0;
									}
									destroyedRamEnemiesType3.add(ramEnemyType3);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}
			} 
		}
	}
	private void processingOperations_Enemy_Carrier_Type_1() throws IOException
	{
		////////////////////////////////////////////////////////////////
		///////////////////CARRIER TYPE1////////////////////////////////
		////////////////////////////////////////////////////////////////
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		int distanceY2;
		int distanceY3;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distaceShootPlayerToEnemyForY2;
		int distaceShootPlayerToEnemyForY3;
		int statusArmor;
		int distancePlayerToEnemyX;
		int distancePlayerToEnemyY;
		int distancePlayerToEnemy;
		int distancePlayerToEnemyY2;
		int distancePlayerToEnemyY3;
		for(CarrierEnemyType1 enemy : enemyCarrierType1)
		{
			enemy.moveCarrierType1_200_800onX();
			if(startMoveCarrierType1 == true)
			{
				enemy.moveForCarrierType1();
			}
			if(enemy.getY() >= 200)
			{
				enemy.createEnemyType1FromCarrierType1();
			}
			distanceToEnemyForLock();
			List<Shoot> shoot = enemy.createShootCarrierEnemyType1(); // создать выстрелы противника
			if(shoot != null && enemy.getY() > 0) 
			{
				shootsCarrierEnemyType1.addAll(shoot);
			}
			if(chronometerActive == true)
			{
				enemy.setCheckChronometron(4);
			}
			else
			{
				enemy.setCheckChronometron(5);
			}
			statusArmor = (int) (enemy.getArmor() / 2);
			////ENEMY<-->PLAYER (COLLISION)////
			for(Player player : players)
			{	
				distancePlayerToEnemyX = player.getX() - enemy.getX();
				distancePlayerToEnemyY = player.getY() - enemy.getY() + 400;
				distancePlayerToEnemyY2 = player.getY() - enemy.getY() + 350;
				distancePlayerToEnemyY3 = player.getY() - enemy.getY() + 380;
				distancePlayerToEnemy = (int) Math.hypot(distancePlayerToEnemyX, distancePlayerToEnemyY);
				
				if(distancePlayerToEnemy < 360 && distancePlayerToEnemyX < 200 && distancePlayerToEnemyX >= -200 ||
						distancePlayerToEnemyY2 < 360 && distancePlayerToEnemyX == 0 ||
						distancePlayerToEnemyY3 < 360 && distancePlayerToEnemyX < 15 &&
						distancePlayerToEnemyX >= -15)
				{
					if(shieldActivated == true)
					{
						
					}
					else
					{
						enemy.damageArmorColision();
						if(enemy.getArmor() <= statusArmor + statusArmor / 2 + statusArmor / 6)
						{
							enemy.setCheckHalfArmorCarrierType1(4);
						}
						if(enemy.getArmor() <= 0)
						{
							carrierDestroy = true;
							score += 1000;
							if(enemyCarrierType1.size() >= 1)
							{
								carrierType1Destroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemy.getX(),
												enemy.getY()));
								if(carrierType1Destroy == true) 
								{
									destroyedCarrierType1.add(enemy);
								}
							}
						}
						shieldActivated = true;
						timerForShield.schedule(new TimerTask()
						{
							public void run()
							{
								if(shieldActivated == false)
								{
									timerForShield.cancel();
								}
								shieldActivated = false;
							}
						}, timeWorkShield);
						gunDual = false;
						gunTriple = false;
						gunMachinegun = false;
						gunVoidHunter = false;
						gunPlasma = false;
						gunUnknown = false;
						shootDualGreenFlag = false;
						shootTripleFlag = false;
						shootMachinegunFlag = false;
						shootVoidHunterFlag = false;
						shootPlasmaGunFlag = false;
						shootUnknownFlag = false;
						countNumberShootsMachinegun = 0;
						countNumberShootsVoidHunter = 0;
						countNumberShootsUnknown = 0;
						countLifesPlayer--;
						player.setX(startPointForPlayerX);
						player.setY(startPointForPlayerY);
						player.setArmor(armorPlayer);
						if(countLifesPlayer <= -1)
						{
							writeScore(score);
							playerDestroyed = true;
							percentageArmorPlayer = 0;
							destroyedPlayer.add(player);
						}
					}
				}
			}	
			////PLAYER SHOOT<-->ENEMY (DAMAGE)/////
			for(Shoot shootPlayer : shootsPlayer)
			{
				if(shootPlayer.getY() > height) //если выстрел достиг нижнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				if(shootPlayer.getY() < 0) //если выстрел достиг верхнего края карты
				{
					destroyedShootsPlayer.add(shootPlayer); //удалить его
					continue;
				}
				distanceX = shootPlayer.getX() - enemy.getX();
				distanceY = shootPlayer.getY() - enemy.getY() + 400; //+ 400 - для работающих крыльев 350 - для носа (кончик) 380 - для остальной части носа
				distanceY2 = shootPlayer.getY() - enemy.getY() + 350;
				distanceY3 = shootPlayer.getY() - enemy.getY() + 380;
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				distaceShootPlayerToEnemyForY2 = (int) Math.hypot(distanceX, distanceY2);
				distaceShootPlayerToEnemyForY3 = (int) Math.hypot(distanceX, distanceY3);
				if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToEnemy < 360 && distanceX < 175 && distanceX >= -175 ||
							distaceShootPlayerToEnemyForY2 < 360 && distanceX == 0 ||
							distaceShootPlayerToEnemyForY3 < 360 && distanceX < 15 && distanceX >= -15)
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemy.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemy.getArmor() <= statusArmor + statusArmor / 2 + statusArmor / 20) //подлежит проверке
						{
							enemy.setCheckHalfArmorCarrierType1(4);
						}
						if(enemy.getArmor() <= 0)
						{
							carrierDestroy = true;
							score += 1000;
							if(enemyCarrierType1.size() >= 1)
							{
								carrierType1Destroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemy.getX(),
												enemy.getY()));
								if(carrierType1Destroy == true) 
								{
									destroyedCarrierType1.add(enemy);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(distaceShootPlayerToEnemy < 400 && distanceX < 175 && distanceX >= -175 ||
							distaceShootPlayerToEnemyForY2 < 360 && distanceX == 0 ||
							distaceShootPlayerToEnemyForY3 < 360 && distanceX < 15 && distanceX >= -15 ||
							distaceShootPlayerToEnemy < 475 && distanceX > 175 && distanceX <= 375 ||
							distaceShootPlayerToEnemy < 475 && distanceX < -175 && distanceX >= -375 ||
							distaceShootPlayerToEnemy < 600 && distanceX > 375 && distanceX <= width ||
							distaceShootPlayerToEnemy < 600 && distanceX < -375 && distanceX >= -width)
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemy.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemy.getArmor() <= statusArmor + statusArmor / 2 + statusArmor / 6)
						{
							enemy.setCheckHalfArmorCarrierType1(4);
						}
						if(enemy.getArmor() <= 0)
						{	
							carrierDestroy = true;
							score += 1000;
							if(enemyCarrierType1.size() >= 1)
							{
								carrierType1Destroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemy.getX(),
												enemy.getY()));
								if(carrierType1Destroy == true) 
								{
									destroyedCarrierType1.add(enemy);
									continue;
								}
							}
						}
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToEnemy < 360 && distanceX < 175 && distanceX >= -175 ||
							distaceShootPlayerToEnemyForY2 < 360 && distanceX == 0 ||
							distaceShootPlayerToEnemyForY3 < 360 && distanceX < 15 && distanceX >= -15)
					{
						destroyedShootsPlayer.add(shootPlayer);
						enemy.damageArmor(shootPlayer.getWeapon());
						score += 5;
						if(enemy.getArmor() <= statusArmor + statusArmor / 2 + statusArmor / 6)
						{	
							enemy.setCheckHalfArmorCarrierType1(4);
						}
						if(enemy.getArmor() <= 0)
						{
							carrierDestroy = true;
							score += 1000;
							if(enemyCarrierType1.size() >= 1)
							{
								carrierType1Destroy = true; /////////////////////////////////
								setAnimationDestroyEnemyTypeX(
										new AnimationDestroyEnemyTypeX(enemy.getX(),
												enemy.getY()));
								if(carrierType1Destroy == true) 
								{
									destroyedCarrierType1.add(enemy);
									continue;
								}
							}
						}
					}
				}
				if(shootPlayer != null && shootPlayer.isDestroy())
				{
					destroyedShootsPlayer.add(shootPlayer);
				}	
			}
		}
		////ENEMY SHOOT//////
		for(Shoot shootEnemy : shootsCarrierEnemyType1)
		{
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			if(shootEnemy.getY() > height) //если выстрел достиг нижнего края карты
			{
				destroyedShootsCarrierEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			if(shootEnemy.getY() < 0) //если выстрел достиг верхнего края карты
			{
				destroyedShootsCarrierEnemyType1.add(shootEnemy); //удалить его
				continue;
			}
			////ENEMY SHOOT<-->PLAYER SHOOT (COLLISION)////
			for(Shoot shootPlayer : shootsPlayer)
			{
				distanceShootX = shootPlayer.getX() - shootEnemy.getX();
				distanceShootY = shootPlayer.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(shootPlayer.getWeapon().getIndicator() == 0 || shootPlayer.getWeapon().getIndicator() == 1)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsPlayer.add(shootPlayer);
						destroyedShootsCarrierEnemyType1.add(shootEnemy);
						shootPlayer.setX(0); 
						shootPlayer.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 2)
				{
					if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
					{
						shootDestroy = true;
						shootDestroy = false;
						destroyedShootsCarrierEnemyType1.add(shootEnemy);
						shootEnemy.setX(0); 
						shootEnemy.setY(0);
						continue;
					}
				}
				else if(shootPlayer.getWeapon().getIndicator() == 3)
				{
					if(Math.abs(distanceShootY) < 20) 
					{
						destroyedShootsCarrierEnemyType1.add(shootEnemy);
						continue;
					}
				}
			}	
			////ENEMY<-->PLAYER (DAMAGE)////
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX =  player.getX() - shootEnemy.getX();
				distanceShootEnemyToPlayerY = player.getY() - shootEnemy.getY();
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				if(distanceShootEnemyToPlayer < 30)
				{
					if(shieldActivated == true)
					{
						destroyedShootsCarrierEnemyType1.add(shootEnemy);
					}
					else
					{
						player.damageArmor(shootEnemy.getWeapon());
						destroyedShootsCarrierEnemyType1.add(shootEnemy);
						if(player.getArmor() <= 0)
						{
							shieldActivated = true;
							timerForShield.schedule(new TimerTask()
							{
								public void run()
								{
									if(shieldActivated == false)
									{
										timerForShield.cancel();
									}
									shieldActivated = false;
								}
							}, timeWorkShield);
							gunDual = false;
							gunTriple = false;
							gunMachinegun = false;
							gunVoidHunter = false;
							gunPlasma = false;
							gunUnknown = false;
							shootDualGreenFlag = false;
							shootTripleFlag = false;
							shootMachinegunFlag = false;
							shootVoidHunterFlag = false;
							shootPlasmaGunFlag = false;
							shootUnknownFlag = false;
							countNumberShootsMachinegun = 0;
							countNumberShootsVoidHunter = 0;
							countNumberShootsUnknown = 0;
							countLifesPlayer--;
							player.setX(startPointForPlayerX);
							player.setY(startPointForPlayerY);
							player.setArmor(armorPlayer);
							if(currentArmorPlayer < 0)
							{
								player.setArmor(armorPlayer);
							}
							if(countLifesPlayer <= -1)	
							{
								writeScore(score);
								playerDestroyed = true;
								percentageArmorPlayer = 0;
								destroyedPlayer.add(player);
							}
						}
					}
				}
			}
		}
	}
	private void processingOperations_Void_Hunter()
	{
		///////////////////
		////VOID HUNTER////
		///////////////////
		int distanceX; //от выстрела игрока до противника по Х
		int distanceY; //от выстрела игрока до противника по Y
		int distanceY2;
		int distanceY3;
		int distaceShootPlayerToEnemy; //длина вектора от выстрела до противника
		int distaceShootPlayerToEnemyForY2;
		int distaceShootPlayerToEnemyForY3;
		int statusArmor;
		for(VoidHunter voidHunter : voidHunters)
		{
			voidHunter.moveHunter();
			if(voidHunter.getY() >= height)
			{
				destroyedVoidHunters.add(voidHunter);
			}
			if(voidHunter.getY() <= 0)
			{
				destroyedVoidHunters.add(voidHunter);
			}
			////ENEMY TYPE1////
			for(EnemyType1 enemyType1 : enemiesType1)
			{
				distanceX = voidHunter.getX() - enemyType1.getX();
				distanceY = voidHunter.getY() - enemyType1.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 20)
				{
					destroyedVoidHunters.add(voidHunter);
					enemyType1.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(enemyType1.getArmor() <= 0) //<= было
					{
						score += 100;
						countDestroyedEnemyType1++;
						countEliminateEnemyType1++;
						if(enemiesType1.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType1.getX(),
											enemyType1.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType1 == 5)  
								{
									destroyEnemyType1 = true;
									destroyEnemyType2 = false;
									destroyEnemyType3 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType1.getX(),
											enemyType1.getY(), speedShootBonus));
									countDestroyedEnemyType1 = 0;
								}
								destroyedEnemiesType1.add(enemyType1);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootX;
			int distanceShootY;
			int distaceShootPlayerToShootEnemy; //длина вектора от выстрела игрока до выстрела противника
			for(Shoot shootEnemy : shootsEnemyType1)
			{
				distanceShootX = voidHunter.getX() - shootEnemy.getX();
				distanceShootY = voidHunter.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy = (int) 
						Math.hypot(distanceShootX, distanceShootY); 
				if(distaceShootPlayerToShootEnemy < 20 && 
						Math.abs(distanceShootX) < 10)
				{
					destroyedShootsEnemyType1.add(shootEnemy);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////ENEMY TYPE 2////
			for(EnemyType2 enemyType2 : enemiesType2)
			{
				distanceX = voidHunter.getX() - enemyType2.getX();
				distanceY = voidHunter.getY() - enemyType2.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 20)
				{
					destroyedVoidHunters.add(voidHunter);
					enemyType2.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(enemyType2.getArmor() <= 0)
					{
						score += 200;
						countDestroyedEnemyType2++;
						countEliminateEnemyType2++;
						if(enemiesType2.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType2.getX(),
											enemyType2.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType2 == 4) 
								{
									destroyEnemyType2 = true;
									destroyEnemyType1 = false;
									destroyEnemyType3 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType2.getX(),
											enemyType2.getY(), speedShootBonus));
									countDestroyedEnemyType2 = 0;
								}
								destroyedEnemiesType2.add(enemyType2);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootX2;
			int distanceShootY2;
			int distaceShootPlayerToShootEnemy2; //длина вектора от выстрела игрока до выстрела противника
			for(Shoot shootEnemy : shootsEnemyType2)
			{
				distanceShootX2 = voidHunter.getX() - shootEnemy.getX();
				distanceShootY2 = voidHunter.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy2 = (int) 
						Math.hypot(distanceShootX2, distanceShootY2); 
				if(distaceShootPlayerToShootEnemy2 < 20 && 
						Math.abs(distanceShootX2) < 10)
				{
					destroyedShootsEnemyType2.add(shootEnemy);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////ENEMY TYPE3/////
			for(EnemyType3 enemyType3 : enemiesType3)
			{
				distanceX = voidHunter.getX() - enemyType3.getX();
				distanceY = voidHunter.getY() - enemyType3.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 30 && distanceY < 5) 
				{
					destroyedVoidHunters.add(voidHunter);
					enemyType3.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(enemyType3.getArmor() <= 0)
					{
						score += 300;
						countDestroyedEnemyType3++;
						countEliminateEnemyType3++;
						if(enemiesType3.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType3.getX(),
											enemyType3.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType3 == 3)
								{
									destroyEnemyType3 = true;
									destroyEnemyType1 = false;
									destroyEnemyType2 = false;
									destroyEnemyType4 = false;
									setShootBonuses(new ShootBonus(enemyType3.getX(),
											enemyType3.getY(), speedShootBonus));
									countDestroyedEnemyType3 = 0;
								}
								destroyedEnemiesType3.add(enemyType3);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootX3;
			int distanceShootY3;
			int distaceShootPlayerToShootEnemy3; //длина вектора от выстрела игрока до выстрела противника
			for(Shoot shootEnemy : shootsEnemyType3)
			{
				distanceShootX3 = voidHunter.getX() - shootEnemy.getX();
				distanceShootY3 = voidHunter.getY() - shootEnemy.getY();
				distaceShootPlayerToShootEnemy3 = (int) 
						Math.hypot(distanceShootX3, distanceShootY3); 
				if(distaceShootPlayerToShootEnemy3 < 20 && 
						Math.abs(distanceShootX3) < 10)
				{
					destroyedShootsEnemyType3.add(shootEnemy);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////ENEMY TYPE 4////
			for(EnemyType4 enemyType4 : enemiesType4)
			{
				distanceX = voidHunter.getX() - enemyType4.getX();
				distanceY = voidHunter.getY() - enemyType4.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 30 && distanceY < 5) 
				{
					destroyedVoidHunters.add(voidHunter);
					enemyType4.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(enemyType4.getArmor() <= 0)
					{
						score += 400;
						countDestroyedEnemyType4++;
						countEliminateEnemyType4++;
						if(enemiesType4.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(enemyType4.getX(),
											enemyType4.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedEnemyType4 == 3) 
								{
									destroyEnemyType4 = true;
									destroyEnemyType1 = false;
									destroyEnemyType2 = false;
									destroyEnemyType3 = false;
									setShootBonuses(new ShootBonus(enemyType4.getX(),
											enemyType4.getY(), speedShootBonus));
									countDestroyedEnemyType4 = 0;
								}
								destroyedEnemiesType4.add(enemyType4);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootX4;
			int distanceShootY4;
			for(Shoot shootEnemy : shootsEnemyType4)
			{
				distanceShootX4 = voidHunter.getX() - shootEnemy.getX();
				distanceShootY4 = voidHunter.getY() - shootEnemy.getY();
				if(Math.abs(distanceShootY4) < 50 && Math.abs(distanceShootX4) < 10)
				{
					destroyedShootsEnemyType4.add(shootEnemy);
					destroyedVoidHunters.add(voidHunter);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////CARRIER TYPE1////
			for(CarrierEnemyType1 carrier : enemyCarrierType1)
			{
				statusArmor = (int) (carrier.getArmor() / 2);
				distanceX = voidHunter.getX() - carrier.getX();
				distanceY = voidHunter.getY() - carrier.getY() + 400; //+ 400 - для работающих крыльев 350 - для носа (кончик) 380 - для остальной части носа
				distanceY2 = voidHunter.getY() - carrier.getY() + 350;
				distanceY3 = voidHunter.getY() - carrier.getY() + 380;
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				distaceShootPlayerToEnemyForY2 = (int) Math.hypot(distanceX, distanceY2);
				distaceShootPlayerToEnemyForY3 = (int) Math.hypot(distanceX, distanceY3);
				if(distaceShootPlayerToEnemy < 360 && distanceX < 175 && distanceX >= -175 ||
						   distaceShootPlayerToEnemyForY2 < 360 && distanceX == 0 ||
						   distaceShootPlayerToEnemyForY3 < 360 && distanceX < 15 && distanceX >= -15)
				{
					destroyedVoidHunters.add(voidHunter);
					carrier.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(carrier.getArmor() <= statusArmor + statusArmor / 2 + statusArmor / 6)
					{
						carrier.setCheckHalfArmorCarrierType1(4);
					}
					if(carrier.getArmor() <= 0)
					{
						carrierDestroy = true;
						score += 1000;
						if(enemyCarrierType1.size() >= 1)
						{
							carrierType1Destroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(carrier.getX(),
											carrier.getY()));
							if(carrierType1Destroy == true) 
							{
								destroyedCarrierType1.add(carrier);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootCarrierX;
			int distanceShootCarrierY;
			for(Shoot shootEnemy : shootsCarrierEnemyType1)
			{
				distanceShootCarrierX = voidHunter.getX() - shootEnemy.getX();
				distanceShootCarrierY = voidHunter.getY() - shootEnemy.getY();
				if(Math.abs(distanceShootCarrierY) < 20 && Math.abs(distanceShootCarrierX) < 10)
				{
					destroyedShootsCarrierEnemyType1.add(shootEnemy);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////RAM TYPE1////
			for(RamEnemyType1 ramEnemyType1 : ramEnemiesType1)
			{
				distanceX = voidHunter.getX() - ramEnemyType1.getX();
				distanceY = voidHunter.getY() - ramEnemyType1.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 20) 
				{
					ramEnemyType1.damageArmor(voidHunter.getWeapon());
					destroyedVoidHunters.add(voidHunter);
					score += 5;
					if(ramEnemyType1.getArmor() <= 0)
					{
						score += 150;
						countDestroyedRamEnemyType1++;
						countEliminateRamEnemyType1++;
						if(ramEnemiesType1.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType1.getX(),
											ramEnemyType1.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedRamEnemyType1 == 4) 
								{
									setHealthBonuses(new HealthBonus(ramEnemyType1.getX(),
											ramEnemyType1.getY(), speedHealthBonus));
									countDestroyedRamEnemyType1 = 0;
								}
								destroyedRamEnemiesType1.add(ramEnemyType1);
							}
						}
					}
				}
			}
			////коллизия снарядов//////
			int distanceShootRamX;
			int distanceShootRamY;
			int distaceShootPlayerToShootRamEnemy; //длина вектора от выстрела игрока до выстрела противника
			for(Shoot shootEnemy : shootsRamEnemyType1)
			{
				distanceShootRamX = voidHunter.getX() - shootEnemy.getX();
				distanceShootRamY = voidHunter.getY() - shootEnemy.getY();
				distaceShootPlayerToShootRamEnemy = (int) 
						Math.hypot(distanceShootRamX, distanceShootRamY); 
				if(distaceShootPlayerToShootRamEnemy < 20 && 
						Math.abs(distanceShootRamX) < 10)
				{
					destroyedShootsRamEnemyType1.add(shootEnemy);
					voidHunter.setX(-20); 
					voidHunter.setY(-10);
				}
			}
			////RAM TYPE2////
			for(RamEnemyType2 ramEnemyType2 : ramEnemiesType2)
			{
				distanceX = voidHunter.getX() - ramEnemyType2.getX();
				distanceY = voidHunter.getY() - ramEnemyType2.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 20) 
				{
					destroyedVoidHunters.add(voidHunter);
					ramEnemyType2.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(ramEnemyType2.getArmor() <= 0)
					{
						score += 50;
						countDestroyedRamEnemyType2++;
						countEliminateRamEnemyType2++;
						if(ramEnemiesType2.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType2.getX(),
											ramEnemyType2.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedRamEnemyType2 == 6) 
								{
									setRepairBonuses(new RepairBonus(ramEnemyType2.getX(),
											ramEnemyType2.getY(), speedRepairBonus));
									countDestroyedRamEnemyType2 = 0;
								}
								destroyedRamEnemiesType2.add(ramEnemyType2);
							}
						}
					}
				}
			}
			////RAM TYPE3////
			for(RamEnemyType3 ramEnemyType3 : ramEnemiesType3)
			{
				distanceX = voidHunter.getX() - ramEnemyType3.getX();
				distanceY = voidHunter.getY() - ramEnemyType3.getY();
				distaceShootPlayerToEnemy = (int) Math.hypot(distanceX, distanceY);
				if(distaceShootPlayerToEnemy < 20) 
				{
					destroyedVoidHunters.add(voidHunter);
					ramEnemyType3.damageArmor(voidHunter.getWeapon());
					score += 5;
					if(ramEnemyType3.getArmor() <= 0)
					{
						score += 50;
						countDestroyedRamEnemyType3++;
						countEliminateRamEnemyType3++;
						if(ramEnemiesType3.size() >= 1)
						{
							enemyDestroy = true; /////////////////////////////////
							setAnimationDestroyEnemyTypeX(
									new AnimationDestroyEnemyTypeX(ramEnemyType3.getX(),
											ramEnemyType3.getY()));
							if(enemyDestroy == true) 
							{
								if(countDestroyedRamEnemyType3 == 6) 
								{
									setRepairBonuses(new RepairBonus(ramEnemyType3.getX(),
											ramEnemyType3.getY(), speedRepairBonus));
									countDestroyedRamEnemyType3 = 0;
								}
								destroyedRamEnemiesType3.add(ramEnemyType3);
							}
						}
					}
				}	
			}
		}
	}
	private void processingOperations_Repair_Bonus()
	{
		////////////////////
		////REPAIR BONUS////
		////////////////////
		int distancePlayerToBonusX;
		int distancePlayerToBonusY;
		int percentageRepair;
		for(RepairBonus repairBonus : repairBonuses)
		{
			repairBonus.moveBonus();
			if(repairBonus.getY() >= height)
			{
				destroyedRepairBonus.add(repairBonus);
			}
			for(Player player : players)
			{
				distancePlayerToBonusX = player.getX() - repairBonus.getX();
				distancePlayerToBonusY = player.getY() - repairBonus.getY() + 40; //60
				if(Math.abs(distancePlayerToBonusY) < 35 && 
						distancePlayerToBonusX > -40 && distancePlayerToBonusX <= 40)
				{
					currentArmorPlayer = player.getArmor();
					percentageRepair = (int) (armorPlayer / 4);
					if(currentArmorPlayer <= armorPlayer - percentageRepair)
					{
						player.setArmor(currentArmorPlayer + percentageRepair);
					}
					else if(currentArmorPlayer > armorPlayer - percentageRepair)
					{
						currentArmorPlayer = armorPlayer - currentArmorPlayer;
						player.setArmor(player.getArmor() + currentArmorPlayer);
					}
					else if(currentArmorPlayer >= armorPlayer)
					{
						currentArmorPlayer = currentArmorPlayer;
					}
					destroyedRepairBonus.add(repairBonus);
				}
			}
		}
	}
	private void processingOperations_Health_Bonus()
	{
		////////////////////
		////HEALTH BONUS////
		////////////////////
		int distancePlayerToBonusX;
		int distancePlayerToBonusY;
		for(HealthBonus healthBonus : healthBonuses)
		{
			healthBonus.moveBonus();
			if(healthBonus.getY() >= height)
			{
				destroyedHealthBonus.add(healthBonus);
			}
			for(Player player : players)
			{
				distancePlayerToBonusX = player.getX() - healthBonus.getX();
				distancePlayerToBonusY = player.getY() - healthBonus.getY() + 40; //60
				if(Math.abs(distancePlayerToBonusY) < 35 && 
						distancePlayerToBonusX > -40 && distancePlayerToBonusX <= 40)
				{
					if(countLifesPlayer < maxCountLifesPlayer)
					{
						countLifesPlayer++;
					}
					if(countLifesPlayer >= maxCountLifesPlayer)
					{
						countLifesPlayer = countLifesPlayer;
					}
					destroyedHealthBonus.add(healthBonus);
				}
			}
		}
	}
	private void processingOperations_Shoot_Bonus()
	{
		///////////////////
		////SHOOT BONUS////
		///////////////////
		int distancePlayerToBonusX;
		int distancePlayerToBonusY;
		for(ShootBonus shootBonus : shootBonuses)
		{
			shootBonus.moveBonus();
			if(shootBonus.getY() >= height)
			{
				destroyedShootBonus.add(shootBonus);
			}
			for(Player player : players)
			{
				distancePlayerToBonusX = player.getX() - shootBonus.getX();
				distancePlayerToBonusY = player.getY() - shootBonus.getY() + 40; //60
				if(Math.abs(distancePlayerToBonusY) < 35 && 
						distancePlayerToBonusX > -40 && distancePlayerToBonusX <= 40)
				{
					if(destroyEnemyType1 == true)
					{
						do
						{
							flagForGun = (int) (Math.random() * (3 - 2 + 1) + 2);
						}
						while(previos == flagForGun);
						previos = flagForGun;
						if(flagForGun == 2)
						{
							gunDual = true;
						}
						else if(flagForGun == 3)
						{
							gunTriple = true;
						}
					}
					else if(destroyEnemyType2 == true)
					{
						do
						{
							flagForGun = (int) (Math.random() * (4 - 2 + 1) + 2);
						}
						while(previos == flagForGun);
						previos = flagForGun;
						if(flagForGun == 2)
						{
							gunDual = true;
						}
						else if(flagForGun == 3)
						{
							gunTriple = true;
						}
						else if(flagForGun == 4)
						{
							gunMachinegun = true;
							readyToShootMachinegun = true;
							if(maxCountMachinegunShootsPlayer - countNumberShootsMachinegun <= 99
									&& countNumberShootsMachinegun < maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun += maxCountMachinegunShootsPlayer - 
										countNumberShootsMachinegun; 
							}
							else if(maxCountMachinegunShootsPlayer - countNumberShootsMachinegun > 99 &&
									countNumberShootsMachinegun < maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun += 100;
							}
							else if(countNumberShootsMachinegun > maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun = countNumberShootsMachinegun;
							}
						}
					}
					else if(destroyEnemyType3 == true)
					{
						do
						{
							flagForGun = (int) (Math.random() * (5 - 4 + 1) + 4); 
						}
						while(previos == flagForGun);
						if(flagForGun == 4)
						{
							gunMachinegun = true;
							readyToShootMachinegun = true;
							if(maxCountMachinegunShootsPlayer - countNumberShootsMachinegun <= 99
									&& countNumberShootsMachinegun < maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun += maxCountMachinegunShootsPlayer - 
										countNumberShootsMachinegun; 
							}
							else if(maxCountMachinegunShootsPlayer - countNumberShootsMachinegun > 99 &&
									countNumberShootsMachinegun < maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun += 100;
							}
							else if(countNumberShootsMachinegun > maxCountMachinegunShootsPlayer)
							{
								countNumberShootsMachinegun = countNumberShootsMachinegun;
							}
						}
						if(flagForGun == 5)
						{
							gunVoidHunter = true;
							readyToShootVoidHunter = true;
							if(maxCountVoidHunterShootsPlayer - countNumberShootsVoidHunter != 1 &&
									countNumberShootsVoidHunter < maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter += 2;
							}
							else if(maxCountVoidHunterShootsPlayer - countNumberShootsVoidHunter == 1 &&
									countNumberShootsVoidHunter < maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter++;
							}
							else if(countNumberShootsVoidHunter >= maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter = countNumberShootsVoidHunter;
							}
						}
					}
					else if(destroyEnemyType4 == true)
					{
						do
						{
							flagForGun = (int) (Math.random() * (6 - 5 + 1) + 5);
						}
						while(previos == flagForGun);
						if(flagForGun == 5)
						{
							gunVoidHunter = true;
							readyToShootVoidHunter = true;
							if(maxCountVoidHunterShootsPlayer - countNumberShootsVoidHunter != 1 &&
									countNumberShootsVoidHunter < maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter += 2;
							}
							else if(maxCountVoidHunterShootsPlayer - countNumberShootsVoidHunter == 1 &&
									countNumberShootsVoidHunter < maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter++;
							}
							else if(countNumberShootsVoidHunter >= maxCountVoidHunterShootsPlayer)
							{
								countNumberShootsVoidHunter = countNumberShootsVoidHunter;
							}
						}
						if(flagForGun == 6)
						{
							gunPlasma = true;
						}
					}
					destroyedShootBonus.add(shootBonus);
				}
			}	
		}
		for(UnknownWeaponBonus bonus : unknownBonus)
		{
			bonus.moveBonus();
			for(Player player : players)
			{
				distancePlayerToBonusX = player.getX() - bonus.getX();
				distancePlayerToBonusY = player.getY() - bonus.getY() + 40;
				if(Math.abs(distancePlayerToBonusY) < 50 && 
						distancePlayerToBonusX > -40 && distancePlayerToBonusX <= 40)
				{
					gunUnknown = true;
					readyToShootUnknown = true;
					if(countNumberShootsUnknown < maxCountUnknownShootsPlayer)
					{
						countNumberShootsUnknown++;
					}
					if(countNumberShootsUnknown >= maxCountUnknownShootsPlayer)
					{
						countNumberShootsUnknown = countNumberShootsUnknown;
					}
					destroyedUnknownWeaponBonus.add(bonus);
				}
			}
		}
	}
	private void processingOperations_Free_Fly_Shoots_Enemy() throws IOException
	{
		////Если все противники убиты, снаряды по-прежнему должны лететь и наносить урон, реализовано ниже////
		int distanceShootEnemyToPlayerX;
		int distanceShootEnemyToPlayerY;
		int distanceShootEnemyToPlayer;
		/////////////////////////////////
		////выстрелы противника TYPE1////
		/////////////////////////////////
		for(Shoot shootEnemy : shootsEnemyType1)
		{
			shootEnemy.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(enemiesType1.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 30)
					{
						if(shieldActivated == true)
						{
							destroyedShootsEnemyType1.add(shootEnemy);
						}
						else
						{
							player.damageArmor(shootEnemy.getWeapon());
							destroyedShootsEnemyType1.add(shootEnemy);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootEnemy.getX();
					distanceShootY = shootPlayer.getY() - shootEnemy.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
										shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsEnemyType1.add(shootEnemy);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
								new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsEnemyType1.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(Math.abs(distanceShootY) < 20) 
						{
							destroyedShootsEnemyType1.add(shootEnemy);
							continue;
						}
					}
				}
			}
		}
		/////////////////////////////////
		////выстрелы противника TYPE2////
		/////////////////////////////////
		for(Shoot shootEnemy : shootsEnemyType2)
		{
			shootEnemy.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 32;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(enemiesType2.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 32)
					{
						if(shieldActivated == true)
						{
							destroyedShootsEnemyType2.add(shootEnemy);
						}
						else
						{
							player.damageArmor(shootEnemy.getWeapon());
							destroyedShootsEnemyType2.add(shootEnemy);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootEnemy.getX();
					distanceShootY = shootPlayer.getY() - shootEnemy.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsEnemyType2.add(shootEnemy);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsEnemyType2.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(Math.abs(distanceShootY) < 20) 
						{
							destroyedShootsEnemyType2.add(shootEnemy);
							continue;
						}
					}
				}
			}
		}
		/////////////////////////////////
		////выстрелы противника TYPE3////
		/////////////////////////////////
		for(Shoot shootEnemy : shootsEnemyType3)
		{
			shootEnemy.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(enemiesType3.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 30)
					{
						if(shieldActivated == true)
						{
							destroyedShootsEnemyType3.add(shootEnemy);
						}
						else
						{
							player.damageArmor(shootEnemy.getWeapon());
							destroyedShootsEnemyType3.add(shootEnemy);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootEnemy.getX();
					distanceShootY = shootPlayer.getY() - shootEnemy.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
								new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsEnemyType3.add(shootEnemy);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsEnemyType3.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(Math.abs(distanceShootY) < 20) 
						{
							destroyedShootsEnemyType3.add(shootEnemy);
							continue;
						}
					}
				}
			}
		}
		/////////////////////////////////
		////выстрелы противника TYPE4////
		/////////////////////////////////
		for(Shoot shootEnemy : shootsEnemyType4)
		{
			shootEnemy.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY();
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(enemiesType4.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 30)
					{
						if(shieldActivated == true)
						{
							destroyedShootsEnemyType4.add(shootEnemy);
						}
						else
						{
							player.damageArmor(shootEnemy.getWeapon());
							destroyedShootsEnemyType4.add(shootEnemy);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootEnemy.getX();
					distanceShootY = shootPlayer.getY() - shootEnemy.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0 &&
							shootEnemy.getWeapon().getIndicator() != 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsEnemyType4.add(shootEnemy);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsEnemyType4.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(Math.abs(distanceShootY) < 50) 
						{
							destroyedShootsEnemyType4.add(shootEnemy);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2 && 
							shootEnemy.getWeapon().getIndicator() == 2)
					{
						if(Math.abs(distanceShootY) < 50 && Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() + 35)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsEnemyType4.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootEnemy.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
							{
								shootDestroy = true;
								setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 60)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							continue;
						}
					}
				}
			}
		}
		/////////////////////////////////////
		////выстрелы противника RAM TYPE1////
		/////////////////////////////////////
		for(Shoot shootEnemy : shootsRamEnemyType1)
		{
			shootEnemy.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootEnemy.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootEnemy.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(ramEnemiesType1.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 30)
					{
						if(shieldActivated == true)
						{
							destroyedShootsRamEnemyType1.add(shootEnemy);
						}
						else
						{
							player.damageArmor(shootEnemy.getWeapon());
							destroyedShootsRamEnemyType1.add(shootEnemy);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootEnemy.getX();
					distanceShootY = shootPlayer.getY() - shootEnemy.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsRamEnemyType1.add(shootEnemy);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootEnemy.getX(),
											shootEnemy.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsRamEnemyType1.add(shootEnemy);
							shootEnemy.setX(0); 
							shootEnemy.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							destroyedShootsRamEnemyType1.add(shootEnemy);
							continue;
						}
					}
				}
			}
		}
		/////////////////////////////////////////
		////выстрелы противника CARRIER TYPE1////
		/////////////////////////////////////////
		for(Shoot shootCarrierEnemyType1 : shootsCarrierEnemyType1)
		{
			shootCarrierEnemyType1.move();
			for(Player player : players)
			{
				distanceShootEnemyToPlayerX = shootCarrierEnemyType1.getX() - player.getX();
				distanceShootEnemyToPlayerY = shootCarrierEnemyType1.getY() - player.getY() - 30;
				distanceShootEnemyToPlayer = (int) Math.hypot(distanceShootEnemyToPlayerX, distanceShootEnemyToPlayerY);
				int distanceShootX;
				int distanceShootY;
				int distaceShootPlayerToShootEnemy;
				if(enemyCarrierType1.size() <= 0)
				{
					if(distanceShootEnemyToPlayer < 30)
					{
						if(shieldActivated == true)
						{
							destroyedShootsCarrierEnemyType1.add(shootCarrierEnemyType1);
						}
						else
						{
							player.damageArmor(shootCarrierEnemyType1.getWeapon());
							destroyedShootsCarrierEnemyType1.add(shootCarrierEnemyType1);
							if(player.getArmor() <= 0)
							{
								shieldActivated = true;
								timerForShield.schedule(new TimerTask()
								{
									public void run()
									{
										if(shieldActivated == false)
										{
											timerForShield.cancel();
										}
										shieldActivated = false;
									}
								}, timeWorkShield);
								gunDual = false;
								gunTriple = false;
								gunMachinegun = false;
								gunVoidHunter = false;
								gunPlasma = false;
								gunUnknown = false;
								shootDualGreenFlag = false;
								shootTripleFlag = false;
								shootMachinegunFlag = false;
								shootVoidHunterFlag = false;
								shootPlasmaGunFlag = false;
								shootUnknownFlag = false;
								countNumberShootsMachinegun = 0;
								countNumberShootsVoidHunter = 0;
								countNumberShootsUnknown = 0;
								countLifesPlayer--;
								player.setX(startPointForPlayerX);
								player.setY(startPointForPlayerY);
								if(countLifesPlayer <= -1)
								{
									writeScore(score);
									playerDestroyed = true;
									percentageArmorPlayer = 0;
									destroyedPlayer.add(player);
								}
							}
						}
					}
				}
				for(Shoot shootPlayer : shootsPlayer)
				{
					distanceShootX = shootPlayer.getX() - shootCarrierEnemyType1.getX();
					distanceShootY = shootPlayer.getY() - shootCarrierEnemyType1.getY();
					distaceShootPlayerToShootEnemy = (int) 
							Math.hypot(distanceShootX, distanceShootY); 
					if(shootPlayer.getWeapon().getIndicator() == 0)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
							Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootPlayer.getX(),
											shootPlayer.getY() + 30)); ///анимация коллизии снарядов
							destroyedShootsPlayer.add(shootPlayer);
							destroyedShootsCarrierEnemyType1.add(shootCarrierEnemyType1);
							shootPlayer.setX(0); 
							shootPlayer.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 2)
					{
						if(distaceShootPlayerToShootEnemy < 20 &&
								Math.abs(distanceShootX) < 5)
						{
							shootDestroy = true;
							setAnimationDestroyShoot(
									new AnimationDestroyShoot(shootCarrierEnemyType1.getX(),
											shootCarrierEnemyType1.getY() - 45)); ///анимация коллизии снарядов
							destroyedShootsCarrierEnemyType1.add(shootCarrierEnemyType1);
							shootCarrierEnemyType1.setX(0); 
							shootCarrierEnemyType1.setY(0);
							continue;
						}
					}
					if(shootPlayer.getWeapon().getIndicator() == 3)
					{
						if(Math.abs(distanceShootY) < 20) 
						{
							destroyedShootsCarrierEnemyType1.add(shootCarrierEnemyType1);
							continue;
						}
					}
				}
			}
		}
	}
	private void processingOperations_Free_Fly_Shoots_Player()
	{
		///выстрелы игрока - снаряды не должны оставаться на поле/////
		for(Shoot shootPlayer : shootsPlayer)
		{
			shootPlayer.move();
			if(shootPlayer != null && shootPlayer.isDestroy())
			{
				destroyedShootsPlayer.add(shootPlayer);
				continue;
			}
		}
	}
	private void destroyObjects()
	{
		shootsPlayer.removeAll(destroyedShootsPlayer);
		shootsEnemyType1.removeAll(destroyedShootsEnemyType1);
		shootsEnemyType2.removeAll(destroyedShootsEnemyType2);
		shootsEnemyType3.removeAll(destroyedShootsEnemyType3);
		shootsEnemyType4.removeAll(destroyedShootsEnemyType4);
		shootsRamEnemyType1.removeAll(destroyedShootsRamEnemyType1);
		shootsCarrierEnemyType1.removeAll(destroyedShootsCarrierEnemyType1);
		
		players.removeAll(destroyedPlayer);
		
		enemiesType1.removeAll(destroyedEnemiesType1);
		enemiesType2.removeAll(destroyedEnemiesType2);
		enemiesType3.removeAll(destroyedEnemiesType3);
		enemiesType4.removeAll(destroyedEnemiesType4);
		ramEnemiesType1.removeAll(destroyedRamEnemiesType1);
		ramEnemiesType2.removeAll(destroyedRamEnemiesType2);
		ramEnemiesType3.removeAll(destroyedRamEnemiesType3);
		enemyCarrierType1.removeAll(destroyedCarrierType1);
		
		shootBonuses.removeAll(destroyedShootBonus);
		unknownBonus.removeAll(destroyedUnknownWeaponBonus);
		animationDestroyEnemyTypeX.removeAll(destroyedAnimationEnemy);
		animationDestroyShoot.removeAll(destroyedAnimationShoot);	
		healthBonuses.removeAll(destroyedHealthBonus);
		repairBonuses.removeAll(destroyedRepairBonus);
		voidHunters.removeAll(destroyedVoidHunters);
	}
	private void clearFrameAfterEndLevel_1()
	{
		enemiesType1.removeAll(enemiesType1);
		shootsEnemyType1.removeAll(shootsEnemyType1);
		shootsCarrierEnemyType1.removeAll(shootsCarrierEnemyType1);
	}
	private void animationDestroyEnemy()
	{
		for(AnimationDestroyEnemyTypeX animation : animationDestroyEnemyTypeX)
		{
			if(enemyDestroy == true)
			{
				destroyedAnimationEnemy.add(animation);
				carrierType1Destroy = false;
				continue;
			}
			if(carrierType1Destroy == true)
			{
				destroyedAnimationEnemy.add(animation);
				enemyDestroy = false;
				continue;
			}
		}
	}
	private void animationDestroyShoot()
	{
		for(AnimationDestroyShoot animation : animationDestroyShoot)
		{
			if(shootDestroy == true)
			{
				destroyedAnimationShoot.add(animation);
				shootDestroy = false;
				continue;
			}
		}
	}
	private void writeScore(int score) throws IOException
	{
		String addresFolder = "C:\\DarknessSpace\\BestScore";
		String addresFile = "C:\\DarknessSpace\\BestScore\\score.txt";
		File folder = new File(addresFolder);
		File file = new File(addresFile);
		if(folder.exists() == false)
		{
			folder.mkdirs();
		}
		if(file.exists() == false) //проверяем, что если файл не существует то создаем его
		{
			file.createNewFile();
			int myString = score; //инфа к записи
			PrintWriter out = new PrintWriter(addresFile);
			out.print(myString);
			out.close();
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
			int parseReadScore = Integer.parseInt(readScore);
			if(parseReadScore < score)
			{
				parseReadScore = score;
				PrintWriter out = new PrintWriter(addresFile);
				out.print(parseReadScore);
				out.close();
			}
		}
	}
	private void addCreatorsForLevel_1()
	{
		////CREATORS TYPE1////
		creatorEnemyType_1_Straight_50_950_Right.createEnemyType1StraightSpeed_12_Level_1();
		creatorEnemyType_1_Straight_50_950_Left.createEnemyType1StraightSpeed_10_Level_1();
		creatorEnemyType_1_Straight_350_650_Center.createEnemyType1StraightSpeed_10_Level_1();
		creatorEnemyType_1_Crossed_From_Left.createEnemyType1Fast15CrossedFromLeft_Level_1();
		creatorEnemyType_1_Crossed_From_Right.createEnemyType1Fast15CrossedFromRight_Level_1();
		creatorEnemyType_1_Diagonal_From_Left.createEnemyType1DiagonalFromLeft_Level_1();
		creatorEnemyType_1_Diagonal_From_Right.createEnemyType1DiagonalFromRight_Level_1();
		creatorEnemyType_1_Straight_50_950_Fast_20_Left.createEnemyType1Fast20Straight_Level_1();
				
		creatorEnemyType_1_Straight_50_950_Right.move50_950onX();
		creatorEnemyType_1_Straight_50_950_Left.move50_950onX();
		creatorEnemyType_1_Straight_350_650_Center.move350_650onX();
		creatorEnemyType_1_Straight_50_950_Fast_20_Left.move50_950onX();
		creatorEnemyType_1_Crossed_From_Right.move900_700onX();
		creatorEnemyType_1_Crossed_From_Left.move300_100onX();
		////CREATORS TYPE2////
		creatorEnemyType_2_Straight_50_950_Left.createEnemyType2StraightSpeed_8_Level_1();
		creatorEnemyType_2_Straight_50_950_Right.createEnemyType2StraightSpeed_6_Level_1();
		creatorEnemyType_2_Crossed_Diagonal_Right.createEnemyType2ForDiagonalMoveFromRight_Level_1();
		creatorEnemyType_2_Crossed_Diagonal_Left.createEnemyType2ForDiagonalMoveFromLeft_Level_1();
		
		creatorEnemyType_2_Straight_50_950_Left.move50_950onX();
		creatorEnemyType_2_Straight_50_950_Right.move50_950onX();
		////CREATORS TYPE3////
		creatorEnemyType_3_Straight_50_950_Left.createEnemyType3Straight_Level_1();
		creatorEnemyType_3_Crossed_From_Right.createEnemyType3CrossedFromRight_Level_1();
		creatorEnemyType_3_Crossed_From_Left.createEnemyType3CrossedFromLeft_Level_1();
		
		creatorEnemyType_3_Straight_50_950_Left.move50_950onX();
		creatorEnemyType_3_Crossed_From_Right.move900_700onX();
		creatorEnemyType_3_Crossed_From_Left.move300_100onX();
		////CREATOR RAM TYPE3 SNAKE////
		creatorRamEnemyType_3_Snake.createRamEnemyType3MoveSnake_Level_1();
		////CREATORS RAM TYPE1 RAM TYPE 2 WALL////
		creatorRamEnemyType2_50_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_100_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_150_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_200_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType1_250_Wall.createRamEnemyType1ForWall_Level_1();
		creatorRamEnemyType2_300_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_350_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_400_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_450_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType1_500_Wall.createRamEnemyType1ForWall_Level_1();
		creatorRamEnemyType2_550_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_600_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_650_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_700_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType1_750_Wall.createRamEnemyType1ForWall_Level_1();
		creatorRamEnemyType2_800_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_850_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_900_Wall.createRamEnemyType2ForWall_Level_1();
		creatorRamEnemyType2_950_Wall.createRamEnemyType2ForWall_Level_1();
		////CREATORS TYPE4////
		creatorEnemyType_4_Straight_50_950_Left.createEnemyType4StraightFromLeft_Level_1();
		creatorEnemyType_4_Route_Flight_Left.createEnemyType4RouteFlightLeft_Level_1();
		creatorEnemyType_4_Route_Flight_Right.createEnemyType4RouteFlightRight_Level_1();
		
		creatorEnemyType_4_Straight_50_950_Left.move50_950onX();
		////CREATOR UNKNOWN WEAPON////
		creatorUnknownWeaponShoot.createUnknownWeaponBonus();
		creatorUnknownWeaponShoot.move50_950onX();
		////CREATOR HEALTH BONUS////
		creatorHealthBonus.createHealthBonus();
		creatorHealthBonus.move50_950onX();
		////CRETAOR REPAIR BONUS////
		creatorRepairBonus.createRepairBonus();
		creatorRepairBonus.move50_950onX();
		////CREATOR CARRIER TYPE1////
		creatorEnemyCarrierType1.createEnemyCarrierType1_Level_1();
	}
	private void addCreatorsForLevel_2()
	{
		////CREATORS TYPE1////
		creatorEnemyType_1_Straight_50_950_Left_Level_2.createEnemyType1StraightSpeed_12_Level_2();
		creatorEnemyType_1_Straight_50_950_Right_Level_2.createEnemyType1StraightSpeed_14_Level_2();
		creatorEnemyType_1_Straight_350_650_Left_Level_2.createEnemyType1StraightSpeed_12_Level_2();
		creatorEnemyType_1_Straight_350_650_Right_Level_2.createEnemyType1StraightSpeed_12_Level_2();
		creatorEnemyType_1_Diagonal_From_Left_Level_2.createEnemyType1DiagonalFromLeft_Level_2();
		creatorEnemyType_1_Diagonal_From_Right_Level_2.createEnemyType1DiagonalFromRight_Level_2();
		creatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2.createEnemyType1Fast20Straight_Left_Level_2();
		creatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2.createEnemyType1Fast20Straight_Right_Level_2();
		creatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2.createEnemyType1Fast20Straight_Right_2_Level_2();
		
		creatorEnemyType_1_Straight_50_950_Left_Level_2.move50_950onX();
		creatorEnemyType_1_Straight_50_950_Right_Level_2.move50_950onX();
		creatorEnemyType_1_Straight_350_650_Left_Level_2.move350_650onX();
		creatorEnemyType_1_Straight_350_650_Right_Level_2.move350_650onX();
		////CREATORS TYPE2////
		creatorEnemyType_2_Straight_50_950_Left_Level_2.createEnemyType2StraightSpeed_8_Level_2();
		creatorEnemyType_2_Straight_50_950_Right_Level_2.createEnemyType2StraightSpeed_12_Level_2();
		creatorEnemyType_2_Crossed_From_Left_Level_2.createEnemyType1Fast10CrossedFromLeft_Level_2();
		creatorEnemyType_2_Crossed_From_Right_Level_2.createEnemyType1Fast10CrossedFromRight_Level_2();
		
		creatorEnemyType_2_Straight_50_950_Left_Level_2.move50_950onX();
		creatorEnemyType_2_Straight_50_950_Right_Level_2.move50_950onX();
		////CREATORS TYPE3/////
		creatorEnemyType_3_Straight_50_950_Left_Level_2.createEnemyType3Straight_Level_2();
		creatorEnemyType_3_Straight_50_950_Left_Level_2.move50_950onX();
		////CREATORS TYPE4////
		creatorEnemyType_4_Straight_50_950_Left_Level_2.createEnemyType4StraightFromLeft_Level_2();
		creatorEnemyType_4_Straight_50_950_Left_Level_2.move50_950onX();
		////CREATOR CARRIER 1////
		creatorEnemyCarrierType1_Level_2.createEnemyCarrierType1_Level_2();
		////CREATOR UNKNOWN WEAPON////
		creatorUnknownWeaponShoot.createUnknownWeaponBonusLevel2();
		creatorUnknownWeaponShoot.move50_950onX();
		////CREATOR HEALTH BONUS////
		creatorHealthBonus.createHealthBonusLevel2();
		creatorHealthBonus.move50_950onX();
		////CRETAOR REPAIR BONUS////
		creatorRepairBonus.createRepairBonusLevel2();
		creatorRepairBonus.move50_950onX();
	}
	private void setCreatorsOnGameField_Level_1()
	{
		////CREATORS TYPE1////
		setCreatorEnemyType_1_Straight_50_950_Right(new CreatorEnemyType1(950, -150, 5)); //-150
		setCreatorEnemyType_1_Straight_50_950_Left(new CreatorEnemyType1(50, -200, 8)); //-200
		setCreatorEnemyType_1_Straight_350_650_Center(new CreatorEnemyType1(660, -50, 5)); //-50
		setCreatorEnemyType_1_Crossed_From_Left(new CreatorEnemyType1(300, -100, 8));
		setCreatorEnemyType_1_Crossed_From_Right(new CreatorEnemyType1(700, -100, 8));
		setCreatorEnemyType_1_Diagonal_From_Left(new CreatorEnemyType1(0, -100, 0));
		setCreatorEnemyType_1_Straight_50_950_Fast_20_Left(new CreatorEnemyType1(50, -200, 15));
		setCreatorEnemyType_1_Diagonal_From_Right(new CreatorEnemyType1(1000, -100, 0));
		////CREATORS TYPE2////
		setCreatorEnemyType_2_Straight_50_950_Left(new CreatorEnemyType2(50, -100, 6));
		setCreatorEnemyType_2_Straight_50_950_Right(new CreatorEnemyType2(950, -200, 10));
		setCreatorEnemyType_2_Crossed_Diagonal_Right(new CreatorEnemyType2(1000, -150, 0));
		setCreatorEnemyType_2_Crossed_Diagonal_Left(new CreatorEnemyType2(0, -150, 0));
		////CREATORS TYPE3////
		setCreatorEnemyType_3_Straight_50_950_Left(new CreatorEnemyType3(50, -100, 8));
		setCreatorEnemyType_3_Crossed_From_Right(new CreatorEnemyType3(700, -150, 4));
		setCreatorEnemyType_3_Crossed_From_Left(new CreatorEnemyType3(300, -150, 4));
		////CREATOR RAM TYPE3(SNAKE)////
		setCreatorRamEnemyType_3_Snake(new CreatorRamEnemyType3(800, -100, 0));
		////CREATORS RAM TYPE1 AND RAM TYPE2 (WALL)///
		setCreatorRamEnemyType2_50_Wall(new CreatorRamEnemyType2(50, -100, 0));
		setCreatorRamEnemyType2_100_Wall(new CreatorRamEnemyType2(100, -100, 0));
		setCreatorRamEnemyType2_150_Wall(new CreatorRamEnemyType2(150, -100, 0));
		setCreatorRamEnemyType2_200_Wall(new CreatorRamEnemyType2(200, -100, 0));
		setCreatorRamEnemyType1_250_Wall(new CreatorRamEnemyType1(250, -100, 0));
		setCreatorRamEnemyType2_300_Wall(new CreatorRamEnemyType2(300, -100, 0));
		setCreatorRamEnemyType2_350_Wall(new CreatorRamEnemyType2(350, -100, 0));
		setCreatorRamEnemyType2_400_Wall(new CreatorRamEnemyType2(400, -100, 0));
		setCreatorRamEnemyType2_450_Wall(new CreatorRamEnemyType2(450, -100, 0));
		setCreatorRamEnemyType1_500_Wall(new CreatorRamEnemyType1(500, -100, 0));
		setCreatorRamEnemyType2_550_Wall(new CreatorRamEnemyType2(550, -100, 0));
		setCreatorRamEnemyType2_600_Wall(new CreatorRamEnemyType2(600, -100, 0));
		setCreatorRamEnemyType2_650_Wall(new CreatorRamEnemyType2(650, -100, 0));
		setCreatorRamEnemyType2_700_Wall(new CreatorRamEnemyType2(700, -100, 0));
		setCreatorRamEnemyType1_750_Wall(new CreatorRamEnemyType1(750, -100, 0));
		setCreatorRamEnemyType2_800_Wall(new CreatorRamEnemyType2(800, -100, 0));
		setCreatorRamEnemyType2_850_Wall(new CreatorRamEnemyType2(850, -100, 0));
		setCreatorRamEnemyType2_900_Wall(new CreatorRamEnemyType2(900, -100, 0));
		setCreatorRamEnemyType2_950_Wall(new CreatorRamEnemyType2(950, -100, 0));
		////CREATORS TYPE4////
		setCreatorEnemyType_4_Straight_50_950_Left(new CreatorEnemyType4(50, -200, 8));
		setCreatorEnemyType_4_Route_Flight_Left(new CreatorEnemyType4(-100, 300, 0));
		setCreatorEnemyType_4_Route_Flight_Right(new CreatorEnemyType4(1100, 300, 0));
		////CREATOR UNKNOWN BONUS////
		setCreatorUnknownWeaponShoot(new CreatorUnknownWeaponShoot(50, -100, 8));
		////CREATOR HEALTH BONUS////
		setCreatorHealthBonus(new CreatorHealthBonus(50, -200, 10));
		////CREATOR REPAIR BONUS////
		setCreatorRepairBonus(new CreatorRepairBonus(50, -300, 12));
		////CREATOR CARRIER TYPE1////
		setCreatorEnemyCarrierType1(new CreatorEnemyCarrierType1(200, -300, 0));
	}
	private void setCreatorsOnGameField_Level_2()
	{
		////CREATORS TYPE1////
		setCreatorEnemyType_1_Straight_50_950_Right_Level_2(new CreatorEnemyType1(950, -150, 2));
		setCreatorEnemyType_1_Straight_50_950_Left_Level_2(new CreatorEnemyType1(50, -200, 10));
		setCreatorEnemyType_1_Straight_350_650_Left_Level_2(new CreatorEnemyType1(340, -50, 4));
		setCreatorEnemyType_1_Straight_350_650_Right_Level_2(new CreatorEnemyType1(660, -50, 6));
		setCreatorEnemyType_1_Diagonal_From_Left_Level_2(new CreatorEnemyType1(0, -100, 0));
		setCreatorEnemyType_1_Diagonal_From_Right_Level_2(new CreatorEnemyType1(1000, -100, 0));
		setCreatorEnemyType_1_Straight_50_950_Fast_20_Left_Level_2(new CreatorEnemyType1(300, -100, 0));
		setCreatorEnemyType_1_Straight_50_950_Fast_20_Right_Level_2(new CreatorEnemyType1(500, -300, 0));
		setCreatorEnemyType_1_Straight_50_950_Fast_20_Right_2_Level_2(new CreatorEnemyType1(650, -500, 0));
		////CREATORS TYPE2////
		setCreatorEnemyType_2_Straight_50_950_Right_Level_2(new CreatorEnemyType2(950, -100, 2));
		setCreatorEnemyType_2_Straight_50_950_Left_Level_2(new CreatorEnemyType2(50, -200, 6));
		setCreatorEnemyType_2_Crossed_From_Left_Level_2(new CreatorEnemyType2(300, -100, 0));
		setCreatorEnemyType_2_Crossed_From_Right_Level_2(new CreatorEnemyType2(700, -100, 0));
		////CREATORS TYPE3////
		setCreatorEnemyType_3_Straight_50_950_Left_Level_2(new CreatorEnemyType3(50, -100, 6));
		////CREATORS TYPE4////
		setCreatorEnemyType_4_Straight_50_950_Left_Level_2(new CreatorEnemyType4(50, -200, 8));
		////CREATOR CARRIER TYPE1////
		setCreatorEnemyCarrierType1_Level_2(new CreatorEnemyCarrierType1(200, -300, 0));
		////CREATOR UNKNOWN BONUS////
		setCreatorUnknownWeaponShoot(new CreatorUnknownWeaponShoot(50, -100, 8));
		////CREATOR HEALTH BONUS////
		setCreatorHealthBonus(new CreatorHealthBonus(50, -200, 10));
		////CREATOR REPAIR BONUS////
		setCreatorRepairBonus(new CreatorRepairBonus(50, -300, 12));
		////CREATOR CARRIER TYPE1////
		setCreatorEnemyCarrierType1(new CreatorEnemyCarrierType1(200, -300, 0));
	}
	public void addObjects() //отвечает за добавление на поле объектов
	{
		setPlayers(new Player(startPointForPlayerX, startPointForPlayerY, armorPlayer, 8));
		setBackground(new Background(0, 0));
		for(int i = 0; i < 2000; i = (i + 50))
		{
			setStarDust(new StarDust((25 + i), 50));
			setStarDust(new StarDust((25 + i), 150));
			setStarDust(new StarDust((25 + i), 250));
			setStarDust(new StarDust((25 + i), 350));
			setStarDust(new StarDust((25 + i), 450));
			setStarDust(new StarDust((25 + i), 550));
			setStarDust(new StarDust((25 + i), 650));
			for(int j = 0; j < height; j = (j + 100))
			{
				setStarDust(new StarDust((100 + i), j));
			}	
		}
		setStatistics(new Statistics(250, 50));
		setCreatorsOnGameField_Level_1();
		setCreatorsOnGameField_Level_2();
		setCreatorEnemyCarrierType1(new CreatorEnemyCarrierType1(200, -300, 0));
	}
}
