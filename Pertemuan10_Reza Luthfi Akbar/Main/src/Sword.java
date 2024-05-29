public class Sword extends Item {
    private int damage;

    public Sword(String name, String rank, int price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String use() {
        return "Damage dealt by " + damage;
    }

}