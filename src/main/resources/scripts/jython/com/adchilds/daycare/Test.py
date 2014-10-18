import java.lang.System as System

class Test:
    """
    A Simple test class to test that Jython script execution is working.
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
    test = Test()
    test.test_func()