package shoppingcartt;
public class YazIndirimiStratejisi implements KuponStratejisi {
    
	@Override
    public double kuponUygula(double sepetTutari) {
        return sepetTutari * 0.10; 
    }
}