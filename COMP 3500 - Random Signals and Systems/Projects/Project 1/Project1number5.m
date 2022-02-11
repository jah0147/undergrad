%%
%Project 1 Part 5
%Jacob Howard
%%
%probability of heads
%expected probability of 0.45
trials=100;
p=0;
for i=1:1000

flip=rand(1,trials);
heads=(flip>=0.55);
if (sum(heads)/100)>=0.5
p=p+1;
end
end
percentheads = sum(heads)/trials;
p;
fprintf("Relative frequency of unfair coin landing Heads = %f\n",percentheads);
%%
%Relative frequency of showing as a fair coin
pFair=(p/1000);
p=100*(p/1000);
pFairPercent = pFair * 100;
fprintf("Relative frequency of fair coin showing fair coin RF = %f\n",pFair);
%%
