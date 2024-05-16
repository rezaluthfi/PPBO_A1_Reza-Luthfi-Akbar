import java.util.ArrayList;

public class Merchant extends Entity {

    private ArrayList<String> listItem;

    public Merchant(int level, int hp, ArrayList<String> listItem) {
        super(level, hp);
        this.listItem = listItem;
    }

    public ArrayList<String> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<String> listItem) {
        this.listItem = listItem;
    }

    @Override
    public void entityInfo() {
        //super.entityInfo();
        System.out.println("# MERCHANT DENGAN LEVEL : " + getLevel());
    }
}