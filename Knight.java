
public class Knight extends Enemy{

    public Knight(){
        enemyType = "knight";
        maxHealth = 125;
        currHealth = maxHealth;
        damageHigh = 16;
        damageLow = damageHigh / 2;
    }

}
