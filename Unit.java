//Bounoir Fabien

public abstract class Unit implements Fighter {
    
    protected String name;
    protected int hp;
    protected int ap;
    protected Fighter closerUnit;

    protected Unit(String name, int hp, int ap)
    {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    public String getName()
    {
        return this.name;
    }

    public int getHp()
    {
        return this.hp;
    }

    public int getAp()
    {
        return this.ap;
    }

    public void receiveDamage(int damage)
    {
        if(this.isAlive())
            this.hp -= damage;
        if(this.hp < 0) this.hp = 0;
    }

    public boolean moveCloseTo(Fighter unit)
    {
        if(!this.isAlive()) return false; //ajout
        if(unit == this.closerUnit || this == unit) return false;
        else{
            this.closerUnit = unit;
            System.out.println(this.getName() + " is moving closer to " + unit.getName() + ".");
            return true;
        }
    }

    public void recoverAP()
    {
        if(this.getAp() + 7 > 50) this.ap = 50;
        else this.ap += 7;
    }

    public boolean isAlive()
    {
        return (this.getHp() > 0);
    }

}
