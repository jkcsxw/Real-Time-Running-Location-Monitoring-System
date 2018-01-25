package demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Xinkang on 1/24/18.
 */
@Entity
@Table(name = "RUNNING LOCATIONS")
public class Location {
    enum GpsStatus {
        EXCELLENT, OK, UNRELIABLE, NOFIX, UNKNOWN;
    }

    public enum RunnerMovementType {
        STOPPED, IN_MOTION;

        public boolean isMoving() {
            return this != STOPPED;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
    private final UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi")),
            @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr"))
    )
    private MedicalInfo medicalInfo;

    private double latitude;
    private double longtitude;

    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;

    private double odometer;
    private double totalRunningTime;
    private double totalIdleTime;
    private double totalCaloriesBurnt;
    private String address;
    private Date timestamp;
    private String gearProvider;
    private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
    private String serviceType;

    public Location(String runningId) {
        this.unitInfo = new UnitInfo(runningId);
    }

}
