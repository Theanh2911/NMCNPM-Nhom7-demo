/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SQL.TaiKhoan.TaiKhoanSQL;
import SQL.TaiKhoan.TaiKhoanSQLImpl;
import model.TaiKhoan;

/**
 *
 * @author admin
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private TaiKhoanSQL taiKhoanSQL = null;
    public TaiKhoanServiceImpl(){
        taiKhoanSQL = new TaiKhoanSQLImpl();
    }

    @Override
    public TaiKhoan login(String tdn, String mk) {
        return taiKhoanSQL.login(tdn, mk);
    }
    
}
