package config;

public class HighCPU extends CPU {

    @Override
    public void showConfigInfo() {
        System.out.printf("%-10s:\t%s\n", "CPU质量", "高");
    }
}
