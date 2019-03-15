import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Samp {

	public static void main(String[] args) {

     try{
    	
    	 Class.forName("oracle.jdbc.OracleDriver");
    	 
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");
    	 
 		//Prepared Statement
 		String sql="update Student_1 set city=? where name=?";
 		PreparedStatement stmt=con.prepareStatement(sql);
 		
 		stmt.setString(1,"LKNW");
 		stmt.setString(2,"Aditya");
 		
 		int rows = stmt.executeUpdate();
 	      System.out.println("Rows impacted : " + rows );
 	      
 	   //insert values 
 	   sql="insert into Student_1 values(?,?,?)";
 	   PreparedStatement stmtt=con.prepareStatement(sql);
 	    
 	    stmtt.setInt(1,5);
		stmtt.setString(2,"Vishu");
		stmtt.setString(3,"KNP");
		//stmtt.setDate(5,Date.valueOf("1997-09-22"));
		
	 //   rows = stmtt.executeUpdate();
	   //   System.out.println("Rows impacted : " + rows );
 	
 	    //Query to print  
 	     
 	    sql="select * from Student_1";
 	    PreparedStatement s=con.prepareStatement(sql);
 		ResultSet rs=s.executeQuery();
 		
 		while(rs.next()){
 			   //Retrieve by column name
 	         int r  = rs.getInt("Rno");
 	         String name = rs.getString("Name");
 	         String d = rs.getString("City");

 	         //Display values
 	         System.out.print("ID: " + r);
 	         System.out.print(", Name: " + name);
 	         System.out.println(", City: " + d);
 		}
 		rs.close();
 		stmt.close();
 		con.close();
 	}catch(Exception e){
 		e.printStackTrace();;
 	}

    	 
     }
	}


