package game;

public enum AgentsEnum {
    RABBIT,
    FOOD;

    public Agent getAgent() {
        switch (this) {
            case RABBIT:
                return new Rabbit();
            case FOOD:
                return new Food();
            default:
                return null;
        }
    }
}
