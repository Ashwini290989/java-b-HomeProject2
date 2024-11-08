package see.ashwini.advanture.Model;

public abstract class Entity {
    String role;
    int health;
    int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public void punch(Entity topunch) {
        topunch.takeHit(this.damage);

    }

    public void takeHit(int damage) {

        this.health -= damage;
    }

    public boolean isConcious() {
        if (health > 0) {
            return true;
        }
        return false;
    }

        public void addDamage ( int damage){

            this.damage += damage;
        }

    }

