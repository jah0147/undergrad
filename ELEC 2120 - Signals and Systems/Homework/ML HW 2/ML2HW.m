clear;clc; %Clears command line
t=0:0.0001:10; %time index from 0 to 10 for pulse plots

% part (a)
T1=5; %pulse width
p1=zeros(1,length(t));
p2=p1;
p1(t>=0)=(1-exp(-t(t>=0)./2));
p2(t>=T1)=(1-exp(-(t(t>=T1)-T1)./2));
y1=(1/T1)*(p1-p2);
%Plotting Figure 1
figure(1)
plot(t,y1);
title('Part (a) (Plot for pulse response T=5)');
xlabel('t(sec)');
ylabel('y_{pulse1}(t)');
grid on;

% part (b)
T2=0.05; %pulse width
p3=zeros(1,length(t));
p4=p3;
p3(t>=0)=(1-exp(-t(t>=0)./2));
p4(t>=T2)=(1-exp(-(t(t>=T2)-T2)./2));
y2=(1/T2)*(p3-p4);
%Plotting Figure 2
figure(2)
plot(t,y2);
title('Part (b) (Plot of pulse response T=0.05)');
xlabel('t(sec)');
ylabel('y_{pulse2}(t)');
grid on;

% part (c)
T3=0.01; %pulse width
p5=zeros(1,length(t));
p6=p1;
p5(t>=0)=(1-exp(-t(t>=0)./2));
p6(t>=T3)=(1-exp(-(t(t>=T3)-T3)./2));
y3=(1/T3)*(p5-p6);
%Plotting Figure 3
figure(3)
plot(t,y3);
title('Part (c) (Plot for pulse response T=0.01)');
xlabel('t(sec)');
ylabel('y_{pulse3}(t)');
grid on;