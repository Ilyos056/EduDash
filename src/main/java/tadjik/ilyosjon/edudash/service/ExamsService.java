package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.ExamsDto;
import tadjik.ilyosjon.edudash.model.Exams;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.repo.ExamsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ExamsService {

    @Autowired
    ExamsRepo examsRepo;

    public List<Exams> getAll() {
        return examsRepo.findAll();
    }

    public Exams getById(Long id) {
        return examsRepo.findById(id).get();
    }

    public Result create(ExamsDto examsDto) {
        Exams exams = new Exams();
        exams.setDescription(examsDto.getDescription());
        exams.setExamResults(examsDto.getExamResults());
        examsRepo.save(exams);
        return new Result(true, "Exam created");
    }

    public Result update(Long id, ExamsDto examsDto) {
        Optional<Exams> optionalExams = examsRepo.findById(id);
        if (optionalExams.isPresent()) {
            Exams exams = optionalExams.get();
            exams.setDescription(examsDto.getDescription());
            exams.setExamResults(examsDto.getExamResults());
            examsRepo.save(exams);
            return new Result(true, "Exam updated");
        }
        return new Result(false, "Exam not found");
    }

    public Result delete(Long id) {
        examsRepo.deleteById(id);
        return new Result(true, "Exam deleted");
    }
}