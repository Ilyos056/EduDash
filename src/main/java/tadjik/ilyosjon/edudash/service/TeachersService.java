package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.TeachersDto;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.Teachers;
import tadjik.ilyosjon.edudash.repo.TeachersRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {
    @Autowired
    TeachersRepo teachersRepo;

    //get all
    public List<Teachers> getAll(){
        return teachersRepo.findAll();
    }

    //get by id
    public Teachers getById(Long id){
        return teachersRepo.findById(id).get();
    }

    //create
    public Result create(TeachersDto teachersDto){
        Teachers teachers = new Teachers();

        teachers.setTeacherList(teachersDto.getTeacherList());
        teachers.setSubjectId(teachersDto.getSubjectId());
        teachers.setResult(teachersDto.getResult());
        teachersRepo.save(teachers);
        return new Result(true, "Teachers created");
    }

    //update
    public Result update(Long id, TeachersDto teachersDto){
        Optional<Teachers> teachersoptional = teachersRepo.findById(id);
        if (teachersoptional.isPresent()) {
            Teachers teachers = teachersoptional.get();

            teachers.setTeacherList(teachersDto.getTeacherList());
            teachers.setSubjectId(teachersDto.getSubjectId());
            teachers.setResult(teachersDto.getResult());
            teachersRepo.save(teachers);
            return new Result(true, "Teachers updated");
        }
        return new Result(false, "Teachers not found");
    }

    //delete
    public Result delete(Long id){
        teachersRepo.deleteById(id);
        return new Result(true, "Teachers deleted");
    }
}
