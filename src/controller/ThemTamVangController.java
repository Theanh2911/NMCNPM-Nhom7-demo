
package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.TamVang;
import service.TamVangService;
import service.TamVangServiceImpl;

/**
 *
 * @author admin
 */
public class ThemTamVangController {
    private JTextField jtfIdKhaiBao;
    private JTextField jtfIdNhanKhau;
    private JTextField jtfHoTen;
    private JTextArea jtaNoiDen;
    private JDateChooser jdcthoiGianKhaiBao;
    private JTextField jtfNguoiThucHien;
    private JButton btnSubmit;
    private TamVang tamVang = null;
    private TamVangService tamVangService = null;
    private JLabel jlbMsg;

    public ThemTamVangController(JTextField jtfIdKhaiBao, JTextField jtfIdNhanKhau, JTextField jtfHoTen, JTextArea jtaNoiDen, JDateChooser jdcthoiGianKhaiBao, JTextField jtfNguoiThucHien, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfIdKhaiBao = jtfIdKhaiBao;
        this.jtfIdNhanKhau = jtfIdNhanKhau;
        this.jtfHoTen = jtfHoTen;
        this.jtaNoiDen = jtaNoiDen;
        this.jdcthoiGianKhaiBao = jdcthoiGianKhaiBao;
        this.jtfNguoiThucHien = jtfNguoiThucHien;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.tamVangService = new TamVangServiceImpl();
    }

    public void setView(TamVang tamVang){
        this.tamVang = tamVang;
        jtfIdKhaiBao.setText("#" + tamVang.getIdKhaiBao());
        jtfIdNhanKhau.setText(String.valueOf(tamVang.getIdNhanKhau()));
        jtfHoTen.setText(tamVang.getHoTen());
        jtaNoiDen.setText(tamVang.getNoiDen());
        jdcthoiGianKhaiBao.setDate(tamVang.getThoiGianKhaiBao());
        jtfNguoiThucHien.setText(String.valueOf(tamVang.getNguoiThucHien()));
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtaNoiDen.getText().length() == 0 || jtfIdNhanKhau.getText().length() ==0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    tamVang.setNoiDen(jtaNoiDen.getText());
                    tamVang.setThoiGianKhaiBao((java.sql.Date) new Date(jdcthoiGianKhaiBao.getDate().getTime()));
                    tamVang.setHoTen(jtfHoTen.getText());
                    tamVang.setIdNhanKhau(Integer.parseInt(jtfIdNhanKhau.getText()));
                    tamVang.setNguoiThucHien(Integer.parseInt(jtfNguoiThucHien.getText()));
                    int lastID = tamVangService.createOrUpdate(tamVang);
                    if (lastID > 0){
//                    tamVang.setID(lastID);
                        jtfIdKhaiBao.setText("#" + lastID);
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
