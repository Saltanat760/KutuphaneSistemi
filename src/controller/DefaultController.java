package controller;

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
		System.out.println("Hoþgeldin");
		return "hosgeldiniz";
	}
	
	@RequestMapping("/login")
	public String girisSayfasiGoster() {
		System.out.println("Giriþ");
		return "login";
	}
	
	@RequestMapping("/uyeOl")
	public String uyeOlmaSayfasiGoster() {
		System.out.println("Üyelik");
		return "uyeOl";
	}
	
	@RequestMapping("/kitapEkleme")
	public String kitapEklemeSayfasiGoster() {
		System.out.println("kitapEkleme");
		return "kitapEkleme";
	}

	@RequestMapping("/kitapListesi")
	public String kitapListesiSayfasiGoster(ModelMap model) {
		System.out.println("kitapListesi");
		model.addAttribute("kitapListesi", kitapDAO.getKitapListesi());
		return "kitapListesi";
	}

	@RequestMapping("/odemeYap")
	public String odemeSayfasiGoster() {
		System.out.println("odemeYap");
		return "odemeYap";
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
		System.out.println("yeni");
		user.setAuthority("ROLE_USER");
		user.setEnabled(1);
		userDAO.create(user);
		return "hosgeldiniz";
	}
}
