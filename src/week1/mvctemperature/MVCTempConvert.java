package week1.mvctemperature;

/**
 * MainDriver
 * 
 * Reference: http://csis.pace.edu/~bergin/mvc/mvcgui.html
 */

public class MVCTempConvert 
{	
	public static void main(String args[]) 
	{	
		TemperatureModel temperature = new TemperatureModel();
		new FarenheitGUI(temperature, 100, 100);
		new CelsiusGUI(temperature,100, 250);
	}
}