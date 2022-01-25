package Car;

public class Car {
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public int getManufactureYear() {
        return manufactureYear;
    }

    private String manufacturer;
    private String model;
    private int manufactureYear = -1;

    public String getStateNumber() {
        return stateNumber;
    }
    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    private String stateNumber;

    public Car(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public Car(String manufacturer, String model, int manufactureYear){
        this(manufacturer, model);
        this.manufactureYear = manufactureYear;
    }
    public Car(String manufacturer, String model, String stateNumber){
        this(manufacturer, model);
        this.stateNumber = stateNumber;
    }
    public Car(String manufacturer, String model, int manufactureYear, String stateNumber){
        this(manufacturer, model, manufactureYear);
        this.stateNumber = stateNumber;
    }
}
