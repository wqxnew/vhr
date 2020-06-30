package com.javamm.vhr.util;

import com.javamm.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtil {
    public static Hr getLocalUser(){
        return (Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
