package factory;

import config.*;

public abstract class PCConfigFactory {

    public abstract PCConfig createCPU();

    public abstract PCConfig createMainBoard();

    public abstract PCConfig createMemory();

}
