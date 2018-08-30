package com.first.app.util;

public class ConstantaVariable {
	
	public final static String IP_ADDRESS_JDV = "http://10.254.208.23:8080/";
	public final static String VDB_JDV = "ProgModelVDB_1/";
	
	public static class SLIK_URL {
//		public final static String URL_AFTER_LOGIN = "slik/SG73200375";
//		public final static String URL_PETUGAS_PERMINTAAN_INFORMASI = "slik/authentication/change-group/15";
	}

	public static class ENCRYPT {
		public final static String KEY = "ARMSTheSecretIngredients";	// 128 bit key
		public final static String INIT_VECTOR = "RandomInitVector";	// 16 bytes IV
	}
	
	public static class INTERAKTIF_TYPE {
		public final static String INDIVIDUAL = "individual";	
		public final static String CORPORATE = "corporate";	
	}
	
	public static class ERR_STEP {
		public final static String ERR_LOGIN = "ERROR LOGIN";
		public final static String FAIL_LOGIN = "LOGIN FAILED";
		public final static String ERR_AFTER_LOGIN = "ERROR AFTER LOGIN";
		public final static String ERR_BUTTON_SELENGKAPNYA = "ERROR CLICK BUTTON SELENGKAPNYA";
		public final static String ERR_MENU_SUBMENU_PETUGAS_PERMINTAAN_INFORMASI = "ERROR CLICK SUBMENU PETUGAS PERMINTAAN INFORMASI";
		public final static String ERR_MENU_PERMINTAAN_DATA = "ERROR CLICK MENU PERTMINTAAN DATA";
		public final static String ERR_MENU_UPLOAD_FILE_BATCH = "ERROR CLICK MENU UPLOAD FILE BATCH";
		public final static String ERR_UPLOAD_FILE_BATCH = "ERROR UPLOAD FILE BATCH";
		public final static String ERR_DOWNLOAD_IDEB = "ERROR DOWNLOAD IDEB";
		public final static String ERR_MENU_INDIVIDUAL = "ERROR CLICK MENU INDIVIDUAL";
		public final static String ERR_MENU_BADANUSAHA = "ERROR CLICK MENU BADAN USAHA";
		public final static String ERR_DATA_INDIVIDUAL = "ERROR FILL DATA INDIVIDUAL";
		public final static String ERR_DATA_BADAN_USAHA = "ERROR FILL DATA BADAN USAHA";
		public final static String ERR_CHECK_RESULT_INDIVIDUAL = "ERROR CHECK RESULT DATA INDIVIDUAL";
		public final static String ERR_BTN_HASILKAN_IDEB = "ERROR CLICK BUTTON HASILKAN IDEB";
		public final static String ERR_BTN_CEK_HASIL = "ERROR CLICK BUTTON CEK HASIL PERMINTAAN IDEB";
		public final static String ERR_GET_KODE_INQUIRY_INDIVIDUAL = "ERROR CLICK BUTTON CEK HASIL PERMINTAAN IDEB";
		
		
		public final static String ERR_NO_DATA_FOUND_INDIVIDUAL = "DATA NOT FOUND";
	}
	
	public static class LOG_MSG {
		public final static String SUCCES_LOGIN = "LOGIN SUCCESS";
		public final static String SUCCES_FILL_DATA = "FILL DATA SUCCESS";
		public final static String SUCCES_DOWNLOAD = "DOWNLOAD SUCCESS";
		
		public final static String ERR_LOGIN = "LOGIN ERROR";
		public final static String ERR_FILL_DATA = "FILL DATA ERROR";
		public final static String ERR_DOWNLOAD = "DOWNLOAD ERROR";
	}
	
