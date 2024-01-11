package model.QLPhatThuong;

import java.sql.Date;

public class PhatThuongLe {
    private int maPhatThuong;
//    private int maNguoiPhat;
//    private String nguoiPhat;
    private int maPhanThuong;
    private String tenPhanThuong;
    private int giaTri;
    private int maNguoiNhan;
    private String nguoiNhan;
    private Date ngayNhan;

    public int getMaPhatThuong() {
        return maPhatThuong;
    }

    public void setMaPhatThuong(int maPhatThuong) {
        this.maPhatThuong = maPhatThuong;
    }

    public String getTenPhanThuong() {
        return tenPhanThuong;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setTenPhanThuong(String tenPhanThuong) {
        this.tenPhanThuong = tenPhanThuong;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public int getMaPhanThuong() {
        return maPhanThuong;
    }

    public void setMaPhanThuong(int maPhanThuong) {
        this.maPhanThuong = maPhanThuong;
    }

    public int getMaNguoiNhan() {
        return maNguoiNhan;
    }

    public void setMaNguoiNhan(int maNguoiNhan) {
        this.maNguoiNhan = maNguoiNhan;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }
}
