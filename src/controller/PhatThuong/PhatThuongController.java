package controller.PhatThuong;

import view.PhatThuong.ThongKePhatThuongLeJPanel;
import view.PhatThuong.ThongKePhatThuongHocTapJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ThongKeController class handles button events for statistical purposes.
 */
public class PhatThuongController {

    public static String chosenThongKe = null;
    private JButton btnThongKePhatThuongHocTap;
    private JButton btnThongKePhatThuongLe;

    public PhatThuongController(JButton btnThongKePhatThuongHocTap, JButton btnThongKePhatThuongLe) {
        this.btnThongKePhatThuongHocTap = btnThongKePhatThuongHocTap;
        this.btnThongKePhatThuongLe = btnThongKePhatThuongLe;
    }

    public void setEvent(JPanel root){
        btnThongKePhatThuongHocTap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeTamVang";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKePhatThuongHocTapJPanel());
                root.validate();
                root.repaint();
            }
        });

        btnThongKePhatThuongLe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeTamTru";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKePhatThuongLeJPanel());
                root.validate();
                root.repaint();
            }
        });
    }
}
