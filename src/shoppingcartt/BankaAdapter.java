package shoppingcartt;
public class BankaAdapter implements OdemeSistemi {
    private DisBankaOdemeServisi disBanka;
    private final double DOLAR_KURU = 32.5;

    public BankaAdapter(DisBankaOdemeServisi disBanka) {
        this.disBanka = disBanka;
    }

    @Override
    public void odemeYap(double miktarTL) {
        double dolarMiktari = miktarTL / DOLAR_KURU;
        
        disBanka.payInDollars(dolarMiktari, "TR-HESAP-999");
    }
}