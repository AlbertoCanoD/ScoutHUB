package org.scouthub.uservalidator.infraestructure.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.uservalidator.domain.UserRepository;
import org.scouthub.uservalidator.infraestructure.kafka.BinderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class UserListener {
    // TODO - En caso de que los usuarios esten mal, almacenarlos con el error que tengan, crear nuevo modelo de usuario con error

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @StreamListener()
    @SendTo(BinderProcessor.USER_VALIDATED)
    public KStream<UserValidatedKey, UserValidatedValue> prendas(
            @Input(BinderProcessor.USER) KStream<UserKey, UserValue> prendas) {

        log.debug("Prenda recibida por topid de kafka");
        return prendas.flatMap((prendaKey, prendaValue) -> {
            log.debug("PrendaKey {}, PrendaValue {}", prendaKey, prendaValue);
            List<KeyValue<PrendaPromocionadaKey, PrendaPromocionadaValue>> result = new LinkedList<>();
            if ((prendaValue == null)) { // Thombstone record
                EliminarPrenda.eliminar(prendaKey.getReferencia(), prendaRepository, prendaService);
                result.add(KeyValue.pair(new PrendaPromocionadaKey(prendaKey.getReferencia()), null));
            } else {
                log.debug("Prenda is not a tombstone");
                Prenda prenda = new Prenda(prendaValue.getReferencia(), prendaValue.getPrecio(),
                        prendaValue.getPrecio(), prendaValue.getCategorias());
                CrearPrenda.crear(prenda, prendaRepository, prendaService);
                PrendaPromocionadaValue prendaPromocionadaValue = new PrendaPromocionadaValue(
                        prenda.getReferencia(),
                        prenda.getPrecio(),
                        prenda.getPrecio_promocionado(),
                        prenda.getCategorias()
                );
                result.add(
                        KeyValue.pair(new PrendaPromocionadaKey(prendaKey.getReferencia()), prendaPromocionadaValue));
            }
            return result;
        });
    }
}
