package SQL;

import model.QLPhatThuong.PhatThuongLe;

import java.util.List;

public interface PhatThuongLeSQL {
    public List<PhatThuongLe> getList();
    public int createOrUpdate(PhatThuongLe phatThuongLe);

    int delete(int id);
}
