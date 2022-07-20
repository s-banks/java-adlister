import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumsDao {
	private Connection connection = null;
	public AlbumsDao() {
		try {
			//Step one, register driver
			DriverManager.registerDriver(new Driver());
			//step 2, create connection
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
					"root",
					"codeup"
			);
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to database", e);
		}
	}

	public List<Album> all() {
		try {
			//step 3, create statement
			Statement stmt = connection.createStatement();
			//ResultSet needs to be handled so we create an instance
			//step 4, execute statement
			ResultSet rs = stmt.executeQuery("SELECT * FROM albums");
			List<Album> albums = new ArrayList<>();
			while (rs.next()) {
				//step 5, interpret results
				albums.add(new Album(
						rs.getLong("id"),
						rs.getString("artist"),
						rs.getString("name"),
						rs.getInt("release_date"),
						rs.getDouble("sales"),
						rs.getString("genre")
				));
			}
			return albums;
		} catch(SQLException e) {
			throw new RuntimeException("Error connecting to database", e);
		}

	}

	public static void main(String[] args) {
		AlbumsDao albumsDao = new AlbumsDao();
		List<Album> albums = albumsDao.all();
		for (Album album : albums) {
			System.out.println(album.getName());
		}
	}
}
