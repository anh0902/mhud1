
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class BangChuDonCode {
     // Tạo bảng chữ cái gốc
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Hàm tạo khóa ngẫu nhiên (xáo trộn bảng chữ cái)
    public static String generateRandomKey() {
        char[] key = ALPHABET.toCharArray();
        Random random = new Random();

        // Xáo trộn mảng ký tự
        for (int i = key.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Đổi chỗ các ký tự
            char temp = key[i];
            key[i] = key[index];
            key[index] = temp;
        }
        return new String(key);
    }

    // Hàm mã hóa văn bản bằng Monoalphabetic Cipher
    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        plainText = plainText.toUpperCase();

        // Lặp qua từng ký tự trong văn bản gốc
        for (char character : plainText.toCharArray()) {
            if (Character.isLetter(character)) {
                int index = ALPHABET.indexOf(character);
                cipherText.append(key.charAt(index)); // Thay bằng ký tự theo khóa
            } else {
                cipherText.append(character); // Giữ nguyên các ký tự không phải chữ
            }
        }

        return cipherText.toString();
    }

    // Hàm giải mã văn bản đã mã hóa
    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();
        cipherText = cipherText.toUpperCase();

        // Lặp qua từng ký tự trong văn bản mã hóa
        for (char character : cipherText.toCharArray()) {
            if (Character.isLetter(character)) {
                int index = key.indexOf(character);
                plainText.append(ALPHABET.charAt(index)); // Thay bằng ký tự gốc từ bảng chữ cái
            } else {
                plainText.append(character);
            }
        }

        return plainText.toString();
    }
}

