package shoppingcartt;
public class ShoppingCart {

    public static void main(String[] args) {

        String musteriTipi = "premium"; 
        double toplamFiyat = 2500;
        String kupon = "INDIRIM50";
        double indirim = 0;

        // FACTORY METHOD
        musteri musteri = musteriFabrikasi.musteriOlustur(musteriTipi);
        indirim = musteri.indirimHesapla(toplamFiyat);

        if (toplamFiyat > 1000) {
            indirim += 50;
        }
        if (kupon.equals("INDIRIM50")) {
            indirim += 50;
        }

        double sonFiyat = toplamFiyat - indirim;

        System.out.println("Müşteri Tipi: " + musteriTipi);
        System.out.println("Sepet Tutarı: " + toplamFiyat + " TL");
        System.out.println("Uygulanan Toplam İndirim: " + indirim + " TL");
        System.out.println("Ödenecek Son Fiyat: " + sonFiyat + " TL");
    }
}