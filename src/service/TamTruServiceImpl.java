package service;

import SQL.TamTruSQL;
import SQL.TamTruSQLImpl;
import model.TamTru;

import java.util.List;

public class TamTruServiceImpl implements TamTruService {
    private TamTruSQL tamTruSQL = null;

    public TamTruServiceImpl() {
        tamTruSQL = new TamTruSQLImpl();
    }


    @Override
    public List<TamTru> getList() {
        return tamTruSQL.getList();
    }

    @Override
    public int createOrUpdate(TamTru tamTru) {
        return tamTruSQL.createOrUpdate(tamTru);

    }
    @Override
    public int delete(int id){
        return tamTruSQL.delete(id);
    }
}
