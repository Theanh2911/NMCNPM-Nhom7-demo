package SQL;

import model.TamTruTamVang.TamTru;

import java.util.List;

public interface TamTruSQL {
    public List<TamTru> getList();
    public int createOrUpdate(TamTru tamTru);

    int delete(int id);
}
