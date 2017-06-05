package mvctemperature;

/**
 * controller for CelsiusGUI
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

class CelsiusGUI extends TemperatureGUI
{	
	public CelsiusGUI(TemperatureModel model, int h, int v)
	{	
		super("Celsius Temperature", model, h, v);
		setDisplay("" + model.getC());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
	}
	
	public void update(Observable t, Object o) // Called from the Model
	{	
		setDisplay("" + model().getC());
	}
	
	class UpListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			model().setC(model().getC() + 1.0);
		}
	}
	
	class DownListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			model().setF(model().getC() - 1.0);
		}
	}
	
	class DisplayListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			double value = getDisplay();
			model().setF(value);
		}
	}
}