package tadjik.ilyosjon.edudash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.edudash.dto.LatestNewsDto;
import tadjik.ilyosjon.edudash.model.LatestNews;
import tadjik.ilyosjon.edudash.model.Result;
import tadjik.ilyosjon.edudash.repo.LatestNewsRepo;

import java.util.List;
import java.util.Optional;

@Service
public class LatestNewsService {
    @Autowired
    LatestNewsRepo latestNewsRepo;

    //get all
    public List<LatestNews> getAll(){
        return latestNewsRepo.findAll();
    }

    //get by id
    public LatestNews findById(Long id){
        return latestNewsRepo.findById(id).get();
    }

    //create
    public Result create(LatestNewsDto latestNewsDto){
        LatestNews latestNews = new LatestNews();
        latestNews.setTitle(latestNewsDto.getTitle());
        latestNews.setDescription(latestNewsDto.getDescription());
        latestNewsRepo.save(latestNews);
        return new Result(true, "Latest News Created");
    }

    //update
    public Result update(Long id, LatestNewsDto latestNewsDto){
        Optional<LatestNews> optionalLatestNews = latestNewsRepo.findById(id);
        if (optionalLatestNews.isPresent()) {
            LatestNews latestNews = optionalLatestNews.get();
            latestNews.setTitle(latestNewsDto.getTitle());
            latestNews.setDescription(latestNewsDto.getDescription());
            latestNewsRepo.save(latestNews);
            return new Result(true, "Latest News Updated");
        }
        return new Result(false, "Latest News Not Found");
    }


    //delete
    public Result delete(Long id){
        latestNewsRepo.deleteById((id).longValue());
        return new Result(true, "Latest News Deleted");
    }
}
