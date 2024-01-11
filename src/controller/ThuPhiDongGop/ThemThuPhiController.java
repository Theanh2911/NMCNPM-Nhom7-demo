
package controller.ThuPhiDongGop;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.QLThuPhiDongGop.ThuPhi;
import service.QLThuPhiDongGop.ThuPhiService;
import service.QLThuPhiDongGop.ThuPhiServiceImpl;

/**
 *
 * @author admin
 */
public class ThemThuPhiController {
    private JTextField jtfMaHoaDon;
    private JTextField jtfMaNguoiNop;
    private JTextField jtfMaKhoanThu;
    private JTextField jtfSoTien;
    private JDateChooser jdcNgayThuPhi;
    private JTextField jtfMaNguoiThu;
    private JButton btnSubmit;
    private ThuPhi thuPhi = null;
    private ThuPhiService thuPhiService = null;
    private JLabel jlbMsg;

    public ThemThuPhiController(JTextField jtfMaHoaDon, JTextField jtfMaKhoanThu, JTextField jtfMaNguoiNop, JTextField jtfSoTien, JDateChooser jdcNgayThuPhi, JTextField jtfMaNguoiThu, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfMaHoaDon = jtfMaHoaDon;
        this.jtfMaKhoanThu = jtfMaKhoanThu;
        this.jtfMaNguoiNop = jtfMaNguoiNop;
        this.jtfSoTien = jtfSoTien;
        this.jdcNgayThuPhi = jdcNgayThuPhi;
        this.jtfMaNguoiThu = jtfMaNguoiThu;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.thuPhiService = new ThuPhiServiceImpl();
    }

    public void setView(ThuPhi thuPhi){
        this.thuPhi = thuPhi;
        jtfMaHoaDon.setText("#" + thuPhi.getMaHoaDon());
        jtfMaNguoiNop.setText(String.valueOf(thuPhi.getMaNguoiNop()));
        jtfMaKhoanThu.setText(thuPhi.getTenKhoanThu());
        jtfSoTien.setText(String.valueOf(thuPhi.getSoTien()));
        jdcNgayThuPhi.setDate(thuPhi.getNgayDong());
        jtfMaNguoiThu.setText(String.valueOf(thuPhi.getMaNguoiThu()));
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfSoTien.getText().isEmpty() || jtfMaNguoiNop.getText().isEmpty()){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    thuPhi.setMaHoaDon(Integer.parseInt(jtfMaHoaDon.getText()));
                    thuPhi.setNgayDong((java.sql.Date) new Date(jdcNgayThuPhi.getDate().getTime()));
                    thuPhi.setMaKhoanThu(Integer.parseInt(jtfMaKhoanThu.getText()));
                    thuPhi.setMaNguoiNop(Integer.parseInt(jtfMaNguoiNop.getText()));
                    thuPhi.setSoTien(Integer.parseInt(jtfSoTien.getText()));
                    thuPhi.setMaNguoiThu(Integer.parseInt(jtfMaNguoiThu.getText()));

                    int lastID = thuPhiService.createOrUpdate(thuPhi);
                    if (lastID > 0){
//                    thuPhi.setID(lastID);
                        jtfMaHoaDon.setText("#" + lastID);
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
