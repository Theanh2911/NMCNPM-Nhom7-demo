package model.QLThuPhiDongGop;

import java.sql.Date;

public class DongGop {
    private int maHoaDon;
    private int maKhoanDongGop;
    private int maNguoiDongGop;
    private int soTien;
    private Date ngayDongGop;
    private int maNguoiThu;

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaKhoanDongGop() {
        return maKhoanDongGop;
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


    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaKhoanDongGop(int maKhoanDongGop) {
        this.maKhoanDongGop = maKhoanDongGop;
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
}
