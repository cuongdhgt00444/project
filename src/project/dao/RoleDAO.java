/**
 *
 */
package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.Role;

/**
 * @author CuongDH
 *
 */
public class RoleDAO {

    public ArrayList<Role> retrieveRoles() throws SQLException {
        String sqlQuery = "select * from Role";
        Connection connection;
        connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

        statement.executeQuery();

        ResultSet rs = statement.getResultSet();
        ArrayList<Role> roles = new ArrayList<>();
        Role r;
        while (rs.next()) {
            r = new Role();
            r.setRoleId(rs.getInt(1));
            r.setRole(rs.getString(2));

            roles.add(r);
        }

        return roles;
    }
}
