
import java.util.ArrayList;
import java.util.Random;
public class Player {
    int maxHealth = 100;
    int currHealth = maxHealth;
    Weapon equippedWeapon;
    ArrayList<Item> inventory = new ArrayList<>();

    public void attack(Enemy enemy) {
        enemy.takeDamage(this);
    }


    /**
     * The player takes damage from an enemy.
     * After taking damage, their health is checked.
     * If they are dead, the fight method will end.
     * @param enemy The current enemy that is being fought
     */
    public void takeDamage(Enemy enemy){
        int damageTaken = enemy.getDamage();
        this.currHealth -= damageTaken;
        System.out.println("You take " + damageTaken + " damage!");
        if (!playerIsAlive()){
            System.out.println("Oh no! You have died!");
        }
        else {
            System.out.println("You have " + this.currHealth + " health left.");
        }
        return;
    }

    public boolean playerIsAlive(){
        if (currHealth > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void setEquippedWeapon(Weapon weapon){
        equippedWeapon = weapon;

    }

    public void addItemToInventory(Item itemToAdd) {
        this.inventory.add(itemToAdd);
    }

    public void printInventory(){
        for (int i = 0; i < inventory.size(); ++i){
            System.out.println(inventory.get(i).toString());
        }
    }


    /**
     * Allows the player to run from combat. Ends the fight sequence
     * @return
     */
    public int run() {
        Random rand = new Random();
        System.out.println("You try to run.");
        int run = rand.nextInt(2);

        return run;
    }
}
