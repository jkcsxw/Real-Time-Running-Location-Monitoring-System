package demo.domain;

import lombok.Data;

/**
 * Created by Xinkang on 1/23/18.
 */
@Data
public class UnitInfo {
    private final String runningId;
    private String bandMake;
    private String customerName;
    private String unitNumber;

    public UnitInfo(){
        this.runningId = "";
    }

    public UnitInfo(String runningId){
        this.runningId = runningId;
    }


}
