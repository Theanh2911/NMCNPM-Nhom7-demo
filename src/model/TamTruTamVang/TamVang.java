package model.TamTruTamVang;

import java.sql.Date;

public class TamVang {
    private static int nbKhaiBao = 0;
    private int idKhaiBao;
    private int idNhanKhau;
    private String hoTen;
    private String noiDen;
    private Date thoiGianKhaiBao;
    private int nguoiThucHien;
     public int getNguoiThucHien(){
         return nguoiThucHien;
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

    public Date getThoiGianKhaiBao() {
        return thoiGianKhaiBao;
    }

    public static void setNbKhaiBao(int nbKhaiBao) {
        TamVang.nbKhaiBao = nbKhaiBao;
    }

    public void setIdKhaiBao(int idKhaiBao) {
        this.idKhaiBao = idKhaiBao;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public void setThoiGianKhaiBao(Date thoiGianKhaiBao) {
        this.thoiGianKhaiBao = thoiGianKhaiBao;
    }

    public void setNguoiThucHien(int nguoiThucHien) {
        this.nguoiThucHien = nguoiThucHien;
    }

    @Override
    public String toString() {
        return "TamVang{" + "idKhaiBao=" + this.idKhaiBao + ", idNhanKhau=" + this.idNhanKhau + ", hoTen=" + this.hoTen + ", thoiGianKhaiBao=" + this.thoiGianKhaiBao + '}';
    }
}