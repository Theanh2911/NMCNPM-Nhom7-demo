package service;

import SQL.LichSuThayDoiSQL;
import SQL.LichSuThayDoiSQLImpl;
import model.LichSuThayDoi;
import service.LichSuThayDoiService;

import java.util.List;

public class LichSuThayDoiServiceImpl implements LichSuThayDoiService {
    private LichSuThayDoiSQL lichSuThayDoiSQL = null;

    public LichSuThayDoiServiceImpl() {
        lichSuThayDoiSQL = new LichSuThayDoiSQLImpl();
    }


    @Override
    public List<LichSuThayDoi> getList() {
        return lichSuThayDoiSQL.getList();
    }

    @Override
    public int createOrUpdate(LichSuThayDoi lichSuThayDoi) {
        return lichSuThayDoiSQL.createOrUpdate(lichSuThayDoi);

    }
    @Override
    public int delete(int id){
        return lichSuThayDoiSQL.delete(id);
    }
}
