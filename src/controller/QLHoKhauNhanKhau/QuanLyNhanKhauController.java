
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
import model.QLHoKhauNhanKhau.NhanKhau;
import service.NhanKhauService;
import service.NhanKhauServiceImpl;
import utility.ClassTableModel;
import view.QLHoKhauNhanKhau.NhanKhauJFrame;

/**
 *
 * @author admin
 */
public class QuanLyNhanKhauController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private NhanKhauService nhanKhauService = null;
    private String[] listColumn = {"ID", "Họ và Tên", "Ngày sinh", "Giới tính", "Nơi sinh", "Địa chỉ"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhanKhauController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nhanKhauService = new NhanKhauServiceImpl();
    }
    public void setDatetoTable(){
        List<NhanKhau> listItem = nhanKhauService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNhanKhau(listItem, listColumn);
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
                    NhanKhau nhanKhau = new NhanKhau();
                    nhanKhau.setID((int) model.getValueAt(selectedRowIndex, 0));
                    nhanKhau.setHoTen(model.getValueAt(selectedRowIndex, 1).toString());
                    nhanKhau.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 2));
                    nhanKhau.setGioiTinh(model.getValueAt(selectedRowIndex, 3).toString());
                    nhanKhau.setNoiSinh((String) model.getValueAt(selectedRowIndex, 4));
                    nhanKhau.setDiaChi((String) model.getValueAt(selectedRowIndex, 5));
                    
                    NhanKhauJFrame frame = new NhanKhauJFrame(nhanKhau);
                    frame.setTitle("Thông Tin Nhân Khẩu");
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
            NhanKhauJFrame frame = new NhanKhauJFrame(new NhanKhau());
            frame.setTitle("Thêm Mới Nhân Khẩu");
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
