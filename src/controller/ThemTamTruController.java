
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
import model.TamTru;
import model.TamTru;
import service.TamTruService;
import service.TamTruServiceImpl;

/**
 *
 * @author admin
 */
public class ThemTamTruController {
    private JTextField jtfIdKhaiBao;
    private JTextField jtfIdNhanKhau;
    private JTextField jtfHoTen;
    private JTextField jtfNoiTamTru;
    private JDateChooser jdcthoiGianKhaiBao;
    private JTextField jtfNguoiThucHien;
    private JButton btnSubmit;
    private TamTru tamTru = null;
    private TamTruService tamTruService = null;
    private JLabel jlbMsg;

    public ThemTamTruController(JTextField jtfIdKhaiBao, JTextField jtfIdNhanKhau, JTextField jtfHoTen,JTextField jtfNoiTamTru, JDateChooser jdcthoiGianKhaiBao, JTextField jtfNguoiThucHien, JButton btnSubmit) {
        this.jtfIdKhaiBao = jtfIdKhaiBao;
        this.jtfIdNhanKhau = jtfIdNhanKhau;
        this.jtfHoTen = jtfHoTen;
        this.jtfNoiTamTru = jtfNoiTamTru;
        this.jtfNguoiThucHien = jtfNguoiThucHien;
        this.btnSubmit = btnSubmit;
        this.tamTruService = new TamTruServiceImpl();
    }



    public void setView(TamTru tamTru){
        this.tamTru = tamTru;
        jtfIdKhaiBao.setText("#" + tamTru.getIdKhaiBao());
        jtfIdNhanKhau.setText("#" + tamTru.getIdNhanKhau());
        jtfHoTen.setText("#" + tamTru.getHoTen());
        jtfNoiTamTru.setText("#" + tamTru.getNoiTamTru());
        jdcthoiGianKhaiBao.setDate(tamTru.getThoiGianKhaiBao());
        jtfNguoiThucHien.setText("#"+ tamTru.getNguoiThucHien());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfNoiTamTru.getText().length() == 0 || jtfIdNhanKhau.getText().length() ==0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    tamTru.setNoiTamTru(jtfNoiTamTru.getText());
                    tamTru.setThoiGianKhaiBao((java.sql.Date) new Date(jdcthoiGianKhaiBao.getDate().getTime()));
                    tamTru.setHoTen(jtfHoTen.getText());
                    tamTru.setIdNhanKhau(Integer.parseInt(jtfIdNhanKhau.getText()));
                    tamTru.setNguoiThucHien(Integer.parseInt(jtfNguoiThucHien.getText()));
                    int lastID = tamTruService.createOrUpdate(tamTru);
                    if (lastID > 0){
//                    tamTru.setID(lastID);
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
