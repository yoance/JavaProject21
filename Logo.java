
public class Logo {

    public static enum Code{
        ABBOTT, ADOBE, AIRWALK, AJINOMOTO, AMAZON, ARENA, ASUS, ATARI, AXA, BAJAJ, BEATS, BILLABONG, 
        BLOGGER, BOSCH, BRAUN, BTS, BUGATTI, CARHARTT, CHRISTIE, CISCO, CLINIQUE, COMPAQ, CROCS, DAIHATSU, 
        DEBIAN, DHL, DIADORA, DOLBY, DREAMWORKS, DUOLINGO, ELECTROLUX, ETIHAD, EVERBEST, FACEBOOK, FEDEX, FUJITSU, 
        GARNIER, GE, GIMP, HERMES, HILTON, HSBC, HUAWEI, HYUNDAI, IBM, IKEA, INDOMIE, ISUZU, ITUNES, JAGUAR, JBL, 
        JUVENTUS, KAWASAKI, KENWOOD, KLM, KODAK, KYB, LAYS, LEICA, LG, LINUX, LOTTO, LUFTHANSA, MASPION, MCAFEE, 
        MENTOS, MICHELIN, MOTOROLA, MSN, NAKAMICHI, NBA, NESCAFE, NICKELODEON, NOVOTEL, NUTELLA, NVIDIA, OLAY, 
        OMEGA, OPEL, OXONE, PANTENE, PEUGEOT, PFIZER, PIONEER, POKEMON, PRINGLES, PUMA, PYTHON, QANTAS, QUAKER,
        RENAULT, ROLEX, RSS, SANYO, SENNHEISER, SHISEIDO, SIEMENS, SKULLCANDY, SNAPCHAT, SPOTIFY, SRIRACHA, 
        STABILO, SUZUKI, TATA, TDK, TESLA, TIMBERLAND, TOBLERONE, TRIPADVISOR, TWITCH, UMBRO, UNILEVER, VANS, 
        VERSACE, VIMEO, VOLVO, WAZE, WHATSAPP, WIKIPEDIA, WORDPRESS, XBOX, XEROX, YELP, YOUTUBE, ZOOM
    }

    /**a String representing the name of the logo given in a specific format (see class' constants).*/
    private Code code;
    private boolean marked = false;

    /**
     * Create a logo with the specified code. Use the
     * {@code enum Code} for the list of codes for the logo.
     * @param code the code containing the name of the logo given in a specific format (use enum).
     */
    public Logo(Code code){
        this.code = code;
    }

    /**
     * Create a logo with the specified name. Use the
     * {@code enum Code} for the list of names for the logo.
     * @param name the name containing the logo name in a specific format (use enum).
     */
    public Logo(String name) {
        this.code = Code.valueOf(name);
    }

    public Code getCode() { return code; }

    public String getName(){ return code.name(); }

    public void setMark(){ marked = true;}

    public boolean getMark(){ return marked;}
}
