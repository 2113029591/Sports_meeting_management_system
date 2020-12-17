public class Message {
    private String message;
    private int count;

    public Message() {

    }

    public Message(int count, String message) {
        this.message = message;
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
