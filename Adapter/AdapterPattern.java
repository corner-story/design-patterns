/*
    在Iterator模式的例子中安排了一次相亲, 我们见到了乔碧萝殿下和cxk
    不过qbl的面貌和声音和想象中的不一样，我们想要的是甜美的声音和好看的美女
    所以使用Adapter模式把qbl适配成我们想要的样子
*/
public class AdapterPattern{
    public static void main(String[] args){
        System.out.println("未适配的QBL:");
        new QBLNN().talk();

        System.out.println("适配之后的乔碧萝:");
        ToBeBeautiful qbl = new AdapteToBeautiful();
        qbl.talkWithOpenFilter();
    }    
}

// 乔碧萝奶奶(不可变)， 我们只能适配一个新的出来
class QBLNN{
    public void talk(){
        System.out.println("我是乔碧萝!");
    }
}

interface ToBeBeautiful{
    public void talkWithOpenFilter();
}

// 适配器，把qbl适配成我们想要的
class AdapteToBeautiful extends QBLNN implements ToBeBeautiful{
    public void talkWithOpenFilter(){
        System.out.println("乔碧萝即将talk, 打开美颜, 滤镜, 变声器.....");
        talk();
    }
}
