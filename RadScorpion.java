//Bounoir Fabien

public class RadScorpion extends Monster {
    
    private static int monsterCount = 1;

    public RadScorpion()
    {
        super("RadScorpion #" + monsterCount, 80, 50);
        monsterCount++;
        this.damage = 25;
        this.apcost = 8;
        System.out.println(this.getName() + ": Crrr!");
    }

    @Override
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
                if(!(target instanceof AssaultTerminator) && (target instanceof SpaceMarine)) target.receiveDamage(this.getDamage() * 2);
                else target.receiveDamage(this.getDamage());
                return true;
            }
            return false;
        }
    }
}
