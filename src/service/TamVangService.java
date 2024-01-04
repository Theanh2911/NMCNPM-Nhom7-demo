package service;

import model.HoKhau;
import model.TamVang;
import java.util.List;

public interface TamVangService {
    public List<TamVang> getList();
    public int createOrUpdate(TamVang tamVang);
    public int delete(int id);
}
