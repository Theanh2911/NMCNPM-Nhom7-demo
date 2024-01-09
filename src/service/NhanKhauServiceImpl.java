
package service;

import SQL.QLHoKhauNhanKhau.NhanKhauSQL;
import SQL.QLHoKhauNhanKhau.NhanKhauSQLImpl;
import java.util.List;
import model.QLHoKhauNhanKhau.NhanKhau;

/**
 *
 * @author admin
 */
public class NhanKhauServiceImpl implements NhanKhauService{
    private NhanKhauSQL nhanKhauSQL = null;

    public NhanKhauServiceImpl() {
        nhanKhauSQL = new NhanKhauSQLImpl();
    }
    

    @Override
    public List<NhanKhau> getList() {
        return nhanKhauSQL.getList();

    }

    @Override
    public int createOrUpdate(NhanKhau nhanKhau) {
        return nhanKhauSQL.createOrUpdate(nhanKhau);
    
    }

    @Override
    public int delete(int id) {
        return nhanKhauSQL.delete(id);
    }


}
