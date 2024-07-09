package com.wdm.wdm.service;

import com.wdm.wdm.entity.Dispositivo;
import com.wdm.wdm.entity.TipoDispositivo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DispositivoServiceInterface {
    List<Dispositivo> buscarDispositivosPorId(List<Long> id);

    Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long> idDispositivos);
}
