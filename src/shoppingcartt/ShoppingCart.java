package shoppingcartt;
public class ShoppingCart{

    public static void main(String[] args) {
        String musteriTipi = "premium"; 
        double toplamFiyat = 2500;
        double indirim = 0;
        String kupon = "INDIRIM50";

        if (musteriTipi.equals("ogrenci")) {
            indirim = toplamFiyat * 0.10;
        } 
        else if (musteriTipi.equals("normal")) {
            indirim = 0; 
        } 
        else if (musteriTipi.equals("silver")) {
            indirim = toplamFiyat * 0.05;
        } 
        else if (musteriTipi.equals("gold")) {
            indirim = toplamFiyat * 0.25;
        } 
        else if (musteriTipi.equals("premium")) {
            if (toplamFiyat > 2000) {
                indirim = toplamFiyat * 0.30;
            } else {
                indirim = toplamFiyat * 0.20;
            }
        }

        if (toplamFiyat > 1000) {
            indirim += 50;
        }

        if (kupon.equals("INDIRIM50")) {
            indirim += 50;
        }

        double sonFiyat = toplamFiyat - indirim;
        
        System.out.println("Müşteri Tipi: " + musteriTipi);
        System.out.println("Sepet Tutarı: " + toplamFiyat + " TL");
        System.out.println("Kullanılan Kupon: " + kupon);
        System.out.println("Uygulanan Toplam İndirim: " + indirim + " TL");
        System.out.println("Ödenecek Son Fiyat: " + sonFiyat + " TL");
    }
}