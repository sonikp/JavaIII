package week4;
// fig 22.3

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class OvalSliderFrame extends JFrame
{
	private final JSlider diameterJSlider;	// slider to select diameter
	private final OvalSliderPanel myPanel;
	
	public OvalSliderFrame() 
	{
		super("Slider Demo");
		
		myPanel = new OvalSliderPanel();	// create panel to draw circle
		myPanel.setBackground(Color.YELLOW);
		
		// set up JSlider to control diameter
		diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		diameterJSlider.setMajorTickSpacing(10);
		diameterJSlider.setPaintTicks(true);
		
		// register JSlider event listener
		diameterJSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent event) {
				// handle change in slider value
				myPanel.setDiampeter(diameterJSlider.getValue());
				
			}
		});
		
		add(diameterJSlider, BorderLayout.SOUTH);
		add(myPanel,BorderLayout.CENTER);
		
	}
}































