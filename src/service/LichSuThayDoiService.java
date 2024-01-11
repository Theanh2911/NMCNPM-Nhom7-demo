package service;

import model.LichSuThayDoi;
import model.QLHoKhauNhanKhau.HoKhau;

import java.util.List;

public interface LichSuThayDoiService {
    public List<LichSuThayDoi> getList();
    public int createOrUpdate(LichSuThayDoi lichSuThayDoi);
    public int delete(int id);
}
