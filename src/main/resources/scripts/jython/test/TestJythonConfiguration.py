import java.lang.System as System

class TestJythonConfiguration:
    """
    A Simple test class to test that Jython script execution/configuration is working.
    """

    def __init__(self):
        return

    def test_func(self):
        """
        A Simple test function.

        :return:
        """
        System.out.println("Testing Jython code execution from Java!")

if __name__ == '__main__':
    test = TestJythonConfiguration()
    test.test_func()