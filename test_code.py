import unittest
from code import Func


class Testing(unittest.TestCase):
    def test_sum_0(self):
        a = 'some'
        b = 'some'
        f = Func()
        self.assertEqual(f.sum(5, 5),  10)

    def test_sum_1(self):
        a = True
        b = True
        f = Func()
        self.assertEqual(f.sum(10), 20)
        
#     def test_diff_1(self):
#         f = Func()
#         self.assertEqual(f.diff(5), 5)
        
     
#     def test_diff_2(self):
#         f = Func()
#         self.assertEqual(f.diff(6,5), 1)


if __name__ == '__main__':
    unittest.main()
