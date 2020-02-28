package factory;

import config.*;

public class HighConfigFactory extends PCConfigFactory {

    @Override
    public PCConfig createMainBoard() {
        return new HighMainBoard();
    }

    @Override
    public PCConfig createCPU() {
        return new HighCPU();
    }

    @Override
    public PCConfig createMemory() {
        return new HighMemory();
    }
}
