import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Sql {

	String NAME;
	int MARKS;
	int ROLL_NO;

	int COLUMN;
	int ROW;
	String s[][];

	public String[][] Sql1(String choice, String text) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String userName = "root";
			String password = "root";

			String url = "jdbc:mysql://localhost:3306/test";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();// This is the newest driver
			conn = DriverManager.getConnection(url, userName, password);
		
			stmt = conn.createStatement();

			stmt.execute("select count(*) from students");
			rs = stmt.getResultSet();
			while (rs.next()) {
				ROW = Integer.parseInt(rs.getString("count(*)"));
			}

			if (text.equals("math")) {
				if (choice == "Ascending") {
					stmt.execute(
							"select s.Name,s.Roll_No,m.Marks from students s INNER JOIN math m ON m.Roll_No=s.Roll_No ORDER BY marks ASC;");
				} else {
					stmt.execute(
							"select s.Name,s.Roll_No,m.Marks from students s INNER JOIN math m ON m.Roll_No=s.Roll_No ORDER BY marks DESC;");
				}
			} else if (text.equals("physics")) {
				if (choice == "Ascending") {
					stmt.execute(
							"select s.Name,s.Roll_No,m.Marks from students s INNER JOIN physics m ON m.Roll_No=s.Roll_No ORDER BY marks ASC;");
				} else {
					stmt.execute(
							"select s.Name,s.Roll_No,m.Marks from students s INNER JOIN physics m ON m.Roll_No=s.Roll_No ORDER BY marks DESC;");
				}
			}

			rs = stmt.getResultSet();

			String marks = "", name = "", n3 = "";
			s = new String[ROW][3];
			int i = -1, j = -1;
			while (rs.next()) {
				i++;
				n3 = (rs.getString("Roll_No"));
				name = rs.getString("Name");
				marks = rs.getString("marks");
				j++;
				s[i][j] = n3;
				j++;
				s[i][j] = name;
				j++;
				s[i][j] = marks;
				j = -1;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}

}
