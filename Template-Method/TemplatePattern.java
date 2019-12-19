/*
    Tempalte Method模式: 父类中决定处理流程, 子类决定具体实现
*/

public class TemplatePattern{
    public static void main(String[] args){
        new You("qbl").show();
        new CXK().show();
    }
}

abstract class Tempalte{
    public abstract void sing();
    public abstract void jump();
    public abstract void rap();

    public final void show(){
        System.out.println("表演开始!");
        sing();
        jump();
        rap();
        System.out.println("表演完毕, 有请下一位!");
    }
}

class You extends Tempalte{
    private String name;

    public You(String name){
        this.name = name;
    }
    public void sing(){
        System.out.println("Hello, 我是" + this.name);
        System.out.println("唱.....");
    }
    public void jump(){
        System.out.println("跳.....");
    }
    public void rap(){
        System.out.println("rap......");
    }
}

class CXK extends Tempalte{
    public void sing(){
        System.out.println("大家好, 我是练习时长两年半的个人练习生");
        System.out.println("及你太美.....");
    }
    public void jump(){
        System.out.println("扭pp.....");
    }
    public void rap(){
        System.out.println("及你太美......");
    }
}


