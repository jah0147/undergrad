%% Homwork 6 - Sygnals and Systems - Jacob Howard
%% Clearing everything
clc; clear; %clearing command window
close all; %closing all previously opened graphs
%% Setting x(n) and h(n) values
x=[0 -1 -2 -1 0 1 2 1 0 0];%x(n) values
h=[0 0 0 0 1 1 -1 -1 0 0];%h(n) values
%% Ploting convolution of x(n) with h(n)
y=conv(x,h);%convolving x(n) with h(n)
stem([-4:5],x);%plotting x(n) 
title('x(n)');
grid on;
figure()
%%
stem([-4:5],h);%plotting h(n) sequence
title('h(n)');
grid on;
figure()
%% Ploting y(n)
stem([-8:10],y);%plotting y(n) sequence
title('y(n)');
grid on;
%% Printing y(n) value
fprintf('the y(n) sequence is ');
fprintf('[');
disp(y); fprintf(']');
fprintf(']')
%%