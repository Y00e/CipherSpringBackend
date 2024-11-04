package org.example.chiperspringbackend;

public class Cipher {

    // Fields
    int shift;

    // Constructor
    public Cipher(int shift) {
        this.shift = shift;
    }

    // Method to encrypt a Password
    public String encrypt(String password) {
        // encryption logic
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password cannot contain spaces.");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + shift) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + shift) % 26 + 'A');
            }
            result.append(c);
        }

        return result.toString();
    }

    // Method to decrypt a Password
    public String decrypt(String password) {
        // TODO Implement decryption logic
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' - shift + 26) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' - shift + 26) % 26 + 'A');
            }
            result.append(c);
        }
        return result.toString();
    }
}