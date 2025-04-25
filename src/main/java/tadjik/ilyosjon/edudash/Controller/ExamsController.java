package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.ExamsDto;
import tadjik.ilyosjon.edudash.model.Exams;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.service.ExamsService;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamsController {
    @Autowired
    ExamsService examsService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Exams> getall = examsService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        Exams getbyid = examsService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody ExamsDto examsDto) {
        Result result = examsService.create(examsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody ExamsDto examsDto) {
        Result update = examsService.update(id, examsDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = examsService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
