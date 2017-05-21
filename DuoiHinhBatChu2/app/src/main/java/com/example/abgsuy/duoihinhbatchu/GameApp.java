package com.example.abgsuy.duoihinhbatchu;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Abgsuy on 04/05/2017.
 */

public class GameApp extends Application{

    private List<ObjectGames> mListObject;
    private static int score = 0;
    private static int life = 3;
    private static int suggest = 3;
    private static int hightScore = 1;
    private boolean check = true;
    private int ran;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    private void initComponent() {
        mListObject = new ArrayList<>();
        mListObject.add(new ObjectGames(R.drawable.aimo,"AIMO","AMALKUOEAIPNGTBC"));
        mListObject.add(new ObjectGames(R.drawable.anhhao,"ANHHAO","HUOMALKUEAPNGHBC"));
        mListObject.add(new ObjectGames(R.drawable.aomua,"AOMUA","HUOMALKUEAPNGTBC"));
        mListObject.add(new ObjectGames(R.drawable.bamoi,"BAMOI","BUOMALIUEAPNKPUE"));
        mListObject.add(new ObjectGames(R.drawable.baocao,"BAOCAO","AUOMBLKUEAPNOTAC"));
        mListObject.add(new ObjectGames(R.drawable.baothuc,"BAOTHUC","HUOCALTUEAONGTBA"));
        mListObject.add(new ObjectGames(R.drawable.baxa,"BAXA","HUOMALKUEAXNGTBC"));
        mListObject.add(new ObjectGames(R.drawable.bongda,"BONGDA","DAOMALKUEAPNGABE"));
        mListObject.add(new ObjectGames(R.drawable.canthiep,"CANTHIEP","DCEAYUNPTOHSIVEP"));
        mListObject.add(new ObjectGames(R.drawable.chim_chich_bong,"CHIMCHICHBONG","GCHIBMCIHUOUMNHC"));
        mListObject.add(new ObjectGames(R.drawable.congbo,"CONGBO","CUOMABKOEAPNGTBC"));
        mListObject.add(new ObjectGames(R.drawable.daituong,"DAITUONG","TUOMNLKUDAINGTBC"));
        mListObject.add(new ObjectGames(R.drawable.detien,"DETIEN","EUTMAIDUEAPNGTBN"));
        mListObject.add(new ObjectGames(R.drawable.hailong,"HAILONG","LUONAGKUEAINGABH"));
        mListObject.add(new ObjectGames(R.drawable.hanhha,"HANHHA","UOHALNKUEAPHGTHA"));
        mListObject.add(new ObjectGames(R.drawable.hoidong,"HOIDONG","THYUOIODPONMKLDG"));
        mListObject.add(new ObjectGames(R.drawable.hongtam,"HONGTAM","HOMNALGKUETPNATBM"));
        mListObject.add(new ObjectGames(R.drawable.kichthich,"KICHTHICH","HTCMILKHKIACNHTKC"));
        mListObject.add(new ObjectGames(R.drawable.ke_cong,"KECONG","CKEIEMCVGUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.kiemchuyen,"KIEMCHUYEN","GKEIEMCVHUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.luclac,"LUCLAC","LKUIEACVHCYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.macarong,"MACARONG","GMEAERCVOUNUECOA"));
        mListObject.add(new ObjectGames(R.drawable.muinhon,"MUINHON","MKNIEMCUHUYIENOL"));
        mListObject.add(new ObjectGames(R.drawable.ngangu,"NGANGU","GKNIAMCNHUYUEUOG"));
        mListObject.add(new ObjectGames(R.drawable.nguao,"NGUAO","OKUIEMAVHUYGENOL"));
        mListObject.add(new ObjectGames(R.drawable.nhaccu,"NHACCU","GCEIEMCVHUYUANOU"));
        mListObject.add(new ObjectGames(R.drawable.nhahat,"NHAHAT","GHEIEMCAHUYTENOA"));
        mListObject.add(new ObjectGames(R.drawable.nhanduc,"NHANDUC","CKHIENCVHUYAENND"));
        mListObject.add(new ObjectGames(R.drawable.noithat,"NOITHAT","TKOIEMCTHUAUENOL"));
        mListObject.add(new ObjectGames(R.drawable.ruatien,"RUATIEN","KEIENCVRUAYUENOT"));
        mListObject.add(new ObjectGames(R.drawable.songsong,"SONGSONG","OOEINMCGGUNUSSOL"));
        mListObject.add(new ObjectGames(R.drawable.taihoa,"TAIHOA","IKAIETCVHUAUENOL"));
        mListObject.add(new ObjectGames(R.drawable.thankhoc,"THANKHOC","HKEOEMCVHUYUANOT"));
        mListObject.add(new ObjectGames(R.drawable.thongtan,"THONGTAN","TGEIHMOTHUAUENON"));
        mListObject.add(new ObjectGames(R.drawable.tichphan,"TICHPHAN","PKEITMCHHUYUENOA"));
        mListObject.add(new ObjectGames(R.drawable.traicay,"TRAICAY","YKTIERCAHUCUEYOA"));
        mListObject.add(new ObjectGames(R.drawable.traumong,"TRAUMONG","MREITMCVGUYUENOA"));
        mListObject.add(new ObjectGames(R.drawable.vuaphaluoi,"VUAPHALUOI","VKAIAPCVHUIUENOL"));
        mListObject.add(new ObjectGames(R.drawable.vuonbachthu,"VUONBACHTHU","BHAICMCTHUVUENOL"));
        mListObject.add(new ObjectGames(R.drawable.xichlo,"XICHLO","XKEIEMCVHUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.am_u,"AMU","MKAIEMCVHUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.ban_han,"BANHAN","HKBIEACVHAYUNNOL"));
        mListObject.add(new ObjectGames(R.drawable.bao_la_cai,"BAOLACAI","CKAIEBCVAULUENOA"));
        mListObject.add(new ObjectGames(R.drawable.be_tha,"BETHA","AKEIEMCVHHATENOB"));
        mListObject.add(new ObjectGames(R.drawable.bo_be,"BOBE","XBEIEMCVHUBUENOL"));
        mListObject.add(new ObjectGames(R.drawable.bo_gia,"BOGIA","GKEIEACVBUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.bo_phieu,"BOPHIEU","PKEIEMCVHUYUENOB"));
        mListObject.add(new ObjectGames(R.drawable.bong_bong_nha_nuoc,"BONGBONGNHANUOC","UNGAGHCBBONONNON"));
        mListObject.add(new ObjectGames(R.drawable.ca_tung,"CATUNG","CKEIEMCVAUTUENOG"));
        mListObject.add(new ObjectGames(R.drawable.cai_tien,"CAITIEN","CKAIEMTVHUYIENOL"));
        mListObject.add(new ObjectGames(R.drawable.cam_on,"CAMON","XCEIAMCVHUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.canh_me,"CANHME","MKEIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.cau_truc,"CAUTRUC","TKECEACVHAYUEUOR"));
        mListObject.add(new ObjectGames(R.drawable.cong_cu,"CONGCU","CKGIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.cuu_canh,"CUUCANH","AKECENCVHUYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.canh_me,"CANHME","MKEIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.dai_duong,"DAIDUONG","DKDIEGCIHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.dau_co,"DAUCO","OKEIEMCVHADUENOC"));
        mListObject.add(new ObjectGames(R.drawable.diem_sinh,"DIEMSINH","MKEIEDCVSAIUENOH"));
        mListObject.add(new ObjectGames(R.drawable.duong_cach_mang,"DUONGCACHMANG","ANDGEMCHOAGUANOC"));
        mListObject.add(new ObjectGames(R.drawable.duongtinh,"DUONGTINH","NTEIEHCVDAGUENOL"));
        mListObject.add(new ObjectGames(R.drawable.ganh_hat,"GANHHAT","GKEAENHVHAYTENOL"));
        mListObject.add(new ObjectGames(R.drawable.hochoi,"HOCHOI","HKOIECCVHAYIENOL"));
        mListObject.add(new ObjectGames(R.drawable.keo_luoi,"KEOLUOI","OKEIEICVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.khihocogay,"KHIHOCOGAY","HKEIEHCVOAYGENOL"));
        mListObject.add(new ObjectGames(R.drawable.canh_me,"CANHME","MKEIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.mi_tom,"MITOM","MKETEMCMHAIUENOL"));
        mListObject.add(new ObjectGames(R.drawable.mo_kim_day_be,"MOKIMDAYBE","MKEIEMCDHAYBENOL"));
        mListObject.add(new ObjectGames(R.drawable.mung_tho,"MUNGTHO","MKEUEGCVNATUHNOL"));
        mListObject.add(new ObjectGames(R.drawable.noi_dong_coi_da,"NOIDONGCOIDA","NADIEDCOHAGOINOL"));
        mListObject.add(new ObjectGames(R.drawable.ngoai_o,"NGOAIO","OKNIGMCVIAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.nhac_nuoc,"NHACNUOC","NKCIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.phat_tai,"PHATTAI","TTEIEMCVHAYPEAOL"));
        mListObject.add(new ObjectGames(R.drawable.canh_me,"CANHME","MKEIEMCVHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.quay_quan,"QUAYQUAN","QKEIANCVUAYUQNOL"));
        mListObject.add(new ObjectGames(R.drawable.quy_tien,"QUYTIEN","TKEIENCVHAYUENQL"));
        mListObject.add(new ObjectGames(R.drawable.soi_dong,"SOISONG","SKEIEMDVOANUGNOG"));
        mListObject.add(new ObjectGames(R.drawable.son_tinh,"SONTINH","NKEIETCVHASUENOL"));
        mListObject.add(new ObjectGames(R.drawable.sot_ruot,"SOTRUOT","RKEISMCTHOTUENOL"));
        mListObject.add(new ObjectGames(R.drawable.tay_hom_chia_khoa,"TAYHOMCHIAKHOA","HKAIEOCTHAYMEHOA"));
        mListObject.add(new ObjectGames(R.drawable.tham_canh,"THAMCANH","MKETEMCVHAYUANOH"));
        mListObject.add(new ObjectGames(R.drawable.thanh_cong,"THANHCONG","CKEIGMCTHAYUENHL"));
        mListObject.add(new ObjectGames(R.drawable.thu_nho,"THUNHO","HTEINMCHHAYUENOL"));
        mListObject.add(new ObjectGames(R.drawable.trong_cay_chuoi,"TRONGCAYCHUOI","TREREGCIHAYCUNOH"));
        mListObject.add(new ObjectGames(R.drawable.tre_gia_mang_moc,"TREGIAMANGMOC","MTRECGCIHAACONGM"));
        mListObject.add(new ObjectGames(R.drawable.trang_luoi_liem,"TRANGLUOILIEM","TRELEGLIEAMCUNOG"));
        mListObject.add(new ObjectGames(R.drawable.trong_trang,"TRONGTRANG","TRTREGOINAYCUNAG"));
        mListObject.add(new ObjectGames(R.drawable.vai_tro,"VAITRO","ATRREGVIHAYCUNOH"));
        mListObject.add(new ObjectGames(R.drawable.vit_troi,"VITROI","TRERVGTIHAYCUNOI"));
        mListObject.add(new ObjectGames(R.drawable.xa_mat_cach_long,"XAMATCACHLONG","GOLRAGXNMACTUCAH"));
    }

    public ObjectGames getObjects(){
        Random random = new Random();
        ran = random.nextInt(mListObject.size());
        ObjectGames objectGames = mListObject.get(ran);
        return objectGames;
    }

    public void remove(){
        if (check == true){
            mListObject.remove(ran);
        }
    }

    public String getMessage(String check) {
        if(check == "correct"){
            return "Chính xác!";
        }
        else
            return "Sai!";
    }

    public void setCheck(boolean ch){
        check = ch;
    }

    public void setScore(){
        score += 10;
    }

    public int getScore(){
        return score;
    }

    public int getHightScore(){
        return hightScore;
    }

    public void setHightScore(){
        if (score > hightScore)
            hightScore = score;
    }

    public void setLife(){
        life--;
    }

    public int getLife(){
        return life;
    }

    public int getSuggest() {
        return suggest;
    }

    public void setSuggest() {
        suggest--;
    }
}
