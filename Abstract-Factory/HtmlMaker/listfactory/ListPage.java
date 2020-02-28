package listfactory;

import factory.Item;
import factory.Page;

import java.io.File;
import java.io.FileWriter;

public class ListPage extends Page {

    public ListPage(String title){
        super(title);
    }

    @Override
    public void output() {
        String filepath = this.title + ".html";
        try{
            FileWriter fw = new FileWriter(new File(filepath));
            fw.write(this.makeHTML());
            fw.close();
            System.out.println(this.makeHTML());
            System.out.println(filepath + " 已生成!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();

        sb.append("<html><head><title>");
        sb.append(this.title);
        sb.append("</title></head><body>");

        for (Item item : this.content) {
            sb.append(item.makeHTML());
        }

        sb.append("</body></html>\n");

        return sb.toString();
    }
}
