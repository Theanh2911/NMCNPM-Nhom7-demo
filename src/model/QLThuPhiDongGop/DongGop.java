package model.QLThuPhiDongGop;

import java.sql.Date;

public class DongGop {
    private int maKhoanThu;
    private int maNguoiDongGop;
    private int maHo;
    private String hoTen;
    private String khoanDongGop;
    private int soTien;
    private Date ngayDongGop;
    private int nguoiThu;

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public int getMaNguoiDongGop() {
        return maNguoiDongGop;
    }

    public int getMaHo() {
        return maHo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getKhoanDongGop() {
        return khoanDongGop;
    }

    public int getSoTien() {
        return soTien;
    }

    public Date getNgayDongGop() {
        return ngayDongGop;
    }

    public int getNguoiThu() {
        return nguoiThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public void setMaNguoiDongGop(int maNguoiDongGop) {
        this.maNguoiDongGop = maNguoiDongGop;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setKhoanDongGop(String khoanDongGop) {
        this.khoanDongGop = khoanDongGop;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public void setNgayDongGop(Date ngayDongGop) {
        this.ngayDongGop = ngayDongGop;
    }

    public void setNguoiThu(int nguoiThu) {
        this.nguoiThu = nguoiThu;
    }
}
