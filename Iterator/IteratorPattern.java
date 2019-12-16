import java.util.ArrayList;
import java.util.List;

/*
    使用Iterator模式实现相亲(狗头保命)
*/
public class IteratorPattern{
    public static void main(String[] args){
        System.out.println("我要相亲啦, 看看谁是我老婆, 嘿嘿!");
        var girls = new GirlList();
        girls.append(new Girl("cxk", 12));
        girls.append(new Girl("qbl", 58));
        girls.append(new Girl("saber", 20));
        girls.append(new Girl("cb", 10));
        var girlIterator = girls.iterator();

        while(girlIterator.hasnext()){
            var currgirl = (Girl)girlIterator.next();
            System.out.print(currgirl);
            if(currgirl.getName().equals("saber")){
                System.out.println("\t这是我老婆!");
            }else{
                System.out.println("\t下一个!");
            }
        }
    }
}


// Aggregate: 集合接口
interface Aggregate{
    public Iterator iterator();
}
// Iterator: 迭代器接口
interface Iterator{
    public Boolean hasnext();
    public Object next();
}

// 集合中的具体元素
class Girl{
    private String name;
    private Integer age;

    public Girl(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "<我的相亲对象: "+ this.name + ", " + this.age + ">";
    }
}

// 具体的集合, 实现Aggregate接口
class GirlList implements Aggregate{
    private List<Girl> girls;
    public GirlList(){
        girls = new ArrayList<>();
    }
    public void append(Girl girl){
        girls.add(girl);
    }

    public Girl getIndexAt(Integer index){
        return girls.get(index);
    }

    public Integer length(){
        return this.girls.size();
    }

    // 实现Aggregate接口
    public Iterator iterator(){
        return new GirlListIterator(this);
    }
}

// 具体的迭代器对象, 实现Iterator接口
class GirlListIterator implements Iterator{
    private GirlList girls;
    private Integer index = 0;

    public GirlListIterator(GirlList girls){
        this.girls = girls;
    }

    // 实现Iterator接口
    public Boolean hasnext(){
        if(index < girls.length()){
            return true;
        }
        return false;
    }

    public Object next(){
        var girl = girls.getIndexAt(index);
        index++;
        return girl;    
    }
}