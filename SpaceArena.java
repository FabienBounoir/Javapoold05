//Bounoir Fabien

import java.util.ArrayList;
import java.util.List;

public class SpaceArena {
    private List<SpaceMarine> spaceMarines = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private boolean isFightStarted = false;
    private Monster currentMonster;
    private SpaceMarine currentSpaceMarine;


    public SpaceArena() {};

    public void enlistMonsters(List<Monster> monstersToAdd)
    {
        if(!isFightStarted)
        {
            for(Monster monster : monstersToAdd)
            {
                monsters.add(monster);
            }
        }
    }

    public void enlistSpaceMarines(List<SpaceMarine> marinesToAdd)
    {
        if(!isFightStarted)
        {
            for(SpaceMarine marine : marinesToAdd)
            {
                spaceMarines.add(marine);
            }
        }
    }

    public boolean fight()
    {
        if(monsters.size() == 0)
        {
            System.out.println("No monsters available to fight.");
            return false;
        }
        else if(spaceMarines.size() == 0)
        {
            System.out.println("Those cowards ran away.");
            return false;
        }

        if(this.currentSpaceMarine == null)
        {
            this.currentSpaceMarine = this.spaceMarines.get(0);
            System.out.println(this.currentSpaceMarine.getName() + " has entered the arena.");
        }

        if(this.currentMonster == null)
        {
            this.currentMonster = this.monsters.get(0);
            System.out.println(this.currentMonster.getName() + " has entered the arena.");
        }


        this.currentSpaceMarine = this.spaceMarines.get(0);

        while(areMarinesAlive() && areMonstersAlive())
        {
            if(!this.currentSpaceMarine.attack(this.currentMonster))
            {
                if(this.currentSpaceMarine.closerUnit != this.currentMonster && this.currentSpaceMarine.weapon.isMelee())
                {
                    this.currentSpaceMarine.moveCloseTo(this.currentMonster);
                }
                else if(this.currentSpaceMarine.getAp() < this.currentSpaceMarine.weapon.getApcost())
                {
                    this.currentSpaceMarine.recoverAP();
                }
                
            }

            if(this.currentMonster.isAlive() && !this.currentMonster.attack(this.currentSpaceMarine))
            {
                if(this.currentMonster.closerUnit != this.currentSpaceMarine)
                {
                    this.currentMonster.moveCloseTo(this.currentSpaceMarine);
                }
                else if(this.currentMonster.getAp() < this.currentMonster.getApcost())
                {
                    this.currentMonster.recoverAP();
                }
            }

            if(!this.currentSpaceMarine.isAlive())
            {
                this.spaceMarines.remove(this.currentSpaceMarine);
                this.currentMonster.recoverAP();
                if(this.spaceMarines.indexOf(this.currentSpaceMarine) + 1 == this.spaceMarines.size()) 
                {
                    this.currentSpaceMarine = null;
                    break;
                }
                this.currentSpaceMarine = this.spaceMarines.get(this.spaceMarines.indexOf(this.currentSpaceMarine) + 1 );
                System.out.println(this.currentSpaceMarine.getName() + " has entered the arena.");
            }

            if(!this.currentMonster.isAlive())
            {
                this.monsters.remove(this.currentMonster);
                this.currentSpaceMarine.recoverAP();
                if(this.monsters.indexOf(this.currentMonster) + 1 == this.monsters.size()) 
                {
                    this.currentMonster = null;
                    break;
                }
                this.currentMonster = this.monsters.get(monsters.indexOf(this.currentMonster) + 1 );
                System.out.println(this.currentMonster.getName() + " has entered the arena.");
            }
            
        }

        System.out.println("The " + (areMarinesAlive() ? "spaceMarines" : "monsters") +  " are victorious.");
        return true;
    }

    public boolean areMarinesAlive()
    {
        for(SpaceMarine marine : this.spaceMarines)
        {
            if(marine.isAlive()) return true;
        }
        return false;
    }

    public boolean areMonstersAlive()
    {
        for(Monster monster : this.monsters)
        {
            if(monster.isAlive()) return true;
        }
        return false;
    }

}