	public static class LOG {
		public final static String FILEJOB = "job.file";
		public final static String UPLOADJOB = "job.upload";
	}
	
	
	public static class METADATA {
		public final static String LOV = "LovMetadata/";
	}

	
	public static class LovPrefix {
		public static String GET_LOV_JENIS_PAJAK = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_jenis_pajak";
		public static String GET_LOV_JENIS_PERMOHONAN = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_jenis_permohonan";
		public static String GET_LOV_NAMA_PELAKSANA = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_nama_pelaksana";
		public static String GET_LOV_DITERIMA_MELALUI = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_diterima_melalui";
		public static String GET_LOV_PEGAWAI = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_pegawai";
		public static String GET_LOV_STATUS_PERSETUJUAN = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_status_persetujuan";
		public static String GET_LOV_KATEGORI_KASUS = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_kategori_kasus";
		public static String GET_LOV_KLASIFIKASI = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_klasifikasi";
		public static String GET_LOV_MASA_PAJAK = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_masa_pajak";
		public static String GET_LOV_JENIS_DOKUMEN = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_jenis_dokumen";
		public static String GET_LOV_KEPUTUSAN = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_keputusan";
		public static String GET_LOV_SIFAT_SURAT = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_sifat_surat";
		public static String GET_LOV_ZONE_TIME = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_zone_time";
		public static String GET_LOV_JENIS_DOKUMEN_UNGGAH = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_jenis_dokumen_unggah";
		public static String GET_LOV_JENIS_DOKUMEN_CETAK_ULANG = IP_ADDRESS_JDV + VDB_JDV + METADATA.LOV + "lov_jenis_dokumen_cetakulang";
		public static String GET_LOV_ST_PENGGANTI = IP_ADDRESS_JDV + VDB_JDV + "STPenggantiMetadata/" + "lov_st_pengganti";
		public static String GET_LOV_ST_PK = IP_ADDRESS_JDV + VDB_JDV + "STPenggantiMetadata/" + "lov_pk";
	}
	
	


	public static class ERR_MSG {
		public final static String ERRAPP_AC1 = "Can not create session!\n please contact admin";
		public final static String ERRAPP_AC2 = "Server Ad1Access sedang sibuk. Cobalah beberapa saat lagi.";
		public final static String ERRAPP_AC3 = "Username atau Password tidak sesuai!";
		public final static String ERRAPP_AC4 = "Username tidak boleh kosong!";
		public final static String ERRAPP_AC5 = "Password tidak boleh kosong!";
	}

	public static class MSG {
		public final static String UPLOAD_SUCCESS = "{\"message\":\"UPLOAD SUCCESS\"}";
		public final static String UPLOAD_FAILED = "{\"message\":\"UPLOAD FAILED\"}";
		public final static String SUCCESS = "{\"message\":\"SAVE SUCCESS\"}";
		public final static String FAILED = "{\"message\":\"SAVE FAILED\"}";
		public final static String SUCCESS_IDEB = "{\"message\":\"IDEB BATCH SUCCESS\"}";
		public final static String SUCCESS_IDEB_INTERAKTIF = "{\"message\":\"IDEB INTERAKTIF SUCCESS\"}";
		public final static String DELETE_SUCCESS = "{\"message\":\"DELETE SUCCESS\"}";
		public final static String DELETE_FAILED = "{\"message\":\"DELETE FAILED\"}";
		public final static String SUCCESS_CONVERT = "{\"message\":\"CONVERT IDEB TO JSON SUCCESS\"}";
		public final static String FAILED_CONVERT = "{\"message\":\"CONVERT IDEB TO JSON FAILED\"}";
		public final static String ROLE_EMPTY = "{\"message\":\"DATA ROLE EMPTY\"}";
		public final static String SUCCESS_LIST_IDEB_INTERAKTIF = "IDEB INTERAKTIF SUCCESS";
		
		public final static String START_JOB_SUCCESS = "{\"message\":\"START SUCCESS\"}";
		public final static String STOP_JOB_SUCCESS = "{\"message\":\"STOP SUCCESS\"}";
		public final static String START_JOB_FAILED = "{\"message\":\"START FAILED\"}";
		public final static String STOP_JOB_FAILED = "{\"message\":\"STOP FAILED\"}";
		
		public final static String SUCCESS_CONVERT_STAT = "CONVERT SUCCESS";
		public final static String FAILED_CONVERT_STAT = "CONVERT FAILED";
		public final static String DOWNLOAD_SUCCESS = "DOWNLOAD SUCCESS";
		public final static String DOWNLOAD_FAILED = "DOWNLOAD FAILED";
		public final static String NODATA_BATCH = "NO DATA FOUND";
		public final static String SUCCESS_LIST_IND_INTERAKTIF = "LIST DATA INDIVIDUAL INTERACTIVE SUCCESS";
		public final static String SUCCESS_LIST_COR_INTERAKTIF = "LIST DATA CORPORATE INTERACTIVE SUCCESS";
		public final static String MANDATORY_IS_NULL = "DATA MANDATORY NULL";
		public final static String AUTH_FAILED = "APLIKASI ARMS INI TIDAK VALID, HARAP HUBUNGI PIHAK PT. TEKNO GLOBAL MULTI SISTEM INTEGRASI";
		
		public final static String RESULT_FILE_SUCCESS = "9";
		public final static String RESULT_FILE_FAILED = "1";
	}
	
