package SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SQL.DBConnect;
import model.LichSuThayDoi;

/**
 *
 * @author admin
 */

public class LichSuThayDoiSQLImpl implements LichSuThayDoiSQL {
    @Override
    public List<LichSuThayDoi> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM lichsuthaydoi";
            List<LichSuThayDoi> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                LichSuThayDoi lichSuThayDoi = new LichSuThayDoi();
                lichSuThayDoi.setLoaiThayDoi(rs.getString("loaiThayDoi"));
                lichSuThayDoi.setMaViTri(rs.getInt("maViTri"));
                lichSuThayDoi.setNoiDung(rs.getString("noiDung"));
                lichSuThayDoi.setThoiGian(rs.getTimestamp("thoiGian"));
                list.add(lichSuThayDoi);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public int createOrUpdate(LichSuThayDoi lichSuThayDoi) {
        return 0;
    }
    @Override
    public int delete(int id) {
        return 0;
    }

    public static void main(String[] args) {
        LichSuThayDoiSQL lichSuThayDoiSQL = new LichSuThayDoiSQLImpl();
        System.out.println(lichSuThayDoiSQL.getList());
    }

}
