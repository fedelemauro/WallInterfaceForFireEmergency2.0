package KyraWallTouch.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenteDAO {




    public Agente doRetrieveById(int id)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM agente WHERE idagente=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Agente s = new Agente();
                s.setId(rs.getInt(1));
                s.setNome(rs.getString(2));
                s.setLatitudine(rs.getString(3));
                s.setLongitudine(rs.getString(4));
                s.setSalute(rs.getString(5));
                s.setEta(rs.getInt(6));
                return s;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Agente> doRetrieveAll()
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM agente");
            List<Agente> agenti= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Agente s = new Agente();
                s.setId(rs.getInt(1));
                s.setNome(rs.getString(2));
                s.setLatitudine(rs.getString(3));
                s.setLongitudine(rs.getString(4));
                s.setSalute(rs.getString(5));
                s.setEta(rs.getInt(6));
                agenti.add(s);
            }
            return agenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
