package config;

public class HighMemory extends Memory {
    @Override
    public void showConfigInfo() {
        System.out.printf("%-10s:\t%s\n", "内存质量", "高");
    }
}
