//Bounoir Fabien

public class TacticalMarine extends SpaceMarine{
    public TacticalMarine(String name)
    {
        super(name, 100, 20);
        System.out.println(this.getName() + " on duty.");
        this.equip(new PlasmaRifle());
    }

    @Override
    public void recoverAP()
    {
        if(this.isAlive())
        {
            if(this.getAp() + 12 > 50) this.ap = 50;
            else this.ap +=12;
        }
    }
}
