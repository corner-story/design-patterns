import factory.*;
import config.*;

public class Main {


    public static void main(String[] args) {
        System.out.println("**********PC Config Store!*********");

        System.out.println("高配置:");
        PCConfigFactory highfactory = new HighConfigFactory();
        PCConfig hcpu = highfactory.createCPU();
        PCConfig hmb  = highfactory.createMainBoard();
        PCConfig hmem = highfactory.createMemory();

        hcpu.showConfigInfo();
        hmb.showConfigInfo();
        hmem.showConfigInfo();


        System.out.println("\n低配置:");
        PCConfigFactory lowfactory = new LowConfigFactory();
        PCConfig lcpu = lowfactory.createCPU();
        PCConfig lmb  = lowfactory.createMainBoard();
        PCConfig lmem = lowfactory.createMemory();

        lcpu.showConfigInfo();
        lmb.showConfigInfo();
        lmem.showConfigInfo();

    }
}
