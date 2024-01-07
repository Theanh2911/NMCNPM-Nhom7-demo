
package controller.QLHoKhauNhanKhau;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.QLHoKhauNhanKhau.HoKhau;
import service.HoKhauService;
import service.HoKhauServiceImpl;

/**
 *
 * @author admin
 */
public class HoKhauController {
    private JTextField jtfIDHoKhau;
    private JTextField jtfIDMaHoKhau;
    private JTextField jtfIDChuHo;
    private JTextField jtfMaKhuVuc;
    private JTextField jtfDiaChi;
    private JDateChooser jdcNgayLap;
    private JDateChooser jdcNgayChuyenDi;
    private JTextArea jtaLyDoChuyen;
    private JTextField jtfNguoiThucHien;
    private JButton btnSubmit;
    private HoKhau hoKhau = null;
    private HoKhauService hoKhauService = null;
    private JLabel jlbMsg;

    public HoKhauController(JTextField jtfIDHoKhau, JTextField jtfIDMaHoKhau, JTextField jtfIDChuHo, JTextField jtfMaKhuVuc, JTextField jtfDiaChi, JDateChooser jdcNgayLap, JDateChooser jdcNgayChuyenDi, JTextArea jtaLyDoChuyen, JTextField jtfNguoiThucHien, JButton btnSubmit,JLabel jlbMsg) {
        this.jtfIDHoKhau = jtfIDHoKhau;
        this.jtfIDMaHoKhau = jtfIDMaHoKhau;
        this.jtfIDChuHo = jtfIDChuHo;
        this.jtfMaKhuVuc = jtfMaKhuVuc;
        this.jtfDiaChi = jtfDiaChi;
        this.jdcNgayLap = jdcNgayLap;
        this.jdcNgayChuyenDi = jdcNgayChuyenDi;
        this.jtaLyDoChuyen = jtaLyDoChuyen;
        this.jtfNguoiThucHien = jtfNguoiThucHien;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.hoKhauService = new HoKhauServiceImpl();
    }

    

    public void setView(HoKhau hoKhau){
        this.hoKhau = hoKhau;
        jtfIDHoKhau.setText("#" + hoKhau.getID());
        jtfIDMaHoKhau.setText(String.valueOf(hoKhau.getMaHoKhau()));
        jtfMaKhuVuc.setText(String.valueOf(hoKhau.getMaKhuVuc()));
        jtfIDChuHo.setText(String.valueOf(hoKhau.getIdChuHo()));
        jtfDiaChi.setText(hoKhau.getDiaChi());
        jdcNgayLap.setDate(hoKhau.getNgayLap());
        jdcNgayChuyenDi.setDate(hoKhau.getNgayChuyenDi());
        jtfNguoiThucHien.setText(String.valueOf(hoKhau.getNguoiThucHien()));
        jtaLyDoChuyen.setText(hoKhau.getLyDoChuyen());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfDiaChi.getText().length() == 0 || jtaLyDoChuyen.getText() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    hoKhau.setDiaChi(jtfDiaChi.getText());
                    hoKhau.setNgayLap((java.sql.Date) new Date(jdcNgayLap.getDate().getTime()));
                    hoKhau.setNgayChuyenDi((java.sql.Date) new Date(jdcNgayChuyenDi.getDate().getTime()));
                    hoKhau.setMaHoKhau(jtfIDMaHoKhau.getText());
                    hoKhau.setMaKhuVuc(jtfMaKhuVuc.getText());
                    hoKhau.setIdChuHo(Integer.parseInt(jtfIDChuHo.getText()));
                    hoKhau.setNguoiThucHien(Integer.parseInt(jtfNguoiThucHien.getText()));
                    hoKhau.setLyDoChuyen(jtaLyDoChuyen.getText());
                    int lastID = hoKhauService.createOrUpdate(hoKhau);
                    if (lastID > 0){
//                    hoKhau.setID(lastID);
                    jtfIDHoKhau.setText("#" + lastID);
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
