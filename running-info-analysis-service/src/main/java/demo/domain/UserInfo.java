package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by Xinkang on 1/26/18.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
public class UserInfo {
    private String username;
    private String address;
    public UserInfo(){}
    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
