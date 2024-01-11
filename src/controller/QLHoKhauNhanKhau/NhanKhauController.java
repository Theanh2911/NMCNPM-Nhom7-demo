/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.QLHoKhauNhanKhau.NhanKhau;
import service.HoKhauNhanKhau.NhanKhauService;
import service.HoKhauNhanKhau.NhanKhauServiceImpl;

/**
 *
 * @author admin
 */
public class NhanKhauController {
    private JTextField jtfID;
    private JTextField jtfHoTen;
    private JButton btnSubmit;
    private JTextArea jtaDiaChi;
    private JTextField jtfGioiTinh;
    private JTextArea jtaNoiSinh;
    private JDateChooser jdcNgaySinh;
    private JLabel jlbMsg;
    private NhanKhau nhanKhau = null;
    private NhanKhauService nhanKhauService = null;

    public NhanKhauController(JTextField jtfID, JTextField jtfHoTen, JButton btnSubmit, 
            JTextArea jtaDiaChi, JTextField jtfGioiTinh, JTextArea jtaNoiSinh, 
            JDateChooser jdcNgaySinh, JLabel jlbMsg) {
        this.jtfID = jtfID;
        this.jtfHoTen = jtfHoTen;
        this.btnSubmit = btnSubmit;
        this.jtaDiaChi = jtaDiaChi;
        this.jtfGioiTinh = jtfGioiTinh;
        this.jtaNoiSinh = jtaNoiSinh;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jlbMsg = jlbMsg;
        this.nhanKhauService = new NhanKhauServiceImpl();
    }


    public void setView(NhanKhau nhanKhau){
        this.nhanKhau = nhanKhau;
        jtfID.setText("#" + nhanKhau.getID());
        jtfHoTen.setText(nhanKhau.getHoTen());
        jdcNgaySinh.setDate(nhanKhau.getNgaySinh());
        jtfGioiTinh.setText(nhanKhau.getGioiTinh());
        jtaNoiSinh.setText(nhanKhau.getNoiSinh());
        jtaDiaChi.setText(nhanKhau.getDiaChi());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length() == 0 || jtaDiaChi.getText() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    nhanKhau.setHoTen(jtfHoTen.getText());
                    nhanKhau.setNgaySinh((java.sql.Date) new Date(jdcNgaySinh.getDate().getTime()));
                    nhanKhau.setGioiTinh(jtfGioiTinh.getText());
                    nhanKhau.setNoiSinh(jtaNoiSinh.getText());
                    nhanKhau.setDiaChi(jtaDiaChi.getText());
                    int lastID = nhanKhauService.createOrUpdate(nhanKhau);
                    if (lastID > 0){
//                    nhanKhau.setID(lastID);
                    jtfID.setText("#" + lastID);
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
