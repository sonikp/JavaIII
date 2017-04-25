package observerjournal;

public interface Observer
{
	// method to update the observer, used by Subject
	public void update(){}
	
	// attach with subject to observer
	public void setSubject(Subject sub){}
}