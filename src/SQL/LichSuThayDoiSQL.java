package SQL;

import model.LichSuThayDoi;

import java.util.List;

public interface LichSuThayDoiSQL {
    public List<LichSuThayDoi> getList();
    public int createOrUpdate(LichSuThayDoi lichSuThayDoi);

    int delete(int id);
}
