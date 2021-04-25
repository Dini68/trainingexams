package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps =
                conn.prepareStatement("select name from dog_types where country = ?" )){
                    ps.setString(1, country);
                    try (ResultSet rs = ps.executeQuery()) {
                        String name = "";
                        while (rs.next()) {
                            name = rs.getString("name");
                            result.add(name.toLowerCase());
                        }
                    }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

