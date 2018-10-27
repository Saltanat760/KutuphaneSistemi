package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Kitap;
import entity.User;
import dao.KitapDAO;
import dao.UserDAO;

@Controller
public class DefaultController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private KitapDAO kitapDAO;

	@RequestMapping("/")
	public String anasayfaGoster() {
		System.out.println("Ho�geldin");
		return "hosgeldiniz";
	}
	
	@RequestMapping("/login")
	public String girisSayfasiGoster() {
		System.out.println("Giri�");
		return "login";
	}
	
	@RequestMapping("/uyeOl")
	public String uyeOlmaSayfasiGoster() {
		System.out.println("�yelik");
		return "uyeOl";
	}
	
	@RequestMapping("/kitapEkleme")
	public String kitapEklemeSayfasiGoster() {
		System.out.println("kitapEkleme");
		return "kitapEkleme";
	}

	@RequestMapping("/yonetici")
	public String yoneticiSayfasiGoster() {
		System.out.println("yonetici");
		return "yonetici";
	}
	
	@RequestMapping("/kitapListesi")
	public String kitapListesiSayfasiGoster(ModelMap model) {
		System.out.println("kitapListesi");
		model.addAttribute("kitapListesi", kitapDAO.getKitapListesi());
		return "kitapListesi";
	}

	@RequestMapping("/odemeYap")
	public String odemeSayfasiGoster(HttpServletRequest request,ModelMap model) {
		// gelen kitap isimlerine g�re kitap tablosundan her kitap i�in kiralanabilir mi de�eri 0 yap�lacak 
		// se�ilen her kitap i�in kiral�k kitaplar tablosuna veri eklenecek
		
		String [] odenecekKitapIDler = request.getParameterValues("kitapID");
		userDAO.odemeYapilacakKitaplar(odenecekKitapIDler);
		kitapDAO.kiralananGuncelle(odenecekKitapIDler, 1);
		return "kiraladigimKitaplar";
	}

	@RequestMapping(value = "/kitapEkle", method = RequestMethod.POST)
	public String kitapEkle(Kitap kitap) {
		System.out.println(kitap);
		kitap.setKiralanabilirMi(1);
		kitapDAO.kitapEkle(kitap);
		
		return "kitapEkleme";
	}
	
	@RequestMapping(value = "/uyeEkle", method = RequestMethod.POST)
	public String kullaniciOlustur(User user) {
		//System.out.println("yeni2");
		user.setAuthority("ROLE_USER");
		user.setEnabled(1);
		userDAO.create(user);
		if(userDAO.getHataMesaji().equals(""))
			return "login";
		else
			return "uyeOl";
		
	}
	
	@RequestMapping(value = "/kirala", method = RequestMethod.POST)
	public String kitapKiralamaSayfasi(HttpServletRequest request) {
		// gelen kitap isimlerine g�re kitap tablosundan her kitap i�in kiralanabilir mi de�eri 0 yap�lacak 
		// se�ilen her kitap i�in kiral�k kitaplar tablosuna veri eklenecek
		
		String [] gelenKitapIDler = request.getParameterValues("kitapID");
		
		System.out.println("kirala");
		System.out.println("request : "+ gelenKitapIDler.length);
		
		kitapDAO.kiralananGuncelle(gelenKitapIDler,0);
		userDAO.kiraladigimKitaplaraEkle(gelenKitapIDler);
		return "kitapListesi";
	}
	 
	@RequestMapping("/kiraladigimKitaplar")
	public String kiraladigimKitapListesiSayfasiGoster(ModelMap model) {
		System.out.println("kitapListesi");
		model.addAttribute("kitapListesi", userDAO.getKitaplarim());   
		return "kiraladigimKitaplar";
	}
	

	@RequestMapping("/kiralananKitaplar")
	public String kiralananKitaplarSayfasiGoster(ModelMap model) {
		System.out.println("kitapListesi");
		model.addAttribute("kitapListesi", userDAO.getKiralananKitaplar());   
		return "kiralananKitaplar";
	}
}
