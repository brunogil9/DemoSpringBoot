package br.com.localtest.javaclient;

import br.com.localtest.model.PageableResponse;
import br.com.localtest.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {

        //getForObject
//        Student student = restTemplate.getForObject("/{id}", Student.class, 1);
//        System.out.println(student);
        //getForEntity
//        ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
//        System.out.println(forEntity.getBody());
//        //List getForObject (primitivo)
//        Student[] students = restTemplate.getForObject("/", Student[].class);
//        System.out.println(Arrays.toString(students));
//        //exchange
//        ResponseEntity<List<Student>> exchange = restTemplate.exchange("/",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Student>>() {
//                });
//        System.out.println(exchange.getBody());

        //GET
//        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/?sort=id,desc&sort=name,asc",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<PageableResponse<Student>>() {
//                });
//        System.out.println(exchange);
        //Post
//        Student studentPost = new Student();
//        studentPost.setName("John Wick");
//        studentPost.setEmail("john@pencil.com");
//        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/",
//                HttpMethod.POST, new HttpEntity<>(studentPost,createJSONHeader()),
//                Student.class);
//        Student studentPostForObject = restTemplateAdmin.postForObject("/", studentPost, Student.class);
//        ResponseEntity<Student> studentResponseEntity = restTemplateAdmin.postForEntity("/", studentPost, Student.class);
//
//        System.out.println(exchangePost);
//        System.out.println(studentPostForObject);
//        System.out.println(studentResponseEntity);


        //Após utilização da classe JavaClientDAO
        Student studentPost = new Student();
        studentPost.setName("Hino De");
        studentPost.setEmail("hino@de.com");
        JavaClientDAO dao = new JavaClientDAO();
//        System.out.println(dao.findById((long) 1));
        List<Student> students = dao.listAll();
        System.out.println(students);
//        System.out.println(dao.save(studentPost));
    }

//    private static HttpHeaders createJSONHeader(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return headers;
//    }
}