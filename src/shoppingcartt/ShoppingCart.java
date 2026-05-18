package shoppingcartt;
public class ShoppingCart {
public static void main(String[] args) {
        
        String musteriTipi = "premium"; 
        double toplamFiyat = 2500;
        
        // FAZ 1: Factory
        musteri mevcutMusteri = musteriFabrikasi.musteriOlustur(musteriTipi);
        
        // FAZ 2: Decorator
        mevcutMusteri = new HediyePaketiDecorator(mevcutMusteri);
        double indirim = mevcutMusteri.indirimHesapla(toplamFiyat);

        if (toplamFiyat > 1000) {
            indirim += 50; 
        }
        
        KuponStratejisi aktifKupon = new YazIndirimiStratejisi();
        indirim += aktifKupon.kuponUygula(toplamFiyat);

        double sonFiyat = toplamFiyat - indirim;
        
        System.out.println("Müşteri Tipi: " + musteriTipi);
        System.out.println("Sepet Tutarı: " + toplamFiyat + " TL");
        System.out.println("Uygulanan Toplam İndirim: " + indirim + " TL");
        System.out.println("Ödenecek Son Fiyat: " + sonFiyat + " TL");
        
        DisBankaOdemeServisi eskiBanka = new DisBankaOdemeServisi();
        OdemeSistemi odemeSistemi = new BankaAdapter(eskiBanka);
        
        System.out.println("Ödeme işlemi başlatılıyor...");
        odemeSistemi.odemeYap(sonFiyat); 
        
        // FAZ 3: OBSERVER PATTERN
        System.out.println("-------------------------------------------------");
        BildirimYoneticisi bildirimYoneticisi = new BildirimYoneticisi();
   
        
        bildirimYoneticisi.gozlemciEkle(new EmailBildirimcisi());
        bildirimYoneticisi.gozlemciEkle(new SmsBildirimcisi());
        bildirimYoneticisi.siparisTamamlandi(sonFiyat);
    }
}