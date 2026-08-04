package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class AuthGatewayTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
                "sa",
                ""
        );

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS members");

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS members (
                    member_id INT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    password VARCHAR(100)
                )
            """);

            stmt.execute("""
                INSERT INTO members
                VALUES (1, 'Alice', 'alice@example.com', 'asdasd')
            """);
        }
    }

    @Test
    void testVulnerability() {
        VulnerableAuthGateway authGateway = new VulnerableAuthGateway();

        assertDoesNotThrow(() -> authGateway.authenticateUser("alice@example.com", "asdasd", connection));
    }

    @Test
    void testInjection() {
        VulnerableAuthGateway authGateway = new VulnerableAuthGateway();
        try {
            assertFalse(authGateway.authenticateUser(") OR 1=1 --", "anyPassword", connection));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
