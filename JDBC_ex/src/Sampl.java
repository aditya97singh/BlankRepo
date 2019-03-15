import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sampl {

	public static void main(String[] args) {
		
		try{
		   Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");

		//Prepared Statement
		String sql="update Details_1 set age=? where rollno=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setInt(1,21);
		stmt.setInt(2,1);
		
		int rows = stmt.executeUpdate();
	      System.out.println("Rows impacted : " + rows );
		
	    //Query to print  
	     
	    sql="select * from Details_1";
	    PreparedStatement s=con.prepareStatement(sql);
		ResultSet rs=s.executeQuery();
		
		while(rs.next()){
			   //Retrieve by column name
	         int r  = rs.getInt("rollno");
	         int age = rs.getInt("age");
	         String name = rs.getString("name");
	         String d = rs.getString("dept");

	         //Display values
	         System.out.print("ID: " + r);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + name);
	         System.out.println(", Last: " + d);
		}
		rs.close();
		stmt.close();
		con.close();
	}catch(Exception e){
		e.printStackTrace();;
	}

}
}
