package Java8;

import java.util.Base64;

public class Base64Example {
    //Java 8 introduces Base64 encoding and decoding utilities for encoding binary data (e.g., images)
    // into strings and decoding them back into raw bytes.
    public static void main(String[] args) {
        String original = "Hello World";

        // Encode the string into Base64
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println("Encoded: " + encoded);

        // Decode the Base64 string
        String decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + decoded);

        // Explanation:
        // 1. `getEncoder` encodes raw bytes into Base64 format.
        // 2. `getDecoder` decodes Base64 string back into bytes.
        
        // URL-safe Base64 encoding and decoding
        String urlSafeEncoded = Base64.getUrlEncoder().encodeToString(original.getBytes());
        System.out.println("URL-safe Encoded: " + urlSafeEncoded);
        String urlSafeDecoded = new String(Base64.getUrlDecoder().decode(urlSafeEncoded));
        System.out.println("URL-safe Decoded: " + urlSafeDecoded);
        
        // MIME Base64 encoding and decoding
        String mimeEncoded = Base64.getMimeEncoder().encodeToString(original.getBytes());
        System.out.println("MIME Encoded: " + mimeEncoded);
        String mimeDecoded = new String(Base64.getMimeDecoder().decode(mimeEncoded));
        System.out.println("MIME Decoded: " + mimeDecoded);

        // Custom encoding/decoding with a buffer
        byte[] originalBytes = original.getBytes();

        // Step 1: Correctly size the encoding buffer
        byte[] buffer = new byte[Base64.getEncoder().encode(originalBytes).length];
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        // Step 2: Encode using the appropriately sized buffer
        int encodedLength = encoder.encode(originalBytes, buffer);
        System.out.println("Custom Encoded: " + new String(buffer, 0, encodedLength));

        // Step 3: Correctly size the decoding buffer for the original data length
        byte[] decodedBuffer = new byte[originalBytes.length];

        // Perform decoding with the properly sized decoding buffer
        int decodedLength = decoder.decode(buffer, decodedBuffer);
        System.out.println("Custom Decoded: " + new String(decodedBuffer, 0, decodedLength));
    }
}