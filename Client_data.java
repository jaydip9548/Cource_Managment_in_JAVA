
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.*;

public class Client_data extends JPanel implements ActionListener {
	static JButton b1;
	static JFrame f;
	static String name,sub,roll,marks;
	static JLabel l2, l3, l4, l5;
	static JTextField t2, t3, t4, t5;

	public Client_data() {
		
//		setBackground(Color.cyan);

		JLabel l1 = new JLabel("Enter Data");
		l1.setFont(new Font("", Font.BOLD, 25));
		l1.setBounds(80, 20, 300, 30);

		l2 = new JLabel("Name :");
		l2.setBounds(65, 80, 130, 20);

		t2 = new JTextField();
		t2.setBounds(130, 80, 120, 20);

		l3 = new JLabel("Subject :");
		l3.setBounds(65, 110, 130, 20);

		t3 = new JTextField();
		t3.setBounds(130, 110, 120, 20);

		l4 = new JLabel("Roll_No :");
		l4.setBounds(65, 140, 130, 20);

		t4 = new JTextField();
		t4.setBounds(130, 140, 120, 20);

		l5 = new JLabel("Marks :");
		l5.setBounds(65, 170, 130, 20);

		t5 = new JTextField();
		t5.setBounds(130, 170, 120, 20);

		b1 = new JButton("Submit");
		b1.setBounds(90, 210, 75, 40);
//		b1.addActionListener(this);
		f.add(b1);

		f.add(l2);
		f.add(l1);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawLine(0, 60, 400, 60);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//name = t2.getText();
// sub = t3.getText();
// roll = t4.getText();
//marks = t5.getText();
		name = "jaydip";
		sub = "Math";
		roll = "555";
		marks = "100";

try {
	Socket s = new Socket("localhost",3333);
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());

	dout.writeUTF(name+" "+sub+" "+roll+" "+marks);

	
	dout.flush();
	dout.close();
	s.close();
	
	}
	

catch(Exception e1) {
	System.out.println(e1);
}

}
	
	
	public static void Fun() {
		f = new JFrame("pp");
		f.setSize(350, 500);
		
		
		f.getContentPane().add(new Client_data());
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	}