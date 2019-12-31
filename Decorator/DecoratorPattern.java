public class DecoratorPattern{

    public static void main(String[] args){
        System.out.println("无装饰器:");
        var d1 = new StringDisplay("Hello, Decorator!");
        d1.show();

        System.out.println("第一个装饰器:");
        Decorator decorator1 = new DisplayDecorator(d1, '*');
        decorator1.show();

        System.out.println("复杂装饰器:");
        new DisplayDecorator(
            new DisplayDecorator(
                new DisplayDecorator(
                    new DisplayDecorator(
                        d1,
                        '*'
                    ),
                    '~'
                ),
                '/'
            ),
            '='
            ).show();
    }

}

// Decorator(装饰器)模式
abstract class Display{
    protected String description = "";
    public abstract void show();
}

class StringDisplay extends Display{
    public StringDisplay(String str){
        this.description = str;
    }
    public void show(){
        System.out.println(description);
    }
}



// 修饰类, 继承Display是为了提供和Display一样的API
abstract class Decorator extends Display{
    protected Display decorated;

    protected Decorator(Display display){
        this.decorated = display;
        this.description = display.description;  // 确保decorated中的description和this中的一样
    }
}

class DisplayDecorator extends Decorator{
    private char dotchar;

    public DisplayDecorator(Display display, char dotchar){
        super(display);
        this.dotchar = dotchar;
    }

    // 对decorated的show方法进行装饰
    public void show(){
        for (int i = 0; i < this.description.length(); i++) {
            System.out.print(this.dotchar);
        }
        System.out.println("");
        this.decorated.show();
        for (int i = 0; i < this.description.length(); i++) {
            System.out.print(this.dotchar);
        }
        System.out.println("");
    }
}