package factory;

public abstract class Factory {
    public static Factory getFactory(String classname){
        Factory factory = null;
        try{
            factory = (Factory) Class.forName(classname).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            System.out.println(e);
        }
        return factory;
    }

    public abstract Link createLink(String title, String url);
    public abstract Tray createTray(String title);
    public abstract Page createPage(String title);
}