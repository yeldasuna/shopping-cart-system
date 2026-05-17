package shoppingcartt;

public class HediyePaketiDecorator extends MusteriDecorator {

    public HediyePaketiDecorator(musteri sarmalananMusteri) {
        super(sarmalananMusteri);
    }

    @Override
    public double indirimHesapla(double toplamTutar) {
        double normalIndirim = super.indirimHesapla(toplamTutar);
        return normalIndirim - 50.0;
    }
}