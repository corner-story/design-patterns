// 简单工厂模式
// 适用于对象类别比较少, 客户只知道用例名, 不知道对象名的情况

public class SimpleFactory{
    public static void main(String[] args){
        TVProduct product1 = TVProduct.getInstance("mi");
        product1.play();

        TVProduct product2 = TVProduct.getInstance("huawei");
        product2.play();
    

    }
}


abstract class TVProduct{
    public static TVProduct getInstance(String pname){
        /*
        if(pname.equals("mi")){
            return new MIProduct();
        }else if(pname.equals("huawei")){
            return new HUAWEIProduct();
        }
        return null;
        */

        
        TVProduct p = null;
        try {
            Class pclass = Class.forName(pname.toUpperCase()+"Product");
            p = (TVProduct) pclass.getDeclaredConstructor().newInstance();
            return p;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public abstract void play();
}

class MIProduct extends TVProduct{
    public void play(){
        System.out.println("嘿, 你看这个TV, 它又大又圆!");
    }
}

class HUAWEIProduct extends TVProduct{
    public void play(){
        System.out.println("HuaWei TV ?");
    }
}