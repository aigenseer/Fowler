public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR -> price = new RegularPrice();
            case CHILDRENS -> price = new ChildrensPrice();
            case NEW_RELEASE -> price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle (){
        return title;
    };


    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

}