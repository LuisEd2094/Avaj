package simulator.aircraft;


public abstract class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
        this.id = p_id;
        this.name = p_name;
        this. coordinates = p_coordinates;
    }

    public String getName(){return this.name;}
    public String getType(){return this.type;}
    public long getId(){return this.id;}

    protected void unregisterTower(String s)
    {
        weatherTower.unregister(this);
        System.out.printf("%s%n",s);

    }
}
