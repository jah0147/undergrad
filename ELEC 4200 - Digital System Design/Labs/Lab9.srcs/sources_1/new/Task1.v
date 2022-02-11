`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/24/2021 07:19:33 PM
// Design Name: 
// Module Name: Task1
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module Task1(multiplicand, multiplier, clk, start, product, done);
input [2:0] multiplicand;
input [2:0] multiplier;
input clk, start;
output reg [5:0] product;
output reg done;
reg SI;
wire SO;
reg [6:0] tmp1;
reg [2:0] tmp2;
integer n = 0;

reg [6:0] acc; 
reg [6:0] Q; 

//Main Code
////////////////////////////////////////////////////
always @ (posedge clk)
//begin
if (start)
begin
acc[5:3] = 3'b000;
acc[2:0] = multiplier;
done = 0;
n = 0;
while (n <= 2) //check if n is to large

begin
if (acc[0] == 1)
begin
//accumulate
acc[6:3] = acc [6:3] + multiplicand;
Q = acc; 
end

//Shift Register
acc = {1'b0, acc[6:1]};
n = n + 1; //adds 1 to n
product = acc[5:0];
end
// Product
//product = acc[5:0];
done = 1;
end

else
begin
//do nothing
end

//end 
endmodule
