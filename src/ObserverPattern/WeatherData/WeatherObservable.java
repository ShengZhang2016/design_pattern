package ObserverPattern.WeatherData;

import ObserverPattern.WeatherObservers.Observer;

import java.util.HashSet;

public class WeatherObservable implements WeatherSubject {
    private HashSet<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherObservable() {
        this.observers = new HashSet<>();
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }

    public void setParam(float temperature, float humidity, float pressure) {
        if (this.measureChanged(temperature, humidity, pressure)) {
            this.notifyObservers();
        }
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    private boolean measureChanged(float temperature, float humidity, float pressure) {
        return temperature != this.getTemperature() || humidity != this.getHumidity() || pressure != this.getPressure();
    }

    @Override
    public void registerObservers(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObservers(Observer o) throws Exception {
        if (! this.observers.contains(o)) {
            throw new Exception("Unable to unsubscribe. ");
        }
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (this.observers.size() == 0) {
            return;
        }
        for (Observer o: this.observers) {
            this.notifyObserver(o);
        }
    }

    @Override
    public void notifyObserver(Observer o) {
        o.update(this.getTemperature(), this.getHumidity(), this.getPressure());
    }
}
