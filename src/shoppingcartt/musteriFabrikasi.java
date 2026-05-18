package shoppingcartt;

public class musteriFabrikasi {
	public static musteri musteriOlustur(String tip) {
        if (tip.equalsIgnoreCase("ogrenci")) {
            return new ogrenciMusteri();
        } else if (tip.equalsIgnoreCase("premium")) {
            return new premiumMusteri();
        } else {
            return new standartMusteri();
        }
    }
}
