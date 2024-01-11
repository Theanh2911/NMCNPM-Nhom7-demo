package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.QLThuPhiDongGop.ThuPhi;

    /**
     *
     * @author admin
     */
public class ClassThuPhiTableModel {
        public DefaultTableModel setTableThuPhi(List<ThuPhi> listItem, String[] listColumn) {
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
                    ThuPhi thuPhi = listItem.get(i);
                    o = new Object[columns];
                    o[0] = thuPhi.getMaHoaDon();
                    o[1] = thuPhi.getMaKhoanThu();
                    o[2] = thuPhi.getMaNguoiNop();
                    o[3] = thuPhi.getSoTien();
                    o[4] = thuPhi.getNgayDong();
                    o[5] = thuPhi.getMaNguoiThu();
                    dtm.addRow(o);
                }
            }
            return dtm;
        }
}
    
