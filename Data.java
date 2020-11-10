import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class Data extends JPanel {
	String choice = "";
	static JTextArea t2;
	JLabel l2;
	static JTextField t1;
	JRadioButton r1;
	JRadioButton r2;
	ButtonGroup group;
	static Main m;
	static JPanel p1;

	Data() {
		m = new Main();

		// setLayout(new BorderLayout());
		setBackground(Color.cyan);
		JLabel l1 = new JLabel("Graphical User Interface");
		l1.setFont(new Font("", Font.BOLD, 25));

		l1.setBounds(30, 20, 300, 30);

		l2 = new JLabel("Enter Subject Name:");
		l2.setBounds(35, 80, 130, 20);
		// l2.setForeground(Color.PINK);

		t1 = new JTextField();
		t1.setBounds(160, 80, 120, 20);

		group = new ButtonGroup();

		JLabel l3 = new JLabel("Order :");
		l3.setBounds(110, 110, 80, 30);
		m.f.add(l3);

		r1 = new JRadioButton("Ascending", true);
		r1.setActionCommand(r1.getText());
		r1.setBackground(Color.cyan);

		r1.setBounds(160, 110, 130, 40);

		r2 = new JRadioButton("Discending");
		r2.setActionCommand(r2.getText());
		r2.setBackground(Color.cyan);
		r2.setBounds(160, 140, 130, 40);
		group.add(r1);
		;
		group.add(r2);

		JButton b1 = new JButton("Generate Rank List");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBounds(90, 190, 160, 30);
		p1 = new JPanel();
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub'
				boolean b = true;
				String sqlData[][] = null;
				String text = "";
				text = t1.getText();
				choice = group.getSelection().getActionCommand();

				if (text.equals("Maths") || text.equals("maths") || text.equals("MATHS") || text.equals("math")) {
					text = "math";
				} else if (text.equals("Physics") || text.equals("physics")) {
					text = "physics";
				}
				if (text.equals("")) {

					JOptionPane.showMessageDialog((m.f), "Enter Subject Name");
				} else if (choice.equals("")) {
					JOptionPane.showMessageDialog((m.f), "Enter Subject Name");
					System.out.println();
				} else if (text.equals("math") || text.equals("physics")) {

					sqlData = new Sql().Sql1(choice, text);

					String column[] = { "Roll_No", "Name", "Marks" };

					JTable tt = new JTable(sqlData, column);
					JScrollPane sp = new JScrollPane(tt);
					sp.setBounds(0, 0, 330, 195);
					sp.setVisible(true);
					p1.add(sp);
					// p1.setBackground(Color.white);
					p1.setBounds(0, 250, 350, 200);
					p1.setVisible(true);

				}
				else {
					JOptionPane.showMessageDialog((m.f), "Enter right subject name");
				}
			}

		});

		m.f.add(p1);
		(m.f).add(r1);
		(m.f).add(r2);

		(m.f).add(t1);

		(m.f).add(l1);
		(m.f).add(l2);

		(m.f).add(b1);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawLine(0, 60, 400, 60);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated ,method stub
//
//		
//
//     
//}

}