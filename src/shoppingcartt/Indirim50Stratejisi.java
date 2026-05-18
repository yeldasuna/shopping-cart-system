package shoppingcartt;
public class Indirim50Stratejisi implements KuponStratejisi {
    @Override
    public double kuponUygula(double sepetTutari) {
        return 50.0; 
    }
}