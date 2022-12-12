package at.aschowurscht.dev.saadi.erp.backend.demands;

import at.aschowurscht.dev.saadi.erp.backend.dtos.DemandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/demands")
@CrossOrigin
@RequiredArgsConstructor
public class DemandController {
    final DemandService demandService;

    @PostMapping("/{proId}/pubs/{pubId}")
    public DemandDTO createDemand(@PathVariable int proId, @PathVariable int pubId) {
        return demandService.createDemand(proId, pubId);
    }

    @PutMapping("/{proId}/pubs/{pubId}")
    public List<DemandDTO> decreaseQuantity(@PathVariable int proId, @PathVariable int pubId) {
        return demandService.decreaseQuantity(proId, pubId);
    }

    @DeleteMapping("/{proId}/pubs/{pubId}")
    public void deleteDemand(@PathVariable int proId,@PathVariable int pubId){
        demandService.deleteDemand(proId,pubId);
    }
}
