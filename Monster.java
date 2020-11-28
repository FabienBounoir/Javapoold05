//Bounoir Fabien

public abstract class Monster extends Unit {
    protected int damage = 0;
    protected int apcost = 0; 
    
    protected Monster(String name, int hp, int ap)
    {
        super(name, hp, ap);
        this.damage = damage;
        this.apcost = apcost;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public int getApcost()
    {
        return this.apcost;
    }

    public boolean equip(Weapon weapon)
    {
        if(!this.isAlive()) return false;  //ajout
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    public boolean attack(Fighter target)
    {
        if(!this.isAlive()) return false;  //ajout
        if(this.closerUnit != target)
        {
            System.out.println(this.getName() + ": I'm too far away from " + target.getName() + ".");
            return false;
        }
        else
        {
            if(this.getAp() >= this.getApcost())
            {
                this.ap -= this.getApcost();
                System.out.println(this.getName() + " attacks " + target.getName() + ".");
                target.receiveDamage(this.getDamage());
                return true;
            }
            return false;
        }
    }



}
