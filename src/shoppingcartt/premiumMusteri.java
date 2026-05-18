package shoppingcartt;
public class premiumMusteri implements musteri {
    @Override
    public double indirimHesapla(double toplamTutar) {
        if (toplamTutar > 2000) {
            return toplamTutar * 0.30;
        }
        return toplamTutar * 0.20;
    }
}