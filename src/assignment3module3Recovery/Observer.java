package assignment3module3Recovery;


abstract class Observer {
    protected InventoryProgramModel subject;
    public abstract void update();
}