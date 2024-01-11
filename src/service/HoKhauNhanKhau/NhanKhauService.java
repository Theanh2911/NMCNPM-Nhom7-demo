/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.HoKhauNhanKhau;

import java.util.List;
import model.QLHoKhauNhanKhau.NhanKhau;

/**
 *
 * @author admin
 */
public interface NhanKhauService {
    
    public List<NhanKhau> getList();
        public int createOrUpdate(NhanKhau nhanKhau);
    public int delete(int id);
    
}
