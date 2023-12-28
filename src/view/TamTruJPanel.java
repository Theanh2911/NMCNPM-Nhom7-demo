package view;

import controller.QuanLyNhanKhauController;

public class TamTruJPanel extends javax.swing.JPanel{
    /**
     * Creates new form NhanKhauJPanel
     */
    public TamTruJPanel() {
        initComponents();
        QuanLyNhanKhauController controller = new QuanLyNhanKhauController(jpnView, btnAdd, jtfSearch);
        controller.setDatetoTable();
        controller.setEvent();
    }
}
