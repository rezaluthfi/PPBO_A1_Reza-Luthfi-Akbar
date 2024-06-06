public class Shield extends Item {
    private int damageBlock;

    public Shield(String name, String rank, int price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }

    public int getDamageBlock() {
        return damageBlock;
    }

    public void setDamageBlock(int damageBlock) {
        this.damageBlock = damageBlock;
    }

    @Override
    public String use() {
        return "Damage mitigated by " + damageBlock;
    }

}