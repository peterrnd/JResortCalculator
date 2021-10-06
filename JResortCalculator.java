// Exercise on page 745-746

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{

	// Instance variables for this class
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	JCheckBox weekendBox = new JCheckBox("Weekend premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast premium $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf Premium $" + GOLF_PREMIUM, false);
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE);
	JLabel optionExplainLabel2 = new JLabel("Check off any add-ons you wish.");
	JLabel priceLabel = new JLabel("The price for your stay is:");
	JTextField totPriceField = new JTextField(4);

	// Custom constructor for this class
	public JResortCalculator()
	{
		super("Resort Price Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(totPriceField);

		// When app loads, set the totalPrice into the field
		totPriceField.setText("$" + totalPrice);

		// Add event listeners to the check boxes
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);

	}

	// Event handling method 734-735 (list of event listeners)
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		// IF Statement that decides which checkbox was the source of the ItemEvent
		if(source == weekendBox)
		{
			// Now that we know the source, decide if the check box is selected or not
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if(source == breakfastBox)
		{
			// Now that we know the source, decide if the check box is selected or not
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		else
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}

		totPriceField.setText("$" + totalPrice);
	}


	public static void main(String[] args)
	{
		JResortCalculator aFrame = new JResortCalculator();
		aFrame.setSize(300, 200);
		aFrame.setVisible(true);
	}
}