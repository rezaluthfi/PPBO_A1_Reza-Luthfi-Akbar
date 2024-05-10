public class Zombie extends Entity{

    public enum Types {
        MELEE,
        RANGED
    }

    private Types type;

    public Zombie(int level, int hp, Types type) {
        super(level, hp);
        this.type = type;
    }

    @Override
    public void entityInfo() {
        //super.entityInfo();
        System.out.println("# ZOMBIE DENGAN TIPE : " + type + ", DAN LEVEL : " + getLevel());
    }

    public void attack(Player player) {
        if (super.getHp()>0) {
            System.out.println("player : UGHH");
            if (type == Types.MELEE) {
                player.setHp(player.getHp() - 20);
                if (player.getHp() <= 0) {
                    System.out.println("# YOU DIE, GAME OVER");
                }
            } else if (type == Types.RANGED) {
                player.setHp(player.getHp() - 15);
                if(player.getHp() <= 0){
                    System.out.println("# YOU DIE, GAME OVER");
                }
            }
        } else {
            System.out.println("# ZOMBIE SUDAH MATI");
        }
    }

}