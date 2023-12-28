package service;

import model.HoKhau;
import model.TamTru;
import java.util.List;

public interface TamTruService {
    public List<TamTru> getList();
    public int createOrUpdate(TamTru tamTru);
    public int delete(int id);
}
