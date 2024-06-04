/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import javax.swing.Timer;
import utils.*;

/**
 *
 * @author sangh
 */
public class Home extends javax.swing.JFrame {
    int index = 0;
    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        new Timer(1000, new ActionListener() {
            SimpleDateFormat fomat = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblClock.setText(fomat.format(new Date()));
            }
        }).start();
        this.openWelcome();
        this.openLogin();
    }

    private void openWelcome() {
        new ChaoJDialog(this, true).setVisible(true);
    }

    private void openLogin() {
        new DangNhapJDialog(this, true).setVisible(true);
    }

    private void openQuanLyChuyenDe() {
        new ChuyenDeJDialog(this, true).setVisible(true);
    }

    private void openHocVien() {
        new HocVienJDialog(this, true).setVisible(true);
    }

    private void openNguoiHoc() {
        new NguoiHocJDialog(this, true).setVisible(true);
    }

    private void openKhoaHoc() {
        new KhoaHocJDialog(this, true).setVisible(true);
    }

    private void openNhanVien() {
        new NhanVienJDialog(this, true).setVisible(true);
    }

    private void openThongKe(int index) {
        if (Auth.isLogin()) {
            if (index == 3 && !Auth.isManager()) {
                DialogOption.alert(this, "Bạn không có quyền xem thông tin doanh thu");
            } else {
                ThongKeJDialog tk = new ThongKeJDialog(this, true);
                tk.setVisible(true);
                tk.selectTab(index);
            }
        } else {
            DialogOption.alert(this, "Vui lòng đăng nhập!");
        }
    }

    private void openDoiMatKhau() {
        if (Auth.isLogin()) {
            new DoiMatKhau(this, true).setVisible(true);
        } else {
            DialogOption.alert(this, "Vui lòng đăng nhập!");
        }
    }

    private void dangXuat() {
        Auth.clear();
        new DangNhapJDialog(this, true).setVisible(true);
    }

    private void ketThuc() {
        if (DialogOption.confirm(this, "Bạn có muốn kết thúc làm việc?")) {
            System.exit(0);
        }
    }

    private void openHuongDan() {
        try {
            Desktop.getDesktop().browse(new File("help/index.html").toURI());
        } catch(IOException ex) {
            DialogOption.alert(this, "Không tìm thấy file  hướng dẫn!");
        }
    }

    private void openGioiThieu() {

    }

    private void startDongHo() {

    }

    public Home() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        tbnLogout = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniResetPassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniEnd = new javax.swing.JMenuItem();
        mniQuanLy = new javax.swing.JMenu();
        mniQLChuyenDe = new javax.swing.JMenuItem();
        mniQLKhoaHoc = new javax.swing.JMenuItem();
        mniQLNguoiHoc = new javax.swing.JMenuItem();
        mniQLHocVien = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniQLNhanVien = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mniTKBangDiem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniTKNguoiHoc = new javax.swing.JMenuItem();
        mniTKDiemChuyenDe = new javax.swing.JMenuItem();
        mniTKDoanhThu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ Thống Quản Lý Đào Tạo");

        jToolBar1.setRollover(true);

        tbnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        tbnLogout.setText("Đăng xuất");
        tbnLogout.setFocusable(false);
        tbnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbnLogout.setMaximumSize(new java.awt.Dimension(67, 44));
        tbnLogout.setMinimumSize(new java.awt.Dimension(67, 44));
        tbnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLogoutActionPerformed(evt);
            }
        });
        jToolBar1.add(tbnLogout);

        btnEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/end.png"))); // NOI18N
        btnEnd.setText("Kết thúc");
        btnEnd.setFocusable(false);
        btnEnd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnd.setMaximumSize(new java.awt.Dimension(67, 44));
        btnEnd.setMinimumSize(new java.awt.Dimension(67, 44));
        btnEnd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEnd);
        jToolBar1.add(jSeparator2);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ChuyenDe.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/people.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setMaximumSize(new java.awt.Dimension(67, 44));
        btnNguoiHoc.setMinimumSize(new java.awt.Dimension(67, 44));
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/course.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setMaximumSize(new java.awt.Dimension(67, 44));
        btnKhoaHoc.setMinimumSize(new java.awt.Dimension(67, 44));
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoaHoc);

        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/student.png"))); // NOI18N
        btnHocVien.setText("Học viên");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setMaximumSize(new java.awt.Dimension(67, 44));
        btnHocVien.setMinimumSize(new java.awt.Dimension(67, 44));
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocVienActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHocVien);
        jToolBar1.add(jSeparator3);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/instruct.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHuongDan);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/danger.png"))); // NOI18N
        jLabel2.setText("HỆ QUẢN LÝ ĐÀO TẠO");

        lblClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clock.png"))); // NOI18N
        lblClock.setText("12:12:12 AM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClock)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/onglopy (1).png"))); // NOI18N

        mnuSystem.setText("Hệ thống");

        mniLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/key.png"))); // NOI18N
        mniLogin.setText("Đăng nhập");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        mnuSystem.add(mniLogin);

        mniLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        mniLogout.setText("Đăng xuất");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mnuSystem.add(mniLogout);
        mnuSystem.add(jSeparator4);

        mniResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/return.png"))); // NOI18N
        mniResetPassword.setText("Đổi mật khẩu");
        mniResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniResetPasswordActionPerformed(evt);
            }
        });
        mnuSystem.add(mniResetPassword);
        mnuSystem.add(jSeparator1);

        mniEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/end.png"))); // NOI18N
        mniEnd.setText("Kết thúc");
        mniEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEndActionPerformed(evt);
            }
        });
        mnuSystem.add(mniEnd);

        jMenuBar1.add(mnuSystem);

        mniQuanLy.setText("Quản lý");

        mniQLChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ChuyenDe.png"))); // NOI18N
        mniQLChuyenDe.setText("Chuyên đề");
        mniQLChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLChuyenDeActionPerformed(evt);
            }
        });
        mniQuanLy.add(mniQLChuyenDe);

        mniQLKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/course.png"))); // NOI18N
        mniQLKhoaHoc.setText("Khóa học");
        mniQLKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLKhoaHocActionPerformed(evt);
            }
        });
        mniQuanLy.add(mniQLKhoaHoc);

        mniQLNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/people.png"))); // NOI18N
        mniQLNguoiHoc.setText("Người học");
        mniQLNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLNguoiHocActionPerformed(evt);
            }
        });
        mniQuanLy.add(mniQLNguoiHoc);

        mniQLHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/student.png"))); // NOI18N
        mniQLHocVien.setText("Học viên");
        mniQLHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLHocVienActionPerformed(evt);
            }
        });
        mniQuanLy.add(mniQLHocVien);
        mniQuanLy.add(jSeparator5);

        mniQLNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/teamwork.png"))); // NOI18N
        mniQLNhanVien.setText("Nhân viên");
        mniQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLNhanVienActionPerformed(evt);
            }
        });
        mniQuanLy.add(mniQLNhanVien);

        jMenuBar1.add(mniQuanLy);

        jMenu3.setText("Thống kê");

        mniTKBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transcript.png"))); // NOI18N
        mniTKBangDiem.setText("Bảng điểm");
        mniTKBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKBangDiemActionPerformed(evt);
            }
        });
        jMenu3.add(mniTKBangDiem);
        jMenu3.add(jSeparator6);

        mniTKNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/networking.png"))); // NOI18N
        mniTKNguoiHoc.setText("Lượng người học");
        mniTKNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKNguoiHocActionPerformed(evt);
            }
        });
        jMenu3.add(mniTKNguoiHoc);

        mniTKDiemChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bar-chart.png"))); // NOI18N
        mniTKDiemChuyenDe.setText("Điểm chuyên đề");
        mniTKDiemChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKDiemChuyenDeActionPerformed(evt);
            }
        });
        jMenu3.add(mniTKDiemChuyenDe);

        mniTKDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salary.png"))); // NOI18N
        mniTKDoanhThu.setText("Doanh thu");
        mniTKDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTKDoanhThuActionPerformed(evt);
            }
        });
        jMenu3.add(mniTKDoanhThu);

        jMenuBar1.add(jMenu3);

        mnuTroGiup.setText("Trợ giúp");

        mniHuongDan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/instruct.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn dử dụng");
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniHuongDan);
        mnuTroGiup.add(jSeparator7);

        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mniGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGioiThieuActionPerformed(evt);
            }
        });
        mnuTroGiup.add(mniGioiThieu);

        jMenuBar1.add(mnuTroGiup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        this.dangXuat();
    }//GEN-LAST:event_mniLogoutActionPerformed

    private void mniQLKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_mniQLKhoaHocActionPerformed

    private void mniQLHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLHocVienActionPerformed
        openHocVien();
    }//GEN-LAST:event_mniQLHocVienActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        this.ketThuc();
    }//GEN-LAST:event_btnEndActionPerformed

    private void mniQLChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLChuyenDeActionPerformed
        this.openQuanLyChuyenDe();
    }//GEN-LAST:event_mniQLChuyenDeActionPerformed

    private void mniQLNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_mniQLNguoiHocActionPerformed

    private void mniQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLNhanVienActionPerformed
        openNhanVien();
    }//GEN-LAST:event_mniQLNhanVienActionPerformed

    private void tbnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLogoutActionPerformed
        this.dangXuat();
    }//GEN-LAST:event_tbnLogoutActionPerformed

    private void mniResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniResetPasswordActionPerformed
        this.openDoiMatKhau();
    }//GEN-LAST:event_mniResetPasswordActionPerformed

    private void mniEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEndActionPerformed
        this.ketThuc();
    }//GEN-LAST:event_mniEndActionPerformed

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        this.openLogin();
    }//GEN-LAST:event_mniLoginActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        this.openQuanLyChuyenDe();
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
        this.openNguoiHoc();
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        this.openKhoaHoc();
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void btnHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocVienActionPerformed
        this.openHocVien();
    }//GEN-LAST:event_btnHocVienActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        this.openHuongDan();
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed
        this.openHuongDan();
    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed
        this.openGioiThieu();
    }//GEN-LAST:event_mniGioiThieuActionPerformed

    private void mniTKBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKBangDiemActionPerformed
        this.openThongKe(0);
    }//GEN-LAST:event_mniTKBangDiemActionPerformed

    private void mniTKNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKNguoiHocActionPerformed
        this.openThongKe(1);
    }//GEN-LAST:event_mniTKNguoiHocActionPerformed

    private void mniTKDiemChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKDiemChuyenDeActionPerformed
        this.openThongKe(2);
    }//GEN-LAST:event_mniTKDiemChuyenDeActionPerformed

    private void mniTKDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTKDoanhThuActionPerformed
        this.openThongKe(3);
    }//GEN-LAST:event_mniTKDoanhThuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JMenuItem mniEnd;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniQLChuyenDe;
    private javax.swing.JMenuItem mniQLHocVien;
    private javax.swing.JMenuItem mniQLKhoaHoc;
    private javax.swing.JMenuItem mniQLNguoiHoc;
    private javax.swing.JMenuItem mniQLNhanVien;
    private javax.swing.JMenu mniQuanLy;
    private javax.swing.JMenuItem mniResetPassword;
    private javax.swing.JMenuItem mniTKBangDiem;
    private javax.swing.JMenuItem mniTKDiemChuyenDe;
    private javax.swing.JMenuItem mniTKDoanhThu;
    private javax.swing.JMenuItem mniTKNguoiHoc;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JMenu mnuTroGiup;
    private javax.swing.JButton tbnLogout;
    // End of variables declaration//GEN-END:variables
}
