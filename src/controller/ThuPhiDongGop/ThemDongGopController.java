
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
import model.QLThuPhiDongGop.DongGop;
import service.QLThuPhiDongGop.DongGopService;
import service.QLThuPhiDongGop.DongGopServiceImpl;

/**
 *
 * @author admin
 */
public class ThemDongGopController {
    private JTextField jtfMaHoaDon;
    private JTextField jtfTenNguoiDongGop;
    private JTextField jtfMaNguoiDongGop;
    private JTextField jtfTenKhoanDongGop;
    private JTextField jtfSoTien;
    private JDateChooser jdcNgayDongGop;
    private JTextField jtfMaNguoiThu;
    private JButton btnSubmit;
    private DongGop dongGop = null;
    private DongGopService dongGopService = null;
    private JLabel jlbMsg;

    public ThemDongGopController(JTextField jtfMaHoaDon, JTextField jtfTenNguoiDongGop, JTextField jtfMaNguoiDongGop, JTextField jtfTenKhoanDongGop, JTextField jtfSoTien, JDateChooser jdcNgayDongGop, JTextField jtfMaNguoiThu, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfMaHoaDon = jtfMaHoaDon;
        this.jtfTenNguoiDongGop = jtfTenNguoiDongGop;
        this.jtfMaNguoiDongGop = jtfMaNguoiDongGop;
        this.jtfTenKhoanDongGop = jtfTenKhoanDongGop;
        this.jtfSoTien = jtfSoTien;
        this.jdcNgayDongGop = jdcNgayDongGop;
        this.jtfMaNguoiThu = jtfMaNguoiThu;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.dongGopService = new DongGopServiceImpl();
    }

    public void setView(DongGop dongGop){
        this.dongGop = dongGop;
        jtfMaHoaDon.setText("#" + dongGop.getMaHoaDon());
        jtfTenNguoiDongGop.setText(dongGop.getTenNguoiDongGop());
        jtfMaNguoiDongGop.setText(String.valueOf(dongGop.getMaNguoiDongGop()));
        jtfTenKhoanDongGop.setText(dongGop.getTenKhoanDongGop());
        jtfSoTien.setText(String.valueOf(dongGop.getSoTien()));
        jdcNgayDongGop.setDate(dongGop.getNgayDongGop());
        jtfMaNguoiThu.setText(String.valueOf(dongGop.getMaNguoiThu()));
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfSoTien.getText().isEmpty() || jtfMaNguoiDongGop.getText().isEmpty()){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    dongGop.setMaHoaDon(Integer.parseInt(jtfMaHoaDon.getText()));
                    dongGop.setNgayDongGop((java.sql.Date) new Date(jdcNgayDongGop.getDate().getTime()));
                    dongGop.setTenNguoiDongGop(jtfTenNguoiDongGop.getText());
                    dongGop.setMaNguoiDongGop(Integer.parseInt(jtfMaNguoiDongGop.getText()));
                    dongGop.setSoTien(Integer.parseInt(jtfSoTien.getText()));
                    dongGop.setMaNguoiThu(Integer.parseInt(jtfMaNguoiThu.getText()));

                    int lastID = dongGopService.createOrUpdate(dongGop);
                    if (lastID > 0){
//                    dongGop.setID(lastID);
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
