package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Created by Xinkang on 1/26/18.
 */
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {
    @Id
    @GeneratedValue
    private Long id;
    private String runningId;
    private String latitude;
    private String longitude;
    private double runningDistance;
    private double totalRunningTIme;
    private int heartRate;
    private Date timestamp;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userinfo_username")),
            @AttributeOverride(name = "address", column = @Column(name = "userinfo_address"))
    })
    private UserInfo userInfo;
    public RunningInformation(){}
    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.runningId = runningId;
        this.heartRate = 60 + new Random().nextInt(140);  //fake data
    }
}