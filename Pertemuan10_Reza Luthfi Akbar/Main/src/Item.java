abstract class Item implements Usable {
    private String name;
    private String rank;
    private int price;

    public Item(String name, String rank, int price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}