package com.uce.pa2_u4_p4_al_mp.serviice;

import com.uce.pa2_u4_p4_al_mp.repository.IPropietarioRepository;
import com.uce.pa2_u4_p4_al_mp.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
    @Autowired
    private IPropietarioRepository propietarioRepository;

    @Override

    @Transactional(value = TxType.REQUIRED)
    public void agregar(Propietario propietario) {
        System.out.println("service"+TransactionSynchronizationManager.isActualTransactionActive());
        this.propietarioRepository.insertar(propietario);

    
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void actulizar(Propietario propietario) {
        this.propietarioRepository.actulizar(propietario);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void remover(Integer id) {
        this.propietarioRepository.eliminar(id);
    }

    @Override
    public Propietario buscarPorId(Integer id) {
        return this.propietarioRepository.seleccionarPorId(id);
    }

    @Override
    public List<Propietario> buscarTodos() {
        return this.propietarioRepository.seleccionarTodos();
    }
    
}
