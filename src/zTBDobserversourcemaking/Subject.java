package zTBDobserversourcemaking;

import java.util.ArrayList;
import java.util.List;


public class Subject{
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
        System.out.println("DB:Subject.setState = value ::" + value);
        execute();
    }

    private void execute() {
    	System.out.println("Debug: Observers.execute() ENTERED" );
    	for (Observer observer : observers) {
            System.out.println("Debug: Observers.execute() " + observer );
        	observer.update();
        }
    }
}
