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