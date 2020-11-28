//Bounoir Fabien

import javax.swing.text.StyledEditorKit;

public class AssaultTerminator extends SpaceMarine{
    
    public AssaultTerminator(String name)
    {
        super(name, 150, 30);
        System.out.println(this.getName() + " has teleported from space.");
        this.equip(new PowerFist());
    }

    @Override
    public void receiveDamage(int damage)
    {
        if(this.isAlive())
            this.hp -=(damage - 3 >= 1 ? damage -  3 : 1);
        if(this.hp < 0) this.hp = 0;
    }

}
