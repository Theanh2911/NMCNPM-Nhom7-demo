package controller.ThongKe;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.ThongKe.ThongKeNhanKhauJPanel;

/**
 * ThongKeController class handles button events for statistical purposes.
 */
public class ThongKeController {

    public static String chosenThongKe = null;
    private JButton btnThongKeCachLy;
    private JButton btnThongKeHoKhau;
    private JButton btnThongKeNhanKhau;

    public ThongKeController(JButton btnThongKeCachLy, JButton btnThongKeKiemTra, JButton btnThongKeNhanKhau) {
        this.btnThongKeCachLy = btnThongKeCachLy;
        this.btnThongKeHoKhau = btnThongKeKiemTra;
        this.btnThongKeNhanKhau = btnThongKeNhanKhau;
    }

    public void setEvent(JPanel root){
        btnThongKeCachLy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeCachLy";
                // Handle the action here if needed
            }
        });

        btnThongKeHoKhau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeKiemTra";
                // Handle the action here if needed
            }
        });

        btnThongKeNhanKhau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeNhanKhau";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeNhanKhauJPanel());
                root.validate();
                root.repaint();
            }
        });
    }
}
