

import java.util.Scanner;

public class main {

    public static void main(String args[]) {
        String gameChoice = startGame();
        switch (gameChoice){
            case "y":
                Player player = new Player();
                playIntro(player);
                break;
            case "n":
                System.out.println("Okay, see you again later.");
                break;
            default:
                System.out.println("Please type either Y or N.");
                startGame();
        }
    }


    /**
     * Intro sequence of the game.
     * @param player The player of the game. Currently only single player.
     */
    private static void playIntro(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of your kingdom.");
        String kingdomName = input.nextLine();
        System.out.println("Oh no! " + kingdomName + " is under siege! Do you escape or defend your kingdom? (ESC/DEF)");
        String defenseChoice = input.nextLine().toLowerCase();
        System.out.println("But first, you must grab a weapon. Do you choose the...\n1) Mace\n2) Sword\n3) Hatchet");
        int weaponChoice = input.nextInt();

        Weapon firstWeapon = new Weapon(weaponChoice);
        player.addItemToInventory(firstWeapon);
        player.printInventory();
        System.out.println("You've chosen the " + firstWeapon.getName());
        player.setEquippedWeapon(firstWeapon);


        switch (defenseChoice.toLowerCase()) {
            case "esc":
                escapeSequence();
                break;
            case "def":
                defenseSequence(player);
                break;
            default:

                break;
        }
    }

    /**
     * This method initiates the fight sequence between the player and the enemy.
     * In the fight loop, the player attacks or runs from the enemy, and the enemy attacks the player.
     * After the player attack the enemy, their health is checked if the enemy is dead, the fight method ends.
     * After the enemy attacks the player, their health is checked.
     * @param enemy
     * @param player
     */
    private static void fight(Enemy enemy, Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("You are fighting an enemy " + enemy.enemyType + "!");
        enemy.printEnemyStats();

        while (!enemy.enemyIsDead()){
            System.out.println("Do you...\n 1) Attack\n2) Run?");
            String fightChoice = input.nextLine();
            switch (fightChoice){
                case "1":
                    player.attack(enemy);
                    if (enemy.enemyIsDead()){
                        return;
                    }
                    break;
                case "2":
                    switch (player.run()){
                        case 1:
                            System.out.println("You have failed to run away...");
                            break;
                        case 0:
                    System.out.println("You have successfully ran away!");
                    return;
                }
            }
            enemy.attack(player);
            if (!player.playerIsAlive()){
                return;
            }
        }
        }


    /**
     * The defence sequence.
     * CURRENTLY USED FOR TESTING COMBAT SYSTEM
     * @param player
     */
    private static void defenseSequence(Player player) {
        Enemy enemy1 = createEnemy("goblin");
        fight(enemy1, player);
        Enemy enemy2 = createEnemy("knight");
        fight(enemy2, player);
    }

    private static void escapeSequence() {
    }

    private static Enemy createEnemy(String enemyType){
        Enemy enemy;

        switch (enemyType){
            case "goblin":
                 enemy = new Goblin();
                break;
            case "knight":
                enemy = new Knight();
               break;
            default:
                enemy = new Goblin();
                break;
        }
        return enemy;
    }


    private static String startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TextGame. We currently have support for one game. Would you like to play? (Y/N)");
        String gameChoice = input.nextLine().toLowerCase();
        return gameChoice;
    }
}
