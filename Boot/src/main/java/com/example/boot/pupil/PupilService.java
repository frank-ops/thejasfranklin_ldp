package com.example.boot.pupil;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PupilService {
    PupilRepo pr;

    @Autowired
    private HttpServletResponse response;

    public PupilService(PupilRepo pr) {
        this.pr=pr;
    }

    public List<Pupil> getPupil(){
        return pr.findAll();
    }

    public void postPupil(Pupil p){
        Optional<Pupil> np=pr.findByEmail(p.getEmail());
        if (np.isEmpty()) {
            pr.save(p);
        }
        else{
            response.setStatus(400);
        }
    }

    public void deleteById(Long id){
        if (pr.existsById(id)){
           pr.deleteById(id);
        }
        else{
           response.setStatus(400);
        }
    }

}
