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
            String sql = "SELECT * FROM tamtru";
            List<ThuPhi> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThuPhi thuPhi = new ThuPhi();
                thuPhi.setMaKhoanThu(rs.getInt("idKhaiBao"));
                thuPhi.setMaNguoiNop(rs.getInt("idNhanKhau"));
                /*thuPhi.setMaHo(rs.getInt("idNhanKhau"));
                thuPhi.setHoTen(rs.getString("hoTen"));
                thuPhi.setTenKhoanThu(rs.getString("noiThuPhi"));
                thuPhi.setThoiGianKhaiBao(rs.getDate("thoiGianKhaiBao"));
                thuPhi.setNguoiThucHien(rs.getInt("nguoiThucHien"));
                list.add(thuPhi);*/
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
            String sql = "INSERT INTO ThuPhi(idKhaiBao, idNhanKhau, hoTen, noiThuPhi, thoiGianKhaiBao, nguoiThucHien) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE idKhaiBao = VALUES(idKhaiBao),idNhanKhau = VALUES(idNhanKhau), hoTen = VALUES(hoTen), noiThuPhi = VALUES(noiThuPhi),thoiGianKhaiBao = VALUES(thoiGianKhaiBao), nguoiThucHien = VALUES(nguoiThucHien);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            /*ps.setInt(1, thuPhi.getIdKhaiBao());
            ps.setInt(2, thuPhi.getIdNhanKhau());
            ps.setString(3, thuPhi.getHoTen());
            ps.setString(4, thuPhi.getNoiThuPhi());
            ps.setDate(5, (java.sql.Date) new Date(thuPhi.getThoiGianKhaiBao().getTime()));
            ps.setInt(6, thuPhi.getNguoiThucHien());*/
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
        ThuPhiSQL thuPhiSQL = new ThuPhiSQLImpl();
        System.out.println(thuPhiSQL.getList());
    }

}
