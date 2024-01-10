package SQL.QLThuPhiDongGop;

import model.QLThuPhiDongGop.DongGop;

import java.util.List;

public interface DongGopSQL {
    public List<DongGop> getList();
    public int createOrUpdate(DongGop dongGop);

    int delete(int id);
}
