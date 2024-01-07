package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.DangNhap.DangNhapJDialog;
import view.TrangChu.MainJFrame;
public class Main {
    public static void main(String[] args) {
        //new MainJFrame().setVisible(true);
        try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
