package factory;

import config.*;

public class LowConfigFactory extends PCConfigFactory {
    @Override
    public PCConfig createMainBoard() {
        return new LowMainBoard();
    }

    @Override
    public PCConfig createCPU() {
        return new LowCPU();
    }

    @Override
    public PCConfig createMemory() {
        return new LowMemory();
    }
}
