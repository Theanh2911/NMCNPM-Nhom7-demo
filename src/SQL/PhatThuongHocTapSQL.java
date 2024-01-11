package SQL;

import model.QLPhatThuong.PhatThuongHocTap;

import java.util.List;

public interface PhatThuongHocTapSQL {
    public List<PhatThuongHocTap> getList();
    public int createOrUpdate(PhatThuongHocTap phatThuongHocTap);

    int delete(int id);
}
