package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Xinkang on 1/26/18.
 */
public interface RunningInfoService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    Page<RunningInformation> findAll(Pageable pageable);
}