package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.QLThuPhiDongGop.DongGop;

/**
 *
 * @author admin
 */
public class ClassDongGopTableModel {
    public DefaultTableModel setTableDongGop(List<DongGop> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] o = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                DongGop dongGop = listItem.get(i);
                o = new Object[columns];
                o[0] = dongGop.getMaHoaDon();
                o[1] = dongGop.getMaKhoanDongGop();
                o[2] = dongGop.getMaNguoiDongGop();
                o[3] = dongGop.getSoTien();
                o[4] = dongGop.getNgayDongGop();
                o[5] = dongGop.getMaNguoiThu();
                dtm.addRow(o);
            }
        }
        return dtm;
    }
}
    
