Faz 0: Başlangıç Kodu Analizi:
Koddaki Tasarım Sorunları
1. **Açık/Kapalı Prensibi (OCP) İhlali:** Sisteme yeni bir müşteri tipi mesela öğretmen veya platin gibi veyahut yeni bir indirim kuralı eklemek istediğimizde `if-else` bloklarını değiştirmek zorundayız.
2. **Tek Sorumluluk Prensibi (SRP) İhlali:** `ShoppingCart` sınıfının içindeki `main` metodu her işi yapıyor; müşteri tiplerini kontrol ediyor, indirim hesaplıyor, kupon sorguluyor ve ekrana çıktı veriyor.
3. **Esneklik Eksikliği ve Sabit Kodlama:** İndirim oranları (`0.15`, `0.20` vb.) ve "INDIRIM50" gibi kupon kodları doğrudan kodun içine gömülü.
4. **Kod Tekrarı (DRY Prensibi İhlali):** `indirim = toplamFiyat * ...` mantığı neredeyse her `if` bloğunda tekrar ediyor.
5. **Test Edilebilirlik Sorunu:** Tüm iş mantığı `main` metodunun içine sıkıştırıldığı için, farklı senaryoları birim testlerle otomatik olarak test etmek imkansız hale gelmiş.

yapay zekanın yorumu:
1.Sorun: Aşırı if-else kullanımı ve OCP ihlali. Farklı indirim oranları iç içe geçmiş koşullarla yönetiliyor.
çözüm: Strategy Pattern (Strateji Örüntüsü). İndirim algoritmaları ayrı sınıflara (Öğrenciİndirimi, Altınİndirimi vb.) ayrılabilir ve çalışma zamanında dinamik olarak seçilebilir.

2.Sorun: Sorumlulukların tek noktada toplanması (God Class / SRP ihlali). Sepet, kendi indirimini ve kuponunu kendi hesaplıyor.
Çözüm (Örüntü): Decorator Pattern (Dekoratör Örüntüsü). Çıplak bir sepet nesnesine, kupon veya ek kampanya gibi indirimler katman katman dışarıdan giydirilebilir.

3.Sorun: Nesne yaratım esnekliğinin olmaması. Tüm veriler ve müşteri tipleri main içinde manuel yaratılıyor.
Çözüm (Örüntü): Factory Method. İlgili müşteri tipine göre doğru özelliklere sahip nesneyi yaratma işi merkezi bir üretici sınıfa devredilebilir.

karşılaştırma yorumu:Yapay zeka da benim gibi OCP ve SRP ihlallerini tespit etti. Ancak benim sadece sorun olarak gördüğüm spagetti if-else yapısı için, Strategy Pattern ve Decorator Pattern gibi çözüm yolları sundu. Ben esneklik eksikliğine odaklanırken, yapay zeka doğrudan nesne yaratım sorununa (Factory Method) kıwmına odaklandı.