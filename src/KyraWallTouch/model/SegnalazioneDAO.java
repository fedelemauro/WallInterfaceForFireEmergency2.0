package KyraWallTouch.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SegnalazioneDAO {

    public void doSave(Segnalazione segnalazione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO segnalazione (descrizione, latitudine, longitudine, citta, provincia, via, numerocivico, cap, datasegnalazione) VALUES(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, segnalazione.getDescrizione());
            ps.setString(2, segnalazione.getLatitudine());
            ps.setString(3, segnalazione.getLongitudine());
            ps.setString(4, segnalazione.getCitta());
            ps.setString(5, segnalazione.getProvincia());
            ps.setString(6, segnalazione.getVia());
            ps.setString(7, segnalazione.getNumcivico());
            ps.setString(8, segnalazione.getCap());
            ps.setString(9, segnalazione.getData());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
           segnalazione.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM segnalazione WHERE idsegnalazione=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void doUpdate(Segnalazione s) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE segnalazione SET descrizione=?, latitudine=?, longitudine=?, citta=?, provincia=?, via=?, numerocivico=?, cap=?, datasegnalazione=? WHERE idsegnalazione=?");
            ps.setString(1, s.getDescrizione());
            ps.setString(2, s.getLatitudine());
            ps.setString(3, s.getLongitudine());
            ps.setString(4, s.getCitta());
            ps.setString(5, s.getProvincia());
            ps.setString(6, s.getVia());
            ps.setString(7, s.getNumcivico());
            ps.setString(8, s.getCap());
            ps.setString(9, s.getData());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Segnalazione doRetrieveById(int id)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM segnalazione WHERE idsegnalazione=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Segnalazione s = new Segnalazione();
                s.setId(rs.getInt(1));
                s.setDescrizione(rs.getString(2));
                s.setLatitudine(rs.getString(3));
                s.setLongitudine(rs.getString(4));
                s.setCitta(rs.getString(5));
                s.setProvincia(rs.getString(6));
                s.setVia(rs.getString(7));
                s.setNumcivico(rs.getString(8));
                s.setCap(rs.getString(9));
                s.setData(rs.getString(10));
                return s;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Segnalazione> doRetrieveAll()
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idsegnalazione, descrizione, latitudine, longitudine, citta, provincia, via, numerocivico, cap, datasegnalazione FROM segnalazione");
            ArrayList<Segnalazione> segnalazioni= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Segnalazione s = new Segnalazione();
                s.setId(rs.getInt(1));
                s.setDescrizione(rs.getString(2));
                s.setLatitudine(rs.getString(3));
                s.setLongitudine(rs.getString(4));
                s.setCitta(rs.getString(5));
                s.setProvincia(rs.getString(6));
                s.setVia(rs.getString(7));
                s.setNumcivico(rs.getString(8));
                s.setCap(rs.getString(9));
                s.setData(rs.getString(10));
                segnalazioni.add(s);
            }
            return segnalazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
