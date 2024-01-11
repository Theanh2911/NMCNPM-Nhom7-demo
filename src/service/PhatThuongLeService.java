package service;

import model.QLPhatThuong.PhatThuongLe;

import java.util.List;

public interface PhatThuongLeService {
    public List<PhatThuongLe> getList();
    public int createOrUpdate(PhatThuongLe phatThuongLe);
    public int delete(int id);
}
