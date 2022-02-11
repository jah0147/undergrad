`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 09:38:12 PM
// Design Name: 
// Module Name: Task2
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


module Task2(input set, input [3:0] D, input Clk,
input reset, input load, output reg [3:0] Q);
always @(posedge Clk)
if (reset)
begin
Q <= 4'b0;
end 
else if (set)
begin
Q <= 4'b1111;
end
else if (load)
begin
Q <= D;
end
endmodule
