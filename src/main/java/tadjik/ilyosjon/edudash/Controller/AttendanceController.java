package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.AttendanceDto;
import tadjik.ilyosjon.edudash.model.Attendance;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Attendance> getall = attendanceService.findAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Attendance getbyid = attendanceService.findById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody AttendanceDto attendanceDto) {
        Result result = attendanceService.create(attendanceDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody AttendanceDto attendanceDto) {
        Result update = attendanceService.update(id, attendanceDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = attendanceService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
