package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.ReportsDto;
import tadjik.ilyosjon.edudash.dto.TeachersDto;
import tadjik.ilyosjon.edudash.model.Reports;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.Teachers;
import tadjik.ilyosjon.edudash.service.ReportsService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    @Autowired
    ReportsService reportsService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Reports> getall = reportsService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        Reports getbyid = reportsService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody ReportsDto reportsDto) {
        Result result = reportsService.create(reportsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody ReportsDto reportsDto) {
        Result update = reportsService.update(id, reportsDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = reportsService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
