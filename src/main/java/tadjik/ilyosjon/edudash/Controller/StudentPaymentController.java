package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.StudentPaymentDto;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.StudentPayment;
import tadjik.ilyosjon.edudash.service.StudentPaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/studentpayment")
public class StudentPaymentController {
    @Autowired
    StudentPaymentService studentPaymentService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<StudentPayment> getall = studentPaymentService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id) {
        StudentPayment getbyid = studentPaymentService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody StudentPaymentDto studentPaymentDto) {
        Result result = studentPaymentService.create(studentPaymentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody StudentPaymentDto studentPaymentDto) {
        Result update = studentPaymentService.update(id, studentPaymentDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = studentPaymentService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
