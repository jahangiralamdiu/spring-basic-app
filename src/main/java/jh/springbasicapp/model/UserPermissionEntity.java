package jh.springbasicapp.model;

import javax.persistence.*;

/**
 * Created by BS-113-Jahangir on 3/3/2015.
 */
@Entity
@Table(name = "USER_PERMISSION")
public class UserPermissionEntity {

    @Id
    @Column
    @SequenceGenerator(name = "UserPermissionIdGenerator", sequenceName = "USER_PERMISSION__ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserPermissionIdGenerator")
    private int id;

    @Column(name ="USER_ID", nullable = false, length = 10)
    private int userId;

    @Column(name="USER_ROLE_ID", nullable = false, length = 10)
    private int userRoleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}
