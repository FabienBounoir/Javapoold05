//Bounoir Fabien

public abstract class SpaceMarine extends Unit{
    protected Weapon weapon;

    protected SpaceMarine(String name,int hp, int ap) {
        super(name, hp, ap);
    }

    public Weapon getWeapon()
    {
        return this.weapon;
    }

    public boolean equip(Weapon weapon)
    {
        if(!this.isAlive()) return false;  //ajout
        if(weapon.getOwer() == null)
        {
            this.weapon = weapon;
            weapon.setOwner(this);
            System.out.println(this.getName() + " has been equipped with a " + weapon.getName() + ".");
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean attack(Fighter target)
    {
        if(!this.isAlive()) return false;  //ajout
        if(this.weapon == null)
        {
            System.out.println(this.getName() + ": Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        }
        else if(this.weapon.isMelee() && this.closerUnit != target)
        {
            System.out.println(this.getName() + ": I'm too far away from " + target.getName() + ".");
            return false;
        }
        else if(this.getAp() >= this.weapon.getApcost())
        {
            this.ap -= this.weapon.getApcost();
            System.out.println(this.getName() + " attacks " + target.getName() + " with a " + this.weapon.getName() + ".");
            this.weapon.attack();
            target.receiveDamage(this.weapon.getDamage());
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void recoverAP()
    {
        if(this.isAlive())
        {
            if(this.getAp() + 9 > 50)
            {
                this.ap = 50;
            }
            else
            {
                this.ap += 9;
            }
        }
    }
    
}
