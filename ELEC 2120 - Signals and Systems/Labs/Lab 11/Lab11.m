%Lab 11 Matlab Code
%Jacob Howard

%Copy and paste a section into a new code to run that specific question
%or comment everything but the section you want to run before you run code

%% TF and P&Z
clc; clear all; close all; %CLears the command line and closes any open windows

%Creating H1 graph
H1 = tf([1 3], [1 4 3])
[p1,z1] = pzmap(H1)
figure(1);
subplot(2,1,1)
pzmap(H1);
subplot(2,1,2)
impulse(H1); grid on;

%Creating H2 graph
H2 = tf([1 -7 12], [1 3 1 -5])
[p2,z2] = pzmap(H2)
figure(2);
subplot(2,1,1)
pzmap(H2);
subplot(2,1,2)
impulse(H2); grid on;

%Creating H3 graph
H3 = tf([1 -10 21], [1 3 1 -5 0])
[p3,z3] = pzmap(H3)
figure(3);
subplot(2,1,1)
pzmap(H3);
subplot(2,1,2)
impulse(H3); grid on;

%%3rd Order Stable TF
clc; clear all; close all; %CLosing anything open and clearing command line

%Creating Variables
p1 = -1;
p2 = -2;
p3 = 0;

z1 = 1;
z2 = 2;

syms s

N = expand((s-z1)*(s-z2))
D = expand((s-p1)*(s-p2)*(s-p3))

H = tf([1 -3 2],[1 3 2 0])

%Creating graph
[p,z] = pzmap(H)
subplot(2,1,1)
pzmap(H)
subplot(2,1,2)
impulse(H)


%%3rd Order Asymptotically Stable TF
clc; clear all; close all;

%Creating Variables
p1 = -1;
p2 = -2;
p3 = -3;

z1 = 4;
z2 = 5;

syms s

N = expand((s-z1)*(s-z2))
D = expand((s-p1)*(s-p2)*(s-p3))

%Creating Graph
H = tf([1 -9 20],[1 6 11 6])
[p,z] = pzmap(H)
subplot(2,1,1)
pzmap(H)
subplot(2,1,2)
impulse(H)

%%3rd Order Unstable TF
clc; clear all; close all; %Clears everything

%Creating variables
p1 = -1;
p2 = -2;
p3 = 1;

z1 = 4;
z2 = 5;

syms s

N = expand((s-z1)*(s-z2))
D = expand((s-p1)*(s-p2)*(s-p3))

%Creating graph
H = tf([1 -9 20],[1 2 -1 -2])
[p,z] = pzmap(H)
subplot(2,1,1)
pzmap(H)
subplot(2,1,2)
impulse(H)

%% Step 8 - RLC Circuit 
clc; clearvars; close all;

%Variables
R = 40;
L = 3e-3;
C = 5e-6;

%equasion
H = tf(1/(L*C), [1 R/L 1/(L*C)])

%graph
subplot(3,1,1)
impulse(H)
subplot(3,1,2)
step(H)
[p,z] = pzmap(H)
subplot(3,1,3)
pzmap(H)

%%Step 10 - RLC Circuit 
clc; clearvars; close all; %clearing eveyting

%variables
R = 1;
L = 3e-3;
C = 5e-6;

%equasion 1
H1 = tf(1/(L*C), [1 R/L 1/(L*C)])

%graph 1
figure(1)
subplot(3,1,1)
impulse(H)
subplot(3,1,2)
step(H)
[p,z] = pzmap(H)
subplot(3,1,3)
pzmap(H)


R = 2;

%equasion 2
H2 = tf(1/(L*C), [1 R/L 1/(L*C)])

%graph 2
figure(2)
subplot(3,1,1)
impulse(H)
subplot(3,1,2)
step(H)
[p,z] = pzmap(H)
subplot(3,1,3)
pzmap(H)

R = 3;

%equasion 3
H3 = tf(1/(L*C), [1 R/L 1/(L*C)])

%graph 3
figure(3)
subplot(3,1,1)
impulse(H)
subplot(3,1,2)
step(H)
[p,z] = pzmap(H)
subplot(3,1,3)
pzmap(H)

R = 10;

%equasion 4
H10 = tf(1/(L*C), [1 R/L 1/(L*C)])

%graph 4
figure(4)
subplot(3,1,1)
impulse(H)
subplot(3,1,2)
step(H)
[p,z] = pzmap(H)
subplot(3,1,3)
pzmap(H)

%% Bonus PZ Cancelation
clc; clearvars; close all; %cleaing eveything

H = tf([1 -7 12], [1 1 0 -2])

%graph 1
[p1,z1] = pzmap(H)
figure(1)
subplot(2,1,1)
pzmap(H)
subplot(2,1,2)
impulse(H)

%variables
p1 = -1+1j;
p2 = -1-1j;
p3 = 1+0j;

z1 = 3;
z2 = 4;

syms s;
N = expand((s-z1)*(s-z2))
D = expand((s-p1)*(s-p2))

Hnew = tf([1 -7 12], [1 2 2])

%graph 2
[p2,z2] = pzmap(Hnew)
figure(2)
subplot(2,1,1)
pzmap(Hnew)
subplot(2,1,2)
impulse(Hnew)
