package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.FinanceDto;
import tadjik.ilyosjon.edudash.dto.StudentPaymentDto;
import tadjik.ilyosjon.edudash.model.Finance;
import tadjik.ilyosjon.edudash.model.Reports;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.model.StudentPayment;
import tadjik.ilyosjon.edudash.repo.FinanceRepo;
import tadjik.ilyosjon.edudash.repo.ReportsRepo;
import tadjik.ilyosjon.edudash.repo.StudentPaymentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {
    @Autowired
    FinanceRepo financeRepo;

    @Autowired
    ReportsRepo reportsRepo;

    @Autowired
    StudentPaymentRepo studentPaymentRepo;

    public List<Finance> getAll() {
        return financeRepo.findAll();
    }

    public Finance getById(Long id) {
        return financeRepo.findById(id).get();
    }

    public Result create(FinanceDto financeDto) {
        Finance finance = new Finance();
        finance.setProfit(financeDto.getProfit());
        finance.setExpenditure(financeDto.getExpenditure());
        finance.setMonthlyBudget(financeDto.getMonthlyBudget());

        Optional<Reports> reportsOptional = reportsRepo.findById(financeDto.getReportId());
        Reports reports = reportsOptional.get();
        finance.setReportId((List<Reports>) reports);

        Optional<StudentPayment> studentPaymentOptional = studentPaymentRepo.findById(financeDto.getStudentpaymentId());
        StudentPayment studentPayment = studentPaymentOptional.get();
        finance.setStudentpaymentId((List<StudentPayment>) studentPayment);
        financeRepo.save(finance);
        return new Result(true, "Finance created");
    }

    public Result update(Long id, FinanceDto financeDto) {
        Optional<Finance> optionalFinance = financeRepo.findById(id);
        if (optionalFinance.isPresent()) {
            Finance finance = optionalFinance.get();
            finance.setProfit(financeDto.getProfit());
            finance.setExpenditure(financeDto.getExpenditure());
            finance.setMonthlyBudget(financeDto.getMonthlyBudget());

            Optional<Reports> reportsOptional = reportsRepo.findById(financeDto.getReportId());
            Reports reports = reportsOptional.get();
            finance.setReportId((List<Reports>) reports);

            Optional<StudentPayment> studentPaymentOptional = studentPaymentRepo.findById(financeDto.getStudentpaymentId());
            StudentPayment studentPayment = studentPaymentOptional.get();
            finance.setStudentpaymentId((List<StudentPayment>) studentPayment);
            financeRepo.save(finance);
            return new Result(true, "Finance updated");
        }
        return new Result(false, "Finance not found");
    }

    public Result delete(Long id) {
        financeRepo.deleteById(id);
        return new Result(true, "Finance deleted");
    }
}
