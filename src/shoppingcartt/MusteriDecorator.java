package shoppingcartt;

public abstract class MusteriDecorator implements musteri {
    protected musteri sarmalananMusteri;

    public MusteriDecorator(musteri sarmalananMusteri) {
        this.sarmalananMusteri = sarmalananMusteri;
    }

    @Override
    public double indirimHesapla(double toplamTutar) {
        return sarmalananMusteri.indirimHesapla(toplamTutar);
    }
}