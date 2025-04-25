package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.DashboardDto;
import tadjik.ilyosjon.edudash.model.Dashboard;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.service.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Dashboard> getall = dashboardService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Dashboard getbyid = dashboardService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody DashboardDto dashboardDto) {
        Result result = dashboardService.create(dashboardDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody DashboardDto dashboardDto) {
        Result update = dashboardService.update(id, dashboardDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = dashboardService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
