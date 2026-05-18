package shoppingcartt;

public class EmailBildirimcisi implements SiparisGozlemcisi {
    
	@Override
    public void siparisTamamlandiMesajiGonder(double tutar) {
        System.out.println("EMAIL GÖNDERİLDİ: Siparişiniz başarıyla alındı. Tutar: " + tutar + " TL");
    }
}