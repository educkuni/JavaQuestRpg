public class Monster {
    private String name;
    private int currentHp;
    private int maxHp;
    private int attack;
    private int xpReward;

    public Monster(String name, int maxHp, int attack, int xpReward) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.xpReward = xpReward;

    }

    public int attackHero(){
        return this.attack;
    }

    public void takeDamage(int damage){
        this.currentHp -= damage;
        if(this.currentHp < 0){
            this.currentHp = 0;
        }
        System.out.println(name + " took " + damage + " damage!");
    }

    public boolean isAlive(){
        return this.currentHp > 0;
    }

    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getXpReward() { return xpReward; }

}
