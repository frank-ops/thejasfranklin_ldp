package com.example.boot;

import com.example.boot.pupil.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.time.Month.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class BootApplicationTests {




    @Mock
    private PupilRepo pr;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private PupilService ps;



    private final PupilController pc =new PupilController();




    ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());

    private Pupil p ;

    private MockMvc mvc;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.p= new Pupil(1L,"franklin",LocalDate.of(2001,DECEMBER,12),"thejasfranklin@gmail.com");
        pc.dependencySetter(pr,ps);
        this.mvc=MockMvcBuilders.standaloneSetup(pc).build();
    }

    @Test
    void detailsField_typeCheck() {
        Assertions.assertEquals("Long", (((Object) p.getId()).getClass()).getSimpleName());
        Assertions.assertEquals("LocalDate", (((Object) p.getDob()).getClass()).getSimpleName());
        Assertions.assertEquals("String", (((Object) p.getName()).getClass()).getSimpleName());
        Assertions.assertEquals("String", (((Object) p.getEmail()).getClass()).getSimpleName());
        Assertions.assertEquals("Integer", (((Object) p.getAge()).getClass()).getSimpleName());
        p=new Pupil("franklin", LocalDate.of(2001, APRIL,15),"franklin@gmail.com");

    }

    @Test
    void toString_check(){
        Assertions.assertEquals("String", (((Object) p.toString()).getClass()).getSimpleName());
    }

    @Test
    void mainClass_check(){
       BootApplication.main(new String[] {});
        Assertions.assertFalse(false);
    }

    @Test
    void pupilSetters_check(){
        p.setEmail("franklin@gmail.com");
        p.setName("franklin");
        p.setId(1L);
        p.setDob(LocalDate.of(2001, APRIL,15));
        Assertions.assertFalse(false);
    }



    @Test
    void pupilApiGet_check() throws Exception {
        List<Pupil> results = new ArrayList<>(Arrays.asList(p,p,p,p));
        Mockito.when(pc.getPupil()).thenReturn(results);
        mvc.perform(get("/api/v1/pupil")
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andExpect(status().is(200))
                                        .andExpect(jsonPath("$",hasSize(4)))
                                        .andExpect(jsonPath("$[2].name").value("franklin"));


    }

    @Test
    void pupilApiGetById_check() throws Exception{

        Mockito.when(pr.findById(p.getId())).thenReturn(Optional.of(p));
        mvc.perform(get("/api/v1/pupil/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is(200))
                        .andExpect(jsonPath("$",notNullValue()))
                        .andExpect(jsonPath("$.name").value("franklin"));
    }


    @Test
    void pupilApiRegister_check() throws Exception{
        Pupil p1 = p;
        String content =objectMapper.writeValueAsString(p1);
        mvc.perform(post("/api/v1/pupil")
                       .contentType(MediaType.APPLICATION_JSON)
                       .accept(MediaType.APPLICATION_JSON)
                       .content(content)).andExpect(status().is(200));
        response.setStatus(200);
        Mockito.when(pr.findByEmail(p1.getEmail())).thenReturn(Optional.of(p));
        content =objectMapper.writeValueAsString(p);
        mvc.perform(post("/api/v1/pupil")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content));
    }

    @Test
    void pupilDelete_check() throws Exception{

        mvc.perform(delete("/api/v1/pupil/1")
                .contentType(MediaType.APPLICATION_JSON)
                );
        Mockito.when(pr.existsById(1L)).thenReturn(true);
        mvc.perform(delete("/api/v1/pupil/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(200));

    }

    @Test
    void PupilUpdate_check() throws Exception{
        Mockito.when(pr.findById(1L)).thenReturn(Optional.of(p));
        String content =objectMapper.writeValueAsString(p);
        mvc.perform(put("/api/v1/pupil/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)).andExpect(status().is(200));
    }
}
