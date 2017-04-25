package week3;

public class Week3Notes
{
	
}

/*

Google Search: java head first observer pattern
https://www.safaribooksonline.com/library/view/head-first-design/0596007124/ch02.html
http://www.wintellect.com/devcenter/jwood/head-first-design-patterns-part-1-observer-pattern
https://www.youtube.com/results?search_query=java+beginner+observer+pattern
https://www.youtube.com/watch?v=ojbT9WA70Fw
https://www.youtube.com/watch?v=wiQdrH2YpT4

http://www.austintek.com/mvc/

MVC Controller: (design patterns)
observer, strategy composite patterns

update routine = double dispatch

Assignment comments:
-Do not use the observer interface in Java
-Make each M, V, C an observer
-How is it that objects discover each other and start talking to each other
-Wiring more complex architectures

Further reading:
further reading on observer
		//https://ucsdextension.blackboard.com/webapps/blackboard/content/listContent.jsp?course_id=_5698010_1&content_id=_2280155_1
		https://ucsdextension.blackboard.com/webapps/discussionboard/do/message?action=list_messages&course_id=_5698010_1&nav=discussion_board_entry&conf_id=_69906_1&forum_id=_161710_1&message_id=_5188539_1

+++Important:
the one thing that all the different models have in common, is the "double dispatch" communications

The view:
-stored in instance variables, not global variables
-return notification from model to view to say state has changed
-(Robert)define a view interface? What does that mean?

Controller sometimes has
-business rules
-authentication
-purchase 5 items and get free shipping

Finalize(method): are all the things are needed to prepare an object of destruction, garbage collection
-it is frowned upon to call finalize. 
The better practice for reclaiming resources would be to implement a dispose method
-don't expect finalize to be called by the garbage collector, ensure that you implement a 
definite finalize method using the following:

void dispose()
{
	if(!disposed)
	{
		"code to relinquish an object, close(), etc and stuff";
		disposed = true;
	}
}

void finalizez()
{
	dispose();
}

=========================================
Looking at some swing stuff Look at all of chapter 12
Next project will be implementing a swing interface

Example fig 12_02 - Addition.java

JFrame, one of the major libraries in java
-gives you the window frame
-example fig 12_06_07 - LabelFrame.java

Java is an example of a "single tree inheritance language"
-everything inherits from object
-after Object, there is Component, Container, JComponent
-All swing objects inherit from JComponent

FlowLayout
-sets the layout as we would read, from left to right
what does getClass() do, what exactly is this return

"weird, confusing, magical!!"

NB: If you make a reference to an object, you should make sure that the object exists

Fig 12_09_10 = JLabel
Fig 12_15_16 = JButton

Be conscious of differences in windows and unix, case sensitivity and the difference in / \ for paths.
Checkbox :  Fig 12_17_18
imutable, cant be changed, Font objects are imutable

Radio Buttons Fig 12.19

(anonymous innner class)::this listener is an object, that can not be reused, however it is instantly avaliable to that listener object


fig 12.21.22

fig 12.23
fig 12.25
fig 12.28
JPanel is a graphical container
has private inner class

private inner classes

anonomyous innerclass can't be deregistered for the entire life of the app because it doesn't have a name to reference to remove the object
a private innerclass has a name reference so it can be deregistered


fig 12.31.32
an adapter class, is a class is where you take a give interface where you implement the entire methods with null methods.


----------------------

http://www.journaldev.com/1739/observer-design-pattern-in-java
https://www.youtube.com/watch?v=wiQdrH2YpT4
http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
https://dzone.com/articles/design-patterns-uncovered

observer patterns

Subject (Publisher)
Observer (subscriber)

MVC;
Model = Subject
View = Observer

+ve: 
	- loose coupling
	- Subject doesn't know anything about the Observer (subscriber)
-ve: 
	-Subject may send updates that don't matter to the Observer (subscriber)

http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/

Notes on this tutorial
1. Start with creating an interface class called Subject
2. Create an Observer interface class
3. Create StockObserver class which implements the Subject class' methods for adding, deleting, updating observers
	- this stores all the observers in an ArrayList
	- implements the instance variables that will store all the data
	- implements all the methods for updating, deleting, adding observers
	- implements methods that will update the stock prices
4. Create StockGrabber























*/