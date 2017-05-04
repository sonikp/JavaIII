package assgnINVobsvr;


abstract class Observer {
    protected InventoryProgramModel subject;
    public abstract void update();
}