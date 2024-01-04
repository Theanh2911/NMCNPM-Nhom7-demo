/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.TamTru;

/**
 *
 * @author admin
 */
public class ClassTableModel2 {
    public DefaultTableModel setTableTamTru(List<TamTru> listItem, String[] listColumn){
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
                TamTru tamTru = listItem.get(i);
                o = new Object[columns];
                o[0] = tamTru.getIdKhaiBao();
                o[1] = tamTru.getIdNhanKhau();
                o[2] = tamTru.getHoTen();
                o[3] = tamTru.getNoiTamTru();
                o[4] = tamTru.getThoiGianKhaiBao();
                o[5] = tamTru.getNguoiThucHien();
                dtm.addRow(o);
            }
        }
        return dtm;
        
    }
    
}
