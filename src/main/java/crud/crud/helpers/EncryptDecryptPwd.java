package crud.crud.helpers;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

@Slf4j
public class EncryptDecryptPwd {

    private static final String DB_USERNAME = "product";
    private static final String DB_PWD = "password!234#";

    public static void main(String[] args) {
        encryptKey(DB_USERNAME);
        encryptKey(DB_PWD);
    }

    //encrypt the plan text
    public static String encryptKey(final String plainKey) {
        final SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);
        String encrypted = pbeStringEncryptor.encrypt(plainKey);
        log.info("Encrypted key = {}", encrypted);
        return encrypted;
    }

    //decrypt the encrypted text
    public static void decryptKey(final String encryptedKey) {
        final SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);

        log.info("Decrypted key = {}", pbeStringEncryptor.decrypt(encryptedKey));
    }
}