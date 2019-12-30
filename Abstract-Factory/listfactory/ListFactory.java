package listfactory;

import factory.*;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String title, String url) {
        return new ListLink(title, url);
    }

    @Override
    public Tray createTray(String title) {
        return new ListTray(title);
    }

    @Override
    public Page createPage(String title) {
        return new ListPage(title);
    }
}
