import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pro_ex {

	public static void main(String[] args) {
		
		try{
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");
			
			//Callable statement
			
			String sql=null;
			CallableStatement stmt=con.prepareCall("{call insertR(?,?)}"); 
			
			stmt.setInt(1,1011);  
			stmt.setString(2,"Amit");  
			stmt.execute();  
			  
			int rows = stmt.executeUpdate();
	 	      System.out.println("Rows impacted : " + rows );  
	 	      
	 	    //Display Values  
	 	     sql="select * from Users_1";
	 	    CallableStatement s=con.prepareCall(sql); 
	  		ResultSet rs=s.executeQuery();
	  		
	  		while(rs.next()){
	  			   //Retrieve by column name
	  	         int r  = rs.getInt("id");
	  	         String name = rs.getString("Name");

	  	         //Display values
	  	         System.out.print("ID: " + r);
	  	         System.out.print(", Name: " + name);
	  		}
	  		rs.close();
	  		stmt.close();
	  		con.close();
			 
			
		}catch(Exception e){
		  e.printStackTrace();
		}
		}

	

}


/*

SQL> set serveroutput on
SQL> create or replace procedure "INSERTR"
  2  (id IN NUMBER,name IN VARCHAR2)
  3  IS
  4  begin
  5  insert into Users_1 values(id,name);
  6  end;
  7  /

*/