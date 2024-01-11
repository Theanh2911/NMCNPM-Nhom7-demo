package SQL.QLHoKhauNhanKhau;

import java.util.List;
import model.QLHoKhauNhanKhau.HoKhau;

/**
 *
 * @author admin
 */
public interface HoKhauSQL {
    public List<HoKhau> getList();
    public int createOrUpdate(HoKhau hoKhau);

    int delete(int id);
}
