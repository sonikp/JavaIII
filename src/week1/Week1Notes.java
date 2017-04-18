package week1;

public class Week1Notes
{
	public static void main(String[] args)
	{
		System.out.println("JavaIII - Week1");
	}
}

/*

Teacher: Duane Wesley

Sending Syllabus and homework

email: sifuduane@att.net
cell: 858-717-1127

5x quiz's  & 3x assignments


Module 1: MVC 
- chapt 20, 14, 6,8,9

+ component design
+ breaking down complex problems,
+ module carved out to solve problems


Module 2: GUI/swing
- chptr 12,22

Module 3: error handling, generics, Wildcards
- chaptr 11, 16, 21

 Mod 4, JDBC
 - chapt 24
 
 Mod5 multi-threading
 - chapt 23
 


Assignment #1

Basic inventory System, ie borders, 

- Properties class, 
- use: inheritance, polymorphism, and one interface definition, , at least one enumeration
- app will be runnable as a jar

-----class notes--------------

=========MVC===========================

MVC - is a design pattern

isolate the concerns of viewing, controlling and modeling, by separating and 
modularizing things into their own respective components.
- architectural component. 
- each has a well defined interface
- model makes changes as requested by controller,
- view then received notifications that state has changed
- controller is usually stupid and forwards it to the model

- view: presentation to user, receiving i/p, manages presentation layer
- controller: mapping events or queries or state changes of the model
- model: is responsible for maintaining the current state of the system or application

example;
- view =  Jbutton
- controller = registering the button
- model = event handler

- controller = can be used for implementing biz models, auth functions,

- model decouples the function from the 'view' so it doesn't need to know what the 'view' requires
- why go both ways?
	- model = state change
	- view = notification of state change
	 	- updates view after state change
 		- view: state changes, 
 								- model passes all data
 								- view has to check all the data to see what changed
 								- model notifies of the change and what changed (ENUM)
		- could have different update methods
		
		-- "double dispatch relationship"; between view & model => difficult for students to understand
			- need to be both senders and receivers of each other
			- view has to have a reference to it's model, and the model has to have a reference to it's view
		
		-- views and contexts
		
	
	more information:
	http://www.leepoint.net/GUI/structure/40mvc.html
	
	Study:
	https://www.youtube.com/watch?v=Iwwznm9XSME
	
	
	
	========================================================
	
		
	--Maps--
	a map is an interface that declares operations that associate keys/values as data pairs withn a collection
	- HashMap and HashTable, are two classes that extend the Map interface
	- associating key value pairs
	- HashTable class is synchronized, safe for multiple threads to work on it at the same time
	- HashMap class is not
	- HashTable is thread-safe, HashMaps is not
	- thread-safty incurs 
	- HashMap or HashTable is often more convenient than a vector
	- Vector 
	
	--Properties Class---
	- properties class is a persistant hashTable. c
	- configuration properties is a synced hashmap (page14)
	
	--properties file format--
	page 16, forgot VOID type value
	
	exercises: chapter 20, chapter 16 = HashMaps, HashTables, 
	
	properties class: = chapter 16.12 = properties class, learn this example. Also start tweeking this properties file
	--use this as my persistance. This should be hidden, not exposed at the component level
	- model extends properties, this is not the correct way to implement this.
	- model does not have to be a properties. Do not extend
	- model can support different implementations. 
	- do not expose the fact that your model is a properties.
	- model should not have a set properties method. 
	- model should use store, establish that as the method for the model, and the 
	properties should 
	- hide the fact that the model is interfacing the properties file. 
	
	--> learning about design issues and how that impacts the coding
	
	--Enumerations--
	- constants that have a very specialized puropse. ENUMS
	- enums is very much like a class, so the enum are like objects
	- allows you to give values a significant name to understand what their value is.
	enums page 221
	public enum book fig 08_10_11 fig 8.10 page 335 && fig 8.11 page336
	- looks like a class
	- learn examples: craps.java
	
	
	--- advanced polymorphism-----
	- explain polymorphism: 
	- dynamic binding
	
	- review of polymorphism
	- first major princile of OOO
	- 1. encapsulation, the class keyword sets up encapsulation, instance variables and methods for that class
		this provide objects
	- sec major prinvimple of OOO
	- 2. inheritance, => software/code reusability
	- what do you need to define inheritance = need classes, 
	- inheritance depends on encapsulation
	- each class has its own table, each object refers to the table of each class
	
	-- double indirection = this supports polymorphism, a pointer to a pointer
	- objects are what they are, and objects do what they do. This tells you that you are using polymorphism
	- 
	
	
	--- making use of Jar utility
	--sdk/bin
	
	
	--learn how the IDE createds a JAR, also experience the command line version using the JAR. Needs to update the na
	,manifest file, points to the class that has the main method.
	- need to create a package name as part of this exercise
	
	-jar utility makes use of the zip compression utility, so you can look it it with a zip application.
	- jar = zip file
	- can be read with a zip utility
	
	java -jar myspiffyapp.jar
	
	
	all OOO use double indirections to support .... 
	- you can't have polymorphism if you don't have upcasting pointers
	- 
	
	- double dispatch
	- 
	
	- need to do model interfaces
	- have to make sure these are all polymorphic calls
	
	
	
		
		
		
		
		
		





*/