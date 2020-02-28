package config;

public class LowCPU extends CPU{
    @Override
    public void showConfigInfo() {
        System.out.printf("%-10s:\t%s\n", "CPU质量", "低");
    }
}
