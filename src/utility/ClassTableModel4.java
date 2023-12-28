package utility;

import model.TamVang;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClassTableModel4 {
    public DefaultTableModel setTableKhaiBao(List<TamVang> listItem, String[] listColumn){
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
                o[0] = tamVang.getIDKhaiBao();
                o[1] = tamVang.getIDNhanKhau();
                o[2] = tamVang.getVungDich();
                o[3] = tamVang.getBieuHien();
                o[4] = tamVang.getNgayKhaiBao();
                dtm.addRow(o);
            }
        }
        return dtm;

    }
}
