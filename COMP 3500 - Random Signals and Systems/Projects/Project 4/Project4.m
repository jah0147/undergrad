%% Project 3
%Jacob Howard
%% Task 1
clc;
clear;
test = xlsread('project4.xlsx');
mean1 = mean(test)
standardDeviation  = std(test)
%% Task 2
n = 51;
mu = 1450;
z = (mean1 - mu)/ (standardDeviation / sqrt(n))
%% Part 3
test2 = [1300 2000 850 400 250]; %5 random people data
mean2 = mean(test2)
u = 650;
n1 = 5;
z1 = (mean2 - u)/ (standardDeviation / sqrt(n1))
%%