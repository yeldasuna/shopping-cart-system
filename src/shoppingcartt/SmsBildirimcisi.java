package shoppingcartt;

public class SmsBildirimcisi implements SiparisGozlemcisi {
    @Override
    public void siparisTamamlandiMesajiGonder(double tutar) {
        System.out.println("SMS GÖNDERİLDİ: Sayın müşterimiz, " + tutar + " TL değerindeki siparişiniz onaylanmıştır.");
    }
}
