/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import model.QLPhatThuong.PhatThuongHocTap;

/**
 *
 * @author admin
 */
public class ClassTableModelPhatThuongHocTap {
    public DefaultTableModel setTablePhatThuongHocTap(List<PhatThuongHocTap> listItem, String[] listColumn){
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
                PhatThuongHocTap phatThuongHocTap = listItem.get(i);
                o = new Object[columns];
                o[0] = phatThuongHocTap.getMaPhatThuong();
                o[1] = phatThuongHocTap.getMaPhanThuong();
                o[2] = phatThuongHocTap.getTenPhanThuong();
                o[3] = phatThuongHocTap.getMaNguoiNhan();
                o[4] = phatThuongHocTap.getGiaTri();
                o[5] = phatThuongHocTap.getNgayNhan();
                dtm.addRow(o);
            }
        }
        return dtm;
    }

}
