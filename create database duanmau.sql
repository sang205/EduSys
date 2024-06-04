create database duanmau
use duanmau

create table NhanVien (
	MaNV nvarchar(10) primary key,
	MatKhau nvarchar(20)not null,
	HoTen nvarchar(50)not null,
	VaiTro bit not null
	)
go
Create table ChuyenDe(
	MaCD nvarchar(10) primary key,
	TenCD nvarchar(100),
	MoTa text,
	HocPhi float not null,
	ThoiLuong int,
	Hinh nvarchar(50) not null
	)
go
create table KhoaHoc(
	MaKH int identity(1,1) primary key,
	MaCD nvarchar(10) not null,
	HocPhi float,
	ThoiLuong int not null,
	NgayKG date not null,
	GhiChu nvarchar(50),
	MaNV nvarchar(10) not null,
	NGayTao date not null,
	foreign key (MaCD) references ChuyenDe(MaCD)on delete no action on update cascade,
	foreign key(MaNV) references NhanVien(MaNV) on delete no action on update cascade
	)
go
create table NguoiHoc(
	MaNH nvarchar(7) primary key,
	HoTen nvarchar(50) not null, 
	NgaySinh date not null,
	GioiTinh bit not null,
	DienThoai nvarchar(20) not null,
	Email nvarchar(50) not null,
	GhiChu text,
	MaNV nvarchar(10) not null,
	NgayDK date not null,
	foreign key (MaNV) references NhanVien(MaNV) on delete no action on update cascade
	)
go
create table HocVien(
	MaHV int identity(1,1) primary key,
	MaKH int not null,
	MaNH nvarchar(7) not null,
	Diem float not null,
	foreign key(MaNH) references NguoiHoc(MaNH) on delete no action on update cascade,
	foreign key(MaKH) references KhoaHoc(MaKH)
	)
	