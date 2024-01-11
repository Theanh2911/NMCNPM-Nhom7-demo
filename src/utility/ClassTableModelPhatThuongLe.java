/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import model.QLPhatThuong.PhatThuongLe;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author admin
 */
public class ClassTableModelPhatThuongLe {
    public DefaultTableModel setTablePhatThuongLe(List<PhatThuongLe> listItem, String[] listColumn){
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
                PhatThuongLe phatThuongLe = listItem.get(i);
                o = new Object[columns];
                o[0] = phatThuongLe.getMaPhatThuong();
                o[1] = phatThuongLe.getMaPhanThuong();
                o[2] = phatThuongLe.getMaNguoiNhan();
                o[3] = phatThuongLe.getGiaTri();
                o[4] = phatThuongLe.getNgayNhan();
                dtm.addRow(o);
            }
        }
        return dtm;
    }

}
