package shoppingcartt;
import java.util.ArrayList;
import java.util.List;

public class BildirimYoneticisi {
    private List<SiparisGozlemcisi> gozlemciler = new ArrayList<>();

    public void gozlemciEkle(SiparisGozlemcisi gozlemci) {
        gozlemciler.add(gozlemci);
    }

    public void siparisTamamlandi(double tutar) {
        for (SiparisGozlemcisi gozlemci : gozlemciler) {
            gozlemci.siparisTamamlandiMesajiGonder(tutar);
        }
    }
}