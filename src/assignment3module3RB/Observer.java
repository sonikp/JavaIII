package assignment3module3RB;


abstract class Observer {
    protected InventoryProgramModel subject;
    public abstract void update();
}