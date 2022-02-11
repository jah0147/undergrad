%clears command window
clc; clear;

%Exercises

%Exercise 1
fprintf('Exercise 1 \n') %Prints the exercise number
syms x %setting symbolic variables x and y for equasions
eqn = x^2-5*x+6==0; %Setting up 2 quasions
S = solve(eqn,x); %this will solve for x and y
fprintf('x = (%0.1f and %0.1f)\n', S(1), S(2))


%Exercise 2
fprintf('\nExercise 2 \n') %Prints the exercise number
syms x y z %sets symbolic variables x, y, and z
eqns2 = [2*x+y-2*z==3, x-y-z==0, x+y+3*z==12]; %set 3 equasions using symbolic x,y,&z
S2 = solve(eqns2,[x y z]); %solves for x,y,&z
S2.x; %gives value of x
S2.y; %gives value of y
S2.z; %gives value of z
fprintf('x = (%0.1f)\n', S2.x) %Prints the values
fprintf('y = (%0.1f)\n', S2.y)
fprintf('z = (%0.1f)\n', S2.z)

%Exercise 3
fprintf('\nExercise 3 \n') %Prints the exercise number
syms h k
r = 6.5; % Radius of the circle
x1 = 1; y1 = 4; % Point P1 on the two circles
x2 = 5; y2 = 1; % Point P2 on the two circles
eqns3 = [(x1-h)^2+(y1-k)^2==r^2, (x2-h)^2+(y2-k)^2==r^2]; %setting up the 2 equasions needed
[Ch, Ck] = solve(eqns3); % solving for centers of the circles
fprintf('Center 1(%0.1f, %0.1f)\n',Ch(1),Ch(2)) %Print out the centers
fprintf('Center 2 (%0.1f, %0.1f)\n',Ck(1),Ck(2))

%Exercise 4
fprintf('\nExercise 4 \n') %Prints the exercise number
figure(1)%Creates a window specifically for thsi graph
ezplot('cos(x)', [-4, 4]) %setting up the graphs
hold on
ezplot('x^2-4', [-4, 4])
%graph labels
title('Plot of cos(x) = x^2-4')
xlabel('x')
ylabel('y')
hold off
%setting up and solving for intersections
syms x %setting symbolic variable x
eqn = cos(x) == x^2-4; %setting up equasion
%finding intersections
V1 = vpasolve(eqn, x, [-3 -1]); %finding first solution
V2 = vpasolve(eqn, x, [1 3]); %finding second solution
fprintf('1st Intersection at x = %0.1f\n',V1)
fprintf('2nd Intersection at x = %0.1f\n',V2)

%Exercise 5
fprintf('\nExercise 5 \n') %Prints the exercise number
%cos(x) == sin(x) at 45 degrees and 224 degrees infinitely 
figure(2)%Creates a window specifically for thsi graph
ezplot('sin(x)', [0, 10])
hold on
ezplot('cos(x)', [0, 10])
%graph labels
title('Plot of sin(x) = cos(x)')
xlabel('x')
ylabel('y')
hold off

syms x
eqn5 = cos(x) == sin(x);
V3 = vpasolve(eqn5, x, [0 2]);
V4 = vpasolve(eqn5, x, [3 5]);
V5 = vpasolve(eqn5, x, [6 8]);
fprintf('1st Intersection at x = %0.1f\n',V3)
fprintf('2nd Intersection at x = %0.1f\n',V4)
fprintf('3rd Intersection at x = %0.1f\n',V5)

%Exercise 6
fprintf('\nExercise 6 \n') %Prints the exercise number
%we must design 2 equasions that intersect at 2 different points
figure(3)%Creates a window specifically for thsi graph
ezplot('x^2+1', [-4, 4]) %setting up the graphs
hold on
ezplot('sin(x)+2', [-4, 4])
%graph labels
title('Plot of cos(x) = x^2-4')
xlabel('x')
ylabel('y')
hold off

syms x
eqn5 = sin(x)+2 == x^2+1; %This the the equasion i came up with that intersects and 2 points
V6 = vpasolve(eqn5, x, [-1 0]);
V7 = vpasolve(eqn5, x, [1 2]);
fprintf('1st Intersection at x = %0.1f\n',V6)
fprintf('2nd Intersection at x = %0.1f\n',V7)

%Note you will only see the last graph in the script be plotted
%To get other graphs, comment out the plot commands in all other exercises