import java.io.BufferedWriter;
import java.io.FileWriter;


// Builder模式

public class BuilderPattern {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("use text or html");
            System.exit(0);
        }

        if(args[0].equals("text")){
            new Director(new TextBuilder()).construct();
        }else if(args[0].equals("html")){
            new Director(new HtmlBuilder()).construct();
        }else{
            System.out.println("unknown type: " + args[0]);
        }
    }
}

// Builder接口或者抽象类
interface Builder {
    public void makeTitle(String title);

    public void makeHeader(String header);

    public void makeBody(String body);

    public void close(String footer);

    public String getResInfo();
}

// 调用Builder的类
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("欢迎注册Github!");
        builder.makeHeader("Hello, new User!");
        builder.makeBody("欢迎注册github, github是千万开发者交流平台");
        builder.close("2019-12-29");
    }

    public String getResult(){
        return builder.getResInfo();
    }

}

// Builder子类
class TextBuilder implements Builder {
    private BufferedWriter bw;
    private StringBuffer sb;
    private String path;

    public TextBuilder() {
        try{
            this.path = "res.txt";
            this.bw = new BufferedWriter(new FileWriter(this.path));
            this.sb = new StringBuffer();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void makeTitle(String title) {
        sb.append("==============");
        sb.append(title);
        sb.append("==============");
        sb.append("\n");
    }

    public void makeHeader(String header) {
        sb.append("             ");
        sb.append(header);
        sb.append("\n");
    }

    public void makeBody(String body) {
        sb.append("  ");
        sb.append(body);
        sb.append("\n");
    }

    public void close(String footer) {
        try {
            sb.append("==============");
            sb.append(footer);
            sb.append("==============");
            sb.append("\n");

            bw.write(sb.toString());
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getResInfo() {
        return this.path;
    }
}


class HtmlBuilder implements Builder {
    private BufferedWriter bw;
    private StringBuffer sb;
    private String path;

    public HtmlBuilder() {
        try{
            this.path = "res.html";
            this.bw = new BufferedWriter(new FileWriter(this.path));
            this.sb = new StringBuffer();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void makeTitle(String title) {
        sb.append("<html><title>");
        sb.append(title);
        sb.append("</title>");
        sb.append("\n");
    }

    public void makeHeader(String header) {
        sb.append("<h2 style=\"text-align:center;\">");
        sb.append(header);
        sb.append("</h2>");
        sb.append("\n");
    }

    public void makeBody(String body) {
        sb.append("<body>");
        sb.append(body);
        sb.append("</body>");
        sb.append("\n");
    }

    public void close(String footer) {
        try {
            sb.append("<footer>");
            sb.append(footer);
            sb.append("</footer>");
            sb.append("\n");
            sb.append("</html>");

            bw.write(sb.toString());
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getResInfo() {
        return this.path;
    }
}
