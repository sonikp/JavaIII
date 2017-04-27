package zTBDassignmentobserver;

//This interface handles adding, deleting and updating
//all observers 

public interface Subject {
	
	public void register(Inventory o);
	public void unregister(Inventory o);
	public void notifyObserver();
	
}