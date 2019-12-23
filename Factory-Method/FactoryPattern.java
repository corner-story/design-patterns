import java.util.ArrayList;
import java.util.List;

public class FactoryPattern{

    public static void main(String[] args){
        Factory factory = new IDCardFactory();
        Product cxk = factory.create("cxk");
        Product qbl = factory.create("qbl");

        cxk.use();
        qbl.use();

        System.out.println("factory products:");
        System.out.println(factory.getProducts());

    }
}


// 具体接口
interface Product{
    public abstract void use();
}

abstract class Factory{
    public abstract Product createProduct(String name); 
    public abstract void registerProduct(Product product);
    public abstract List getProducts();

    // 工厂方法
    public final Product create(String username){
        Product product = createProduct(username);
        registerProduct(product);
        return product;
    }
}

// 具体的product和工厂实现
class IDCard implements Product{
    private String username;
    public IDCard(String username){
        this.username = username;
    }
    public void use(){
        System.out.println(username + " 使用IDCard!");
    }
    public String getOwner(){
        return username;
    }
}

class IDCardFactory extends Factory{
    private List<String> products = new ArrayList<>();
    
    public Product createProduct(String username){
        System.err.println("创建IDCard: " + username);
        return new IDCard(username);
    }

    public void registerProduct(Product product){
        products.add(((IDCard)product).getOwner());
    }

    public List<String> getProducts(){
        return products;
    }

}