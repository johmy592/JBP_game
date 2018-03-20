public class MinionCard extends Card
{
    int damage;
    int health;

    public MinionCard(String name, int cost, String description, int damage, int health)
    {
        super(name, cost, description);
        this.damage = damage;
        this.health = health;
    }
}
