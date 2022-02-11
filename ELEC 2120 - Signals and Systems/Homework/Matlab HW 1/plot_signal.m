%% What to teach?
%  1. step size in time
%  2. Debugging mode
%  3. Time efficiency 
%  4. 'doc figure'
%  5. Search online 
%  6. continuous-time vs. discrete-time signals


clc;clear;

%% plot the continueous-time signal x(t)
t = 0:.002:3;
x = 5 * r(t,0)- 5 * r(t,2) - 10 * u(t,2);

figure(1);
plot(t,x,'linewidth',2);
set(gca,'FontSize',20);
axis([0,3,-2,12]);
xlabel('t','fontsize',20);
ylabel('x(t)','fontsize',20);
grid on

%% plot the discrete-time signal
t = 0:.2:3;
x = 5 * r(t,0)- 5 * r(t,2) - 10 * u(t,2);

figure(2);
stem(t,x,'linewidth',2);
set(gca,'FontSize',20);
axis([0,3,-2,12]);
xlabel('t','fontsize',20);
ylabel('x(t)','fontsize',20);
grid on
1;
