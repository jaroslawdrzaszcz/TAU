def calculated_triangle(first_side, second_side, third_side):
    if (first_side + second_side > third_side) or (first_side + third_side > second_side) or\
            (second_side + third_side > first_side):
        print("You can build the triangle with given sides.")
    else:
        print("You can't build the triangle with given sides.")


def calculate_quadrangle(first_side, second_side, third_side, fourth_side):
    if max(first_side, second_side, third_side, fourth_side) < (first_side + second_side + third_side + fourth_side -
                                                                max(first_side, second_side, third_side, fourth_side)):
        print("You can build the quadrangle with given sides.")
    else:
        print("You can't build the quadrangle with given sides.")


if __name__ == '__main__':
    try:
        print("Enter float value of sides:")
        a = float(input("First side:"))
        b = float(input("Second side:"))
        c = float(input("Third side:"))
        key = input("If you want to build a triangle, press T, if you want to build a quadrangle, press Q:")
        if key == 'T':
            calculated_triangle(a, b, c)
        elif key == 'Q':
            d = float(input("Fourth side:"))
            calculate_quadrangle(a, b, c, d)
        else:
            print("Something went wrong")
    except ValueError:
        print("You have to enter float value, try again.")
