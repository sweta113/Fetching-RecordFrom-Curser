/* Code to fetch all records from the Curser by using ResultSet interface*/
package org.jdbc.fetchApp;

import java.sql.*;

public class FetchData {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select*from data.student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class load and registerd");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with db server");
			
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform created");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println(id+" "+name+" "+perc);
			}
 		  } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Closed all costly resources");
		}
	}

}