	public static class Cetak {
		public static String TESTING = "report/testing.jrxml";
		public static String LPADBPS = "report/LPADBPS.jrxml";
		public static String LAMPIRAN_SURAT_KEBERATAN = "report/DokLampiranSuratKeberatan.jrxml";
		public static String LEMBAR_ISIAN_KELENGKAPAN_BERKAS = "report/lembarIsianKelengkapanBerkas.jrxml";
		public static String LEMBAR_PENGAWASAN_PENELITIAN = "report/LembarPengawasanPenelitianBerkasKeberatan.jrxml";
		public static String SURAT_PENGANTAR = "report/SuratPengantar.jrxml";
		public static String SURAT_TUGAS = "report/SuratTugas.jrxml";
		public static String LEMBAR_PENELITIAN_SYARAT = "report/LembarPenenelitianSyaratSK.jrxml";
		public static String SURAT_TIDAK_MEMENUHI_SYARAT = "report/SuratTidakMemenuhiSyarat.jrxml";
		public static String SURAT_HADIR = "report/SuratPemberitahuanHadir.jrxml";
		public static String SURAT_KEBERATAN = "report/SKKeberatan.jrxml";
		public static String SURAT_TUGAS_PENGGANTI = "report/SuratTugasPengganti.jrxml";
	}
	
	public static class UPLOAD_DATA {
		public static String STATUS = "STATUS";
		public static String STATUS_ERROR = "ERROR";
		public static String STATUS_SUCCESS = "SUKSES";
		public static String MESSAGE = "MESSAGE";
		public static String ERROR_MESSAGE = "ERROR_MESSAGE";
		public static String LIST_INDIVIDU = "LIST_INDIVIDU";
		public static String REJECT = "REJECT";
	}
	
	public static class PARAM {
		public static String PATH = "PATH";
		public static String SLIK = "SLIK";
		public static String URL = "URL";
		public static String JOB = "JOB";
		public static String FILE = "FILE";
		public static String ELEMENT = "ELEMENT";
		public static String DRIVER_GECKO = "DRIVER_GECKO";
		public static String DRIVER_FILE_UPLOAD = "DRIVER_FILE_UPLOAD";
		public static String FILE_PATH = "FILE_PATH";
		public static String IDEBFILE = "IDEBFILE";
		public static String CONVERT = "CONVERT";
		public static String MULTI_INDIVIDU = "MULTI_INDIVIDU";
		public static String LOG = "LOG";
		public static String WAIT_ELEMENT = "WAIT_ELEMENT";
		public static String REPEAT = "REPEAT";
		public static String RESPONSE = "RESPONSE";
		public static String RESPONSE_TEMP = "RESPONSE_TEMP";
		public static String JSON_RESULT = "JSON_RESULT";
		
		public static String SEARCH_TYPE = "SEARCH_TYPE";
		public static String SEARCH_METHOD = "SEARCH_METHOD";
		public static String SIMILARITY_TYPE = "SIMILARITY_TYPE";
		public static String MAX_RETRY_JOB = "MAX_RETRY_JOB";
		public static String IND_PLACE_BIRTH = "IND_PLACE_BIRTH";
		public static String IND_NPWP = "IND_NPWP";
		public static String COR_PLACE = "COR_PLACE";
		
		
		public static String URL_MAIN = "MAIN";
		public static String URL_AFTER_LOGIN = "AFTER_LOGIN";
		public static String URL_PETUGAS_PERMINTAAN_INFORMASI = "PETUGAS_PERMINTAAN_INFORMASI";
		
		public static String MAX_TIME_JOB = "MAX_TIME_JOB";
		
//		 = "slik/SG73200375";
//		public final static String URL_PETUGAS_PERMINTAAN_INFORMASI 
	}

	
	public static class ELEMENT {
		public static String COOKIE_NAME = "JSESSIONID";
		
		public static String ATTR_SRC = "src";
		public static String ATTR_ARIA_EXPANDED = "aria-expanded";
		public static String ATTR_CLASS = "class";
		
