package service;

import model.QLThuPhiDongGop.ThuPhi;

import java.util.List;

public interface ThuPhiService {
    public List<ThuPhi> getList();
    public int createOrUpdate(ThuPhi thuPhi);
    public int delete(int id);
}
