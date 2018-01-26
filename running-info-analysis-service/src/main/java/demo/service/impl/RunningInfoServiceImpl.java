package demo.service.impl;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xinkang on 1/26/18.
 */
@Service
public class RunningInfoServiceImpl implements RunningInfoService{
    private RunningInfoRepository runningInfoRepository;
    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository runningInfoRepository) {
        this.runningInfoRepository = runningInfoRepository;
    }
    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformationList) {
        return runningInfoRepository.save(runningInformationList);
    }

    @Override
    public void deleteAll() {
        runningInfoRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInfoRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningInfoRepository.findByRunningId(runningId,pageable);
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return runningInfoRepository.findAllByOrderByHeartRateDesc(pageable);
    }
}
