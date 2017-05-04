package assigment1module1;

import java.util.ArrayList;
import java.util.List;

public class Subject{
    private List<Observer> observers = new ArrayList<>();
    private int state;
    private String stateString;

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
    
    public String getObserverState() {
        return stateString;
    }
    
    public void setObserverState(String valueString) {
        this.stateString = valueString;
        execute();
    }

    private void execute() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
