package zTBDassignmentz2_jtable;


abstract class Observer {
    protected InventoryProgramModel subject;
    public abstract void update();
}