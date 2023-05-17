package vehicle;


public abstract class Vehicle 
{
	private double kilometrage;
	private String modelName; 
	private int maxPassengers; 
	private int maxSpeed; 
	
	//type /**parameter c'tor   */
	public Vehicle(String modelName,int maxPassengers,int maxSpeed)
	{
		this.kilometrage=0;
		this.modelName=modelName;
		this.maxPassengers=maxPassengers;
		this.maxSpeed=maxSpeed;
				
	}
	
	
	//type/**get model name*/
	public String getModelName() 
	{
		return modelName;
	}

	public int getMaxPassengers() 
	{
	    return maxPassengers;
	}

	public int getMaxSpeed() 
	{
	    return maxSpeed;
	}

	public double getKilometrage() 
	{
	    return kilometrage;
	}

	public void move(double distance)
	{
	    this.kilometrage+= distance;
	}
	public void resetKilometrage( )
	{
		this.kilometrage=0;
	}
	public abstract String getVehicleName();
	//public abstract String getType();
	
}
