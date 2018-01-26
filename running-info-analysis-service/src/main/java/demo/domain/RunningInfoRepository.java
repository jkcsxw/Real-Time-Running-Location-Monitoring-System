package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Xinkang on 1/26/18.
 */
public interface RunningInfoRepository extends JpaRepository<RunningInformation, Long> {
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    void deleteByRunningId(@Param("runningId") String runningId);
    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);
}
