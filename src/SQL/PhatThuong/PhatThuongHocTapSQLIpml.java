package SQL.PhatThuong;

import SQL.DBConnect;
import model.QLPhatThuong.PhatThuongHocTap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhatThuongHocTapSQLIpml implements PhatThuongHocTapSQL {
    @Override
    public List<PhatThuongHocTap> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM phatthuonghoctap";
            List<PhatThuongHocTap> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhatThuongHocTap phatThuongHocTap = new PhatThuongHocTap();
                phatThuongHocTap.setMaPhatThuong(rs.getInt("maPhatThuong"));
                phatThuongHocTap.setMaPhanThuong(rs.getInt("maPhanThuong"));
                phatThuongHocTap.setMaNguoiNhan(rs.getInt("maNguoiNhan"));
                phatThuongHocTap.setNguoiNhan(rs.getString("nguoiNhan"));
                phatThuongHocTap.setNgayNhan(rs.getDate("ngayNhan"));

                list.add(phatThuongHocTap);
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
    public int createOrUpdate(PhatThuongHocTap phatThuongHocTap) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO PhatThuongHocTap(maPhatThuong, maPhanThuong, maNguoiNhan, nguoiNhan, ngayNhan) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maPhatThuong = VALUES(maPhatThuong), maPhanThuong = VALUES(maPhanThuong), maNguoiNhan = VALUES(maNguoiNhan), nguoiNhan = VALUES(nguoiNhan), ngayNhan = VALUES(ngayNhan);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, phatThuongHocTap.getMaPhatThuong());
            ps.setInt(2, phatThuongHocTap.getMaPhanThuong());
            ps.setInt(3, phatThuongHocTap.getMaNguoiNhan());
            ps.setString(4, phatThuongHocTap.getNguoiNhan());
            ps.setDate(5, phatThuongHocTap.getNgayNhan());
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
            String sql = "DELETE FROM phatthuonghoctap WHERE maPhatThuong = ?";
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
        PhatThuongHocTapSQLIpml phatThuongHocTapSQLIpml = new PhatThuongHocTapSQLIpml();
        System.out.println(phatThuongHocTapSQLIpml.getList());
    }
}
