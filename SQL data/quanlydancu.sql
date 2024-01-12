create table hokhau
(
    ID            int auto_increment
        primary key,
    maHoKhau      nvarchar(100) null,
    idChuHo       int          null,
    maKhuVuc      nvarchar(100) null,
    diaChi        nvarchar(100) null,
    ngayLap       date         null,
    ngayChuyenDi  date         null,
    lyDoChuyen    text         null,
    nguoiThucHien int          null
);

create table nhankhau
(
    ID       int auto_increment
        primary key,
    HoTen    nvarchar(255) null,
    NgaySinh date         null,
    GioiTinh nvarchar(5)   null,
    DiaChi   nvarchar(255) null,
    NoiSinh  nvarchar(255) null
);

create table taikhoan
(
    IDTaiKhoan  int auto_increment
        primary key,
    TenDangNhap nvarchar(255) not null,
    MatKhau     nvarchar(255) not null,
    TinhTrang   int not null,
    VaiTro      nvarchar(255)      not null
);
create table tamtru
(
    idKhaiBao   int auto_increment
        primary key,
    idNhanKhau  int null,
    FOREIGN KEY (idNhanKhau) REFERENCES nhankhau(ID),
    hoTen     	nvarchar(100) null,
    noiTamTru        nvarchar(100) null,
    thoiGianKhaiBao       datetime         null,
    nguoiThucHien int          null
);
create table tamvang
(
    idKhaiBao   int auto_increment
        primary key,
    idNhanKhau  int null,
    FOREIGN KEY (idNhanKhau) REFERENCES nhankhau(ID),
    hoTen   nvarchar(100) null,
    noiDen  nvarchar(100) null,
    thoiGianKhaiBao datetime null,
    nguoiThucHien int          null
);

create table khoanthuphi
(
    maKhoanThu int auto_increment primary key,
    tenKhoanThu nvarchar(100) null,
    soTien int null
);
create table thuphi
(
    maHoaDon int auto_increment primary key,
    maKhoanThu int not null ,
    FOREIGN KEY (maKhoanThu) REFERENCES khoanthuphi(maKhoanThu),
    maNguoiNop int not null,
    FOREIGN KEY (maKhoanThu) REFERENCES nhankhau(ID),
    ngayDong date null,
    maNguoiThu int null
);

create table khoandonggop
(
    maKhoanDongGop int auto_increment primary key,
    tenKhoanDongGop nvarchar(100) null
);
create table donggop
(
    maHoaDon int auto_increment primary key,
    maKhoanDongGop int not null ,
    FOREIGN KEY (maKhoanDongGop) REFERENCES khoandonggop(maKhoanDongGop),
    maNguoiDongGop int not null,
    FOREIGN KEY (maNguoiDongGop) REFERENCES nhankhau(ID),
    soTien int not null,
    ngayDongGop date null,
    maNguoiThu int null
);

create table phanthuonghoctap
(
    maPhanThuong int auto_increment primary key,
    tenPhanThuong nvarchar(100) null,
    giaTri int null
);
create table phatthuonghoctap
(
    maPhatThuong int auto_increment primary key,
    maPhanThuong int not null ,
    FOREIGN KEY (maPhanThuong) REFERENCES phanthuonghoctap(maPhanThuong),
    maNguoiNhan int not null,
    FOREIGN KEY (maNguoiNhan) REFERENCES nhankhau(ID),
    nguoiNhan nvarchar(100) null,
    ngayNhan date null
);

create table phanthuongle
(
    maPhanThuong int auto_increment primary key,
    tenPhanThuong nvarchar(100) null,
    giaTri int null
);
create table phatthuongle
(
    maPhatThuong int auto_increment primary key,
    maPhanThuong int not null ,
    FOREIGN KEY (maPhanThuong) REFERENCES phanthuonghoctap(maPhanThuong),
    maNguoiNhan int not null,
    FOREIGN KEY (maNguoiNhan) REFERENCES nhankhau(ID),
    nguoiNhan nvarchar(100) null,
    ngayNhan date null
);

