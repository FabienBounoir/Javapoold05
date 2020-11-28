//Bounoir Fabien

public interface Fighter{

    public boolean equip(Weapon weapon);
    public boolean attack(Fighter unit);
    public void receiveDamage(int damage);
    public boolean moveCloseTo(Fighter unit);
    public void recoverAP();
    public String getName();
    public int getAp();
    public int getHp();

}