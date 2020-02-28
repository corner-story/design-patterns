package factory;

public abstract class Link extends Item{
    protected String url;

    public Link(String title, String url){
        super(title);
        this.url = url;
    }

}