insert into taikhoan (IDTaiKhoan, TenDangNhap, MatKhau, TinhTrang, VaiTro)
values  (1, 'QuyDuong', '123',1, 'admin'),
        (2, 'TheAnh', '123',1, 'admin'),
        (3, 'ChienHuu', '123',1, 'admin'),
        (4, 'HuuManh', '123',1, 'admin'),
        (5, 'MinhHuyen', '321',1, 'user'),
        (6, 'TruongGiang', '321',1, 'user'),
        (7, 'QuangAnh', '321',1, 'user'),
        (8, 'DucManh', '321',1, 'user');

insert into hokhau (ID, maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen, nguoiThucHien)
values  (1, '1', 28, '1', '777 Pham Van Dong Street', '1995-02-12', null, null, null),
        (2, '2', 7, '2', '111 Nguyen Trai Road', '2002-07-08', null, null, null),
        (3, '3', 19, '1', '111 Le Lai Lane', '2010-11-20', null, null, null),
        (4, '4', 4, '1', '567 Nguyen Hue Street', '1993-03-05', null, null, null),
        (5, '5', 31, '1', '555 Nguyen Van Cu Avenue', '2015-09-17', null, null, null),
        (6, '6', 3, '1', '789 Nguyen Van Linh Road', '2007-05-30', null, null, null),
        (7, '7', 12, '1', '888 Tran Hung Dao Road, Rach Gia', '1998-10-09', null, null, null),
        (8, '8', 20, '2', '444 Tran Phu Road', '2005-04-22', null, null, null),
        (9, '9', 16, '1', '333 Le Loi Street', '1991-12-03', null, null, null),
        (10, '10', 25, '3', '222 Ly Tu Trong Street, Haiphong', '2019-08-14', null, null, null);

