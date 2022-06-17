package com.jaymin.TaskDemo.Controller;

import com.jaymin.TaskDemo.Entity.Owner;
import com.jaymin.TaskDemo.DAO.UserDAO;
import com.jaymin.TaskDemo.DTO.DataClass;
import com.jaymin.TaskDemo.DTO.Master;
import com.jaymin.TaskDemo.Entity.Users;
import com.jaymin.TaskDemo.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class testController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
   public UserService userService;
    @GetMapping("/Demo")
    public ResponseEntity<Master> display(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("app-id","62a983805e54f010a720324c");
        String uri = "https://dummyapi.io/data/v1/comment?limit=3";
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        ObjectMapper mapper = new ObjectMapper();
        Master master = null;
        try {
            master = mapper.readValue(response.getBody(), Master.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        userService.SaveAllUsers(master);

        return  ResponseEntity.ok(master);
    }
    @GetMapping("/users")
    @Scheduled(fixedRate = 86400000L)
    public List<Owner> checkAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        List<Owner> own = userDAO.getAllUser();

        headers.set("app-id", "62a983805e54f010a720324c");
        String uri = null;
        ResponseEntity<String> response;
        com.jaymin.TaskDemo.DTO.Owner xyz;
        HttpEntity request = null;
        for (int i = 0; i < own.size(); i++) {
            uri = "https://dummyapi.io/data/v1/user/" + own.get(i).getOwnerId();
            request = new HttpEntity(headers);
            response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    request,
                    String.class,
                    1
            );
            ObjectMapper mapper = new ObjectMapper();
            xyz = null;
            try {
                xyz = mapper.readValue(response.getBody(), com.jaymin.TaskDemo.DTO.Owner.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String fetchedFirstName = xyz.getFirstName();
            String fetchedlastName = xyz.getLastName();
            String storedFirstName = userDAO.getFirstName(xyz.getId());
            String storedLastName = userDAO.getLastName(xyz.getId());
            if (!fetchedlastName.equals(storedLastName)) {
                userDAO.updateLastName(fetchedlastName);
            } else if (!fetchedFirstName.equals(storedFirstName)) {
                userDAO.updateFirstName(fetchedFirstName);
            }

        }
//        List<Users> users = userDAO.getAll();
//        String uri2 = "https://dummyapi.io/data/v1/comment?limit=3";
//        HttpHeaders headers1 = new HttpHeaders();
//        headers1.setContentType(MediaType.APPLICATION_JSON);
//        headers1.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers1.set("app-id", "62a983805e54f010a720324c");
//        ResponseEntity<String> response2 = restTemplate.exchange(
//                uri2,
//                HttpMethod.GET,
//                request,
//                String.class,
//                1
//        );
//        com.jaymin.TaskDemo.DTO.Owner owner = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            owner = mapper.readValue(response2.getBody(), com.jaymin.TaskDemo.DTO.Owner.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return own;
    }
}
