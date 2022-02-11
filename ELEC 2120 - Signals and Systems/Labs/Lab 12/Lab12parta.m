%Lab 12 part a
clc; clearvars; close all %CLearing everything

%% Plot fundamental frequency and hear associated sound
t = 0:.1:1000;
y = sin(t);
plot(t,y);
sound(y)

%% Next add the third harmonic to the fundamental, and plot/hear it.
y = sin(t) + sin(3*t)/3;
plot(t,y);
sound(y)

%% Now use the first, third, fifth, seventh, and ninth harmonics.
y = sin(t) + sin(3*t)/3 + sin(5*t)/5 + sin(7*t)/7 + sin(9*t)/9;
plot(t,y);
sound(y)
