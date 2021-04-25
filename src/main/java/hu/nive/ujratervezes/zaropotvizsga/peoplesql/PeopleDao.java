package hu.nive.ujratervezes.zaropotvizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        String ip = "";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")){
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ip = rs.getString("ip_address");
                }
                return ip;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("no database", sqlException);
        }
    }
}
