
import java.util.Random;

public class Enemy {
    public int maxHealth;
    public int currHealth;
    public int damageHigh;
    public int damageLow;
    public String enemyType;

    void printEnemyStats(){
        System.out.println("Type: " + enemyType + "\nHealth: " + currHealth + "\n");
    }

    public int getDamage(){
        Random random = new Random();
        int damage = random.nextInt(damageLow, damageHigh);
        return damage;
    }

    public void takeDamage(Player player){
        int damage = player.equippedWeapon.getDamage();
        this.currHealth -= damage;
        System.out.println("You deal " + damage + " damage.");
        if (enemyIsDead()){
            System.out.println("The enemy " + this.enemyType + " has been defeated.");
            return;
        }
        System.out.println("The enemy has " + this.currHealth + " health left.");

    }

    public void attack(Player player){
        System.out.println("The enemy attacks you.");
        player.takeDamage(this);
    }

    public boolean enemyIsDead(){
        if (this.currHealth > 0){
            return false;
        }
        else {
            return true;
        }
    }

    public int getHealth() {
        return currHealth;
    }



    public Enemy(){

    }



}
