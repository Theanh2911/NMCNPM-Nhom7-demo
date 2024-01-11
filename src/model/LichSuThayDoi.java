package model;

import java.sql.Timestamp;

public class LichSuThayDoi {
    private String loaiThayDoi;
    private int maViTri;
    private String NoiDung;
    private Timestamp thoiGian;

    public String getLoaiThayDoi() {
        return loaiThayDoi;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setLoaiThayDoi(String loaiThayDoi) {
        this.loaiThayDoi = loaiThayDoi;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }
}
