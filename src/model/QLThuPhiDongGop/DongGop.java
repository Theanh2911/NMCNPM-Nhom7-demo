package model.QLThuPhiDongGop;

import java.sql.Date;

public class DongGop {
    private int maHoaDon;
    private int maKhoanDongGop;
    private String tenKhoanDongGop;
    private int maNguoiDongGop;
    private String tenNguoiDongGop;
    private int soTien;
    private Date ngayDongGop;
    private int maNguoiThu;

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaKhoanDongGop() {
        return maKhoanDongGop;
    }
    public String getTenKhoanDongGop() {
        return tenKhoanDongGop;
    }

    public int getMaNguoiDongGop() {
        return maNguoiDongGop;
    }


    public int getSoTien() {
        return soTien;
    }

    public Date getNgayDongGop() {
        return ngayDongGop;
    }

    public int getMaNguoiThu() {
        return maNguoiThu;
    }
    public String getTenNguoiDongGop(){return tenNguoiDongGop;}


    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaKhoanDongGop(int maKhoanDongGop) {
        this.maKhoanDongGop = maKhoanDongGop;
    }
    public void setTenKhoanDongGop(String tenKhoanDongGop) {
        this.tenKhoanDongGop = tenKhoanDongGop;
    }

    public void setMaNguoiDongGop(int maNguoiDongGop) {
        this.maNguoiDongGop = maNguoiDongGop;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public void setNgayDongGop(Date ngayDongGop) {
        this.ngayDongGop = ngayDongGop;
    }

    public void setMaNguoiThu(int maNguoiThu) {
        this.maNguoiThu = maNguoiThu;
    }
    public void setTenNguoiDongGop(String tenNguoiDongGop){this.tenNguoiDongGop = tenNguoiDongGop;}
}
