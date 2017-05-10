package week5;

public class Week5Notes
{
	
}
/*


Exception handling and Generics

Exception Handling Chapter 11

Why do we care about crashed programs?
Some applications are mission-critical apps where the program can not crash and needs to handle the error condition
- factories producing stuff
- stock broker
- Special Ops in the field

Aims to keep a program running where it handles the errror condition without totally stopping the program operation

Heirarchy tree on Fig 11.4 p 452

Checked exceptions or UnChecked Exceptions
-runtime errors = UnChecked exceptions
-array-out-of-bounds

UnChecked Exceptions usually exposes errors in the coders error


Checked Exceptions are run-time exceptions




Fig 11.2 : DivideByZero => error
Fig 11.3 throws Arithemetic exception and a try/catch block

Usually all executable code is in the 'try' section of the try/catch block


fig 11.5
Line 20;

Try/Catch/Finally

Finally: get's executed ALWAYS, even when leaving the method. Usually used to close() or release resources.
It's the "no-matter-what" method


fig 11.6


*** NOTE: Exceptions, make sure the most specific exceptions are caught first and the ones that are more general are a catch all for last.


Chained Exceptions 
fir 11.7

This can be used is a logging mechanism. where one exception takes in the return from the previous exception so this is
an additional exception additions


Making your own exception class
- should have many constructors (4),
- 1, should have a default constructor without any input, in case there is none.
- is should call super, and pass any string to the parent exception class
- 2, should also support taking string
- 3, constructor to take a reference to an exceptions
- 4, 2 parameters, a string
- no instance variables, because there is no need to maintain state.

Asserts: (11.11)
- one of the coolest java features that is almost never used.
- 
fig 11.8, line 15, if = true, OK, if = false, then return : bad number

------------------------------
Generic Classes and Methods
Chapter 20:

Fig 20.1 
Only difference here it type

Generic allows us to paramatize for data types

public static <T> void printArray(T[] inputArray)

Fig 20.3 line 22
Explanation was: Common Programming Error 20.1

Generics is a way to move beyond overloading by using generics
Generics is probably a better way of coming up with a solution, rather then to use overloading.


Fig 20.5


Fig 20.7

maximum is a generic method

Fig 20.7
Stack

Ternaiy assignment operator
? asks expressjion imieiately to the left left is true, 

if capacity is no greaater to 0 then use the lh side, if it is greater use the rh side


fig 20.10



NB**** Don't use Raw types, if you have a choice between generics or objects, do not use Raw types


fig 20.14
? = wildcard

T = type, it is what it is and it has to be the same type

Next time is JDBC
JTable for 3rd assignment

-------------

talking about assignment 2

JList, or JTable


*/