package week2;

public class Week2Notes
{
	public static void main(String[] args)
	{
		System.out.println("JavaIII - Week2");
	}
}

/*

Module Lesson 1: Advanced Polymorphism


Review:
chapt 20, 14, 6,8,9

Supplementary Material:
https://ucsdextension.blackboard.com/webapps/blackboard/content/listContent.jsp?course_id=_5698010_1&content_id=_2280155_1

Course Overview:

Week 1
	- Introduction,
	- The Model, View, Controller Architecture
	- Scanner Class,
	- HashMaps, Hashtables, and the Properties Class, (properties 718-721 Fig 16.19)
	- Enum type,
	- Packages, jars, and the manifest file.
	 

Week 2
	
	- Overview of Object-Oriented Programming,
	- Classes,
	- Encapsulation,
	- Access Modifiers,
	- thisReference,
	- Constructors,
 	- Set and Get Methods,
	- Composition,
	- Enumerations,
	- Garbage Collection,finalize and dispose methods,
	- finalInstance Variables,
	- Package Access

course Schedule on Blackboard:
https://ucsdextension.blackboard.com/webapps/blackboard/content/listContent.jsp?course_id=_5698010_1&content_id=_2280133_1&mode=reset

Supplementary materials contain information on the projects

REMEMBER
***Be ruthlessly simple**
***should be streamlined***

Note for assignment: the deliverables ** DUE FOR WEEK 4****
*** submit all the design documents individually, clearly for marking**
- Brief software system requirements specification document
	- what are the fields going to be
	- what is the data you are managing
	- what is the field you will use for the title of the book
	- what are these fields going to map to
	- are is the version number of the book, (that's version two)
	- don't make it too complicated, but make it usable enough to be real
	- HAve to do CRUD
- brief Software System Design Document (create a UML diagram)
	- what are the key abstractions here?
		- MVC is a key abstraction
		- persistence layer/model?
		- please include MVC names in components.
		- View, Model, controller  are key abstractions, and promotes swap-ability, may have more than one view or model
		- there should be an abstract view and an interface HINT, HINT!!!!
		- inheritance/polymorphism are abstractions
		- need to be able to track the media items, is this not an abstraction
		- need to support the abstraction of the media items.
		- need UML diagram, what the abstractions are and how they relate to each other
- application as a runnable jar
- capture source code as well as screen captures of images as it is running. 
	- when you create a JAR file, it does not put the .java files in it.
	- this MUST be submitted separately in a zip file.
		
		****-- Design patterns add to our engineering solutions---***
		


Question Properties File

Key : Value

What is the key? 
	- it is used for looking up the value
	- must be unique?
	
What is the value?
	-
	
Can use "key : value", where the value contains delimiters for to separate the fields?

(key:value) = (cd-prodID:"name-artist-price-quantity")

Lesson begins:

Chapter 8
	- fig 08_01_02
	- IMPRTANT: is the use of 'private' keywords for the data elements, data should always 
	be accessed through public methods.
	- this.hour = hour; 	// preferred way of presenting instance variable, should always follow this formation
	- 'this' reference is something that all non-static methods get
	- 
	
	-- to wire all the MVC components together, you could have a constructor that instantiates 
	the methods in another 
	
	In the main, this is the best way to start the MVC to make sure they are all wired together
	
	Recommended way :: MyInventoryApp, is better than MyInventoryMain because it shows it is the app
	
	*** read supplementary material, contains information about the way to start the program below
	
	Model model = new Model();
	Controller controller = new Controller(model);
	View view = new View(controller);
	model.setView(view);
	
	view.setModel(model);
	
	view.start();
	
	*********************
	
	???? Robert --> Must have double dispatch communications between view and model. 
	
	--recommended as a best practice:  should implement a toString method in all "non-trivial" classes.
	
	Chapter 8 cascading constructors fig: 8.5.6
	
	fig 8.8
	Object composition:
	Employee has, first_name, last_name, DOB, hire_date
	
	Static variables "sticks" to the class
		- static variable is not an instance variable, it stays with the class
		- instance variable make copies of each variable for each object.
		- most often used to count the number of objects have been instantiated
		- static methods are 'class only' methods
		- the preferred way to call a static method is to use the class name to call the static method
		 	e.g Employee.getCount(); if called in this context shows it is a static method by the capitalized class name
		 	
 		- fig 08_15 package access variables without specifiers become package access by default, this is not preferred
	
	Chapter 9 - inheritance
	- recommended to use the @Override annotation when overriding a method. This will allow the JVM to notify you
	when compiling the code that there is nothing to override. this is very important.
	- polymorphism tests 
	
	- abstract keyword, why use it?
		- non instantiatable class, where the methods have no functionality
		- a little like an interface, you want to benefit from what that class can represent, but your class does not 
		provide the full solution, therefore you don't want people to create objects from an incomplete class.
		- serves to provide abstractions
		- Why would you ever have a abstract class at the bottom of a hierarchy
			- when creating a framework for other developers to use
			- creating the bare-bones for  an application, however this is unfinished.
			- to use the abstract class, the person needs to extend the class to use the objects of that class.
	- interface fig 10.11 (Payable)
		- convention is to use ....able or ....ible in the name. 
		- implies the notion that this interface provides a set of abilities.
		- 
	== implements is an extension of a method, however if the class specifier is abstract then this is not an actual
	class that implements that 'implements' class until the class specifier is 'class' then that is actually a concrete class
	
	
	READ: some answers to questions regarding MVC
	resources/supplemental materials
	- clarification is also more reading,
	- read FAQ from answer questions from students.
	
	
	Jar	 - The Jar utility
	
	located
	# /usr/local/java/jdk1.8.0_91/bin
	
	Creating a jar file:
	# jar -cvf jarFile path[path][...]
	
	List the contents of the jarFile
	# jar -tvf jarFile [path][..]
	
	Extract the contents of the jarFile
	# jar -xvf jarFile [path][..]
	
	Example:
	
	create:
	jar cvf MySpiffyApp.jar MySpiffyApp
	
	after creation, to list the contents:
	jar tvf MySpiffyApp.jar
	
	to make runnable create a manifest file = MANIFEST.MF
	
	Main-Class: MySpiffyApp.MyAppClassName
	
	MySpiffyApp = package name
	MyAppClassName = is the name of the Main class
	
	inject the manifest file
	# jar -cvmf MANIFEST.MF MySpiffyApp.jar MySpiffyApp
	
	run 
	# java -jar MySpiffyApp.jar
	
	
	============================================================
	Example (can't seem to make this work with packages)
	
	1. create a project name
	2. inside create 2 folders, 
		classes
		source
	3. Copy all the *.java to the "source" folder (remove all the package references at the beginning of each file)
	4. go to command line, and compile .java to .classes and place into the ../classes folder
		# javac -d ../classes *.java
	5. 	In the classes directory, create a file called manifest.txt containing the file with the 'main' class
	
	-> 
	Main-Class: InventoryProgramMainApp

	6. From inside your classes/ type:
	# jar -cvmf manifest.txt InventoryProgramMainApp.jar *.class
	
	added manifest
	adding: InventoryBOOK.class(in = 1020) (out= 448)(deflated 56%)
	adding: InventoryCD.class(in = 1023) (out= 443)(deflated 56%)
	adding: InventoryDVD.class(in = 1021) (out= 450)(deflated 55%)
	adding: InventoryItems.class(in = 975) (out= 460)(deflated 52%)
	adding: InventoryProgramController.class(in = 1431) (out= 618)(deflated 56%)
	adding: InventoryProgramMainApp.class(in = 778) (out= 466)(deflated 40%)
	adding: InventoryProgramModel.class(in = 2055) (out= 897)(deflated 56%)
	adding: InventoryProgramPersistance$1.class(in = 774) (out= 458)(deflated 40%)
	adding: InventoryProgramPersistance.class(in = 7925) (out= 4123)(deflated 47%)
	adding: InventoryProgramPersistance$ItemType.class(in = 1068) (out= 535)(deflated 49%)
	adding: InventoryProgramStoreOperations.class(in = 494) (out= 231)(deflated 53%)
	adding: InventoryProgramView.class(in = 4209) (out= 2104)(deflated 50%)
	adding: Observer.class(in = 251) (out= 201)(deflated 19%)
	adding: Subject.class(in = 1012) (out= 591)(deflated 41%)

	
	7. execute:
	java -jar InventoryProgramMainApp.jar

		
	List: # jar -tvf MVCCalculator.jar


*/