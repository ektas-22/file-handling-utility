package com.main.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class FileHandlingUtility {

    private static final Path FILE_PATH = Paths.get("example.txt");

    // Ensure file exists before operations
    private static void ensureFileExists() {
        try {
            if (!Files.exists(FILE_PATH)) {
                Files.createFile(FILE_PATH);
                System.out.println("📄 Created new file: " + FILE_PATH.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("❌ Error creating file: " + e.getMessage());
        }
    }

    // Validate user input
    private static boolean isValidInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("⚠️ Input cannot be empty. Please enter valid text.");
            return false;
        }
        return true;
    }

    // Write text to file (append mode)
    public static void writeToFile(String content) {
        ensureFileExists();
        if (!isValidInput(content)) return;

        try {
            Files.write(FILE_PATH, (content + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
            System.out.println("✅ Successfully wrote to file.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Read file contents
    public static void readFromFile() {
        ensureFileExists();
        try {
            List<String> lines = Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8);
            if (lines.isEmpty()) {
                System.out.println("📂 File is empty.");
            } else {
                System.out.println("📖 File Content:");
                lines.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Modify file content (replace oldText with newText)
    public static void modifyFile(String oldText, String newText) {
        ensureFileExists();

        if (!isValidInput(oldText) || !isValidInput(newText)) return;

        try {
            List<String> lines = Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8);
            boolean modified = false;

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(oldText)) {
                    lines.set(i, lines.get(i).replace(oldText, newText));
                    modified = true;
                }
            }

            if (modified) {
                Files.write(FILE_PATH, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("✅ File modified successfully.");
            } else {
                System.out.println("⚠️ No matches found for: " + oldText);
            }

        } catch (IOException e) {
            System.err.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    // Delete file safely
    public static void deleteFile() {
        try {
            if (Files.exists(FILE_PATH)) {
                Files.delete(FILE_PATH);
                System.out.println("🗑️ File deleted successfully.");
            } else {
                System.out.println("⚠️ File does not exist.");
            }
        } catch (IOException e) {
            System.err.println("❌ Error deleting file: " + e.getMessage());
        }
    }

    // Menu-driven interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n==== File Handling Utility ====");
                System.out.println("1. Write to File");
                System.out.println("2. Read from File");
                System.out.println("3. Modify File");
                System.out.println("4. Delete File");
                System.out.println("5. Exit");
                System.out.print("👉 Enter choice (1-5): ");

                String input = scanner.nextLine().trim();
                if (!input.matches("[1-5]")) {
                    System.out.println("⚠️ Invalid choice. Please enter a number between 1 and 5.");
                    continue;
                }

                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter text to write: ");
                        String content = scanner.nextLine();
                        writeToFile(content);
                    }
                    case 2 -> readFromFile();
                    case 3 -> {
                        System.out.print("Enter text to replace: ");
                        String oldText = scanner.nextLine();
                        System.out.print("Enter new text: ");
                        String newText = scanner.nextLine();
                        modifyFile(oldText, newText);
                    }
                    case 4 -> deleteFile();
                    case 5 -> {
                        System.out.println("👋 Exiting program. Goodbye!");
                        scanner.close();
                        return;
                    }
                }

            } catch (Exception e) {
                System.err.println("❌ Unexpected error: " + e.getMessage());
            }
        }
    }
}
