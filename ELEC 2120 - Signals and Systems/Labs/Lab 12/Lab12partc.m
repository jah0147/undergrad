%Lab 12 part C
%Jacob Howard
%%Sawtooth Wave
clc, syms n x
L = pi; N_TERMS = input('Number of terms: '); n = 1:N_TERMS;
 
% Calculating coefficients of Fourier Series
%tic
a0 = (1/L)*int(x, x, 0, pi);
an = (1/L)*int(x*cos(n*x), x, 0, pi);
bn = (1/L)*int(x*sin(n*x), x, 0, pi);
 
% putting coefficient values in Fourier Series
f = 0;
for n = 1:N_TERMS   
f = f+ (an(n)*cos(n*x) + bn(n)*sin(n*x));
end
%toc
 
fprintf('Approximation using %d terms\n', n)
f_approx = (a0/2)+ f
ezplot(f_approx, [-10,10])
title('Fourier Series Approximation')
xlabel('x')
ylabel('F(x) approximated')
hold on;