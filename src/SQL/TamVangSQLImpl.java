package SQL;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.TamVang;

/**
 *
 * @author admin
 */

public class TamVangSQLImpl implements TamVangSQL {
    @Override
    public List<TamVang> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM tamvang";
            List<TamVang> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TamVang tamVang = new TamVang();
                tamVang.setIdKhaiBao(rs.getInt("idKhaiBao"));
                tamVang.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tamVang.setHoTen(rs.getString("hoTen"));
                tamVang.setNoiDen(rs.getString("noiDen"));
                tamVang.setThoiGianKhaiBao(rs.getDate("thoiGianKhaiBao"));
                tamVang.setNguoiThucHien(rs.getInt("nguoiThucHien"));
                list.add(tamVang);
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
    public int createOrUpdate(TamVang tamVang) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO TamVang(idKhaiBao, idNhanKhau, hoTen, noiDen, thoiGianKhaiBao, nguoiThucHien) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maKhaiBao = VALUES(maKhaiBao), maNhanKhau = VALUES(maNhanKhau), nguoiThucHien = VALUES(nguoiThucHien);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tamVang.getIdKhaiBao());
            ps.setInt(2, tamVang.getIdNhanKhau());
            ps.setString(3, tamVang.getHoTen());
            ps.setString(4, tamVang.getNoiDen());
            ps.setDate(5, new Date(tamVang.getThoiGianKhaiBao().getTime()));
            ps.setInt(6, tamVang.getNguoiThucHien());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    @Override
    public int delete(int id) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM tamtru WHERE idKhaiBao = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            ps.close();
            cons.close();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        TamVangSQL tamVangSQL = new TamVangSQLImpl();
        System.out.println(tamVangSQL.getList());
    }

}
