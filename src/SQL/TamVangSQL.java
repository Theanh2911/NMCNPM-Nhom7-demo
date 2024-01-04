package SQL;

import model.TamVang;

import java.util.List;

public interface TamVangSQL {
    public List<TamVang> getList();
    public int createOrUpdate(TamVang tamVang);

    int delete(int id);
}
