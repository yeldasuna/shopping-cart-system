package shoppingcartt;
public class ogrenciMusteri implements musteri {
    @Override
    public double indirimHesapla(double toplamTutar) {
        return toplamTutar * 0.10;
    }
}