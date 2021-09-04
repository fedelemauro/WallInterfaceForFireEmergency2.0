package KyraWallTouch.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinateDAO {

    public Segnalazione doRetrieveByComune(Segnalazione segnalazione)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM coordinate WHERE comune=?");
            ps.setString(1, segnalazione.getCitta());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String lat = rs.getString(2);
                String primi = lat.substring(0,2);
                String ultimi = lat.substring(2);
                lat=primi+"."+ultimi;


                String lng = rs.getString(3);
                primi = lng.substring(0,2);
                ultimi = lng.substring(2);
                lng= primi+"."+ultimi;

                segnalazione.setLatitudine(lat);
                segnalazione.setLongitudine(lng);

                return segnalazione;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
