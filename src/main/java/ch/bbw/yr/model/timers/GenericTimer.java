/**
 * @Author: Yannick Ruck
 * @Date: 29/12/2020
 */
package ch.bbw.yr.model.timers;

public class GenericTimer {
    private boolean success;
    private  String msg;
    private  String type;
    private Double queryTime;
    private Double estimate;
    private String estimateRelative;
    private Double num;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Double queryTime) {
        this.queryTime = queryTime;
    }

    public Double getEstimate() {
        return estimate;
    }

    public void setEstimate(Double estimate) {
        this.estimate = estimate;
    }

    public String getEstimateRelative() {
        return estimateRelative;
    }

    public void setEstimateRelative(String estimateRelative) {
        this.estimateRelative = estimateRelative;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}
