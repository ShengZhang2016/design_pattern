package ObserverPattern.WeatherObservers;

import ObserverPattern.DisplayUtil.DisplayElement;
import ObserverPattern.WeatherData.WeatherSubject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherSubject weatherData;

    public CurrentConditionsDisplay(WeatherSubject weatherData) {
        this.weatherData = weatherData;
    }

    public void subscribe() {
        this.weatherData.registerObservers(this);
    }

    public void unsubscribe() {
        try {
            this.weatherData.removeObservers(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void display() {
        System.out.println("Current Conditions Display portal: " + this.temperature + "° Celsius. Humidity: " + this.humidity + "%. Pressure: " + this.pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }
}
