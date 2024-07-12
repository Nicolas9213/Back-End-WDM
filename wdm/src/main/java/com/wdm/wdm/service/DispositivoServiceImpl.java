package com.wdm.wdm.service;

import com.wdm.wdm.entity.Dispositivo;
import com.wdm.wdm.entity.TipoDispositivo;
import com.wdm.wdm.repository.DispositivoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class DispositivoServiceImpl implements DispositivoServiceInterface {

    private DispositivoRepository dispositivoRepository;
    @Override
    public List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {

        return dispositivoRepository.findAllById(ids);
    }

    @Override
    public Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long>id) {
        List<Dispositivo> dispositivos = buscarDispositivosPorId(id);

        Map<TipoDispositivo, List<Dispositivo>> dispositivosPorTipo = new HashMap<>();

        for (Dispositivo dispositivo : dispositivos) {
            List<Dispositivo> dispositivoList = new ArrayList<>();
            if(dispositivosPorTipo.containsKey(dispositivo.getTipo())) {
                dispositivoList = dispositivosPorTipo.get(dispositivo.getTipo());
            }
            dispositivoList.add(dispositivo);
            dispositivosPorTipo.put(dispositivo.getTipo(), dispositivoList);
        }

        return dispositivosPorTipo;
    }
}
