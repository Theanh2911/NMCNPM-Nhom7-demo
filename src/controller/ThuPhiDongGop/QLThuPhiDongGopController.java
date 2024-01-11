package controller.ThuPhiDongGop;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.ThuPhiDongGop.DongGopJPanel;
import view.ThuPhiDongGop.ThuPhiJPanel;

/**
 * ThongKeController class handles button events for statistical purposes.
 */
public class QLThuPhiDongGopController {

    public static String chosenThongKe = null;
    private JButton btnQuanLyThuPhi;
    private JButton btnQuanLyDongGop;

    public QLThuPhiDongGopController(JButton btnQuanLyThuPhi, JButton btnQuanLyDongGop) {
        this.btnQuanLyThuPhi = btnQuanLyThuPhi;
        this.btnQuanLyDongGop = btnQuanLyDongGop;
    }

    public void setEvent(JPanel root){
        btnQuanLyThuPhi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "QuanLyThuPhi";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThuPhiJPanel());
                root.validate();
                root.repaint();
            }
        });

        btnQuanLyDongGop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeDongGop";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new DongGopJPanel());
                root.validate();
                root.repaint();
            }
        });
    }
}
