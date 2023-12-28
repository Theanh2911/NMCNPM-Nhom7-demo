/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
    private LocalDateTime thoiGianKhaiBao;

    public TamTru(int idNhanKhau, String hoTen, String noiTamTru) {
        this.idKhaiBao = ++nbKhaiBao;
        this.idNhanKhau = idNhanKhau;
        this.hoTen = hoTen;
        this.noiTamTru = noiTamTru;
        this.thoiGianKhaiBao = LocalDateTime.now(ZoneId.of("Asia/Bangkok"));
    }

    @Override
    public String toString() {
        return "TamTru{" + "IDNhanKhau=" + this.idNhanKhau + ", HoTen=" + this.hoTen + ", NoiTamTru=" + this.noiTamTru + ", ThoiGianKhaiBao=" + this.thoiGianKhaiBao + '}';
    }
    
    
}
