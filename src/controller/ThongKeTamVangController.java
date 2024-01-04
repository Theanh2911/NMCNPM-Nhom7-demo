/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.TamVang;
import service.TamVangService;
import service.TamVangServiceImpl;
import utility.ClassTableModel4;
import view.ThemTamVangJFrame;

/**
 *
 * @author admin
 */
public class ThongKeTamVangController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private TamVangService tamVangService = null;
    private String[] listColumn = {"Id", "ID Nhân khẩu", "Họ và tên", "Nơi Đến", "Ngày thực hiện", "Người Thực Hiện"};
    private TableRowSorter<TableModel> rowSorter = null;

    public ThongKeTamVangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.tamVangService = new TamVangServiceImpl();
    }
    public void setDatetoTable4(){
        List<TamVang> listItem = tamVangService.getList();
        DefaultTableModel model = new ClassTableModel4().setTableTamVang(listItem, listColumn);
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
                    TamVang tamVang = new TamVang();
                    tamVang.setIdKhaiBao((int) model.getValueAt(selectedRowIndex, 0));
                    tamVang.setIdNhanKhau((int) model.getValueAt(selectedRowIndex, 1));
                    tamVang.setHoTen((String) model.getValueAt(selectedRowIndex, 2));
                    tamVang.setNoiDen((String) model.getValueAt(selectedRowIndex, 3));
                    tamVang.setThoiGianKhaiBao((Date) model.getValueAt(selectedRowIndex, 4));
                    tamVang.setNguoiThucHien((int) model.getValueAt(selectedRowIndex, 5));

                    ThemTamVangJFrame frame = new ThemTamVangJFrame(tamVang);
                    frame.setTitle("Thông Tin Tạm Vắng");
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
                ThemTamVangJFrame frame = new ThemTamVangJFrame(new TamVang());
                frame.setTitle("Khai báo tạm vắng");
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
