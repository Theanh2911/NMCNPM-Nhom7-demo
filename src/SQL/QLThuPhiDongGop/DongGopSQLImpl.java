package SQL.QLThuPhiDongGop;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SQL.DBConnect;
import model.QLThuPhiDongGop.DongGop;

/**
 *
 * @author admin
 */

public class DongGopSQLImpl implements DongGopSQL {
    @Override
    public List<DongGop> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM donggop";
            List<DongGop> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DongGop dongGop = new DongGop();
                dongGop.setMaHoaDon(rs.getInt("maHoaDon"));
                dongGop.setMaKhoanDongGop(rs.getInt("maKhoanDongGop"));
                dongGop.setMaNguoiDongGop(rs.getInt("maNguoiDongGop"));
                dongGop.setSoTien(rs.getInt("soTien"));
                dongGop.setNgayDongGop(rs.getDate("ngayDong"));
                dongGop.setMaNguoiThu(rs.getInt("maNguoiThu"));
                list.add(dongGop);
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
    public int createOrUpdate(DongGop dongGop) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO DongGop(maHoaDon, maKhoanThu, maNguoiNop, ngayDong, maNguoiThu) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maHoaDon = VALUES(maHoaDon),maKhoanThu = VALUES(maKhoanThu), maNguoiNop = VALUES(maNguoiNop),ngayDong = VALUES(ngayDong), maNguoiDong = VALUES(maNguoiDong);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dongGop.getMaHoaDon());
            ps.setInt(2, dongGop.getMaKhoanThu());
            ps.setInt(3, dongGop.getMaNguoiNop());
            ps.setDate(4, (java.sql.Date) new Date(dongGop.getNgayDong().getTime()));
            ps.setInt(5, dongGop.getMaNguoiThu());
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
            String sql = "DELETE FROM donggop WHERE maHoaDon = ?";
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
        DongGopSQL dongGopSQL = new DongGopSQLImpl();
        System.out.println(dongGopSQL.getList());
    }

}
