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

    @Override
    public String toString() {
        return "TamVang{" + "idKhaiBao=" + this.idKhaiBao + ", idNhanKhau=" + this.idNhanKhau + ", hoTen=" + this.hoTen + ", thoiGianKhaiBao=" + this.thoiGianKhaiBao + '}';
    }
}