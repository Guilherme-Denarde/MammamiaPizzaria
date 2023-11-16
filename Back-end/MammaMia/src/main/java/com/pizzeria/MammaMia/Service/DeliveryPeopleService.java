//package com.pizzeria.MammaMia.Service;
//
//import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
//import com.pizzeria.MammaMia.Entity.DeliveryPeople;
//import com.pizzeria.MammaMia.Repository.DeliveryPeopleRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DeliveryPeopleService {
//
//    @Autowired
//    private DeliveryPeopleRepository deliveryPeopleRepository;
//
//    public List<DeliveryPeople> getAllDeliveryPeople() {
//        return deliveryPeopleRepository.findAll();
//    }
//
//    public Optional<DeliveryPeople> getDeliveryPeopleById(Long id) {
//        return deliveryPeopleRepository.findById(id);
//    }
//
//    public DeliveryPeople createDeliveryPeopleFromDTO(DeliveryPeopleDTO deliveryPeopleDTO) {
//        DeliveryPeople deliveryPeople = new DeliveryPeople();
//        deliveryPeople.setId(deliveryPeopleDTO.getId());
//        deliveryPeople.setCpf(deliveryPeopleDTO.getCpf());
//        deliveryPeople.setName(deliveryPeopleDTO.getName());
//        deliveryPeople.setPhone(deliveryPeopleDTO.getPhone());
//
//        return deliveryPeopleRepository.save(deliveryPeople);
//    }
//
//    public DeliveryPeople updateDeliveryPeopleFromDTO(DeliveryPeopleDTO deliveryPeopleDto) {
//        Optional<DeliveryPeople> existingDeliveryPeople = deliveryPeopleRepository.findById(Long.valueOf(deliveryPeopleDto.getId()));
//
//        if (existingDeliveryPeople.isPresent()) {
//            DeliveryPeople deliveryPeople = existingDeliveryPeople.get();
//
//
//            deliveryPeople.setCpf(deliveryPeopleDto.getCpf());
//            deliveryPeople.setName(deliveryPeopleDto.getName());
//            deliveryPeople.setPhone(deliveryPeopleDto.getPhone());
//
//
//            return deliveryPeopleRepository.save(deliveryPeople);
//        } else {
//            throw new EntityNotFoundException("DeliveryPeople com o ID " + deliveryPeopleDto.getId() + " não encontrado");
//        }
//    }
//
//    public boolean deleteDeliveryPeople(Long id) {
//        if (deliveryPeopleRepository.existsById(id)) {
//            deliveryPeopleRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
