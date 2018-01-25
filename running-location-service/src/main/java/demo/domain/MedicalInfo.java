package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Xinkang on 1/24/18.
 */
@Data
@RequiredArgsConstructor  //必须在初始化时赋final变量值
public class MedicalInfo {
    private final long bfr;
    private final long fmi;
}
