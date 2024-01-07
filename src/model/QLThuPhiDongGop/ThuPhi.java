package model.QLThuPhiDongGop;

import java.sql.Date;

public class ThuPhi {
    private int maKhoanThu;
    private int maNguoiNop;
    private String hoTen;
    private int maHo;
    private String tenKhoanThu;
    private int soTien;
    private boolean daDong;
    private Date ngayDong;
    private int nguoiThu;

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public int getMaNguoiNop() {
        return maNguoiNop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getMaHo() {
        return maHo;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public int getSoTien() {
        return soTien;
    }

    public boolean isDaDong() {
        return daDong;
    }

    public Date getNgayDong() {
        return ngayDong;
    }

    public int getNguoiThu() {
        return nguoiThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public void setMaNguoiNop(int maNguoiNop) {
        this.maNguoiNop = maNguoiNop;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public void setDaDong(boolean daDong) {
        this.daDong = daDong;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
    }

    public void setNguoiThu(int nguoiThu) {
        this.nguoiThu = nguoiThu;
    }
}
