public class Player extends Entity {

    private String name;

    public Player(int level, int hp, String name) {
        super(level, hp);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void entityInfo() {
        //super.entityInfo();
        System.out.println("# PLAYER DENGAN NAMA : " + name + ", DAN LEVEL : " + getLevel());
    }

    public void attack(Zombie zombie) {
        if (getHp() > 0) {
            System.out.println("zombie : GRAAA!");
            zombie.setHp(zombie.getHp() - 10);
            if (zombie.getHp() <= 0) {
                System.out.println("# ZOMBIE MATI");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void attack(Merchant merchant) {
        if (getHp() > 0) {
            System.out.println("merchant : hey heyy, ngapain nyerang");
            merchant.setHp(merchant.getHp() - 10);
            if (merchant.getHp() <= 0) {
                System.out.println("Merchant : Dah lah males jualan");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void interact (Merchant merchant) {
        if (getHp() > 0) {
            if (merchant.getHp() > 0) {
                System.out.println("Merchant :");
                System.out.println("Barang yang tersedia hari ini");
                for (String item : merchant.getListItem()) {
                    System.out.println("# " + item);
                }
            } else {
                System.out.println("# TIDAK BISA BELI, MERCHANT NGAMBEK");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }
}