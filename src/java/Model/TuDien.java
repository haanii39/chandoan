/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thanh
 */
public class TuDien {
    public static final HashMap<String, String> tudien = new HashMap<String, String>();
    public Map<String, String> getMap(){
        return tudien;
    }
    static
    {
        //Chung
        tudien.put("BT", "Bình thường");
        
        // Nhóm bệnh
        tudien.put("HoHap", "Hô hấp");
        tudien.put("Tim", "Tim");
        tudien.put("Gan","Gan");
        tudien.put("TieuHoa","Tiêu hóa");
        
        // Bệnh Tiêu hóa
        tudien.put("ViemRuotThua", "Viêm ruột thừa");
        tudien.put("ViemDaDayRuot","Viêm dạ dày");
        tudien.put("ViemLoetDaDay","Viêm loét dạ dày");
        tudien.put("TraoNguocDaDay","Trào ngược dạ dày");
        
        // Bệnh hô hấp
        tudien.put("CamCum","Cảm cúm");
        tudien.put("ViemMuiDiUng","Viêm mũi dị ứng");
        tudien.put("HenSuyen","Hen suyễn");
        tudien.put("ViemPheQuan","Viêm phế quản");
        tudien.put("ViemPhoi","Viêm phổi");
        
        //Triệu chứng
        
        //Ho
        tudien.put("Dam","Ho có đàm");
        tudien.put("Mau","Ho ra máu");
        tudien.put("Khan","Ho khan");
        
        //Kho Tho
        tudien.put("ThoKhoKhe","Thở khò khè");
        tudien.put("ThoGap","Thở gấp");
        tudien.put("ThoCham","Thở chậm");
        
        //Sot
        tudien.put("SotCao","Sốt cao");
        tudien.put("SotNhe","Sốt nhẹ");
        tudien.put("SotKOD","Sốt không ổn định");
        
        //Mui
        tudien.put("NghetMui","Nghẹt mũi");
        tudien.put("ChayNuocMui","Chảy nước mũi");
        tudien.put("HatHoi","Hắt hơi");
        
        //Hong
        tudien.put("DauHong","Đau họng");
        tudien.put("RatHong","Rát họng");
        tudien.put("NguaHong","Ngứa họng");
        
        //Toan Than
        tudien.put("DauCo","Đau cổ");
        tudien.put("NguaHong","Ngứa họng");
        tudien.put("DauNguc","Đau ngực");
        tudien.put("MetMoi","Mệt mỏi");
        
        //Ăn uống        
        tudien.put("KhoNuot","Khó nuốt");
        tudien.put("ChanAn","Chán ăn");
        tudien.put("KNgon","Ăn không ngon");
        
        //Bụng
        tudien.put("DauBung","Đau bụng");
        tudien.put("ChuongBung","Chướng bụng");
        tudien.put("SungDau","Sưng đau");
        
        //Cảm giác
        tudien.put("BuonNon","Buồn nôn");
        tudien.put("DayHoi","Đầy hơi");
        tudien.put("OChua","Ợ chua");
        tudien.put("NonRaMau","Nôn ra máu");
        
        //Triệu chứng
        tudien.put("TaoBon","Táo bón");
        tudien.put("TieuChay","Tiêu chảy");
        tudien.put("TraoNguocTA","Trào ngược thức ăn");
        
        //Cân nặng
        tudien.put("Giam","Giảm");
        tudien.put("Tang","Tăng");
        
        //Da
        tudien.put("Vang","Vàng");
        tudien.put("TimTai","Tím tái");
        tudien.put("Kho","Khô");
        tudien.put("Mun","Nổi mụn");
        
        //Ngực
        tudien.put("DauNguc","Đau ngực");
        tudien.put("TucNguc","Tức ngực");
        tudien.put("NangNguc","Nặng ngực");
        
        //Thể trạng
        tudien.put("ThieuSinhLuc","Lờ đờ uể oải");
        tudien.put("KTapTrung","Không tập trung");
        tudien.put("MatPH","Mất phương hướng");
    }

    
    
    
}
