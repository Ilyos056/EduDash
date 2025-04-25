package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.FinanceDto;
import tadjik.ilyosjon.edudash.model.Finance;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.service.FinanceService;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    @Autowired
    FinanceService financeService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Finance> getall = financeService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        Finance getbyid = financeService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody FinanceDto financeDto) {
        Result result = financeService.create(financeDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody FinanceDto financeDto) {
        Result update = financeService.update(id, financeDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = financeService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
