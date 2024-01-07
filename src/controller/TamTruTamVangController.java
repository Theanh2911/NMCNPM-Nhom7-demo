package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.ThongKeTamTruJPanel;
import view.ThongKeTamVangJPanel;

/**
 * ThongKeController class handles button events for statistical purposes.
 */
public class TamTruTamVangController {

    public static String chosenThongKe = null;
    private JButton btnThongKeTamTru;
    private JButton btnThongKeTamVang;

    public TamTruTamVangController(JButton btnThongKeTamTru, JButton btnThongKeTamVang) {
        this.btnThongKeTamTru = btnThongKeTamTru;
        this.btnThongKeTamVang = btnThongKeTamVang;
    }

    public void setEvent(JPanel root){
        btnThongKeTamVang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeTamVang";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeTamVangJPanel());
                root.validate();
                root.repaint();
            }
        });

        btnThongKeTamTru.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeTamTru";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeTamTruJPanel());
                root.validate();
                root.repaint();
            }
        });
    }
}
