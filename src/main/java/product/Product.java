package product;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class Product {

		
		void createData() throws SQLException {

			Connection connection=ConnectDBProduct.setupConnection();

			String query

	        = "INSERT INTO Product( id, name, cost, descrip  ) VALUES(?,?,?,?)";

			PreparedStatement myStmt = connection.prepareStatement(query);

		     // Set Parameters

		        myStmt.setInt(1, 888); // ready with Prepared Statement

		        myStmt.setString(2, "Socks");

		        myStmt.setInt(3, 300);

		        myStmt.setString(4, " good");

		        int success=myStmt.executeUpdate();

		        System.out.println("Added Successfully " + success);
		}

		void readData() throws SQLException{

			Connection connection=ConnectDBProduct.setupConnection();

			

			 Statement statement;

			 statement = connection.createStatement();

	        ResultSet resultSet;

	        resultSet = statement.executeQuery(

	            "select * from Product where id>=1");

	        int id;

	        String name;

	        int cost;

	        String descr;

	        while (resultSet.next()) {

	            id = resultSet.getInt("id");

	            name = resultSet.getString("name");

	            cost=resultSet.getInt("cost");

	            descr = resultSet.getString("descrip");

	            System.out.println("id : " + id

	                               + " name : " + name +"  cost:"+ cost +" Descrip:"+ descr);

		       
	            
	        }

		}

	        void updateData() throws SQLException {

	    		Connection connection = ConnectDBProduct.setupConnection();

	    		String query = "update Product set name =? where id=?";

	    		PreparedStatement myStmt = connection.prepareStatement(query);

	    		myStmt.setString(1,"shoes");

	    		myStmt.setInt(2,111);

	    		boolean success = myStmt.execute();

	    		System.out.println("Updated Successfully " + success);
		       


	    	}

	    	void deleteData() throws SQLException {

	    		Connection connection = ConnectDBProduct.setupConnection();

	    		String query = "delete from Product where id = ? ";

	    		PreparedStatement myStmt = connection.prepareStatement(query);

	    		myStmt.setInt(1, 888);

	    		boolean success = myStmt.execute();

	    		System.out.println("Deleted Successfully " + success);

	     

	    	}


	}

