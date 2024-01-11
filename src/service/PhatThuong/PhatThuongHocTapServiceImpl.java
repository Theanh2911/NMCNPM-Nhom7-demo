package service.PhatThuong;

import SQL.PhatThuong.PhatThuongHocTapSQL;
import SQL.PhatThuong.PhatThuongHocTapSQLIpml;
import model.QLPhatThuong.PhatThuongHocTap;

import java.util.List;

public class PhatThuongHocTapServiceImpl implements PhatThuongHocTapService {

    private PhatThuongHocTapSQL phatThuongHocTapSQL = null;

    public PhatThuongHocTapServiceImpl(){
        phatThuongHocTapSQL = new PhatThuongHocTapSQLIpml();
    }

    @Override
    public List<PhatThuongHocTap> getList() {
        return phatThuongHocTapSQL.getList();
    }

    @Override
    public int createOrUpdate(PhatThuongHocTap phatThuongHocTap) {
        return phatThuongHocTapSQL.createOrUpdate(phatThuongHocTap);
    }

    @Override
    public int delete(int id) {
        return phatThuongHocTapSQL.delete(id);
    }
}
