package de.mkccl.communityprojectbackend.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 21:04
 */

@RestController
@RequestMapping("api/v1/utils")
public class UtilsController {


    @GetMapping("/time/current")
    public TimeModel getCurrentTime() {
        return new TimeModel();
    }



}
