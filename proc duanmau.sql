use duanmau
go 
--Report: MaNH - HoTen -Diem
create proc sp_BangDiem(@MaKH int)
as begin 
	select 
		nh.MaNH,
		nh.HoTen,
		hv.Diem
	From HocVien hv
		Join NguoiHoc nh On nh.MaNH = hv.MaNH
	Where hv.MaKH = @MaKH
	ORDER BY hv.Diem desc
end
go
--Report: TenCD - SoHV - Thap_Nhat - Cao_nhat - Trung_binh
create proc sp_ThongKeDiem
As begin 
	select 
		TenCD ChuyenDe,
		Count(MaHV) SoHV,
		Min(Diem) ThapNhat,
		Max(Diem) CaoNhat,
		AVG(Diem) TrungBinh
	From KhoaHoc kh
			join HocVien hv on kh.MaKH = hv.MaKH
			join ChuyenDe cd on cd.MaCD = kh.MaCD
	Group by TenCD
end
go
--Report: TenCD - SoKH - SoHV - Doanh_thu - Thap_nhat - Cao_nhat - Trung_binh
create proc sp_ThongKeDoanhThu(@year int)
as begin 
	select 
		TenCD ChuyenDe,
		Count(Distinct kh.MaKH) SoKH,
		Count(hv.MaHV) SoHV,
		Sum(kh.HocPhi) DoanhThu,
		Min(kh.HocPhi) ThapNhat,
		Max(kh.HocPhi) CaoNhat,
		Avg(kh.Hocphi) TrungBinh
	From KhoaHoc kh
		Join HocVien hv on kh.MaKh = hv.MaKH
		join ChuyenDe cd on cd.MaCD = kh.maCD
	Where year(NgayKG) = @year
	group by TenCD
end 
go
-- Report: Nam - SoLuong - DauTien - CuoiCung
Create proc sp_ThongKeNuoiHoc
as begin
	select	
		Year(NgayDk) Nam,
		Count(*) SoLuong,
		Min(NgayDK) DauTien,
		Max(NgayDK) CuoiCung
	From NguoiHoc
	Group By year(NgayDK)
end
--Insert into ChuyenDe(MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) Values(?, ?, ?, ?, ?, ?)
--Update ChuyenDe Set MaCD = ?, TenCD = ?, HocPhi = ?, ThoiLuong = ?, Mota = ? Where MaCD = ?
--Delete From ChuyenDe Where MaCD = ?
--Select * From ChuyenDe where MaCD = ?