insert into nhankhau (ID, HoTen, NgaySinh, GioiTinh, DiaChi, NoiSinh)
values  (1, 'Nguyen Minh', '1990-06-15', 'Nam', '123 Tran Hung Dao Street, Hanoi', 'Hanoi'),
        (2, 'Tran Thi Mai', '1985-09-28', 'Nữ', '456 Le Loi Avenue, Ho Chi Minh City', 'Ho Chi Minh'),
        (3, 'Pham Van Anh', '1993-03-12', 'Nữ', '789 Nguyen Van Linh Road, Da Nang', 'Da Nang'),
        (4, 'Le Duc Khanh', '1988-11-05', 'Nam', '567 Nguyen Hue Street, Hue', 'Hue'),
        (5, 'Vo Thanh Long', '1996-07-20', 'Nam', '321 Le Lai Boulevard, Hai Phong', 'Hai Phong'),
        (6, 'Bui Ngoc Trang', '1991-12-04', 'Nữ', '234 Tran Phu Lane, Can Tho', 'Can Tho'),
        (7, 'Hoang Dinh Nhan', '1983-04-18', 'Nam', '111 Nguyen Trai Road, Vinh', 'Vinh'),
        (8, 'Do Thi Thu', '1998-02-25', 'Nữ', '999 Phan Chu Trinh Street, Nha Trang', 'Nha Trang'),
        (9, 'Trinh Van Huy', '1995-10-10', 'Nam', '777 Ly Tu Trong Avenue, Quy Nhon', 'Quy Nhon'),
        (10, 'Nguyen Thi Lan', '1989-08-07', 'Nữ', '222 Nam Ky Khoi Nghia Street, Vung Tau', 'Vung Tau'),
        (11, 'Mai Xuan Thanh', '1992-01-30', 'Nam', '444 Le Duan Street, Buon Ma Thuot', 'Buon Ma Thuot'),
        (12, 'Huynh Minh Tuan', '1997-05-22', 'Nam', '888 Tran Hung Dao Road, Rach Gia', 'Rach Gia'),
        (13, 'Le Thi Kim', '1994-08-14', 'Nữ', '555 Nguyen Trai Street, Hanoi', 'Hanoi'),
        (14, 'Nguyen Van Thanh', '1987-03-27', 'Nam', '777 Le Van Sy Avenue, Ho Chi Minh City', 'Ho Chi Minh'),
        (15, 'Tran Van Long', '1999-05-09', 'Nam', '888 Pham Van Dong Road, Da Nang', 'Da Nang'),
        (16, 'Pham Thi Hanh', '1990-10-03', 'Nữ', '333 Le Loi Street, Hue', 'Hue'),
        (17, 'Vo Ngoc Trung', '1996-11-18', 'Nam', '222 Tran Hung Dao Boulevard, Hai Phong', 'Hai Phong'),
        (18, 'Bui Thi Mai', '1992-12-25', 'Nữ', '999 Nguyen Van Cu Street, Can Tho', 'Can Tho'),
        (19, 'Hoang Van Nam', '1988-01-30', 'Nam', '111 Le Lai Lane, Vinh', 'Vinh'),
        (20, 'Do Van Khanh', '1997-09-22', 'Nam', '444 Tran Phu Road, Nha Trang', 'Nha Trang'),
        (21, 'Trinh Thi Linh', '1991-06-08', 'Nữ', '777 Phan Chu Trinh Avenue, Quy Nhon', 'Quy Nhon'),
        (22, 'Nguyen Van Hieu', '1985-04-17', 'Nam', '888 Le Hong Phong Street, Vung Tau', 'Vung Tau'),
        (23, 'Mai Thi Ngoc', '1993-07-21', 'Nữ', '555 Le Duan Avenue, Buon Ma Thuot', 'Buon Ma Thuot'),
        (24, 'Huynh Van Minh', '1998-02-05', 'Nam', '333 Nguyen Trai Road, Rach Gia', 'Rach Gia'),
        (25, 'Le Van Tuan', '1989-11-11', 'Nam', '222 Ly Tu Trong Street, Haiphong', 'Haiphong'),
        (26, 'Nguyen Thi An', '1995-09-03', 'Nữ', '111 Tran Hung Dao Avenue, Hanoi', 'Hanoi'),
        (27, 'Tran Van Duc', '1990-12-19', 'Nam', '888 Le Van Sy Road, Ho Chi Minh City', 'Ho Chi Minh'),
        (28, 'Pham Thi Mai', '1997-04-26', 'Nữ', '777 Pham Van Dong Street, Da Nang', 'Da Nang'),
        (29, 'Vo Van Huy', '1984-10-14', 'Nam', '333 Le Loi Road, Hue', 'Hue'),
        (30, 'Bui Van Anh', '1996-08-28', 'Nam', '999 Tran Hung Dao Boulevard, Hai Phong', 'Hai Phong'),
        (31, 'Hoang Thi Lan', '1991-03-02', 'Nữ', '555 Nguyen Van Cu Avenue, Can Tho', 'Can Tho'),
        (32, 'Do Van Nam', '1987-07-09', 'Nam', '111 Le Lai Street, Vinh', 'Vinh');

insert into tamtru (idKhaiBao, idNhanKhau, hoTen, noiTamTru, thoiGianKhaiBao, nguoiThucHien)
values (1, 1, 'Nguyen Minh', '283 Khuong Trung', null, null),
       (2,2,'Tran Thi Mai', '198 Cau Giay',null, null);

insert into tamvang (idKhaiBao, idNhanKhau, hoTen, noiDen, thoiGianKhaiBao, nguoiThucHien)
values (1, 3, 'Pham Van Anh', '283 Khuong Trung', null, null),
       (2,4,'Le Duc Khanh', '198 Cau Giay',null, null);

INSERT INTO khoanthuphi (maKhoanThu, tenKhoanThu, soTien)
VALUES (1, 'Phí vệ sinh',6000);

insert into khoandonggop(maKhoanDongGop,tenKhoanDongGop)
values(1,'Ủng hộ trẻ em vùng cao 2023'),
      (2,'Quỹ từ thiện tình thương 2023');
insert into phanthuonghoctap(maPhanThuong,tenPhanThuong,giaTri)
values(1,'Thưởng học sinh xuất sắc',100000),
      (2,'Thưởng học sinh giỏi',50000),
      (3,'Thưởng học sinh khá',30000);
insert into phanthuongle(maPhanThuong,tenPhanThuong,giaTri)
values(1,'Thưởng Tết Nguyên Đán',50000),
      (2,'Thưởng Tết Thiếu nhi 1-6',50000),
      (3,'Thưởng Trung Thu',30000);


