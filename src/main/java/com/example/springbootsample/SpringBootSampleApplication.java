package com.example.springbootsample;

import com.example.springbootsample.upload.service.StorageService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSampleApplication   {


    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return  ()->42;
    }

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootSampleApplication.class, args);

        // Customer SpringApplication
//        SpringApplication application = new SpringApplication(SpringBootSampleApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

        // . Application Exit
        SpringApplication.run(SpringBootSampleApplication.class, args);
//        System.exit(SpringApplication.exit());
/*        new SpringApplicationBuilder()
//                .sources(Parent.class)
                .child(SpringBootSampleApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
  */

    }


    @Bean
    CommandLineRunner init(StorageService service){
        return  (args )-> {
            service.deleteAll();
            service.init();
        } ;
    }
}
