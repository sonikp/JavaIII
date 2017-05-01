package observerMVC;

import java.util.ArrayList;
import java.util.List;

import assgnINVobsvr.InvOView;


public class Model
{

	
	private List<Observer> observers = new ArrayList<>();
    private int state;

    public void add(Observer o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int value) {
        this.state = value;
        execute();
    }

    private void execute() 
    {
    	System.out.println("!!!Debug " + observers.get(0));
    	
    	for (Observer observer : observers) 
    	{
        	observer.update();
        }
    }
    



}
