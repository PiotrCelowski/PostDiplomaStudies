package game;

public enum AgentsEnum {
    RABBIT;

    public Agent getAgent() {
        switch (this) {
            case RABBIT:
                return new Rabbit();
            default:
                return null;
        }
    }
}
