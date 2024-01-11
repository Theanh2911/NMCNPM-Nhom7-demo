package service.QLThuPhiDongGop;

import SQL.QLThuPhiDongGop.DongGopSQL;
import SQL.QLThuPhiDongGop.DongGopSQLImpl;
import model.QLThuPhiDongGop.DongGop;
import service.QLThuPhiDongGop.DongGopService;

import java.util.List;

public class DongGopServiceImpl implements DongGopService {
    private DongGopSQL dongGopSQL = null;

    public DongGopServiceImpl() {
        dongGopSQL = new DongGopSQLImpl();
    }


    @Override
    public List<DongGop> getList() {
        return dongGopSQL.getList();
    }

    @Override
    public int createOrUpdate(DongGop dongGop) {
        return dongGopSQL.createOrUpdate(dongGop);

    }
    @Override
    public int delete(int id){
        return dongGopSQL.delete(id);
    }
}
