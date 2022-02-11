function [z] = pol2recFunction(r, theta)
%   polar to rectangular
theta = deg2rad(theta)
a = r*cosd(theta);
b = r*sind(theta);
z = a+j*b

z = r*exp(j*theta)
end

