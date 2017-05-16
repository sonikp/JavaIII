package week6;

public class Week6Notes
{
	
}
/*

There is no inheritance relationship between list objects

****Tonight: JDBC and databases	 -	 Chapter 24

Objects can be stored in DB's, and RAW data

Relational Database; table row/column, key/value data relationship
- good way of managing data
- relational DB's are grounded in mathematical thinking
- really fast
- easy to maintain and update, and apply real world changes

-==- relational DB's take data and decompose it, (normalize it), striping it down to its essentials, so to create fundamental/rudimentary data relationships, 
allows SQL to "ask questions" (using SQL queries) about the data that would have previously never been asked.

Looking at examples:


MySQL :: Follow the example below.
Fig 24.23 DisplayAuthors.java, p 1063

Walking through the code
Line 20, is the connection string. DATABASE_URL, "username", "password"
DATABASE_URL = "jdbc:derby:books"

Make sure that the error catches are implemented => catch (SQLException sqlException)

Fig 24.25 = Model component of an MVC architecture.

ResultSetTableModel.java = can be assumed this is the model component 

final = it has not yet been initialized, however, when you finally do initialize it and define the parameters, it can never be changed.

// constructor has all the data elements, user/pwd

Databases are at 1 based, so line 58 is a reference to updating the result to be the same as the java zero based number returns

+++ line 166. this is a good way to disconnect from a database correctly.

fig 24.28 DisplayQueryResults

SELECT * (page 42)

JTable is in the final assignment and it is in the final view, and 

--!!--JFC swing tutorial has a really good JTable section.

EXAMPLES:
https://cs.fit.edu/~mmahoney/cis5100/examples/
http://www.cpesq8.com/wp-content/uploads/2014/12/Java-How-to-Program-Early-Objects-10th.pdf

Different approach:

JDBCRowSetTest.java

http://www.deitel.com/Books/Java/JavaHowtoProgram8eEarlyObjectsVersion/UpdatedMySQLSetupInstructions/tabid/3631/Default.aspx

Example code on this laptop:
/Users/mfloerchinger/Documents/z.JAVA-school/z.JavaProgramming/Java-HowToProgram/deitel_code_examples.zip

*****************************************

This is the MSSQL we want:

Download MySQL Community Server
https://dev.mysql.com/downloads/mysql/


Want MsSQL workbench
:https://www.mysql.com/products/workbench/

Need MsSQL connector:
https://dev.mysql.com/downloads/connector/j/

Need to make sure the connector is in the class path

*****************************************











*/





