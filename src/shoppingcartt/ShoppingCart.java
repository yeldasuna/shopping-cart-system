package shoppingcartt;
public class ShoppingCart {

    public static void main(String[] args) {
        
        String musteriTipi = "premium"; 
        double toplamFiyat = 2500;
        String kupon = "INDIRIM50";

        // FAZ 1: Factory 
        musteri mevcutMusteri = musteriFabrikasi.musteriOlustur(musteriTipi);
        
        // FAZ 2 DECORATOR
        mevcutMusteri = new HediyePaketiDecorator(mevcutMusteri);

        double indirim = mevcutMusteri.indirimHesapla(toplamFiyat);

        if (toplamFiyat > 1000) {
            indirim += 50;
        }

        if (kupon.equals("INDIRIM50")) {
            indirim += 50;
        }

        double sonFiyat = toplamFiyat - indirim;
        
        System.out.println("Müşteri Tipi: " + musteriTipi);
        System.out.println("Sepet Tutarı: " + toplamFiyat + " TL");
        System.out.println("Uygulanan Toplam İndirim (Hediye Paketi Dusulmus Halde): " + indirim + " TL");
        System.out.println("Ödenecek Son Fiyat: " + sonFiyat + " TL");
        System.out.println("-------------------------------------------------");
        
        DisBankaOdemeServisi eskiBanka = new DisBankaOdemeServisi();
        OdemeSistemi odemeSistemi = new BankaAdapter(eskiBanka);
        
        System.out.println("Odeme islemi baslatiliyor...");
        odemeSistemi.odemeYap(sonFiyat);
}
}