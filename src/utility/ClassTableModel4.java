package utility;

import model.TamTruTamVang.TamVang;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClassTableModel4 {
    public DefaultTableModel setTableTamVang(List<TamVang> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] o = null;
        int rows = listItem.size();
        if (rows > 0){
            for(int i = 0; i< rows; i++){
                TamVang tamVang = listItem.get(i);
                o = new Object[columns];
                o[0] = tamVang.getIdKhaiBao();
                o[1] = tamVang.getIdNhanKhau();
                o[2] = tamVang.getHoTen();
                o[3] = tamVang.getNoiDen();
                o[4] = tamVang.getThoiGianKhaiBao();
                o[5] = tamVang.getNguoiThucHien();
                dtm.addRow(o);
            }
        }
        return dtm;

    }
}
