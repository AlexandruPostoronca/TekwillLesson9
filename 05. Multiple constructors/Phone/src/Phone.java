class Phone {
    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    // write your code here

    public Phone(String ownerName, String number) {
        this.ownerName = ownerName;
        this.number = number;
    }

    public Phone(String ownerName, String countryCode, String cityCode, String number) {
        this.ownerName = ownerName;
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }
}