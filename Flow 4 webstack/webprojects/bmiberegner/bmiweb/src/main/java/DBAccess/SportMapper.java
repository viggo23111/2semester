package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportMapper {

    public static List<Sport> getAllSports() throws LoginSampleException {
        List<Sport> sportList = null;
        try {
            String SQL = "SELECT * FROM sport ";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (sportList == null) {
                    sportList = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Sport sport = new Sport(id, name);
                sportList.add(sport);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return sportList;
    }

    public static void updateSport(int sport_id, String name) throws LoginSampleException {
        int newId = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE sport SET name =? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setInt(2, sport_id);
            int result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("THERE WAS AN ERROR: Sportid: " + sport_id + " Sportname: " + name);

        }
    }

    public static void deleteSport(int sport_id) throws LoginSampleException {
        int newId = 0;
        try {
            String SQL = "DELETE FROM sport WHERE id=?";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, sport_id);
            int result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            if(ex.getMessage().startsWith("Cannot delete or update a parent row")){
                throw new LoginSampleException("Du kan ikke fjerne en sportskategori som allerede er anvendt i databasen");
            }else {
                throw new LoginSampleException(ex.getMessage());
            }
        }
    }
}
