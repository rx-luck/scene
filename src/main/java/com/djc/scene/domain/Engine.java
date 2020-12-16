package com.djc.scene.domain;

public class Engine {

    private String engineId;
    private String engineName;
    private String builds;
    private String unit;
    private String floor;

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getBuilds() {
        return builds;
    }

    public void setBuilds(String builds) {
        this.builds = builds;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
