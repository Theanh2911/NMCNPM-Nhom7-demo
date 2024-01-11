package service.PhatThuong;

import SQL.PhatThuong.PhatThuongLeSQL;
import SQL.PhatThuong.PhatThuongLeSQLIpml;
import model.QLPhatThuong.PhatThuongLe;

import java.util.List;

public class PhatThuongLeServiceImpl implements PhatThuongLeService {

    private PhatThuongLeSQL phatThuongLeSQL = null;

    public PhatThuongLeServiceImpl(){
        phatThuongLeSQL = new PhatThuongLeSQLIpml();
    }

    @Override
    public List<PhatThuongLe> getList() {
        return phatThuongLeSQL.getList();
    }

    @Override
    public int createOrUpdate(PhatThuongLe phatThuongLe) {
        return phatThuongLeSQL.createOrUpdate(phatThuongLe);
    }

    @Override
    public int delete(int id) {
        return phatThuongLeSQL.delete(id);
    }
}
