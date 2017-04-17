package test.tutorialproperties;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tutorialproperties.PropertiesFile;

public class PropertiesFileTest {

	private PropertiesFile classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new PropertiesFile("test.properties");
	}

	@Test
	public void testGetProperty() {
		String propertyName = "property1";
		String expectedPropertyValue = "property1Value";
		String actualPropertyValue = classUnderTest.getProperty(propertyName);
		
		assertEquals(expectedPropertyValue, actualPropertyValue); //expectedPropertyValue
		
	}

	@Test
	public void testPutProperty() {
		String propertyName = "dynamicProperty";
		
		classUnderTest.putProperty(propertyName + "1", "value1");
		classUnderTest.putProperty(propertyName + "2", "value2");
		classUnderTest.putProperty(propertyName + "3", "value3");
		classUnderTest.putProperty(propertyName + "4", "value4");
		
		classUnderTest.save(false);
		
		classUnderTest.save(true);
		
	}

}
