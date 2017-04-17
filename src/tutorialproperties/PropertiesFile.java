package tutorialproperties;

// from: https://www.youtube.com/watch?v=qzP_RQydBJs
// JUnit tests package test.tutorialproperties
// PropertiesFileTest.java

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PropertiesFile
{
	private static final Logger log = Logger.getLogger(PropertiesFile.class.getName());
	private String propertiesFileName;
	private Properties properties;
	public PropertiesFile(String propertiesFileName)
	{
		this.propertiesFileName = propertiesFileName;	
		this.properties = new Properties();
		try
		{
			this.properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
			log.info("Properties file '" + propertiesFileName + "' loaded.");
		}
		catch (IOException e)
		{
			String message =
			          "Exception while reading properties file '" + propertiesFileName + "':" + e.getLocalizedMessage();
			      log.log(Level.SEVERE, message, e);
			throw new RuntimeException(message, e);
		}
	}
	
	public String getProperty(String propertyName)
	{
		String ret = "";
		log.fine("Looking for property '" + propertyName + "'...");
		ret = properties.getProperty(propertyName);
		log.fine("Property value is '" + ret + "'");
		return ret;
	}
	
	public void putProperty(String propertyName, String propertyValue)
	{
		 properties.put(propertyName, propertyValue);
	}
	
	public void save(boolean makeBackup)
	{
		String outputFileName = this.propertiesFileName + ((makeBackup) ? ".bak" : "");
		try 
		{
			
			// Get the CLASSPATH root directory
			String classpathRoot = getClass().getResource("/").getPath();

			// Open an OutputStream to write the properties backup file to
			FileOutputStream fileOutputStream = new FileOutputStream(classpathRoot + File.separator + outputFileName);

			// Write the properties. Use the COPYRIGHT as the comments.
			properties.store(fileOutputStream, fetchCopyright());
		} 
		catch (IOException e)
		{
		    String message = "Exception occurred: " + e.getLocalizedMessage();
		    log.log(Level.SEVERE, message, e);
		}
	}
	
	private String fetchCopyright() throws IOException
	{
		String ret = null;

	    byte[] bytes = Files.readAllBytes(Paths.get("./COPYRIGHT"));

	    ret = new String(bytes);

	    return ret;
	}
	
}