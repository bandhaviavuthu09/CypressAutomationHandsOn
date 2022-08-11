package DBConnection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsontoJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		ArrayList<CustomerDetails> al = new ArrayList<CustomerDetails>();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","admin");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from CustomerInfo where location = 'Asia' and purchaseDate=curdate();");
		CustomerDetails cd = new CustomerDetails();
		ObjectMapper om = new ObjectMapper();
		/*
		 * while(rs.next()) { System.out.println(rs.getString(1));
		 * System.out.println(rs.getString(2)); System.out.println(rs.getString(3));
		 * System.out.println(rs.getString(4)); }
		 */
		
		while(rs.next()) {
			cd.setCourseName(rs.getString(1));
			cd.setPurchaseDate(rs.getString(2));
			cd.setAmount(rs.getInt(3));
			cd.setLocation(rs.getString(4));
			System.out.println(cd.getCourseName());
			System.out.println(cd.getPurchaseDate());
			System.out.println(cd.getAmount());
			System.out.println(cd.getLocation());
			al.add(cd);
		}
		
		for(int i=0;i<al.size();i++) {
			om.writeValue(new File("C:\\Users\\002TQO744\\TestArchitectTraining\\JDBCConnection\\customerInfo"+i+".json"), al.get(i));
		}

		
		con.close();
	}

}
