package com.outreach.greenstar.dto;
import lombok.Data;

@Data
public class HolidayDTO {

    private int id;
    private String date;
    private String details;
    private boolean isPublicHoliday;
}