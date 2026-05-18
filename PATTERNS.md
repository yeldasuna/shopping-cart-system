# Faz 1: Creational Pattern (Yaratımsal Örüntü)
Factory Method kullandık.

**Nerede Uygulandı?**
`ShoppingCart` sınıfının içindeki müşteri tipine göre indirim hesaplayan uzun `if-else` blokları kaldırılarak yerine entegre edildi. Nesne yaratım işlemleri yeni oluşturduğumuz `MusteriFabrikasi` sınıfına taşındı.

**Neden Uygulandı?**
Başlangıç kodunda `ShoppingCart` sınıfı, hangi müşteri tipine (öğrenci, premium, standart) ait indirim oranının ne olduğunu bilmek zorundaydı. Bu durum Tek Sorumluluk Prensibi'ni (SRP) ihlal ediyordu. Ayrıca yeni bir müşteri eklemek için sürekli ana koddaki `if-else` yapısına dokunmamız gerekiyordu (Açık/Kapalı Prensibi - OCP ihlali).

**Ne Kazandık?**
1) Nesne yaratım işini `MusteriFabrikasi` sınıfına devrederek ana sınıfın yani ShoppingCart sorumluluğunu azalttık.
2) `Musteri` adında bir arayüz (interface) yaratarak ana kodun sadece bu arayüzle konuşmasını sağladık (Bağımlılıklar azaltıldı).
3) Sisteme yeni bir müşteri tipi eklemek istediğimizde ana koda hiç dokunmadan sadece yeni bir sınıf eklememiz yeterli hale geldi (OCP sağlandı).

### UML Sınıf Diyagramı Öncesi ve Sonrası:

Aşağıdaki diyagramda nesne yaratım sorumluluğunun ana sınıftan alınıp Factory sınıfına nasıl devredildiği gösterilmektedir:

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
    
    ---

# Faz 2: Structural Patterns (Yapısal Örüntüler)

 1. Adapter Pattern (Adaptör)
**Nerede Uygulandı?**
Üçüncü parti olarak sisteme dahil edilen, sadece Dolar ile çalışan ve farklı metot isimlerine sahip `DisBankaOdemeServisi` sınıfını, kendi sistemimizdeki `OdemeSistemi` arayüzüne bağlarken `BankaAdapter` sınıfı ile uygulandı.
**Neden Uygulandı?**
Dışarıdan aldığımız banka sınıfının kodlarına dokunup değiştiremiyorduk. Kendi `ShoppingCart` sınıfımızı da bu dış bankaya göre baştan yazmak (kodu kırmak) istemedik.
**Ne Kazandık?**
Uyumsuz iki arayüzü birbirine bağladık. Ana kodumuz sadece kendi bildiği `OdemeSistemi` arayüzüyle konuşmaya devam etti, kur çevirisi ve dış sistemin çağrılması gibi karmaşık işler Adaptörün içine gizlendi.

## 2. Decorator Pattern (Dekoratör)
**Nerede Uygulandı?**
Sepete "Hediye Paketi" gibi ekstra hizmetler eklemek için `MusteriDecorator` adında soyut bir sarmalayıcı sınıf ve bunu miras alan `HediyePaketiDecorator` oluşturuldu.
**Neden Uygulandı?**
Müşteriye özel ekstra hizmetler eklemek için her müşteri tipine özel alt sınıflar (Örn: `HediyePaketliPremiumMusteri`) açmak sınıf patlamasına (class explosion) yol açacaktı. Ana müşteri sınıflarını bozmadan onlara dinamik olarak yeni sorumluluklar eklememiz gerekiyordu.
**Ne Kazandık?**
Mevcut indirim hesaplama mantığına hiç dokunmadan, çalışma zamanında (runtime) fiyata hediye paketi ücretini yansıtacak esnek bir yapı kurduk.

### Faz 2 UML Sınıf Diyagramı Güncellemesi

Aşağıdaki diyagramda Faz 2 ile sisteme dahil olan Decorator (Musteri sarmalayıcıları) ve Adapter (Dış banka entegrasyonu) yapıları gösterilmektedir:

```mermaid
classDiagram
    class Musteri {
        <<interface>>
        +indirimHesapla(toplamTutar: double) double
    }
    class MusteriDecorator {
        <<abstract>>
        #musteri sarmalananMusteri
        +indirimHesapla(toplamTutar: double) double
    }
    class HediyePaketiDecorator {
        +indirimHesapla(toplamTutar: double) double
    }
    
    Musteri <|.. MusteriDecorator : implements
    MusteriDecorator o-- Musteri : has-a
    MusteriDecorator <|-- HediyePaketiDecorator : extends
    
    class OdemeSistemi {
        <<interface>>
        +odemeYap(miktarTL: double)
    }
    class BankaAdapter {
        -DisBankaOdemeServisi disBanka
        +odemeYap(miktarTL: double)
    }
    class DisBankaOdemeServisi {
        +payInDollars(amountUSD: double, accountId: String)
    }
    
    OdemeSistemi <|.. BankaAdapter : implements
    BankaAdapter --> DisBankaOdemeServisi : adapts