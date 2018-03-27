public abstract class Card
{
    String name;
    int cost;
    String description;


    protected Card(String name, int cost, String description)
    {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    String getName()
    {
        return name;
    }
    String toStr()
    {
        return "Name: " + name + " Cost: " + cost + " Desc: " + description +"\n";
    }
}
