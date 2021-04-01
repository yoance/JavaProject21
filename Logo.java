package TypeShootGame;

public class Logo {
public static enum Code{
//kode ato inisial buat tiap gambar
}

/**a String representing the name of the logo given in a specific format (see class' constants).*/
private Code code;

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
}