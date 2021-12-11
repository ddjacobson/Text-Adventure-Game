
import java.util.Random;

public class Weapon extends Item {

    private String name;
    private int damageMax;
    private int damageMin;
    private String type;


    public Weapon(int weaponChoice){
        switch (weaponChoice){
            case 1:
                this.name = "mace";
                this.damageMax = 16;
                this.damageMin = 8;
                type = "wooden";
                break;
            case 2:
                name = "sword";
                this.damageMax = 16;
                this.damageMin = 8;
                type = "wooden";
                break;
            case 3:
                name = "hatchet";
                this.damageMax = 16;
                this.damageMin = 8;
                type = "wooden";
                break;
            default:
                name = "sword";
                this.damageMax = 16;
                this.damageMin = 8;
                type = "wooden";
                break;

        }
    }

    /**
     * Generates a damage number out of the min and max damage values.
     * @return
     */
    public int getDamage(){
        Random rand = new Random();
        int damage = rand.nextInt(damageMin, damageMax);
        return damage;
    }

    public String getName(){
        return name;
    }


    @Override
    public String toString(){
        String string = "";
        string += this.name;
        return string;
    }
}
