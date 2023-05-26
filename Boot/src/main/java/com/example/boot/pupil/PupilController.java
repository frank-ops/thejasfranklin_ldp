package com.example.boot.pupil;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/v1/pupil")
public class PupilController {

    private PupilRepo pr;
    private PupilService pupilService;



    @Autowired
    public void dependencySetter(PupilRepo pr,PupilService pupilService){
        this.pr=pr;
        this.pupilService=pupilService;
    }




    @GetMapping
    public List<Pupil> getPupil(){
   return pupilService.getPupil();
    }

   @GetMapping("{pupilId}")
    public Pupil findPupil(@PathVariable("pupilId") Long pupilId){
       return pr.findById(pupilId).orElseThrow(()->new IllegalStateException("pupil does not exist with id : "+pupilId));
}
    @PostMapping
    public void register(@RequestBody Pupil p) {
        this.pupilService.postPupil(p);
    }

    @DeleteMapping("{pupilId}")
    public void deletePupil(@PathVariable("pupilId") Long pupilId){
        this.pupilService.deleteById(pupilId);
    }

    @PutMapping("{pupilId}")
    @Transactional
    public void updatePupil(@PathVariable("pupilId") Long pupilId,@RequestBody Pupil p){
         Pupil pa= pr.findById(pupilId).orElseThrow(()->new IllegalStateException("pupil does not exist with id : "+pupilId));
         pa.setName(p.getName());
         pa.setEmail(p.getEmail());
    }

}
