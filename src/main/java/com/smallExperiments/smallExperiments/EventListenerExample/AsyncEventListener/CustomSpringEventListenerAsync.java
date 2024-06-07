package com.smallExperiments.smallExperiments.EventListenerExample.AsyncEventListener;

import com.smallExperiments.smallExperiments.EventListenerExample.model.CustomSpringAsync;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListenerAsync {

    @Async
    @EventListener
    public void handleCustomSpringEvent(CustomSpringAsync event) {
        System.out.println("Received Async spring event - " + event.getMessage());
    }
}
/*
islemin bitmesini beklemeden islemleri yapmaya devam ediyor thread mantigi gibi sirali veya sirasiz ilerliyor
 */


/*
  @Async
* Bu annotation, bir metodu asenkron hale getirir.
* Anotasyon bir metoda uygulandığında, bu metot ayrı bir iş  parçacığında çalıştırılır. Bu, metot çağrısının mevcut iş
  parçacığını bloke etmeden arka planda çalışmasını sağlar.
* Bu genellikle, uzun süren işlemleri veya yoğun hesaplama gerektiren işleri işlemek için kullanılır.
* Örneğin, veritabanı işlemleri, ağ çağrıları veya dosya işlemleri gibi yavaş işlemler, @Async annotation kullanılarak ayrı bir iş parçacığında işlenebilir.
 */

/*
@EventListener
* Bir metoda @EventListener annotation uygulandığında, bu metot belirli bir türdeki olayları dinlemek üzere yapılandırılmıştır.
* Bu metot, belirli bir olay yayımlandığında otomatik olarak çağrılır.
* Örneğin, veritabanı güncellemeleri, kullanıcı oturumu değişiklikleri veya özel uygulama olayları gibi olayları dinlemek için @EventListener kullanılabilir
 */