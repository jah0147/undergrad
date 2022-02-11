%%
%Jacob Howard
%Project 4
clear; clc;
%% Part 1
x = rand(1000000, 1);
n = randn(1000000, 1);
y = 5*x+n;
figure(1)
scatter(x,y)
%% Part 2
xc = [-0.2:0.025:1.2];
yc = [-6.5:0.2:10];
figure(2)
fxy = hist3 ([x,y],{xc yc});
mesh(xc, yc, fxy')
%% Part 4
N = 1000000;
x = rand(N,1); 
n = randn(N,1);     

y = 5*x + n;       
sum = 0;

%loop to find product
for i=1:length(y)     
sum = sum + x(i)*y(i);
end

mean = sum/length(y);

%print expected value
disp("Expected value: ");
disp(mean);
%% Part 5
figure(3)
fx = hist(x,xc);
fy = hist(y,yc);
figure(4)
mesh(xc,yc,fy'*fx)
%%