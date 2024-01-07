/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SQL.HoKhauSQL;
import SQL.HoKhauSQLImpl;
import java.util.List;
import model.QLHoKhauNhanKhau.HoKhau;

/**
 *
 * @author admin
 */
public class HoKhauServiceImpl implements HoKhauService{
    private HoKhauSQL hoKhauSQL = null;

    public HoKhauServiceImpl() {
        hoKhauSQL = new HoKhauSQLImpl();
    }
    

    @Override
    public List<HoKhau> getList() {
        return hoKhauSQL.getList();

    }

    @Override
    public int createOrUpdate(HoKhau hoKhau) {
        return hoKhauSQL.createOrUpdate(hoKhau);
    
    }
    @Override
    public int delete(int id){
        return hoKhauSQL.delete(id);
    }
}
