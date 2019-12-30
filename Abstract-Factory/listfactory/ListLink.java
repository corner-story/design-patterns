package listfactory;

import factory.Link;

public class ListLink extends Link {
    public ListLink(String title, String url){
        super(title, url);
    }

    @Override
    public String makeHTML() {
        return "\t\t<li><a href=\"" + this.url + "\">" + this.title + "</a></li>\n";
    }
}
