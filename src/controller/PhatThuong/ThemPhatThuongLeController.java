
package controller.PhatThuong;

import com.toedter.calendar.JDateChooser;
import model.QLPhatThuong.PhatThuongLe;
import service.PhatThuong.PhatThuongLeService;
import service.PhatThuong.PhatThuongLeServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class ThemPhatThuongLeController {
    private JTextField jtfMaPhatThuong;
    private JTextField jtfTenPhanThuong;
    private JTextField jtfGiatri;
    private JTextField jtfMaNguoiNhan;
    private JTextField jtfNguoiNhan;
    private JDateChooser jdcNgayNhan;
//    private JTextField jtfNguoiThucHien;
    private JButton btnSubmit;
    private PhatThuongLe phatThuongLe = null;
    private PhatThuongLeService phatThuongLeService = null;
    private JLabel jlbMsg;

    public ThemPhatThuongLeController(JTextField jtfMaPhatThuong, JTextField jtfTenPhanThuong, JTextField jtfMaNguoiNhan, JTextField jtfNguoiNhan,JTextField jtfGiaTri, JDateChooser jdcNgayNhan, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfMaPhatThuong = jtfMaPhatThuong;
        this.jtfTenPhanThuong = jtfTenPhanThuong;
        this.jtfMaNguoiNhan = jtfMaNguoiNhan;
        this.jtfNguoiNhan = jtfNguoiNhan;
        this.jtfGiatri = jtfGiaTri;
        this.jdcNgayNhan = jdcNgayNhan;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.phatThuongLeService = new PhatThuongLeServiceImpl();
    }

    public void setView(PhatThuongLe phatThuongLe){
        this.phatThuongLe = phatThuongLe;
        jtfMaPhatThuong.setText("#" + phatThuongLe.getMaPhatThuong());
        jtfTenPhanThuong.setText(phatThuongLe.getTenPhanThuong());
        jtfMaNguoiNhan.setText(String.valueOf(phatThuongLe.getMaNguoiNhan()));
        jtfNguoiNhan.setText(phatThuongLe.getNguoiNhan());
        jtfGiatri.setText(String.valueOf(phatThuongLe.getGiaTri()));
        jdcNgayNhan.setDate(phatThuongLe.getNgayNhan());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfMaNguoiNhan.getText().length() == 0 || jtfMaPhatThuong.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    phatThuongLe.setMaPhatThuong(Integer.parseInt(jtfMaPhatThuong.getText()));
                    phatThuongLe.setTenPhanThuong(jtfTenPhanThuong.getText());
                    phatThuongLe.setMaNguoiNhan(Integer.parseInt(jtfMaNguoiNhan.getText()));
                    phatThuongLe.setNguoiNhan(jtfNguoiNhan.getText());
                    phatThuongLe.setGiaTri(Integer.parseInt(jtfGiatri.getText()));
                    phatThuongLe.setNgayNhan((Date) new Date(jdcNgayNhan.getDate().getTime()));
                    int lastID = phatThuongLeService.createOrUpdate(phatThuongLe);
                    if (lastID > 0){
//                    tamTru.setID(lastID);
                        jtfMaPhatThuong.setText("#" + lastID);
                        jlbMsg.setText("Thêm Mới Dữ Liệu Thành Công");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));

            }
        });
    }

}
