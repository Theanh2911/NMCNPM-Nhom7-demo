/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PhatThuong;

import model.QLPhatThuong.PhatThuongHocTap;
import service.PhatThuong.PhatThuongHocTapService;
import service.PhatThuong.PhatThuongHocTapServiceImpl;
import utility.ClassTableModelPhatThuongHocTap;
import view.PhatThuong.ThemPhatThuongHocTapJFrame;

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
public class ThongKePhatThuongHocTapController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private PhatThuongHocTapService phatThuongHocTapService = null;
    private String[] listColumn = {"Mã phát thưởng", "Mã phần thưởng", "Mã người nhận", "Người nhận", "Ngày phát thưởng"};
    private TableRowSorter<TableModel> rowSorter = null;

    public ThongKePhatThuongHocTapController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.phatThuongHocTapService = new PhatThuongHocTapServiceImpl();
    }
    public void setDatetoThongKePhatThuongHocTapTable(){
        List<PhatThuongHocTap> listItem = phatThuongHocTapService.getList();
        DefaultTableModel model = new ClassTableModelPhatThuongHocTap().setTablePhatThuongHocTap(listItem, listColumn);
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
                    PhatThuongHocTap phatThuongHocTap = new PhatThuongHocTap();
                    phatThuongHocTap.setMaPhatThuong((int) model.getValueAt(selectedRowIndex, 0));
                    phatThuongHocTap.setMaPhanThuong((int) model.getValueAt(selectedRowIndex, 1));
                    phatThuongHocTap.setMaNguoiNhan((int) model.getValueAt(selectedRowIndex, 2));
                    phatThuongHocTap.setNguoiNhan((String) model.getValueAt(selectedRowIndex, 3));
                    phatThuongHocTap.setNgayNhan((Date) model.getValueAt(selectedRowIndex, 4));

                    ThemPhatThuongHocTapJFrame frame = new ThemPhatThuongHocTapJFrame(phatThuongHocTap);
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
                ThemPhatThuongHocTapJFrame frame = new ThemPhatThuongHocTapJFrame(new PhatThuongHocTap());
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
