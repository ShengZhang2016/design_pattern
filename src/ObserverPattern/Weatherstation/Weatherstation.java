package ObserverPattern.Weatherstation;

import ObserverPattern.WeatherData.WeatherObservable;
import ObserverPattern.WeatherObservers.CurrentConditionsDisplay;

public class Weatherstation {

    public static void main(String[] args) {
        System.out.println("Hello World From whether station!");

        WeatherObservable weatherObservable = new WeatherObservable();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherObservable);
        CurrentConditionsDisplay currentDisplay2 = new CurrentConditionsDisplay(weatherObservable);

        currentDisplay.subscribe();

        weatherObservable.setParam(10, 65, 30);
        weatherObservable.setParam(11, 63, 33);
        weatherObservable.setParam(14, 75, 38);

        currentDisplay2.unsubscribe(); // throw exception, unable to un-subscribe.

        currentDisplay.unsubscribe();

        weatherObservable.setParam(10, 65, 30);
        weatherObservable.setParam(11, 63, 33);
        weatherObservable.setParam(14, 75, 38);
    }
}
