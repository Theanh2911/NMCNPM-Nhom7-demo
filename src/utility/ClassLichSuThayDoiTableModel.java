package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.LichSuThayDoi;

/**
 *
 * @author admin
 */
public class ClassLichSuThayDoiTableModel {
    public DefaultTableModel setTableLichSuThayDoi(List<LichSuThayDoi> listItem, String[] listColumn) {
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
                LichSuThayDoi lichSuThayDoi = listItem.get(i);
                o = new Object[columns];
                o[0] = lichSuThayDoi.getLoaiThayDoi();
                o[1] = lichSuThayDoi.getMaViTri();
                o[2] = lichSuThayDoi.getNoiDung();
                o[3] = lichSuThayDoi.getThoiGian();
                dtm.addRow(o);
            }
        }
        return dtm;
    }
}
    
