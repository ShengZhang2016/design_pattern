package ObserverPattern.WeatherData;

import ObserverPattern.WeatherObservers.Observer;

public interface WeatherSubject {
    /**
     * @param o
     */
    void registerObservers(Observer o);

    /**
     * @param o
     */
    void removeObservers(Observer o) throws Exception;

    /**
     * Notify Observers
     */
    void notifyObservers();

    /**
     * Notify single Observer
     */
    void notifyObserver(Observer o);
}
