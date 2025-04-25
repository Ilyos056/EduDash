package tadjik.ilyosjon.edudash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.edudash.dto.LatestNewsDto;
import tadjik.ilyosjon.edudash.model.LatestNews;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.service.LatestNewsService;

import java.util.List;

@RestController
@RequestMapping("/api/latestnews")
public class LatestNewsController {
    @Autowired
    LatestNewsService latestNewsService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<LatestNews> getall = latestNewsService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        LatestNews getbyid = latestNewsService.findById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody LatestNewsDto latestNewsDto) {
        Result result = latestNewsService.create(latestNewsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody LatestNewsDto latestNewsDto) {
        Result update = latestNewsService.update(id, latestNewsDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = latestNewsService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
