package zTBDassignment2module2BKUP;

import java.util.ArrayList;
import java.util.List;

public class Subject{
    private List<Observer> observers = new ArrayList<>();
    private String stateString;

    public void add(Observer o) {
        observers.add(o);
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
