package com.spstudio.zheng.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Data
public class TeacherDomainObject {

    @Setter(AccessLevel.NONE)
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
