import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {


    private Connection connection;

    public MySQLAdsDao() throws SQLException {

        //Instantiating the Config object
        Config config = new Config();

        //Registering a new driver.
        DriverManager.registerDriver(new Driver());

        //Making the connection
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );

    }


    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM ads";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {

        long newAdId = 0;

        String query = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d,'%s','%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet ks = stmt.getGeneratedKeys();

            if (ks.next()) {
                newAdId = ks.getLong(1);
            }

            if (newAdId != 0) {
                ad.setId(newAdId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newAdId;
    }
}
