package assignmentobserverINCLUDEObserver;


abstract class Observer {
    protected InvModel subject;
    public abstract void update();
}