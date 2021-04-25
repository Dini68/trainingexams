package hu.nive.ujratervezes.zaropotpotvizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long getPointsOfHouse(String house) {
        long points = 0;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select points_earned from house_points where house_name = ?");
        ) {
            ps.setString(1, house);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    points += rs.getLong("points_earned");
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("table is not", se);
        }
        return points;
    }
}
