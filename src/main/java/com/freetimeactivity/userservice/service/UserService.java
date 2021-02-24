package com.freetimeactivity.userservice.service;

import com.freetimeactivity.userservice.VO.Department;
import com.freetimeactivity.userservice.VO.ResponseTemplateVO;
import com.freetimeactivity.userservice.entity.User;
import com.freetimeactivity.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of save UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of save UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
