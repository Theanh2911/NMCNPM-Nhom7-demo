package service.TamTruTamVang;

import SQL.TamTruTamVang.TamVangSQL;
import SQL.TamTruTamVang.TamVangSQLImpl;
import model.TamTruTamVang.TamVang;
import service.TamTruTamVang.TamVangService;

import java.util.List;

public class TamVangServiceImpl implements TamVangService {
    private TamVangSQL tamVangSQL = null;

    public TamVangServiceImpl() {
        tamVangSQL = new TamVangSQLImpl();
    }


    @Override
    public List<TamVang> getList() {
        return tamVangSQL.getList();
    }

    @Override
    public int createOrUpdate(TamVang tamVang) {
        return tamVangSQL.createOrUpdate(tamVang);

    }
    @Override
    public int delete(int id){
        return tamVangSQL.delete(id);
    }
}
