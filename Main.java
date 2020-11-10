import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.*;

public class Main {

	static JFrame f;

	public static void main(String[] args) {
		f = new JFrame("pp");
		f.setSize(350, 500);
		f.getContentPane().add(new Data());
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(500, 200);
		f.setVisible(true);

	}
}