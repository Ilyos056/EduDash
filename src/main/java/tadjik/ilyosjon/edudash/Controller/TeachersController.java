package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.TeachersDto;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.Teachers;
import tadjik.ilyosjon.edudash.service.TeachersService;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeachersController {
    @Autowired
    TeachersService teachersService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Teachers> getall = teachersService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        Teachers getbyid = teachersService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody TeachersDto teachersDto) {
        Result result = teachersService.create(teachersDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody TeachersDto teachersDto) {
        Result update = teachersService.update(id, teachersDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = teachersService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
