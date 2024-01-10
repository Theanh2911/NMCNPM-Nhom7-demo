package SQL;

import model.QLPhatThuong.PhatThuongLe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhatThuongLeSQLIpml implements PhatThuongLeSQL {
    @Override
    public List<PhatThuongLe> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM phatthuongle";
            List<PhatThuongLe> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhatThuongLe phatThuongLe = new PhatThuongLe();
                phatThuongLe.setMaPhatThuong(rs.getInt("maPhatThuong"));
                phatThuongLe.setMaPhanThuong(rs.getInt("maPhanThuong"));
                phatThuongLe.setMaNguoiNhan(rs.getInt("maNguoiNhan"));
                phatThuongLe.setNguoiNhan(rs.getString("nguoiNhan"));
                phatThuongLe.setNgayNhan(rs.getDate("ngayNhan"));

                list.add(phatThuongLe);
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
    public int createOrUpdate(PhatThuongLe phatThuongLe) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO PhatThuongLe(maPhatThuong, maPhanThuong, maNguoiNhan, nguoiNhan, ngayNhan) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maPhatThuong = VALUES(maPhatThuong), maPhanThuong = VALUES(maPhanThuong), maNguoiNhan = VALUES(maNguoiNhan), nguoiNhan = VALUES(nguoiNhan), ngayNhan = VALUES(ngayNhan);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, phatThuongLe.getMaPhatThuong());
            ps.setInt(2, phatThuongLe.getMaPhanThuong());
            ps.setInt(3, phatThuongLe.getMaNguoiNhan());
            ps.setString(4, phatThuongLe.getNguoiNhan());
            ps.setDate(5, phatThuongLe.getNgayNhan());
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
            String sql = "DELETE FROM phatthuongle WHERE maPhatThuong = ?";
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
        PhatThuongLeSQLIpml phatThuongLeSQLIpml = new PhatThuongLeSQLIpml();
        System.out.println(phatThuongLeSQLIpml.getList());
    }
}
