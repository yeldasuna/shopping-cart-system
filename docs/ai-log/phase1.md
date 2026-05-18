# Faz 1 AI Log

**AI'a ne sordunuz:**
"E-ticaret sepeti projemde nesne yaratımını uzun if-else bloklarından kurtarmak için Factory Method uygulamak istiyorum. Mevcut God Class yapımı (ShoppingCart) nasıl bölebilirim? Bana Türkçe isimlendirmelerle bir Factory Method mantığı kurar mısın?"

**AI ne yanıtladı (özet):**
Yapay zeka, nesne yaratımını ana sınıftan almak için `Musteri` adında bir arayüz (interface) tanımlamamı ve müşteri tiplerini (`OgrenciMusteri`, `PremiumMusteri`) bu arayüzden implement etmemi önerdi. Üretim sorumluluğunu ise `MusteriFabrikasi` isimli tek bir sınıfa vermemi tavsiye etti.

**Siz ne uyguladınız ve neden farklı/aynı :**
Yapay zekanın sunduğu mimari çözümü (Factory Method) doğru buldum ve arayüz/sınıf isimlendirmelerini kullandım. Ancak AI'ın ürettiği kodun tamamını projeme kopyalamadım. Kendi `ShoppingCart` sınıfımdaki `toplamFiyat`, kupon hesaplama mantığı ve özel konsol çıktıları gibi projemin özgün kısımlarını korumam gerekiyordu. Bu yüzden sadece if-else bloklarını kendi ellerimle silip, yapay zekanın mantığını kavradığım `MusteriFabrikasi.musteriOlustur()` çağrısını kendi koduma dikkatlice entegre ettim. Böylece OCP ve SRP prensiplerini kodumun ruhunu bozmadan sağlamış oldum.