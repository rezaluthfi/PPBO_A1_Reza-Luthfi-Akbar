public class Potion extends Item {
    private int duration;
    private int effectPoint;
    private String potionType;

    public Potion(String name, String rank, int price, int duration, int effectPoint, String potionType) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.potionType = potionType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEffectPoint() {
        return effectPoint;
    }

    public void setEffectPoint(int effectPoint) {
        this.effectPoint = effectPoint;
    }

    public String getPotionType() {
        return potionType;
    }

    public void setPotionType(String potionType) {
        this.potionType = potionType;
    }

    @Override
    public String use() {
        if (potionType.equalsIgnoreCase("Attack")) {
            return "Damage dealt by " + effectPoint;
        } else if (potionType.equalsIgnoreCase("Heal")) {
            return "Healed by " + effectPoint;
        } else {
            return "Invalid potion type";
        }
    }

}
