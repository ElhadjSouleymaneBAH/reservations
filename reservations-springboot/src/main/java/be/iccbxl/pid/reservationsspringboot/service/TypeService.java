package be.iccbxl.pid.reservationsspringboot.service;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();
        repository.findAll().forEach(types::add);
        return types;
    }

    public Type get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Type type) {
        repository.save(type);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

