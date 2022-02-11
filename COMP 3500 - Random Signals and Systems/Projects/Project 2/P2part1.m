%%
% Jacob Howard
% Project 2
%% Part 1
clc;
clear;
s = RandStream.create('mt19937ar','seed',sum(100*clock));
RandStream.setGlobalStream(s); 

%% Part 2calculate 200 random numbers
x = rand(1, 200);
figure(1)
subplot (3, 2, 1); %part b
hist (x, 10); %10 bin histogram
%% Part 3
y = rand(1, 2000000);
figure(2)
subplot (3, 2, 1) 
hist (y, 10) %bar graph
%% Part 4
z = randn (1,  2000000);
figure(3)
hist (z, 30); %histogram of 30 bins
%% Part 5
a = randn(1, 2000000);
figure(4)
hist (a, 30); %histogram of 30 bins
a = a*3; %multiplying a by 3
figure(5)
hist (a, 30); %histogram of 30 bins
figure(6)
a = a+4;
hist (a, 30); %histogram of 30 bins
%% Part 6
b = rand(1, 2000000, 0); %2 million random variables between 0 and 1
figure(7)
hist (a, 100);
figure(8)
c = sqrt(-2*log(1 - b));
hist (c, 100);