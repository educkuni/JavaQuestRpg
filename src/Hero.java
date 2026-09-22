public class Hero {
    private String name;
    private String heroClass;
    private int level;
    private int maxHp;
    private int currentHp;
    private int maxMana;
    private int currentMana;
    private int attack;
    private int defense;
    private int xp;
    private int potions;

    public Hero(String name, String heroClass) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = 1;
        this.xp = 0;
        this.potions = 3;

        if (heroClass.equalsIgnoreCase("Warrior")) {
            this.maxHp = 120;
            this.maxMana = 30;
            this.attack = 15;
            this.defense = 10;

        } else if (heroClass.equalsIgnoreCase("Mage")) {
            this.maxHp = 80;
            this.maxMana = 100;
            this.attack = 25;
            this.defense = 4;

        }
        //archer
        else {
            this.maxHp = 100;
            this.maxMana = 50;
            this.attack = 18;
            this.defense = 7;

        }
        this.currentHp = this.maxHp;
        this.currentMana = this.maxMana;

    }

    public int attackEnemy() {
        return this.attack;
    }

    public int useSpecialSkill() {
        int manaCost = 20;
        if (this.currentMana >= manaCost) {
            this.currentMana -= manaCost;
            return this.attack * 2;
        } else {
            System.out.println("Not enough mana!");
            return 0;
        }
    }

    public void usePotion(){
        if (this.potions > 0){
            this.potions--;
            int healAmount = 40;
            this.currentHp = Math.min(this.maxHp, this.currentHp + healAmount);
            System.out.println(name + " used a Health Potion and recovered " + healAmount + " HP!");
        } else {
            System.out.println("You don't have any potions left!");
        }
    }

    public void takeDamage(int damage){
        int actualDamage = Math.max(1, damage - this.defense);
        this.currentHp -= actualDamage;
        if(this.currentHp < 0) this.currentHp = 0;
        System.out.println(name + " took " + actualDamage + " damage!");
    }

    public void gainXp(int amount){
        this.xp += amount;
        System.out.println(name + " gained " + amount + " XP!");
        if (this.xp >= this.level * 100) {
            levelUp();
        }
    }

    private void levelUp(){
        this.level++;
        this.maxHp += 20;
        this.currentHp = this.maxHp;
        this.maxMana += 15;
        this.currentMana = this.maxMana;
        this.attack += 5;
        this.defense += 2;
        System.out.println("\n LEVEL UP!" + name + " reached Level " + level + "!");
    }

    public boolean isAlive(){
        return this.currentHp > 0;
    }

    public String getName() { return name; }
    public String getHeroClass() { return heroClass; }
    public int getLevel() { return level; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getCurrentMana() { return currentMana; }
    public int getMaxMana() { return maxMana; }
    public int getPotions() { return potions; }

    public void addPotion() { this.potions++; }

}

