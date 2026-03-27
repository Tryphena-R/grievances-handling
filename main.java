import service.ComplaintService;
import ui.AdminMenu;
import ui.UserMenu;

import java.util.Scanner;

/**
 * Application entry point for the Grievance Handling System.
 *
 * <p>Responsibilities:
 * <ul>
 *   <li>Bootstrap the shared service and scanner instances.</li>
 *   <li>Present the top-level role-selection menu.</li>
 *   <li>Delegate to the appropriate role menu (User or Admin).</li>
 * </ul>
 *
 * <p>Architecture overview:
 * <pre>
 *   Main
 *    ├── UserMenu  → ComplaintService → ComplaintRepository → FileHandler
 *    └── AdminMenu → ComplaintService → ComplaintRepository → FileHandler
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        // ── Bootstrap ────────────────────────────────────────────────────────
        Scanner          scanner = new Scanner(System.in);
        ComplaintService service = new ComplaintService();      // single shared instance

        UserMenu  userMenu  = new UserMenu(service, scanner);
        AdminMenu adminMenu = new AdminMenu(service, scanner);

        // ── Banner ───────────────────────────────────────────────────────────
        printBanner();

        // ── Main loop ────────────────────────────────────────────────────────
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt(scanner, "Select role: ");

            switch (choice) {
                case 1 -> userMenu.show();
                case 2 -> adminMenu.show();
                case 0 -> running = false;
                default -> System.out.println("  ⚠ Invalid option. Please enter 0, 1, or 2.");
            }
        }

        // ── Shutdown ─────────────────────────────────────────────────────────
        scanner.close();
        System.out.println("\n  Thank you for using the Grievance Handling System. Goodbye!");
    }

    // ─── Display ──────────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     GRIEVANCE HANDLING SYSTEM  v1.0          ║");
        System.out.println("║     Transparent • Efficient • Accountable    ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("  ┌──────────────────────────┐");
        System.out.println("  │   SELECT YOUR ROLE       │");
        System.out.println("  ├──────────────────────────┤");
        System.out.println("  │  1. User                 │");
        System.out.println("  │  2. Admin                │");
        System.out.println("  │  0. Exit                 │");
        System.out.println("  └──────────────────────────┘");
    }

    // ─── Helper ───────────────────────────────────────────────────────────────

    /** Reads an integer from stdin; returns -1 on non-numeric input. */
    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try { return Integer.parseInt(line); }
        catch (NumberFormatException e) { return -1; }
    }
}
