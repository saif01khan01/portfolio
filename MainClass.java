package oop11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import uk.ac.leedsbeckett.oop.TurtleGraphics;

public class MainClass extends TurtleGraphics {

	String str = "SAIF KHAN";

	public void circle(Graphics g, int radius, Color f) {

		reset();
		g.setColor(f);
		g.drawOval(100, 100, radius * 2, radius * 2);
		setxPos(100);
		setyPos(100);
		turnLeft(90);
		forward(50);
	}

	public void setCircleColour(Color f) {

	}

	public void about(Graphics g) {
		g.setColor(Color.GREEN);
		Font stringFont = new Font("SansSerif", Font.BOLD, 50);
		g.setFont(stringFont);
		g.drawString(str, 275, 50);

		reset();

		setxPos(400);
		setyPos(200);

		penDown();
		forward(100);
		turnRight(90);
		forward(100);
		turnRight(90);
		forward(100);
		turnRight(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnLeft(45);
		forward(145);
		turnLeft(135);
		forward(100);
		turnLeft(45);
		forward(130);

	}

}
