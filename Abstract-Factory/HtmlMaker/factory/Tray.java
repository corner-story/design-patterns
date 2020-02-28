package factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {
    protected List<Item> trays = new ArrayList<>();

    public Tray(String title){
        super(title);
    }

    public void add(Item item){
        this.trays.add(item);
    }
}
