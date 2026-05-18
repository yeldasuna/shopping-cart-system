### UML Sınıf Diyagramı Öncesi ve Sonrası:

```mermaid
classDiagram
    class Musteri {
        <<interface>>
        +indirimHesapla(toplamTutar: double) double
    }
    
    class OgrenciMusteri {
        +indirimHesapla(toplamTutar: double) double
    }
    class PremiumMusteri {
        +indirimHesapla(toplamTutar: double) double
    }
    class StandartMusteri {
        +indirimHesapla(toplamTutar: double) double
    }
    
    class MusteriFabrikasi {
        +musteriOlustur(tip: String) Musteri$
    }
    
    class ShoppingCart {
        +main(args: String[])$
    }
    
    Musteri <|.. OgrenciMusteri : implements
    Musteri <|.. PremiumMusteri : implements
    Musteri <|.. StandartMusteri : implements
    
    ShoppingCart ..> MusteriFabrikasi : kullanır
    MusteriFabrikasi ..> Musteri : üretir