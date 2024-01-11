/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.QLHoKhauNhanKhau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.QLHoKhauNhanKhau.HoKhau;
import service.HoKhauNhanKhau.HoKhauService;
import service.HoKhauNhanKhau.HoKhauServiceImpl;
import utility.ClassTableModel3;
import view.QLHoKhauNhanKhau.HoKhauJFrame;

/**
 *
 * @author admin
 */
public class QuanLyHoKhauController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private HoKhauService hoKhauService = null;
    private String[] listColumn = {"ID", "Mã Hộ Khẩu", "ID Chủ Hộ", "Mã Khu Vực", "Địa chỉ", "Ngày Lập", "Ngày Chuyển Đi", "Lý Do Chuyển", "Người Thực Hiện"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHoKhauController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.hoKhauService = new HoKhauServiceImpl();
    }
    public void setDatetoTable3(){
        List<HoKhau> listItem = hoKhauService.getList();
        DefaultTableModel model = new ClassTableModel3().setTableHoKhau(listItem, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0 ){
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 String text = jtfSearch.getText();
                if(text.trim().length() == 0 ){
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    HoKhau hoKhau = new HoKhau();
                    hoKhau.setID((int) model.getValueAt(selectedRowIndex, 0));
                    hoKhau.setMaHoKhau((String)model.getValueAt(selectedRowIndex, 1));
                    hoKhau.setIdChuHo((int) model.getValueAt(selectedRowIndex, 2));
                    hoKhau.setMaKhuVuc((String) model.getValueAt(selectedRowIndex, 3));
                    hoKhau.setDiaChi((String) model.getValueAt(selectedRowIndex, 4));
                    hoKhau.setNgayLap((Date) model.getValueAt(selectedRowIndex, 5));
                    hoKhau.setNgayChuyenDi((Date) model.getValueAt(selectedRowIndex, 6));
                    hoKhau.setLyDoChuyen((String)model.getValueAt(selectedRowIndex, 7));
                    hoKhau.setNguoiThucHien((int) model.getValueAt(selectedRowIndex, 8));
                    
                    HoKhauJFrame frame = new HoKhauJFrame(hoKhau);
                    frame.setTitle("Thông Tin Hộ Khẩu");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }

            }
            
        });
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
        public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            HoKhauJFrame frame = new HoKhauJFrame(new HoKhau());
            frame.setTitle("Thêm Mới Hộ Khẩu");
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));

            }
            
            
        });
    }
    
}
