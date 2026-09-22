import java.util.Random;
import java.util.Scanner;

public class GameApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static Hero hero;

    public static void main(String[] args){

        System.out.println("-----------------------------------");
        System.out.println("      🗡️     JAVA QUEST      🛡️   ");
        System.out.println("-----------------------------------");

        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("Choose an option: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("2")) {
            hero = SaveManager.loadGame();
        }

        if (hero== null){
            creatNewHero();
        }

        mainGameLoop();

    }

private static void creatNewHero(){
    System.out.println("\n--- Create yoour hero ---");
    System.out.println("Enter hero name: ");
    String name = scanner.nextLine().trim();

    System.out.println("Choose class:");
    System.out.println("1. Warrior (High HP and Defense)");
    System.out.println("2. Mage (High Attack and Mana)");
    System.out.println("3. Archer (Balanced)");
    System.out.println("Option: ");
    String classChoice = scanner.nextLine().trim();

    String heroClass = "Warrior";
    if (classChoice.equals("2")) heroClass = "Mage";
    else if (classChoice.equals("3")) heroClass = "Archer";

    hero = new Hero(name,heroClass);
    System.out.println("\n✨ Welcome, " + hero.getName() + " the " + hero.getHeroClass() + "!");
}

private static void mainGameLoop() {
        while (hero.isAlive()){
        System.out.println("\n--------------------------------");
        System.out.println("Hero: " + hero.getName() + " | Level: " + hero.getLevel() +
                           "| HP: " + hero.getCurrentHp() + "/" + hero.getMaxHp() +
                           "| Mana: " + hero.getCurrentMana() + "/" + hero.getMaxMana() +
                           "| Potions: " + hero.getPotions());
        System.out.println("--------------------------------");
        System.out.println("1. Explore Dungeon (Battle)");
        System.out.println("2. Rest at inn (Heal)");
        System.out.println("3. Save Game");
        System.out.println("4. Exit Game");
        System.out.print("Action: " );

        String action =  scanner.nextLine().trim();

        switch(action) {
            case "1":
                startBattle();
                break;
            case "2":
                healAtInn();
                break;
            case "3":
                SaveManager.saveGame(hero);
                break;
            case "4":
                System.out.println("\nSaving and closing game... Goodbye!");
                SaveManager.saveGame(hero);
                return;

            default:
                System.out.println("Invalid optionN");
        }
    }
    System.out.println("\nGame over! " + hero.getName() + " has fallen in battle.");

}

private static void startBattle(){
        Monster monster = generateRandomMonster();
    System.out.println("\nA wild " + monster.getName() + " appeared!");

    while(hero.isAlive() && monster.isAlive()) {
        System.out.println("\n[" + hero.getName() + " HP: " + hero.getCurrentHp() + "] vs [" +
                            monster.getName() + " HP: " + monster.getCurrentHp() + "]");
        System.out.println("1. Attack | 2. Special Ability | 3. Drink Potion | 4. Run");
        System.out.println("Choose action: ");
        String battleAction = scanner.nextLine().trim();

        int heroDamage = 0;
        if (battleAction.equals("1")) {
            heroDamage = hero.attackEnemy();
            monster.takeDamage(heroDamage);
        } else if (battleAction.equals("2")) {
            heroDamage = hero.useSpecialSkill();
            if(heroDamage > 0) monster.takeDamage(heroDamage);
        } else if(battleAction.equals("3")) {
            hero.usePotion();
        } else if (battleAction.equals("4")){
            System.out.println("You managed to run away!");
            return;
        } else {
            System.out.println("Invalid action, you lose your turn!");
        }
        if(monster.isAlive()){
            int monsterDamage = monster.attackHero();
            hero.takeDamage(monsterDamage);
        }
    }

    if (hero.isAlive()){
        System.out.println("\nYou defeated the " + monster.getName() + "!");
        hero.gainXp(monster.getXpReward());

        if (random.nextBoolean()){

            hero.addPotion();
            System.out.println("You found a Health Potion on the monster!");
        }
    }
}

    private static Monster generateRandomMonster() {
        int choice = random.nextInt(3);

        if (choice == 0) {
            return new Monster("Goblin", 35, 10, 50);
        } else if (choice == 1) {
            return new Monster("Orc", 70, 18, 100);
        } else {
            return new Monster("Skeleton", 50, 14, 75);
        }
    }

    private static void healAtInn(){
        System.out.println("\nYou rested at the Inn and restored all HP and Mana!");

        hero.usePotion();
    }
}
