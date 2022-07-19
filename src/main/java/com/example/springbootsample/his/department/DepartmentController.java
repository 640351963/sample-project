package com.example.springbootsample.his.department;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;

/**
 * 科室查询
 */
@RestController
public class DepartmentController {


    @Value("${system.cdxt}")
    private String type;

//    @PostConstruct
    public void showInit() {
        System.out.println("type -> ");
        System.out.println(type);
        System.out.println("type -> ");
    }

    /**
     * 获取科室信息
     */
    @RequestMapping("/")
    public Object selectDepartments(@RequestBody DepartmentQueryVo departmentQueryVo) {


        return null;
    }

}
