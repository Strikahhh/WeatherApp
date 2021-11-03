package sample.enums;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public enum Country {
    AFGHANISTAN( "AF", "Afghanistan"),
    ALBANIA(  "AL", "Albania"),
    ALGERIA(  "DZ", "Algeria"),
    ANDORRA(  "AD", "Andorra"),
    ANGOLA(  "AO", "Angola"),
    ANGUILLA(  "AI", "Anguilla"),
    ANTIGUA_AND_BARBUDA(  "AG", "Antigua and Barbuda"),
    ARGENTINA(  "AR", "Argentina"),
    ARMENIA(  "AM", "Armenia"),
    ARUBA( "AW", "Aruba"),
    AUSTRALIA(  "AU", "Australia"),
    AUSTRIA(  "AT", "Austria"),
    AZERBAIJAN(  "AZ", "Azerbaijan"),
    BAHAMAS( "BS", "Bahamas"),
    BAHRAIN(  "BH", "Bahrain"),
    BANGLADESH(  "BD", "Bangladesh"),
    BARBADOS( "BB", "Barbados"),
    BELARUS(  "BY", "Belarus"),
    BELGIUM(  "BE", "Belgium"),
    BELIZE(  "BZ", "Belize"),
    BENIN(  "BJ", "Benin"),
    BERMUDA(  "BM", "Bermuda"),
    BHUTAN(  "BT", "Bhutan"),
    BOLIVIA( "BO", "Bolivia"),
    BONAIRE_SAINT_EUSTATIUS_AND_SABA( "BQ", "Bonaire, Saint Eustatius and Saba"),
    BOSNIA_AND_HERZEGOVINA(  "BA", "Bosnia and Herzegovina"),
    BOTSWANA(  "BW", "Botswana"),
    BRAZIL(  "BR", "Brazil"),
    BRITISH_VIRGIN_ISLANDS(  "VG", "British Virgin Islands"),
    BRUNEI_DARUSSALAM(  "BN", "Brunei Darussalam"),
    BULGARIA(  "BG", "Bulgaria"),
    BURKINA_FASO(  "BF", "Burkina Faso"),
    BURUNDI(  "BI", "Burundi"),
    CAMBODIA(  "KH", "Cambodia"),
    CAMEROON(  "CM", "Cameroon"),
    CANADA(  "CA", "Canada"),
    CAPE_VERDE(  "CV", "Cape Verde"),
    CASES_ON_AN_INTERNATIONAL_CONVEYANCE_JAPAN(  "JPG11668",
            "Cases on an international conveyance Japan"),
    CAYMAN_ISLANDS(  "KY", "Cayman Islands"),
    CENTRAL_AFRICAN_REPUBLIC(  "CF", "Central African Republic"),
    CHAD(  "TD", "Chad"),
    CHILE(  "CL", "Chile"),
    CHINA(  "CN", "China"),
    COLOMBIA(  "CO", "Colombia"),
    COMOROS(  "KM", "Comoros"),
    CONGO(  "CG", "Congo"),
    COSTA_RICA(  "CR", "Costa Rica"),
    COTE_DIVOIRE(  "CI", "Côte dIvoire"),
    CROATIA(  "HR", "Croatia"),
    CUBA(  "CU", "Cuba"),
    CURACAO(  "CW", "Curaçao"),
    CYPRUS(  "CY", "Cyprus"),
    CZECHIA(  "CZ", "Czech Republic"),
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO(  "CD", "Democratic Republic of the Congo"),
    DENMARK(  "DK", "Denmark"),
    DJIBOUTI(  "DJ", "Djibouti"),
    DOMINICA(  "DM", "Dominica"),
    DOMINICAN_REPUBLIC(  "DO", "Dominican Republic"),
    ECUADOR(  "EC", "Ecuador"),
    EGYPT(  "EG", "Egypt"),
    EL_SALVADOR(  "SV", "El Salvador"),
    EQUATORIAL_GUINEA(  "GQ", "Equatorial Guinea"),
    ERITREA(  "ER", "Eritrea"),
    ESTONIA(  "EE", "Estonia"),
    ESWATINI(  "SZ", "Eswatini"),
    ETHIOPIA(  "ET", "Ethiopia"),
    FALKLAND_ISLANDS_MALVINAS(  "FK", "Falkland Islands (Malvinas)"),
    FAROE_ISLANDS(  "FO", "Faroe Islands"),
    FIJI(  "FJ", "Fiji"),
    FINLAND(  "FI", "Finland"),
    FRANCE(  "FR", "France"),
    FRENCH_POLYNESIA(  "PF", "French Polynesia"),
    GABON(  "GA", "Gabon"),
    GAMBIA(  "GM", "Gambia"),
    GEORGIA(  "GE", "Georgia"),
    GERMANY(  "DE", "Germany"),
    GHANA(  "GH", "Ghana"),
    GIBRALTAR(  "GI", "Gibraltar"),
    GREECE(  "GR", "Greece"),
    GREENLAND(  "GL", "Greenland"),
    GRENADA( "GD", "Grenada"),
    GUAM(  "GU", "Guam"),
    GUATEMALA(  "GT", "Guatemala"),
    GUERNSEY(  "GG", "Guernsey"),
    GUINEA(  "GN", "Guinea"),
    GUINEA_BISSAU(  "GW", "Guinea Bissau"),
    GUYANA(  "GY", "Guyana"),
    HAITI(  "HT", "Haiti"),
    HOLY_SEE(  "VA", "Holy See"),
    HONDURAS(  "HN", "Honduras"),
    HUNGARY(  "HU", "Hungary"),
    ICELAND(  "IS", "Iceland"),
    INDIA(  "IN", "India"),
    INDONESIA(  "ID", "Indonesia"),
    IRAN(  "IR", "Iran"),
    IRAQ(  "IQ", "Iraq"),
    IRELAND(  "IE", "Ireland"),
    ISLE_OF_MAN(  "IM", "Isle of Man"),
    ISRAEL(  "IL", "Israel"),
    ITALY(  "IT", "Italy"),
    JAMAICA(  "JM", "Jamaica"),
    JAPAN(  "JP", "Japan"),
    JERSEY(  "JE", "Jersey"),
    JORDAN(  "JO", "Jordan"),
    KAZAKHSTAN(  "KZ", "Kazakhstan"),
    KENYA(  "KE", "Kenya"),
    KIRIBATI("KI", "Kiribati"),
    KOSOVO(  "XK", "Kosovo"),
    KUWAIT(  "KW", "Kuwait"),
    KYRGYZSTAN(  "KG", "Kyrgyzstan"),
    LAOS(  "LA", "Laos"),
    LATVIA(  "LV", "Latvia"),
    LEBANON(  "LB", "Lebanon"),
    LESOTHO(  "LS", "Lesotho"),
    LIBERIA(  "LR", "Liberia"),
    LIBYA(  "LY", "Libya"),
    LIECHTENSTEIN(  "LI", "Liechtenstein"),
    LITHUANIA(  "LT", "Lithuania"),
    LUXEMBOURG(  "LU", "Luxembourg"),
    MADAGASCAR(  "MG", "Madagascar"),
    MALAWI(  "MW", "Malawi"),
    MALAYSIA(  "MY", "Malaysia"),
    MALDIVES(  "MV", "Maldives"),
    MALI(  "ML", "Mali"),
    MALTA(  "MT", "Malta"),
    MAURITANIA(  "MR", "Mauritania"),
    MAURITIUS(  "MU", "Mauritius"),
    MEXICO( "MX", "Mexico"),
    MOLDOVA(  "MD", "Moldova"),
    MONACO(  "MC", "Monaco"),
    MONGOLIA(  "MN", "Mongolia"),
    MONTENEGRO(  "ME", "Montenegro"),
    MONTSERRAT(  "MS", "Montserrat"),
    MOROCCO(  "MA", "Morocco"),
    MOZAMBIQUE(  "MZ", "Mozambique"),
    MYANMAR(  "MM", "Myanmar"),
    NAMIBIA(  "NA", "Namibia"),
    NEPAL(  "NP", "Nepal"),
    NETHERLANDS(  "NL", "Netherlands"),
    NEW_CALEDONIA(  "NC", "New Caledonia"),
    NEW_ZEALAND(  "NZ", "New Zealand"),
    NICARAGUA(  "NI", "Nicaragua"),
    NIGER(  "NE", "Niger"),
    NIGERIA(  "NG", "Nigeria"),
    NORTH_MACEDONIA(  "MK", "North Macedonia"),
    NORTHERN_MARIANA_ISLANDS(  "MP", "Northern Mariana Islands"),
    NORWAY(  "NO", "Norway"),
    OMAN(  "OM", "Oman"),
    PAKISTAN(  "PK", "Pakistan"),
    PALESTINE(  "PS", "Palestine"),
    PANAMA(  "PA", "Panama"),
    PAPUA_NEW_GUINEA(  "PG", "Papua New Guinea"),
    PARAGUAY(  "PY", "Paraguay"),
    PERU(  "PE", "Peru"),
    PHILIPPINES(  "PH", "Philippines"),
    POLAND(  "PL", "Poland"),
    PORTUGAL(  "PT", "Portugal"),
    PUERTO_RICO(  "PR", "Puerto Rico"),
    QATAR(  "QA", "Qatar"),
    ROMANIA(  "RO", "Romania"),
    RUSSIA(  "RU", "Russia"),
    RWANDA(  "RW", "Rwanda"),
    SAINT_KITTS_AND_NEVIS(  "KN", "Saint Kitts and Nevis"),
    SAINT_LUCIA(  "LC", "Saint Lucia"),
    SAINT_VINCENT_AND_THE_GRENADINES(  "VC", "Saint Vincent and the Grenadines"),
    SAN_MARINO(  "SM", "San Marino"),
    SAO_TOME_AND_PRINCIPE(  "ST", "Sao Tome and Principe"),
    SAUDI_ARABIA(  "SA", "Saudi Arabia"),
    SENEGAL(  "SN", "Senegal"),
    SERBIA(  "RS", "Serbia"),
    SEYCHELLES(  "SC", "Seychelles"),
    SIERRA_LEONE(  "SL", "Sierra Leone"),
    SINGAPORE(  "SG", "Singapore"),
    SINT_MAARTEN(  "SX", "Sint Maarten"),
    SLOVAKIA(  "SK", "Slovakia"),
    SLOVENIA(  "SI", "Slovenia"),
    SOMALIA(  "SO", "Somalia"),
    SOUTH_AFRICA(  "ZA", "South Africa"),
    SOUTH_KOREA(  "KR", "South Korea"),
    SOUTH_SUDAN(  "SS", "South Sudan"),
    SPAIN( "ES", "Spain"),
    SRI_LANKA( "LK", "Sri Lanka"),
    SUDAN( "SD", "Sudan"),
    SURINAME( "SR", "Suriname"),
    SWEDEN( "SE", "Sweden"),
    SWITZERLAND("CH", "Switzerland"),
    SYRIA( "SY", "Syria"),
    TAIWAN("TW", "Taiwan"),
    TAJIKISTAN( "TJ", "Tajikistan"),
    THAILAND( "TH", "Thailand"),
    TIMOR_LESTE( "TL", "Timor Leste"),
    TOGO( "TG", "Togo"),
    TRINIDAD_AND_TOBAGO( "TT", "Trinidad and Tobago"),
    TUNISIA( "TN", "Tunisia"),
    TURKEY( "TR", "Turkey"),
    TURKS_AND_CAICOS_ISLANDS( "TC", "Turks and Caicos islands"),
    UGANDA( "UG", "Uganda"),
    UKRAINE( "UA", "Ukraine"),
    UNITED_ARAB_EMIRATES( "AE", "United Arab Emirates"),
    UNITED_KINGDOM( "UK", "United Kingdom"),
    GREAT_BRITAIN("GB", "United Kingdom"),
    UNITED_REPUBLIC_OF_TANZANIA( "TZ", "United Republic of Tanzania"),
    UNITED_STATES_OF_AMERICA( "US", "United States"),
    UNITED_STATES_VIRGIN_ISLANDS( "VI", "US Virgin Islands"),
    URUGUAY( "UY", "Uruguay"),
    UZBEKISTAN( "UZ", "Uzbekistan"),
    VENEZUELA( "VE", "Venezuela"),
    VIETNAM( "VN", "Vietnam"),
    WESTERN_SAHARA( "EH", "Western Sahara"),
    YEMEN("YE", "Yemen"),
    ZAMBIA( "ZM", "Zambia"),
    ZIMBABWE( "ZW", "Zimbabwe");
    ;
    private final String id, name;

    Country( String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public static Country getById(String id) {
        return Arrays.stream(values()).filter(country -> country.id.equals(id))
                .findFirst()
                .orElse(null);
    }
}
