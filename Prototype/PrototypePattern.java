import java.util.HashMap;

public class PrototypePattern{

    public static void main(String[] args){
        PrototypeManager pm = new PrototypeManager();
        pm.register("underline-pencil", new UnderlinePen('~'));
        pm.register("message-box", new MessageBox('*'));

        // 使用
        Product pd = pm.create("underline-pencil");
        pd.use("Hello, World!");

        Product pmb = pm.create("message-box");
        pmb.use("Hello, World!");

    }
}


// 具体product的接口, 需要实现cloneable
abstract class Product implements Cloneable{
    public abstract void use(String str);
    public final Product createClone(){
        Product p = null;
        try{
            p = (Product)clone();
        }catch(Exception e){
            System.out.println(e);
        }
        return p;
    }
}

// prototype(原型管理)类
class PrototypeManager{
    private HashMap<String, Product> prototypes = new HashMap<>();

    public void register(String key, Product value){
        prototypes.put(key, value);
    }

    public Product create(String key){
        // 对原型进行clone
        Product p = prototypes.get(key).createClone();
        return p;
    }
}



// 具体的product类
class UnderlinePen extends Product{
    private char dotchar;
    public UnderlinePen(char dotchar){
        this.dotchar = dotchar;
    }

    public void use(String msg){
        System.out.println("\n" + msg);
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(dotchar);
        }
        System.out.println("");
    }
}

class MessageBox extends Product{
    private char dotchar;
    public MessageBox(char dotchar){
        this.dotchar = dotchar;
    }

    public void use(String msg){
        System.out.println("");
        for (int i = 0; i < msg.length()+4; i++) {
            System.out.print(dotchar);
        }
        System.out.println("");
        System.out.println(dotchar + " " + msg + " " + dotchar);
        for (int i = 0; i < msg.length()+4; i++) {
            System.out.print(dotchar);
        }
        System.out.println("");
    }
}