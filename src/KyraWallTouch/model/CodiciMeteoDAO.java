package KyraWallTouch.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodiciMeteoDAO {

    public String doRetrieveByComune(String citta)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM meteo WHERE comune=?");
            ps.setString(1, citta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String code = rs.getString(1);
                return code;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
