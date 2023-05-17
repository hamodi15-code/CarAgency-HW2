package vehicle;

public class CruiseShip extends MarineVehicle implements Motorized, Commercial {

    private int averageFuel;
    private int averageEngineLife;
    public CruiseShip(String modelName, int maxPassengers, int maxSpeed, String countryFlag, int averageFuel, int averageEngineLife) {
        super(modelName, maxPassengers, maxSpeed, true, countryFlag);
        setAverageFuel(averageFuel);
        setAverageEngineLife(averageEngineLife);
    }

    @Override
    public String getLicenseType() {
        return "UNLIMITED";
    }

    @Override
    public int getAverageFuel() {
        return averageFuel;
    }

    @Override
    public int getAverageEngineLife() {
        return averageEngineLife;
    }

    @Override
    public void setAverageFuel(int fuel) {
        this.averageFuel=fuel;
    }

    @Override
    public void setAverageEngineLife(int life) {
        this.averageEngineLife=life;

    }

    @Override
    public String getVehicleName() {
        return "CruiseShip";
    }

    @Override
    public String toString() {
        return "CruiseShip" +
                "modelName='" + getModelName() + '\'' +
                ", maxPassengers=" + getMaxPassengers() +
                ", maxSpeed=" + getMaxSpeed() +
                ", sailWithWind=" + getSailWithWind() +
                ", countryFlag='" + getCountryFlag() + '\'' +
                ", averageFuel=" + averageFuel +
                ", averageEngineLife=" + averageEngineLife ;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CruiseShip)) {
            return false;
        }
        CruiseShip otherShip = (CruiseShip) other;
        return super.equals(other) && this.averageFuel == otherShip.averageFuel
                && this.averageEngineLife == otherShip.averageEngineLife;
    }


}
