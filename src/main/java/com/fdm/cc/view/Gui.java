package com.fdm.cc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fdm.cc.exceptions.InvalidNumeralException;
import com.fdm.cc.model.EvaluateNumeral;

public class Gui {
	
	private JFrame frame = new JFrame("Roman Numerals");
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JTextField tfInput = new JTextField(10);
	private JButton btnConvert = new JButton("Convert");
	private JLabel lblResult = new JLabel("Decimal value: 0");
	private EvaluateNumeral en = new EvaluateNumeral();
	
	public Gui() {
		setupComponents();
		addListeners();
	}

	private void setupComponents() {
		tfInput.setText("Roman numeral...");
		tfInput.select(0, 100);
		pnlNorth.add(tfInput);
		pnlNorth.add(btnConvert);
		pnlNorth.add(lblResult);
		pnlSouth.add(lblResult);
		frame.setLayout(new BorderLayout());
		frame.add(pnlSouth, BorderLayout.SOUTH);
		frame.add(pnlNorth, BorderLayout.NORTH);
	}

	private void addListeners() {
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertInput();
			}
        });
		
		tfInput.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					convertInput();
			}
		});
	}
	
	/**
	 * Takes the input string from the text field, converts it to
	 * decimal and sets the label to show this result.
	 */
	private void convertInput() {
		String input = tfInput.getText().toUpperCase();
		int decimal;
		try {
			decimal = en.convertNumeral(input);
			lblResult.setText("Decimal value: "+decimal);
		} catch (InvalidNumeralException ine) {
			lblResult.setText("Decimal value: Invalid input");
		}
	}

	public void launchFrame(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(225, 100);
	}

}
