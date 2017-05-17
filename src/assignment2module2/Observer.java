package assignment2module2;


abstract class Observer {
    protected InventoryProgramModel subject;
    public abstract void update();
}