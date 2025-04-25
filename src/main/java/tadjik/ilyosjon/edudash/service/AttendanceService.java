package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.AttendanceDto;
import tadjik.ilyosjon.edudash.model.Attendance;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.repo.AttendanceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepo attendanceRepo;


    public List<Attendance> findAll() {
        return attendanceRepo.findAll();
    }

    public Attendance findById(Long id) {
        return attendanceRepo.findById(id).get();
    }

    //create
    public Result create(AttendanceDto attendanceDto) {
        Attendance attendance = new Attendance();
        attendance.setStudentList(attendanceDto.getStudentList());
        attendance.setAttendance_statistics(attendanceDto.getAttendance_statistics());
        attendance.setExamResult(attendanceDto.getExamResult());
        attendanceRepo.save(attendance);
        return new Result(true, "Attendance created");
    }

    //update
    public Result update(Long id, AttendanceDto attendanceDto) {
        Optional<Attendance> optionalAttendance = attendanceRepo.findById(id);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            attendance.setStudentList(attendanceDto.getStudentList());
            attendance.setAttendance_statistics(attendanceDto.getAttendance_statistics());
            attendance.setExamResult(attendanceDto.getExamResult());
            attendanceRepo.save(attendance);
            return new Result(true, "Attendance updated");
        }
        return new Result(false, "Attendance not found");
    }

    //delete
    public Result delete(Long id) {
        attendanceRepo.deleteById(id);
        return new Result(true, "Attendance deleted");
    }
}
