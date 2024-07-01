import org.example.getNumberFromUser
import org.example.getOperationFromUser
import org.example.performOperation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class TestUtilities {

    @Test
    fun testGetNumberFromUser_ValidInput() {
        val input = "5.0\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val result = getNumberFromUser("Test")
        assertEquals(5.0, result)
    }

    @Test
    fun testGetNumberFromUser_InvalidInput() {
        val input = "invalid\n5.0\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val result = getNumberFromUser("Test")
        assertEquals(5.0, result)
    }

    @Test
    fun testGetOperationFromUser_ValidInput() {
        val input = "+\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val result = getOperationFromUser("Test")
        assertEquals('+', result)
    }

    @Test
    fun testGetOperationFromUser_InvalidInput() {
        val input = "invalid\n+\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val result = getOperationFromUser("Test")
        assertEquals('+', result)
    }

    @Test
    fun testPerformOperation_Addition() {
        val result = performOperation(5.0, 3.0, '+')
        assertEquals(8.0, result)
    }

    @Test
    fun testPerformOperation_Subtraction() {
        val result = performOperation(5.0, 3.0, '-')
        assertEquals(2.0, result)
    }

    @Test
    fun testPerformOperation_Multiplication() {
        val result = performOperation(5.0, 3.0, '*')
        assertEquals(15.0, result)
    }

    @Test
    fun testPerformOperation_Division() {
        val result = performOperation(6.0, 3.0, '/')
        assertEquals(2.0, result)
    }

    @Test
    fun testPerformOperation_DivisionByZero() {
        val exception = assertThrows<ArithmeticException> {
            performOperation(5.0, 0.0, '/')
        }
        assertEquals("Division by zero error", exception.message)
    }
}