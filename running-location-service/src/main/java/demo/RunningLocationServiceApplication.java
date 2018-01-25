package demo;

/**
 * Created by Xinkang on 1/23/18.
 */

import demo.domain.UnitInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunningLocationServiceApplication {
    public static void main(String[] args){
        UnitInfo unitInfo = new UnitInfo();
        unitInfo.setBandMake("");
        SpringApplication.run(RunningLocationServiceApplication.class,args);
    }
}
