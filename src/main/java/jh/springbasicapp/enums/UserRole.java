package jh.springbasicapp.enums;

/**
 * Created by BS-113-Jahangir on 3/3/2015.
 */
public enum UserRole {

    ROLE_ADMIN(1),
    ROLE_USER(2);

    private int code;

    private UserRole(int code) {
        this.code = code;
    }

    public static String getNameByValue(int code) {
        String name = "";

        for (UserRole userRole : UserRole.values()) {
            if (userRole.getCode() == code) {
                name = userRole.name();
                break;
            }
        }
        return name;
    }

    public int getCode() {
        return code;
    }
}
