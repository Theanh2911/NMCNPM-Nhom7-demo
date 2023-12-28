/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class TamTru {
    private static int nbKhaiBao = 0;
    private int idKhaiBao;
    private int idNhanKhau;
    private String hoTen;
    private String noiTamTru;
    private Date thoiGianKhaiBao;
    private int nguoiThucHien;

    public void setNguoiThucHien(int nguoiThucHien) {
        this.nguoiThucHien = nguoiThucHien;
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

    public String getNoiTamTru() {
        return noiTamTru;
    }

    public Date getThoiGianKhaiBao() {
        return thoiGianKhaiBao;
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

    public void setNoiTamTru(String noiTamTru) {
        this.noiTamTru = noiTamTru;
    }

    public void setThoiGianKhaiBao(Date thoiGianKhaiBao) {
        this.thoiGianKhaiBao = thoiGianKhaiBao;
    }

    @Override
    public String toString() {
        return "TamTru{" + "IDNhanKhau=" + this.idNhanKhau + ", HoTen=" + this.hoTen + ", NoiTamTru=" + this.noiTamTru + ", ThoiGianKhaiBao=" + this.thoiGianKhaiBao + '}';
    }
    
    
}
