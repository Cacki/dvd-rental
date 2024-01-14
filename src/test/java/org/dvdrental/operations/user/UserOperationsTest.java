package org.dvdrental.operations.user;


import org.dvdrental.models.OperationStatus;
import org.dvdrental.models.cache.UserCache;
import org.dvdrental.models.user.UserDTO;
import org.dvdrental.operations.UserOperations;
import org.dvdrental.utils.Utils;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class UserOperationsTest {
    static DateTimeFormatter formatter;
    static String fileName;
    static Path path;
    static UserOperations userOperations;
    static UserCache userCache;

    @BeforeClass
    public static void setUpBeforeTest() {
        formatter = DateTimeFormatter.ofPattern(Utils.DATE_PATTERN);
        fileName = "test_users.csv";
        path = Paths.get(fileName);
    }

    @Before
    public void setUp() throws IOException {
        Files.createFile(path);
        userCache = new UserCache(fileName);
        userOperations = new UserOperations(userCache);
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(path);
        userCache = null;
    }

    @AfterClass
    public static void tearDownAfterTest() {
        formatter = null;
        userOperations = null;
        fileName = null;
        userCache = null;
    }

    @Test
    public void addUser_shouldReturnInvalidData() {
        UserDTO userData = new UserDTO("John", "2Snow", "a-11-1999");

        OperationStatus operationStatus = userOperations.addUser(userData);

        assertEquals(OperationStatus.INVALID_DATA, operationStatus);
    }

    @Test
    public void addUser_shouldReturnSuccess() {
        UserDTO userData = new UserDTO("John", "Snow", "1999-11-11");

        OperationStatus operationStatus = userOperations.addUser(userData);

        assertEquals(OperationStatus.SUCCESS, operationStatus);
    }

    @Test
    public void addUser_shouldReturnUserExist() {
        UserDTO userData = new UserDTO("John", "Snow", "1999-11-11");

        userOperations.addUser(userData);
        OperationStatus operationStatus = userOperations.addUser(userData);

        assertEquals(OperationStatus.USER_EXIST, operationStatus);
    }

}