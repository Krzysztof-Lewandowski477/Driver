package pl.driver.city;

public enum Region {

    DOLNOSLASKIE("Dolnośląskie"),
    KUJAWSKO_POMORSKIE("Kujawsko-Pomorskie"),
    LUBELSKIE("Lubelskie"),
    LUBUSKIE("Lubuskie"),
    LODZKIE("Łódzkie"),
    MALOPOLSKIE("Małopolskie"),
    MAZOWIECKIE("Mazowieckie"),
    OPOLSKIE("Opolskie"),
    PODKARPACKIE("Podkarpackie"),
    PODLASKIE("Podlaskie"),
    POMORSKIE("Pomorskie"),
    SLĄSKIE("Śląskie"),
    SWIĘTOKRZYSKIE("Świętokrzyskie"),
    WARMINSKO_MAZURSKIE("Warmińsko-Mazurskie"),
    WIELKOPOLSKIE("Wielkopolskie"),
    ZACHODZNIOPOMORSKIE("Zachodniopomorskie");

    private String representation;

    Region(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
