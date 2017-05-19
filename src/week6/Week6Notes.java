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

=========LINUX=============

configure MySql environment

1. Download from MySql
2. follow instructions from here: https://dev.mysql.com/doc/refman/5.5/en/binary-installation.html

On Linux: A temporary password is generated for root@localhost: YNeB<ypzE7cz

http://www.yolinux.com/TUTORIALS/LinuxTutorialMySQL.html
mysql root user password = mysql

Start MySQL service:
# /etc/init.d/mysqld start


Accessing DB
# mysql -u root -p mysql -h localhost

Setting root password:
# mysqladmin -u root password mysql


Troubleshooting
http://stackoverflow.com/questions/6445917/connect-failed-access-denied-for-user-rootlocalhost-using-password-yes
http://www.yolinux.com/TUTORIALS/LinuxTutorialMySQL.html
http://www.elated.com/articles/mysql-for-absolute-beginners/

=========MAC=============

https://blog.joefallon.net/2013/10/install-mysql-on-mac-osx-using-homebrew/

start service:
mysql.server start
mysql.server status


Install with Brew on MAC:
brew doctor
brew update
brew install mysql
unset TMPDIR
mysqld -initialize --verbose --user=whoami --basedir="$(brew --prefix mysql)" --datadir=/usr/local/var/mysql --tmpdir=/tmp <- only use this for El Capitan!, not completely sure what you should use otherwise
mysql.server start
brew services start mysql

==========MYSQL=================

https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial

=====Preparing to connect=====
https://www.youtube.com/watch?v=2i4t-SL1VsU

Method:
1. Add MySQL database driver to classpath
2. Get Connection
3. Submit SQL Query
4. Process result set

=====Preparing DB===

> show databases;

> create database demo;

> use demo;

> show tables;

> create table employees (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> last_name varchar(30),
    -> first_name varchar(20),
    -> email varchar(30));

> show tables;

> describe employees;


Insert:
> INSERT INTO `employees` (`last_name`,`first_name`,`email`) VALUES ("Doe", "John", "John_Doe@foo.com");
> INSERT INTO `employees` (`last_name`,`first_name`,`email`) VALUES ("Public", "Mary", "Mary_Public@youtwit.com");
> INSERT INTO `employees` (`last_name`,`first_name`,`email`) VALUES ("Queue", "Susan", "Susan_Queue@waddatube.com");

=====EXPORT/IMPORT DATA TO .sql file=========================

http://www.deitel.com/Books/Java/JavaHowtoProgram8eEarlyObjectsVersion/UpdatedMySQLSetupInstructions/tabid/3631/Default.aspx

Export entire DB:
# mysqldump -u root -p demo > demo.sql

Export ALL DB's:
# mysqldump -u root -p --all-databases > all_db_backup.sql

Export specific tables within a DB:
# mysqldump -u root -p db_name table1 table2 > table_backup.sql

Remotely;
# mysqldump -P 3306 -h [ip_address] -u [uname] -p[pass] db_name > db_backup.sql

Import:
# mysqldump -u root -p books < books.sql

mysql -u username -p -h localhost DATA-BASE-NAME < data.sql




*/





