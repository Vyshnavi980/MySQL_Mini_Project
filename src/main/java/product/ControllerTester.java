package product;

	import java.sql.SQLException;

	public class ControllerTester {
		
		public static void main(String[] args)throws SQLException {

		Product bl = new Product();
		bl.createData();
		bl.readData();
		bl.deleteData();
		bl.readData();
		bl.updateData();
		bl.readData();
		
		}
	}
