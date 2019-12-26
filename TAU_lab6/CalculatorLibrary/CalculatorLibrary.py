from test_calculate_triangle_quadrangle import QuadTriCalculator


class CalculatorLibrary:
    def __init__(self, first_side=None, second_side=None, third_side=None, fourth_side=None):
        self.first_side = first_side
        self.second_side = second_side
        self.third_side = third_side
        self.fourth_side = fourth_side
        self._calc = QuadTriCalculator()
        self._result = ''

    def add_side(self, side):
        self._sides = self._calc.add(side)

    def result_should_be(self, expected):
        if self._result != expected:
            raise AssertionError('%s != %s' % (self._result, expected))

    # def should_fail(self, expression):
    #     try:
    #         self.push_buttons(expression)
    #     except CalculationError, err:
    #         return str(err)
    #     else:
    #         raise AssertionError("'%s' should have failed" % expression)