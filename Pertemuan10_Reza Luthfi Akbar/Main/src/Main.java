public class Main {
    public static void main(String[] args) {

        Potion potionAttack = new Potion("Attack Potion", "A", 50, 5, 20, "Attack");
        Potion potionHeal = new Potion("Healing Potion", "B", 30, 3, 15, "Heal");
        Sword sword = new Sword("Excalibur", "S", 300, 50);
        Shield shield = new Shield("Dragon Shield", "A", 200, 40);

        // Using potion
        System.out.println(potionAttack.use());
        System.out.println(potionHeal.use());

        // Sword attack
        System.out.println(sword.use());
        // Shield defense
        System.out.println(shield.use());
    }
}