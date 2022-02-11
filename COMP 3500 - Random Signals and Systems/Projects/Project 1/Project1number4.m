%%
% Project 1 #4
%Jacob Howard
%Expected Probability of all 4 coins being heads is 6.25%

%%
%#4 Part 1
% Setting n to 10,000
n = 10000;
allHeads = 0; % Setting number of times all heads appears to 0

% loop N times to count every time all heads appear in 4 coin flips
for i =1:n
coinFlip = randi([0,1],1,4); % randomly generates 4 coin flips (0 being tains and 1 being heads)
if(sum(coinFlip) == 4) % if all heads, allHeads variable incremented by 1
allHeads = allHeads + 1;
end
end

% Set up a message that calculates and displays the percentage of all 4 
%coin tosses being heads
fprintf('Percentage of all 4 Heads for: Part 1 / n = %d is %.2f\n',n,((allHeads*100)/n));

%%
%#4 Part 2
% Setting n to 100,000
n = 100000;
allHeads = 0; % set number of times all heads appears to 0

% loop N times to count every time all heads appear in 4 coin flips
for i =1:n
coinFlip = randi([0,1],1,4); % randomly generate 4 coin flips (0-tails, 1-heads)
if(sum(coinFlip) == 4) % if all heads, increment all_heads by 1
allHeads = allHeads + 1;
end
end

% Set up a message that calculates and displays the percentage of all 4 
%coin tosses being heads
fprintf('Percentafe of all 4 Heads for: Part 2 / n = %d is %.2f\n',n,((allHeads*100)/n));
%%