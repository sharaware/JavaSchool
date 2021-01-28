public class SpellBannedException extends Exception {
    private int code;
    private String description;

    SpellBannedException(int code, String description, String message) {
        super(message);
        this.code = code;
        this.description = description;
    }

    int getCode() {
        return code;
    }

    String getDescription() {
        return description;
    }
}
