package service;

import SQL.TamTruSQL;
import SQL.TamTruSqlImpl;
import model.HoKhau;

import java.util.List;

public class TamTruServiceImpl implements TamTruService {
    private TamTruSQL hoKhauSQL = null;

    public HoKhauServiceImpl() {
        hoKhauSQL = new TamtruSQLImpl();
    }


    @Override
    public List<HoKhau> getList() {
        return hoKhauSQL.getList();

    }

    @Override
    public int createOrUpdate(HoKhau hoKhau) {
        return hoKhauSQL.createOrUpdate(hoKhau);

    }
    @Override
    public int delete(int id){
        return hoKhauSQL.delete(id);
    }
}
