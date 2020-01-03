import java.util.ArrayList;
import java.util.List;

public class ObserverPattern{

    public static void main(String[] args){
        Observed gen = new NumberGen();
        gen.registerObserver(new NumberObserve());
        gen.execute();
    }
}


// 观察者
interface Observer{
    public void observe(Observed observed);
}

// 被观察者基类
abstract class Observed{
    protected List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyAllObservers(){
        var os = observers.iterator();
        while(os.hasNext()){
            var observer = (Observer) os.next();
            observer.observe(this);
        }
    }
    public abstract void execute();
    public abstract int getInfo();
}

// 具体被观察的类
class NumberGen extends Observed{
    private int dot = 0;

    public void execute(){
        for (int i = 0; i < 20; i++) {
            notifyAllObservers();
            this.dot += 5;
        }
    }
    public int getInfo(){
        return this.dot;
    }
}


// 具体的观察类
class NumberObserve implements Observer{
    
    public void observe(Observed observed){
        System.out.println("NumberGen observe: " + observed.getInfo());
        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }
    }
}