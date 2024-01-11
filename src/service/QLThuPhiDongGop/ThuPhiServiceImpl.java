package service.QLThuPhiDongGop;

import SQL.QLThuPhiDongGop.ThuPhiSQL;
import SQL.QLThuPhiDongGop.ThuPhiSQLImpl;
import model.QLThuPhiDongGop.ThuPhi;
import service.QLThuPhiDongGop.ThuPhiService;

import java.util.List;

public class ThuPhiServiceImpl implements ThuPhiService {
    private ThuPhiSQL thuPhiSQL = null;

    public ThuPhiServiceImpl() {
        thuPhiSQL = new ThuPhiSQLImpl();
    }


    @Override
    public List<ThuPhi> getList() {
        return thuPhiSQL.getList();
    }

    @Override
    public int createOrUpdate(ThuPhi thuPhi) {
        return thuPhiSQL.createOrUpdate(thuPhi);

    }
    @Override
    public int delete(int id){
        return thuPhiSQL.delete(id);
    }
}
