# Evrimleşen E-Ticaret Sepeti Sistemi

Bu proje, yazılım tasarım örüntüleri (Design Patterns) kullanılarak adım adım geliştirilmiş, nesne yönelimli programlama (OOP) ve Nesneye Yönelik Analiz ve Tasarım ilkelerine (SOLID / OCP) uygun esnek bir e-ticaret sepeti simülasyonudur.

## Proje Ne Yapıyor?
Sistem, farklı müşteri tiplerine (Standart, Öğrenci, Premium) göre dinamik indirimler hesaplar, sepete hediye paketi gibi ek hizmetler ekleyebilir, TL bazlı sipariş tutarını dış bir Dolar bazlı banka servisine adapte ederek ödeme alabilir. Son aşamada ise sipariş tamamlandığında otomatik olarak SMS ve Email kanalları üzerinden müşteriye bildirim fırlatır.

## Kullanılan Tasarım Örüntüleri (Design Patterns)

Projenin evrim sürecinde toplamda 5 farklı tasarım örüntüsü sisteme entegre edilmiştir:

### 1. Creational (Yaratımsal) Örüntüler
* **Factory Method Pattern (Faz 1):** Müşteri nesnelerinin (`standart`, `ogrenci`, `premium`) yaratım sorumluluğunu ana koddan ayırarak `musteriFabrikasi` sınıfına devretti. Böylece sisteme yeni bir müşteri tipi eklendiğinde ana sepet kodunun değiştirilmesine gerek kalmadı.

### 2. Structural (Yapısal) Örüntüler
* **Decorator Pattern (Faz 2):** Mevcut müşteri sınıflarını bozmadan veya alt sınıf patlamasına yol açmadan, çalışma zamanında sepet tutarına "Hediye Paketi" gibi ekstra ücretli hizmetleri dinamik olarak eklemeyi sağladı.
* **Adapter Pattern (Faz 2):** Sisteme dokunamadığımız üçüncü parti, farklı metot isimlerine sahip ve sadece Dolar ile çalışan eski bir banka servisini (`DisBankaOdemeServisi`), kendi modern TL bazlı `OdemeSistemi` arayüzümüze adapte etti.

### 3. Behavioral (Davranışsal) Örüntüler
* **Strategy Pattern (Faz 3):** İndirim ve kupon kodlarının yönetimini karmaşık `if-else` yığınlarından kurtararak bağımsız strateji sınıflarına (`YazIndirimiStratejisi`, `Indirim50Stratejisi`) böldü. Bu sayede **Açık/Kapalı Prensibi (OCP)** tam anlamıyla sağlandı; ana koda dokunmadan yeni kuponlar eklenebilir hale geldi.
* **Observer Pattern (Faz 3):** Ödeme işlemi başarıyla sonlandığında, sistemi dinleyen gözlemcileri (`EmailBildirimcisi`, `SmsBildirimcisi`) otomatik olarak tetikleyerek gevşek bağlı (loosely coupled) bir bildirim altyapısı kurdu.

---

## Mimari Sınıf Diyagramı (UML)

Aşağıdaki diyagram, projenin son halinde örüntülerin birbirleriyle nasıl bir ilişki içinde olduğunu göstermektedir:

```mermaid
classDiagram
    class ShoppingCart {
        +main(args: String[])
    }
    class musteri {
        <<interface>>
        +indirimHesapla(toplamTutar: double) double
    }
    class musteriFabrikasi {
        +musteriOlustur(tip: String) musteri
    }
    class MusteriDecorator {
        <<abstract>>
        #musteri sarmalananMusteri
    }
    class OdemeSistemi {
        <<interface>>
        +odemeYap(miktarTL: double)
    }
    class KuponStratejisi {
        <<interface>>
        +kuponUygula(sepetTutari: double) double
    }
    class BildirimYoneticisi {
        -List~SiparisGozlemcisi~ gozlemciler
        +gozlemciEkle(g: SiparisGozlemcisi)
        +siparisTamamlandi(tutar: double)
    }

    ShoppingCart --> musteriFabrikasi : Kullanır
    ShoppingCart --> musteri : Bağımlıdır
    MusteriDecorator ..|> musteri : Implements
    MusteriDecorator --> musteri : Has-a
    ShoppingCart --> OdemeSistemi : Ödeme Yapar
    ShoppingCart --> KuponStratejisi : Kupon Uygular
    ShoppingCart --> BildirimYoneticisi : Olay Tetikler