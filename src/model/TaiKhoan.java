
package model;

/**
 *
 * @author admin
 */
public class TaiKhoan {
    private int IDTaiKhoan;
    private String TenDangNhap;
    private String MatKhau;
    private boolean TinhTrang;

    public int getIDTaiKhoan() {
        return IDTaiKhoan;
    }

    public void setIDTaiKhoan(int IDTaiKhoan) {
        this.IDTaiKhoan = IDTaiKhoan;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    
}
