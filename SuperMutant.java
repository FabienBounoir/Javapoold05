//Bounoir Fabien

public class SuperMutant extends Monster {
    

    private static int monsterCount = 1;

    public SuperMutant()
    {
        super("SuperMutant #" + monsterCount, 170, 20);
        monsterCount++;
        System.out.println(this.getName() + ": Roaarrr!");
        this.damage = 60;
        this.apcost = 20;
    }

    @Override
    public void recoverAP()
    {
        if(this.getAp() + 7 > 50) this.ap = 50;
        this.ap += 7;
        if(this.getHp() + 10 > 170) this.hp = 170;
        else this.hp += 10;
    }

}
