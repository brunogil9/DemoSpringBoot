package br.com.localtest.javaclient;

import br.com.localtest.model.PageableResponse;
import br.com.localtest.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaClientDAO {
    RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8082/v1/protected/students")
            .basicAuthentication("almofadinhas", "demospring").build();
    RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8082/v1/admin/students")
            .basicAuthentication("harry", "demospring").build();

    public Student findById(Long id){
        return restTemplate.getForObject("/{id}", Student.class,id);
//        ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
    }

    public List<Student> listAll(){
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
                });
        return exchange.getBody().getContent();
    }

    public Student save(Student student){
        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/",
                HttpMethod.POST,
                new HttpEntity<>(student,createJSONHeader()),
                Student.class);
        return exchangePost.getBody();
    }

    private static HttpHeaders createJSONHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
