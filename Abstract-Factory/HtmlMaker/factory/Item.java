package factory;

public abstract class Item {
    protected String title;
    public Item(String title){
        this.title = title;
    }

    public abstract String makeHTML();
}