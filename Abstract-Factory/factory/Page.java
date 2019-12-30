package factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Page extends Item {
    protected List<Item> content = new ArrayList<>();

    public Page(String title){
        super(title);
    }

    public void add(Item item){
        this.content.add(item);
    }

    public abstract void output();
}
