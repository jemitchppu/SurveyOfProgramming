"""
#CALCULATE AREA OF RECTANGLE
length = int(input("Enter the length of a rectangle: "))
width = int(input("Enter the width of a rectangle: "))
area = length * width
print ("The area of the rectangle is: ", area)"
"""

"""
#IS NUMBER EVEN
number = int(input("Enter a number: "))
if number % 2 == 0:
    print(number, "is even")
else:
    print(number, "is odd")"
"""

"""
#FIND MIN AND MAX
num1 = input("Enter the first number: ")
num2 = input("Enter the second number: ")
num3 = input("Enter the third number: ")

maxValue = max(num1,num2,num3)
minValue = min(num1,num2,num3)
print("The max number is:", maxValue)
print("The min number is:", minValue)
"""

"""
#FACTORIAL
num = int(input("Enter a number: "))
factorial = 1
for i in range(1, num + 1):
    factorial *- i
print("The factorial of", num, "is", factorial)"
"""

#REVERSE A STRING
string = input("Enter a string value: ")

reverseString = string[::-1]
print("Reverse String: ", reverseString)
