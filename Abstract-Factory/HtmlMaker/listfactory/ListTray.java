package listfactory;

import factory.Item;
import factory.Tray;

public class ListTray extends Tray {

    public ListTray(String title){
        super(title);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n<li>");
        sb.append(this.title);
        sb.append("<ul>");
        for (Item item : this.trays) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>");
        sb.append("</li>\n");

        return sb.toString();
    }
}
