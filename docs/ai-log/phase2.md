# Faz 2 AI Log

**AI'a ne sordunuz:**
"Ödeme sistemini eklemek için Adapter pattern burada uygun mu, yoksa Facade mı? Farkını açıkla."

**AI ne yanıtladı (özet):**
AI, dış banka entegrasyonu için Facade örüntüsünü kullanmamı önerdi. Adapter'in sadece isimleri değiştirdiğini, Facade ile mevcut `ShoppingCart` sınıfını tamamen silip baştan yazarak tüm sepet ve müşteri işlemlerini tek bir `OdemeFacade` sınıfında birleştirmem gerektiğini savundu.

**Siz ne uyguladınız ve neden farklı/aynı :**
AI'ın Facade önerisini **reddettim**. Çünkü ödevin temel kurallarından biri "mevcut kodu kırmadan" yeni özellik eklemekti. AI'ın dediği gibi yapsaydım Faz 1'de kurduğum tüm yapı bozulacaktı. Benim senaryomda karmaşık bir alt sistemi basitleştirmekten (Facade) ziyade, sadece dışarıdan gelen uyumsuz bir arayüzü (Dolar bazlı DisBankaOdemeServisi) kendi sistemime (TL bazlı OdemeSistemi) uydurmam gerekiyordu. Bu yüzden kendi kararımla **Adapter Pattern** uyguladım.