package jh.springbasicapp.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 18/02/2015.
 */
@Entity
@Table(name="USER_ACCOUNT")
public class UserEntity {

    @Id
    @Column
    @SequenceGenerator(name = "UserAccountIdGenerator", sequenceName = "USER_ACCOUNT__ID", initialValue = 1, allocationSize =1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserAccountIdGenerator")
    private int id;

    @Column(name = "USER_NAME", nullable = false, length = 35)
    private String userName;

    @Column(name="PASSWORD", length = 100)
    private String password;

    @Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;

    @Column(name = "MOBILE", length = 15)
    private String mobile;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "ADDRESS", length = 300)
    private String address;

    @Column(name="DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name="IMAGE")
    private byte[] imageFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getImageFile() {
        return imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
