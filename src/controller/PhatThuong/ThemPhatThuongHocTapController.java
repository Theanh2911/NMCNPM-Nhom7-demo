
package controller.PhatThuong;

import com.toedter.calendar.JDateChooser;
import model.QLPhatThuong.PhatThuongHocTap;
import service.PhatThuong.PhatThuongHocTapService;
import service.PhatThuong.PhatThuongHocTapServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class ThemPhatThuongHocTapController {
    private JTextField jtfMaPhatThuong;
    private JTextField jtfTenPhanThuong;
    private JTextField jtfGiaTri;
    private JTextField jtfMaNguoiNhan;
    private JTextField jtfNguoiNhan;
    private JDateChooser jdcNgayNhan;
//    private JTextField jtfNguoiThucHien;
    private JButton btnSubmit;
    private PhatThuongHocTap phatThuongHocTap = null;
    private PhatThuongHocTapService phatThuongHocTapService = null;
    private JLabel jlbMsg;

    public ThemPhatThuongHocTapController(JTextField jtfMaPhatThuong, JTextField jtfTenPhanThuong, JTextField jtfGiaTri, JTextField jtfMaNguoiNhan, JTextField jtfNguoiNhan, JDateChooser jdcNgayNhan, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfMaPhatThuong = jtfMaPhatThuong;
        this.jtfTenPhanThuong = jtfTenPhanThuong;
        this.jtfGiaTri = jtfGiaTri;
        this.jtfMaNguoiNhan = jtfMaNguoiNhan;
        this.jtfNguoiNhan = jtfNguoiNhan;
        this.jdcNgayNhan = jdcNgayNhan;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.phatThuongHocTapService = new PhatThuongHocTapServiceImpl();
    }

    public void setView(PhatThuongHocTap phatThuongHocTap){
        this.phatThuongHocTap = phatThuongHocTap;
        jtfMaPhatThuong.setText("#" + phatThuongHocTap.getMaPhatThuong());
        jtfTenPhanThuong.setText(phatThuongHocTap.getTenPhanThuong());
        jtfGiaTri.setText(String.valueOf(phatThuongHocTap.getGiaTri()));
        jtfMaNguoiNhan.setText(String.valueOf(phatThuongHocTap.getMaNguoiNhan()));
        jtfNguoiNhan.setText(phatThuongHocTap.getNguoiNhan());
        jdcNgayNhan.setDate(phatThuongHocTap.getNgayNhan());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfMaNguoiNhan.getText().length() == 0 || jtfMaPhatThuong.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    phatThuongHocTap.setMaPhatThuong(Integer.parseInt(jtfMaPhatThuong.getText()));
                    phatThuongHocTap.setTenPhanThuong(jtfTenPhanThuong.getText());
                    phatThuongHocTap.setGiaTri(Integer.parseInt(jtfGiaTri.getText()));
                    phatThuongHocTap.setMaNguoiNhan(Integer.parseInt(jtfMaNguoiNhan.getText()));
                    phatThuongHocTap.setNguoiNhan(jtfNguoiNhan.getText());
                    phatThuongHocTap.setNgayNhan((Date) new Date(jdcNgayNhan.getDate().getTime()));
                    int lastID = phatThuongHocTapService.createOrUpdate(phatThuongHocTap);
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
