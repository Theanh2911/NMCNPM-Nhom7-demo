package model.QLThuPhiDongGop;

import java.sql.Date;

public class ThuPhi {
    private int maHoaDon;
    private int maKhoanThu;
    private int maNguoiNop;
    private Date ngayDong;
    private int maNguoiThu;

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public int getMaNguoiNop() {
        return maNguoiNop;
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

    public void setMaNguoiNop(int maNguoiNop) {
        this.maNguoiNop = maNguoiNop;
    }

    public void setNgayDongGop(Date ngayDongGop) {
        this.ngayDong = ngayDong;
    }

    public void setNguoiThu(int nguoiThu) {
        this.maNguoiThu = maNguoiThu;
    }
}
