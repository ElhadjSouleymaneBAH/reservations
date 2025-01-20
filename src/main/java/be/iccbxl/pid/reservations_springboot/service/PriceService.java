package be.iccbxl.pid.reservations_springboot.service;


import be.iccbxl.pid.reservations_springboot.model.Price;
import be.iccbxl.pid.reservations_springboot.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository repository;

    public List<Price> getAllPrices() {
        return repository.findAll();
    }

    public Price getPrice(long id) {
        return repository.findById(id);
    }

    public void addPrice(Price price) {
        repository.save(price);
    }

    public void updatePrice(long id, Price price) {
        repository.save(price);
    }

    public void deletePrice(long id) {
        repository.deleteById(id);
    }
}

