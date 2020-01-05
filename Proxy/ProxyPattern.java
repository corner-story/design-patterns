public class ProxyPattern{

    public static void main(String[] args){
        Printable printable = new PrinterProxy("proxy-name");
        System.out.println("name: " + printable.getName());
        printable.setName("change-name");
        System.out.println("name: " + printable.getName());
        
        if(args.length == 1){
            System.out.println("使用反射生成class....");
            ((PrinterProxy)printable).printByClass(args[0]);
        }else{
            System.out.println("使用默认方式生成class....");
            printable.print();
        }   
    }
}

// proxy接口
abstract class Printable{
    protected String name;

    protected Printable(String name){
        this.name = name;
    }
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void print();
}

// 代理
class PrinterProxy extends Printable{
    private Printable printable = null;
    public PrinterProxy(String name){
        super(name);
    }
    public synchronized void setName(String name){
        if(this.printable != null){
            this.printable.setName(name);
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void print(){
        getReal();
        printable.print();
    }

    public void printByClass(String classname){
        getRealByClass(classname);
        printable.print();
    }

    public synchronized void getRealByClass(String classname){
        try{
            this.printable = (Printable)Class.forName(classname).getDeclaredConstructor(String.class).newInstance(this.name);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public synchronized void getReal(){
        if(this.printable == null){
            this.printable = new Printer(this.name);
        }
    }
}

// 主体
class Printer extends Printable{
    public Printer(String name){
        super(name);
        System.out.print("Printer(" + name + ")正在生成");
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(1000);
            }catch(Exception e){

            }
            System.out.print(".");
        }
        System.out.println("");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void print(){
        for (int i = 0; i < this.name.length(); i++) {
            System.out.print("*");
        }
        System.out.println("");
        System.out.println(this.name);
        for (int i = 0; i < this.name.length(); i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

}