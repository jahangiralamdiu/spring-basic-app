package jh.springbasicapp.encryptor;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by BS-113-Jahangir on 3/2/2015.
 */
@Component
public class TextEncryptor {

    @Autowired
    private StandardPBEStringEncryptor pbeStringEncryptor;

    @Value("${key.encryptionKey}")
    private String encryptionKey;

    public String encrypt(String textToEncrypt)
    {
        try
        {
            if (!pbeStringEncryptor.isInitialized())
            {
                this.initEncryptor();
            }

            return pbeStringEncryptor.encrypt(textToEncrypt);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }

    public String dycrypt(String textToDycrypt)
    {
        try
        {
            if (!pbeStringEncryptor.isInitialized())
            {
                this.initEncryptor();
            }
            return pbeStringEncryptor.decrypt(textToDycrypt);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }

    }

    public boolean isEqual(String encryptedText, String plainText)
    {
        try
        {
            if (!pbeStringEncryptor.isInitialized())
            {
                this.initEncryptor();
            }
            return this.dycrypt(encryptedText).equals(plainText);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public void initEncryptor()
    {
        if (!pbeStringEncryptor.isInitialized()) {
            pbeStringEncryptor.setPassword(encryptionKey);
            pbeStringEncryptor.setStringOutputType("hexadecimal");
        }
    }
}
