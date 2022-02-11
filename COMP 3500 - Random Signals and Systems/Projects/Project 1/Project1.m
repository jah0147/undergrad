%%
% Project 1 #4
%Jacob Howard
%Expected Probability of all 4 coins being heads is 6.25%

%%
%#4 Part 1
% setting N to 10,000
N = 10000;
allHeads = 0; % setting number of times all heads appears to 0

% loop N times to count every time all heads appear in 4 coin flips
for i =1:N
coinFlip = randi([0,1],1,4); % randomly generates 4 coin flips (0 being tains and 1 being heads)
if(sum(coinFlip) == 4) % if all heads, allHeads variavle incremented by 1
allHeads = allHeads + 1;
end
end

% Set up a message that calculates and dsiplays the percentage of all 4
% coin tosses being heads
fprintf('Percentage of the time all four coin flips across a row are heads for N = %d is %.2f\n',N,((allHeads*100)/N));

%%
%#4 Part 2
% set N to 100,000
N = 100000;
allHeads = 0; % set number of times all heads appears to 0

% loop N times to count the number of times all heads appear in 4 coin
% flips
for i =1:N
coinFlip = randi([0,1],1,4); % randomly generate 4 coin flips (0-tails, 1-heads)
if(sum(coinFlip) == 4) % if all heads, increment all_heads by 1
allHeads = allHeads + 1;
end
end

% calculate and display the percentage that all four coin flips are heads
fprintf('Percentage of the time all four coin flips across a row are heads for N = %d is %.2f\n',N,((allHeads*100)/N));
%%