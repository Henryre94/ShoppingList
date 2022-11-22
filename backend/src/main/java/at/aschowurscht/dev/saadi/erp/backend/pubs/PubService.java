package at.aschowurscht.dev.saadi.erp.backend.pubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PubService {
    @Autowired
    PubCRUDRepository pubCRUDRepository;
    public void post(Pub pub){
        pubCRUDRepository.save(pub);
    }
    public Pub getById(int pubId){
        Pub pub = pubCRUDRepository.findById(pubId).get();
        return pub;
    }
    public List<Pub> get(){
        return ((List<Pub>) pubCRUDRepository.findAll());
    }
    public void put(Pub pub){
        pubCRUDRepository.save(pub);
    }
    public void delete(int pubId){
        pubCRUDRepository.deleteById(pubId);
    }
}