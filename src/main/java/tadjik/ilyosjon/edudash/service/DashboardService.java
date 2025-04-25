package tadjik.ilyosjon.edudash.service;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.DashboardDto;
import tadjik.ilyosjon.edudash.model.Dashboard;
import tadjik.ilyosjon.edudash.model.LatestNews;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.repo.DashboardRepo;
import tadjik.ilyosjon.edudash.repo.LatestNewsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {
    @Autowired
    DashboardRepo dashboardRepo;

    @Autowired
    LatestNewsRepo latestNewsRepo;

    //get all
    public List<Dashboard> getAll() {
        return dashboardRepo.findAll();
    }

    //get by id
    public Dashboard getById(Long id) {
        return dashboardRepo.findById(id).get();
    }

    //create
    public Result create(DashboardDto dashboardDto) {
        Dashboard dashboard = new Dashboard();

        Optional<LatestNews> optionalLatestNews = latestNewsRepo.findById(dashboardDto.getLatestNewsId());
        LatestNews latestNews = optionalLatestNews.get();
        dashboardDto.setLatestNewsId(latestNews.getId());

        dashboard.setStudentNumber(dashboardDto.getStudentNumber());
        dashboard.setTeacherResult(dashboardDto.getTeacherResult());
        dashboardRepo.save(dashboard);
        return new Result(true, "Dashboard created");
    }

    //update
    public Result update(Long id, DashboardDto dashboardDto) {
        Optional<Dashboard> optionalDashboard = dashboardRepo.findById(id);
        if (optionalDashboard.isPresent()) {
            Dashboard dashboard = optionalDashboard.get();

            Optional<LatestNews> latestNewsOptional = latestNewsRepo.findById(dashboardDto.getLatestNewsId());
            LatestNews latestNews = latestNewsOptional.get();
            dashboard.setLatestNewsId((List<LatestNews>) latestNews);
            dashboard.setStudentNumber(dashboardDto.getStudentNumber());
            dashboard.setTeacherResult(dashboardDto.getTeacherResult());
            dashboardRepo.save(dashboard);
            return new Result(true, "Dashboard updated");
        }
        return new Result(false, "Dashboard not found");
    }

    //delete
    public Result delete(Long id) {
        dashboardRepo.deleteById(id);
        return new Result(true, "Dashboard deleted");
    }
}
