package oop11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIinterface implements ActionListener {

	private JButton Run, RunSep, savecmd;
	private JTextField tf, tf2;
	private JMenuItem new1, open, save, exit , about;
	private JPanel p;
	private JMenu m1, m2;
	private MainClass tg;
	private JFrame frame;
	boolean b = false;
	JMenuBar mb;
	FileWriter fw;

	public GUIinterface() {

		tg = new MainClass();

		frame = new JFrame("Turtle Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);

		tg.setSize(200, 200);

		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Help");
		about = new JMenuItem("About");

		open = new JMenuItem("Open");
		save = new JMenuItem("Save as");
		exit = new JMenuItem("Exit");
		new1 = new JMenuItem("New");

		m2.add(about);

		mb.add(m1);
		mb.add(m2);

		m1.add(open);
		m1.add(save);
		m1.add(exit);
		m1.add(new1);

		m2.add(about);

		p = new JPanel();

		JLabel l = new JLabel("Enter single command");
		JLabel l1 = new JLabel("Enter multiple commands");
		tf = new JTextField(10);
		tf2 = new JTextField(10);

		Run = new JButton("Send");
		RunSep = new JButton("run together");
		savecmd = new JButton("save commands");

		p.add(l);
		p.add(tf);
		p.add(Run);
		p.add(RunSep);
		p.add(l1);
		p.add(tf2);
		p.add(savecmd);

		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.getContentPane().add(BorderLayout.CENTER, tg);
		frame.getContentPane().add(BorderLayout.SOUTH, p);

		frame.setVisible(true);

		frame.setResizable(true);

		Run.addActionListener(this);

		RunSep.addActionListener(this);

		about.addActionListener(this);

		save.addActionListener(this);

		open.addActionListener(this);

		new1.addActionListener(this);

		exit.addActionListener(this);

		savecmd.addActionListener(this);

	}

	public static void main(String[] args) {
		new GUIinterface();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Run) {
			if (tf.getText().contains("penup")) {
				tg.penUp();
			} else if (tf.getText().contains("pendown")) {
				tg.penDown();
			} else if (tf.getText().contains("turnleft")) {
				String Line = tf.getText();
				try {
					String value = Line.replaceAll("[^0-9]", "");
					int temp = Integer.parseInt(value);
					tg.turnLeft(temp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
				}
			} else if (tf.getText().contains("turnright")) {
				String Line = tf.getText();
				try {
					String value = Line.replaceAll("[^0-9]", "");
					int temp = Integer.parseInt(value);
					tg.turnRight(temp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
				}
			} else if (tf.getText().contains("forward")) {
				String Line = tf.getText();
				try {
					String value = Line.replaceAll("[^0-9]", "");
					int temp = Integer.parseInt(value);
					tg.forward(temp);
					b = false;
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
				}

			} else if (tf.getText().contains("backward")) {
				String Line = tf.getText();
				try {
					String value = Line.replaceAll("[^0-9]", "");
					int temp = Integer.parseInt(value);
					tg.turnLeft(180);
					tg.forward(temp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
				}
			} else if (tf.getText().contains("green")) {
				tg.setPenColour(Color.GREEN);
			} else if (tf.getText().contains("blue")) {
				tg.setPenColour(Color.BLUE);
			} else if (tf.getText().contains("yellow")) {
				tg.setPenColour(Color.YELLOW);
			} else if (tf.getText().contains("circle")) {
				String Line = tf.getText();
				try {
					String value = Line.replaceAll("[^0-9]", "");
					int temp = Integer.parseInt(value);
					tg.circle(tg.getGraphicsContext(), temp, Color.BLUE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
				}

			} else if (tf.getText().contains("about")) {
				tg.about(tg.getGraphicsContext());
			} else if (tf.getText().contains("reset")) {
				tg.reset();
				tg.clear();
			} else if (tf.getText().contains("clear")) {
				tg.clear();
			}

			else {
				JOptionPane.showMessageDialog(frame, "incorrect command");
			}

			tg.repaint();
			tf.setText("");

		}

		else if (e.getSource() == RunSep) {
			Scanner sc = new Scanner(tf2.getText());
			tg.penDown();
			while (sc.hasNext()) {
				String line = sc.next();
				String split2[] = line.split("-");
				int length = split2.length;
				int i = 0;
				for (i = 0; i < length; i++) {

					if (split2[i].contains("forward")) {
						String Line = split2[i];
						try {
							String value = Line.replaceAll("[^0-9]", "");
							int temp = Integer.parseInt(value);
							tg.forward(temp);
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
						}
					} else if (split2[i].contains("backward")) {
						String Line2 = split2[i];
						try {
							String value2 = Line2.replaceAll("[^0-9]", "");
							int temp2 = Integer.parseInt(value2);
							tg.turnLeft(180);
							tg.forward(temp2);
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
						}

					} else if (split2[i].contains("penup")) {
						tg.penUp();
					} else if (split2[i].contains("pendown")) {
						tg.penDown();

					} else if (split2[i].contains("turnright")) {

						String Line3 = split2[i];
						try {
							String value3 = Line3.replaceAll("[^0-9]", "");
							int temp3 = Integer.parseInt(value3);
							tg.turnRight(temp3);
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
						}

					} else if (split2[i].contains("turnleft")) {

						String Line4 = split2[i];
						try {
							String value4 = Line4.replaceAll("[^0-9]", "");
							int temp4 = Integer.parseInt(value4);
							tg.turnLeft(temp4);
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(frame, "INCORRECT PARAMETERS");
						}

					} else if (split2[i].contains("green")) {
						tg.setPenColour(Color.GREEN);
					} else if (split2[i].contains("red")) {
						tg.setPenColour(Color.RED);
					} else if (split2[i].contains("yellow")) {
						tg.setPenColour(Color.YELLOW);
					} else if (split2[i].contains("reset")) {
						tg.reset();
					} else if (split2[i].contains("clear")) {
						tg.clear();
					} else {
						JOptionPane.showMessageDialog(frame, "incorrect command");
					}

					tg.repaint();
					tf2.setText("");

				}
			}
		} else if (e.getSource() == about) {
			JFrame abt = new JFrame();
			abt.setSize(400, 400);
			abt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			abt.setVisible(true);

			p = new JPanel();

			JPanel p1 = new JPanel();

			abt.getContentPane().add(BorderLayout.NORTH, p);
			abt.getContentPane().add(BorderLayout.SOUTH, p1);

			JTextArea a = new JTextArea();

			a.setText("-Instructions- \n "
					+ "The way to use this program is to enter your command from those i will specify below , the turtle can do many things and move in many directions;\n"
					+ "forward<distance> - will move the turtle forward by specified distance\n"
					+ "Backward<distance> - will move turtle back by sepcified distance\n"
					+ "turnright<degree> - turn right by sepcified degrees\n"
					+ "turnleft<degrees> - turn left specified degrees\n" + "about - special graphics \n"
					+ "circle<radius> - make a circle with sepcified radius \n"
					+ "yellow , blue , green - change pen colour \n" + "penup - wont draw on screen \n"
					+ "penddown - will draw on screen \n" + "reset - reset the turtle to original position \n"
					+ "clear - will clear the drawings \n" + "below is what the image with graphics looks like:");

			JLabel j = new JLabel();
			Image i = new ImageIcon(this.getClass().getResource("turtlegraphicsdemotest1.jpg")).getImage();
			j.setIcon(new ImageIcon(i));
			j.setSize(100, 200);
			p.add(a);
			p1.add(j);

		} else if (e.getSource() == open) {

			if (b == false) {
				JOptionPane.showMessageDialog(frame, "file not saved go back and save.");
			} else if (b == true) {
				JFileChooser fc = new JFileChooser("C:\\Users");

				int userselection = fc.showOpenDialog(frame);
				BufferedImage image = null;

				if (userselection == JFileChooser.APPROVE_OPTION) {
					File filename = fc.getSelectedFile();

					try {
						image = ImageIO.read(filename);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					JLabel lbl = new JLabel();
					lbl.setSize(600, 400);
					lbl.setIcon(new ImageIcon(image));
					frame.remove(tg);
					frame.getContentPane().add(BorderLayout.CENTER, lbl);
					frame.pack();
					frame.setVisible(true);
				}
			}

		} else if (e.getSource() == save) {
			JFileChooser fc = new JFileChooser("C:\\Users");

			int userselection = fc.showSaveDialog(frame);

			if (userselection == JFileChooser.APPROVE_OPTION) {
				File filename = fc.getSelectedFile();
				try {
					BufferedImage image = new BufferedImage(tg.getWidth(), tg.getHeight(),
							BufferedImage.TYPE_4BYTE_ABGR);
					tg.paint(image.getGraphics());
					ImageIO.write(image, "png", filename);
					b = true;
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getSource() == exit) {
			if (b == true) {
				System.exit(0);

			} else {
				JOptionPane.showMessageDialog(frame, "file not saved go back and save.");
			}

		} else if (e.getSource() == new1) {
			tg.reset();
			tg.clear();

		}

	}
}
