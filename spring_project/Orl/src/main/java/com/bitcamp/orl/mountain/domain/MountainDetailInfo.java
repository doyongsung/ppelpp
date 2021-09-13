package com.bitcamp.orl.mountain.domain;

import java.util.List;

public class MountainDetailInfo {
    public List<List<List<Double>>> paths;

    public MountainDetailInfo(List<List<List<Double>>> paths) {
        this.paths = paths;
    }
}
