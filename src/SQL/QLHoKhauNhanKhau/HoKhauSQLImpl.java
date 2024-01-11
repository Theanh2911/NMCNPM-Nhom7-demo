package SQL.QLHoKhauNhanKhau;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SQL.DBConnect;
import model.QLHoKhauNhanKhau.HoKhau;

/**
 *
 * @author admin
 */

public class HoKhauSQLImpl implements HoKhauSQL {
    @Override
    public List<HoKhau> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM hokhau";
            List<HoKhau> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoKhau hoKhau = new HoKhau();
                hoKhau.setID(rs.getInt("ID"));
                hoKhau.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhau.setIdChuHo(rs.getInt("idChuHo"));
                hoKhau.setMaKhuVuc(rs.getString("maKhuVuc"));
                hoKhau.setDiaChi(rs.getString("diaChi"));
                hoKhau.setNgayLap(rs.getDate("ngayLap"));
                hoKhau.setNgayChuyenDi(rs.getDate("ngayChuyenDi"));
                hoKhau.setNguoiThucHien(rs.getInt("nguoiThucHien"));

                list.add(hoKhau);
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
    public int createOrUpdate(HoKhau hoKhau) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO HoKhau(ID, maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen, nguoiThucHien) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE maHoKhau = VALUES(maHoKhau), idChuHo = VALUES(idChuHo), maKhuVuc = VALUES(maKhuVuc), diaChi = VALUES(diaChi), ngayLap = VALUES(ngayLap), ngayChuyenDi = VALUES(ngayChuyenDi), lyDoChuyen = VALUES(lyDoChuyen), nguoiThucHien = VALUES(nguoiThucHien);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hoKhau.getID());
            ps.setString(2, hoKhau.getMaHoKhau());
            ps.setInt(3, hoKhau.getIdChuHo());
            ps.setString(4, hoKhau.getMaKhuVuc());
            ps.setString(5, hoKhau.getDiaChi());
            ps.setDate(6, (java.sql.Date) new Date(hoKhau.getNgayLap().getTime()));
            ps.setDate(7, (java.sql.Date) new Date(hoKhau.getNgayChuyenDi().getTime()));
            ps.setString(8, hoKhau.getLyDoChuyen());
            ps.setInt(9, hoKhau.getNguoiThucHien());
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
            String sql = "DELETE FROM hokhau WHERE ID = ?";
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
        HoKhauSQL hoKhauSQL = new HoKhauSQLImpl();
        System.out.println(hoKhauSQL.getList());
    }

}
