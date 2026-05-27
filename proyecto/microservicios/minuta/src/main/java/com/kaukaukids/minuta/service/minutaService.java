package com.kaukaukids.minuta.service;

import com.kaukaukids.minuta.model.minutaModel;
import com.kaukaukids.minuta.repository.minutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class minutaService {

    @Autowired
    private minutaRepository repository;

    public Map<String, Object> calcularYGuardarMinuta(minutaModel minuta) {
        
        // 1. Guardar en la base de datos temporal
        minutaModel minutaGuardada = repository.save(minuta);

        // 2. Factores de consumo unitarios
        double fAdultoBebida = 0.5;  
        double fNinoBebida = 0.3;    

        double fAdultoSnack = 4.0;   
        double fNinoSnack = 6.0;     

        // 3. Cálculo matemático con los getters limpios de Lombok
        double totalBebidas = (minutaGuardada.getAdults() * fAdultoBebida) + (minutaGuardada.getChildren() * fNinoBebida); 
        double totalSnacks = (minutaGuardada.getAdults() * fAdultoSnack) + (minutaGuardada.getChildren() * fNinoSnack); 

        // 4. Estructurar respuesta para Postman
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idRegistro", minutaGuardada.getId());
        respuesta.put("tipoMinuta", minutaGuardada.getTipoMinuta());
        
        Map<String, Double> insumosCalculados = new HashMap<>();
        insumosCalculados.put("Bebidas (Litros)", totalBebidas);
        insumosCalculados.put("Snacks/Comestibles (Unidades)", totalSnacks);
        
        respuesta.put("cantidadesCalculadas", insumosCalculados);

        return respuesta;
    }
}