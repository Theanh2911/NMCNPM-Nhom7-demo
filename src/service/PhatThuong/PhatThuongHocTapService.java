package service.PhatThuong;

import model.QLPhatThuong.PhatThuongHocTap;
import java.util.List;

public interface PhatThuongHocTapService {
    public List<PhatThuongHocTap> getList();
    public int createOrUpdate(PhatThuongHocTap phatThuongHocTap);
    public int delete(int id);
}
