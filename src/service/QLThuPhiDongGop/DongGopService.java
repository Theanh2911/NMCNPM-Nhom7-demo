package service.QLThuPhiDongGop;

import model.QLThuPhiDongGop.DongGop;

import java.util.List;

public interface DongGopService {
    public List<DongGop> getList();
    public int createOrUpdate(DongGop dongGop);
    public int delete(int id);
}
