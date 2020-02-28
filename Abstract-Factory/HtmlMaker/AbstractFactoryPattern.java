import factory.*;


public class AbstractFactoryPattern {
    public static void main(String[] args) {
       if(args.length != 1){
           System.out.println("请输入具体的工厂类!");
           System.exit(0);
       }
        // String factoryname = "listfactory.ListFactory";
        String factoryname = args[0];

        Factory factory = Factory.getFactory(factoryname);

        var glink = factory.createLink("Google", "https://www.google.com");
        var blink = factory.createLink("Baidu", "https://www.baidu.com");
        var site = factory.createLink("My website", "39.107.83.159");

        var links = factory.createTray("网站");
        links.add(glink);
        links.add(blink);
        links.add(site);

        var page = factory.createPage("demo");
        page.add(links);
        page.add(factory.createLink("Bilibili", "https://www.bilibili.com/"));

        page.output();

    }
}