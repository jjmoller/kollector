package models;

public class CardsProduct {
    private String card_id;
    private String card_name;
    private String card_description;
    private double selling_price;
    private String user_id;
    private String rarity;
    private String set;
    private String condition;
    private boolean availability;
    private String brand;

    public CardsProduct(String card_id, String card_name, String card_description, double selling_price, String user_id, String rarity, String set, String condition, boolean availability, String brand) {
        super();

        /* after the '=' the database should display the relevant info */

        this.card_id = card_id;
        this.card_name = card_name;
        this.card_description = card_description;
        this.selling_price = selling_price;
        this.user_id = user_id; // this is data from user class
        this.rarity = rarity;
        this.set = set;
        this.condition = condition;
        this.availability = availability;
        this.brand = brand;
    }

    public String getCardId() { return card_id;}
        public void setCardId(String card_id) {
        this.card_id = card_id;
    }

    public String getCardName() { return card_name;}
        public void setCardName(String card_id) { this.card_name = card_name;}

    public String getCardDescription() { return card_description;}
        public void setCardDescription(String card_description) {this.card_description = card_description;}

    public double getSellingPrice() {return selling_price;}
        public void setSellingPrice(double selling_price) {this.selling_price = selling_price;}

    public String getUserId () { return user_id;}
        public void setUserId( String user_id) {this.user_id = user_id;}

    public String getRarity () {return rarity;}
        public void setRarity (String rarity) {this.rarity = rarity;}

    public String getSet () {return set;}
        public void setSet (String set) {this.set = set;}

    public String getCondition () {return condition;}
        public void setCondition (String condition) {this.condition = condition;}

    public boolean getAvailability () {return availability;}
        public void setAvailability (boolean availability) {this.availability = availability;}

    public String getBrand () {return brand;}
        public void setBrand (String brand) {this.brand = brand;}

}
