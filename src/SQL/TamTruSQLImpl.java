package SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TamTruTamVang.TamTru;

/**
 *
 * @author admin
 */

public class TamTruSQLImpl implements TamTruSQL {
    @Override
    public List<TamTru> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM tamtru";
            List<TamTru> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TamTru tamTru = new TamTru();
                tamTru.setIdKhaiBao(rs.getInt("idKhaiBao"));
                tamTru.setIdNhanKhau(rs.getInt("idNhanKhau"));
                tamTru.setHoTen(rs.getString("hoTen"));
                tamTru.setNoiTamTru(rs.getString("noiTamTru"));
                tamTru.setThoiGianKhaiBao(rs.getDate("thoiGianKhaiBao"));
                tamTru.setNguoiThucHien(rs.getInt("nguoiThucHien"));
                list.add(tamTru);
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
    public int createOrUpdate(TamTru tamTru) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO TamTru(idKhaiBao, idNhanKhau, hoTen, noiTamTru, thoiGianKhaiBao, nguoiThucHien) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE idKhaiBao = VALUES(idKhaiBao),idNhanKhau = VALUES(idNhanKhau), hoTen = VALUES(hoTen), noiTamTru = VALUES(noiTamTru),thoiGianKhaiBao = VALUES(thoiGianKhaiBao), nguoiThucHien = VALUES(nguoiThucHien);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tamTru.getIdKhaiBao());
            ps.setInt(2, tamTru.getIdNhanKhau());
            ps.setString(3, tamTru.getHoTen());
            ps.setString(4, tamTru.getNoiTamTru());
            ps.setDate(5, (java.sql.Date) new Date(tamTru.getThoiGianKhaiBao().getTime()));
            ps.setInt(6, tamTru.getNguoiThucHien());
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
        TamTruSQL tamTruSQL = new TamTruSQLImpl();
        System.out.println(tamTruSQL.getList());
    }

}
