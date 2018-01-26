package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Xinkang on 1/26/18.
 */
@RestController
public class RunningInfoAnalysisServiceRestController {
    private RunningInfoService runningInfoService;

    @Autowired
    public RunningInfoAnalysisServiceRestController(RunningInfoService runningInfoService) {
        this.runningInfoService = runningInfoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index page of running information analysis service";
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformationList) {
        runningInfoService.saveRunningInformation(runningInformationList);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void purge() {
        runningInfoService.deleteAll();
    }

    @RequestMapping(value = "/delete/{runningId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByRunningId(@PathVariable String runningId) {
        runningInfoService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/running/{runningId}")
    public Page<RunningInformation> findByRunningId(@PathVariable String runningId, @RequestParam int page, @RequestParam int size) {
        return runningInfoService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAll() {
        return runningInfoService.findAll(new PageRequest(0, 2));
    }
}
