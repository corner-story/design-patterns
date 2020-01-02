import java.util.ArrayList;
import java.util.List;

public class VisitorPattern{
    public static void main(String[] args){
        var demo = new VisitedFile("demo.txt");
        var home = new VisitedDir("home");
        var cxk = new VisitedDir("cxk");
        var cxkdress = new VisitedDir("dress");
        cxkdress.add(new VisitedFile("mydress.gif"));

        cxk.add(new VisitedFile("mypicture.jpg"));
        cxk.add(cxkdress);
        cxk.add(new VisitedFile("kiss.png"));
        
        home.add(demo);
        home.add(cxk);
        home.add(new VisitedFile("config.py"));

        var print = new PrintVisitor();

        System.out.println("文件:");
        demo.accept(print);

        System.out.println("目录:");
        home.accept(print);
    }
}


// 访问
interface Visitor{
    public void visit(VisitedFile visited);
    public void visit(VisitedDir visited);
}

// 被访问
interface Visited{
    public void accept(Visitor visitor); 
}

// 具体被访问的元素(具体的数据)
class VisitedFile implements Visited{
    private String filename;

    public VisitedFile(String filename){
        this.filename = filename;
    }

    public String getFileName(){
        return this.filename;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
class VisitedDir implements Visited{
    private String dirname;
    private List<Visited> childs = new ArrayList<>();

    public VisitedDir(String dirname){
        this.dirname = dirname;
    }

    public String getDirName(){
        return this.dirname;
    }

    public List<Visited> getChilds(){
        return this.childs;
    }
    public void add(Visited visited){
        childs.add(visited);
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}


// 具体的访问行为
class PrintVisitor implements Visitor{
    private int indent = 0;
    public void visit(VisitedFile visited){
        System.out.println("|-" + visited.getFileName());
    }

    public void visit(VisitedDir visited){
        System.out.println("|-" + visited.getDirName() + "\\");
        
        indent = indent + 2;
        for (int i = 0; i < visited.getChilds().size(); i++) {
            for (int j = 0; j < indent; j++) {
                System.out.print(" ");
            }
            visited.getChilds().get(i).accept(this);
        }
        indent = indent - 2;
    }
}


