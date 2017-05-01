package assgnNobsvr;


abstract class Observer {
    protected InvOModel subject;
    public abstract void update();
}