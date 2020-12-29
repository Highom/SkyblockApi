/**
 * @Author: Yannick Ruck
 * @Date: 29/12/2020
 */
package ch.bbw.yr.model.timers;

import ch.bbw.yr.dao.TimerDAO;

public class TimerCollection {
    private GenericTimer darkAuction;
    private GenericTimer bankInterest;
    private EventTimer newYear;
    private EventTimer spookyFestival;
    private EventTimer winterEvent;

    public TimerCollection() {
        TimerDAO timerDAO = new TimerDAO();

        darkAuction = timerDAO.getGenericTimer("darkauction");
        bankInterest = timerDAO.getGenericTimer("bank/interest");
        newYear = timerDAO.getEventTimer("newyear");
        spookyFestival = timerDAO.getEventTimer("spookyFestival");
        winterEvent = timerDAO.getEventTimer("winter");
    }

    public GenericTimer getDarkAuction() {
        return darkAuction;
    }

    public GenericTimer getBankInterest() {
        return bankInterest;
    }

    public EventTimer getNewYear() {
        return newYear;
    }

    public EventTimer getSpookyFestival() {
        return spookyFestival;
    }

    public EventTimer getWinterEvent() {
        return winterEvent;
    }
}
