package flightbooking;

public class Flight {
    private String flightNo;
    private String from;
    private String to;
    private int price;

    public Flight(String flightNo, String from, String to, int price) {
        this.flightNo = flightNo;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public String getFlightNo() { return flightNo; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return flightNo + " | " + from + " → " + to + " | ₩" + price;
    }
}