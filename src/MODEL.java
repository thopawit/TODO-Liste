import java.sql.*;
public class MODEL {
    TODO_LIST list;
    Connection con;

    static final String TABLE = "TODO";

    MODEL(String pathN) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + pathN);

            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, TABLE, null);
            if (!rs.next()) {
                Statement stmt = con.createStatement();
                String sql = "CREATE TABLE " + TABLE +
                        "(NAME TEXT PRIMARY KEY NOT NULL," +
                        " PRIORITY INT NOT NULL, " +
                        " STATUS BOOLEAN, " +
                        " DURATION INT)";
                stmt.executeUpdate(sql);
                stmt.close();
            }
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + TABLE+ ";");
            list = new TODO_LIST();
            while (rs.next()) {
                String name = rs.getString("name");
                int priority = rs.getInt("priority");
                boolean status  = rs.getBoolean("status");
                int duration = rs.getInt("duration");
                ENTRY entry = new ENTRY(name, duration, status, priority);
                list.insert(entry);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void CreateTODO(DATA dataN) {
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO " + TABLE + "(NAME, PRIORITY, STATUS, DURATION) " +
                    "VALUES ('" + dataN.GetName() +"', " + dataN.GetPriority() + ", " + dataN.GetStatus()+ ", " + dataN.GetDuration() + ");";
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        list.insert(dataN);
    }

    public void DeleteTODO(String name) {
        try {
            Statement stmt = con.createStatement();
            String sql = "DELETE from " + TABLE + " where NAME='" + name + "';";
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        list.delete(name);
    }

    public void UpdateTODO(String name, DATA dataN) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + TABLE + " set NAME = '" + dataN.GetName() +
                    "', PRIORITY = " + dataN.GetPriority() +
                    ", STATUS = " + dataN.GetStatus() +
                    ", DURATION = " + dataN.GetDuration() +
                    " where NAME='" + name + "';";
            stmt.executeUpdate(sql);
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        list.update(name, dataN);
    }

}
