package game.enemies;

import game.Ship;
import game.Shoot;
import game.Weapon;
import game.fields.GameField;
import game.guns.LightGrayShootForEnemy;
import game.guns.PlasmaGunForEnemy;
import game.guns.RedGunShoot;
import game.guns.ShootForCarrierType1;
import game.guns.ShootForEnemyType3;
import game.guns.ShootForRamEnemyType1;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public abstract class Enemy extends Ship
{	
	private int targetX;
	private int targetY;
	private int minDistance;
	private int armor;
	private int speed;
	private int checkChronometron; //если == 4 то снаряды замедляются, иначе, летят с обычной скоростью.
	private int checkHalfArmorCarrierType1; // аналог checkChronometron
	private int idForMove; //Специальный id, в соответствии со значением id у проотивника будет вызываться определенный метод move()
	private long lastShoot; // время последнего выстрела
	private int rateFire;  // скорострельность
	private static final int width = 20;
	private static final int height = 20;
	private GameField gameField;
	private boolean enemyCreateShoot; //индикатор выстрела противника(для анимации выстрела)
	private boolean shootEnemyType1 = false; //индикатор выстрела конкретного оружия
	private boolean shootEnemyType2 = false;
	private boolean shootEnemyType3 = false;
	private boolean shootEnemyType4 = false;
	private boolean shootRamEnemyType1 = false;
	private boolean shootCarrierEnemyType1 = false;
	private boolean tripleShootCarrierEnemyType1 = false;
	public Enemy(int x, int y, int armor, int speed, int idForMove) 
	{
		super(x, y, width, height);
		this.armor = armor;
		this.speed = speed;
		this.idForMove = idForMove;
	}
	public int getIdForMove() 
	{
		return idForMove;
	}
	public void setIdForMove(int idForMove) 
	{
		this.idForMove = idForMove;
	}
	public int getCheckChronometron() 
	{
		return checkChronometron;
	}
	public void setCheckChronometron(int checkChronometron) 
	{
		this.checkChronometron = checkChronometron;
	}
	public int getCheckHalfArmorCarrierType1() 
	{
		return checkHalfArmorCarrierType1;
	}
	public void setCheckHalfArmorCarrierType1(int checkHalfArmorCarrierType1) 
	{
		this.checkHalfArmorCarrierType1 = checkHalfArmorCarrierType1;
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
	public boolean isEnemyCreateShoot() 
	{
		return enemyCreateShoot;
	}
	public void setEnemyCreateShoot(boolean enemyCreateShoot)
	{
		this.enemyCreateShoot = enemyCreateShoot;
	}
	public boolean isShootEnemyType1() 
	{
		return shootEnemyType1;
	}
	public void setShootEnemyType1(boolean shootEnemyType1) 
	{
		this.shootEnemyType1 = shootEnemyType1;
	}
	public boolean isShootEnemyType2()
	{
		return shootEnemyType2;
	}
	public void setShootEnemyType2(boolean shootEnemyType2)
	{
		this.shootEnemyType2 = shootEnemyType2;
	}
	public boolean isShootEnemyType3() 
	{
		return shootEnemyType3;
	}
	public void setShootEnemyType3(boolean shootEnemyType3)
	{
		this.shootEnemyType3 = shootEnemyType3;
	}
	public boolean isShootEnemyType4()
	{
		return shootEnemyType4;
	}
	public void setShootEnemyType4(boolean shootEnemyType4)
	{
		this.shootEnemyType4 = shootEnemyType4;
	}
	public boolean isShootRamEnemyType1() 
	{
		return shootRamEnemyType1;
	}
	public void setShootRamEnemyType1(boolean shootRamEnemyType1) 
	{
		this.shootRamEnemyType1 = shootRamEnemyType1;
	}
	public boolean isShootCarrierEnemyType1()
	{
		return shootCarrierEnemyType1;
	}
	public void setShootCarrierEnemyType1(boolean shootCarrierEnemyType1)
	{
		this.shootCarrierEnemyType1 = shootCarrierEnemyType1;
	}
	public boolean isTripleShootCarrierEnemyType1() 
	{
		return tripleShootCarrierEnemyType1;
	}
	public void setTripleShootCarrierEnemyType1(boolean tripleShootCarrierEnemyType1)
	{
		this.tripleShootCarrierEnemyType1 = tripleShootCarrierEnemyType1;
	}
	public int getMinDistance()
	{
		return minDistance;
	}
	public void setMinDistance(int minDistance) 
	{
		this.minDistance = minDistance;
	}
	public int getTargetX() 
	{
		return targetX;
	}
	public void setTargetX(int targetX)
	{
		this.targetX = targetX;
	}
	public int getTargetY()
	{
		return targetY;
	}
	public void setTargetY(int targetY) 
	{
		this.targetY = targetY;
	}
	public void damageArmorColision()
	{
		armor -= 50;
	}
	public void damageArmor(Weapon weapon)
	{
		armor -= weapon.getDamage();
	}
	public void moveRouteFlightLeft()
	{
		int dx = getDx();
		int dy = getDy();
		dy = -speed;
		dx = speed + 2;
		if(getX() >= 200)
		{
			dy = speed;
			dx = 0;
		}
		if(getY() > 200)
		{
			dx = speed + 2;
		}
		if(getY() > 500)
		{
			dx = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveRouteFlightRight()
	{
		int dx = getDx();
		int dy = getDy();
		dy = -speed;
		dx = -speed - 2;
		if(getX() <= 800)
		{
			dy = speed;
			dx = 0;
		}
		if(getY() > 200)
		{
			dx = -speed - 2;
		}
		if(getY() > 500)
		{
			dx = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveCrossed()
	{	
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		if(getX() <= 300)
		{
			if(getY() >= 100)
			{
				dx = speed + 2;
			}
		}
		else if(getX() >= 700)
		{
			if(getY() >= 100)
			{
				dx = -speed - 2;
			}
		}
		if(getY() >= 450)
		{
			dx = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveStraight()
	{
		int dy = getDy();
		dy = speed;
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
		}
		else
		{
			setDy(dy);
		}
		super.move(1);
	}
	public void moveForCarrierType1()
	{
		int dy = getDy();
		dy = speed;
		if(getY() >= 200)
		{
			dy = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
		}
		else
		{
			setDy(dy);
		}
		super.move(1);
	}
	public void moveDiagonalFromLeft()
	{
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		dx = speed + 2;
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveDiagonalFromRight()
	{
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		dx = -speed - 2;
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveSnake()
	{
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		if(getY() >= 0)
		{
			if(getX() >= 800)
			{
				dx = -speed - 15;
			}
			if(getX() <= 200)
			{
				dx = speed + 15;
			}
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveCrossedDiagonalFromRight()
	{
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		dx = -speed - 2;
		if(getY() >= 500)
		{
			dx = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveCrossedDiagonalFromLeft()
	{
		int dx = getDx();
		int dy = getDy();
		dy = speed;
		dx = speed + 2;
		if(getY() >= 500)
		{
			dx = 0;
		}
		if(checkChronometron == 4)
		{
			setDy(dy / 2);
			setDx(dx / 2);
		}
		else
		{
			setDy(dy);
			setDx(dx);
		}
		super.move(1);
	}
	public void moveCarrierType1_200_800onX()
	{
		int dx = getDx();
		if(getX() >= getGameFild().getWidth() - 200)
		{
			dx = -speed;
		}
		if(getX() <= 200)
		{
			dx = speed;
		}
		setDx(dx);
		super.move(1);
	}
	public Shoot createShootEnemyType1() 
	{
		shootEnemyType1 = true;
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		Shoot shoot = new LightGrayShootForEnemy(getX(), getY());
		if(checkChronometron == 4)
		{
			shoot.setDy((speed + 5) / 2);
			rateFire = shoot.getWeapon().getRateFire() * 2;
		}
		else
		{
			shoot.setDy(speed + 5);
			rateFire = shoot.getWeapon().getRateFire();
		}
		return shoot;
	}
	public List<Shoot> createShootEnemyType2() 
	{
		shootEnemyType2 = true;
		if (lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		////первый выстрел/////////////////
		Shoot shoot1 = new RedGunShoot(getX() - 22, getY() - 44);
		if(checkChronometron == 4)
		{
			shoot1.setDy((speed + 5) / 2);
			rateFire = shoot1.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot1.setDy(speed + 5);
			rateFire = shoot1.getWeapon().getRateFire(); 
		}
		shoots.add(shoot1);
		////второй выстрел/////////////////
		Shoot shoot2 = new RedGunShoot(getX() + 18, getY() - 44);
		if(checkChronometron == 4)
		{
			shoot2.setDy((speed + 5) / 2);
			rateFire = shoot1.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot2.setDy(speed + 5);
			rateFire = shoot1.getWeapon().getRateFire(); 
		}
		shoots.add(shoot2);
		return shoots;
	}
	public Shoot createShootEnemyType3() 
	{
		shootEnemyType3 = true;
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		Shoot shoot = new ShootForEnemyType3(getX() + 2, getY());
		if(checkChronometron == 4)
		{
			shoot.setDy((speed + 5) / 2);
			rateFire = shoot.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot.setDy(speed + 5);
			rateFire = shoot.getWeapon().getRateFire(); 
		}
		return shoot;
	}
	public Shoot createShootEnemyType4() 
	{
		shootEnemyType4 = true;
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		Shoot shoot = new PlasmaGunForEnemy(getX(), getY());
		if(checkChronometron == 4)
		{
			shoot.setDy((speed + 5) / 2);
			rateFire = shoot.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot.setDy(speed + 5);
			rateFire = shoot.getWeapon().getRateFire(); 
		}
		return shoot;
	}
	public Shoot createShootRamEnemyType1() 
	{
		shootRamEnemyType1 = true;
		if(lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		Shoot shoot = new ShootForRamEnemyType1(getX(), getY());
		if(checkChronometron == 4)
		{
			shoot.setDy((speed + 5) / 2);
			rateFire = shoot.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot.setDy(speed + 5);
			rateFire = shoot.getWeapon().getRateFire(); 
		}
		return shoot;
	}
	public List<Shoot> createShootCarrierEnemyType1()
	{
		shootCarrierEnemyType1 = true;
		if (lastShoot + rateFire > System.currentTimeMillis()) 
		{
			return null;
		}
		enemyCreateShoot = true;
		lastShoot  = System.currentTimeMillis();
		List<Shoot> shoots = new LinkedList<Shoot>();
		////первый выстрел/////////////////
		Shoot shoot1 = new ShootForCarrierType1(getX() - 100, getY() - 54);
		if(checkChronometron == 4)
		{
			shoot1.setDy((speed + 7) / 2);
			rateFire = shoot1.getWeapon().getRateFire() * 2;
		}
		else
		{
			shoot1.setDy(speed + 7);
			rateFire = shoot1.getWeapon().getRateFire();
		}
		shoots.add(shoot1);
		////второй выстрел/////////////////
		Shoot shoot2 = new ShootForCarrierType1(getX() + 100, getY() - 54);
		if(checkChronometron == 4)
		{
			shoot2.setDy((speed + 7) / 2);
			rateFire = shoot2.getWeapon().getRateFire() * 2; 
		}
		else
		{
			shoot2.setDy(speed + 7);
			rateFire = shoot2.getWeapon().getRateFire(); 
		}
		shoots.add(shoot2);
		Shoot shoot3 = new ShootForCarrierType1(getX(), getY());
		if(checkHalfArmorCarrierType1 == 4)
		{
			if(checkChronometron == 4)
			{
				shoot3.setDy((speed + 7) / 2);
				rateFire = shoot3.getWeapon().getRateFire() * 2; 
			}
			else
			{
				shoot3.setDy(speed + 7);
				rateFire = shoot3.getWeapon().getRateFire(); 
			}
			shoots.add(shoot3);
		}
		return shoots;
	}
	public abstract void paintEnemy(Graphics g);
}