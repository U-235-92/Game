package game;

import game.fields.GameField;
import game.guns.DualGreenShoot;
import game.guns.GreenGunShoot;
import game.guns.Machinegun;
import game.guns.PlasmaGun;
import game.guns.ShootForTripleShoot;
import game.guns.UnknownWeapon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.util.LinkedList;
import java.util.List;

public class Player extends Ship
{
	private int armor;
	private int speed;
	private static final int width = 30;
	private static final int height = 55;
	private long lastShoot; // время последнего выстрела
	private int rateFire; // скорострельность
	private boolean plasmaGun;
	private boolean unknownWeapon;
	private GameField gameField;
	private boolean shotGreenShoot;
	private boolean shotTripleShoot;
	private boolean shotRedShoot;
	private boolean shotPlasmagun;
	private boolean shotUnknown;
	private boolean shotMashinegun;
	private boolean shotDualGreenShoot;
	
	public Player(int x, int y, int armor, int speed) 
	{
		super(x, y, width, height);
		this.armor = armor;
		this.speed = speed;
	}
	public int getArmor() 
	{
		return armor;
	}
	public void setArmor(int armor) 
	{
		this.armor = armor;
	}
	public int getSpeed() 
	{
		return speed;
	}
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	public GameField getGameFild() 
	{
		return gameField;
	}
	public void setGameFild(GameField gameField) 
	{
		this.gameField = gameField;
	}
	public boolean isPlasmaGun() 
	{
		return plasmaGun;
	}
	public boolean isUnknownWeapon()
	{
		return unknownWeapon;
	}
	public boolean isShotGreenShoot()
	{
		return shotGreenShoot;
	}
	public void setShotGreenShoot(boolean shotGreenShoot) 
	{
		this.shotGreenShoot = shotGreenShoot;
	}
	public boolean isShotTripleShoot() 
	{
		return shotTripleShoot;
	}
	public void setShotTripleShoot(boolean shotTripleShoot) 
	{
		this.shotTripleShoot = shotTripleShoot;
	}
	public boolean isShotRedShoot() 
	{
		return shotRedShoot;
	}
	public void setShotRedShoot(boolean shotRedShoot) 
	{
		this.shotRedShoot = shotRedShoot;
	}
	public void setPlasmaGun(boolean plasmaGun)
	{
		this.plasmaGun = plasmaGun;
	}
	public boolean isShotUnknown() 
	{
		return shotUnknown;
	}
	public void setShotUnknown(boolean shotUnknown)
	{
		this.shotUnknown = shotUnknown;
	}
	public boolean isShotMashinegun() 
	{
		return shotMashinegun;
	}
	public void setShotMashinegun(boolean shotMashinegun)
	{
		this.shotMashinegun = shotMashinegun;
	}
	public boolean isShotDualGreenShoot()
	{
		return shotDualGreenShoot;
	}
	public void setShotDualGreenShoot(boolean shotDualGreenShoot)
	{
		this.shotDualGreenShoot = shotDualGreenShoot;
	}
	public void damageArmor(Weapon weapon)
	{
		armor -= weapon.getDamage();
	}
	public void damageArmorEnemyType1(Weapon weapon)
	{
		if(getGameFild().getEnemiesType1().size() > 0)
		{
			armor -= (int) (weapon.getDamage() / getGameFild().getEnemiesType1().size());
		}
		else if(getGameFild().getEnemiesType1().size() <= 0)
		{
			armor -= weapon.getDamage();
		}
	}
	public void damageArmorEnemyType2(Weapon weapon)
	{
		if(getGameFild().getEnemiesType2().size() > 0)
		{
			armor -= weapon.getDamage() / getGameFild().getEnemiesType2().size();
		}
		else if(getGameFild().getEnemiesType2().size() <= 0)
		{
			armor -= weapon.getDamage();
		}
	}
	public void damageArmorEnemyType3(Weapon weapon)
	{
		if(getGameFild().getEnemiesType3().size() > 0)
		{
			armor -= weapon.getDamage() / getGameFild().getEnemiesType3().size();
		}
		else if(getGameFild().getEnemiesType3().size() <= 0)
		{
			armor -= weapon.getDamage();
		}
	}
	public void damageArmorEnemyType4(Weapon weapon)
	{
		if(getGameFild().getEnemiesType4().size() > 0)
		{
			armor -= weapon.getDamage() / getGameFild().getEnemiesType4().size();
		}
		else if(getGameFild().getEnemiesType4().size() <= 0)
		{
			armor -= weapon.getDamage();
		}
	}
	public void damageArmorRamEnemyType1(Weapon weapon)
	{
		if(getGameFild().getRamEnemiesType1().size() > 0)
		{
			armor -= weapon.getDamage() / getGameFild().getRamEnemiesType1().size();
		}
		else if(getGameFild().getRamEnemiesType1().size() <= 0)
		{
			armor -= weapon.getDamage();
		}
	}
	public void up()
	{
		int dy = getDy();
		dy = -speed;
		setDy(dy);
	}
	public void down()
	{
		int dy = getDy();
		dy = speed;
		setDy(dy);
	}
	public void right()
	{
		int dx = getDx();
		dx = speed;
		setDx(dx);
	}
	public void left()
	{
		int dx = getDx();
		dx = -speed;
		setDx(dx);
	}
	public void stop()
	{
		setDx(0);
		setDy(0);
	}
	public void movePlayerAfterCarrierDestroy()
	{
		int dy = getDy();
		dy = -speed;
		setDy(dy);
		super.move(1);
	}
	public void stopPlayerAfterEndGame()
	{
		setDx(0);
		setDy(0);
		super.move(0);
	}
	public List<Shoot> createGreenShoot() 
	{
		shotGreenShoot = true; // это для анимации стрельбы (ну, пламя, типа)
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		Shoot shoot = new GreenGunShoot(getX(), getY());
		shoot.setDy(-speed - 15); //-5
		rateFire = shoot.getWeapon().getRateFire(); 
		shoots.add(shoot);
		return shoots;
	}
	public List<Shoot> createDualGreenShoot() 
	{
		shotDualGreenShoot = true; // это для анимации стрельбы (ну, пламя, типа)
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		//первый выстрел///
		Shoot shoot1 = new DualGreenShoot(getX() - 7, getY());
		shoot1.setDy(-speed - 15);
		rateFire = shoot1.getWeapon().getRateFire();
		shoots.add(shoot1); 
		//второй выстрел///
		Shoot shoot2 = new DualGreenShoot(getX() + 5, getY());
		shoot2.setDy(-speed - 15);
		rateFire = shoot2.getWeapon().getRateFire();
		shoots.add(shoot2);
		return shoots;
	}
	public List<Shoot> createPlasmaGunShoot() 
	{
		plasmaGun = true; // это нужно для счетчка жизни PlasmaGun (НЕ МЕНЯТЬ!)
		shotPlasmagun = true; // это для анимации стрельбы (ну, пламя, типа)
		if (lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		Shoot shoot = new PlasmaGun(getX(), getY());
		shoot.setDy(-speed - 15);
		rateFire = shoot.getWeapon().getRateFire(); 
		shoots.add(shoot);
		return shoots;
	}
	public List<Shoot> createUnknownWeaponShoot() 
	{
		unknownWeapon = true; // пока не понял зачем, возможно - это мусор.
		shotUnknown = true; // это для анимации стрельбы (ну, пламя, типа)
		if (lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		Shoot shoot = new UnknownWeapon(getX(), getY());
		shoot.setDy(-speed - 1);
		rateFire = shoot.getWeapon().getRateFire(); 
		shoots.add(shoot);
		shotUnknown = true;
		return shoots;
	}
	public List<Shoot> createTripleShoot()
	{
		shotTripleShoot = true; // это для анимации стрельбы (ну, пламя, типа)
		if (lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		//первый выстрел///
		Shoot shoot1 = new ShootForTripleShoot(getX(), getY());
		shoot1.setDy(-speed - 10);
		shoot1.setDx((int) speed / 2 - 6); //
		rateFire = shoot1.getWeapon().getRateFire();
		shoots.add(shoot1); 
		//второй выстрел///
		Shoot shoot2 = new ShootForTripleShoot(getX(), getY());
		shoot2.setDy(-speed - 10);
		rateFire = shoot2.getWeapon().getRateFire();
		shoots.add(shoot2);
		//третий выстрел///
		Shoot shoot3 = new ShootForTripleShoot(getX(), getY());
		shoot3.setDy(-speed - 10);
		shoot3.setDx((int) -speed / 2 + 6); //
		rateFire = shoot3.getWeapon().getRateFire();
		shoots.add(shoot3);
		shotTripleShoot = true;
		return shoots;
	}
	public List<Shoot> createMashinegunShoot()
	{
		shotMashinegun = true; // это для анимации стрельбы (ну, пламя, типа)
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			getGameFild().setFlag(false);
			return null;
		}
		getGameFild().setFlag(true);
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		//первый выстрел///
		Shoot shoot1 = new Machinegun(getX() - 16, getY() + 40);
		shoot1.setDy(-speed - 15);
		rateFire = shoot1.getWeapon().getRateFire();
		shoots.add(shoot1); 
		//второй выстрел///
		Shoot shoot2 = new Machinegun(getX() + 16, getY() + 40);
		shoot2.setDy(-speed - 15);
		rateFire = shoot2.getWeapon().getRateFire();
		shoots.add(shoot2);
		shotMashinegun = true;
		return shoots;
	}
	public void paintPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
		g2d.setPaint(Color.BLACK);
		GeneralPath playerShip = new GeneralPath();
		playerShip.moveTo(getX(), getY());
		playerShip.lineTo(getX() + 3, getY() + 15);
		playerShip.lineTo(getX() + 3, getY() + 20);
		playerShip.lineTo(getX() + 8, getY() + 22);
		playerShip.lineTo(getX() + 13, getY() + 32);
		playerShip.lineTo(getX() + 30, getY() + 40);
		playerShip.lineTo(getX() + 29, getY() + 44);
		playerShip.lineTo(getX() + 12, getY() + 41);
		playerShip.lineTo(getX() + 10, getY() + 48);
		playerShip.lineTo(getX() + 6, getY() + 48);
		playerShip.lineTo(getX() + 4, getY() + 42);
		playerShip.lineTo(getX() + 3, getY() + 42);
		playerShip.lineTo(getX() + 2, getY() + 50);
		playerShip.lineTo(getX() + 1, getY() + 54);
		
		playerShip.lineTo(getX() - 1, getY() + 54);
		playerShip.lineTo(getX() - 2, getY() + 50);
		playerShip.lineTo(getX() - 3, getY() + 42);
		playerShip.lineTo(getX() - 4, getY() + 42);
		playerShip.lineTo(getX() - 6, getY() + 48);
		playerShip.lineTo(getX() - 10, getY() + 48);
		playerShip.lineTo(getX() - 12, getY() + 41);
		playerShip.lineTo(getX() - 29, getY() + 44);
		playerShip.lineTo(getX() - 30, getY() + 40);
		playerShip.lineTo(getX() - 13, getY() + 32);
		playerShip.lineTo(getX() - 8, getY() + 22);
		playerShip.lineTo(getX() - 3, getY() + 20);
		playerShip.lineTo(getX() - 3, getY() + 15);
		playerShip.lineTo(getX(), getY());
		g2d.fill(playerShip);
		g.setColor(Color.WHITE);
		/////конус/////////////////////
		g.drawLine(getX(), getY(), getX() + 3, getY() + 15);
		g.drawLine(getX(), getY(), getX() - 3, getY() + 15);
		/////корпус////////////////////
		g.drawLine(getX() + 3, getY() + 15, getX() + 3, getY() + 20);
		g.drawLine(getX() - 3, getY() + 15, getX() - 3, getY() + 20);
		////воздухозаборник////////////
		g.drawLine(getX() + 3, getY() + 20, getX() + 8, getY() + 22);
		g.drawLine(getX() - 3, getY() + 20, getX() - 8, getY() + 22);
		////центроплан/////////////////
		g.drawLine(getX() + 8, getY() + 22, getX() + 13, getY() + 32);
		g.drawLine(getX() - 8, getY() + 22, getX() - 13, getY() + 32);
		////крылья/////////////////////
		g.drawLine(getX() + 13, getY() + 32, getX() + 30, getY() + 40);
		g.drawLine(getX() - 13, getY() + 32, getX() - 30, getY() + 40);
		g.drawLine(getX() + 30, getY() + 40, getX() + 29, getY() + 44);
		g.drawLine(getX() - 30, getY() + 40, getX() - 29, getY() + 44);
		g.drawLine(getX() + 29, getY() + 44, getX() + 12, getY() + 41);
		g.drawLine(getX() - 29, getY() + 44, getX() - 12, getY() + 41);
		////двигатели//////////////////
		g.drawLine(getX() + 12, getY() + 41, getX() + 10, getY() + 48);
		g.drawLine(getX() - 12, getY() + 41, getX() - 10, getY() + 48);
		g.drawLine(getX() + 10, getY() + 48, getX() + 6, getY() + 48);
		g.drawLine(getX() - 10, getY() + 48, getX() - 6, getY() + 48);
		g.drawLine(getX() + 6, getY() + 48, getX() + 4, getY() + 42);
		g.drawLine(getX() - 6, getY() + 48, getX() - 4, getY() + 42);
		////хвост//////////////////////
		g.drawLine(getX() + 4, getY() + 42, getX() + 3, getY() + 42);
		g.drawLine(getX() - 4, getY() + 42, getX() - 3, getY() + 42);
		g.drawLine(getX() + 3, getY() + 42, getX() + 2, getY() + 50);
		g.drawLine(getX() - 3, getY() + 42, getX() - 2, getY() + 50);
		g.drawLine(getX() + 2, getY() + 50, getX() + 1, getY() + 54);
		g.drawLine(getX() - 2, getY() + 50, getX() - 1, getY() + 54);
		g.drawLine(getX() + 1, getY() + 54, getX(), getY() + 54);
		////выделение фюзеляжа/////////
		g.drawLine(getX() + 3, getY() + 20, getX() + 2, getY() + 42);
		g.drawLine(getX() - 3, getY() + 20, getX() - 2, getY() + 42);
		////от центроплана к движкам///
		g.drawLine(getX() + 13, getY() + 32, getX() + 12, getY() + 41);
		g.drawLine(getX() - 13, getY() + 32, getX() - 12, getY() + 41);
		////выделение сопел////////////
		g.drawLine(getX() + 10, getY() + 41, getX() + 10, getY() + 48);
		g.drawLine(getX() - 10, getY() + 41, getX() - 10, getY() + 48);
		g.drawLine(getX() + 8, getY() + 41, getX() + 8, getY() + 48);
		g.drawLine(getX() - 8, getY() + 41, getX() - 8, getY() + 48);
		g.drawLine(getX() + 6, getY() + 41, getX() + 6, getY() + 48);
		g.drawLine(getX() - 6, getY() + 41, getX() - 6, getY() + 48);
		g.drawLine(getX() + 10, getY() + 41, getX() + 6, getY() + 41);
		g.drawLine(getX() - 10, getY() + 41, getX() - 6, getY() + 41);
	}
	public void paintShield(Graphics g)
	{
		g.setColor(Color.PINK);
		g.drawOval(getX() - 35, getY() + 0, 70, 70);
	}
	public void paintFlameFromEngine1(Graphics g)
	{
		///пламя из правого двигателя////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 10, getY() + 50, getX() + 12, getY() + 56);
		g.drawLine(getX() + 6, getY() + 50, getX() + 4, getY() + 56);
		g.setColor(Color.RED);
		g.drawLine(getX() + 8, getY() + 50, getX() + 8, getY() + 62);
		g.drawLine(getX() + 9, getY() + 50, getX() + 9, getY() + 62);
		///пламя из левого двигателя////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 10, getY() + 50, getX() - 12, getY() + 56);
		g.drawLine(getX() - 6, getY() + 50, getX() - 4, getY() + 56);
		g.setColor(Color.RED);
		g.drawLine(getX() - 8, getY() + 50, getX() - 8, getY() + 62);
		g.drawLine(getX() - 9, getY() + 50, getX() - 9, getY() + 62);
		///пламя из правого двигателя////
		g.setColor(Color.RED);
		g.drawLine(getX() + 11, getY() + 50, getX() + 12, getY() + 56);
		g.drawLine(getX() + 5, getY() + 50, getX() + 4, getY() + 56);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 7, getY() + 50, getX() + 6, getY() + 59);
		g.drawLine(getX() + 9, getY() + 50, getX() + 10, getY() + 59);
		///пламя из левого двигателя////
		g.setColor(Color.RED);
		g.drawLine(getX() - 11, getY() + 50, getX() - 12, getY() + 56);
		g.drawLine(getX() - 5, getY() + 50, getX() - 4, getY() + 56);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 7, getY() + 50, getX() - 6, getY() + 59);
		g.drawLine(getX() - 9, getY() + 50, getX() - 10, getY() + 59);
	}
	public void paintFlameFromEngine2(Graphics g)
	{
		///пламя из правого двигателя////
		g.setColor(Color.RED);
		g.drawLine(getX() + 10, getY() + 50, getX() + 12, getY() + 56);
		g.drawLine(getX() + 6, getY() + 50, getX() + 4, getY() + 56);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 8, getY() + 50, getX() + 8, getY() + 62);
		g.drawLine(getX() + 9, getY() + 50, getX() + 9, getY() + 62);
		///пламя из левого двигателя////
		g.setColor(Color.RED);
		g.drawLine(getX() - 10, getY() + 50, getX() - 12, getY() + 56);
		g.drawLine(getX() - 6, getY() + 50, getX() - 4, getY() + 56);
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 8, getY() + 50, getX() - 8, getY() + 62);
		g.drawLine(getX() - 9, getY() + 50, getX() - 9, getY() + 62);
		///пламя из правого двигателя////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() + 11, getY() + 50, getX() + 12, getY() + 56);
		g.drawLine(getX() + 5, getY() + 50, getX() + 4, getY() + 56);
		g.setColor(Color.RED);
		g.drawLine(getX() + 7, getY() + 50, getX() + 6, getY() + 59);
		g.drawLine(getX() + 9, getY() + 50, getX() + 10, getY() + 59);
		///пламя из левого двигателя////
		g.setColor(Color.ORANGE);
		g.drawLine(getX() - 11, getY() + 50, getX() - 12, getY() + 56);
		g.drawLine(getX() - 5, getY() + 50, getX() - 4, getY() + 56);
		g.setColor(Color.RED);
		g.drawLine(getX() - 7, getY() + 50, getX() - 6, getY() + 59);
		g.drawLine(getX() - 9, getY() + 50, getX() - 10, getY() + 59);
	}
	public void paintFlameFromEngine3(Graphics g)
	{
		///пламя из правого двигателя////
		g.setColor(Color.YELLOW);
		g.drawLine(getX() + 10, getY() + 50, getX() + 8, getY() + 54);
		g.drawLine(getX() + 6, getY() + 50, getX() + 8, getY() + 54);
		g.drawLine(getX() + 6, getY() + 50, getX() + 8, getY() + 50);
		g.drawLine(getX() + 6, getY() + 51, getX() + 8, getY() + 51);
		g.drawLine(getX() + 7, getY() + 52, getX() + 8, getY() + 52);
		///пламя из левого двигателя////
		g.drawLine(getX() - 10, getY() + 50, getX() - 8, getY() + 54);
		g.drawLine(getX() - 6, getY() + 50, getX() - 8, getY() + 54);
		g.drawLine(getX() - 6, getY() + 50, getX() - 8, getY() + 50);
		g.drawLine(getX() - 6, getY() + 51, getX() - 8, getY() + 51);
		g.drawLine(getX() - 7, getY() + 52, getX() - 8, getY() + 52);
	}
	public void paintAnimationGreenShoot(Graphics g)
	{	
		if(shotGreenShoot == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.GREEN);
			g.drawLine(getX() + 2, getY() - 5, getX() + 8, getY() - 16);
			g.drawLine(getX() - 2, getY() - 5, getX() - 8, getY() - 16);
			g.drawLine(getX() + 1, getY() - 5, getX() + 4, getY() - 18);
			g.drawLine(getX() - 1, getY() - 5, getX() - 4, getY() - 18);
			g.drawLine(getX() + 1, getY() - 5, getX() + 10, getY() - 10);
			g.drawLine(getX() - 1, getY() - 5, getX() - 10, getY() - 10);
		}
	}
	public void paintAnimationRedShoot(Graphics g)
	{	
		if(shotRedShoot == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.RED);
			g.drawLine(getX() + 3, getY() - 3, getX() + 14, getY() + 0);
			g.drawLine(getX() - 3, getY() - 3, getX() - 14, getY() + 0);
			g.drawLine(getX() + 3, getY() - 3, getX() + 12, getY() - 5);
			g.drawLine(getX() - 3, getY() - 3, getX() - 12, getY() - 5);
			g.drawLine(getX() + 3, getY() - 4, getX() + 9, getY() - 9);
			g.drawLine(getX() - 3, getY() - 4, getX() - 9, getY() - 9);
		}
	}
	public void paintAnimationTripleShoot(Graphics g)
	{	
		if(shotTripleShoot == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.RED);
			g.drawLine(getX() + 3, getY() - 3, getX() + 14, getY() + 0);
			g.drawLine(getX() - 3, getY() - 3, getX() - 14, getY() + 0);
			g.drawLine(getX() + 3, getY() - 3, getX() + 12, getY() - 5);
			g.drawLine(getX() - 3, getY() - 3, getX() - 12, getY() - 5);
			g.drawLine(getX() + 3, getY() - 4, getX() + 9, getY() - 9);
			g.drawLine(getX() - 3, getY() - 4, getX() - 9, getY() - 9);
		}
	}
	public void paintAnimationUnknownShoot(Graphics g)
	{	
		if(shotUnknown == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.GRAY);
			g.drawLine(getX() + 15, getY() - 3, getX() - 15, getY() - 3);
			g.drawLine(getX() + 25, getY() - 6, getX() - 25, getY() - 6);
			g.drawLine(getX() + 40, getY() - 9, getX() - 40, getY() - 9);
			g.drawLine(getX() + 1, getY() - 3, getX() - 7, getY() - 10);
			g.drawLine(getX() - 1, getY() - 3, getX() + 7, getY() - 10);
		}
	}
	public void paintAnimationMashinegunShoot(Graphics g)
	{	
		if(shotMashinegun == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.ORANGE);
			g.drawLine(getX() + 16, getY() + 30, getX() + 18, getY() + 16);
			g.drawLine(getX() - 16, getY() + 30, getX() - 18, getY() + 16);
			g.drawLine(getX() + 14, getY() + 30, getX() + 12, getY() + 16);
			g.drawLine(getX() - 14, getY() + 30, getX() - 12, getY() + 16);
			
			g.drawLine(getX() + 16, getY() + 30, getX() + 20, getY() + 22);
			g.drawLine(getX() - 16, getY() + 30, getX() - 20, getY() + 22);
			g.drawLine(getX() + 14, getY() + 30, getX() + 10, getY() + 22);
			g.drawLine(getX() - 14, getY() + 30, getX() - 10, getY() + 22);
		}
	}
	public void paintAnimationPlasmaGunShoot(Graphics g)
	{	
		if(shotPlasmagun == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.MAGENTA);
			g.drawLine(getX() + 3, getY() - 3, getX() + 14, getY() + 0);
			g.drawLine(getX() - 3, getY() - 3, getX() - 14, getY() + 0);
			g.drawLine(getX() + 3, getY() - 3, getX() + 12, getY() - 5);
			g.drawLine(getX() - 3, getY() - 3, getX() - 12, getY() - 5);
			g.drawLine(getX() + 3, getY() - 4, getX() + 9, getY() - 9);
			g.drawLine(getX() - 3, getY() - 4, getX() - 9, getY() - 9);
		}
	}
	public void paintAnimationDualGreenShoot(Graphics g)
	{	
		if(shotDualGreenShoot == true && getGameFild().isFlag() == true)
		{
			g.setColor(Color.CYAN);
			g.drawLine(getX() + 3, getY() - 3, getX() + 14, getY() + 0);
			g.drawLine(getX() - 3, getY() - 3, getX() - 14, getY() + 0);
			g.drawLine(getX() + 3, getY() - 3, getX() + 12, getY() - 5);
			g.drawLine(getX() - 3, getY() - 3, getX() - 12, getY() - 5);
			g.drawLine(getX() + 3, getY() - 4, getX() + 9, getY() - 9);
			g.drawLine(getX() - 3, getY() - 4, getX() - 9, getY() - 9);
		}
	}
	public void paintFlashBeaconAnimation(final Graphics g)
	{
		g.setColor(Color.RED);
		////right////
		g.drawLine(getX() + 30, getY() + 40, getX() + 30, getY() + 38);
		g.drawLine(getX() + 30, getY() + 40, getX() + 30, getY() + 42);
		
		g.drawLine(getX() + 30, getY() + 40, getX() + 28, getY() + 40);
		g.drawLine(getX() + 30, getY() + 40, getX() + 32, getY() + 40);
		
		g.drawLine(getX() + 30, getY() + 40, getX() + 28, getY() + 42);
		g.drawLine(getX() + 30, getY() + 40, getX() + 32, getY() + 42);
		
		g.drawLine(getX() + 30, getY() + 40, getX() + 28, getY() + 38);
		g.drawLine(getX() + 30, getY() + 40, getX() + 32, getY() + 38);
		////left////
		g.drawLine(getX() - 30, getY() + 40, getX() - 30, getY() + 38);
		g.drawLine(getX() - 30, getY() + 40, getX() - 30, getY() + 42);
		
		g.drawLine(getX() - 30, getY() + 40, getX() - 28, getY() + 40);
		g.drawLine(getX() - 30, getY() + 40, getX() - 32, getY() + 40);
		
		g.drawLine(getX() - 30, getY() + 40, getX() - 28, getY() + 42);
		g.drawLine(getX() - 30, getY() + 40, getX() - 32, getY() + 42);
		
		g.drawLine(getX() - 30, getY() + 40, getX() - 28, getY() + 38);
		g.drawLine(getX() - 30, getY() + 40, getX() - 32, getY() + 38);
		////center////
		g.drawLine(getX(), getY() + 20, getX(), getY() + 18);
		g.drawLine(getX(), getY() + 20, getX(), getY() + 22);
			
		g.drawLine(getX(), getY() + 20, getX() - 2, getY() + 20);
		g.drawLine(getX(), getY() + 20, getX() + 2, getY() + 20);
			
		g.drawLine(getX(), getY() + 20, getX() - 2, getY() + 22);
		g.drawLine(getX(), getY() + 20, getX() + 2, getY() + 22);
			
		g.drawLine(getX(), getY() + 20, getX() - 2, getY() + 18);
		g.drawLine(getX(), getY() + 20, getX() + 2, getY() + 18);
	}
}