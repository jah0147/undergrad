%clears command window before running script
clc; clear;


%Start of problem 1.25(b)

%time start at 0 and ends at 60. 
%I went to 60 to get the best posible look at the graph. 
%Graph curves out at around 45
t=0: .02: 60;

%seting x's value
x1=-10*exp(-.1*t);

%plots the graph of b (linewitdth is the thickness of the line)
figure(1);
plot(t,x1, 'linewidth',1.5)

%setting labs for graph and turning on grid
xlabel('t');ylabel('x(t)')
title('Problem 1.25(b)')
grid on;

%End of problem 1.25(b)

%Start of 1.25(c)

%setting values of t2(time)
t=0: .02: 40;

%setting x2's values
x2 = -10*exp(-.1*t)*u(t,-5);

figure(2);
plot(t,x2, 'linewidth', 2)
set(gca,'FontSize',20);
title('Problem 1.25(c)');
grid on;

%plots the graph of c
%plot(t2,x2, 'linewidth',2)

