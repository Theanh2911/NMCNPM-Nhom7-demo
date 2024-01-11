/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PhatThuong;

import model.QLPhatThuong.PhatThuongLe;
import service.PhatThuongLeService;
import service.PhatThuongLeServiceImpl;
import utility.ClassTableModelPhatThuongLe;
import view.PhatThuong.ThemPhatThuongLeJFrame;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ThongKePhatThuongLeController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private PhatThuongLeService phatThuongLeService = null;
    private String[] listColumn = {"Mã phát thưởng", "Mã phần thưởng", "Mã người nhận", "Người nhận", "Ngày phát thưởng"};
    private TableRowSorter<TableModel> rowSorter = null;

    public ThongKePhatThuongLeController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.phatThuongLeService = new PhatThuongLeServiceImpl();
    }
    public void setDatetoThongKePhatThuongLeTable(){
        List<PhatThuongLe> listItem = phatThuongLeService.getList();
        DefaultTableModel model = new ClassTableModelPhatThuongLe().setTablePhatThuongLe(listItem, listColumn);
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

        /*table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);*/

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    PhatThuongLe phatThuongLe = new PhatThuongLe();
                    phatThuongLe.setMaPhatThuong((int) model.getValueAt(selectedRowIndex, 0));
                    phatThuongLe.setMaPhanThuong((int) model.getValueAt(selectedRowIndex, 1));
                    phatThuongLe.setMaNguoiNhan((int) model.getValueAt(selectedRowIndex, 2));
                    phatThuongLe.setNguoiNhan((String) model.getValueAt(selectedRowIndex, 3));
                    phatThuongLe.setNgayNhan((Date) model.getValueAt(selectedRowIndex, 4));

                    ThemPhatThuongLeJFrame frame = new ThemPhatThuongLeJFrame(phatThuongLe);
                    frame.setTitle("Thông Tin Tạm Trú");
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
                ThemPhatThuongLeJFrame frame = new ThemPhatThuongLeJFrame(new PhatThuongLe());
                frame.setTitle("Khai báo phát thưởng học tập");
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
