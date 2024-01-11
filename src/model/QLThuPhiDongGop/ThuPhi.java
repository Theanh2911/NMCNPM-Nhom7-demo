package model.QLThuPhiDongGop;

import java.sql.Date;

public class ThuPhi {
    private int maHoaDon;
    private int maKhoanThu;
    private String tenKhoanThu;
    private int soTien;
    private int maNguoiNop;
    private String tenNguoiNop;
    private Date ngayDong;
    private int maNguoiThu;

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public int getSoTien() {
        return soTien;
    }

    public int getMaNguoiNop() {
        return maNguoiNop;
    }

    public String getTenNguoiNop() {
        return tenNguoiNop;
    }

    public Date getNgayDong() {
        return ngayDong;
    }

    public int getMaNguoiThu() {
        return maNguoiThu;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public void setMaNguoiNop(int maNguoiNop) {
        this.maNguoiNop = maNguoiNop;
    }

    public void setTenNguoiNop(String tenNguoiNop) {
        this.tenNguoiNop = tenNguoiNop;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
    }

    public void setMaNguoiThu(int maNguoiThu) {
        this.maNguoiThu = maNguoiThu;
    }
}
