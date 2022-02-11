%declaring vvariables
variable1 = 3;
variable2 = 6;

%sum of variable1 and variable2
variableSum = variable1 + variable2

%product of variable1 and variable2
variableProduct = variable1 * variable2

%differance of variable2 and variable1
variableDifferance = variable2 - variable1

%divide variable2 by variable1
variableDivision = variable2 / variable1

%define array 1-10
array1 = [1 2 3 4 5 6 7 8 9 10];

%annother way to define array 1-10
array2 = [1: 2: 3: 4: 5: 6: 7: 8: 9: 10];

%new matrix #11
matrix1 = [1 2; 3 4];

%define a new variable with the eye() command
matrix2 = eye(2)

%sum of matrices
matrixSum = matrix1 + matrix2

%matrix product of matrix1 and matrix2
matrixProduct = matrix1 * matrix2

%matrix to be element-wise product of the variables defined in steps 11 and 12.
matrixEWP = matrix1 .* matrix2

%Define a new variable to be the difference of the first matrix minus the second in steps 11 and 12.
matrixDiference = matrix1 - matrix2

%matrix division of matrix1 and matrix2
matrixDivision = matrix1 * inv(matrix2)

%Name: Jacob Howard