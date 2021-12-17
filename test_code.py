import unittest
from code import *


class Testing(unittest.TestCase):
    def test_sum_0(self):
        a = 'some'
        b = 'some'
        self.assertEqual(sum(5, 5),  10)

    def test_sum_1(self):
        a = True
        b = True
        self.assertEqual(sum(10), 20)
        
    def test_diff_1(self):
        self.assertEqual(diff(5), 6)
        
        
    #def test_diff_2(self):
    #    self.assertEqual(diff(6,5), 1)

if __name__ == '__main__':
    unittest.main()
