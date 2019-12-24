public class SingletonPattern{
    public static void main(String[] args){
        System.out.println("Start test singleton:");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if(singleton1 == singleton2){
            System.out.println("singleton1 == singleton2");
        }else{
            System.out.println("singleton1 != singleton2");
        }

        System.out.println("end test!");
    }
}

// 单例模式
class Singleton{
    private static Singleton singleton = new Singleton();

    //构造函数必须设置为private
    //只能在该类生成该类的实例, 不能再类外生成实例 
    private Singleton(){
        System.out.println("生成Singleton class实例!");
    }

    public static Singleton getInstance(){
        return singleton;
    }
}