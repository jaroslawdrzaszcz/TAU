class QuadTriCalculator:
    def __init__(self, first_side=None, second_side=None, third_side=None, fourth_side=None):
        self.first_side = first_side
        self.second_side = second_side
        self.third_side = third_side
        self.fourth_side = fourth_side

    def calculated_triangle(self):
        if (self.first_side + self.second_side > self.third_side) \
                or (self.first_side + self.third_side > self.second_side) \
                or (self.second_side + self.third_side > self.first_side):
            print("You can build the triangle with given sides.")
        else:
            print("You can't build the triangle with given sides.")

    def calculate_quadrangle(self):
        if max(self.first_side, self.second_side, self.third_side, self.fourth_side) \
                < (self.first_side + self.second_side + self.third_side + self.fourth_side -
                   max(self.first_side, self.second_side, self.third_side, self.fourth_side)):
            print("You can build the quadrangle with given sides.")
        else:
            print("You can't build the quadrangle with given sides.")


if __name__ == '__main__':
    calculator = QuadTriCalculator()

    try:
        print("Enter float value of sides:")
        a = float(input("First side:"))
        b = float(input("Second side:"))
        c = float(input("Third side:"))
        key = input("If you want to build a triangle, press T, if you want to build a quadrangle, press Q:")
        if key == 'T':
            QuadTriCalculator(a, b, c).calculated_triangle()
        elif key == 'Q':
            d = float(input("Fourth side:"))
            QuadTriCalculator(a, b, c, d).calculate_quadrangle()
        else:
            print("Something went wrong")
    except ValueError:
        print("You have to enter float value, try again.")
