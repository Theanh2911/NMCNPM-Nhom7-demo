package service;

import model.HoKhau;
import model.TamTru;

public interface TamTruService {
    public TamTru getList();
    public int createOrUpdate(TamTru tamTru);
    public int delete(int id);
}
