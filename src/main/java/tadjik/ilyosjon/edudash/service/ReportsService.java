package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.ReportsDto;
import tadjik.ilyosjon.edudash.model.Reports;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.repo.ReportsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ReportsService {
    @Autowired
    ReportsRepo reportsRepo;

    public List<Reports> getAll() {
        return reportsRepo.findAll();
    }

    public Reports getById(Long id) {
        return reportsRepo.findById(id).get();
    }

    public Result create(ReportsDto reportsDto) {
        Reports reports = new Reports();
        reports.setDescription(reportsDto.getDescription());
        reports.setTitle(reportsDto.getTitle());
        reportsRepo.save(reports);
        return new Result(true, "Report created");
    }

    public Result update(Long id, ReportsDto reportsDto) {
        Optional<Reports> reportsOptional = reportsRepo.findById(id);
        if (reportsOptional.isPresent()) {
            Reports reports = reportsOptional.get();
            reports.setDescription(reportsDto.getDescription());
            reports.setTitle(reportsDto.getTitle());
            reportsRepo.save(reports);
            return new Result(true, "Report updated");
        }
        return new Result(false, "Report not found");
    }

    public Result delete(Long id) {
        reportsRepo.deleteById(id);
        return new Result(true, "Report deleted");
    }
}
