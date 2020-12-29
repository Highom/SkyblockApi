/**
 * @Author: Yannick Ruck
 * @Date: 29/12/2020
 */
package ch.bbw.yr.model.timers;

public class EventTimer extends GenericTimer{
    private Double endEstimate;
    private String endEstimateRelative;
    private boolean active;

    public Double getEndEstimate() {
        return endEstimate;
    }

    public void setEndEstimate(Double endEstimate) {
        this.endEstimate = endEstimate;
    }

    public String getEndEstimateRelative() {
        return endEstimateRelative;
    }

    public void setEndEstimateRelative(String endEstimateRelative) {
        this.endEstimateRelative = endEstimateRelative;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