		public static String LOGIN_ID = "LOGIN_ID";
		public static String LOGIN_PASSWORD = "LOGIN_PASSWORD";
		public static String CAPTCHA_ID = "CAPTCHA_ID";
		public static String CAPTCHA_ANSWER = "CAPTCHA_ANSWER";
		public static String BTN_LOGIN = "BTN_LOGIN";
		public static String FRAME_MAIN = "FRAME_MAIN";
		public static String AFTER_LOGIN_POPUP = "AFTER_LOGIN_POPUP";
		public static String USER_INFO = "USER_INFO";
		public static String BTN_SELENGKAPNYA = "BTN_SELENGKAPNYA";
		public static String PERMINTAAN_DATA = "PERMINTAAN_DATA";
		public static String MENU_IDEB_INTERAKTIF = "MENU_IDEB_INTERAKTIF";
		public static String MENU_INDIVIDUAL = "MENU_INDIVIDUAL";
		public static String TXT_REFERENCE_CODE = "TXT_REFERENCE_CODE";
		public static String CMB_PURPOSE = "CMB_PURPOSE";
		public static String DIV_IDENITY_NUMBER = "DIV_IDENITY_NUMBER";
		public static String IDENTITY_NUMBER = "IDENTITY_NUMBER";
		public static String DIV_COMBINATION = "DIV_COMBINATION";
		public static String FULLNAME = "FULLNAME";
		public static String BIRTH_PLACE = "BIRTH_PLACE";
		public static String RADIO_KESAMAAN = "RADIO_KESAMAAN";
		public static String RADIO_KEMIRIPAN = "RADIO_KEMIRIPAN";
		public static String BIRTH_DATE = "BIRTH_DATE";
		public static String GENDER_CODE = "GENDER_CODE";
		public static String TAX_ID = "TAX_ID";
		public static String CAPTCHA = "CAPTCHA";
		public static String BTN_SEARCH = "BTN_SEARCH";
		public static String POPUP_VAL_PERINGATAN = "POPUP_VAL_PERINGATAN";
		public static String POPUP_VAL_PERINGATAN_BU = "POPUP_VAL_PERINGATAN_BU";
		public static String POPUP_BTN_OK = "POPUP_BTN_OK";
		public static String POPUP_BTN_OK_BU = "POPUP_BTN_OK_BU";
		public static String CHECK_LIST_RESULT = "CHECK_LIST_RESULT";
		public static String BTN_HASIL_IDEB = "BTN_HASIL_IDEB";
		public static String LINK_CEK_HASIL_PERMINTAAN = "LINK_CEK_HASIL_PERMINTAAN";
		public static String MENU_HASIL_PERMINTAAN = "MENU_HASIL_PERMINTAAN";
		public static String TXT_REFERENCE_CODE_SRC = "TXT_REFERENCE_CODE_SRC";
		public static String BTN_SEARCH_SRC = "BTN_SEARCH_SRC";
		public static String EV_GRAY = "EV_GRAY";
		public static String TD = "TD";
		public static String BTN_DOWNLOAD = "BTN_DOWNLOAD";
		public static String MENU_BADAN_USAHA = "MENU_BADAN_USAHA";
		public static String TXT_TEMPAT_PENDIRIAN = "TXT_TEMPAT_PENDIRIAN";
		public static String EST_CERT_DATE = "EST_CERT_DATE";
		public static String POPUP_LOGIN = "POPUP_LOGIN";
		
		public static String RESULT_HEAD_ELEMENT_IND = "RESULT_HEAD_ELEMENT_IND";
		public static String RESULT_HEAD_ELEMENT_COR = "RESULT_HEAD_ELEMENT_COR";
		public static String RESULT_JENIS_IDENTITAS = "RESULT_JENIS_IDENTITAS";
		public static String RESULT_NOMOR_IDENTITAS = "RESULT_NOMOR_IDENTITAS";
		public static String RESULT_NAMA_LENGKAP = "RESULT_NAMA_LENGKAP";
		public static String RESULT_MOTHER_NAME = "RESULT_MOTHER_NAME";
		public static String RESULT_JENIS_KELAMIN = "RESULT_JENIS_KELAMIN";
		public static String RESULT_TEMPAT_LAHIR = "RESULT_TEMPAT_LAHIR";
		public static String RESULT_TANGGAL_LAHIR = "RESULT_TANGGAL_LAHIR";
		public static String RESULT_NPWP = "RESULT_NPWP";
		public static String RESULT_ALAMAT = "RESULT_ALAMAT";
		public static String RESULT_KOTA = "RESULT_KOTA";
		public static String RESULT_KODE_POS = "RESULT_KODE_POS";
	}
	
	public static class DISTRIBUTION_TYPE {
		public static String BALANCED = "1";
		public static String PERFORMANCED = "2";
	}
	
	public static class STATUS {
		public static String STAT_0 = "WAITING";
		public static String STAT_1 = "DOWNLOADED";
		public static String STAT_2 = "SUCCESS";
		public static String STAT_5 = "ERROR FILL DATA";
		public static String STAT_6 = "ERROR CLICK MENU INDIVIDU";
		public static String STAT_7 = "NO DATA FOUND";
		public static String STAT_8	= "DOWNLOAD FAILED";
		public static String STAT_9 = "ERROR CONDITIONAL";
	}


}