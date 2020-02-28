package config;

public class LowMainBoard extends MainBoard {
    @Override
    public void showConfigInfo() {
        System.out.printf("%-10s:\t%s\n", "主板质量", "低");
    }
}
