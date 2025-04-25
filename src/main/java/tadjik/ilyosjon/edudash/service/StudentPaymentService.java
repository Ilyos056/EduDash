package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.StudentPaymentDto;
import tadjik.ilyosjon.edudash.model.Entity.Status;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.StudentPayment;
import tadjik.ilyosjon.edudash.repo.StudentPaymentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPaymentService {
    @Autowired
    StudentPaymentRepo studentPaymentRepo;

    public List<StudentPayment> getAll(){
        return studentPaymentRepo.findAll();
    }

    public StudentPayment getById(Long id){
        return studentPaymentRepo.findById(id).get();
    }

    public Result create(StudentPaymentDto studentPaymentDto){
        StudentPayment studentPayment = new StudentPayment();
        studentPayment.setAmount(studentPaymentDto.getAmount());
        studentPayment.setPaymentMethod(studentPaymentDto.getPaymentMethod());
        studentPayment.setPaymentStatus(Status.ACTIVE);
        studentPaymentRepo.save(studentPayment);
        return new Result(true, "Successfully created");
    }

    public Result update(Long id, StudentPaymentDto studentPaymentDto){
        Optional<StudentPayment> studentPaymentOptional = studentPaymentRepo.findById(id);
        if(studentPaymentOptional.isPresent()){
            StudentPayment studentPayment = studentPaymentOptional.get();
            studentPayment.setAmount(studentPaymentDto.getAmount());
            studentPayment.setPaymentMethod(studentPaymentDto.getPaymentMethod());
            studentPayment.setPaymentStatus(Status.ACTIVE);
            studentPaymentRepo.save(studentPayment);
            return new Result(true, "Successfully updated");
        }
        return new Result(false, "Not found");
    }

    public Result delete(Long id){
        studentPaymentRepo.deleteById(id);
        return new Result(true, "Successfully deleted");
    }
}
