package SQL.QLThuPhiDongGop;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SQL.DBConnect;
import model.QLThuPhiDongGop.ThuPhi;

/**
 *
 * @author admin
 */

public class ThuPhiSQLImpl implements ThuPhiSQL {
    @Override
    public List<ThuPhi> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM thuphi";
            List<ThuPhi> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThuPhi thuPhi = new ThuPhi();
                thuPhi.setMaHoaDon(rs.getInt("maHoaDon"));
                thuPhi.setMaKhoanThu(rs.getInt("maKhoanThu"));
                thuPhi.setMaNguoiNop(rs.getInt("maNguoiNop"));
                thuPhi.setNgayDong(rs.getDate("ngayDong"));
                thuPhi.setMaNguoiThu(rs.getInt("maNguoiThu"));
                list.add(thuPhi);
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
    public int createOrUpdate(ThuPhi thuPhi) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO ThuPhi(maHoaDon, maKhoanThu, maNguoiNop, ngayDong, maNguoiThu) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maHoaDon = VALUES(maHoaDon),maKhoanThu = VALUES(maKhoanThu), maNguoiNop = VALUES(maNguoiNop),ngayDong = VALUES(ngayDong), maNguoiThu = VALUES(maNguoiThu);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, thuPhi.getMaHoaDon());
            ps.setInt(2, thuPhi.getMaKhoanThu());
            ps.setInt(3, thuPhi.getMaNguoiNop());
            ps.setDate(4, (java.sql.Date) new Date(thuPhi.getNgayDong().getTime()));
            ps.setInt(5, thuPhi.getMaNguoiThu());
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
            String sql = "DELETE FROM thuphi WHERE maHoaDon = ?";
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
        ThuPhiSQL thuPhiSQL = new ThuPhiSQLImpl();
        System.out.println(thuPhiSQL.getList());
    }

}
