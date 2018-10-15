package entity;

public class Kitap {
	private String kitapAdi;
	private String yazarAdi;
	private float kiralamaUcreti;
	private int kiralanabilirMi;

	public Kitap() {
	}

	@Override
	public String toString() {
		return "Kitap [kitapAdi=" + kitapAdi + ", yazarAdi=" + yazarAdi + ", kiralamaUcreti=" + kiralamaUcreti
				+ ", kiralanabilirMi=" + kiralanabilirMi + "]";
	}

	public Kitap(String kitapAdi, String yazarAdi, float kiralamaUcreti, int kiralanabilirMi) {
		this.kitapAdi = kitapAdi;
		this.yazarAdi = yazarAdi;
		this.kiralamaUcreti = kiralamaUcreti;
		this.kiralanabilirMi = kiralanabilirMi;
	}

	public int getKiralanabilirMi() {
		return kiralanabilirMi;
	}

	public void setKiralanabilirMi(int kiralanabilirMi) {
		this.kiralanabilirMi = kiralanabilirMi;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazarAdi() {
		return yazarAdi;
	}

	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}

	public float getKiralamaUcreti() {
		return kiralamaUcreti;
	}

	public void setKiralamaUcreti(float kiralamaUcreti) {
		this.kiralamaUcreti = kiralamaUcreti;
	}

}
