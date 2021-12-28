package com.spstudio.zheng.domain.model;

import lombok.Data;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Data
public class TeacherDomainObject {

    private String id;
    private String code;
    private String name;
    private String email;
    private boolean enabled;

    private Set<DayOfWeek> workingDays = new HashSet<>();

    public void addWorkingDay(DayOfWeek dayOfWeek) {
        workingDays.add(dayOfWeek);
    }

    public void removeWorkingDay(DayOfWeek dayOfWeek) {
        workingDays.remove(dayOfWeek);
    }

}
