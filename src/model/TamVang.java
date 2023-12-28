package model;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TamVang {
    private static int nbKhaiBao = 0;
    private int idKhaiBao;
    private int idNhanKhau;
    private String hoTen;
    private String noiDen;
    private LocalDateTime thoiGianKhaiBao;

    public TamVang(int id, String hoTen, String noiDen) {
        this.idKhaiBao = ++nbKhaiBao;
        this.idNhanKhau = id;
        this.hoTen = hoTen;
        this.noiDen = noiDen;
        this.thoiGianKhaiBao = LocalDateTime.now(ZoneId.of("Asia/Bangkok"));
    }

    public int getIdKhaiBao() {
        return idKhaiBao;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public LocalDateTime getThoiGianKhaiBao() {
        return thoiGianKhaiBao;
    }

    @Override
    public String toString() {
        return "TamVang{" + "idKhaiBao=" + this.idKhaiBao + ", idNhanKhau=" + this.idNhanKhau + ", hoTen=" + this.hoTen + ", thoiGianKhaiBao=" + this.thoiGianKhaiBao + '}';
    }
}