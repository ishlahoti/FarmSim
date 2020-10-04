public class Item {
    private int quantity;
    private String name;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getInfo() {
        return (name + " :" + quantity);
    }
    public void updateQuantity() {
        quantity++;
    }
}
