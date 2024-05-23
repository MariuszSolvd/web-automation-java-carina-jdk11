package com.solvd.service;

import com.solvd.model.Job;

import java.util.Random;

public class JobService {

    public static Job getJob() {
        return Job.builder()
                .title(getRandomString(5))
                .description(getRandomString(5))
                .build();
    }

    public static String getRandomString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            stringBuilder.append((char) randomLimitedInt);
        }
        return stringBuilder.toString();
    }
}
