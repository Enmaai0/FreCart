package icu.hao.haomall;

import icu.hao.haomall.controller.UserController;
import icu.hao.haomall.model.dao.CategoryMapper;
import icu.hao.haomall.model.pojo.Category;
import jakarta.annotation.Resource;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import java.util.List;

@SpringBootApplication
@MapperScan("icu.hao.haomall.model.dao")
@EnableCaching
public class HaoMallApplication {
    public static void main(String[] args) {

        SpringApplication.run(HaoMallApplication.class, args);
    }

}
