%Lab 12 code part b
%Jacob Howard
%% COde 1
% Ideal square wave
t=-10:0.0001:10;
x=0.5*(square(t)+1);
plot(t,x)
hold on;

%% CODE 2
clc, syms n x
L = pi; N_TERMS = input('Number of terms: '); n = 1:N_TERMS;
 
% Calculating coefficients of Fourier Series
tic
a0 = (1/L)*int(1, x, 0, pi);
an = (1/L)*int(1*cos(n*x), x, 0, pi);
bn = (1/L)*int(1*sin(n*x), x, 0, pi);
 
% Plugging coefficient values in Fourier Series
f = 0;
for n = 1:N_TERMS   
f = f+ (an(n)*cos(n*x) + bn(n)*sin(n*x));
end
toc
 
fprintf('Approximation using %d terms\n', n)
f_approx = (a0/2)+ f
ezplot(f_approx, [-10,10])
title('Fourier Series Approximation')
xlabel('x')
ylabel('F(x) approximated')
