package com.blbuyer.erp;

import com.blbuyer.core.commons.FeignClientApplication;
import org.springframework.boot.SpringApplication;

/**
 * Created at 2017/12/20
 *
 * @author Andriy
 */
public class BasicServiceApplication extends FeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicServiceApplication.class, args);
    }
}
