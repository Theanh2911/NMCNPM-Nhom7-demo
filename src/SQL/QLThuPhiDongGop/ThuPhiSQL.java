package SQL.QLThuPhiDongGop;

import model.QLThuPhiDongGop.ThuPhi;

import java.util.List;

public interface ThuPhiSQL {
    public List<ThuPhi> getList();
    public int createOrUpdate(ThuPhi thuPhi);

    int delete(int id);
}
