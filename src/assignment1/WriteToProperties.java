package assignment1;

/**
 * Working with propertied
 * https://www.youtube.com/watch?v=w7D5YB2U2jU
 */

import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;



public class WriteToProperties  //verb in a class name : change to persistance (noun, verbs are actions)
{
	public static void main(String[] args) throws Exception
	{
		Properties p = new Properties();
		

		/*
		// 1. write to a properties file
		OutputStream os = new FileOutputStream("dataConfig.properties");
		
		// set properties
		p.setProperty("url", "localhost:3306/myDB");
		p.setProperty("uname", "bobby");
		p.setProperty("passwd", "letmein!");
		
		// push to properties properties file
		p.store(os, null);
		*/
		
		
		// 2. read from properties file
		FileInputStream is = new FileInputStream("dataConfig.properties"); 
		
		// load property file
		p.load(is);
		
		System.out.println(p.getProperty("uname"));
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("passwd"));
		
		System.out.println("\nLets try listing all the properties\n");
		p.list(System.out);
		
		
	}
}