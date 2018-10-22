package com.apollocurrency.aplwallet.apl;

public interface KeyStore {
    /**
     * Return secret bytes if key exists for accountId and can be decrypted by passphrase
     * @param passphrase - string, which consist of random words for keySeed decryption
     * @param accountId - id of account, which keySeed should be decrypted
     * @return decrypted secret bytes with status OK or null with fail status
     */
    SecretBytesDetails getSecretBytes(String passphrase, long accountId);

    /**
     * Save encrypted by passphrase secretBytes to keystore
     * @param passphrase - string, which consist of random words for encryption
     * @param secretBytes - secret array of bytes which will be stored into keystore
     * @return true - if secretBytes were saved successfully, otherwise - false
     */
    boolean saveSecretBytes(String passphrase, byte[] secretBytes);

    /**
     * Remove secret bytes from keystore if secret bytes exist for accountId and can be decrypted by passphrase
     * @param passphrase - string, which consist of random words for secret bytes decryption
     * @param accountId - id of account, which secretBytes should be deleted
     * @return status of deletion
     */
     Status deleteSecretBytes(String passphrase, long accountId);


    enum Status {
        NOT_FOUND,
        DELETE_ERROR,
        DUPLICATE_FOUND,
        BAD_CREDENTIALS,
        READ_ERROR,
        DECRYPTION_ERROR,
        OK
    }
}