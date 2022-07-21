import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
	private Connection connection;

	public MySQLAdsDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUser(),
					config.getPassword()
			);
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to database", e);
		}
	}

	@Override
	public List<Ad> all() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
			List<Ad> ads = new ArrayList<>();
			while (rs.next()) {
				ads.add(new Ad(
						rs.getLong("id"),
						rs.getLong("user_id"),
						rs.getString("title"),
						rs.getString("description")
				));
			}
			return ads;
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to database", e);
		}
	}

	@Override
	public Long insert(Ad ad) {
		try {
			Statement statement = connection.createStatement();
			String query = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("Inserted a new record! New id: " + rs.getLong(1));
			}
			return ad.getUserId();
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to database.", e);
		}
	}
}
