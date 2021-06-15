package de.mkccl.communityprojectbackend.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 21:26
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TimeModel {

    private String currentTime;
    private String currentDate;


    public String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    public String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("EEEEE, dd.MMMMM.Y  ");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

}
